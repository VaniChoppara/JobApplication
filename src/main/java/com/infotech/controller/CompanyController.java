package com.infotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.entity.Company;
import com.infotech.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@GetMapping("/companies")
	public ResponseEntity<List<Company>> getCompanyies() {
		List<Company> company = companyService.getCompanies();
		return new ResponseEntity<>(company, HttpStatus.OK);
	}

	@GetMapping("/companies/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable("id") Long id) {
		Company company = companyService.getCompany(id);
		return new ResponseEntity<>(company, HttpStatus.OK);
	}
    
	@PostMapping("/companies")
	public ResponseEntity<String> createCompany(@RequestBody Company company) {
		boolean status = companyService.createCompany(company);
		if(status)
		return  new ResponseEntity<>("Company Successfully Saved", HttpStatus.OK);
		return  new ResponseEntity<>("Problem Occured in creating the Company", HttpStatus.BAD_REQUEST);
		
	}

	@PutMapping("/companies/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
		boolean status = companyService.updateCompany(id,company);
		if(status)
		return  new ResponseEntity<>("Company Successfully Updated", HttpStatus.OK);
		return  new ResponseEntity<>("No Company Found to Update/Problem Occured in updating the Company", HttpStatus.BAD_REQUEST);
		
	}

	@DeleteMapping("/companies/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable("id") Long id) {
		boolean status = companyService.deleteCompany(id);
		if(status)
		return  new ResponseEntity<>("Company Successfully Deleted", HttpStatus.OK);
		return  new ResponseEntity<>("No Company Found to Delete/ Proble Occured while deleting", HttpStatus.BAD_REQUEST);
	}

}
