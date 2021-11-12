package ru.sberbank.interview.task.dao.model;


import lombok.*;
import ru.sberbank.interview.task.controller.dto.support.EntityDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "ENTITY_DAO")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntityDao implements Serializable {

    private static final long serialVersionUID = -1489263584378511364L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CODE")
    private Integer code;
    @Column(name = "SYSNAME")
    private String sysName;
    @Column(name = "WATCHED_DTTM")
    private Date watchedDttm;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DATA")
    private String data;


    public EntityDto convertToDto() {
        EntityDto dto = new EntityDto();
        dto.setId(this.id);
        dto.setCode(this.code);
        dto.setSysName(this.sysName);
        dto.setWatchedDttm(this.watchedDttm);
        dto.setDescription(this.description);
        dto.setData(this.data);
        return dto;
    }

}
