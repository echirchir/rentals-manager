package com.chirchir.rm.api;

import com.chirchir.rm.models.Listing;
import com.chirchir.rm.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/listings")
public class ListingRestController {

    private ListingRepository repository;

    @Autowired
    public ListingRestController(ListingRepository repository){

        this.repository = repository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Listing>> getAll(){

        return ResponseEntity.ok(repository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Listing> findById(@PathVariable("id") Long id){

        Listing listing = repository.findById(id).orElse(null);

        if (listing != null){
            return ResponseEntity.ok(listing);
        }

        return ResponseEntity.ok(new Listing());
    }
}
