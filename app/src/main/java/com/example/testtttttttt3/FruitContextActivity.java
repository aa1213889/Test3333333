package com.example.testtttttttt3;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testtttttttt3.Bean.Fruit;

public class FruitContextActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_context);
        init();
    }
    private void init(){
        immersionSystemBar();
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_fruit);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        ImageView fruitImageView = findViewById(R.id.fruit_image_view);
        TextView fruitContentText = findViewById(R.id.fruit_context_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Fruit fruit = (Fruit)getIntent().getSerializableExtra("fruit_data");
        collapsingToolbar.setTitle(fruit.getName());
        Glide.with(this).load(fruit.getImageId()).into(fruitImageView);
        fruitContentText.setText(generateFruitContent(fruit.getName()));
    }
    private String generateFruitContent(String name){
        StringBuilder fruitContent = new StringBuilder();
        for(int i = 0;i<500;i++){
            fruitContent.append(name+".");
        }
        return fruitContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
