package controller;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.book.IBookService;

import javax.persistence.NamedQuery;
import javax.transaction.SystemException;
import java.sql.Date;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/{id}")
    public void getBook(@PathVariable int id) {
        System.out.println(bookService.getById(id).getName());
    }

    @GetMapping("/save")
    public ModelAndView saveNewBook() {
        Book book = new Book("y", "s11", "harry", true, 100, 10, Date.valueOf("1999-03-25"));
        try {
            bookService.add(book);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        /*System.out.println(bookService.add(book));*/
        return new ModelAndView("index");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView removeBook(@PathVariable int id) {
        bookService.remove(id);
        return new ModelAndView("index");
    }

    @GetMapping("/all")
    public ModelAndView getAllBook() {
        System.out.println(bookService.getAll().size());
        return new ModelAndView("index");
    }

    @GetMapping("/by-name/{name}")
    public ModelAndView getByName(@PathVariable String name) {
        System.out.println(bookService.getByName(name).size());
        return new ModelAndView("index");
    }
}
