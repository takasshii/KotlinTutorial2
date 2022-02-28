package com.example.aboutme

import android.content.Context

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager

import com.example.aboutme.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  val myName: MyName = MyName("Aleks Haecky")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.myName = myName
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //ボタンが押されたときに
        binding.doneButton.setOnClickListener{
            //it→parentの親
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {

        binding.apply {
            //EditはEditableなので、String型に変更する必要がある。
            myName?.nickname = nicknameEdit.text.toString()
            //nicknameが変更されたら更新する
            invalidateAll()

            //入力したテキストを非表示に
            binding.nicknameEdit.visibility = View.GONE
            //ボタンを非表示に
            binding.doneButton.visibility = View.GONE
            //ニックネーム表示を表示する
            binding.nicknameText.visibility = View.VISIBLE
        }


        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}