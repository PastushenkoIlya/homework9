package homework9;

public class MyQueue <V>{
    Node <V> first;
    Node <V> last;

    public void add(V element){
        if(first == null) {
            first = new Node <V> (null, null, element);
            return;
        }
        else if(last == null){
            last = new Node <V> (first, null, element);
            first.setNextElement(last);
            return;
        }
        Node<V> tNode = new Node<V>(last, null, element);
        last.setNextElement(tNode);
        last = tNode;

    }
    public void clear(){
        first = null;
        last = null;
    }
    public int size (){
        if(first == null && last == null) return 0;

        int count = 1;
        Node <V> temp = first;
        while(temp != last){
            temp = temp.getNextElement();
            count++;
        }
        return count;
    }
    public V peek (){
        return first.getCurrentElement();
    }
    public V poll(){
        V temp = first.getCurrentElement();
        first = first.getNextElement();
        first.setPreviousElement(null);
        return temp;
    }
}
