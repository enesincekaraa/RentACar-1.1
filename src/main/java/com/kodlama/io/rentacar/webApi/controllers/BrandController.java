package com.kodlama.io.rentacar.webApi.controllers;

import com.kodlama.io.rentacar.business.abstracts.BrandServices;
import com.kodlama.io.rentacar.business.request.CreateBrandRequest;
import com.kodlama.io.rentacar.business.request.UpdateBrandRequest;
import com.kodlama.io.rentacar.business.responses.GetAllBrandsResponse;
import com.kodlama.io.rentacar.business.responses.GetByIdBrandResponse;
import com.kodlama.io.rentacar.entities.concretes.Brand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandController {
    private BrandServices brandServices;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return  brandServices.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return  brandServices.getById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@Valid() CreateBrandRequest createBrandRequest){
        this.brandServices.add(createBrandRequest);
    }

    @PutMapping
    public void  update(UpdateBrandRequest updateBrandRequest){
        this.brandServices.update(updateBrandRequest);

    }

    @DeleteMapping("/{id}")
    public  void delete(@PathVariable int id){
        this.brandServices.delete(id);

    }

}
