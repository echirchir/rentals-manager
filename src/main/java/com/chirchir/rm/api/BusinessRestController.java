package com.chirchir.rm.api;

import com.chirchir.rm.models.Business;
import com.chirchir.rm.models.Listing;
import com.chirchir.rm.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/businesses")
public class BusinessRestController {

    private BusinessRepository repository;

    @Autowired
    public BusinessRestController(BusinessRepository repository){

        this.repository = repository;
    }

    @GetMapping("/")
    public ResponseEntity<Response<Business>> getAll(){

        Response<Business> response = new Response<>();
        List<Business> businesses = repository.findAll();
        response.setResults(businesses);
        response.setTotal(businesses.size());
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Business>> findById(@PathVariable("id") Long id){

        Business business = repository.findById(id).orElse(null);
        Response<Business> response = new Response<>();
        List<Business> businesses = new ArrayList<>();

        if (business != null){
            businesses.add(business);
            response.setTotal(1);
            response.setResults(businesses);
            return ResponseEntity.ok(response);
        }

        response.setTotal(businesses.size());
        response.setResults(businesses);
        return ResponseEntity.ok(response);
    }


}
