package Stack;

import java.util.ArrayList;


public class Stack_al{
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }
        //push
        public void push(int data){
            list.add(data);
        }
        //pop
        public int pop() {
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        //peek
        public int peek() {
            return list.get(list.size()-1);
        }
    }

