package com.example.CRUD_Operations.repository;

import com.example.CRUD_Operations.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User,Long>{

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.email = :email WHERE u.id = :id")
    void updateEmail(@Param("id") Long id, @Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.email LIKE %:domain%")
    List<User> findUsersByEmailDomain(@Param("domain") String domain);

    @Query("SELECT COUNT(u) FROM User u")
    int findCount();


}
