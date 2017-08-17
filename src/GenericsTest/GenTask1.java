package GenericsTest;

import java.util.ArrayList;
import java.util.List;

public class GenTask1<X> {
    public static void main(String[] args) {
        GenTask1<Integer> genTask1 = new GenTask1<>();
        genTask1.test(1);
        genTask1.test1();

        List<Integer> arrInt = new ArrayList<>();
        arrInt.add(10);
        arrInt.add(5);
        arrInt.add(8);
        arrInt.add(3);
        arrInt.add(20);
        arrInt.add(45);
        arrInt.add(23);
        swap(arrInt, 0, 1);
        System.out.println(arrInt.toString());

        Library library = new Library();
        library.add(new Book());
        library.add(new Newspaper());
        System.out.println(library.get(0));

        GenericLibrary<Media> genericLibrary = new GenericLibrary<>();
        genericLibrary.add(new Book());
        genericLibrary.add(new Video());
        System.out.println(genericLibrary.get(0));

        System.out.println(find(arrInt, 1, 5));
    }

    void test(X z) {
    }

    void test1() {
    }

    static <T> void swap(List<T> m, Integer index1, Integer index2) {
        T temp;
        temp = m.get(index1);
        m.set(index1, m.get(index2));
        m.set(index2, temp);
    }

    static abstract class Media {
    }

    static class Book extends Media {
    }

    static class Video extends Media {
    }

    static class Newspaper extends Media {
    }


    static class Library {
        List<Media> mediaList = new ArrayList<>();

        void add(Media media) {
            mediaList.add(media);
        }

        Media get(Integer index) {
            return mediaList.get(index);
        }
    }

    static class GenericLibrary<T extends Media> {
        List<T> mediaList = new ArrayList<>();

        void add(T media) {
            mediaList.add(media);
        }

        T get(Integer index) {
            return mediaList.get(index);
        }
    }

    static <E extends Comparable<E>> E find(List<E> m, Integer begin, Integer end) {
        E max = m.get(begin);
        for (int i = begin + 1; i < end; i++)
            if (m.get(i).compareTo(max) > 0)
                max = m.get(i);
        return max;
    }

}
