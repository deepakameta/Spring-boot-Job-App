package com.deepakameta.jobapp.service;

import com.deepakameta.jobapp.model.Company;
import com.deepakameta.jobapp.utils.CompanyException;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    String addCompany(Company company);

    String updateCompanyById(long companyId, Company company) throws CompanyException;

    String deleteCompanyById(long companyId) throws CompanyException;
}
