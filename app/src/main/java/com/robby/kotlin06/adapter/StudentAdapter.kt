package com.robby.kotlin06.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.robby.kotlin06.R
import com.robby.kotlin06.databinding.StudentItemBinding
import com.robby.kotlin06.entity.Student

/**
 * @author Robby Tan
 */
class StudentAdapter(private val students: ArrayList<Student>) :
    Adapter<StudentAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.setStudentData(students[position])
    }

    override fun getItemCount(): Int {
        return students.size
    }

    class StudentViewHolder(itemView: View) : ViewHolder(itemView) {

        private val binding: StudentItemBinding

        init {
            binding = StudentItemBinding.bind(itemView)
        }

        fun setStudentData(student: Student) {
            binding.tvStudentId.text = student.id
            binding.tvStudentName.text = "${student.firstName} ${student.lastName}"
            binding.tvStudentDepartment.text = student.department
        }
    }
}