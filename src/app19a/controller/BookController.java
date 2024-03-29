package app19a.controller;


import app19a.domain.Book;
import app19a.domain.Category;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import app19a.service.BookService;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    private static final Log logger =
            LogFactory.getLog(BookController.class);

    @RequestMapping(value = "/book_input")
    public String inputBook(Model model) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("book", new Book());
        return "BookAddForm";
    }

    @RequestMapping(value = "/book_save")
    public String saveBook(@ModelAttribute Book book) {
        Category category =
                bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.save(book);
        return "redirect:/book_list";
    }

    @RequestMapping(value = "/book_list")
    public String listBooks(Model model) {
        logger.info("book_list");
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "BookList";
    }

    @RequestMapping(value = "/book_edit/{id}")
    public String editBook(Model model, @PathVariable long id)
    {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        Book book = bookService.get(id);
        model.addAttribute("book", book);
        return "BookEditForm";
    }


    //@ModelAttribute Book book，从BookEditForm.jsp中拿到
    @RequestMapping(value = "/book_update")
    public String updateBook(@ModelAttribute Book book) {
        //根据id获取实际的category，在BookEditForm.jsp中，book.category.id与下拉框中的选项值（id）绑定了，但name值没有变化
        Category category =
                bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.update(book);
        return "redirect:/book_list";
    }

}
