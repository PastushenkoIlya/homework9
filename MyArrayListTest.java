package homework9;

import homework8.Circle;

public class MyArrayListTest <V>{
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add(111);
        list.add(new Circle("ball"));
        list.add(1);
        System.out.println(list.toString());
    }
}
