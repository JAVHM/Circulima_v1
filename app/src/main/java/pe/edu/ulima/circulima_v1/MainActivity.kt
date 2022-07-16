package pe.edu.ulima.circulima_v1


import android.content.Intent.EXTRA_TEXT
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import pe.edu.ulima.circulima_v1.R

class MainActivity : AppCompatActivity(){
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val cod = intent.getIntExtra("EXTRA_CODE", 0)
        val textView2 = findViewById(R.id.textview2) as TextView
        textView2.text = "Codigo: " + cod
    }
}