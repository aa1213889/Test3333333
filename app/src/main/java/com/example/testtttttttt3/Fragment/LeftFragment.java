package com.example.testtttttttt3.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.testtttttttt3.R;

/**
 * Created by Administrator on 2018/6/7.
 */

public class LeftFragment extends android.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment,container);
        return view;
    }
    public void speak(){
        Toast.makeText(getActivity(),"BBB",Toast.LENGTH_SHORT).show();
    }
}
