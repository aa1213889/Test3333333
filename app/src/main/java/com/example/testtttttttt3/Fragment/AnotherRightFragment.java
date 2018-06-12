package com.example.testtttttttt3.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.testtttttttt3.DynamicFragmentTestActivity;
import com.example.testtttttttt3.R;

/**
 * Created by Administrator on 2018/6/7.
 */

public class AnotherRightFragment extends android.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.another_right_fragment,container,false);
        return view;
       // dynamicFragmentTestActivity.say();
    }
    DynamicFragmentTestActivity dynamicFragmentTestActivity = (DynamicFragmentTestActivity)getActivity();
   public void speak(){
       Toast.makeText(getActivity(),"BBB",Toast.LENGTH_SHORT).show();
   }
}
