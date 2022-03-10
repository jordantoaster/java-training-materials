package iteration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CustomList implements Iterable<Integer> {
    public CustomList() {
        values = new int[]{101, 202, 303, 404, 505, 606, 707, 808, 909};
    }

    public Iterator<Integer> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<Integer> {
        public boolean hasNext() {
            return position < values.length;
        }

        public Integer next() {
            return values[position++];
        }

        public void remove() {
            //DO NOTHING...
        }

        private int position;
    }

    private int[] values;
}

public class ForEachLoop {
    public static void main(String[] args) {
        int[] array1 = {101, 202, 303, 404, 505};

        System.out.println("First collection contents are:");
        for (int i : array1) {
            System.out.println("\t" + i);
        }

        int[][] array2 = {
                {101, 202, 303, 404},
                {1001, 2002, 3003, 4004},
                {10001, 20002, 30003, 40004}
        };

        System.out.println("Second collection contents are:");
        for (int[] subarray : array2) {
            for (int i : subarray) {
                System.out.println("\t" + i);
            }
            System.out.println("\t------");
        }

        List<Integer> myList = new ArrayList<Integer>();
        myList.add(101);
        myList.add(202);
        myList.add(303);
        myList.add(404);
        myList.add(505);

        System.out.println("Third collection contents are:");
        for (int i : myList) {
            System.out.println("\t" + i);
        }

        System.out.println("Fourth collection contents are:");
        CustomList customList = new CustomList();
        for (Object obj : customList) {
            System.out.println("\t" + obj);
        }
    }
}
