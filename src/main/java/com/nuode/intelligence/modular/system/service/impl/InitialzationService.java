package com.nuode.intelligence.modular.system.service.impl;

import com.nuode.intelligence.modular.system.entity.DBInitialzation;
import com.nuode.intelligence.modular.system.service.IInitialzationService;
import com.nuode.intelligence.modular.system.utils.ConnectionUtil;
import com.nuode.intelligence.modular.system.utils.PropertiesUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-08-20:28
 */
@Service
public class InitialzationService implements IInitialzationService {

    @Override
    public String dbInit(@RequestBody DBInitialzation DBInitialzation) {
        try {
            if (PropertiesUtil.initProperties(DBInitialzation)) {
                return "success";
            }
            return "error";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public boolean dbValidate(DBInitialzation DBInitialzation) {
        return ConnectionUtil.dbConnectionValidate(DBInitialzation.getUrl(), DBInitialzation.getUsername(), DBInitialzation.getPassword());
    }
}
