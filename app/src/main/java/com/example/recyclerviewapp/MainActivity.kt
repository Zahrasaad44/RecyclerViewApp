package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var rootLayout: ConstraintLayout
    private lateinit var rvMain: RecyclerView
    private lateinit var userEntry: EditText
    private lateinit var addBtn2: Button
    private lateinit var entries: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.theRoot)
        rvMain = findViewById(R.id.recyclerView)
        userEntry = findViewById(R.id.userEntry)
        addBtn2 = findViewById(R.id.addBtn2)
        addBtn2 = findViewById(R.id.addBtn2)

        entries = ArrayList() // empty ArrayList

        rvMain.adapter = RecyclerViewAdapter(entries)
        rvMain.layoutManager = LinearLayoutManager(this)


        addBtn2.setOnClickListener {
            Log.d("MainCode2", "btn clicked")
            addUserEntry()
        }
    }

    private fun addUserEntry() {
        val entry = userEntry.text.toString()
        if (entry.isNotEmpty()){
        entries.add(entry)
            userEntry.text.clear()  // To remove user's text after tapping "Add" btn
            userEntry.clearFocus()  // To remove the focus of the "userEntry" edit text after tapping "Add" btn
            rvMain.adapter?.notifyDataSetChanged()
        } else {
            Snackbar.make(rootLayout, "You need to type some text", Snackbar.LENGTH_LONG).show()
        }
    }
}