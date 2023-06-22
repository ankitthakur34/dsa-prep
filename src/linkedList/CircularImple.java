package linkedList;

public class CircularImple {
    private Node head;
    private Node tail;

    private int size;
    public CircularImple(){
        this.size=0;
    }
    class Node{
        private int val;
        private Node next;

        public Node(int val){
            this.val=val;
        }
        public Node(int val,Node next){
            this.val=val;
            this.next=next;
        }
    }

    public void insert(int val){
        Node node = new Node(val);
         if(head==null){
             head=node;
             tail=node;
             return;
         }
         tail.next=node;
         node.next=head;
         tail=node;
    }

    public int delete(int index){
        Node temp=head;

        if(index==0){
            int val=head.val;
            head=head.next;
            tail.next=head;
            return val;
        }

        Node prev=getIndex(index);
        int val=prev.next.val;
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

    public void display(){
        Node temp=head;
        if(head==null){
            System.out.println("empty list");
            return;
        }
        if(head.next==null){
            System.out.println(head.val+"<->");
            return;
        }

        do{
            System.out.print(temp.val+"<->");
            temp=temp.next;
        } while (temp!=head);
    }

    public static void main(String[] args) {
        CircularImple cll = new CircularImple();
        cll.insert(5);
        cll.insert(6);
      cll.insert(7);
       cll.insert(8);
       cll.insert(9);
        cll.display();
        System.out.println();
        System.out.println(cll.delete(4));
      cll.display();
    }
}
