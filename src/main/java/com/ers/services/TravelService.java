package com.ers.services;
import java.util.List;

import com.ers.models.Travel;
import com.ers.repositories.TravelDAO;

public class TravelService {
	TravelDAO tDAO = new TravelDAO();//So that I can use the method sform the employeeDAO

	public List<Travel> getTravel() throws Exception {
		List<Travel> result = tDAO.getTravel();
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public List<Travel> getSingleTravel() throws Exception {
		List<Travel> result = tDAO.getSingleTravel();
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public List<Travel> getEmployeeTravel(int e_id) throws Exception {
		List<Travel> result = tDAO.getEmployeeTravel(e_id);
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public void submitTravel(Travel newTravel) throws Exception {
		int result = tDAO.submitTravel(newTravel);
		if(result == 0 ) {
			throw new Exception();
		}
	}
	public void updateTravelStatus(Travel Travel) throws Exception {
		int result = tDAO.updateTravelStatus(Travel);
		if(result == 0 ) {
			throw new Exception();
		}
	}
	public void updateTravelStatus(int decision, int travel_id) throws Exception {
		int result = tDAO.updateTravelStatus(decision, travel_id);
		if(result == 0 ) {
			throw new Exception();
		}	
	}
	
}
