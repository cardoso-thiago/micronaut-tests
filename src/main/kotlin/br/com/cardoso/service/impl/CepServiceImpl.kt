package br.com.cardoso.service.impl

import br.com.cardoso.model.CepResponse
import br.com.cardoso.service.CepService
import br.com.cardoso.util.WebTarget
import javax.inject.Singleton

@Singleton
class CepServiceImpl(private val webTarget: WebTarget) : CepService {

    override fun getCepData(cep: String): CepResponse {
        val response = webTarget.get("https://viacep.com.br/ws", "/$cep/json/")
        return response.readEntity(CepResponse::class.java)
    }
}