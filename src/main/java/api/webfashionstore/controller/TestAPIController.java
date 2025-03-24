package api.webfashionstore.controller;

import api.webfashionstore.dto.ApiResponse;
import api.webfashionstore.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test-api")
public class TestAPIController {

    @Autowired
    private AuthService authService;

    @PostMapping("/get-token-admin")
    public ApiResponse<Map<String, String>> getTokenAdmin(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Map<String, String> response = new HashMap<>();
        response.put("token", authService.getTokenAdmin(username, password));

        return new ApiResponse<>(response);
    }


}
