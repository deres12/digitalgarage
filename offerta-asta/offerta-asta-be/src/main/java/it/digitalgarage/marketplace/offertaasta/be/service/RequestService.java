package it.digitalgarage.marketplace.offertaasta.be.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.digitalgarage.marketplace.offertaasta.be.model.User;
import it.digitalgarage.marketplace.offertaasta.be.model.UserRequest;
import it.digitalgarage.marketplace.offertaasta.be.repository.RequestRepository;

@Service
public class RequestService implements IRequestService {
	
	@Autowired
	private RequestRepository requestRepo;
	
	public void createRequest(UserRequest request) {
		// validate data
		
		// insert data into db
	}
	
	
	public List<UserRequest> getUserRequests(User user) {
		return new ArrayList<UserRequest>();
	}
	
}