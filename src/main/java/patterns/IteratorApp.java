package patterns;

public class IteratorApp {
    public static void main(String[] args) {

        Task c = new Task();
        Iterator it = c.getIterator();

        while (it.hasNext()) {
            System.out.println((String) it.next());
        }

    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}
interface Aggregate {
    Iterator getIterator();
}

/**
 * Aggregate можна змінити на Container
 */
class Task implements Aggregate {
    String[] tasks = {"Build a house", "Raise a son", "Plant a tree"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {

        int index = 0;

        @Override
        public boolean hasNext() {
            if (index < tasks.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}
