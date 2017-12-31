package com.sample.library.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sample.library.beans.requests.DistributionRequestBean;
import com.sample.library.beans.responses.DistributionResponseBean;
import com.sample.library.managers.DistributionManager;

@Path("/distribute")
public class DistributionResource {
	@Path("/book")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DistributionResponseBean distributBook(DistributionRequestBean distributionRequestBean){
		DistributionResponseBean bean=new DistributionResponseBean();
		try{
			DistributionManager manager=new DistributionManager();
			bean=manager.distributeBook(distributionRequestBean);
		}catch(Exception e){
			System.out.println(e);
		}
		return bean;
	}

}
