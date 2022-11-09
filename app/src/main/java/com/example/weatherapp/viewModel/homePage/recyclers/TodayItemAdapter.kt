package com.example.weatherapp.viewModel.homePage.recyclers


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.viewModel.homePage.HomeFragment


class TodayItemAdapter(
    private val context: HomeFragment, //todo homeFragmentViewModel
    private val todayDataset: MutableList<TodayItem>
) : RecyclerView.Adapter<TodayItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val temperaturePerHour: TextView = view.findViewById(R.id.temp_at_hour_textview)

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val temperaturePerHour: TextView = view.findViewById(R.id.footer_text_news)
//        val weatherIconPerHour: ImageView = view.findViewById(R.id.weatherIconPerHour)
        val eachTimeToday: TextView = view.findViewById(R.id.timeForToday)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_today_details, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = todayDataset[position]

        //todo troubles with homeFragment migrating to HomePageViewModel
        holder.temperaturePerHour.text = context.resources.getString(item.tempOfTime)
//        holder.weatherIconPerHour.setImageResource(item.weatherIconPerHour)
        holder.eachTimeToday.text = context.resources.getString(item.timeForToday)
    }


    override fun getItemCount() = todayDataset.size
}