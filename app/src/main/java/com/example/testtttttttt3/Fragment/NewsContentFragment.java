package com.example.testtttttttt3.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testtttttttt3.R;

/**
 * Created by Administrator on 2018/6/8.
 */

public class NewsContentFragment extends Fragment{
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }
    public void refresh(String newsTitle,String newsContent){
        View viewLayout = view.findViewById(R.id.news_content_layout);
        viewLayout.setVisibility(View.VISIBLE);
        TextView newsTitleText = view.findViewById(R.id.news_title);
        TextView newsContentText = viewLayout.findViewById(R.id.news_content);
        newsContentText.setText(newsContent);
        newsTitleText.setText(newsTitle);
    }
}
