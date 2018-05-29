package com.celnet.restservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.celnet.entity.User;

@Service
public interface UserService {
    
    List<User> findAll();
}