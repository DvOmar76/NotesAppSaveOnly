package com.example.notesappsaveonly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notesappsaveonly.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val note =binding.edNote.text.toString()
            val dbHelper=DBHelper(applicationContext)
            val status=dbHelper.saveNote(note)
            if (status!=-1L) Toast.makeText(applicationContext, "Note added", Toast.LENGTH_SHORT).show()
        }
    }
}