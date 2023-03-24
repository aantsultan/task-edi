package com.edi.crudapi.service;

import com.edi.crudapi.dto.UserRequestDto;
import com.edi.crudapi.dto.UserResponseDto;
import com.edi.crudapi.entity.TblUserEntity;
import com.edi.crudapi.repository.DataUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DataUserServiceImpl implements DataUserService{

    @Autowired
    DataUserRepository repository;

    @Override
    public ResponseEntity getAllDataUser() {
        List<TblUserEntity> userEntityList = repository.findAllDataUser();
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for(TblUserEntity userEntity : userEntityList){
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setNamalengkap(userEntity.getNamalengkap());
            userResponseDto.setStatus(userEntity.getStatus());
            userResponseDto.setUserid(String.valueOf(userEntity.getUserid()));
            userResponseDto.setUsername(userEntity.getUsername());
            userResponseDtoList.add(userResponseDto);
        }
        return new ResponseEntity(userResponseDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getDetailDataUser(String userid) {
        TblUserEntity tblUserEntity = repository.findDetailDataUser(Integer.parseInt(userid));
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        if(tblUserEntity == null){
            return new ResponseEntity(userResponseDtoList, HttpStatus.NOT_FOUND);
        }
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUserid(String.valueOf(tblUserEntity.getUserid()));
        userResponseDto.setStatus(tblUserEntity.getStatus());
        userResponseDto.setUsername(tblUserEntity.getUsername());
        userResponseDto.setNamalengkap(tblUserEntity.getNamalengkap());
        userResponseDtoList.add(userResponseDto);
        return new ResponseEntity(userResponseDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity setDataUser(UserRequestDto userRequestDto) {
        TblUserEntity userEntity = new TblUserEntity();
        userEntity.setNamalengkap(userRequestDto.getNamalengkap());
        userEntity.setStatus(userRequestDto.getStatus());
        userEntity.setUserid(Integer.parseInt(userRequestDto.getUserid()));
        userEntity.setUsername(userRequestDto.getUsername());
        userEntity.setPassword(userRequestDto.getPassword());
        repository.save(userEntity);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity delDataUser(String userid) {
        Optional<TblUserEntity> userEntityOptional = repository.findById(Integer.parseInt(userid));
        if(userEntityOptional.isEmpty()){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        repository.delete(userEntityOptional.get());
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
