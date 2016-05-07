package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import util.AbstractJsonParser;
import util.LoginJsonParser;
import util.RegisterJsonParser;

public class JsonParserFactory{
    public static AbstractJsonParser getParser(String type){
        if(type.equals("login")){
            return new LoginJsonParser();
        }else if(type.equals("register")){
            return new RegisterJsonParser();
        }

        return null;
    }
}

