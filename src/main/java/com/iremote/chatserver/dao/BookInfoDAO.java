package com.iremote.chatserver.dao;

import com.iremote.chatserver.po.BookInfoPO;
import org.springframework.data.repository.CrudRepository;

public interface BookInfoDAO extends CrudRepository<BookInfoPO, Integer>{
}
