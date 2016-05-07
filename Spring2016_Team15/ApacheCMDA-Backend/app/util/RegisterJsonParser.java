package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import util.RegisterObject;
import util.AbstractJsonParser;

public class RegisterJsonParser extends AbstractJsonParser {
    @Override
    public RegisterObject getRegisterObject(JsonNode json){
        String name = json.path("username").asText();
		String email = json.path("email").asText();
		String password = json.path("password").asText();
		String avatar = json.path("avatar").asText();

        return new RegisterObject(name, email, password, avatar);
    }

    @Override
    public LoginObject getLoginObject(JsonNode json){
        return null;
    }
}

