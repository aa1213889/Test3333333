package com.example.testtttttttt3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testtttttttt3.Adapter.LitePalBookAdapter;
import com.example.testtttttttt3.Bean.Book;
import com.example.testtttttttt3.Util.ToastUtil;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import static android.text.TextUtils.isEmpty;

public class LitePalTestActivity extends AppCompatActivity implements View.OnClickListener {
private EditText editName,editPrice,editPage,editAuthor,editId,editPress;
private Button buttonCreate;
private String editNameText,editAuthorText,editPressText;
private int editPageText,editIdText;
private double editPriceText;
private List<Book> mBookList = new ArrayList<>();
private LitePalBookAdapter bookAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal_test);
        LitePal.getDatabase(); //创建数据库
        init();
    }
    private void init(){
      editName = findViewById(R.id.lp_edit_name);
      editPress = findViewById(R.id.lp_edit_press);
      editPrice = findViewById(R.id.lp_edit_price);
      editPage = findViewById(R.id.lp_edit_page);
      editAuthor = findViewById(R.id.lp_edit_author);
      editId = findViewById(R.id.lp_edit_id);
      buttonCreate = findViewById(R.id.lp_btn_create);
      buttonCreate.setEnabled(false);
      buttonCreate.setOnClickListener(this);
      editName.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void afterTextChanged(Editable editable) {
            refreshConfirm();
          }
      });
      editPage.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void afterTextChanged(Editable editable) {
              refreshConfirm();
          }
      });
      editPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                refreshConfirm();
            }
        });
      editId.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void afterTextChanged(Editable editable) {
              refreshConfirm();
          }
      });
      editAuthor.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void afterTextChanged(Editable editable) {
              refreshConfirm();
          }
      });
      editPress.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void afterTextChanged(Editable editable) {
              refreshConfirm();
          }
      });
      mBookList = LitePal.findAll(Book.class); //遍历
      bookAdapter = new LitePalBookAdapter(this,mBookList);
      RecyclerView recyclerView = findViewById(R.id.lp_recyclerView);
      recyclerView.setItemAnimator(new DefaultItemAnimator());
      LinearLayoutManager layoutManager = new LinearLayoutManager(this);
      recyclerView.setLayoutManager(layoutManager);
      recyclerView.setAdapter(bookAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lp_btn_create:
                Book book = new Book();
                editNameText = editName.getText().toString();
                editAuthorText = editAuthor.getText().toString();
                editPressText = editPress.getText().toString();
                editPriceText = Double.parseDouble(editPrice.getText().toString()); //字符串转为浮点类型
                editPageText = Integer.parseInt(editPage.getText().toString());  //字符串转为整数型
                editIdText = Integer.parseInt(editId.getText().toString());
                book.setBookName(editNameText);
                book.setAuthor(editAuthorText);
                book.setPrice(editPriceText);
                book.setBookId(editIdText);
                book.setPage(editPageText);
                book.setPress(editPressText);
                Log.e("LitePalTestActivity:  ","book.bookId:  "+ book.getBookId());
                book.save();
                editPage.setText("");
                editPress.setText("");
                editId.setText("");
                editPrice.setText("");
                editAuthor.setText("");
                editName.setText("");
                update();
                break;
                default:
        }
    }
    private void refreshConfirm() {   //监听editText
        if ( !isEmpty(editName.getText().toString())
                &&!isEmpty(editPage.getText().toString())
                &&!isEmpty(editId.getText().toString())
                &&!isEmpty(editAuthor.getText().toString())
                &&!isEmpty(editPress.getText().toString())
                &&!isEmpty(editPrice.getText().toString())
                ){
            buttonCreate.setEnabled(true);
        } else {
            buttonCreate.setEnabled(false);
        }
    }
    private void update(){
        mBookList.clear(); //去掉之前的数据
        List<Book> newList = LitePal.findAll(Book.class);
        mBookList.addAll(newList);//注意要将数据复制过来，而不是直接使用，不然无法更新数据
        bookAdapter.notifyDataSetChanged();    //更新数据
    }

}
