package api.webfashionstore.service.impl;

import api.webfashionstore.config.JwtUtil;
import api.webfashionstore.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUnil;

    public AuthServiceImpl(JwtUtil jwtUnil) {
        this.jwtUnil = jwtUnil;
    }


    @Override
    public String getTokenAdmin(String username, String password) {
        return jwtUnil.generateToken(username, "ROLE_ADMIN");
    }

    @Override
    public String getTokenStaff(String username, String password) {
        return jwtUnil.generateToken(username, "ROLE_STAFF");
    }

    @Override
    public String getTokenUser(String username, String password) {
        return jwtUnil.generateToken(username, "ROLE_USER");
    }
}
