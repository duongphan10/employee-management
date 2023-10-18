package com.example.employeemanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.domain.dto.response.UserDetailsDto;
import com.example.employeemanagement.exception.NotFoundException;
import com.example.employeemanagement.security.UserPrincipal;
import com.example.employeemanagement.service.CustomUserDetailsService;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService, CustomUserDetailsService {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(
                        "sp_LoadUserByUsername", "UserDetailsMapper")
                .registerStoredProcedureParameter("username", String.class, ParameterMode.IN)
                .setParameter("username", username);
        try {
            UserDetailsDto userDetailsDto = (UserDetailsDto) query.getSingleResult();
            return UserPrincipal.create(userDetailsDto);
        } catch (NoResultException e) {
            throw new NotFoundException(ErrorMessage.User.ERR_NOT_FOUND_USERNAME, new String[]{username});
        }
    }

    @Override
    @Transactional
    public UserDetails loadUserById(Integer id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(
                        "sp_LoadUserById", "UserDetailsMapper")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .setParameter("id", id);
        try {
            UserDetailsDto userDetailsDto = (UserDetailsDto) query.getSingleResult();
            return UserPrincipal.create(userDetailsDto);
        } catch (NoResultException e) {
            throw new NotFoundException(ErrorMessage.User.ERR_NOT_FOUND_ID, new String[]{id.toString()});
        }
    }

}
