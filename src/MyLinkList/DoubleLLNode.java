
package MyLinkList;


public class DoubleLLNode<T> {
  
    protected T data;
    protected DoubleLLNode<T> next;
    protected DoubleLLNode<T> prev;
    
    public DoubleLLNode(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
    public DoubleLLNode(DoubleLLNode<T> prev,T data,DoubleLLNode<T> next){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    
    public void setNextLink(DoubleLLNode<T> next){
        this.next = next;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    
    public T getData(){
        return this.data;
    }
    
    public DoubleLLNode<T> getNextLink(){
        return this.next;
    }
    
    public DoubleLLNode<T> getPrevLink(){
        return this.prev;
    }
}
