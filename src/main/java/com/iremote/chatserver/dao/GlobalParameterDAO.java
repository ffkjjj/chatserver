package com.iremote.chatserver.dao;

import com.iremote.chatserver.po.GlobalParameterPO;
import org.springframework.data.repository.CrudRepository;

public interface GlobalParameterDAO extends CrudRepository<GlobalParameterPO, Integer>{
    GlobalParameterPO findByGlobalid(String key);
}
