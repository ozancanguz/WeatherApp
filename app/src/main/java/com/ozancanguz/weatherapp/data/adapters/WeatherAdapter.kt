package com.ozancanguz.weatherapp.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.weatherapp.R
import com.ozancanguz.weatherapp.data.models.Weather
import com.ozancanguz.weatherapp.data.models.WeatherResult
import com.ozancanguz.weatherapp.data.util.Util.Companion.loadImage
import kotlinx.android.synthetic.main.search_city_rv.view.*

class WeatherAdapter:RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {
    class WeatherViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    var weatherList= emptyList<WeatherResult>()

    fun setData(newData: Weather){
        this.weatherList=newData.result
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.search_city_rv,parent,false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val currentCity=weatherList[position]
        holder.itemView.Rv_date.text=currentCity.date
        holder.itemView.Rv_day.text=currentCity.day
        holder.itemView.Rv_degree.text=currentCity.degree
        holder.itemView.Rv_mindegree.text=currentCity.min
        holder.itemView.Rv_maxdegree.text=currentCity.max
        holder.itemView.Rv_humidity.text=currentCity.humidity
        holder.itemView.Rv_night.text=currentCity.night

        // glide image loading
        holder.itemView.Rv_iconimageview.loadImage(currentCity.icon)
    }

    override fun getItemCount(): Int {
      return weatherList.size
    }


}