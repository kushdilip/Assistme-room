package com.tavant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.db.impl.ContactDAO;
import com.tavant.domain.Contact;

@Service("contactService")
public class ContactServiceImpl implements ContactService {
	private ContactDAO contactDAO;
	
	@Autowired
	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}


	@Override
	public void deleteContact(int id) {
		// TODO Auto-generated method stub
		contactDAO.delete(id);
//		System.out.println(contactName + " User deleted successfully");
	}


	@Override
	public void addContact(Contact contact) {
		// TODO Auto-generated method stub
		contactDAO.insert(contact);
//		System.out.println(contact + " added successfully");
	}
	
	@Override
	public List<Contact> selectAllContacts(int userId){
		return contactDAO.selectAll(userId);
	}
	
	@Override
	public Contact selectById(int id){
		return contactDAO.selectById(id);
	}

	@Override
	public void updateContact(Contact contact){
		contactDAO.update(contact);
	}

}
