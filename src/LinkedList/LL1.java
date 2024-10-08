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
       temp.next = temp.next.next;
    }
    public int itrsearch(int key) {
        Node temp = head;
        int i=0;

        while(temp != null){
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public int helper(Node head, int key){
        if(head == null) {
            return -1;
        }

        if(head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        }
        return idx + 1;
    }
    public int recSearch(int key) {
        return helper(head,key);
    }

    public void reverse(){
        Node curr = tail = head;
        Node prev = null;
        Node next ;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //Remove nth node from end
    public void removenthEnd(int n){
        remove(size-n-1-1);
    }


    //slow fast approach
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome() {
        if(head == null || head.next == null){
            return true;
        }

        //step1 - find mid
        Node midNode = findMid(head);
        //step2- reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;//right half head
        Node left = head;
        //step3- match left and right half
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
//        LL1 ll = new LL1();
//        ll.addFirst(1);
//        ll.addFirst(2);
//        ll.addLast(3);
//        ll.printLL();
//        ll.addLast(4);
//        ll.printLL();
//        ll.Add(100,2);
//        ll.printLL();
//        System.out.println(ll.size);
//        ll.removeFirst();
//        ll.printLL();
//        ll.removeLast();
//        ll.printLL();
//        ll.addLast(4);
//        ll.addLast(5);
//        ll.remove(2);
//        ll.printLL();
//        ll.remove(1);
//        ll.Add(2,1);
//        ll.Add(3,2);
//        ll.printLL();
//        System.out.println(ll.itrsearch(3));
//        System.out.println(ll.recSearch(4));
//        System.out.println(ll.recSearch(23));
//        ll.reverse();
//        ll.printLL();
//        ll.removenthEnd(3);
//        ll.printLL();


        LL1 ll = new LL1();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(4);

        ll.printLL();
        System.out.println(ll.checkPalindrome());

    }
}
