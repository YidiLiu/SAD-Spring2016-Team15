package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import util.LoginObject;

public class LoginJsonParser extends AbstractJsonParser {
    @Override
    public LoginObject getLoginObject(JsonNode json){
		String email = json.path("email").asText();
		String password = json.path("password").asText();

        return new LoginObject(email, password);
    }

    @Override
    public RegisterObject getRegisterObject(JsonNode json){
        return null;
    }
}

