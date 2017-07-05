package Assignment6;

import java.util.NoSuchElementException;

/**
 * Created by zemoso on 5/7/17.
 */

/**
 * The Interface which is used to store the reference of the iterator returned by SList.
 * @param <T> The object type used
 */
public interface SListIterator<T> {

    void addItem(T t);

    void addItem(T t, int index) throws IndexOutOfBoundsException;

    void removeIndex(int index) throws IndexOutOfBoundsException;

    void removeItem(T t) throws NoSuchElementException;

    boolean hasNext();

    T next();
}
