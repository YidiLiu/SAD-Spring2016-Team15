package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class RegisterObject {
    String name;
    String email;
    String password;
    String avatar;

    public RegisterObject(String name, String email, String password, String avatar){
        this.name = name;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public String getAvatar(){
        return this.avatar;
    }
}

