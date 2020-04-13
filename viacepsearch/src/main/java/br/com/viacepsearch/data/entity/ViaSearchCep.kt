package br.com.viacepsearch.data.entity


data class ViaSearchCep(
    val bairro: String? = null,
    val cep: String? = null,
    val complemento: String? = null,
    val gia: String? = null,
    val ibge: String? = null,
    val localidade: String? = null,
    val logradouro: String? = null,
    val uf: String? = null,
    val unidade: String? = null
)