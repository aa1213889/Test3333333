package com.example.testtttttttt3;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.testtttttttt3.Adapter.FruitAdapter;
import com.example.testtttttttt3.Bean.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

public class BaseRecyclerViewAdapterHelperActivity extends BaseActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    private FruitAdapter adapter;
    private Fruit[] fruits = {
            new Fruit("Apple",R.drawable.apple),
            new Fruit("Banana",R.drawable.banana),
            new Fruit("Orange",R.drawable.orange),
            new Fruit("Watermelon",R.drawable.watermelon),
            new Fruit("Pear",R.drawable.pear),
            new Fruit("Grape",R.drawable.grape),
            new Fruit("Pineapple",R.drawable.pineapple),
            new Fruit("Strawberry",R.drawable.strawberry),
            new Fruit("Cherry",R.drawable.cherry),
            new Fruit("Mango",R.drawable.mango),
    };
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_recycler_view_adapter_helper);
        init();
        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recyc_fruit);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FruitAdapter(R.layout.fruit_adapter_item,fruitList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Fruit fruit = fruitList.get(position);
                Intent intent = new Intent(BaseRecyclerViewAdapterHelperActivity.this,FruitContextActivity.class);
                intent.putExtra("fruit_data",fruit);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void init(){
        immersionSystemBar();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


         FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"excuse 咪?",Snackbar.LENGTH_SHORT).show();
            }
        });
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_re);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(1500);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initFruits();
                                adapter.notifyDataSetChanged();
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                }).start();
            }
        });

    }
    private void initFruits(){
        fruitList.clear();
        for(int i = 0;i < 50;i++){
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
    }
}
