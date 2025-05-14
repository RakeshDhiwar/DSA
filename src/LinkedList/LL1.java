package LinkedList;
import java.util.LinkedList;

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
        Node prev = null;
        Node curr = tail = head;
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
    public static Node findMid(Node head) {
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

    public boolean iscycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    public void removeCycle() {
        Node slow = head;
        Node fast = head;

        boolean cycle = false;

        while (fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                cycle = true;
                break;
            }
        }
        if (!cycle) return;

        slow = head;
        // Special case: loop starts at head
        if (slow == fast) {
            // Find last node in the cycle
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null; // Break the loop
            return;
        }

        // General case: loop doesn't start at head
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null; // Break the loop

    }

    public  Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public  Node merge(Node a, Node b){
        Node mergeList = new Node(-1);
        Node temp = mergeList;
        while(a != null && b!=null){
            if (a.data <= b.data){
                temp.next=a;
                a=a.next;
                temp=temp.next;
            }else {
                temp.next=b;
                b=b.next;
                temp=temp.next;
            }
        }
        while (a!=null){
            temp.next=a;
            a=a.next;
            temp=temp.next;
        }
        while (b!=null){
            temp.next=b;
            b=b.next;
            temp=temp.next;
        }
        return mergeList.next;
    }

    public  Node mergeSort(Node head) {
        //Base case
        if(head == null || head.next == null){
            return head;
        }

        //find mid
        Node mid = getMid(head);

        //left & right half recursive call
        Node right = mid.next;
        mid.next = null;

        Node lefthalf = mergeSort(head);
        Node righthalf = mergeSort(right);

        //Merge sorted parts
        Node mergedList = merge(lefthalf,righthalf);
        return mergedList;
    }

    public void zigzag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse second half
        Node curr = mid.next;
        Node prev = null;
        Node next;
        mid.next = null; //separating in 1st & 2nd Half

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL,nextR;

        //alt-merge || zig-zag-merge
        while(left != null && right != null) {
            nextL = left.next;
            left.next = right;

            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
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


//        LL1 ll = new LL1();
//        ll.addLast(1);
//        ll.addLast(2);
//        ll.addLast(3);
//        ll.addLast(4);
//        ll.addLast(5);

        //Making a Linked List Cycle
//        Node temp = ll.head;
//        while (temp.next != null){
//            temp = temp.next;
//        }
//        temp.next = ll.head;



//        System.out.println(ll.iscycle());
//        ll.removeCycle();
//        System.out.println(ll.iscycle());
//        ll.printLL();
//        LL1 ll = new LL1();
//                ll.addLast(4);
//                ll.addLast(2);
//                ll.addLast(5);
//                ll.addLast(3);
//                ll.addLast(1);
//        ll.printLL();
//    ll.head = ll.mergeSort(ll.head);
//    ll.printLL();

        LL1 ll = new LL1();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.printLL();
        ll.zigzag();
        ll.printLL();
    }
}
