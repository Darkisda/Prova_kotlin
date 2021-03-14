package tads.eaj.ufrn.minhaprova

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.minhaprova.databinding.ActivityAcao2Binding
import tads.eaj.ufrn.minhaprova.db.LivroDBOpenner
import tads.eaj.ufrn.minhaprova.models.Livro

class ActivityAcao2 : AppCompatActivity() {

    lateinit var binding: ActivityAcao2Binding
    lateinit var db: LivroDBOpenner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_acao2)
        db = LivroDBOpenner(this)

        var livro = Livro()

        binding.apply {

            saveButton.setOnClickListener {
                if (tituloInput.text.isNotBlank()) {
                    livro.nome = tituloInput.text.toString()
                } else {
                    Toast.makeText(this@ActivityAcao2, "Por favor preencha com um título", Toast.LENGTH_SHORT).show()
                }

                if (autorInput.text.isNotBlank()) {
                    livro.autor = autorInput.text.toString()
                } else {
                    Toast.makeText(this@ActivityAcao2, "Por favor preencha com um autor", Toast.LENGTH_SHORT).show()
                }

                if (anoInput.text.toString().isNotBlank()) {
                    livro.ano = anoInput.text.toString().toInt()
                } else {
                    Toast.makeText(this@ActivityAcao2, "Por favor preencha com um ano", Toast.LENGTH_SHORT).show()
                }

                livro.nota = notaInput.rating

                db.create(livro)

                var intent = Intent()
                intent.putExtra("resposta2", "Cadastrado")
                setResult(Activity.RESULT_OK, intent)
                finish()
            }

            cancelButton.setOnClickListener {
                setResult(Activity.RESULT_CANCELED)
                finish()
            }
        }
    }
}