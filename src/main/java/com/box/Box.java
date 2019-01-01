package com.box;

public class Box {
    public static BaseBox getInstanse(float length, float width, float height, boolean rotate){
        BaseBox box = null;
        Box3 box3 = new Box3();
        if (box3.validate(length, width, height))
            box = box3;
        else{
            Box5 box5 = new Box5();
            if (box5.validate(length, width, height))
                box = box5;
        }
        return box;
    }

}
