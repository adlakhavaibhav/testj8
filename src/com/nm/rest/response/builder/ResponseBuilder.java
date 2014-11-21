package com.nm.rest.response.builder;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: Feb 25, 2013
 * Time: 11:29:21 AM
 */
public interface ResponseBuilder {

  public static enum Status {
    OK(200), BAD_REQUEST(400), UNAUTHORIZED(401), FORBIDDEN(403), NOT_FOUND(404), GONE(410), INTERNAL_SERVER_ERROR(500),
    SERVICE_UNAVAILABLE(503);

    private int statusCode;

    Status(int statusCode) {
      this.statusCode = statusCode;
    }

    public int getStatusCode() {
      return statusCode;
    }
  }

  public String buildAsString();

  public ResponseBuilder addField(String fieldName, Object fieldValue);

  public Object getParam(String fieldName);


}
