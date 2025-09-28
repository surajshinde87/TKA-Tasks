package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Book;

public class BookDAO {

    public void addBook(Book book) {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Book.class);
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();
        
        ss.persist(book);
        System.out.println("Book Added Successfully");
        
        tr.commit();
        ss.close();
    }
    
    public Book getBookById(int bookId) {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Book.class);
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        
        Book book = ss.get(Book.class, bookId);
        ss.close();
        return book;
    }
    
    public void updateBook(Book book) {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Book.class);
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();
        
        ss.merge(book);
        
        System.out.println("Book Updated Successfully");
        
        tr.commit();
        ss.close();
    }

}
