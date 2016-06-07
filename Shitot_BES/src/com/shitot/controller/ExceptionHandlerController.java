package com.shitot.controller;

import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shitot.exception.RestException;
import com.shitot.response.Response;

@Controller
public class ExceptionHandlerController {

    private static final Logger LOG = Logger.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(RestException.class)
    @ResponseBody
    public Map<String, Object> handleException(RestException e) {
	LOG.error("Error: " + e.getMessage(), e);
	return Response.errorResponse(e.getMessage());
    }
}