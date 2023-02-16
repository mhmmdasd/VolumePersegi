package com.example.perhitunganvolumepersegi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var sisi : EditText
    private lateinit var luas : RadioButton
    private lateinit var keliling : RadioButton
    private lateinit var hitung : Button
    private lateinit var hasil : TextView
    private lateinit var simpan : Button

    private lateinit var recyclerView : RecyclerView
    private lateinit var recylerAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager



    private  var rumus : Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sisi = findViewById(R.id.Etsisi)
        luas = findViewById(R.id.rbluas)
        keliling = findViewById(R.id.rbkeliling)
        hitung = findViewById(R.id.btnhitung)
        hasil = findViewById(R.id.tvhasil)
        simpan = findViewById(R.id.simpan)

        recyclerView = findViewById(R.id.listdata)

        val data = mutableListOf<Data>()
        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recylerAdapter = AdapterActivity(data)
        recyclerView.adapter = recylerAdapter
        recyclerView.layoutManager = viewManager

        simpan.setOnClickListener {

            val jawaban = hasil.text.toString()

            val dataSiswa = Data(jawaban)
            data.add(dataSiswa)
            recylerAdapter.notifyDataSetChanged()
        }



        hitung.setOnClickListener {
            var sisi = sisi.text.toString().toInt()

            if (luas.isChecked)
            {
                rumus= (sisi * sisi)
                hasil.setText(rumus.toString())
            }else
            {
                rumus = (sisi * 4)
                hasil.setText(rumus.toString())
            }
        }
    }

    }
