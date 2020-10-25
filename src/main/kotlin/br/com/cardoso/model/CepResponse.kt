package br.com.cardoso.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CepResponse(

	@field:JsonProperty("uf")
	val uf: String? = null,

	@field:JsonProperty("complemento")
	val complemento: String? = null,

	@field:JsonProperty("ddd")
	val ddd: String? = null,

	@field:JsonProperty("logradouro")
	val logradouro: String? = null,

	@field:JsonProperty("bairro")
	val bairro: String? = null,

	@field:JsonProperty("localidade")
	val localidade: String? = null,

	@field:JsonProperty("ibge")
	val ibge: String? = null,

	@field:JsonProperty("siafi")
	val siafi: String? = null,

	@field:JsonProperty("gia")
	val gia: String? = null,

	@field:JsonProperty("cep")
	val cep: String? = null
)
