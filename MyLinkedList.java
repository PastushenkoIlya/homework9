package homework9;
import java.util.*;
public class MyLinkedList <V>{
    private Node<V> first;
    private Node <V> last;

    public void add(V element){
        if(first == null) {
            first = new Node<V>(null, null, element);
            first.setPosition(0);
            return;

        }
        else if(last == null){
            last = new Node<V>(first, null, element);
            first.setNextElement(last);
            last.setPosition(1);
            return;
        }
        else {
            Node<V> tNode = new Node<V>(last, null, element);
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
            while(temp.getPosition() < last.getPosition()+1){
                if(temp.getPosition() == index){
                    //connecting previous and next nodes between each other
                    temp.getPreviousElement().setNextElement(temp.getNextElement());
                    temp.getNextElement().setPreviousElement(temp.getPreviousElement());

                    //recalculating a positions for the next elements
                    while(temp.getPosition() < last.getPosition()){
                        temp.getNextElement().setPosition(temp.getNextElement().getPosition()-1);
                        if(temp.getNextElement() != null)
                        temp = temp.getNextElement();
                    }
                    return;
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
    public <V> V get(int index){
        if(first == null && last == null) throw new EmptyStackException();
        if(index > last.getPosition()) throw new IndexOutOfBoundsException();
        Node<V> temp;
        if(last.getPosition()/2 > index){
            temp = (Node<V>) first;
            while (temp.getPosition() < last.getPosition()){
                if(temp.getPosition() == index) return temp.getCurrentElement();
                else temp = temp.getNextElement();
            }

        }
        else{
            temp = (Node<V>) last;
            while(temp.getPosition() > first.getPosition()){
                if(temp.getPosition() == index) return temp.getCurrentElement();
                else temp = temp.getPreviousElement();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node tNode = first;
        while(tNode.getPosition() < last.getPosition()){
            sb.append(tNode.getCurrentElement()+" ");
            tNode = tNode.getNextElement();
        }
        sb.append(last.getCurrentElement());
        return sb.toString();
    }
}
