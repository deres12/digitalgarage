package it.digitalgarage.marketplace.offertaasta.be.service;

import java.util.List;

import it.digitalgarage.marketplace.offertaasta.be.model.User;
import it.digitalgarage.marketplace.offertaasta.be.model.UserRequest;


public interface IRequestService {
	public void createRequest(UserRequest request);
	public List<UserRequest> getUserRequests(User user);
}
