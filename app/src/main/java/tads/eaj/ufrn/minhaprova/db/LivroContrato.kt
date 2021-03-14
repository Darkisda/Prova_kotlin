package tads.eaj.ufrn.minhaprova.db

import android.provider.BaseColumns

object LivroContrato {
    const val DATABASE_NAME = "livrodb.sqlite"
    const val DATABASE_VERSION = 1

    object LivroEntry: BaseColumns {
        const val TABLE_NAME = "livro"
        const val NOME = "nome"
        const val AUTOR = "autor"
        const val ANO = "ano"
        const val NOTA = "nota"
    }
}