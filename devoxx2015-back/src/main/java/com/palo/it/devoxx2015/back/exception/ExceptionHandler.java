package com.palo.it.devoxx2015.back.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    // =========================================================================
    // OVERRIDES
    // =========================================================================

    @Override
    public Response toResponse(Exception _exception) {

        Response response = null;

        if (_exception instanceof WebApplicationException) {
            response = ((WebApplicationException) _exception).getResponse();
        } else {
            Status status = Status.METHOD_NOT_ALLOWED;

            response = Response.status(status.getStatusCode()).build();
        }

        return response;
    }
}