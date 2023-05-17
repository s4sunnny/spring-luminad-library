package com.sunny.Library.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sunny.Library.book.entity.Books;

public interface BooksRepository extends JpaRepository<Books, Long> {

	Books findByBookId(Long bookId);

	@Modifying
	@Query(value = "delete from Books b where b.bookId=:bookId", nativeQuery = false)
	void deleteByBookId(Long bookId);


}
