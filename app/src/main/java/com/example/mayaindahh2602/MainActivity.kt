package com.example.mayaindahh2602

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val NamaPembeli = findViewById<EditText>(R.id.txtNamaPembeli)
        val NamaBarang = findViewById<EditText>(R.id.txtNamaBarang)
        val JumlahBeli = findViewById<EditText>(R.id.txtJumlahBeli)
        val Harga = findViewById<EditText>(R.id.txtHarga)
        val UangBayar = findViewById<EditText>(R.id.txtUangBayar)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val TotalBelanja = findViewById<TextView>(R.id.txtTotalBelanja)
        val UangKembalian = findViewById<TextView>(R.id.txtUangKembalian)
        val Bonus = findViewById<TextView>(R.id.txtBonus)
        val Keterangan = findViewById<TextView>(R.id.txtKeterangan)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnProses.setOnClickListener {
            var total: Int = 0
            val JumlahBeli = Integer.parseInt(JumlahBeli.text.toString())
            val  Harga = Integer.parseInt(Harga.text.toString())
            val Bayar = Integer.parseInt(UangBayar.text.toString())

            total = JumlahBeli * Harga
            val kembali = Bayar - total

            TotalBelanja.text = "TotalBelanja:"  +  total.toString()
            UangKembalian.text = "UangKembalian:" + kembali.toString()

            if(Bayar == total) {
                Keterangan.text = "Keterangan: Uang Pas"
            }
            if(Bayar < total) {
                Keterangan.text = "Keterangan: Kurang bayar" + abs(kembali)
            }
            if(Bayar > total) {
                Keterangan.text = "Keterangan: Kembalian" + kembali
            }

            if (total >= 200000) {
                Bonus.text = "Bonus: Mouse"
            }else if (total >= 400000){
                Bonus.text = "Bonus: Keyboard"
            }else if (total >= 600000){
                Bonus.text = "Bonus: Harddisk"
            }else {
                Bonus.text = "Bonus: tidak ada bonus"
            }
        }

        btnReset.setOnClickListener {
            NamaPembeli.setText("")
            NamaBarang.setText("")
            JumlahBeli.setText("")
            Harga.setText("")
            UangBayar.setText("")
            TotalBelanja.setText("Total Belanja")
            UangKembalian.setText("Uang Kembalian")
            Bonus.setText("Bonus")
            Keterangan.setText("Keterangan")
        }
    }
}
