package com.burnie.remoteapi.vo;

import com.burnie.remoteapi.common.API;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthVo {
   private String idCardNo;
   private String name;
   private String issueDate;

   private String authResult;

   private String sleepSeconds;

   private API api;
}
