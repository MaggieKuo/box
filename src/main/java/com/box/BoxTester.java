package com.box;

import java.util.Scanner;

public class BoxTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float length = enterFloat(scanner, "Please enter object's length: ");
        float width = enterFloat(scanner, "Please enter object's width: ");
//        int height = enterInt(scanner, "Please enter object's height: ");
        float height = enterFloat(scanner, "Please enter object's height: ");
        boolean rotate = enterYN(scanner, "Can the object to rotate? ");

        BaseBox box = Box.getInstanse(length, width, height, rotate);
        System.out.println(box==null ? "empty" : box.getName());
    }

    private static float enterFloat(Scanner scanner, String info){
        System.out.println(info);
        return scanner.nextFloat();
    }

    private static int enterInt(Scanner scanner, String info){
        System.out.println(info);
        return scanner.nextInt();
    }

    private static boolean enterYN(Scanner scanner, String info){
        String result;
        do{
            System.out.println(info + "(y/N)");
            result = scanner.next();
        } while("y".equals(result) || "N".equals(result));

        return "y".equals(result);
    }
}
