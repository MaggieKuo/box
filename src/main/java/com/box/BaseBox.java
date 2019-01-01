package com.box;

import java.util.Arrays;

public abstract class BaseBox implements IBox {
    private float length;
    private float width;
    //    private int height;
    private float height;
    private boolean rotate;

    public BaseBox(float length, float width, float height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean validate(float length, float width, float height) {
        if (rotate){
            float data[] = new float[]{length, width, height};
            Arrays.sort(data);
            length = data[0];
            width = data[1];
            height = data[2];
        }else {
            length = length > width ? length : width;
            width = length > width ? width : length;
        }
        return this.length >= length && this.width >= width && this.height >= height;
    }

    @Override
    public boolean validate(float length, float width, float height, boolean rotate) {
        canToRotate(rotate);
        return validate(length, width, height);
    }

    @Override
    public void canToRotate(boolean rotate) {
        this.rotate = rotate;
        if (rotate) {
            float data[] = new float[]{length, width, height};
            Arrays.sort(data);
            length = data[0];
            width = data[1];
            height = data[2];
        } else {
            this.length = length > width ? length : width;
            this.width = length > width ? width : length;
        }
    }

//    public BaseBox(float length, float width, int height) {
//        this.length = length > width ? length : width;
//        this.width = length > width ? width : length;
//        this.height = height;
//    }
//
//
//
//    @Override
//    public boolean validate(float length, float width, int height) {
//        float mlength = length > width ? length : width;
//        float mWidth = length > width ? width : length;
//        return this.length>= mlength && this.width>=mWidth && this.height>=height;
//    }


}
