package com.nm.rest.resource;

import com.nm.rest.constants.RespConstants;
import com.nm.rest.response.builder.JSONResponseBuilder;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.interception.PostProcessInterceptor;
import  com.nm.rest.response.generic.GenericErrorResponse;
import  com.nm.rest.response.generic.AbstractBaseResponse;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by adlakhavaibhav on 20/11/14.
 */
@Provider
@ServerInterceptor
public class ResponseFormatterInterceptor implements PostProcessInterceptor {

    private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    private static final String CONTENT_TYPE_JSON = "application/json";


    @Override
    public void postProcess(ServerResponse serverResponse) {


        Long startTime = System.currentTimeMillis();
        Object responseEntity = serverResponse.getEntity();
        setContentTypeHeader(serverResponse);
        String response;

        if (responseEntity == null) {
            GenericErrorResponse nullErrorResponse = new GenericErrorResponse();


            nullErrorResponse.setException(true);
            nullErrorResponse.addMessage("You must be out of your mind. Response from API cannot be null...Go fix this ");
            response = new JSONResponseBuilder().addField(RespConstants.RESULTS, nullErrorResponse).buildAsString();
            serverResponse.setStatus(ServerResponse.Status.OK.getStatusCode());
        } else if (!(responseEntity instanceof AbstractBaseResponse)) {
            GenericErrorResponse genericErrorResponse = new GenericErrorResponse();
            genericErrorResponse.setException(true);
            genericErrorResponse.addMessage("Response from API is not in correct format. Check you extend superclass");

            response = new JSONResponseBuilder().addField(RespConstants.RESULTS, genericErrorResponse).buildAsString();
        } else {
            response = new JSONResponseBuilder().addField(RespConstants.RESULTS, responseEntity).buildAsString();
        }
        serverResponse.setEntity(response);
        Long endTime = System.currentTimeMillis();
        System.out.println("in formatter edge" + (endTime - startTime) + " ms" + " -> " + responseEntity.getClass());
    }

    private void setContentTypeHeader(ServerResponse serverResponse) {
        MultivaluedMap<String, Object> headers = serverResponse.getMetadata();
        List<Object> contentType = new ArrayList<Object>();
        contentType.add(CONTENT_TYPE_JSON);
        headers.put(CONTENT_TYPE_HEADER_KEY, contentType);
    }
}
