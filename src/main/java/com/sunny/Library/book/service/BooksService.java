package com.sunny.Library.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sunny.Library.book.entity.Books;
import com.sunny.Library.book.repository.BooksRepository;
import com.sunny.Library.user.entity.UserSession;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;
	
	public List<Books> getBooks(UserSession session) {
		return booksRepository.findAll();
	}

	public Books getBookById(UserSession session, Long bookId) {
		return booksRepository.findByBookId(bookId);
	}

	public void addBook(UserSession session, Books book) {
		booksRepository.save(book);
	}

	public void updateBook(UserSession session, Books book) {
		
		booksRepository.save(book);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void deleteBookById(UserSession session, Long bookId) {
		booksRepository.deleteByBookId(bookId);
	}

}
