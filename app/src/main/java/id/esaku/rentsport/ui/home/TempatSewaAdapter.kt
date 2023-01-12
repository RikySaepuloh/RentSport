package id.esaku.rentsport.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.esaku.rentsport.data.source.local.entity.TempatSewaEntity
import id.esaku.rentsport.databinding.ListTempatSewaBinding

class TempatSewaAdapter : RecyclerView.Adapter<TempatSewaAdapter.ViewHolder>() {
    private var dataArray= emptyList<TempatSewaEntity>()
    lateinit var context: Context

    fun initData(data:List<TempatSewaEntity>){
        this.dataArray = data
        notifyDataSetChanged()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListTempatSewaBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(dataArray[position]) {
                binding.tvNamaTempatSewa.text = nama
                binding.tvAlamat.text = alamat
                Glide.with(context).load(foto).into(binding.ivImage)
                binding.root.setOnClickListener {
                    context.startActivity(Intent(context, DetailPlaceActivity::class.java).putExtra("id",idTempatSewa))
                }
            }
        }

    }



    override fun getItemCount(): Int {
        return dataArray.size
    }

    inner class ViewHolder(val binding: ListTempatSewaBinding)
        :RecyclerView.ViewHolder(binding.root)

}