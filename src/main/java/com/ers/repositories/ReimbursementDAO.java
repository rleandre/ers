package com.ers.repositories;

import com.ers.models.Reimbursement;
import com.ers.models.Role;
import com.ers.models.Status;
import com.ers.models.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReimbursementDAO {

	List <Reimbursement> GENERIC_ALL_PENDING_REIMBURSEMENTS = new ArrayList<Reimbursement>();
	User GENERIC_EMPLOYEE_1 = new User(1, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
	User GENERIC_FINANCE_MANAGER_1 = new User(1, "genericManager1", "genericPassword", Role.FINANCE_MANAGER);
	Reimbursement GENERIC_REIMBURSEMENT_1 = new Reimbursement(1, Status.PENDING, GENERIC_EMPLOYEE_1, null, 100.00);
	Reimbursement GENERIC_REIMBURSEMENT_2 = new Reimbursement(2, Status.APPROVED, GENERIC_EMPLOYEE_1, GENERIC_FINANCE_MANAGER_1, 150.00);
	Reimbursement REIMBURSEMENT_TO_PROCESS = new Reimbursement(2, Status.PENDING, GENERIC_EMPLOYEE_1, null, 150.00);
    public Optional<Reimbursement> getById(int id) {
    	try {
        	return Optional.of(GENERIC_REIMBURSEMENT_1);
    	}
    	catch(Exception e) {
    		return null;
    	}
    }
    public Optional<Reimbursement> getById1(int id) {
    	try {
        	return Optional.of(REIMBURSEMENT_TO_PROCESS);
    	}
    	catch(Exception e) {
    		return null;
    	}
    }
    public List<Reimbursement> getByStatus(Status status) {
    	try {
    		return GENERIC_ALL_PENDING_REIMBURSEMENTS;
    	}
    	catch(Exception e) {
    		return null;
    	}
    }

 
    public Reimbursement update(Reimbursement unprocessedReimbursement) {
    	try {
    		return GENERIC_REIMBURSEMENT_2;
    	}
    	catch(Exception e) {
    		return null;
    	}
    }

    public Reimbursement update1(Reimbursement unprocessedReimbursement) {
    	try {
    		return unprocessedReimbursement;
    	}
    	catch(Exception e) {
    		return null;
    	}


}
    
}
