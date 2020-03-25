package com.chirchir.rm.api;

import com.chirchir.rm.models.Property;
import com.chirchir.rm.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyRestController {

    private PropertyRepository repository;

    @Autowired
    public PropertyRestController(PropertyRepository repository){

        this.repository = repository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Property>> getAll(){

        return ResponseEntity.ok(repository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> findById(@PathVariable("id") Long id){

        Property property = repository.findById(id).orElse(null);

        if (property != null){
            return ResponseEntity.ok(property);
        }

        return ResponseEntity.ok(new Property());
    }
}
