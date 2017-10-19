package com.example.aniru.publibapp.FB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aniru on 10/19/2017.
 */

public class TestData {

    List<BookDetails_FB> mBooks = new ArrayList<BookDetails_FB>();

    public List<BookDetails_FB> SetupArchiveTestData() {
        List<String> authors = new ArrayList<String>();

        BookDetails_FB bookDetail1 = new BookDetails_FB();
        bookDetail1.setTitle("Ivanhoe");
        authors.add("Sir Walter Scott");
        // bookDetail1.setAuthors(authors);
        authors.clear();
        bookDetail1.setIsbn("1");
        bookDetail1.setPageCount(100);
        mBooks.add(bookDetail1);

        BookDetails_FB bookDetail2 = new BookDetails_FB();
        bookDetail2.setTitle("The Murder of Roger Akroyd");
        authors.add("Agatha Christie");
        // bookDetail2.setAuthors(authors);
        authors.clear();
        bookDetail2.setIsbn("2");
        bookDetail2.setPageCount(200);
        mBooks.add(bookDetail2);

        BookDetails_FB bookDetail3 = new BookDetails_FB();
        bookDetail3.setTitle("C");
        authors.add("Kernighan");
        authors.add("Ritchie");
        // bookDetail3.setAuthors(authors);
        authors.clear();
        bookDetail3.setIsbn("3");
        bookDetail3.setPageCount(300);
        mBooks.add(bookDetail3);

        BookDetails_FB bookDetail4 = new BookDetails_FB();
        bookDetail4.setTitle("M");
        authors.add("Egon Jacobson");
        authors.add("Fritz Lang");
        authors.add("Thea von Harbou");
        // bookDetail4.setAuthors(authors);
        authors.clear();
        bookDetail4.setIsbn("4");
        bookDetail4.setPageCount(400);
        mBooks.add(bookDetail4);

        BookDetails_FB bookDetail5 = new BookDetails_FB();
        bookDetail5.setTitle("Mein Kampf");
        authors.add("Adolf Hitler");
        // bookDetail5.setAuthors(authors);
        authors.clear();
        bookDetail5.setIsbn("5");
        bookDetail5.setPageCount(500);
        mBooks.add(bookDetail5);

        BookDetails_FB bookDetail6 = new BookDetails_FB();
        bookDetail6.setTitle("In the shadow of freedom");
        authors.add("Laxmi Dhaul");
        // bookDetail6.setAuthors(authors);
        authors.clear();
        bookDetail6.setIsbn("6");
        bookDetail6.setPageCount(1000);
        mBooks.add(bookDetail6);
        return mBooks;
    }

    public List<BookDetails_FB> SetupFavoriteTestData() {
        List<String> authors = new ArrayList<String>();

        BookDetails_FB bookDetail1 = new BookDetails_FB();
        bookDetail1.setTitle("Ivanhoe");
        authors.add("Sir Walter Scott");
        // bookDetail1.setAuthors(authors);
        authors.clear();
        bookDetail1.setIsbn("1");
        bookDetail1.setPageCount(100);
        mBooks.add(bookDetail1);

        BookDetails_FB bookDetail2 = new BookDetails_FB();
        bookDetail2.setTitle("The Murder of Roger Akroyd");
        authors.add("Agatha Christie");
        // bookDetail2.setAuthors(authors);
        authors.clear();
        bookDetail2.setIsbn("2");
        bookDetail2.setPageCount(200);
        mBooks.add(bookDetail2);
        return mBooks;
    }

    public void Clear() {
        mBooks.clear();
    }
}
