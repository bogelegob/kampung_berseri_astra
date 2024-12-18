package com.polytechnic.astra.ac.id.kampung_berseri_astra.rest;

import com.polytechnic.astra.ac.id.kampung_berseri_astra.config.EncodeData;
import com.polytechnic.astra.ac.id.kampung_berseri_astra.service.MasterPembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/MasterPembeli")
public class MasterPembeliRest {
    @Autowired
    private MasterPembeliService masterPembeliService;

    @Autowired
    private EncodeData encodeData;

    @PostMapping("/GetDataPembeli")
    public ResponseEntity<String> getDataPembeli(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterPembeliService.getDataPembeli(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mendapatkan data", e);
        }
    }

    @PostMapping("/CreatePembeli")
    public ResponseEntity<String> createPembeli(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterPembeliService.createPembeli(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal membuat data pembeli", e);
        }
    }

    @PostMapping("/EditPembeli")
    public ResponseEntity<String> editPembeli(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterPembeliService.editPembeli(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mengedit data pembeli", e);
        }
    }

    @PostMapping("/SetStatusPembeli")
    public ResponseEntity<String> setStatusPembeli(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterPembeliService.setStatusPembeli(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mengubah status pembeli", e);
        }
    }

    @PostMapping("/GetPembeliById")
    public ResponseEntity<String> getPembeliById(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterPembeliService.getPembeliById(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mendapatkan data pembeli", e);
        }
    }
}