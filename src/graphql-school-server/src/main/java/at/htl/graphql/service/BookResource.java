package at.htl.graphql.service;

import at.htl.graphql.entity.Book;
import at.htl.graphql.repository.BookRepository;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@GraphQLApi
@Path("/api/book")
@Produces(MediaType.APPLICATION_JSON)
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

    @GET
    public Response getAllBooksRest() {
        return Response.ok(bookRepository.findAll()).build();
    }

    @Mutation("saveBook")
    @Description("Saves a book")
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
