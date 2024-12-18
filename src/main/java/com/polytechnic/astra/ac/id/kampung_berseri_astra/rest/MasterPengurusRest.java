package com.polytechnic.astra.ac.id.kampung_berseri_astra.rest;

import com.polytechnic.astra.ac.id.kampung_berseri_astra.config.EncodeData;
import com.polytechnic.astra.ac.id.kampung_berseri_astra.service.MasterPengurusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/MasterPengurus")


public class MasterPengurusRest {
    @Autowired
    private MasterPengurusService masterPengurusService;
    
    @Autowired
    private EncodeData encodeData;

    @PostMapping("/GetDataPengurus")
    public ResponseEntity<String> getDataPengurus(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterPengurusService.getDataPengurus(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mendapatkan data", e);
        }
    }

    @PostMapping("/CreatePengurus")
    public ResponseEntity<String> createPengurus(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterPengurusService.createPengurus(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal membuat data pengurus", e);
        }
    }

    @PostMapping("/EditPengurus")
    public ResponseEntity<String> editPengurus(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterPengurusService.editPengurus(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mengedit data pengurus", e);
        }
    }

    @PostMapping("/SetStatusPengurus")
    public ResponseEntity<String> setStatusPengurus(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterPengurusService.setStatusPengurus(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mengubah status pengurus", e);
        }
    }

    @PostMapping("/GetPengurusById")
    public ResponseEntity<String> getPengurusById(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterPengurusService.getPengurusById(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mendapatkan data pengurus", e);
        }
    }
}
