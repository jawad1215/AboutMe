package com.example.aboutme

import android.content.Context
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName:MyName= MyName("Jawad Yousaf")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        //findViewById<Button>(R.id.done_button).setOnClickListener { addNickName(it) }

        binding.myName=myName
        binding.doneButton.setOnClickListener { addNickName(it) } //


    }

    private fun addNickName(view:View)
    {
//        val editText=findViewById<EditText>(R.id.nickname_edit)
//        val nickNameTextView=findViewById<TextView>(R.id.nickname_text)
//
//        nickNameTextView.text=editText.text
//        editText.visibility=View.GONE
//        view.visibility=View.GONE
//        nickNameTextView.visibility= View.VISIBLE
        binding.apply {
            //nicknameText.text = binding.nicknameEdit.text
            myName?.nickname=nicknameEdit.text.toString()
            invalidateAll() //used to refresh the UI with new data
            // invalidataAll is refresh all binding objects so they could be recreated with
            //correct data
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE

        }
        //Hide the Keyboard

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}
