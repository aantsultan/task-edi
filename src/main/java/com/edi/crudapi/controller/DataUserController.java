package com.edi.crudapi.controller;

import com.edi.crudapi.dto.UserRequestDto;
import com.edi.crudapi.service.DataUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data-user")
public class DataUserController {

    @Autowired
    DataUserService dataUserService;

    @GetMapping("/user/{id}")
    public ResponseEntity getDataUser(@PathVariable(value = "id") String userid){
        if(userid == null ? true : "ALL".equalsIgnoreCase(userid)){
            return dataUserService.getAllDataUser();
        } else {
            return dataUserService.getDetailDataUser(userid);
        }
    }

    @PostMapping("/user")
    public ResponseEntity setDataUser(@RequestBody UserRequestDto userRequestDto){
        return dataUserService.setDataUser(userRequestDto);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity delDataUser(@PathVariable(value = "id") String userid){
        return dataUserService.delDataUser(userid);
    }
}
