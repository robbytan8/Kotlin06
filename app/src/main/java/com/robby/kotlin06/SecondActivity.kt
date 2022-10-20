package com.robby.kotlin06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import com.robby.kotlin06.adapter.StudentAdapter
import com.robby.kotlin06.databinding.ActivitySecondBinding
import com.robby.kotlin06.entity.Student
import java.io.InputStreamReader

/**
 * @author Robby Tan
 */
class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var students: ArrayList<Student>
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        students = ArrayList()
        studentAdapter = StudentAdapter(students)
        val manager = LinearLayoutManager(this@SecondActivity)

        binding.rvStudent.adapter = studentAdapter
        binding.rvStudent.layoutManager = manager
    }

    override fun onStart() {
        super.onStart()
        fetchDataFromFile()
    }

    private fun fetchDataFromFile() {
        val inputStream = assets.open("students.json")
        val reader = JsonReader(InputStreamReader(inputStream, Charsets.UTF_8))
        val gson = Gson()
        val data = gson.fromJson<Array<Student>>(reader, Array<Student>::class.java)
        students.clear()
        students.addAll(data)
        studentAdapter.notifyItemChanged(0)
    }
}