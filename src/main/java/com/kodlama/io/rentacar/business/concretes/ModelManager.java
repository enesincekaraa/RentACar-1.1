package com.kodlama.io.rentacar.business.concretes;

import com.kodlama.io.rentacar.business.abstracts.ModelService;
import com.kodlama.io.rentacar.business.request.CreateModelRequest;
import com.kodlama.io.rentacar.business.responses.GetAllModelResponse;
import com.kodlama.io.rentacar.core.Utilities.mappers.ModelMapperService;
import com.kodlama.io.rentacar.dataAccess.abstracts.ModelRepository;
import com.kodlama.io.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelResponse> getAll() {

        List<Model> models=modelRepository.findAll();

        List<GetAllModelResponse> modelResponses= models.stream()
                .map(model ->this.modelMapperService.forResponse()
                        .map(model,GetAllModelResponse.class)).collect(Collectors.toList());

        return modelResponses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model=this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRepository.save(model);


    }
}
