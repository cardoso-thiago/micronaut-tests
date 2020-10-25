package br.com.cardoso.controller

import br.com.cardoso.model.CepResponse
import br.com.cardoso.service.CepService
import br.com.cardoso.service.impl.CepServiceImpl
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito.*
import javax.inject.Inject

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CepControllerTest {

    @Inject
    lateinit var embeddedServer: EmbeddedServer
    @Inject
    lateinit var cepService: CepService

    private lateinit var rxHttpClient: RxHttpClient

    @BeforeAll
    fun init() {
        rxHttpClient = RxHttpClient.create(embeddedServer.url)
    }

    @Test
    fun givenValidCepShouldReturnSuccessAndCepData() {
        val cep = "QUALQUER_VALOR_PORQUE_O_RETORNO_SERA_MOCKADO"
        val cepResponse = createCepResponse()
        `when`(cepService.getCepData(anyString())).thenReturn(cepResponse)
        val request = HttpRequest.GET<Any>("/cep/$cep")
        val response = rxHttpClient.toBlocking().exchange(request, CepResponse::class.java)

        assertEquals(cepResponse, response.body())
    }

    @MockBean(CepServiceImpl::class)
    fun cepService(): CepService {
        return mock(CepService::class.java)
    }

    private fun createCepResponse(): CepResponse {
        return CepResponse(
                uf = "MG",
                complemento = null,
                ddd = "31",
                logradouro = "Rua Adelino Teste",
                bairro = "Olhos D'Água",
                localidade = "Belo Horizonte",
                ibge = "3106200",
                siafi = "4123",
                gia = null,
                cep = "30390-070")
    }
}