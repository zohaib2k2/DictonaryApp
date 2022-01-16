
package MyLinkList;

public class SimpleLinkList<T> {
    
    protected SingleLLNode<T> head;
    protected SingleLLNode<T> tail;
    
    public void display(){
        SingleLLNode current = head;
        
        while(current != null){
            System.out.println("[::DEBUG:: "+current.getLink()+"] "
                    +current.info+" ");
            
            current = current.getLink();
            
        }
    }
    
    public void append(T element){
        SingleLLNode newNode = new SingleLLNode(element);
        
        if(tail == null && head == null){
            head = newNode;
            tail = head.getLink();
        }
        else{
            SingleLLNode current = head;
            while(current.getLink() != null){
                current = current.getLink();
            }
            current.setLink(newNode);
            tail = current.getLink();
        }
        
    }
    
    public SingleLLNode search(T element){
        SingleLLNode current = head;
        while(current.getLink() != null){
            if(current.getInfo() == element){
                return current;
            }
            current = current.getLink();
        }
        return null;
    }
    
    public boolean delete(T element){
        int found = 0;
        if(head == null) return false;
        
        else if(head.getInfo() == element)
        {
            head = head.getLink();
            found = 1;
        } else {
            SingleLLNode current = head;
            SingleLLNode prev = null;
        
            while(current != null)
            {
                if(current.getInfo() == element){
                    prev.setLink(current.getLink());
                    found = 1;
                    break;
                } else {
                    prev = current;
                    current = current.getLink();
                }
            }
        }
        return (found == 0) ? (false) : (true);
    }
    
}
