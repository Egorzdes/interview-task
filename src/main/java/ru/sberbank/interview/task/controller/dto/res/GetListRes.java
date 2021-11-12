package ru.sberbank.interview.task.controller.dto.res;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sberbank.interview.task.controller.dto.support.EntityDto;

@Data
@AllArgsConstructor
public class GetListRes {

    private List<EntityDto> items;
    private Integer unread;

}
