package com.iremote.chatserver.dao;

import com.iremote.chatserver.po.BookInfoPO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface BookInfoDAO extends CrudRepository<BookInfoPO, Integer>{
    BookInfoPO findByBookwebid(String bookwebid);
}
