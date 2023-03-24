package com.edi.crudapi.repository;


import com.edi.crudapi.entity.TblUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataUserRepository extends JpaRepository<TblUserEntity, Integer> {

    @Query(
            value = "FROM tbl_user a"
    )
    List<TblUserEntity> findAllDataUser();

    @Query(
            value = "FROM tbl_user a " +
                    "WHERE a.userid = ?1"
    )
    TblUserEntity findDetailDataUser(Integer userid);
}
