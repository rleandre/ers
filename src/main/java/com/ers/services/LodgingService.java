package com.ers.services;
import java.util.List;

import com.ers.models.Lodging;
import com.ers.repositories.LodgingDAO;

public class LodgingService {
	
	LodgingDAO lDAO = new LodgingDAO();//So that I can use the method sform the employeeDAO

	public List<Lodging> getLodging() throws Exception {
		List<Lodging> result = lDAO.getLodging();
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public List<Lodging> getSingleLodging() throws Exception {
		List<Lodging> result = lDAO.getSingleLodging();
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public List<Lodging> getEmployeeLodging(int e_id) throws Exception {
		List<Lodging> result = lDAO.getEmployeeLodging(e_id);
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public void submitLodging(Lodging newLodging) throws Exception {
		int result = lDAO.submitLodging(newLodging);
		if(result == 0) {
			throw new Exception();
		}
	}	
	public void updateLodgingStatus(Lodging Lodging) throws Exception {
		int result = lDAO.updateLodgingStatus(Lodging);
		if(result == 0) {
			throw new Exception();
		}
	}
	public void updateLodgingStatus(int decision, int lodging_id) throws Exception {
		int result = lDAO.updateLodgingStatus(decision, lodging_id);
		if(result == 0) {
			throw new Exception();
		}
	}
}
