package com.springsecurity.AuthenticationAuthorization.repository;

import com.springsecurity.AuthenticationAuthorization.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
}
