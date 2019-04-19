package com.finalproject.security.service;

import java.util.List;
import java.util.Set;

import com.finalproject.model.Offer;

public interface OfferService {
	
	List<Offer> findAll();
	
	Set<Offer> getOffersByUserId(Long userId);
	
	Offer saveOfferForUser(Long userId, Offer offer);
	
	Offer updateOfferForUser(Long userId, Long offerId, Offer offer);
	
	boolean deleteOffer(Long offerId);
	
	Offer getOfferByUserId(Long offerId);

}
