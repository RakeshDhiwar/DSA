package LinkedList;

import java.util.HashSet;

public class PracticeQuestions {

    public static class MultilevelNode {
        int data;
        MultilevelNode next, child;

        MultilevelNode(int x) {
            data = x;
            next = null;
            child = null;
        }
    }
    //Print list
    public static void printList(SinglyLL.Node head) {
        SinglyLL.Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println(); // for newline after printing list
    }

    public static void printMList(MultilevelNode head) {
        MultilevelNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");

            // If child exists, recursively print it in parentheses
            if (temp.child != null) {
                System.out.print("[ ");
                printMList(temp.child);
                System.out.print("] ");
            }

            temp = temp.next;
        }
    }

    //Detect a Linked List
    public static SinglyLL.Node getIntersection(SinglyLL.Node head1, SinglyLL.Node head2){
        while (head2!=null){
            SinglyLL.Node temp = head1;
            while(temp!=null){
                if (temp == head2){
                    return head2;
                }
                temp=temp.next;
            }
            head2=head2.next;
        }
        return null;
    }

    //Delete N Nodes After M Nodes of a Linked List
    public static void Delete_NM(SinglyLL.Node head, int N, int M){
        SinglyLL.Node temp = head;
        //Traversing M nodes
        for (int i = 0; i < M-1; i++) {
            temp = temp.next;
        }
        //Deleting N Node
        for (int i = 0; i < N; i++) {
            temp.next = temp.next.next;
        }
    }

    //Swapping Nodes
    public static SinglyLL.Node Swapping(SinglyLL.Node head, int idx1, int idx2){
        if (idx1 == idx2) return head;

        SinglyLL.Node prevX = null, currX = head;
        for (int i = 0; currX != null && i < idx1; i++) {
            prevX = currX;
            currX = currX.next;
        }
        SinglyLL.Node prevY = null, currY = head;
        for (int i = 0; currY != null && i < idx2; i++) {
            prevY = currY;
            currY = currY.next;
        }
        if (currX == null || currY == null)
            return head;
        if (prevX != null)
            prevX.next = currY;
        else
            head = currY;
        if (prevY != null)
            prevY.next = currX;
        else
            head = currX;
        SinglyLL.Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        return head;
    }

    //Odd Even LinkedList
    public static SinglyLL.Node SegregateOddEven(SinglyLL.Node head) {
        if (head == null || head.next == null) return head;

        SinglyLL.Node end = head;
        while (end.next != null) {
            end = end.next;
        }

        SinglyLL.Node new_end = end;
        SinglyLL.Node curr = head;
        SinglyLL.Node prev = null;

        // Move initial odd nodes to end
        while (curr != null && curr != end && curr.data % 2 != 0) {
            new_end.next = curr;
            curr = curr.next;
            new_end = new_end.next;
            new_end.next = null;
            head = curr; // move head to next valid even node (or null)
        }

        // If all were odd, head will be null
        if (curr == null) return head;

        // Now head is pointing to the first even node (if any)
        head = curr;

        // Rearrange the remaining nodes
        while (curr != null && curr != end) {
            if (curr.data % 2 == 0) {
                prev = curr;
                curr = curr.next;
            } else {
                // Remove odd node and move to end
                prev.next = curr.next;
                new_end.next = curr;
                new_end = curr;
                curr = prev.next;
                new_end.next = null;
            }
        }

        // Check if the original last node is odd
        if (curr != null && curr.data % 2 != 0) {
            if (prev != null) prev.next = curr.next;
            new_end.next = curr;
            new_end = curr;
            new_end.next = null;
        }

        return head;
    }

    //Delete a node without head pointer;
    public static void delete_without_head(SinglyLL.Node deleteNode){
        if (deleteNode == null || deleteNode.next == null){
            System.out.println("Cant do! Its last node");
        }

        SinglyLL.Node Nxt = deleteNode.next; //Node next to deleteNode
        deleteNode.data = Nxt.data;          //Copy next node data to deleteNode
        deleteNode.next = Nxt.next;          //delete the next node;
        Nxt.next = null;
    }

    //Remove Duplicate from Unsorted LinkedList
    public static SinglyLL.Node RemoveDuplicate(SinglyLL.Node head) {
        HashSet<Integer> seen = new HashSet<>();
        SinglyLL.Node dummy = new SinglyLL.Node(-1);
        dummy.next = head;

        SinglyLL.Node prev = dummy;
        SinglyLL.Node curr = head;

        while (curr != null) {
            if (seen.contains(curr.data)) {
                // Duplicate found, skip it
                prev.next = curr.next;
            } else {
                // First time seeing this value
                seen.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }

    //Sorting 0s,1s, & 2s
    public static void Sort_012(SinglyLL.Node head){
        int Zeros = 0, Ones = 0, Twos = 0;
        SinglyLL.Node curr = head;

        //Track No of Zeroes Ones and Twos
        while(curr != null){
            if (curr.data == 0){
                Zeros++;
            } else if (curr.data == 1) {
                Ones++;
            } else {
                Twos++;
            }
            curr=curr.next;
        }

        curr = head;
        //Change Data to 0,1,2
        while(curr != null){
            if (Zeros > 0){
                curr.data = 0;
                Zeros--;
            } else if (Ones > 0) {
                curr.data = 1;
                Ones--;
            } else {
                curr.data = 2;
                Twos--;
            }
            curr=curr.next;
        }
    }

    public static SinglyLL.Node Sorting_012(SinglyLL.Node head){
        if(head == null || head.next == null){
            return head;
        }

        SinglyLL.Node head0 = new SinglyLL.Node(-1);
        SinglyLL.Node head1 = new SinglyLL.Node(-1);
        SinglyLL.Node head2 = new SinglyLL.Node(-1);

        SinglyLL.Node temp0 = head0;
        SinglyLL.Node temp1 = head1;
        SinglyLL.Node temp2 = head2;

        SinglyLL.Node temp = head;

        while(temp != null){
            if(temp.data == 0){
                temp0.next = temp;
                temp0 = temp;
            } else if(temp.data == 1) {
                temp1.next = temp;
                temp1 = temp;
            } else {
                temp2.next = temp;
                temp2 = temp;
            }
            temp = temp.next;
        }
        // End all sublists
        temp2.next = null;

        // Connect the three lists safely
        if (head1.next != null) {
            temp0.next = head1.next;
            temp1.next = head2.next;
        } else {
            temp0.next = head2.next;
        }

        // Determine new head
        if (head0.next != null) {
            head = head0.next;
        } else if (head1.next != null) {
            head = head1.next;
        } else {
            head = head2.next;
        }

        return head;
    }

    //Multiply two numbers represented by Linked Lists
    public static int Multiply(SinglyLL.Node head1, SinglyLL.Node head2) {
        int num1 = 0, num2 = 0;

        while (head1 != null) {
            num1 = num1 * 10 + head1.data;
            head1 = head1.next;
        }

        while (head2 != null) {
            num2 = num2 * 10 + head2.data;
            head2 = head2.next;
        }

        return num1 * num2;
    }

    //Remove-nth-node-from-end-of-list
    public SinglyLL.Node removeNthFromEnd(SinglyLL.Node head, int n) {
        if(head == null || head.next == null && n>0){
            head = null;
            return head;
        }
        SinglyLL.Node curr = head;
        int size = 0;
        while(curr!=null){
            size++;
            curr = curr.next;
        }
        int m = size-n-1;

        if(size == n){ // here m = -1, means need to delete head node
            return head.next;
        }
        curr = head;
        while(m>0){
            curr = curr.next;
            m--;
        }
        curr.next = curr.next.next;
        return head;
    }

    //Reorder List -- L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    public void reorderList(SinglyLL.Node head) {
        if (head == null) return;

        // FIND MID
        SinglyLL.Node slow = head;
        SinglyLL.Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // REVERSE SECOND HALF
        SinglyLL.Node prev = null;
        SinglyLL.Node curr = slow.next;  // Start reversing after mid
        slow.next = null;                // Cut first half from second

        while (curr != null) {
            SinglyLL.Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // REARRANGE
        SinglyLL.Node Left_head = head;
        SinglyLL.Node Right_head = prev;

        while (Right_head != null && Left_head != null) {
            SinglyLL.Node temp1 = Left_head.next;
            SinglyLL.Node temp2 = Right_head.next;

            Left_head.next = Right_head;
            Right_head.next = temp1;

            Left_head = temp1;
            Right_head = temp2;
        }
    }

    //Flatten Multilevel Linked List
    public static void flattenLL(MultilevelNode head) {
        if (head == null) return;

        MultilevelNode curr = head;
        MultilevelNode tail = head;

        // Step 1: Find the initial tail
        while (tail.next != null) {
            tail = tail.next;
        }

        // Step 2: Traverse from head to tail
        while (curr != null) {
            if (curr.child != null) {
                // Append the child list to the current tail
                tail.next = curr.child;

                // Find the new tail
                MultilevelNode temp = curr.child;
                while (temp.next != null) {
                    temp = temp.next;
                }
                tail = temp;

                // Nullify the child pointer
                curr.child = null;
            }
            curr = curr.next;
        }
    }

    //Given a Linked list head, rearrange it such that the converted list should be of the form a <= b >= c <= d >= e <= f
//    Node zigZag(Node head) {
//        // Base case - if list has 0 or 1 elemnt no zig-zag possible
//        if(head == null || head.next == null) return head;
//
//        boolean flag = true;
//        Node curr = head;
//
//        while(curr.next != null){
//            if(flag){
//                if(curr.data > curr.next.data){ // checking a < b
//                    //swap
//                    int temp = curr.data;
//                    curr.data = curr.next.data;
//                    curr.next.data = temp;
//                }
//            }else{
//                if(curr.data < curr.next.data){ // checking b > c
//                    //swap
//                    int temp = curr.data;
//                    curr.data = curr.next.data;
//                    curr.next.data = temp;
//                }
//            }
//            curr=curr.next; //move to next elemnt
//            flag = !flag;   //flip flag
//        }
//        return head;
//    }

    public static void main(String[] args) {
//        SinglyLL list1  = new SinglyLL();
//        list1.addLast(10);
//
//        SinglyLL list2  = new SinglyLL();
//        list2.addLast(3);
//        list2.addLast(6);
//        list2.addLast(9);
//        list2.addLast(15);
//
//        list2.addLast(13);
//        list1.tail.next = list2.tail;
//        list1.printLL();
//        list2.printLL();



//        Question 1
//        SinglyLL.Node intersectionPoint = PracticeQuestions.getIntersection(list1.head, list2.head);
//        if (intersectionPoint == null) {
//            System.out.print(" No Intersection Point \n");
//        }
//        else {
//            System.out.print("Intersection Point: "
//                    + intersectionPoint.data);
//        }

        SinglyLL list3 = new SinglyLL();
        list3.addLast(1);
        list3.addLast(0);
        list3.addLast(0);
//        list3.addLast(2);
        SinglyLL list4 = new SinglyLL();
        list4.addLast(1);
        list4.addLast(0);
//        list4.addLast(1);
//        list4.addLast(2);
//      Question 2
//      list3.printLL();
//      PracticeQuestions.Delete_NM(list3.head,2,2);
//      list3.printLL();

//      Question 3
//        list3.printLL();
//        list3.head = PracticeQuestions.Swapping(list3.head,0,3);
//        list3.printLL();

//      Question 4
//        list3.printLL();
//        list3.head = PracticeQuestions.SegregateOddEven(list3.head);
//        list3.printLL();
//
//      Question 5
//        SinglyLL.Node deleteNode = list3.head.next.next.next;
//        list3.printLL();
//        PracticeQuestions.delete_without_head(deleteNode);
//        list3.printLL();

//      Question 6
//        list3.printLL();
//        list3.head = PracticeQuestions.RemoveDuplicate(list3.head);
//        list3.printLL();

//      Question 7
//        list3.printLL();
//        PracticeQuestions.Sort_012(list3.head);
//        list3.printLL();
//        list3.printLL();
//        list3.head = PracticeQuestions.Sorting_012(list3.head);
//        list3.printLL();

//      Question 8
//        System.out.println(PracticeQuestions.Multiply(list3.head,list4.head));

//      Question 9
        MultilevelNode head = new MultilevelNode(1);
        head.next = new MultilevelNode(2);
        head.next.next = new MultilevelNode(3);
        head.child = new MultilevelNode(4);
        head.child.next = new MultilevelNode(5);
        head.next.next.child = new MultilevelNode(6);
        head.child.child = new MultilevelNode(7);

        printMList(head);
        PracticeQuestions.flattenLL(head);
        printMList(head);

    }
}
