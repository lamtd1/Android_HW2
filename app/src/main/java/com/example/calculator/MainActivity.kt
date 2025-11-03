package com.example.calculator

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var etBirthday: EditText
    private lateinit var btnSelectDate: Button
    private lateinit var calendarView: CalendarView
    private lateinit var etAddress: EditText
    private lateinit var etEmail: EditText
    private lateinit var cbTerms: CheckBox
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        rgGender = findViewById(R.id.rgGender)
        etBirthday = findViewById(R.id.etBirthday)
        btnSelectDate = findViewById(R.id.btnSelectDate)
        calendarView = findViewById(R.id.calendarView)
        etAddress = findViewById(R.id.etAddress)
        etEmail = findViewById(R.id.etEmail)
        cbTerms = findViewById(R.id.cbTerms)
        btnRegister = findViewById(R.id.btnRegister)

        val dateClickListener = View.OnClickListener {
            if (calendarView.visibility == View.GONE) {
                calendarView.visibility = View.VISIBLE
                calendarView.requestFocus()
            } else {
                calendarView.visibility = View.GONE
            }
        }

        btnSelectDate.setOnClickListener(dateClickListener)
        etBirthday.setOnClickListener(dateClickListener)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${month + 1}/$year"
            etBirthday.setText(selectedDate)
            calendarView.visibility = View.GONE
        }

        btnRegister.setOnClickListener {
            validateInputs()
        }
    }

    private fun validateInputs() {
        resetBackgrounds()

        if (etFirstName.text.isNullOrEmpty()) {
            etFirstName.setBackgroundColor(Color.RED)
        }

        if (etLastName.text.isNullOrEmpty()) {
            etLastName.setBackgroundColor(Color.RED)
        }

        if (rgGender.checkedRadioButtonId == -1) {
            rgGender.setBackgroundColor(Color.RED)
        }

        if (etBirthday.text.isNullOrEmpty()) {
            etBirthday.setBackgroundColor(Color.RED)
        }

        if (etAddress.text.isNullOrEmpty()) {
            etAddress.setBackgroundColor(Color.RED)
        }

        if (etEmail.text.isNullOrEmpty()) {
            etEmail.setBackgroundColor(Color.RED)
        }

        if (!cbTerms.isChecked) {
            cbTerms.setBackgroundColor(Color.RED)
        }
    }

    private fun resetBackgrounds() {
        etFirstName.setBackgroundColor(Color.TRANSPARENT)
        etLastName.setBackgroundColor(Color.TRANSPARENT)
        rgGender.setBackgroundColor(Color.TRANSPARENT)
        etBirthday.setBackgroundColor(Color.TRANSPARENT)
        etAddress.setBackgroundColor(Color.TRANSPARENT)
        etEmail.setBackgroundColor(Color.TRANSPARENT)
        cbTerms.setBackgroundColor(Color.TRANSPARENT)
    }
}
