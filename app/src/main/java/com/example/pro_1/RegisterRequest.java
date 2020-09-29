package com.example.pro_1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://";
    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPassword, String userGender, String userLive, String userMBTI, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID",userID);
        parameters.put("userPassword",userPassword);
        parameters.put("userGender",userGender);
        parameters.put("userLive",userLive);
        parameters.put("userMBTI",userMBTI);
    }
}
