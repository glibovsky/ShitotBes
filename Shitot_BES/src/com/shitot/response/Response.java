package com.shitot.response;

import java.util.*;

public class Response {

	public static Map<String, Object> successResponse(Object object) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("result", "success");
		response.put("data", object);
		return response;
	}

	public static Map<String, Object> emptyResponse() {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("result", "success");
		return response;
	}

	public static Map<String, Object> errorResponse(String errorMessage) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("result", "error");
		response.put("message", errorMessage);
		return response;
	}
}
