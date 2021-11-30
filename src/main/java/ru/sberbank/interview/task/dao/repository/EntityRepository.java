package ru.sberbank.interview.task.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.interview.task.dao.model.EntityDao;

import java.util.List;

@Repository
public interface EntityRepository extends CrudRepository<EntityDao, Long> {

    List<EntityDao> findAllByCode(Integer code);

    List<EntityDao> findAllBySysName(String sysName);

    List<EntityDao> findEntityDaoByCodeOrSysName(Integer code, String sysName);

}

