package pe.edu.ulima.circulima_v1.beans

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

class Circulo {
    var ID: Int
    var NOMBRE : String
    var CARRERA : String

    constructor(ID: Int, NOMBRE: String, CARRERA : String) {
        this.ID = ID
        this.NOMBRE = NOMBRE
        this.CARRERA = CARRERA
    }
}