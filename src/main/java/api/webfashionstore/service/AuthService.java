package api.webfashionstore.service;

import api.webfashionstore.model.Product;

import java.util.List;

public interface AuthService {

    String getTokenAdmin(String username, String password);
    String getTokenStaff(String username, String password);
    String getTokenUser(String username, String password);

}
