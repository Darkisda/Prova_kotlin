package tads.eaj.ufrn.minhaprova

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import tads.eaj.ufrn.minhaprova.databinding.ActivityMainBinding
import tads.eaj.ufrn.minhaprova.viewModel.MainActivityModelView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityModelView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityModelView::class.java)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        val settings = getSharedPreferences("prefs_file", Context.MODE_PRIVATE)
        val editor = settings.edit()

        val bemvindo = settings.getBoolean("Bem vindo", true)

        if (bemvindo) {
            Toast.makeText(this, "Bem vindo", Toast.LENGTH_SHORT).show()
            editor.putBoolean("Bem vindo", false).apply()
        }

        binding.apply {

            button1.setOnClickListener {
                var intent = Intent(this@MainActivity, ActivityAcao1::class.java)

                startActivityForResult(intent,1)
            }

            button2.setOnClickListener {
                val dialogo = FragmentoDialogo()
                dialogo.isCancelable = false
                dialogo.show(supportFragmentManager, "Dialog")
            }

            button3.setOnClickListener {
                var intent = Intent(this@MainActivity, ActivityAcao2::class.java)

                startActivityForResult(intent, 2)
            }

            button4.setOnClickListener {
                var intent = Intent(this@MainActivity, ActivityAcao3::class.java)

                startActivity(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            1 -> {
                when(resultCode) {
                    Activity.RESULT_OK -> {
                        binding.apply {
                            text1.text = data?.getStringExtra("resposta").toString()
                            viewModel._text1 = data?.getStringExtra("resposta").toString()
                            invalidateAll()
                        }
                    }
                    Activity.RESULT_CANCELED -> {
                        Snackbar.make(binding.button1, "Atualização Cancelada", Snackbar.LENGTH_SHORT)
                            .setAction("Cancelar") {
                                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
                            }
                            .show()
                    }
                }
            }
            2 -> {
                when(resultCode) {
                    Activity.RESULT_OK -> {
                        binding.apply {
                            text2.text = data?.getStringExtra("resposta2").toString()
                            viewmodel!!._text2 = data?.getStringExtra("resposta2").toString()
                            invalidateAll()
                        }
                    }
                    Activity.RESULT_CANCELED -> {
                        Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}