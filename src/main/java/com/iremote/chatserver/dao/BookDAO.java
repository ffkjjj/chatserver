package com.iremote.chatserver.dao;

import com.iremote.chatserver.po.BookPO;
import org.springframework.data.repository.CrudRepository;

public interface BookDAO extends CrudRepository<BookPO, Integer>{
}
