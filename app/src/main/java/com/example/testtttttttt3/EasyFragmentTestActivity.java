package com.example.testtttttttt3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EasyFragmentTestActivity extends AppCompatActivity {
   Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_fragment_test);
        button = findViewById(R.id.fm_btn_left);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "使用了<fragment>标签在布局中添加了碎片，并使用android:name属性来显示指明要添加的碎片类名",Toast.LENGTH_LONG).show();
            }
        });
    }
}
