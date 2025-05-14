package LinkedList;

public class DoublyLL {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static int size;

    public void addLast(int data){
        Node newnode = new Node(data);

        if(head == null){
            head = newnode;
            size++;
           return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next = newnode;
        newnode.prev = temp;
        size++;
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head==null){
            head = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }
    public void removeLast(){
        if (head == null){
            return;
        }
        if (head.next == null){
            head = null;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.prev.next = null;
        temp.prev = null;
        size--;
    }
    public void removeFirst(){
        if (head == null){
            return;
        }
        if (head.next == null){
            head=null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }
    public void printLL(){
        System.out.print(" <--> ");
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data +" <--> ");
            temp = temp.next;
        }
    }
    public void add(int data,int index){
        Node newNode = new Node(data);
        if (head==null){
            head = newNode;
            size++;
        } else if (index==0) {
            addFirst(data);
        } else if (index==size) {
            addLast(data);
        } else {
            Node temp = head;
            for (int i = index; i > 0; i--) {
                temp = temp.next;
            }
            temp.prev.next = newNode;
            newNode.prev = temp.prev;
            temp.prev = newNode;
            newNode.next = temp;
            size++;
        }
    }
    public void remove(int index) {
        if (head == null) {
            return;
        } else if (index == 0) {
            removeFirst();
        } else if (index == size) {
            removeLast();
        } else {
            Node temp = head;
            for (int i = index; i > 0; i--) {
                temp = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            size--;
        }
    }

    public void reverse() {
        if (head == null || head.next == null){
            return;
        }
        Node current = head;
        Node temp = null;
        Node last = null;
        while(current!=null){
            // Swap current.prev & current.next
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            last = current;
            current = current.prev;
        }
        head = temp.prev;
    }

    //Additional functions to try
        //GetSize
        //Find/Search by value
        //Update node at index
        //Print forward/backward
        //Clear
        //CheckEmpty

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addLast(1);
        dll.addFirst(0);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.add(44,1);
        dll.remove(1);
        dll.printLL();
        dll.reverse();
        System.out.println();
        dll.printLL();
    }
}
