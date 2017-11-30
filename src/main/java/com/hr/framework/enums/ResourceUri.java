package com.hr.framework.enums;

import com.hr.framework.constant.ResourcePath;
import com.hr.framework.param.ClientParam;
import com.hr.framework.param.LoginParam;
import com.hr.framework.param.ResourceParam;
import com.hr.framework.param.RoleParam;
import com.hr.framework.param.UserParam;

import java.util.HashMap;
import java.util.Map;


public enum ResourceUri {

  LOGIN(ResourcePath.API + ResourcePath.V1 + ResourcePath.OPEN + ResourcePath.LOGIN,
      LoginParam.class),
  REFRESH(ResourcePath.API + ResourcePath.V1 + ResourcePath.OPEN + ResourcePath.REFRESH,
      LoginParam.class),
  CLIENTS(ResourcePath.API + ResourcePath.V1 + ResourcePath.MANAGEMENT + ResourcePath.CLIENTS,
      ClientParam.class),
  RESOURCES(
      ResourcePath.API + ResourcePath.V1 + ResourcePath.MANAGEMENT + ResourcePath.RESOURCES,
      ResourceParam.class),
  ROLES(ResourcePath.API + ResourcePath.V1 + ResourcePath.MANAGEMENT + ResourcePath.ROLES,
      RoleParam.class),
  USERS(ResourcePath.API + ResourcePath.V1 + ResourcePath.MANAGEMENT + ResourcePath.USERS,
      UserParam.class),

  UNKNOWN("",null);

  private String uri;
  private Class clazz;

  private static final Map<String, ResourceUri> mappings = new HashMap<>(2);

  static {
    for (ResourceUri resourceUri : values()) {
      mappings.put(resourceUri.uri, resourceUri);
    }
  }

  ResourceUri(String uri, Class clazz) {
    this.uri = uri;
    this.clazz = clazz;
  }

  public String uri() {
    return uri;
  }

  public Class clazz() {
    return clazz;
  }

  public static ResourceUri resolve(String uri) {
    return (uri != null ? mappings.get(uri) : UNKNOWN);
  }

  public boolean matches(String uri) {
    return (this == resolve(uri));
  }

  }
