package com.example.tute1application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var res = ArrayList<Int>()
    var excludeNumber = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var results = findViewById<TextView>(R.id.textView)
        var results1 = findViewById<TextView>(R.id.textView1)
        var results2 = findViewById<TextView>(R.id.textView2)
        var results3 = findViewById<TextView>(R.id.textView3)
        var results4 = findViewById<TextView>(R.id.textView4)
        var results5 = findViewById<TextView>(R.id.textView5)
        var warning = findViewById<TextView>(R.id.errorText)

        var button = findViewById<Button>(R.id.bt)

        var butChange = findViewById<Button>(R.id.button1)
        var butChange1 = findViewById<Button>(R.id.button2)
        var butChange2 = findViewById<Button>(R.id.button3)
        var butChange3 = findViewById<Button>(R.id.button4)
        var butChange4 = findViewById<Button>(R.id.button5)
        var butChange5 = findViewById<Button>(R.id.button6)

        var input = findViewById<EditText>(R.id.editTextNumber)

        button.setOnClickListener {
            calculate(results, results1, results2, results3, results4,results5, input, warning)
        }
        butChange.setOnClickListener{
            change(results, 0, warning)
        }
        butChange1.setOnClickListener{
            change(results1, 1, warning)
        }
        butChange2.setOnClickListener{
            change(results2, 2, warning)
        }

        butChange3.setOnClickListener{
            change(results4, 4, warning)
        }
        butChange4.setOnClickListener{
            change(results3, 3, warning)
        }

        butChange5.setOnClickListener{
            change(results5, 5, warning)
        }
    }

    fun calculate(
        results: TextView,
        results1: TextView,
        results2: TextView,
        results3: TextView,
        results4: TextView,
        results5: TextView,
        input: EditText,
        warning: TextView, )
    {

        res.clear()
        var userInput = input.text.toString()

        try {
            excludeNumber = userInput.toInt()
            warning.text = " "
        }
        catch (e: Exception){
            warning.text = "Enter a value"
        }

        var new_number = randomVal()
        while (res.size < 6) {
            if (new_number !in res && new_number != excludeNumber)
                res.add(new_number)
            else
                new_number = randomVal()
        }

        results.setText(res[0].toString())
        results1.setText(res[1].toString())
        results2.setText(res[2].toString())
        results3.setText(res[3].toString())
        results4.setText(res[4].toString())
        results5.setText(res[5].toString())
    }



    fun change(results: TextView, listVal: Int, warning: TextView,) {
        if (res.isEmpty())
        {
            warning.text = ("Generate values first")
        }else{
            var isTrue = false
            var value = randomVal()
            while (!isTrue) {
                if (value !in res && value != excludeNumber) {
                    results.text = value.toString()
                    res[listVal] = value
                    isTrue = true
                }
                else {
                    value = randomVal()
                }
            }
        }
    }

    fun randomVal ():Int{
        var gen: Random = Random()
        var numb = 1 + gen.nextInt(12)
        return numb
    }
}