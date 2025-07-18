package com.deepakameta.jobapp.controller;

import com.deepakameta.jobapp.model.Company;
import com.deepakameta.jobapp.service.CompanyService;
import com.deepakameta.jobapp.utils.CompanyException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PostMapping
    public ResponseEntity<String> saveCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.addCompany(company));
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<String> updateCompanyById(@PathVariable("companyId") long companyId, @RequestBody Company company) {
        try {
            String result = companyService.updateCompanyById(companyId, company);
            return ResponseEntity.ok(result);
        } catch (CompanyException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable("companyId") long companyId) {
        try {
            String result = companyService.deleteCompanyById(companyId);
            return ResponseEntity.ok(result);
        } catch (CompanyException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}