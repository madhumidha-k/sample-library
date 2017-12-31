package com.sample.library.managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sample.library.beans.requests.MemberRequestBean;
import com.sample.library.beans.responses.MemberResponseBean;
import com.sample.library.daos.Member;
import com.sample.library.util.HibernateUtil;

public class MemberManager {

	private final SessionFactory sessionfactory=HibernateUtil.getSessionFactory();
	
	public MemberResponseBean newMember(MemberRequestBean memberRequestBean){
		MemberResponseBean bean=new MemberResponseBean();
		Session session=null;
		Transaction transaction=null;
		
		try{
			session=sessionfactory.getCurrentSession();
			transaction=session.beginTransaction();
			Member member=new Member();
			member.setMemberName(memberRequestBean.getMemberName());
			
			session.persist(member);
			
			bean.setMemberID(member.getMemberID());
			bean.setMemberName(member.getMemberName());
			bean.setMessage("Success");
			
		}catch(RuntimeException re){
			if(transaction!=null){
				transaction.rollback();
			}
		}finally{
			if(session!=null && session.isOpen())
				session.close();
		}
		
		return bean;
	}
}
