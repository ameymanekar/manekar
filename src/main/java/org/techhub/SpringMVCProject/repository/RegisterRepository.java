package org.techhub.SpringMVCProject.repository;

import java.util.List;

import org.techhub.SpringMVCProject.model.Register;

public interface RegisterRepository {

	 public boolean isRegister(Register register);
	 public List<Register> getAllRecords();
}
