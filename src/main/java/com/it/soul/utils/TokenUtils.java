package com.it.soul.utils;

import com.it.soul.model.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenUtils {

    private static Map<String, Customer> tokenMap = new HashMap<>();

    public static String generateToken(Customer customer){
        String token = UUID.randomUUID().toString();
        tokenMap.put(token, customer);
        return token;
    }

    public static boolean verify(String token){
        return tokenMap.containsKey(token);
    }

    public static void remove(String token){
        tokenMap.remove(token);
    }

    public static Customer getCustomer(String token){
        return tokenMap.get(token);
    }
}
