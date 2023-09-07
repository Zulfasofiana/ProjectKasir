package com.example.xiipplg2sofi_kasir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namaPelanggan = findViewById<EditText>(R.id.editNamaPelanggan)
        val namaBarang = findViewById<EditText>(R.id.editNamaBarang)
        val jumlahBeli = findViewById<EditText>(R.id.editJumlahBeli)
        val hargaSatuan = findViewById<EditText>(R.id.editHarga)
        val uangBayar = findViewById<EditText>(R.id.editUangBayar)
        val btnProses = findViewById<Button>(R.id.btnProses)

        val txtHargaTotal = findViewById<TextView>(R.id.txtHargaTotal)
        val txtUangKembali = findViewById<TextView>(R.id.txtUangKembali)
        val txtBonus = findViewById<TextView>(R.id.txtBonus)
        val txtKeterangan = findViewById<TextView>(R.id.txtKeterangan)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnProses.setOnClickListener {
            var hargaBarang = Integer.parseInt(hargaSatuan.text.toString())
            var jumlahBarang = Integer.parseInt(jumlahBeli.text.toString())
            var hargaTotal = hargaBarang * jumlahBarang
            var uangBayar = Integer.parseInt(uangBayar.text.toString())
            var kembalian = uangBayar - hargaTotal

            txtHargaTotal.text = "Harga Total Rp." + hargaTotal
            txtUangKembali.text = "Kembalian: " + if (kembalian<=0) "Tidak Ada" else kembalian

            if(hargaTotal >= 200000) {
                txtBonus.text = "Bonus: Mouse"
            } else if (hargaTotal >= 400000) {
                txtBonus.text = "Bonus: Keyboard"
            } else if (hargaTotal >= 600000) {
                txtBonus.text = "Bonus: Harddisk"
            } else {
                txtBonus.text = "Bonus: Tidak ada"
            }

            if (kembalian == 0) {
                txtKeterangan.text = "Keterangan: Uang pas"
            } else if (kembalian > 0){
                txtKeterangan.text = "Keterangan: Menunggu Kembalian"
            } else {
                txtKeterangan.text = "Keterangan: Uang Kurang" + abs(kembalian)
            }
        }

        btnReset.setOnClickListener {
            namaPelanggan.setText("")
            namaBarang.setText("")
            jumlahBeli.setText("")
            hargaSatuan.setText("")
            uangBayar.setText("")
            txtHargaTotal.text = "Harga Total:"
            txtUangKembali.text = "Kembalian:"
            txtBonus.text = "Bonus:"
            txtKeterangan.text = "Keterangan:"
        }
    }
}
