package com.finalproject.security.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.model.Offer;
import com.finalproject.security.service.OfferService;

@RestController
@RequestMapping(value = "/")
public class OfferController {

	@Autowired private OfferService offerService;
	
	@GetMapping("offers")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<Offer>> getAllOffers(){
		List<Offer> allOffers = offerService.findAll();
		return new ResponseEntity<List<Offer>>(allOffers, HttpStatus.OK);
	}
	
	@GetMapping("user/{userId}/offers")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Set<Offer>> getOffersByUserId(@PathVariable Long userId){
		Set<Offer> userOffers = offerService.getOffersByUserId(userId);
		return new ResponseEntity<Set<Offer>>(userOffers, HttpStatus.OK);
	}
	
	@GetMapping("user/offer/{offerId}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Offer> getOfferByUserId(@PathVariable Long offerId){
		Offer userOffer = offerService.getOfferByUserId(offerId);
		return new ResponseEntity<Offer>(userOffer, HttpStatus.OK);
	}
	
	@PostMapping("user/{userId}/offers")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Offer> saveOfferForUser(@PathVariable Long userId, @RequestBody Offer offer) {
		Offer newOffer = offerService.saveOfferForUser(userId, offer);
		return new ResponseEntity<Offer>(newOffer,HttpStatus.OK);
	}
	
	@PutMapping("user/{userId}/offers/{offerId}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Offer> updateOfferForUser(@PathVariable Long userId, @PathVariable Long offerId, @RequestBody Offer offer){
		Offer updatedOffer = offerService.updateOfferForUser(userId, offerId, offer);
		return new ResponseEntity<Offer>(updatedOffer, HttpStatus.OK);
	}
	
	@DeleteMapping("user/offers/{offerId}")
	@PreAuthorize("hasRole('USER')")
	private boolean deleteOffer(@PathVariable Long offerId) {
		return offerService.deleteOffer(offerId);
	}
	
}
