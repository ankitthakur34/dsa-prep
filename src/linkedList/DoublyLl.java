package linkedList;

public class DoublyLl {

    Node head;
    Node tail;

    int size;

   public DoublyLl(){
        this.size=0;
    }

   private class Node{
    private     int val;
    private     Node next;
    private     Node prev;

    public Node(int val){
        this.val=val;
    }
    public Node(int val,Node next,Node prev){
        this.val=val;
        this.next=next;
        this.prev=prev;
    }
    }

    //INSERT
    public void insertFirst(int val){
       Node node = new Node(val);

       node.next=head;
       node.prev=null;
       if(head!=null) {
           head.prev = node;
       }
       head=node;
       size++;
    }

    public void insertAtPos(int val,int index){
       Node node = new Node(val);
       if(index==0){
           insertFirst(val);
           return;
       }

       Node pre = getIndex(index);
         node.next=pre.next;
         if(pre.next!=null) {
             pre.next.prev = node;
         }
         pre.next=node;
         node.prev=pre;
size++;
    }

    private Node getIndex(int index) {
       Node temp=head;
       for(int i=1;i<index;i++){
           temp=temp.next;
       }
       return temp;
    }


    public int deleteFirst(){
       if(head==null){
           return -1;
       }
       int val=head.val;
       head=head.next;

       if(head!=null){
           head.prev=null;
       }
       return val;
    }

    public int deleteIndex(int index){
if(index==0){
    return deleteFirst();
}
       Node prev=getIndex(index);
       int val=prev.next.val;
       prev.next=prev.next.next;
       if(prev.next!=null){
           prev.next.prev=prev;
       }
       return val;
    }


//DISPLAY
    public void display(){
       Node temp=head;
       while (temp!=null){
           System.out.print(temp.val+"<->");
           temp=temp.next;
       }
        System.out.println("END");
    }
    public void displayRev(){
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        Node newTemp=temp;
        System.out.print("END<->");
        while (newTemp!=null){
            System.out.print(newTemp.val+"<->");
            newTemp=newTemp.prev;
        }

    }

    public static void main(String[] args) {
        DoublyLl dll = new DoublyLl();

        dll.insertFirst(5);
        dll.insertFirst(4);dll.insertFirst(3);dll.insertFirst(2);dll.insertFirst(1);

        dll.display();
        System.out.println(dll.deleteIndex(0));
        dll.display();



    }
}
