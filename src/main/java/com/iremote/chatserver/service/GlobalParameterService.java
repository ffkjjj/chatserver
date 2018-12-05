package com.iremote.chatserver.service;

import com.iremote.chatserver.dao.GlobalParameterDAO;
import com.iremote.chatserver.po.GlobalParameterPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlobalParameterService {
    @Autowired
    private GlobalParameterDAO globalParameterDAO;

    public void addIntValue(String key) {
        GlobalParameterPO po = globalParameterDAO.findByKey(key);
        if (po == null) {
            return;
        }
        if (po.getIntvalue() == null) {
            po.setIntvalue(0);
        }
        po.setIntvalue(po.getIntvalue() + 1);
    }
}
