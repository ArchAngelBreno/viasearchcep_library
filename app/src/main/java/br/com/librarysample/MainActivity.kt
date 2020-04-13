package br.com.librarysample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.viacepsearch.ViaCepCaller
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buscar.setOnClickListener {
            val bairro = ViaCepCaller().getAddress(searchCep.text.toString())
            address.text = "O seu bairro é: $bairro"
        }
    }
}
