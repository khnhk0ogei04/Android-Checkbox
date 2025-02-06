package com.example.checkboxkotlin62

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.checkboxkotlin62.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        addEvents();
    }

    private fun addEvents(){
        binding.btnChonSoThich.setOnClickListener{
            xuLyChonSoThich();
        }
        binding.btnConfirm.setOnClickListener{
            xuLyXacNhan();
        }
    }

    private fun xuLyXacNhan(){
        var s: String = "";
        if (binding.radNam.isChecked){
            s = binding.radNam.text.toString();
        } else if (binding.radNu.isChecked){
            s = binding.radNu.text.toString();
        }
        if (s == ""){
            Toast.makeText(
                this,
                "Ban chua chon gioi tinh, vui long click",
                Toast.LENGTH_LONG
            ).show();
        } else {
            Toast.makeText(
                this,
                "Ban chon gioi tinh: " + s,
                Toast.LENGTH_LONG
            ).show();
        }
    }

    private fun xuLyChonSoThich(){
        var s = ""

        if (binding.chkNgheNhac.isChecked) {
            s += binding.chkNgheNhac.text.toString() + "\n"
        }
        if (binding.chkShopping.isChecked) {
            s += binding.chkShopping.text.toString() + "\n"
        }
        if (binding.chkDuLich.isChecked) {
            s += binding.chkDuLich.text.toString() + "\n"
        }
        if (binding.chkXemPhim.isChecked) {
            s += binding.chkXemPhim.text.toString() + "\n"
        }
        if (binding.chkChoiTheThao.isChecked) {
            s += binding.chkChoiTheThao.text.toString() + "\n"
        }

        if (s.isEmpty()) {
            s = "Bạn chưa chọn sở thích nào!"
        }
        binding.edtSoThich.setText(s)
    }
}