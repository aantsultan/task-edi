package com.edi.crudapi.dto;

public class UserResponseDto {

    private String userid;
    private String namalengkap;
    private String username;
    private String status;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserResponseDto(String userid, String namalengkap, String username, String status) {
        this.userid = userid;
        this.namalengkap = namalengkap;
        this.username = username;
        this.status = status;
    }

    public UserResponseDto() {
    }
}
