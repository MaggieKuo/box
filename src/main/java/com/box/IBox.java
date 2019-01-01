package com.box;

public interface IBox {
//    boolean validate(float length, float width, int height);
    boolean validate(float length, float width, float height);
    boolean validate(float length, float width, float height, boolean rotate);
    String getName();
    void canToRotate(boolean rotate);
}
