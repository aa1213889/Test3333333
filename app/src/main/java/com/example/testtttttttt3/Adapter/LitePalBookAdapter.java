package com.example.testtttttttt3.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.testtttttttt3.Bean.Book;
import com.example.testtttttttt3.Bean.ChatMessage;
import com.example.testtttttttt3.R;
import com.example.testtttttttt3.Util.ToastUtil;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by Administrator on 2018/6/19.
 */

public class LitePalBookAdapter extends RecyclerView.Adapter<LitePalBookAdapter.MyViewHolder>{

    private List<Book> mBookList;
    public Context mContext;

    static class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView textViewName,textViewId,textViewPrice,textViewPages,textViewAuthor,textViewPress;
        RelativeLayout itemBook;
        public  MyViewHolder(View view){
            super(view);
            textViewName = view.findViewById(R.id.book_item_name);
            textViewId = view.findViewById(R.id.book_item_id);
            textViewPress = view.findViewById(R.id.book_item_press);
            textViewPrice = view.findViewById(R.id.book_item_price);
            textViewPages = view.findViewById(R.id.book_item_pages);
            textViewAuthor = view.findViewById(R.id.book_item_author);
            itemBook = view.findViewById(R.id.book_item_adapter);
        }
    }
    public  LitePalBookAdapter(Context context,List<Book> mList){
        mContext = context;
        mBookList = mList;
    }

    @Override
    public LitePalBookAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item_layout,parent,false);
        final LitePalBookAdapter.MyViewHolder holder = new LitePalBookAdapter.MyViewHolder(view);
//        holder.itemBook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int id = getItemCount();
//                deleteData(id);
//            }
//        });
//        holder.itemBook.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//
//                int id = getItemCount();
//                deleteData(id);
//                mBookList.removeData()
//                return false;
//            }
//        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final LitePalBookAdapter.MyViewHolder holder, final int position) {
        Book book = mBookList.get(position);
        holder.textViewId.setText(book.getBookId()+"");
        holder.textViewName.setText(book.getBookName());
        holder.textViewPrice.setText(book.getPrice()+"");
        holder.textViewPages.setText(book.getPage()+"");
        holder.textViewAuthor.setText(book.getAuthor());
        holder.textViewPress.setText(book.getPress());

        holder.itemBook.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(mContext).setTitle("确定删除?")
                        .setTitle("删除?")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                             //   deleteData(book.getBookId());
                                deleteData("BookName = ?","Jack");
                                removeData(position);
                            }
                        }).show();
                return false;
            }
        });
        holder.itemBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG","position is :"+position+",getAdapterPosition is :"+ holder.getAdapterPosition()
                        +",getLayoutPosition() is :"+holder.getLayoutPosition()+",book.getBookId() is:"+book.getBookId());
                //查看区别
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }
    public void deleteData(int id){
        LitePal.deleteAll(Book.class, "mBookId = ?", String.valueOf(id)); //数据库删除
    }
    public void deleteData(String condition,String data){
        LitePal.deleteAll(Book.class,  condition, data); //数据库删除
    }
    public  void removeData(int position){
        mBookList.remove(position);
        notifyDataSetChanged();
    }
}
