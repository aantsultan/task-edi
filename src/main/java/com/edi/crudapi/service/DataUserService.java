package com.edi.crudapi.service;

import com.edi.crudapi.dto.UserRequestDto;
import org.springframework.http.ResponseEntity;

public interface DataUserService {
    ResponseEntity getAllDataUser();

    ResponseEntity getDetailDataUser(String userid);

    ResponseEntity setDataUser(UserRequestDto userRequestDto);

    ResponseEntity delDataUser(String userid);
}
