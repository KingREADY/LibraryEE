package com.github.kingready.library.model;

import com.github.kingready.library.model.enumeration.BookType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "LIB_BOOK")
public class Book implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3)
    private String title;
    @NotNull
    @Size(min = 3)
    private String author;

    @NotNull
    @Enumerated
    BookType bookType;

    public Book() {
    }

    public Book(String title, String author, BookType bookType) {
        this.title = title;
        this.author = author;
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", bookType=" + bookType +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
