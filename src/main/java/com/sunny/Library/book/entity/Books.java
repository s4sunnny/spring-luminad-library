package com.sunny.Library.book.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Table(schema = "library")
@Entity
@Getter
@Setter
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;

	@Column(length = 50)
	private String title;

	@Column(length = 100)
	private String author;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate publicationDate;

	@Column(length = 30)
	private String isbn;

	private Integer noOfPages;
}
