package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import util.LoginObject;
import util.RegisterObject;

public abstract class AbstractJsonParser {
    public abstract LoginObject getLoginObject(JsonNode json);
    public abstract RegisterObject getRegisterObject(JsonNode json);
}

