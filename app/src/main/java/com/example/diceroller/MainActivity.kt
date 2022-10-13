package com.example.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var iv:ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn=findViewById(R.id.btnroll)
        iv=findViewById(R.id.imgDice)
        btn.setOnClickListener {
           rollDice()
        }
    }

    private fun rollDice(){
       // btn.text="DICE ROLLED"
        val toast=Toast.makeText(this,"DICE ROLLED",Toast.LENGTH_SHORT)
        toast.show()
        val d=Dice(6)
        val drawableResource = when (d.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
         iv.animate().apply {
             duration=500
             //alpha(0f)
             rotationYBy(360f)
             withEndAction{
                 iv.setImageResource(drawableResource)
                 //alpha(1f)
                 //rotationY(360f)
             }.start()
         }

    }
}
class Dice(private val numSides:Int){
    fun roll():Int{
        return (1..numSides).random()
    }
}