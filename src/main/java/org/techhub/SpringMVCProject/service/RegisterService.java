package org.techhub.SpringMVCProject.service;

import java.util.List;

import org.techhub.SpringMVCProject.model.Register;

public interface RegisterService {

	 public boolean isRegister(Register register);
	 public List<Register> getAllRecords();
		
}
