/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLinkList;


public class SingleLLNode<T> {
    protected T info;
    protected SingleLLNode<T> link;
    /**
     * initializes a single node
     * @param info 
     */
    public SingleLLNode(T info){
        this.info = info;
        this.link = null;
    }
    
    public void setInfo(T info){
        this.info = info;
    }
    
    public T getInfo(){
        return info;
    }
    
    public void setLink(SingleLLNode<T> link){
        this.link = link;
    }
    public SingleLLNode<T> getLink(){
        return this.link;
    }
    
}

