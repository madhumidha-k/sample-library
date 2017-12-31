package com.sample.library.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sample.library.beans.requests.MemberRequestBean;
import com.sample.library.beans.responses.MemberResponseBean;
import com.sample.library.managers.MemberManager;

@Path("/member")

public class MemberResource {

	@Path("/new")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MemberResponseBean newMember(MemberRequestBean memberRequestBean){
		MemberResponseBean bean=new MemberResponseBean();
		
		try{
			MemberManager manager=new MemberManager();
			manager.newMember(memberRequestBean);
		}catch(Exception e){
			System.out.println(e);
		}
		
		return bean;
	}
}
