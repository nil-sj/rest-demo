package com.tc.rest_demo.controller;

import com.tc.rest_demo.model.CloudVendor;
import com.tc.rest_demo.repository.CloudVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    @GetMapping("all")
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        return cloudVendorRepository.findById(vendorId).get();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorRepository.deleteById(vendorId);
        return "Cloud Vendor Successfully Deleted";
    }

}
