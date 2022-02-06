package at.htl.graphql.repository;

import at.htl.graphql.entity.Author;
import at.htl.graphql.entity.Book;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.time.Instant;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class BookRepository {
    protected List<Book> bookList = new LinkedList<>();

    @PostConstruct
    protected void init() {
        bookList.add(new Book("7656789876569", "A Rose By Any Name", new Author("Katharine Ellis", 31), 1923, "Romance", Instant.now()));
        bookList.add(new Book("9781234567897", "Hard Gun", new Author("Ace Peck", 32), 2010, "Crime", Instant.now()));
        bookList.add(new Book("9781234367897", "Halcyon Dying", new Author("Anees Thatcher", 33), 2021, "Crime", Instant.now()));
        bookList.add(new Book("2342341233123", "Pluto Fading", new Author("Reanna Cummings", 34), 2019, "Sci Fi", Instant.now()));
        bookList.add(new Book("9876567887213", "Seventy and Frisky", new Author("Ariel Obrien", 35), 2015, "Idk", Instant.now()));
        bookList.add(new Book("4567654356721", "Scar and the Inferno", new Author("Christine Garcia", 103), 2017, "Fantasy", Instant.now()));
    }

    public List<Book> findAll() {
        return Collections.unmodifiableList(bookList);
    }

    public Book save(Book book) {
        bookList.add(book);
        return book;
    }

    public Book findByTitle(String title) {
        return bookList.stream().filter(b -> b.title.equalsIgnoreCase(title)).findFirst().orElse(null);
    }
}
