package Stack;

public class Stack {
    public static void main(String[] args) {
        Stack_al s = new Stack_al();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
