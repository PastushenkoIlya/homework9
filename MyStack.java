package homework9;

public class MyStack <V>{
    private Node<V> first;
    private Node <V> last;

    public void push(V value){
        if(first == null) {
            first = new Node<V>(null, null, value);
            first.setPosition(0);
            return;

        }
        else if(last == null){
            last = new Node<V>(first, null, value);
            first.setNextElement(last);
            last.setPosition(1);
            return;
        }
        else {
            Node<V> tNode = new Node<V>(last, null, value);
            last.setNextElement(tNode);
            last = tNode;
            last.setPosition(last.getPreviousElement().getPosition()+1);
        }
    }
    public void remove(int index){
        if((first == null && last == null) || index > last.getPosition()) return;

        //check if it is first or last element
        if(first.getPosition() == index){
            first.getNextElement().setPreviousElement(null);
            first = first.getNextElement();
            Node<V> temp = first;
            while(temp.getNextElement() !=null) {
                temp.setPosition(temp.getPosition() - 1);
                temp = temp.getNextElement();
            }
            return;
        }
        if(last.getPosition() == index){
            last.getPreviousElement().setNextElement(null);
            last = last.getPreviousElement();
            Node<V> temp = last;
            return;
        }

        // if t is some inner element

        Node<V> temp = first;
        while(temp.getPosition() != last.getPosition()+1){
            if(temp.getPosition() == index){
                temp.getPreviousElement().setPreviousElement(temp.getPreviousElement());
                temp.getNextElement().setPreviousElement(temp.getNextElement());
                while(temp.getPosition() < index){
                    temp.setPosition(temp.getPosition()-1);
                    temp = temp.getNextElement();
                }
            }
            else{
                temp = temp.getNextElement();
            }
        }
    }
    public int size(){
        if(first == null && last == null) return 0;

        int count = 1;
        Node <V> temp = first;
        while(temp != last){
            temp = temp.getNextElement();
            count++;
        }
        return count;
    }
    public void clear(){
        first = null;
        last = null;
    }
    public V peek (){
        return last.getCurrentElement();

    }
    public V pop(){
        V temp = last.getCurrentElement();
        last = last.getPreviousElement();
        last.setNextElement(null);
        return temp;
    }


}
