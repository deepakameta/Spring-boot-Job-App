package com.deepakameta.jobapp.service;

import com.deepakameta.jobapp.model.Review;
import com.deepakameta.jobapp.repository.CompanyRepository;
import com.deepakameta.jobapp.repository.ReviewRepository;
import com.deepakameta.jobapp.utils.ReviewException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;


    @Override
    public List<Review> getReview(long companyId) throws ReviewException {
        boolean doesCompanyExist = companyRepository.existsById(companyId);
        if (doesCompanyExist) {
            return reviewRepository.findAll();
        } else {
            throw new ReviewException("Company Not Found");
        }
    }

    @Override
    public String addReview(long companyId, Review review) throws ReviewException {
        boolean doesCompanyExist = companyRepository.existsById(companyId);
        if (doesCompanyExist) {
            return reviewRepository.save(review).toString();
        } else {
            throw new ReviewException("Company Not Found");
        }
    }

    @Override
    public String updateReviewById(long companyId, long reviewId, Review review) throws ReviewException {
        boolean doesCompanyExist = companyRepository.existsById(companyId);
        if (doesCompanyExist) {
            boolean isReviewExists = reviewRepository.existsById(reviewId);
            if (isReviewExists) {
                review.setReviewId(reviewId);
                reviewRepository.save(review);
                return "Review Updated Successfully";
            } else {
                throw new ReviewException("Review Not Found");
            }
        } else {
            throw new ReviewException("Company Not Found");
        }
    }

    @Override
    public String deleteReviewById(long companyId, long reviewId) throws ReviewException {
        boolean doesCompanyExist = companyRepository.existsById(companyId);
        if (doesCompanyExist) {
            boolean isReviewExists = reviewRepository.existsById(reviewId);
            if (isReviewExists) {
                reviewRepository.deleteById(reviewId);
                return "Review Deleted Successfully";
            } else {
                throw new ReviewException("Review Not Found");
            }
        } else {
            throw new ReviewException("Company Not Found");
        }
    }
}