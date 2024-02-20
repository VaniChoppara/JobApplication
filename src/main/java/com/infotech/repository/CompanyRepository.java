package com.infotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infotech.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
