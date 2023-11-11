package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.calculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.input
import kotlinx.android.synthetic.main.activity_main.output
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //name func
        var name = intent.getStringExtra("m")

        binding.theName.setText("Hello ,$name")

        //number pad binding

        binding.buttonClear.setOnClickListener{
            input.text = ""
            output.text = ""
        }
        binding.buttonBracketLeft.setOnClickListener{
            input.text= addToInputText("(")
        }
        binding.buttonBracketRight.setOnClickListener{
            input.text= addToInputText(")")
        }
        binding.button0.setOnClickListener{
            input.text= addToInputText("0")
        }
        binding.button1.setOnClickListener{
            input.text= addToInputText("1")
        }
        binding.button2.setOnClickListener{
            input.text= addToInputText("2")
        }
        binding.button3.setOnClickListener{
            input.text= addToInputText("3")
        }
        binding.button4.setOnClickListener{
            input.text= addToInputText("4")
        }
        binding.button5.setOnClickListener{
            input.text= addToInputText("5")
        }
        binding.button6.setOnClickListener{
            input.text= addToInputText("6")
        }
        binding.button7.setOnClickListener{
            input.text= addToInputText("7")
        }
        binding.button8.setOnClickListener{
            input.text= addToInputText("8")
        }
        binding.button9.setOnClickListener{
            input.text= addToInputText("9")
        }
        binding.buttonDot.setOnClickListener{
            input.text= addToInputText(".")
        }
        binding.division.setOnClickListener{
            input.text= addToInputText("÷")
        }
        binding.buttonMultiply.setOnClickListener{
            input.text= addToInputText("×")
        }
        binding.buttonAddition.setOnClickListener{
            input.text= addToInputText("+")
        }
        binding.buttonSubtraction.setOnClickListener{
            input.text= addToInputText("-")
        }
        binding.buttonEquals.setOnClickListener{
            showResult()
        }


    }
    private fun addToInputText(buttonValue: String):String {
        return "${input.text}$buttonValue"
    }
    //function for divid and multiply
    private fun getInputExpression():String{
        var expression = input.text.replace(Regex("÷"),"/")
        expression = expression.replace(Regex("×"),"*")
        return expression
    }

    //calculator function logic
    private fun showResult(){
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()){
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this ,R.color.red))
            }else{
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this ,R.color.green))
            }
        }catch (e: Exception){
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this ,R.color.red))
        }
    }
}