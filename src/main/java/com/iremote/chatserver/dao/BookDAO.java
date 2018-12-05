package com.iremote.chatserver.dao;

import com.iremote.chatserver.po.BookPO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface BookDAO extends CrudRepository<BookPO, Integer>{
    BookPO findByBookinternalidAndChapterid(Integer bookInternalId, Integer bookId);
}
