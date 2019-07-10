package app19a.service;

import app19a.domain.Book;
import app19a.domain.Category;

import java.util.List;

public interface BookService {
    List<Category> getAllCategories();
    Category getCategory(int id);
    List<Book> getAllBooks();
    Book save(Book book);
    Book update(Book book);
    Book get(long id);
    long getNextId();
}
