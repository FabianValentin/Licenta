package com.finalproject.security;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnauthorizedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3963112665306551722L;

	protected static MessageSourceAccessor message = SpringSecurityMessageSource.getAccessor();
	
	public UnauthorizedException() {
		super(message.getMessage("AbstractAcessDecisionManager.accessDenied", "Access is denied"));
	}
	
	public UnauthorizedException(String message) {
		super(message);
	}
}
