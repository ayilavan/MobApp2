package com.lavan.mobapp2

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView

lateinit var shared : SharedPreferences

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shared = getSharedPreferences("show", MODE_PRIVATE)
        val switch: Switch = findViewById(R.id.switch1)
        val textView: TextView = findViewById(R.id.viewText)

        switch.isChecked = update("isOn")
        if(switch.isChecked){
            textView.text = "This is my 2nd App"
        }


        switch.setOnCheckedChangeListener {_ ,isOn->
            if (isOn) {
                textView.text = "This is my 2nd App"
                save("isOn",true)
            }else{
                textView.text =""
                save("isOn", false)
            }
        }


        }

    private fun save(key: String, status: Boolean) {
        val edit = shared.edit()
        edit.putBoolean(key,status)
        edit.commit()
    }
    private fun update (key:String): Boolean{
        return shared.getBoolean(key,false)
    }
}
