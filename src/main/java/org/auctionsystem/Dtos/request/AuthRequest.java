package org.auctionsystem.Dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
    private String username;
    private String password;
    public AuthRequest() {}
}