package com.example.testtttttttt3.Bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/14.
 */

public class Fruit implements Serializable {
    private String name;
    private int imageId;
    private int headIamge;

    public int getHeadIamge() {
        return headIamge;
    }

    public void setHeadIamge(int headIamge) {
        this.headIamge = headIamge;
    }

    public Fruit(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
