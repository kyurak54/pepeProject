package com.example.pepeproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pepeproject.databinding.ActivityLoanlistBinding
import com.example.pepeproject.databinding.ActivityMainBinding

class LoanActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoanlistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoanlistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val annSalary = intent.getIntExtra("pay", 0)

        if (annSalary == 0 || annSalary == null) {
            binding.message.text = "연봉값 에러"
        } else {
            getLoanList(annSalary)
            binding.message.text = annSalary.toString()
        }
    }

    fun getLoanList(paramAnnSalary: Int) {
        val list1: List<String> = listOf("1500", "이름1", "범위1~범위1")
        val list2: List<String> = listOf("2500", "이름2", "범위2~범위2")
        val list3: List<String> = listOf("3500", "이름3", "범위3~범위3")
        val list4: List<String> = listOf("4500", "이름4", "범위4~범위4")
        val list5: List<String> = listOf("5500", "이름5", "범위5~범위5")

        val listBox = mutableListOf<List<String>>()
        listBox.add(list1)
        listBox.add(list2)
        listBox.add(list3)
        listBox.add(list4)
        listBox.add(list5)

        val matchBox = mutableListOf<List<String>>()
        for (list in listBox) {
            if(Integer.parseInt(list[0]) >= paramAnnSalary) {
                matchBox.add(list)
            }
        }
    }
}