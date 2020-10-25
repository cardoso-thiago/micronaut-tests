package br.com.cardoso.service

import br.com.cardoso.model.CepResponse
import br.com.cardoso.util.WebTarget
import br.com.cardoso.util.impl.WebTargetImpl
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import javax.inject.Inject
import javax.ws.rs.core.Response

@MicronautTest
class CepServiceTest {

    @Inject
    lateinit var cepService: CepService

    @Inject
    lateinit var webTarget: WebTarget

    @Test
    fun givenValidCepShouldReturnSuccessAndCepData() {
        val cep = "QUALQUER_VALOR_PORQUE_O_RETORNO_SERA_MOCKADO"
        val cepResponse = createCepResponse()

        val mockResponse = mock(Response::class.java)
        `when`(mockResponse.readEntity(CepResponse::class.java)).thenReturn(cepResponse)
        `when`(webTarget.get(anyString(), anyString())).thenReturn(mockResponse)
        val serviceResponse = cepService.getCepData(cep)

        Assertions.assertEquals(cepResponse, serviceResponse)
    }

    @MockBean(WebTargetImpl::class)
    fun webTarget(): WebTarget {
        return mock(WebTarget::class.java)
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