package com.example.pepeproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.*
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Spinner에 들어갈 데이터
        var data = listOf("-- 선택하세요 -- ", "선택 항목 1", "선택 항목 2", "선택 항목 3")

        // 데이터와 스피터를 연결 시켜줄 adapter를 만들어 준다.
        // ArrayAdapter의 두번째 인자는 스피너 목록에 아이템을 그려줄 레이아웃을 지정해준다.
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        // activity_main에서 만들어 놓은 spinner에 adapter를 연결해준다.

        var spinner: Spinner = findViewById(R.id.spinner)
        spinner.adapter
        // 데이터가 들어가 있는 spinner에서 선택한 아이템을 가져온다.

        spinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // position은 선택한 아이템의 위치를 넘겨주는 인자다

                var result: TextView = findViewById(R.id.result)

                result.text = data.get(position)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    }

}