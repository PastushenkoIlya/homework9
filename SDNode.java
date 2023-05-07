package homework9;

public class SDNode <K,V>{
    //single directional node
    SDNode <K, V> next;
    K key;
    V currentValue;
    int hashCode;


    public SDNode( K key, V currentValue, SDNode<K, V> next, int hashCode) {
        this.next = next;
        this.key = key;
        this.currentValue = currentValue;
        this.hashCode = hashCode;
    }

    public SDNode<K, V> getNext() {
        return next;
    }

    public void setNext(SDNode<K, V> next) {
        this.next = next;
    }

    public V getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(V currentValue) {
        this.currentValue = currentValue;
    }

    public K getKey() {
        return key;
    }

}