package at.htl.graphql.repository;

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
        bookList.add(new Book("7656789876569", "A Rose By Any Name", "Katharine Ellis", 1923, "Romance", Instant.now()));
        bookList.add(new Book("9781234567897", "Hard Gun", "Ace Peck", 2010, "Crime", Instant.now()));
        bookList.add(new Book("9781234367897", "Halcyon Dying", "Anees Thatcher", 2021, "Crime", Instant.now()));
        bookList.add(new Book("2342341233123", "Pluto Fading", "Reanna Cummings", 2019, "Sci Fi", Instant.now()));
        bookList.add(new Book("9876567887213", "Seventy and Frisky", "Ariel Obrien", 2015, "Idk", Instant.now()));
        bookList.add(new Book("4567654356721", "Scar and the Inferno", "Christine Garcia", 2017, "Fantasy", Instant.now()));
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
