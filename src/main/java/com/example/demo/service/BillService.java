package com.example.demo.service;

import com.example.demo.DTO.BillDTO;
import com.example.demo.entity.Bill;
import com.example.demo.entity.Patient;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {

    private final BillRepository billRepository;
    private final PatientRepository patientRepository;

    public BillService(BillRepository billRepository, PatientRepository patientRepository) {
        this.billRepository = billRepository;
        this.patientRepository = patientRepository;
    }

    public BillDTO createBill(BillDTO billDTO) {
        Bill bill = new Bill();
        bill.setName(billDTO.getName());
        bill.setPhone(billDTO.getPhone());
        bill.setTime(billDTO.getTime());
        bill.setStatus(billDTO.getStatus());

        Patient patient = patientRepository.findById(billDTO.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        bill.setPatient(patient);

        bill = billRepository.save(bill);

        return convertToDTO(bill);
    }

    public List<BillDTO> getAllBills() {
        return billRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private BillDTO convertToDTO(Bill bill) {
        BillDTO dto = new BillDTO();
        dto.setId(bill.getId());
        dto.setName(bill.getName());
        dto.setPhone(bill.getPhone());
        dto.setTime(bill.getTime());
        dto.setStatus(bill.getStatus());
        dto.setPatientId(bill.getPatient().getId());
        return dto;
    }
}
