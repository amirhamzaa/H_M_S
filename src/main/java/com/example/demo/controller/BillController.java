package com.example.demo.controller;

import com.example.demo.DTO.BillDTO;
import com.example.demo.service.BillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    public BillDTO createBill(@RequestBody BillDTO billDTO) {
        return billService.createBill(billDTO);
    }

    @GetMapping
    public List<BillDTO> getAllBills() {
        return billService.getAllBills();
    }
}
