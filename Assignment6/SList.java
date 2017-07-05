package Assignment6;

import java.util.NoSuchElementException;

/**
 * Created by zemoso on 5/7/17.
 */
public class SList<T> {

    private Node<T> start, end; //These point to the starting and ending position of the list

    /**
     * It returns the whole list in form of string.
     *
     * @return A string containing all the elements in order.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[ ");

        Node<T> next;
        if (start != null) {
            next = start;
            str.append(next);
            next = next.next;
            while (next != null) {
                str.append(", " + next);
                next = next.next;
            }
        }

        str.append(" ]");

        return str.toString();
    }

    /**
     * It creates a new iterator and returns a reference of it.
     *
     * @return A SListIterator reference
     */
    public SListIterator<T> iterator() {
        return new Iterator();
    }

    /**
     * It represent the storage unit. It consist of a object holder and a reference to next element
     *
     * @param <T> represent an object.
     */
    private class Node<T> {
        T item;
        Node<T> next = null;

        private Node(T t) {
            item = t;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }

    /**
     * The Iterator class which implements SListIterator. SListIterator has the methods to access the list
     * which are implemented here
     */
    private class Iterator implements SListIterator<T> {

        Node<T> curr;

        /**
         * Constructor which initializes the current node to the start of the list.
         */
        private Iterator() {
            curr = start;
        }

        /**
         * This method returns the next element on the list. It does not check whether the next element
         * exists or not.
         *
         * @return the next element on the list
         */
        @Override
        public T next() {
            curr = curr.next;
            return curr.item;
        }

        /**
         * This method returns if the next element on the list is present or not.
         *
         * @return If the next element on the list is not null, then it returns true else false is returned
         */
        @Override
        public boolean hasNext() {
            if (curr.next != null) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * This method adds a Node with object t at the end of the list
         *
         * @param t The object to be added at the end of the list
         */
        @Override
        public void addItem(T t) {
            Node<T> temp = new Node<>(t);
            if (start == null) {
                start = temp;
            }
            if (end == null) {
                end = temp;
            } else {
                end.next = temp;
                end = temp;
            }
        }

        /**
         * This method is used to add an element at any position on the list.
         *
         * @param t     The element to be added
         * @param index The index at which the element is to be added
         * @throws IndexOutOfBoundsException It is thrown when the index specified is negative or greater
         *                                   than the number of elements present
         */
        @Override
        public void addItem(T t, int index) throws IndexOutOfBoundsException {
            Node<T> temp = new Node<>(t);

            if (index < 0) {
                throw new IndexOutOfBoundsException();
            } else if (index == 0) {
                temp.next = start;
                start = temp;
            } else {
                if (start == null) {
                    throw new IndexOutOfBoundsException();
                }
                Node<T> pre = start;
                for (int i = 0; i < index - 1; i++) {
                    if (pre == null) {
                        throw new IndexOutOfBoundsException();
                    }
                    pre = pre.next;
                }

                temp.next = pre.next;
                pre.next = temp;
                if (temp.next == null) {
                    end = temp;
                }
            }
        }

        /**
         * It removes an element at the specified index.
         *
         * @param index The index of the element to be removed.
         * @throws IndexOutOfBoundsException It is thrown when the index specified is negative or greater
         *                                   than the number of objects present
         */
        @Override
        public void removeIndex(int index) throws IndexOutOfBoundsException {

            if (index < 0) {
                throw new IndexOutOfBoundsException();
            } else if (index == 0) {
                start = start.next;
            } else {
                Node<T> pre = start;
                for (int i = 0; i < index - 1; i++) {
                    pre = pre.next;
                    if (pre == null) {
                        throw new IndexOutOfBoundsException();
                    }
                }
                if (pre.next != null) {
                    pre.next = pre.next.next;
                    if (pre.next == null) {
                        end = pre;
                    }
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
        }

        /**
         * It removes a specific element from the list
         *
         * @param t The element to be removed
         * @throws NoSuchElementException It is thrown when the element specified is not present in the list
         */
        @Override
        public void removeItem(T t) throws NoSuchElementException {

            if (start.item.equals(t)) {
                start = start.next;
                return;
            } else {
                Node<T> pre, curr;
                pre = start;
                curr = start.next;

                while (curr != null) {
                    if (curr.item.equals(t)) {
                        pre.next = curr.next;
                        if (pre.next == null) {
                            end = pre;
                        }
                        return;
                    }
                    pre = curr;
                    curr = curr.next;
                }
            }
            throw new NoSuchElementException();
        }

    }

}
