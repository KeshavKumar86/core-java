package collection;

import java.util.HashSet;

public class HashSetEx {
    public static void main(String[] args) {
        HashSet<Book> set = new HashSet<>();
        set.add(new Book(1,"Java"));
        set.add(new Book(2,"C++"));
        set.add(new Book(3,"JavaScript"));
        set.add(new Book(4,"Ruby"));
        set.add(new Book(1,"Java"));
        set.add(null);
        set.add(null);

        System.out.println(set.size());

        System.out.println(set);

        set.remove(new Book(3,"JavaScript"));
        System.out.println(set.size());
        //traverse using iterator
        for (Book book : set) {
            System.out.print(book + " ");
        }



    }
}
class Book{
    int id;
    String title;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public int hashCode(){
        return this.id;
    }
    public boolean equals(Object o){
        if(!(o instanceof Book b)){
            return false;
        }
        if(this==o) return true;
        return this.id==b.id;
    }
}
