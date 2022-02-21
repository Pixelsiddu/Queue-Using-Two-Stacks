// Queue with two stacks. Implement a queue with two stacks so that each queue operations takes a
// constant amortized number of stack operations. Hint: If you push elements onto a stack and then 
// pop them all, they appear in reverse order. If you repeat this process, they're now back in order.
import java.io.*;
import java.util.*;

class Queue {
    private Stack<Integer> ele1;
    private Stack<Integer> ele2;
    int i;
    
    public Queue() {
        ele1 = new Stack<Integer>();
        ele2 = new Stack<Integer>();
        i =0;
    }

    // Push element x to the back of queue.
    public void enqueue(int x) {
        ele1.push(x);
    }

    // Removes the element from in front of queue.
    public int dequeue() {
        while (!ele1.empty()){
            ele2.push(ele1.pop());
        }
        i++;
        return ele2.pop();
    }
    
    // Get the front element.
    public int peek() {
        while(!ele1.empty()){
            ele2.push(ele1.pop());
        }
        return ele2.peek();
    }
    
    // Return whether the queue is empty.
    public boolean empty() {
        return (ele2.empty() && ele1.empty());
    }

    // Return the number of elements in queue.
    public int size() {
        return ele2.size() + ele1.size();        
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue queue = new Queue();
        int queries = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < queries; i++) {
            String input = scan.nextLine();
            if (input.charAt(0) == '1') {
                String[] tokens = input.split(" ");
                queue.enqueue(Integer.parseInt(tokens[1]));
            } else if (input.charAt(0) == '2') {
                queue.dequeue();
            } else if (input.charAt(0) == '3') {
                System.out.println(queue.peek());
            } 
        }
    }
}
