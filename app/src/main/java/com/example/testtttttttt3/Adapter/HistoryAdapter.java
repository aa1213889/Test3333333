package com.example.testtttttttt3.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testtttttttt3.Bean.History;
import com.example.testtttttttt3.R;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    private List<History> mHistoryList ;
    private Context mContext;

    public HistoryAdapter(List<History> list,Context context) {
        mHistoryList = list;
        mContext = context;
    }
    static class MyViewHolder extends  RecyclerView.ViewHolder{
        private TextView historytitle;
        private ImageView historyImage;
        public  MyViewHolder(View view){
            super(view);
             historytitle = view.findViewById(R.id.hd_tv_name);
             historyImage = view.findViewById(R.id.hd_img);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        History history = mHistoryList.get(position);
//        holder.ada_tv_year_month_day.setText(beforeToday.getYear()+"/"+beforeToday.getMonth()+"/"+beforeToday.getDay());
//        holder.ada_tv_content.setText(beforeToday.getContent());
        holder.historytitle.setText(history.getTitle());
    //    holder.ada_tv_lunar.setText(beforeToday.getLunar());
        Glide.with(mContext).load(history.getPicture()).into(holder.historyImage);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.history_today_item_layout,parent,false));
        return holder;
    }

    @Override
    public int getItemCount() {
        return mHistoryList.size();
    }
}
