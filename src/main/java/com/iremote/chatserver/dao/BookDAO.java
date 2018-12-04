package ml.myll.web.dao;

import ml.myll.web.po.BookPO;
import org.springframework.data.repository.CrudRepository;

public interface BookDAO extends CrudRepository<BookPO, Integer>{
}
