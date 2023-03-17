package com.kodlama.io.rentacar.business.concretes;

import com.kodlama.io.rentacar.business.abstracts.BrandServices;
import com.kodlama.io.rentacar.business.request.CreateBrandRequest;
import com.kodlama.io.rentacar.business.request.UpdateBrandRequest;
import com.kodlama.io.rentacar.business.responses.GetAllBrandsResponse;
import com.kodlama.io.rentacar.business.responses.GetByIdBrandResponse;
import com.kodlama.io.rentacar.business.rules.BrandBusinessRules;
import com.kodlama.io.rentacar.core.Utilities.mappers.ModelMapperService;
import com.kodlama.io.rentacar.dataAccess.abstracts.BrandRepository;
import com.kodlama.io.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandServices {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    private BrandBusinessRules businessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands=brandRepository.findAll();

        List<GetAllBrandsResponse> brandsResponses= brands.stream().map(brand -> this.modelMapperService.forResponse()
                .map(brand,GetAllBrandsResponse.class))
                .collect(Collectors.toList());


        return brandsResponses ;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
       Brand brand= this.brandRepository.findById(id).orElseThrow();

       GetByIdBrandResponse response=this.modelMapperService.forResponse()
               .map(brand,GetByIdBrandResponse.class);
       return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.businessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);

    }
}
