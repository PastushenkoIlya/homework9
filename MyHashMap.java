package homework9;

public class MyHashMap<V,K>{
    private SDNode<V,K> [] array = new SDNode[5];

    public void put(K key, V value){

        int decider = key.hashCode()%5;
        if(array[decider] == null){
            array[decider] = new SDNode(key,value, null, key.hashCode());

        }
        else{
            SDNode temp = array[decider];
            while(true){
                //if there is an object with equal key we don't add another one
                if(temp.getKey().equals(key)) return;
                //searching for the last element in LinkedList chain
                if(temp.getNext() != null){
                    temp = temp.getNext();
                }
                else{
                    temp.setNext(new SDNode(key,value,null,key.hashCode()));
                    return;
                }
            }
        }
    }
    public void remove(K key){
        int decider = key.hashCode()%5;
        //if bucket is empty
        if(array[decider] == null) return;
        //if first element of LinkedList on the bucket is the searched one
        if(array[decider].getKey().equals(key)){
            array[decider] = array[decider].getNext();
            return;
        }

        SDNode tNode = array[decider].getNext();
        SDNode previousNode = array[decider];
        while(true){
            if(tNode.getKey().equals(key)){
                if(tNode.getNext() == null){
                    tNode = null;
                    previousNode.setNext(null);
                    return;
                }
                else{
                    previousNode.setNext(tNode.getNext());
                    return;
                }
            }
            else{
                previousNode = tNode;
                tNode = tNode.getNext();
            }
        }
    }
    public void clear(){
        for(SDNode bucket : array){
            bucket = null;
        }
    }
    public int size(){
        int count = 0;
        for(SDNode tNode : array){
            if(tNode == null) continue;
            tNode = tNode.getNext();
            count++;

        }
        return count;
    }
    public K get(K key){
        int decider = key.hashCode()%5;
        if(array[decider] == null) return null;
        if(array[decider].getKey().equals(key)){
            return array[decider].getCurrentValue();
        }
        SDNode tNode = array[decider].getNext();
        while(true){
            if(tNode.getNext().equals(null)) return null;
            if(tNode.getKey().equals(key)) return (K) tNode.getCurrentValue();
            else tNode = tNode.getNext();

        }
    }



}
