package com.example.calculatorapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonsOnClick(view: View) {
        when (view.id) {
            R.id.btnZero -> ChangeOperationText("0")
            R.id.btnOne -> ChangeOperationText("1")
            R.id.btnTwo -> ChangeOperationText("2")
            R.id.btnThree -> ChangeOperationText("3")
            R.id.btnFour -> ChangeOperationText("4")
            R.id.btnFive -> ChangeOperationText("5")
            R.id.btnSix -> ChangeOperationText("6")
            R.id.btnSeven -> ChangeOperationText("7")
            R.id.btnEight -> ChangeOperationText("8")
            R.id.btnNine -> ChangeOperationText("9")
            R.id.btnPlus -> ChangeOperationText("+")
            R.id.btnMinus -> ChangeOperationText("-")
            R.id.btnDiv -> ChangeOperationText("÷")
            R.id.btnTimes -> ChangeOperationText("×")
            R.id.btnDot -> ChangeOperationText(".")
            R.id.btnDelete -> ChangeOperationText("clc")
            R.id.btnOpen -> ChangeOperationText("(")
            R.id.btnClose -> ChangeOperationText(")")
            R.id.btnEqual -> Calculate()
            R.id.btnClear -> { edtOperation.setText(""); tvResult.text = "" }
        }
    }
    private fun ChangeOperationText(operation: String) {
        val currentText = edtOperation.text.toString()
        if (operation == "clc" && currentText.isNotEmpty()) edtOperation.setText(
            currentText.substring(
                0,
                currentText.length - 1
            )
        )
        else if (operation != "clc") edtOperation.setText(currentText.plus(operation))
    }
    private fun Calculate() {
        val currentText = edtOperation.text.toString()
            .replace("×", "*")
            .replace("÷", "/")
        val e = Expression(currentText)
        tvResult.text = e.calculate().toString()
    }
}