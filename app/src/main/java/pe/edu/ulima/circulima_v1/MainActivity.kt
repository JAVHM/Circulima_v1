package pe.edu.ulima.circulima_v1


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val cod = intent.getIntExtra("EXTRA_CODE", 0)
        val textView2 = findViewById(R.id.textview2) as TextView
        textView2.text = "Codigo: " + cod
    }
}