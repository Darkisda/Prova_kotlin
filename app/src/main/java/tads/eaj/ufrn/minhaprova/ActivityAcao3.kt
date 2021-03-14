package tads.eaj.ufrn.minhaprova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.minhaprova.databinding.ActivityAcao3Binding
import tads.eaj.ufrn.minhaprova.db.LivroDBOpenner

class ActivityAcao3 : AppCompatActivity() {

    lateinit var binding: ActivityAcao3Binding
    lateinit var bd: LivroDBOpenner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bd = LivroDBOpenner(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_acao3)

        var livros = bd.findAll()
        var id = 1

        binding.apply {
            var l = bd.read(id)

            titulo.text = l.nome
            autor.text = l.autor
            ano.text = l.ano.toString()
            nota.text = l.nota.toString()

            buttonProximo.setOnClickListener {
                if (id == livros.size) {
                    buttonProximo.isEnabled = false
                }else{
                    id ++

                    var l = bd.read(id)

                    titulo.text = l.nome
                    autor.text = l.autor
                    ano.text = l.ano.toString()
                    nota.text = l.nota.toString()

                    buttonProximo.isEnabled = true
                    buttonAnterior.isEnabled = true
                }
            }
            buttonAnterior.setOnClickListener {
                if (id == 1) {
                    buttonAnterior.isEnabled = false
                } else {
                    id --

                    var l = bd.read(id)

                    titulo.text = l.nome
                    autor.text = l.autor
                    ano.text = l.ano.toString()
                    nota.text = l.nota.toString()

                    buttonAnterior.isEnabled = true
                    buttonProximo.isEnabled = true
                }
            }
        }
    }
}