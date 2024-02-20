package com.infotech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.entity.Company;
import com.infotech.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{
		
		@Autowired
		CompanyRepository companyRepo;
		
		@Override
		public List<Company> getCompanies() {
			// TODO Auto-generated method stub
			return companyRepo.findAll();
		}

		@Override
		public Company getCompany(Long id) {
			// TODO Auto-generated method stub
			return companyRepo.findById(id).orElse(null);
		}

		@Override
		public boolean createCompany(Company company) {
			Company save = companyRepo.save(company);
			if(save!=null)
				return true;
			return false;
		}

		@Override
		public boolean updateCompany(Long id, Company company) {
			Optional<Company> findById = companyRepo.findById(id);
			if(findById.isPresent()){
				Company existCompany = findById.get();
				existCompany.setName(company.getName());
				existCompany.setDescription(company.getDescription());
				companyRepo.save(existCompany);	
				return true;
			}
			return false;
		}

		@Override
		public boolean deleteCompany(Long id) {
			Optional<Company> findById = companyRepo.findById(id);
			if(findById.isPresent()){
				companyRepo.deleteById(id);	
				return true;
			}
			return false;
		}
	      
	}


