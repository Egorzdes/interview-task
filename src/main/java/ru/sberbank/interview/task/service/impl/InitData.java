package ru.sberbank.interview.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sberbank.interview.task.dao.model.EntityDao;
import ru.sberbank.interview.task.dao.repository.EntityRepository;


import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitData {

    private final EntityRepository entityRepository;

    @Autowired
    public InitData(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @PostConstruct
    public void Init() {
        Set<EntityDao> entityDaoSet = new HashSet<>();
        entityDaoSet.add(new EntityDao(1L, 123, "Sys1", new Date(), "qwerty", "qwweqw"));
        entityDaoSet.add(new EntityDao(2L, 456, "Sys2", new Date(), "qwerty111", "qwweqw1111"));
        entityRepository.saveAll(entityDaoSet);
    }
}
