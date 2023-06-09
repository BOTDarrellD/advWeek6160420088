package com.example.advweek4_160420088.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4_160420088.R
import com.example.advweek4_160420088.databinding.StudentListItemBinding
import com.example.advweek4_160420088.model.Student
import com.example.advweek4_160420088.util.loadImage
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studenList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), ButtonDetailClickListener
{
    class StudentViewHolder(var view: StudentListItemBinding) : RecyclerView.ViewHolder(view.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int):StudentViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.student_list_item, parent, false)
        val view=DataBindingUtil.inflate<StudentListItemBinding>(inflater,R.layout.student_list_item,parent,false)
        return StudentViewHolder(view)

    }
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int)
    {
        holder.view.student=studenList[position]
        holder.view.listener=this
        /*var txtID=holder.view.txtID.text
        holder.view.txtID.text = studenList[position].id
        holder.view.txtName.text = studenList[position].name
        holder.view.btnDetail.setOnClickListener {
            val studentId=txtID.toString()
            val action = StudentListFragmentDirections.actionStudentDetail(studentId)
            Navigation.findNavController(it).navigate(action)
        }
        var imageView = holder.view.findViewById<ImageView>(R.id.imageView)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.loadImage(studenList[position].photoUrl, progressBar)*/
    }
    override fun getItemCount(): Int {
        return studenList.size
    }
    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val action =StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}



