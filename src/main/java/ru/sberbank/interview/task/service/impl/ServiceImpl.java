package ru.sberbank.interview.task.service.impl;


import lombok.RequiredArgsConstructor;
import ru.sberbank.interview.task.constant.exception.TaskError;
import ru.sberbank.interview.task.constant.exception.TaskException;
import ru.sberbank.interview.task.controller.dto.res.GetListRes;
import ru.sberbank.interview.task.controller.dto.support.EntityDto;
import ru.sberbank.interview.task.dao.model.EntityDao;
import ru.sberbank.interview.task.dao.repository.EntityRepository;
import ru.sberbank.interview.task.service.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceImpl implements Service {


    private final EntityRepository entityRepository;

    @Override
    public List<EntityDto> getAllEntitiesById(List<Long> id) {
        if (id.isEmpty()) {
            throw new TaskException(TaskError.ID_CANNOT_BE_NULL, " ");
        }
        List<EntityDao> list = StreamSupport.stream(entityRepository.findAllById(id).spliterator(), false)
                .collect(Collectors.toList());
        Set<Long> allEntityId = list.stream().map(EntityDao::getId).collect(Collectors.toSet());
        id.removeAll(allEntityId);
        if (!id.isEmpty()) {
            throw new TaskException(TaskError.NOT_ALL_ID_EXSIST, getStringValues(id));
        }
        return list.stream().map(EntityDao::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<EntityDto> getEntityByCodeAndSysName(Integer code, String sysName) {
        List<EntityDto> entityDtoList;
        if (code != null && sysName != null) {
            entityDtoList = convertList(entityRepository.findEntityDaoByCodeOrSysName(code, sysName));
        } else if (code != null) {
            entityDtoList = convertList(entityRepository.findAllByCode(code));
        } else if (sysName != null) {
            entityDtoList = convertList(entityRepository.findAllBySysName(sysName));
        } else {
            entityDtoList =
                    convertList(StreamSupport.stream(entityRepository.findAll().spliterator(), false)
                            .collect(Collectors.toList()));
        }
        return entityDtoList;
    }

    @Override
    public GetListRes getList(String sysName) {
        List<EntityDao> res = entityRepository.findAllBySysName(sysName);
        long unread = res.stream().map(EntityDao::getWatchedDttm).filter(Objects::isNull).count();
        if (unread == 0L) {
            return new GetListRes(new ArrayList<>(), 0);
        }
        return new GetListRes(convertList(res), (int) unread);
    }

    private List<EntityDto> convertList(List<EntityDao> entityDaoList) {
        return entityDaoList.stream().map(EntityDao::convertToDto).collect(Collectors.toList());
    }

    private String getStringValues(List<Long> id) {
        StringBuilder sb = new StringBuilder();
        for (Long i : id) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
}