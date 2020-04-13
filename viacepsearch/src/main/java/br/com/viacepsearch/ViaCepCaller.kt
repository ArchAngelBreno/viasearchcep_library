package br.com.viacepsearch

import br.com.viacepsearch.data.entity.ViaSearchCep
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class ViaCepCaller {

    fun getAddress(cep: String): String? = runBlocking {
        withContext(Dispatchers.IO) { callAddress(cep) }?.logradouro
    }

    private fun callAddress(cep: String): ViaSearchCep? {
        val okHttpClient = OkHttpClient.Builder().build()

        val request = Request.Builder()
            .get()
            .url("https://viacep.com.br/ws/$cep/json/")
            .build()
        try {
            val response = okHttpClient.newCall(request).execute()
            if (response.isSuccessful) {
                return GsonBuilder().create()
                    .fromJson(response.body?.string(), ViaSearchCep::class.java)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }
}
