package com.box;

public class BaseBox implements Box {
    private float length;
    private float width;
    private int height;
    private String boxName;

    public BaseBox(String boxName, float length, float width, int height) {
        this.boxName = boxName;
        this.length = length > width ? length : width;
        this.width = length > width ? width : length;
        this.height = height;
    }

    @Override
    public boolean validate(float length, float width, int height) {
        float mlength = length > width ? length : width;
        float mWidth = length > width ? width : length;
        return this.length>= mlength && this.width>=mWidth && this.height>=height;
    }

    @Override
    public String getBoxName() {
        return boxName;
    }
}
