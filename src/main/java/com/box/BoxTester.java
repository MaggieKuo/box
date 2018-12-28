package com.box;

import java.util.Scanner;

public class BoxTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float length = enterFloat(scanner, "Please enter object's length: ");
        float width = enterFloat(scanner, "Please enter object's width: ");
        int height = enterInt(scanner, "Please enter object's height: ");
        Box3 box3 = new Box3();
        if (box3.validate(length, width, height)){
            System.out.println(box3.getBoxName());
        }else{
            Box5 box5 = new Box5();
            if (box5.validate(length, width, height)){
                System.out.println(box5.getBoxName());
            }else{
                System.out.println("Sorry.");
            }
        }
    }

    private static float enterFloat(Scanner scanner, String info){
        System.out.println(info);
//        System.out.print(info);
        return scanner.nextFloat();
    }

    private static int enterInt(Scanner scanner, String info){
//        System.out.print(info);
        System.out.println(info);
        return scanner.nextInt();
    }}
