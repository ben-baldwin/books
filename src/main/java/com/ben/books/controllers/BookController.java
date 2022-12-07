package com.ben.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ben.books.models.Book;
import com.ben.books.services.BookService;

@Controller
public class BookController {
	
//	IMPORT OUR SERVICE / DEPENDENCY INJECTION
	@Autowired
	BookService bookServ;

//		RETRIEVE ONE BOOK FROM DB
	@GetMapping("/books/{id}")
	public String showOne(
		@PathVariable("id") Long id,
		Model model
		) {
		Book oneBook = bookServ.findBook(id);
		
//		PASS THE INFORMATION TO THE JSP
		model.addAttribute("book", oneBook);
		return "show.jsp";
	}
	
    @GetMapping("/books")
    public String index(Model model) {
        List<Book> books = bookServ.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
	
}
