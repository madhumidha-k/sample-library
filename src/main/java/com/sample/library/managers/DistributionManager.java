package com.sample.library.managers;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sample.library.beans.requests.DistributionRequestBean;
import com.sample.library.beans.responses.DistributionResponseBean;
import com.sample.library.daos.Book;
import com.sample.library.daos.Distribution;
import com.sample.library.daos.Member;
import com.sample.library.util.HibernateUtil;

public class DistributionManager {
	private final SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	
public DistributionResponseBean distributeBook(DistributionRequestBean distributionRequestBean){
	DistributionResponseBean bean=new DistributionResponseBean();
	
	Session session=null;
	Transaction transaction=null;
	try{
		session=sessionFactory.getCurrentSession();
		transaction=session.beginTransaction();
		Distribution distribution=new Distribution();
		int bookID=distributionRequestBean.getBookID();
		int memberID=distributionRequestBean.getMemberID();
		Book book=(Book)session.get("com.sample.library.daos.Book",bookID );
		
		
		if(book.getStatus().equals("Available")){
		Member member=(Member)session.get("com.sample.library.daos.Member", memberID);
		distribution.setBookID(bookID);
		distribution.setMemberID(memberID);
		Calendar calendar=Calendar.getInstance();
		String months[]={"Jan","Feb","Mar","Apr","May",
                "Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		String date=calendar.get(Calendar.DATE)+"/"+months[calendar.get(Calendar.MONTH)]+"/"+calendar.get(Calendar.YEAR);
		distribution.setDate(date);
		Calendar calendar2=calendar;
		calendar2.add(Calendar.DATE,30);
		String lastDate=calendar2.get(Calendar.DATE)+"/"+months[calendar2.get(Calendar.MONTH)]+"/"+calendar2.get(Calendar.YEAR);
		distribution.setlastDate(lastDate);
		book.setStatus("Issued");
		member.setDueBook(member.getDueBook()+1);
		bean.setBookID(bookID);
		bean.setMemberID(memberID);
		bean.setDate(date);
		bean.setLastDate(lastDate);
		bean.setMessage("Success");
		
	}
		else{
			bean.setBookID(bookID);
			bean.setMemberID(memberID);
			bean.setMessage("Book is already Issued");
		}
		session.persist(distribution);
		transaction.commit();
		}
	catch(RuntimeException re){
		if(transaction!=null)
			transaction.rollback();	
	}
	finally{
		if(session!=null && session.isOpen())
			session.close();
	}	
	return bean;
}

}
