package com.example.demo.controllers;

import com.example.demo.dto.request.ApiResponse;
import com.example.demo.dto.request.AuthencationRequest;
import com.example.demo.dto.request.IntrospectRequest;
import com.example.demo.dto.response.AuthenticationResponse;
import com.example.demo.dto.response.IntrospectResponse;
import com.example.demo.services.AuthencationService;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthencationController {
    @Autowired
    AuthencationService authencationService;
    @PostMapping("/token")
//    xac thuc tai khoan
//    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthencationRequest request){
//       boolean result = authencationService.authenticate(request);
//       return ApiResponse.<AuthenticationResponse>builder()
//               .result(AuthenticationResponse.builder()
//                       .authenticated(result)
//                       .build())
//               .build();
//    }


//    jwt
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthencationRequest request){
        var result = authencationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }
    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
    throws ParseException, JOSEException {
        var result = authencationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}
