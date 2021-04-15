import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Finish implementation of queue using array
public class QueueImpl<T> {

    private final static int INITIAL_CAPACITY = 3;
    Object[] queueArr = new Object[INITIAL_CAPACITY];
    int capacity = INITIAL_CAPACITY;
    int length = -1;

//    public QueueImpl(int capacity) {
//        this.capacity = capacity;
//    }

    public void enqueue(T data) {
// System.out.println("Increased internal capacity of the Queue!");
        if (length == capacity - 1) {
            capacity += capacity;
            Object[] arr = new Object[capacity];
            for (int i = 1; i < length; i++) {
                arr[i] = queueArr[i - 1];
            }
            queueArr = arr;
        }
        for (int i = length; i > 0; i--) {
            queueArr[i] = queueArr[i - 1];
        }
        queueArr[0] = data;
        length++;
        System.out.println(data + " added to the queue");
        System.out.println(new ArrayList<Object>(Arrays.asList(queueArr)));
    }

    public T dequeue() {
        if (length == -1) {
            System.out.println("Queue is empty!! Can not dequeue element");
            return null;
        }
        System.out.println("Element removed from the queue " + queueArr[length]);
        length--;
        System.out.println(length);
        return (T) queueArr[length + 1];
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String a[]) {
        QueueImpl queue = new QueueImpl();
        queue.dequeue();
        queue.enqueue(1);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(5);
        queue.dequeue();
        queue.enqueue(6);
        queue.enqueue(7);
        queue.dequeue();
        queue.enqueue(8);
        queue.enqueue(9);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
