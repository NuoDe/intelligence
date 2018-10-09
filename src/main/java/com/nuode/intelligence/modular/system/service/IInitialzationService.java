package com.nuode.intelligence.modular.system.service;

import com.nuode.intelligence.modular.system.entity.DBInitialzation;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-08-20:26
 */
public interface IInitialzationService {

    public String dbInit(DBInitialzation DBInitialzation);

    public boolean dbValidate(DBInitialzation DBInitialzation);
}
