package com.cisc181.core;

public class PersonException extends Exception {

	private Person p;
	
	public PersonException(Person p) {
		this.p=p;
	}

	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}

	

	

	
}
