package com.deepakameta.jobapp.service;

import com.deepakameta.jobapp.model.Company;
import com.deepakameta.jobapp.repository.CompanyRepository;
import com.deepakameta.jobapp.utils.CompanyException;
import com.deepakameta.jobapp.utils.ReviewException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ReviewServiceImpl reviewServiceImpl;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll().stream().map(company -> {
            try {
                company.setReviews(reviewServiceImpl.getReview(company.getCompanyId()));
            } catch (ReviewException e) {
                throw new RuntimeException(e);
            }
            return company;
        }).toList();
    }

    @Override
    public String addCompany(Company company) {
        return companyRepository.save(company).getName();
    }

    @Override
    public String updateCompanyById(long companyId, Company company) throws CompanyException {
        boolean isExist = companyRepository.existsById(companyId);
        if (isExist) {
            company.setCompanyId(companyId);
            return companyRepository.save(company).toString();
        } else {
            throw new CompanyException("Company with id: " + company.getCompanyId() + "does not exist.");
        }
    }

    @Override
    public String deleteCompanyById(long companyId) throws CompanyException {
        boolean isExist = companyRepository.existsById(companyId);
        if (isExist) {
            companyRepository.deleteById(companyId);
            return "Company deleted successfully";
        } else {
            throw new CompanyException("Company with id: " + companyId + "does not exist.");
        }
    }
}
