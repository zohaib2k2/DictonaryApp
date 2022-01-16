
package MyLinkList;

public class DoubleLinkList<T> 
{
    int size = 0;
    protected DoubleLLNode<T> head;
    protected DoubleLLNode<T> tail;
    
    public void display(){
        // display all the elements in the link list
        DoubleLLNode<T> current;
        if(head == null) return;
        for(current = head; current != null;current = current.next){
            System.out.println(current.data);
        }
    }
    
    public void reverseDisplay(){
        DoubleLLNode<T> current ;
        if(head == null) return;
        for(current = tail; current != null; current = current.prev){
            System.out.println(current.data);
        }
    }
    
    public void linkFirst(T element){
        DoubleLLNode<T> h = head;
        DoubleLLNode<T> newNode = new DoubleLLNode(null,element,h);
        head = newNode;
        if (h == null)
            tail = newNode;
        else
            h.prev = newNode;
        size++;
    }
    public void linkLast(T element){
        DoubleLLNode current;
        if(head == null && tail == null){
            head = new DoubleLLNode(null,element,null);
            tail = head;
        } else {
            
            for(current = head; current != null; current = current.next ){
                tail = current;
            }
            DoubleLLNode newNode = new DoubleLLNode(tail,element,null);
            tail.next = newNode;
            
        }
        tail = tail.next;
        size++;
            
    }
    
    public void append(T elements){
        this.linkLast(elements);
    }
    
    public DoubleLLNode<T> search(T element){
        DoubleLLNode current;
        if(head == null && tail == null){
            return null;
        }
        else {
            current = head;
            while(current != null){
                if(current.data.equals(element)){
                    return current;
                }
                current = current.next;
            }
        }
        return null;
    }
    
    public boolean remove(T element){
        DoubleLLNode<T> removeable;
        removeable = search(element);
        if(removeable == null){
            return false;
        } else {
            T ele = removeable.data;
            DoubleLLNode<T> next = removeable.next;
            DoubleLLNode<T> prev = removeable.prev;
            if(prev == null){
                head = next;
                head.prev = null;
            } else if(next == null){
                tail = prev;
                tail.next = null;
            }
            else {
                prev.next = next;
                next.prev = prev;
                removeable.prev = null;
            }
            size--;
            return true;
        }
    }
    
    public boolean insertAfter(DoubleLLNode<T> beforeNode, T info ){
        if(this.search(beforeNode.getData()) == null){
            return false;
        }
        if(head == null && tail == null){
            this.linkLast(info);
            return true;
        } else if(beforeNode == tail){
            this.linkLast(info);

            return true;
        } else if(beforeNode == head){
            DoubleLLNode<T> linkableNode = new DoubleLLNode(head,info,head.next);
            head.next = linkableNode;
            this.size++;
            return true;
        } else {
            DoubleLLNode<T> curLink = head;
            while(curLink != beforeNode){
                curLink = curLink.next;
            }
            DoubleLLNode<T> linkableNode = new DoubleLLNode(curLink.prev,info
                    ,curLink.next);
            curLink.next = linkableNode;
            size++;
            return true;
            
        }
        
    }
    
    public Object[] toArray(){
        Object[] array = null;
        DoubleLLNode current;
        if(head == null) return null;
        current = head;
        int index = 0;
        while(current != null && index < this.size){
            array[index] = current.data;
            index++;
            current = current.next;
        }
        return array;
    }
    
    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return (this.getSize() == 0) ? true : false;
    }
    public DoubleLLNode<T> getHead(){
        return this.head;
    }
    
    public DoubleLLNode<T> getTail(){
        return this.tail;
    }
}
