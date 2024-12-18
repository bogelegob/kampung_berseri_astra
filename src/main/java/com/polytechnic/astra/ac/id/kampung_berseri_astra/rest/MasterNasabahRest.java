package com.polytechnic.astra.ac.id.kampung_berseri_astra.rest;
import com.polytechnic.astra.ac.id.kampung_berseri_astra.config.EncodeData;
import com.polytechnic.astra.ac.id.kampung_berseri_astra.service.MasterNasabahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/MasterNasabah")
public class MasterNasabahRest {
    @Autowired
    private MasterNasabahService masterNasabahService;

    @Autowired
    private EncodeData encodeData;

    @PostMapping("/GetDataNasabah")
    public ResponseEntity<String> getDataNasabah(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterNasabahService.getDataNasabah(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mendapatkan data", e);
        }
    }

    @PostMapping("/CreateNasabah")
    public ResponseEntity<String> createNasabah(@RequestBody Map<String, Object> data) {
        try {
            System.out.println("Received data: " + data);  // Log data yang diterima

            // Encode data (jika diperlukan)
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            System.out.println("Encoded data: " + encodedData);  // Log data yang sudah diencode

            // Simpan data nasabah
            String result = masterNasabahService.createNasabah(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.err.println("Error while creating nasabah: " + e.getMessage()); // Log kesalahan
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal membuat data nasabah", e);
        }
    }

    @PostMapping("/SaveImageNasabah")
    public ResponseEntity<String> saveImageNasabah(@RequestPart("file") MultipartFile file) { // Menggunakan @RequestPart untuk data
        try {
//            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String path = masterNasabahService.saveImageNasabah(file);
//            String result = masterNasabahService.createNasabah(encodedData);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal membuat data nasabah", e);
        }
    }

    @PostMapping("/EditImage")
    public ResponseEntity<String> editImage(@RequestPart("file") MultipartFile file,
                                            @RequestPart("path") String jalur) { // Menggunakan @RequestPart untuk data
        try {
//            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String path = masterNasabahService.updateImage(jalur,file);
//            String result = masterNasabahService.createNasabah(encodedData);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal membuat data nasabah", e);
        }
    }


    @PostMapping("/EditNasabah")
    public ResponseEntity<String> editNasabah(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterNasabahService.editNasabah(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mengedit data nasabah", e);
        }
    }

    @PostMapping("/SetStatusNasabah")
    public ResponseEntity<String> setStatusNasabah(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterNasabahService.setStatusNasabah(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mengubah status nasabah", e);
        }
    }

    @PostMapping("/GetNasabahById")
    public ResponseEntity<String> getNasabahById(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterNasabahService.getNasabahById(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mendapatkan data nasabah", e);
        }
    }


//    @PostMapping("/GetNasabahById")
//    public ResponseEntity<String> getNasabahById(@RequestBody Map<String, Object> data) {
//        try {
//            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
//            String result = masterNasabahService.getNasabahById(encodedData);
//            return ResponseEntity.ok(result);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mendapatkan data nasabah", e);
//        }
//    }

    @PostMapping("/GetListNasabah")
    public ResponseEntity<String> getListLomba(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterNasabahService.getListNasabah(encodedData);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to get list", e);
        }
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable String id) {
//        Nasabah nasabah = nasabahService.getNasabahById(id);
        Path imagePath = Paths.get(id);

        try {
            Resource imageResource = new UrlResource(imagePath.toUri());
            return ResponseEntity.ok()
                    .contentType(org.springframework.http.MediaType.IMAGE_JPEG) // Sesuaikan jenis gambar
                    .body(imageResource);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
