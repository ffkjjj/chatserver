package ml.myll.web.dao;

import ml.myll.web.po.ContentPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContentDAO extends PagingAndSortingRepository<ContentPO, Integer> {
    Page<ContentPO> findAll(Pageable pageable);
}
