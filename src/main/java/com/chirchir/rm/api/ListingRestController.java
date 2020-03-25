package com.chirchir.rm.api;

import com.chirchir.rm.models.Listing;
import com.chirchir.rm.models.Property;
import com.chirchir.rm.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/listings")
public class ListingRestController {

    private ListingRepository repository;

    @Autowired
    public ListingRestController(ListingRepository repository){

        this.repository = repository;
    }

    @GetMapping("/")
    public ResponseEntity<Response<Listing>> getAll(){

        Response<Listing> response = new Response<>();
        List<Listing> listings = repository.findAll();
        response.setResults(listings);
        response.setTotal(listings.size());
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Listing>> findById(@PathVariable("id") Long id){

        Listing listing = repository.findById(id).orElse(null);
        Response<Listing> response = new Response<>();
        List<Listing> listings = new ArrayList<>();

        if (listing != null){
            listings.add(listing);
            response.setTotal(1);
            response.setResults(listings);
            return ResponseEntity.ok(response);
        }

        response.setTotal(listings.size());
        response.setResults(listings);

        return ResponseEntity.ok(response);
    }
}
