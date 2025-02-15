package co.edu.uan.demo0214

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var numberLeft = 0
    var numberRight = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)
        generateRandomNumbers()

        btnLeft.setOnClickListener {
            if(numberLeft > numberRight) {
                // Winner
                Toast.makeText(this, "Winner", Toast.LENGTH_SHORT).show()
            } else {
                // Loser
                Toast.makeText(this, "Loser", Toast.LENGTH_SHORT).show()
            }
            println("Left: $numberLeft, Right: $numberRight")
            generateRandomNumbers()
        }
        btnRight.setOnClickListener {
            if(numberLeft < numberRight) {
                // Winner
                Toast.makeText(this, "Winner", Toast.LENGTH_LONG).show()
            } else {
                // Loser
                Toast.makeText(this, "Loser", Toast.LENGTH_SHORT).show()
            }
            println("Left: $numberLeft, Right: $numberRight")
            generateRandomNumbers()
        }


    }

    fun generateRandomNumbers() {
        numberLeft = (0..100).random()
        numberRight = (0..100).random()
        if(numberLeft == numberRight) {
            generateRandomNumbers()
        }
    }
}