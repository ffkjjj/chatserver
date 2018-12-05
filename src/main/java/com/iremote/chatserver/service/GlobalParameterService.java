package com.iremote.chatserver.service;

import com.iremote.chatserver.dao.GlobalParameterDAO;
import com.iremote.chatserver.po.GlobalParameterPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlobalParameterService {
    @Autowired
    private GlobalParameterDAO globalParameterDAO;

    public Integer addIntValue(String key) {
        GlobalParameterPO po = globalParameterDAO.findByGlobalid(key);
        if (po == null) {
            return null;
        }
        if (po.getIntvalue() == null) {
            po.setIntvalue(0);
        }
        po.setIntvalue(po.getIntvalue() + 1);
        return po.getIntvalue();
    }

    public Integer getIntValue(String key) {
        GlobalParameterPO po = globalParameterDAO.findByGlobalid(key);
        return po.getIntvalue();
    }
}
