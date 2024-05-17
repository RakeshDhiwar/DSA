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

    public static int size;
    //Methods

    //Add First
    public void addFirst(int data) {
        //create new node
        Node newnode = new Node(data);
        size++;

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
        size++;

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
        if(idx == 0) {
            addFirst(data);
        }
        Node newnode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next = newnode;
    }

    public int removeFirst(){
        if (size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    
    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev: size-2;
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data; //tail data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public void remove(int idx){
        if(idx == 0) {
            removeFirst();
        } else if (idx == size-1) {
            removeLast();
        }
        Node temp = head;
        int i=0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        Node temp1 = temp.next;
        Node temp2 = temp1.next;
        temp.next = temp2;
        temp1.next = null;
    }


    public static void main(String[] args) {
        LL1 ll = new LL1();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.printLL();
        ll.addLast(4);
        ll.printLL();
        ll.Add(100,2);
        ll.printLL();
        System.out.println(ll.size);
        ll.removeFirst();
        ll.printLL();
        ll.removeLast();
        ll.printLL();
        ll.addLast(4);
        ll.addLast(5);
        ll.remove(2);
        ll.printLL();
        ll.remove(1);
        ll.Add(2,1);
        ll.Add(3,2);
        ll.printLL();
//        System.out.println(ll.itrsearch(3));

    }
}
