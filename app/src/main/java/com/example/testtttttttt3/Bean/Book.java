package com.example.testtttttttt3.Bean;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

/**
 * Created by Administrator on 2018/6/14.
 */

public class Book extends LitePalSupport  {
  private int mBookId;
  private double Price;
  private String BookName;
  private String Author;
  private int Page;
  private String Press;

    public int getBookId() {
        return mBookId;
    }

    public void setBookId(int bookId) {
        mBookId = bookId;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public int getPage() {
        return Page;
    }

    public void setPage(int page) {
        Page = page;
    }

    public String getPress() {
        return Press;
    }

    public void setPress(String press) {
        Press = press;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}
