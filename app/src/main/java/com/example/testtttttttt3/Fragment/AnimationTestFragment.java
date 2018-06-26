package com.example.testtttttttt3.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testtttttttt3.R;

/**
 * Created by Administrator on 2018/6/26.
 */

public class AnimationTestFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.animation_fragment_test_layout,container,false);
        return view;
    }
}
