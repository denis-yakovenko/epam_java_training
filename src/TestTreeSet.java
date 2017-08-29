import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        new TestTreeSet().go();
    }

    private void go() {
        Book b1 = new Book("how cats work");
        Book b2 = new Book("remix your body");
        Book b3 = new Book("finding emo");
        Set<Book> tree = new TreeSet<>();
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        System.out.println(tree);

        Set<Book> tree1 = new TreeSet<>(new BookComparator());
        tree1.add(b1);
        tree1.add(b2);
        tree1.add(b3);
        System.out.println(tree1);
    }
}

class Book implements Comparable<Book> {
    String title;

    Book(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}

class BookComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return o1.title.compareTo(o2.title);
    }
}