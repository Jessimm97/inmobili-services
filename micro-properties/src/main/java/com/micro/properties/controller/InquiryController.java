package com.micro.properties.controller;

import com.micro.properties.model.Inquiry;
import com.micro.properties.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inquiries")
public class InquiryController {

    @Autowired
    private InquiryRepository inquiryRepository;

    @PostMapping
    public ResponseEntity<Inquiry> createInquiry(@RequestBody Inquiry inquiry) {
        Inquiry savedInquiry = inquiryRepository.save(inquiry);
        return ResponseEntity.ok(savedInquiry);
    }
}