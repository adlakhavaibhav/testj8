package com.nm.rest.response.builder;


import com.nm.domain.JSONObject;
import com.nm.rest.constants.RespConstants;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: Feb 25, 2013
 * Time: 11:29:53 AM
 */
public abstract class BaseResponseBuilder implements ResponseBuilder {


  private Map<String, Object> params;

  private Status status = Status.OK;


  public ResponseBuilder setStatus(Status status) {
    this.status = status;
    return this;
  }


  public ResponseBuilder addField(String fieldName, Object fieldValue) {
    if (params == null) {
      params = new LinkedHashMap<String, Object>();
    }

    params.put(fieldName, fieldValue);

    return this;
  }

  public ResponseBuilder addMap(Map<String, Object> data) {
    if (params == null) {
      params = new HashMap<String, Object>();
    }

    params.putAll(data);

    return this;
  }

  public String buildAsString() {
    params.put(RespConstants.STATUS_CODE, status.getStatusCode());
    /* params.put(RespConstants.EXCEPTION, exception);
    if (messages.size() > 1) {
      params.put(RespConstants.MESSAGE, messages);
    }*/

    StringBuilder sb = new StringBuilder();
    JSONObject.appendJSONMap(params, sb);
    return sb.toString();
  }

  public Object getParam(String fieldName) {
    return params.get(fieldName);
  }
}
