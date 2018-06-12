package com.example.testtttttttt3;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.testtttttttt3.Fragment.AnotherRightFragment;
import com.example.testtttttttt3.Fragment.LeftFragment;
import com.example.testtttttttt3.Fragment.RightFragment;

public class DynamicFragmentTestActivity extends AppCompatActivity {
 Button button;
    int click = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment_test);
       replaceFragment(new RightFragment());
        button = findViewById(R.id.fm_btn_left);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnotherRightFragment anotherRightFragment = new AnotherRightFragment();
                replaceFragment(anotherRightFragment);
                click =1;
                if (click !=0){
                  button.setEnabled(false);
              }
            }
        });
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.right_layout_test, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
