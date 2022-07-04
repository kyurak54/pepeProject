package com.example.pepeproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
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

        binding.spinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                // 토스트 메세지 표시
                /*if(p2 != 0) Toast.makeText(this@MainActivity, itemList[p2], Toast.LENGTH_SHORT).show()*/
                
                // 문자열 표시/비표시
                if(p2 == 2) {
                    binding.annualSal.setVisibility(View.VISIBLE)
                } else {
                    binding.annualSal.setVisibility(View.INVISIBLE)
                }
            }

            /* 1. 중소기업 취업 청년 전세자금 대출
                만 19세 ~ 만 34세
                부부합산 연소득 5000이하

                2. 청년전용 버팀목 전세자금 대출
                만 19세 ~ 만 34세
                주택임차보증금 7000이하
            */

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        binding.confirm.setOnClickListener() {
            val intent = Intent(this, LoanActivity::class.java)

            val pay = Integer.parseInt(binding.annualSal.text.toString());
            intent.putExtra("pay", pay)
            startActivity(intent)
        }
    }


}