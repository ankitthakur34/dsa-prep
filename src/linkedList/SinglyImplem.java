package linkedList;

public class SinglyImplem {

    Node head;
    Node tail;

    int size;

    public SinglyImplem(){
        this.size=0;
    }

   private class Node{
        int val;
        Node next;

        public Node(int val){
            this.val=val;
        }

        public Node(int val,Node next){
            this.val=val;
            this.next=next;
        }

    }

    //INSERT
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next=head;
        head=node;

        if(tail==null){
            tail=head;
        }
        size++;
    }

    public void insertLastTail(int val){
        Node node = new Node(val);
        if(tail==null){
            insertFirst(val);
            return;
        }
        tail.next=node;
        tail=node;

        size++;
    }

    public void insertAtPos(int val,int index){
        Node temp=head;
       if(index==0){
         insertFirst(val);
            return;
           }

       if(index==size){
          insertLastTail(val);
            return;
           }

        for(int i=1;i<index;i++){
            temp=temp.next;
        }

        Node node = new Node(val);
        node.next=temp.next;
        temp.next=node;

        size++;
    }

    public void insertLast(int val){
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        Node node = new Node(val);
        node.next=temp.next;
        temp.next=node;
    }


    //DELETE
    public int deleteFirst(){
        int val=Integer.MAX_VALUE;
        if(head!=null) {
             val = head.val;
            head = head.next;
        }

        if(head==null){
            tail=null;
        }
        size--;
        return val;
    }

    public int deleteLast(){

        if(size<=1){
            deleteFirst();
        }

        Node sL= getIndex(size-1);
        int val= tail.val;
        tail=sL;
        tail.next=null;

        return val;
    }

    public int deleteIndex(int index){

        if(index==0){
          return   deleteFirst();
        }

        if (index==size-1){
            return deleteLast();
        }

        Node prev = getIndex(index);
        int val= prev.next.val;
        prev.next=prev.next.next;

        return val;
    }

    private Node getIndex(int index) {

        Node temp=head;

        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }
    //SEARCH
    public int search(int val){
        Node temp=head;

        while(temp!=null){
            if(temp.val==val){
                return 1;
            }
            temp=temp.next;
        }
        return 0;
    }


    public void display(){
        Node temp=head;

        while (temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("END");

    }

    public static void main(String[] args) {
        SinglyImplem ll = new SinglyImplem();

        ll.insertFirst(5);
        ll.insertFirst(4);
        ll.insertFirst(3);
        ll.insertFirst(2);

        ll.display();
       System.out.println(ll.deleteLast());
        ll.display();
      //  System.out.println(ll.size);

    }
}
