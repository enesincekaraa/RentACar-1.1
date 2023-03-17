package com.kodlama.io.rentacar.business.abstracts;

import com.kodlama.io.rentacar.business.request.CreateModelRequest;
import com.kodlama.io.rentacar.business.responses.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponse> getAll();

    void add(CreateModelRequest createModelRequest);
}

