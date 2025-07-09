package com.uca.parcialfinalncapas.service;

import com.uca.parcialfinalncapas.dto.request.AuthenticationRequest;
import com.uca.parcialfinalncapas.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
}