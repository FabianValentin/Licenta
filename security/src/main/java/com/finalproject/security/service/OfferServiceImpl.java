package com.finalproject.security.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.model.Offer;
import com.finalproject.security.repository.OfferRepository;
import com.finalproject.security.repository.UserRepository;

@Service
@Transactional
public class OfferServiceImpl implements OfferService{

	@Autowired private OfferRepository offerRepository;
	
	@Autowired private UserRepository userRepository;
	
	@Override
	public List<Offer> findAll() {
		return (List<Offer>) offerRepository.findAll();
	}

	@Override
	public Set<Offer> getOffersByUserId(Long userId) {
		if (userRepository.existsById(userId)) {
			return offerRepository.findAll().stream().filter(offer -> offer.getUser().getId().equals(userId))
					.collect(Collectors.toSet());
		}
		else {
			return null;
		}
	}

	@Override
	public Offer saveOfferForUser(Long userId, Offer offer) {
		return userRepository.findById(userId)
				.map(user -> {
					offer.setUser(user);
					return offerRepository.save(offer);
				}).orElse(null);
	}
	
	@Override
	public Offer updateOfferForUser(Long userId, Long offerId, Offer offerUpdated) {
		if(!userRepository.existsById(userId)) {
    		return null;
    	}
    	
        return offerRepository.findById(offerId)
                .map(offer -> {
                    offer.setPret(offerUpdated.getPrice());
                    offer.setQuantity(offerUpdated.getQuantity());
                    return offerRepository.save(offer);
                }).orElse(null);
	}

	@Override
	public boolean deleteOffer(Long offerId) {
   	
	/*
	 * return offerRepository.findById(offerId) .map(offer -> {
	 * offerRepository.delete(offer); return true; }).orElse(false); 
	 */
		
		
		Offer offerdb = (Offer) offerRepository.findAll().stream().filter(offer -> offer.getId().equals(offerId))
				.findFirst().orElse(null);
		offerRepository.delete(offerdb);
		if (offerRepository.existsById(offerId)) {
			return false;
		}
		return true;

	}

	@Override
	public Offer getOfferByUserId(Long offerId) {
		return (Offer)offerRepository.findAll().stream().filter(offer -> offer.getId().equals(offerId)).findFirst().orElse(null);
	}

}
