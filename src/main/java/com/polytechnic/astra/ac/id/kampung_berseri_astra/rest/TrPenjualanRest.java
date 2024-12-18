package com.polytechnic.astra.ac.id.kampung_berseri_astra.rest;

import com.polytechnic.astra.ac.id.kampung_berseri_astra.config.EncodeData;
import com.polytechnic.astra.ac.id.kampung_berseri_astra.service.TrPenjualanService;
import org.etsi.uri.x01903.v13.EncapsulatedPKIDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/TransaksiPenjualan")
public class TrPenjualanRest {
    @Autowired
    private TrPenjualanService trPenjualanService;

    @Autowired
    private EncodeData encodeData;

    @PostMapping("/GetDataPenjualan")
    public ResponseEntity<String> getDataPenjualan(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = trPenjualanService.getDataPenjualan(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mendapatkan data", e);
        }
    }

    @PostMapping("/CreatePenjualan")
    public ResponseEntity<String> createPenjualan(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = trPenjualanService.createPenjualan(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal membuat data transaksi penjualan", e);
        }
    }


    //digunakan seperti Edit
    @PostMapping("/EditPenjualan")
    public ResponseEntity<String> editPenjualan(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = trPenjualanService.editPenjualan(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mengubah data transaksi penjualan", e);
        }
    }

    //digunakan seperti delete
    @PostMapping("/SetStatusPenjualan")
    public ResponseEntity<String> setStatusPenjualan(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = trPenjualanService.setStatusPenjualan(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mengubah status transaksi penjualan", e);
        }
    }

    @PostMapping("/GetPenjualanById")
    public ResponseEntity<String> getPenjualanById(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = trPenjualanService.getDataPenjualanById(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mendapatkan data transaksi penjualan", e);
        }
    }

    @PostMapping("/GetListPenjualan")
    public ResponseEntity<String> getListPendaftaran(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = trPenjualanService.getListPenjualan(encodedData);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to get list Penjualan", e);
        }
    }

    @PostMapping("/DetailPenjualan")
    public ResponseEntity<String> detailPenjualan(@RequestBody Map<String, Object> data) {

        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = trPenjualanService.detailPenjualan(encodedData);
            System.out.println("MASUK" + result);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to get detail Penjualan", e);
        }
    }

}
