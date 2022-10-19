package com.robby.kotlin06

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.robby.kotlin06.adapter.NameDataAdapter
import com.robby.kotlin06.databinding.ActivityMainBinding

/**
 * @author Robby Tan
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val names = ArrayList<String>()
        names.add("John Doe")
        names.add("Susan Bones")
        names.add("Richard Max")
        names.add("Robby Tan")
        val nameDataAdapter = NameDataAdapter(names)
        nameDataAdapter.setOnItemDataClicked(object : NameDataAdapter.ItemDataClicked {
            override fun onItemClicked(name: String) {
                Toast.makeText(this@MainActivity, name, Toast.LENGTH_LONG).show()
            }
        })
        val manager = LinearLayoutManager(this@MainActivity)
        binding.rvData.adapter = nameDataAdapter
        binding.rvData.layoutManager = manager
        binding.rvData.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                manager.orientation
            )
        )
    }
}