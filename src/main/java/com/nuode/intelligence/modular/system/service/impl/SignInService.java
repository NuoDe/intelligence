package com.nuode.intelligence.modular.system.service.impl;

import com.nuode.intelligence.modular.system.entity.SignInPage;
import com.nuode.intelligence.modular.system.mapper.SignInMapper;
import com.nuode.intelligence.modular.system.service.ISignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-13-14:56
 */
@Service
public class SignInService implements ISignInService {

    @Autowired
    SignInMapper signInMapper;

    @Override
    public SignInPage initSignInPage() {
        return signInMapper.selectOne(null);
    }
}
