package popular;

import java.util.List;

import book.Book;

public class Popular {

    private String namePopular;
    private List<Book> books;

    public Popular(String namePopular, List<Book> books) {
        this.namePopular = namePopular;
        this.books = books;
    }

    public String getNamePopular() {
        return namePopular;
    }

    public void setNamePopular(String namePopular) {
        this.namePopular = namePopular;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
