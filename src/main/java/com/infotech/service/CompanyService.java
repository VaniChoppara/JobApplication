package com.infotech.service;

import java.util.List;

import com.infotech.entity.Company;

public interface CompanyService {
	 List<Company> getCompanies();
	 Company getCompany(Long id);
	 boolean createCompany(Company company);
	 boolean updateCompany(Long id, Company company);
	 boolean deleteCompany(Long id);
}
