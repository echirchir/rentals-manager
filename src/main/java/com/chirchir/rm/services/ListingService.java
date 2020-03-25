package com.chirchir.rm.services;

import com.chirchir.rm.models.Listing;
import com.chirchir.rm.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {

    private ListingRepository repository;

    @Autowired
    public ListingService(ListingRepository repository){

        this.repository = repository;
    }

    public List<Listing> findAll(){

        return repository.findAll();
    }

    public Listing save(Listing listing){

        return repository.save(listing);
    }

    public List<Listing> findByPropertyId(Long id){

        return repository.findByPropertyId(id);
    }
}
