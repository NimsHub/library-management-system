package org.nims.entities;

import java.time.LocalDate;

public class Borrowings {
    private Book book;
    private LocalDate dueDate;

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBorrower() {
        return borrower;
    }

    private String borrower;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Book: " +"{ id=" + book.getId() + ", title="+ book.getTitle()+", author= "+book.getAuthor() +"}"+
                ", Due Date: " + dueDate +
                ", Borrower: " + borrower;
    }
}
