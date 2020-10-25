package br.com.cardoso.service

import br.com.cardoso.model.CepResponse

interface CepService {

    fun getCepData(cep:String): CepResponse
}