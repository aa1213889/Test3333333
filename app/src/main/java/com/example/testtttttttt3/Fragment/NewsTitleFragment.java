package com.example.testtttttttt3.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testtttttttt3.Bean.News;
import com.example.testtttttttt3.NewsContentActivity;
import com.example.testtttttttt3.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/8.
 */

public class NewsTitleFragment extends Fragment {
     private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_farg,container,false);
        RecyclerView newsTitleRecyclerView = view.findViewById(R.id.news_title_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsTitleRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        newsTitleRecyclerView.setAdapter(adapter);
        return view;
    }

    private List<News> getNews(){
        List<News> newsList = new ArrayList<>();
        for(int i = 0; i <= 50; i++){
            News news = new News();
            news.setTitle("This is title"+i);
            StringBuffer content = new StringBuffer();
           for(int o = 0; o <= 20; o++){
            content.append("This is news content "+i+". ");
           }
            news.setContent(content.toString());
            newsList.add(news);
        }
        return newsList;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_layout)!=null){
            isTwoPane = true;
        }else {
            isTwoPane = false;
        }
    }
    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder>{
        private List<News> mNewsList;
        public NewsAdapter(List<News> list) {
           mNewsList = list;
        }
        class MyViewHolder extends  RecyclerView.ViewHolder{
            TextView newsTitleText;
            public MyViewHolder(View itemView) {
                super(itemView);
                newsTitleText = (TextView)itemView.findViewById(R.id.news_title);
            }
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
          News news = mNewsList.get(position);
          holder.newsTitleText.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
          View  view =LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
          MyViewHolder holder = new MyViewHolder(view);
         view.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                     News news = mNewsList.get(holder.getAdapterPosition());
                     if(isTwoPane){
                         NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                         newsContentFragment.refresh(news.getTitle(),news.getContent());
                     }else {
                         NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                     }
              }
          });
          return holder;
        }
    }

}
