package com.tavant.services;

import java.util.List;

import com.tavant.domain.Contact;


public interface ContactService {
	public void addContact(Contact contact);
	public void deleteContact(int id);
	public List<Contact> selectAllContacts(int userId);
	public Contact selectById(int id);
	public void updateContact(Contact contact);
		
}
