package tads.eaj.ufrn.minhaprova

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class FragmentoDialogo : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            builder.setMessage("Gostaria de uma xícara de café?")
                    .setTitle("Pergunta importante")
                    .setPositiveButton("Sim",
                        DialogInterface.OnClickListener { dialog, id ->
                            Toast.makeText(it.baseContext, "Ótimo", Toast.LENGTH_SHORT).show()
                        }
                            )
                    .setNegativeButton("Não",
                        DialogInterface.OnClickListener { dialog, id ->
                            Toast.makeText(it.baseContext, "Fica pra próxima", Toast.LENGTH_SHORT).show()
                        }
                            )
            builder.create()
        } ?: throw  IllegalStateException("Activity cannot be null")
    }
}