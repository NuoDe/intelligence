package com.nuode.intelligence.modular.system.service;

import com.nuode.intelligence.modular.system.entity.DBInitialzation;
import com.nuode.intelligence.modular.system.entity.SignInPage;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-08-20:26
 */
public interface IInitialzationService {

    public String dbInit(DBInitialzation DBInitialzation);

    public boolean dbValidate(DBInitialzation DBInitialzation);

    public String setLogo(MultipartFile file);

    public String setBackgroundImage(MultipartFile file);

    public boolean setCopyrightInfo(SignInPage signInPage);
}
