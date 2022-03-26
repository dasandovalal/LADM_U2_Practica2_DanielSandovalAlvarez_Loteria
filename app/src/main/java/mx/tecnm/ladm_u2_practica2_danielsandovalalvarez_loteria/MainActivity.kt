package mx.tecnm.ladm_u2_practica2_danielsandovalalvarez_loteria

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import mx.tecnm.ladm_u2_practica2_danielsandovalalvarez_loteria.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loteria = Loteria(binding.imagen,this,binding.btnIniciar,binding.btnPendientes,binding.btnNuevoJuego)
        binding.btnPendientes.visibility = View.INVISIBLE
        binding.btnNuevoJuego.visibility = View.INVISIBLE

        binding.btnIniciar.setOnClickListener {
            try {
                loteria.start()
            }catch (e:Exception){
                loteria.loteria()
                binding.texto.text = "¡¡¡LOTERIA!!!"
                binding.btnPendientes.visibility = View.VISIBLE
            }
        }

        binding.btnPendientes.setOnClickListener {
            loteria.restantes()
        }

        binding.btnNuevoJuego.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
            finishAffinity()
        }


    }

}
