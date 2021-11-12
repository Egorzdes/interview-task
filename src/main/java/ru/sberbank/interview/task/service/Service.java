package ru.sberbank.interview.task.service;

import java.util.List;
import ru.sberbank.interview.task.controller.dto.res.GetListRes;
import ru.sberbank.interview.task.controller.dto.support.EntityDto;


import java.util.List;

public interface Service {
    List<EntityDto> getAllEntitiesById(List<Long> id);

    List<EntityDto> getEntityByCodeAndSysName(Integer code, String sysName);

    GetListRes getList(String sysName);

}

