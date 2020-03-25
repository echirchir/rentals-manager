package com.chirchir.rm.api;

import com.chirchir.rm.models.Business;
import com.chirchir.rm.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/business")
public class BusinessRestController {

    private BusinessRepository repository;

    @Autowired
    public BusinessRestController(BusinessRepository repository){

        this.repository = repository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Business>> getAll(){

        return ResponseEntity.ok(repository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Business> findById(@PathVariable("id") Long id){

        Business business = repository.findById(id).orElse(null);

        if (business != null){
            return ResponseEntity.ok(business);
        }

        return ResponseEntity.ok(new Business());
    }


}
