package LinkedList;

public class LL1 {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;
    //Methods

    //Add First
    public void addFirst(int data) {
        //create new node
        Node newnode = new Node(data);

        if(head == null){
            head = tail = newnode;
            return;
        }



        //newnode next = head
        newnode.next = head;

        //head = newnode
        head = newnode;
    }

    //Add last
    public void addLast(int data) {
        //create new node
        Node newnode = new Node(data);

        if(head == null){
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;
    }

    //Print LL
    public void printLL() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //Add in the Middle
    public void Add(int data,int idx){
        Node newnode = new Node(data);

    }
    public static void main(String[] args) {
        LL1 ll = new LL1();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.printLL();
        ll.addLast(4);
        ll.printLL();
    }
}
