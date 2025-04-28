package com.burnie.remoteapi.service;

import com.burnie.remoteapi.vo.AuthVo;

public interface AuthService {
    AuthVo processIdentification(AuthVo authVo);

}
