package br.senai.sp.jandira.triproom.repository

import android.content.Context
import br.senai.sp.jandira.triproom.dao.TripDb
import br.senai.sp.jandira.triproom.model.User

class UserRepository(context: Context) {

    //variavel que representa o banco de dados

    private val db = TripDb.getDataBase(context)
    // função responsável por inserir um usuario no banco
    fun save(user: User): Long{
        return db.userDao().save(user)
    }

    // função responsável por consultar um usuário do banco
    fun findUserByEmail(email :String): User{
        return db.userDao().findUserByEmail(email)
    }

    fun authenticate(email: String, password: String): User{
        return db.userDao().authenticate(email, password)
    }
}