package com.yuba.hitungvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtPanjang :EditText
    private lateinit var edtLebar   :EditText
    private lateinit var edtTinggi  :EditText
    private lateinit var btnHasil   :Button
    private lateinit var tvHasil    :TextView

    companion object{
        private const val STATE_RESULT = "state_Result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        penghubungAtribut()

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvHasil.text =result
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,tvHasil.text.toString())


    }




    private fun penghubungAtribut(){
        edtPanjang =findViewById(R.id.idEdtPanjang)
        edtLebar =findViewById(R.id.idEdtLebar)
        edtTinggi = findViewById(R.id.idEdtTinggi)

        btnHasil =findViewById(R.id.idbtnHitung)
        tvHasil =findViewById(R.id.idTVHasil)
        btnHasil.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id ==R.id.idbtnHitung){
            val inputPanjang = edtPanjang.text.toString().trim()
            val inputLebar =edtLebar.text.toString().trim()
            val inputTinggi = edtTinggi.text.toString().trim()

            var elemenKosong = false

            if (inputPanjang.isEmpty() || inputLebar.isEmpty() || inputTinggi.isEmpty()) {
                elemenKosong = true
                edtPanjang.error ="this field cannot empty !"
                edtLebar.error ="this field cannot empty !"
                edtTinggi.error ="this field cannot empty !"

            }

            if(!elemenKosong){
                val volume = inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()
                tvHasil.text =volume.toString()
            }



        }

    }


}