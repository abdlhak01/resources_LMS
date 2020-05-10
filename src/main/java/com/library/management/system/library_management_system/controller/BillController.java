package com.library.management.system.library_management_system.controller;

import com.library.management.system.library_management_system.dto.BillDto;
import com.library.management.system.library_management_system.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private BillDto add(@RequestBody BillDto billDto){
        return billService.add(billDto);
    }

     @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private void delete(@RequestBody BillDto billDto){
        billService.add(billDto);
    }

     @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private BillDto update(@RequestBody BillDto billDto){
        return billService.update(billDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<BillDto> findAll(@RequestBody BillDto billDto){
        return billService.findAll();
    }



}
