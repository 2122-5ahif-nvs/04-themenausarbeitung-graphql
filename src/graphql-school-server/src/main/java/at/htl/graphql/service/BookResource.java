package at.htl.graphql.service;


import at.htl.graphql.entity.Book;
import at.htl.graphql.repository.BookRepository;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @Query("allBooks")
    @Description("Get all Books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Query("findByTitle")
    @Description("Find a book by its title")
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Mutation("saveBook")
    @Description("Saves a book")
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
