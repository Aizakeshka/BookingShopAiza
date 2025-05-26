package com.example.bookingshopaiza.service;

import com.example.bookingshopaiza.dto.JwtAuthResponse;
import com.example.bookingshopaiza.dto.LoginDto;
import com.example.bookingshopaiza.dto.RegisterDto;
import com.example.bookingshopaiza.security.JwtService;
import com.example.bookingshopaiza.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtService jwtService,
            PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public JwtAuthResponse register(RegisterDto registerDto) {
        // Здесь должна быть логика регистрации пользователя
        // Пока просто возвращаем токен для примера
        UserDetails userDetails = userDetailsService.loadUserByUsername(registerDto.getEmail());
        String jwtToken = jwtService.generateToken(userDetails);
        return new JwtAuthResponse(jwtToken);
    }

    @Override
    public JwtAuthResponse login(LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getEmail());
        String jwtToken = jwtService.generateToken(userDetails);
        return new JwtAuthResponse(jwtToken);
    }
}