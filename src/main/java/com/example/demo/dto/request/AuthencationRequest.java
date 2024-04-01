package com.example.demo.dto.request;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthencationRequest {
    private String username;
    private String password;
}
