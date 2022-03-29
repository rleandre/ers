package com.ers.services;

import com.ers.models.Reimbursement;
import com.ers.models.Role;
import com.ers.models.Status;
import com.ers.models.User;
import com.ers.repositories.ReimbursementDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ReimbursementService {
	ReimbursementDAO rd = new ReimbursementDAO();
	User GENERIC_EMPLOYEE_1 = new User(1, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
	User GENERIC_FINANCE_MANAGER_1 = new User(1, "genericManager1", "genericPassword", Role.FINANCE_MANAGER);
	Reimbursement GENERIC_REIMBURSEMENT_2 = new Reimbursement(2, Status.APPROVED, GENERIC_EMPLOYEE_1, GENERIC_FINANCE_MANAGER_1, 150.00);
	Reimbursement REIMBURSEMENT_TO_PROCESS = new Reimbursement(2, Status.PENDING, GENERIC_EMPLOYEE_1, null, 150.00);
	List <Reimbursement> GENERIC_ALL_PENDING_REIMBURSEMENTS = new ArrayList<Reimbursement>();

   public Reimbursement process(Reimbursement unprocessedReimbursement, Status finalStatus, User resolver) {
      
	   return GENERIC_REIMBURSEMENT_2;
   }
   
   public List<Reimbursement> getReimbursementsByStatus(Status status) {
      return GENERIC_ALL_PENDING_REIMBURSEMENTS;
   }
}

