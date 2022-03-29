package com.ers.services;

import java.util.List;

import com.ers.models.Misc;
import com.ers.repositories.MiscDAO;

public class MiscService {
	MiscDAO mDAO = new MiscDAO();//So that I can use the method sform the employeeDAO

	public List<Misc> getMisc() throws Exception {
		List<Misc> result = mDAO.getMisc();
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public List<Misc> getSingleMisc() throws Exception {
		List<Misc> result = mDAO.getSingleMisc();
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public List<Misc> getEmployeeMisc(int e_id) throws Exception {
		List<Misc> result = mDAO.getEmployeeMisc(e_id);
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public void submitMisc(Misc newMisc) throws Exception {
		int result = mDAO.submitMisc(newMisc);
		if(result == 0) {
			throw new Exception();
		}
	}	
	public void updateMiscStatus(Misc Misc) throws Exception {
		int result = mDAO.updateMiscStatus(Misc);
		if(result == 0) {
			throw new Exception();
		}
	}
	public void updateMiscStatus(int decision, int misc_id) throws Exception {
		int result = mDAO.updateMiscStatus(decision, misc_id);
		if(result == 0) {
			throw new Exception();
		}
	}
}
