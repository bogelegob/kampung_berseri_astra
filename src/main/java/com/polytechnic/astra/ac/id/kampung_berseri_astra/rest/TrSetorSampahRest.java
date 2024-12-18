package com.polytechnic.astra.ac.id.kampung_berseri_astra.rest;

import com.polytechnic.astra.ac.id.kampung_berseri_astra.config.EncodeData;
import com.polytechnic.astra.ac.id.kampung_berseri_astra.service.TrPenjualanService;
import com.polytechnic.astra.ac.id.kampung_berseri_astra.service.TrSetorSampahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/TransaksiSetorSampah")
public class TrSetorSampahRest {
    @Autowired
    private TrSetorSampahService trSetorSampahService;

    @Autowired
    private EncodeData encodeData;

    @PostMapping("/GetDataSetorSampah")
    public ResponseEntity<String> getDataSetorSampah(@RequestBody Map<String, Object> data) {
        try {
            System.out.println("hghggg"+data);
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = trSetorSampahService.getDataSetorSampah(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mendapatkan data", e);
        }
    }

    @PostMapping("/CreateSetorSampah")
    public ResponseEntity<String> createSetorSampah(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = trSetorSampahService.createSetorSampah(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal membuat data transaksi SetorSampah", e);
        }
    }


    //digunakan seperti Edit
    @PostMapping("/EditSetorSampah")
    public ResponseEntity<String> editSetorSampah(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = trSetorSampahService.editSetorSampah(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mengubah data transaksi SetorSampah", e);
        }
    }

    //digunakan seperti delete
    @PostMapping("/SetStatusSetorSampah")
    public ResponseEntity<String> setStatusSetorSampah(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = trSetorSampahService.setStatusSetorSampah(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mengubah status transaksi SetorSampah", e);
        }
    }

    @PostMapping("/GetSetorSampahById")
    public ResponseEntity<String> getSetorSampahById(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = trSetorSampahService.getDataSetorSampahById(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mendapatkan data transaksi SetorSampah", e);
        }
    }

    @PostMapping("/GetListSetorSampah")
    public ResponseEntity<String> getListPendaftaran(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = trSetorSampahService.getListSetorSampah(encodedData);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to get list SetorSampah", e);
        }
    }

    @PostMapping("/DetailSetorSampah")
    public ResponseEntity<String> detailSetorSampah(@RequestBody Map<String, Object> data) {

        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = trSetorSampahService.detailSetorSampah(encodedData);
            System.out.println("MASUK" + result);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to get detail SetorSampah", e);
        }
    }

}
