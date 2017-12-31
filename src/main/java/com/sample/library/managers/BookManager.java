package com.sample.library.managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sample.library.beans.requests.BookRequestBean;
import com.sample.library.beans.responses.BookResponseBean;
import com.sample.library.daos.Book;
import com.sample.library.util.HibernateUtil;



public class BookManager {
	private final SessionFactory sessionfactory=HibernateUtil.getSessionFactory();
	
	public BookResponseBean newBook(BookRequestBean bookRequestBean){
		BookResponseBean bean=new BookResponseBean();
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionfactory.getCurrentSession();
			transaction=session.beginTransaction();
			Book book=new Book();
			book.setBookName(bookRequestBean.getBookName());
			book.setBookAuthor(bookRequestBean.getBookAuthor());
			book.setStatus("Available");
			
			session.persist(book);
			
			bean.setId(book.getBookID());
			bean.setMessage("Success");
			
			transaction.commit();
			
		}catch(RuntimeException re){
			if(transaction!=null)
			transaction.rollback();
			
		}finally{
			if(session!=null && session.isOpen())
			session.close();
		}
		return bean;
	}

	
}
