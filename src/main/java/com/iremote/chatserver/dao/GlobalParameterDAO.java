package com.iremote.chatserver.dao;

import com.iremote.chatserver.po.GlobalParameterPO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author jwzh
 */
public interface GlobalParameterDAO extends CrudRepository<GlobalParameterPO, Integer>{
    GlobalParameterPO findByKey(String key);
}
