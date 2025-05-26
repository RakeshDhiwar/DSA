package LinkedList;

import java.util.HashSet;

public class PracticeQuestions {
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
        list3.addLast(10);
        list3.addLast(12);
        list3.addLast(10);
        list3.addLast(5);
        list3.addLast(4);
        list3.addLast(6);
        list3.addLast(6);
        list3.addLast(12);
        list3.addLast(12);
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
        list3.printLL();
        list3.head = PracticeQuestions.RemoveDuplicate(list3.head);
        list3.printLL();
    }
}
