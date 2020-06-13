package com.library.management.system.library_management_system.controller;

import com.google.zxing.WriterException;
import com.library.management.system.library_management_system.dto.MemberRecordDto;
import com.library.management.system.library_management_system.model.LMSException;
import com.library.management.system.library_management_system.service.MemberRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/memberRecord")
@CrossOrigin(origins = "http://localhost:4200")
@SuppressWarnings("unchecked")
public class MemberRecordController {


    @Autowired
    private MemberRecordService memberRecordService;

    @GetMapping(path = "/first", produces = MediaType.APPLICATION_JSON_VALUE)
    private MemberRecordDto findFirst() {
        MemberRecordDto memberRecordDto = memberRecordService.findFirst();
        if (memberRecordDto != null)
            return memberRecordDto;
        else
            return new MemberRecordDto();
    }

    @GetMapping(path = "/{codeMemberRecord}", produces = MediaType.APPLICATION_JSON_VALUE)
    private MemberRecordDto findMemberRecordByCode(@PathVariable String codeMemberRecord) {
        return memberRecordService.findByCodeMemberRecord(codeMemberRecord);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private MemberRecordDto add(@RequestBody MemberRecordDto memberRecordDto) throws LMSException, IOException, WriterException {
        return memberRecordService.add(memberRecordDto);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private void delete(@PathVariable Integer id) throws LMSException, IOException {
        memberRecordService.delete(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private MemberRecordDto update(@RequestBody MemberRecordDto memberRecordDto) throws IOException, LMSException, WriterException {
        return memberRecordService.update(memberRecordDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<MemberRecordDto> findByAll() {
        return memberRecordService.findAll();
    }


}
