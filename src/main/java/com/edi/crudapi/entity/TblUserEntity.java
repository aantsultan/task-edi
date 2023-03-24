package com.edi.crudapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "tbl_user")
public class TblUserEntity {

    @Id
    private Integer userid;
    private String namalengkap;
    private String username;
    private String password;
    private String status;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TblUserEntity(Integer userid, String namalengkap, String username, String status) {
        this.userid = userid;
        this.namalengkap = namalengkap;
        this.username = username;
        this.status = status;
    }

    public TblUserEntity() {
    }
}
