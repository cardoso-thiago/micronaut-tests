package br.com.cardoso.controller

import br.com.cardoso.model.CepResponse
import br.com.cardoso.service.CepService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class CepController(private val cepService: CepService) {

    @Get("/cep/{cep}")
    fun getCepData(cep: String): HttpResponse<CepResponse> {
        return HttpResponse.ok(cepService.getCepData(cep))
    }
}