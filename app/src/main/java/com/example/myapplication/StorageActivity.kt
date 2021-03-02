package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_storage.*
import java.io.*


class StorageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)

        loadBtn.setOnClickListener {
            val stream: InputStream = this.openFileInput("data.txt")
            val inputStreamReader = InputStreamReader(stream)
            textBox.text = Editable.Factory.getInstance().newEditable(inputStreamReader.readText())
            stream.close()
        }

        saveBtn.setOnClickListener {
            val text = textBox.text.toString()
            val outputStreamWriter = OutputStreamWriter(this.openFileOutput("data.txt", Context.MODE_PRIVATE))
            outputStreamWriter.write(text)
            outputStreamWriter.close()
        }
    }
}