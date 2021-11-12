package ru.sberbank.interview.task.controller.dto.support;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class EntityDto {
    @JsonProperty("entityId")
    private Long id;
    private Integer code;
    @JsonIgnore
    private String sysName;
    @JsonProperty("watched")
    private Date watchedDttm;
    private String description;
    private String data;

}

