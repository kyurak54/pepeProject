package com.example.pepeproject

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pepeproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val itemList = listOf("----선택사항------", "선택 1번", "선택 2번", "선택 3번")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                if(p2 != 0) Toast.makeText(this@MainActivity, itemList[p2], Toast.LENGTH_SHORT).show()
                if(p2 == 2) {
                    binding.textViewId.setVisibility(View.VISIBLE)
                } else {
                    binding.textViewId.setVisibility(View.INVISIBLE)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


    }

}