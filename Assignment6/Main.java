package Assignment6;

/**
 * Created by zemoso on 5/7/17.
 */
public class Main {

    public static void main(String args[]) {
        SList<Integer> list = new SList<>();

        SListIterator<Integer> iterator = list.iterator();

        System.out.println(list);

        iterator.addItem(1);
        System.out.println(list);

        iterator.addItem(2, 1);
        System.out.println(list);

        iterator.addItem(6);
        System.out.println(list);

        iterator.addItem(3, 0);
        System.out.println(list);

        iterator.addItem(4, 2);
        System.out.println(list);

        iterator.addItem(5);
        System.out.println(list);

        iterator.removeItem(3);
        System.out.println(list);

        iterator.removeIndex(2);
        System.out.println(list);

        iterator.removeItem(5);
        System.out.println(list);

        iterator.removeIndex(1);
        System.out.println(list);

        iterator.removeItem(1);
        System.out.println(list);

        iterator.removeIndex(0);
        System.out.println(list);

        iterator.addItem(5, 0);
        System.out.println(list);

    }
}
