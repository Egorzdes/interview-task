package ru.sberbank.interview.task.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.interview.task.controller.dto.res.GetListRes;
import ru.sberbank.interview.task.controller.dto.support.EntityDto;
import ru.sberbank.interview.task.service.Service;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ServiceController {

    private final String JSON = "application/json;charset=UTF-8";
    private final Service service;


    @GetMapping(value = "/get", produces = JSON)
    public ResponseEntity<List<EntityDto>> getAllEntitiesById(@RequestHeader("id") List<Long> id) {
        return ResponseEntity.ok().body(service.getAllEntitiesById(id));
    }

    @GetMapping(value = "/", produces = JSON)
    public ResponseEntity<List<EntityDto>> getEntityByCodeAndSysName(@RequestParam(value = "code", required = false) Integer code,
                                                                     @RequestParam(value = "sysName", required = false) String sysName) {
        return ResponseEntity.ok().body(service.getEntityByCodeAndSysName(code, sysName));
    }

    @GetMapping(value = "/list/{sysname}", produces = JSON)
    public ResponseEntity<GetListRes> list(@PathVariable(value = "sysname") String sysName) {
        return ResponseEntity.ok().body(service.getList(sysName));
    }
}
