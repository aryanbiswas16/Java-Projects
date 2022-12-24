package a5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * An array-based implementation of the {@code Stack} interface.
 *
 */
public class ArrayStack implements Stack {

    // the initial capacity of the stack
    private static final int DEFAULT_CAPACITY = 16;

    // the array that stores the stack
    private String[] arr;

    // the index of the top of the stack (equal to -1 for an empty stack)
    private int top;

    /**
     * Initialize an empty stack.
     */
    public ArrayStack() {
        this.arr = new String[ArrayStack.DEFAULT_CAPACITY];
        this.top = -1;
    }
    
    public ArrayStack(ArrayStack other) {
        this.arr = Arrays.copyOf(other.arr,DEFAULT_CAPACITY);
        this.top = other.top;
    }

    public ArrayStack(Stack other) {
    	ArrayList<String> container = new ArrayList<>();
    	this.arr = new String[other.size()];
        this.top = -1;
       
        for(int x = 0; x < other.size(); x++) {
         container.add(other.pop());
        }
        for(int x = container.size(); x >= 0; x--) {
            String val = container.get(x);
            other.push(val);
            this.push(val);
        }
    }
   
    public void reverse() {
        for (int x = 0, y = this.size(); x < y; x++, y--) {
            String z = this.arr[x];
            this.arr[x] = this.arr[y];
            this.arr[y] = z;
        }
    }
    
    @Override
    public int size() {
        return this.top + 1;
    }

    @Override
    public void push(String elem) {
    	// do we need to resize the array?
        if (this.size() == this.arr.length) {
            this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
        }
        this.top++;
        this.arr[this.top] = elem;    // will throw an exception if this.top == this.arr.length
    }

    @Override
    public String pop() {
        // is the stack empty?
        if (this.isEmpty()) {
            throw new RuntimeException("popped an empty stack");
        }
        // get the element at the top of the stack as type E
        String element = this.arr[this.top];
        
        // null out the value stored in the array so that we don't keep a reference to the string
        this.arr[this.top] = null;

        // adjust the top of stack index
        this.top--;

        // return the element that was on the top of the stack
        return element;
    }

    /**
     * Returns a string representation of this stack. The elements of the stack
     * appear in the returned string in sequence starting from the top of the
     * stack to the bottom of the stack with each element separated from the
     * next using a newline character.
     * 
     * @return a string representation of this stack
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("ArrayStack:");
        if (this.size() != 0) {
            for (int i = this.size() - 1; i >= 0; i--) {
                b.append('\n');
                b.append(this.arr[i]);
            }
        }
        return b.toString();
    }
    
    
	public static void main(String[] args) {
		ArrayStack t = new ArrayStack();
		t.push("A");
		t.push("B");
		t.push("C");
		System.out.println("size: " + t.size());
		System.out.println(t);
		System.out.println();
		
		String popped = t.pop();
		System.out.println("popped: " + popped);
		System.out.println("size: " + t.size());
		System.out.println(t);
		System.out.println();
		
		popped = t.pop();
		System.out.println("popped: " + popped);
		System.out.println("size: " + t.size());
		System.out.println(t);
		System.out.println();
		
		popped = t.pop();
		System.out.println("popped: " + popped);
		System.out.println("size: " + t.size());
		System.out.println(t);
		System.out.println();
		
	}
}