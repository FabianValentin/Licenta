package com.finalproject.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalproject.model.Offer;


@RepositoryRestResource
@RequestMapping(value = "/api")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public interface OfferRepository extends JpaRepository<Offer, Long> {
	
	List<Offer> findByUserId(Long userId);
}