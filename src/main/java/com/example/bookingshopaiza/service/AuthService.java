package com.example.bookingshopaiza.service;

import com.example.bookingshopaiza.dto.JwtAuthResponse;
import com.example.bookingshopaiza.dto.LoginDto;
import com.example.bookingshopaiza.dto.RegisterDto;

public interface AuthService {
    JwtAuthResponse register(RegisterDto registerDto);
    JwtAuthResponse login(LoginDto loginDto);
}