package com.example.crudrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var inputNIS: EditText
    private lateinit var inputNama: EditText
    private lateinit var jkLakiLaki: RadioButton
    private lateinit var jkperempuan: RadioButton
    private lateinit var btnTambah:Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNIS = findViewById(R.id.txtInputNIS)
        inputNama = findViewById(R.id.txtInputNama)
        jkLakiLaki = findViewById(R.id.radioButton3)
        jkperempuan = findViewById(R.id.radioButton5)
        btnTambah= findViewById(R.id.btnTambah)
        recyclerView= findViewById(R.id.Listdata)
        //membuat variabel kosong tipe array mutablelist untuk simpan data array
        //data array disimpan di data class Siswadata
        val data = mutableListOf<SiswaData>()
        viewManager = LinearLayoutManager(this)
        recyclerAdapter = SiswaAdapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager
        //setOnClickListener untuk tombol tambah data
        btnTambah.setOnClickListener{
            //1.membuat variabel penyimpan data
            val nis = inputNIS.text.toString()
            val nama = inputNama.text.toString()
            var jk = ""
            if (jkLakiLaki.isChecked){
                jk = "Laki-Laki"
            }else{
                jk = "perempuan"
            }
            //simpan data ke array mutablelist
            val dataSiswa = SiswaData(nis,nama,jk)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }

    }
}