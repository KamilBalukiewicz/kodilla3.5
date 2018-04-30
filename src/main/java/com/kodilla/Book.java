package com.kodilla;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    @Override
    public int hashCode() {
        return author.substring(0,3).hashCode();
    }
    @Override
    public boolean equals(Object o) {
        Book b = (Book) o;
        return (title.equals(b.getTitle())) &&
                (author.equals(b.getAuthor()));
    }
    @Override
    public String toString() {
        return title + ", " + author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}

class SpeedTest {

    public static void main (String[] args) throws java.lang.Exception {

        LinkedList<Book> linkedListTest = new LinkedList<Book>();
        for(int n = 0; n < 8000000; n++) {
            linkedListTest.add(new Book("Title no " + n, "author no " + n));
        }
        System.out.println("Quantity of books in LinkedList: " + linkedListTest.size());
        System.out.println();

        long begin = System.nanoTime();
        linkedListTest.remove(0);
        long end = System.nanoTime();
        System.out.println("Removing first object has taken: " + (end - begin) + " ns");
        System.out.println();

        begin = System.nanoTime();
        linkedListTest.remove(linkedListTest.size()-1);
        end = System.nanoTime();
        System.out.println("Removing last object has taken: " + (end - begin) + " ns");
        System.out.println();

        begin = System.nanoTime();
        linkedListTest.add(0, new Book("x", "y"));
        end = System.nanoTime();
        System.out.println("Adding an object to the beginning of the list has taken: " + (end - begin) + " ns");
        System.out.println();

        begin = System.nanoTime();
        linkedListTest.add(linkedListTest.size(), new Book("x", "y"));
        end = System.nanoTime();
        System.out.println("Adding an object to the end of the list has taken: " + (end - begin) + "ns");
        System.out.println();

        HashMap<Integer, Book> hashMapTest = new HashMap<Integer, Book>();
        for(int k = 0; k < 6000000; k++) {
            hashMapTest.put(k,new Book("Title no " + k, "author no " + k));
        }
        System.out.println("Quantity of books in HashMap: " + hashMapTest.size());
        System.out.println();

        begin = System.nanoTime();
        hashMapTest.remove(0);
        end = System.nanoTime();
        System.out.println("Removing first object from HashMap has taken: " + (end - begin) + " ns");
        System.out.println();

        begin = System.nanoTime();
        hashMapTest.remove(hashMapTest.size()-1);
        end = System.nanoTime();
        System.out.println("Removing last object from HashMap has taken: " + (end - begin) + " ns");
        System.out.println();

        begin = System.nanoTime();
        hashMapTest.put(0, new Book("x", "y"));
        end = System.nanoTime();
        System.out.println("Adding an object to the beginning of the HashMap has taken: " + (end - begin) + " ns");
        System.out.println();

        begin = System.nanoTime();
        hashMapTest.put(hashMapTest.size()+1, new Book("x", "y"));
        end = System.nanoTime();
        System.out.println("Adding an object to the end of the HashMap has taken: " + (end - begin) + " ns");
        System.out.println(hashMapTest.size());
    }
}

