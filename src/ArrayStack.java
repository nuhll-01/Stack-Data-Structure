import java.util.EmptyStackException;

public class ArrayStack implements Cloneable {

    private int[] data;
    private int manyItems;

    public ArrayStack() throws OutOfMemoryError {
        final int DEFAULT_CAPACITY = 10;
        manyItems = 0;
        data = new int[DEFAULT_CAPACITY]; // Creates a new Stack with a default capacity of 10
    }

    public ArrayStack(int initialCapacity) throws IllegalArgumentException, OutOfMemoryError {
        // Validate that the capacity is not less than 0
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Invalid Capacity. " + "\nYou entered: " + initialCapacity);
        }
        manyItems = 0; // Indicates that the array does not have any elements
        data = new int[initialCapacity]; // Allocates memory for an array with a specified capacity value
    }

    public boolean search(int element) {
        if (manyItems == 0) {
            throw new EmptyStackException();
        }

        for (int i = data.length - 1; i >= 0; i--) {
            if (element == data[i]) {
                return true;
            }
        }
        return false;
    }

    public void push(int item) throws OutOfMemoryError {
        if (manyItems == data.length) {
            ensureCapacity((manyItems * 2) + 1);
        }
        data[manyItems] = item;
        manyItems++;
    }

    public int pop() {
        int answer;
        if (manyItems == 0) {
            throw new EmptyStackException();
        }
        answer = data[--manyItems];
        data[manyItems] = 0;
        return answer;
    }

    public int peek() {
        if (manyItems == 0) {
            throw new EmptyStackException();
        }
        return data[manyItems - 1]; // returns the last index of the array
    }

    @Override
    public ArrayStack clone() {
        ArrayStack answer;
        try {
            answer = (ArrayStack) super.clone();
        } catch (CloneNotSupportedException exception) {
            throw new RuntimeException("This class does not implement Cloneable.");
        }
        answer.data = data.clone();
        return answer;
    }

    private void ensureCapacity(int minimumCapacity) {
        int[] biggerArray;

        if (data.length < minimumCapacity) {
            biggerArray = new int[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }

    public void printStack() {
        for (int i = data.length - 1; i >= 0; i--) {
            System.out.println(data[i]);
        }
    }

    public void reverseStack() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public void clearStack() {
        for (int i = data.length - 1; i >= 0; i--) {
            data[i] = 0;
        }
    }

    public int getCapacity() {
        return data.length;
    }

    public int size() {
        return manyItems; // Return the number of elements within the Stack
    }

    public boolean isEmpty() {
        return data[manyItems] == 0;
    }
}
