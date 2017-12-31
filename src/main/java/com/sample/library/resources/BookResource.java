package com.sample.library.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sample.library.beans.requests.BookRequestBean;
import com.sample.library.beans.responses.BookResponseBean;
import com.sample.library.managers.BookManager;

@Path("/book")
public class BookResource {

	@Path("/new")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public BookResponseBean addBook(BookRequestBean bookRequestBean){
		BookResponseBean bean=new BookResponseBean();
		try{
			BookManager bookManager=new BookManager();
			bean=bookManager.newBook(bookRequestBean);
		}catch(Exception e){
			System.out.println(e);
		}
		
		return bean;
	}
}
