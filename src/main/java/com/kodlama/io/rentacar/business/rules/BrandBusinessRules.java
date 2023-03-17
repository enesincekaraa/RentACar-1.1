package com.kodlama.io.rentacar.business.rules;


import com.kodlama.io.rentacar.core.Utilities.exceptions.BusinessException;
import com.kodlama.io.rentacar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public  void checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)){
            throw  new BusinessException("Brand name already exists");//Java exception types
        }

    }
}
