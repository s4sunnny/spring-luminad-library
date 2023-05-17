package com.sunny.Library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.Library.book.entity.Books;
import com.sunny.Library.book.service.BooksService;
import com.sunny.Library.user.entity.UserSession;

@RestController
public class BooksController {

	@Autowired
	private BooksService booksService;
	
	@GetMapping("/getBooks")
	public List<Books> getBooks(Authentication auth){
		UserSession session = (UserSession) auth.getPrincipal();
		return booksService.getBooks(session);
	}
	
	@GetMapping("/getBookById")
	public Books getBookById(Authentication auth, @RequestParam(value = "bookId") Long bookId){
		UserSession session = (UserSession) auth.getPrincipal();
		return booksService.getBookById(session, bookId);
	}
	
	@PostMapping("/addBook")
	public String addBook(Authentication auth, @RequestBody Books book) throws Exception{
		UserSession session = (UserSession) auth.getPrincipal();
		if(!session.getUserType().equalsIgnoreCase("Admin") && !session.getUserType().equalsIgnoreCase("Internal")) {
			throw new Exception("You are not Authorized to use this resource");
		}
		booksService.addBook(session, book);
		return "Books Added Successfully";
	}
	
	@PutMapping("/updateBookById")
	public String updateBook(Authentication auth, @RequestBody Books book) throws Exception{
		UserSession session = (UserSession) auth.getPrincipal();
		if(!session.getUserType().equalsIgnoreCase("Admin") && !session.getUserType().equalsIgnoreCase("Internal")) {
			throw new Exception("You are not Authorized to use this resource");
		}
		booksService.updateBook(session, book);
		return "Books Updated Successfully";
	}
	
	@GetMapping("/deleteBookById")
	public String deleteBookById(Authentication auth, @RequestParam(value = "bookId") Long bookId) throws Exception{
		UserSession session = (UserSession) auth.getPrincipal();
		if(!session.getUserType().equalsIgnoreCase("Admin")) {
			throw new Exception("You are not Authorized to use this resource");
		}
		booksService.deleteBookById(session, bookId);
		return "Book deleted successfully";
	}
	
	
}
