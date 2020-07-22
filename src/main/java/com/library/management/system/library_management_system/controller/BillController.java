package com.library.management.system.library_management_system.controller;

import com.library.management.system.library_management_system.dto.BillDto;
import com.library.management.system.library_management_system.dto.BookDto;
import com.library.management.system.library_management_system.entity.Bill;
import com.library.management.system.library_management_system.entity.MemberRecord;
import com.library.management.system.library_management_system.jasper.report.ReportService;
import com.library.management.system.library_management_system.model.LMSException;
import com.library.management.system.library_management_system.repository.BillRepository;
import com.library.management.system.library_management_system.repository.MemberRecordRepository;
import com.library.management.system.library_management_system.service.BillService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/bill")
public class BillController {

    @Autowired
    private BillService billService;

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private BillDto add(@RequestBody BillDto billDto) throws LMSException {
        return billService.add(billDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws LMSException, IOException {
        billService.delete(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private BillDto update(@RequestBody BillDto billDto) throws LMSException {
        return billService.update(billDto);
    }

    @GetMapping()
    private List<BillDto> findAll() {
        return billService.findAll();
    }

    @GetMapping("/first")
    public BillDto findFirst() {
        BillDto billDto = billService.findFirst();
        if (billDto != null)
            return billDto;
        else
            return new BillDto();
    }
    @GetMapping("/print/{billId}")
    public ResponseEntity<byte[]> report(@PathVariable Integer billId) {
        byte[] bytes = billService.getBytes(billId);
        String currentDate = LocalDateTime.now().format(formatter);
        ContentDisposition contentDisposition = ContentDisposition.builder("inline")
                .filename("Facture_"+currentDate + ".pdf").build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(contentDisposition);
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/pdf; charset=UTF-8")
                .headers(headers)
                .body(bytes);
    }


}
