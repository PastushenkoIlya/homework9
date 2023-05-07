package homework9;
import java.util.*;

public class MyArrayList <T>{
    Object[] arr = new Object[0];
    public void add(T obj){
        arr = Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1] = obj;
    }
    public void remove(int index){
        if(arr.length == 0 || arr.length <= index || index < 0) throw new IndexOutOfBoundsException("Incorrect index "+ index);

        Object[] result = Arrays.copyOf(arr, arr.length-1);
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(i != index){
                result[count] = arr[i];
                count++;
            }
        }
        arr = result;
    }
    public void clear(){
        arr = new Object[0];
    }
    public int size(){
        return arr.length;
    }
    public T get(int index){
        return (T) arr[index];
    }



}
