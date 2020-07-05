package com.mic.dateandtime

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c= Calendar.getInstance()
        var year=c.get(Calendar.YEAR)
        var month=c.get(Calendar.MONTH)
        var day=c.get(Calendar.DAY_OF_MONTH)
     txt_text.setOnClickListener {
         val dpd= DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, myear, mmonth, mday ->
             txt_text.setText(""+myear+"/"+mmonth+"/"+mday)

         },year,month,day)
         dpd.show()

     }
        txt_texttime.setOnClickListener {
            val timeS=TimePickerDialog.OnTimeSetListener { view, hour
                                                           , minute ->
                c.set(Calendar.HOUR_OF_DAY,hour)
                c.set(Calendar.MINUTE,minute)
                txt_texttime.setText(SimpleDateFormat("hh:mm a").format(c.time))

            }
            TimePickerDialog(this,timeS,c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),false).show()
        }
    }
}