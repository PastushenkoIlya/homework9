package homework9;

public class Test {
    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.remove(1);
        System.out.println(list.toString());
    }
}
