package tads.eaj.ufrn.minhaprova

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.minhaprova.databinding.ActivityAcao1Binding

class ActivityAcao1 : AppCompatActivity() {
    lateinit var binding: ActivityAcao1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_acao1)

        binding.apply {
            buttonOK.setOnClickListener {
                if(!editText.text.isBlank()) {
                    val intent = Intent()
                    intent.putExtra("resposta", editText.text.toString())
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                } else {
                    Toast.makeText(this@ActivityAcao1, "Informe um texto válido", Toast.LENGTH_SHORT).show()
                }
            }
            buttonCancelar.setOnClickListener {
                setResult(Activity.RESULT_CANCELED)
                finish()
            }
        }
    }
}