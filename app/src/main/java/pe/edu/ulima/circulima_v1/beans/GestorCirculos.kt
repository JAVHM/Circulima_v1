package pe.edu.ulima.circulima_v1.beans

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class GestorCirculos {
    val dbFirebase = Firebase.firestore

    companion object{
        private var instance : GestorCirculos? = null

        fun getInstance() : GestorCirculos{
            if (instance == null){
                instance = GestorCirculos()
            }
            return instance!!
        }
    }

    fun printDB(){
        println("printDB()")
        val circuloCol = dbFirebase.collection("circulos")
        println(circuloCol)
        println(circuloCol.document("sEymwexhmqdBUWLbMV1t"))
        val doc =  circuloCol.document("sEymwexhmqdBUWLbMV1t")
            .get().addOnSuccessListener {
                Log.i("GestorCirculos", it.data!!["nombre"].toString())
                Log.i("GestorCirculos", it.data!!["descripcion"].toString())
                println("IDENTIFICADOR" + it.data!!["nombre"].toString())
            }
        println("doc.isSuccessful: " +  doc.isSuccessful)
    }
    fun  prueba(){
        println("PRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBA")
    }
}