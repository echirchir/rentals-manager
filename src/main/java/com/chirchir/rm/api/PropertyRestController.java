package com.chirchir.rm.api;

import com.chirchir.rm.models.Business;
import com.chirchir.rm.models.Property;
import com.chirchir.rm.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyRestController {

    private PropertyRepository repository;

    @Autowired
    public PropertyRestController(PropertyRepository repository){

        this.repository = repository;
    }

    @GetMapping("/")
    public ResponseEntity<Response<Property>> getAll(){

        Response<Property> response = new Response<>();
        List<Property> properties = repository.findAll();
        response.setResults(properties);
        response.setTotal(properties.size());
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Property>> findById(@PathVariable("id") Long id){

        Property property = repository.findById(id).orElse(null);
        Response<Property> response = new Response<>();
        List<Property> properties = new ArrayList<>();

        if (property != null){
            properties.add(property);
            response.setTotal(1);
            response.setResults(properties);
            return ResponseEntity.ok(response);
        }

        response.setTotal(properties.size());
        response.setResults(properties);

        return ResponseEntity.ok(response);
    }
}
