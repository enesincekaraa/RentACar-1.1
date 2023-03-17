package com.kodlama.io.rentacar.business.abstracts;

import com.kodlama.io.rentacar.business.request.CreateBrandRequest;
import com.kodlama.io.rentacar.business.request.UpdateBrandRequest;
import com.kodlama.io.rentacar.business.responses.GetAllBrandsResponse;
import com.kodlama.io.rentacar.business.responses.GetByIdBrandResponse;
import com.kodlama.io.rentacar.entities.concretes.Brand;

import java.util.List;

public interface BrandServices {
    List<GetAllBrandsResponse> getAll();

    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(int id);


}
