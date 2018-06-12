package com.example.testtttttttt3.Adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.testtttttttt3.Bean.Fruit;
import com.example.testtttttttt3.R;

import java.util.List;

/**
 * Created by Administrator on 2018/5/14.
 */

public class FruitAdapter extends BaseQuickAdapter<Fruit, BaseViewHolder> {

    public FruitAdapter(@LayoutRes int layoutResId, @Nullable List<Fruit> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Fruit item) {
        holder.setText(R.id.fruit_name,item.getName());
        Glide.with(mContext).load(item.getImageId()).crossFade().into((ImageView) holder.getView(R.id.fruit_image));
    }
}

