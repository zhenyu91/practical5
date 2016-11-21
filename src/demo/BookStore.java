package demo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
/**
 * Created by 150436p on 11/21/2016.
 */
@Path("/books")
public class BookStore {
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<BookDetail> getBooks() {
        BookDAO dao = new BookDAO();
        List<BookDetail> books = dao.getAllBook();
        return books;
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public BookDetail getBook(@PathParam("id") String bookId) {
        System.out.println("bookId " + bookId);
        BookDAO dao = new BookDAO();
        BookDetail book = dao.getBookDetails(bookId);
        return book;
    }
}