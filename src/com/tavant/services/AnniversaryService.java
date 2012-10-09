package com.tavant.services;

import java.util.List;

import com.tavant.domain.Anniversary;

public interface AnniversaryService {
	public void addAnniversary(Anniversary anniversary);
	public List<Anniversary> selectAllAnniversaries(int userId);
	public void deleteAnniversary(Anniversary anniversary);
	public void editAnniversary(Anniversary anniversary);
	public Anniversary getAnniversaryById(Anniversary anniversary);
	
}
