package com.example.perhitunganvolumepersegi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterActivity (private val dataset : MutableList<Data>):
        RecyclerView.Adapter<AdapterActivity.DataHolder>(){
            class DataHolder(view : View):RecyclerView.ViewHolder(view){
                val texthasil = view.findViewById<TextView>(R.id.hasil)
                val btnhapus = view.findViewById<ImageView>(R.id.delete)

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_adapter,parent,false
        )
        return DataHolder(view)
    }


    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.texthasil.text = dataset[position].hasil

        holder.btnhapus.setOnClickListener{
            dataset.removeAt(position)
            notifyItemRangeRemoved(position, dataset.size)
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
