package pe.edu.ulima.circulima_v1.beans

import android.content.ContentValues.TAG
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

    fun printDB() : MutableList<Circulo>{
        val iList: MutableList<Circulo> = mutableListOf()
        dbFirebase.collection("circulos")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data} => ${document.get("nombre")}")
                    val ctemp = Circulo(1, document.get("nombre").toString(), document.get("nombre").toString())
                    iList.add(ctemp)
                    println("AÑADIDO: " + ctemp.ID)
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
        return iList
    }
}