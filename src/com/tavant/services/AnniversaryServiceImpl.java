package com.tavant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.db.impl.AnniversaryDAO;
import com.tavant.domain.Anniversary;

@Service("anniversaryService")
public class AnniversaryServiceImpl implements AnniversaryService {
	private AnniversaryDAO anniversaryDAO;

	@Autowired
	public void setAnniversaryDAO(AnniversaryDAO anniversaryDAO) {
		this.anniversaryDAO = anniversaryDAO;
	}

	@Override
	public void addAnniversary(Anniversary anniversary) {
		anniversaryDAO.insert(anniversary);

	}
	
	@Override
	public List<Anniversary> selectAllAnniversaries(int userId){
		return anniversaryDAO.selectAllByUserId(userId);
		
	}

	@Override
	public void deleteAnniversary(Anniversary anniversary) {
		anniversaryDAO.delete(anniversary);
		
	}

	@Override
	public void editAnniversary(Anniversary anniversary) {
		anniversaryDAO.update(anniversary);
	}

	@Override
	public Anniversary getAnniversaryById(Anniversary anniversary) {
		return anniversaryDAO.selectById(anniversary);
	}

}
