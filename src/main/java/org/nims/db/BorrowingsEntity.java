package org.nims.db;

import javax.persistence.*;

@Entity
@Table(name = "borrowings")
public class BorrowingsEntity {
    @Basic
    @Column(name = "book")
    private Object book;
    @Basic
    @Column(name = "dueDate")
    private Object dueDate;
    @Basic
    @Column(name = "borrower")
    private Object borrower;
    @Id
    private Long id;

    public Object getBook() {
        return book;
    }

    public void setBook(Object book) {
        this.book = book;
    }

    public Object getDueDate() {
        return dueDate;
    }

    public void setDueDate(Object dueDate) {
        this.dueDate = dueDate;
    }

    public Object getBorrower() {
        return borrower;
    }

    public void setBorrower(Object borrower) {
        this.borrower = borrower;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
