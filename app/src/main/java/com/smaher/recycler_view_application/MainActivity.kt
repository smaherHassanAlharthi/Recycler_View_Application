package com.smaher.recycler_view_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.RecyclerViewAdapter
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var addButton: Button
    lateinit var userEntry: EditText
    lateinit var tasks: ArrayList<String>
    lateinit var myRV: RecyclerView
    lateinit var appAlert: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addButton = findViewById(R.id.btAdd)
        userEntry = findViewById(R.id.etTask)
        tasks = arrayListOf()
        myRV = findViewById(R.id.rvMain)

        appAlert = findViewById(R.id.taskAlert)
        addButton.setOnClickListener (){ addTask() }
    }


    fun addTask() {
        var check = true
        var input = userEntry.text.toString()
        try {
            Integer.parseInt(input)
        }catch (e: Exception){
            check = false
        }

        if(check == true || input == null || input == ""){
            Snackbar.make(appAlert , "Enter a Task!!", Snackbar.LENGTH_LONG).show()
        }else {
            tasks.add(input)
            myRV.adapter = RecyclerViewAdapter(tasks)
            myRV.layoutManager = LinearLayoutManager(this)
            userEntry.setText("")
        }
    }
}