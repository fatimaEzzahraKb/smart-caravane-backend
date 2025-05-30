package com.smartcaravane.backend.controller;

import com.smartcaravane.backend.dto.JWTRequest;
import com.smartcaravane.backend.dto.JWTResponse;
import com.smartcaravane.backend.security.JwtUtil;
import com.smartcaravane.backend.service.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthenticationController {
   /* @Autowired
    private AuthenticationManager authenticationManager;

   @Autowired
    private JwtUtil jwtutil;

   @Autowired
    private MyUserDetails userDetails;

   @PostMapping("/authentication")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JWTRequest request) throws Exception{
       try{
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
           );
       }catch(BadCredentialsException e ){
           throw new Exception("Incorrect email or password",e);
       }
       final UserDetails userData = userDetails.loadUserByUsername(request.getEmail());
       final String jwt = jwtUtil.generateToken(userData);
       return ResponseEntity.ok(new JWTResponse(jwt));

   } */
}
