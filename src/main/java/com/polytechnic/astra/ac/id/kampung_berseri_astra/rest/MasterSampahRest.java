package com.polytechnic.astra.ac.id.kampung_berseri_astra.rest;

import com.polytechnic.astra.ac.id.kampung_berseri_astra.config.EncodeData;
import com.polytechnic.astra.ac.id.kampung_berseri_astra.service.MasterSampahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@RequestMapping("/api/MasterSampah")

public class MasterSampahRest {
    @Autowired
    private MasterSampahService masterSampahService;

    @Autowired
    private EncodeData encodeData;

    @PostMapping("/GetDataSampah")
    public ResponseEntity<String> getDataSampah(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterSampahService.getDataSampah(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mendapatkan data sampah", e);
        }
    }

    @PostMapping("/CreateSampah")
    public ResponseEntity<String> createSampah(@RequestBody Map<String, Object> data) { // Menggunakan @RequestPart untuk data
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
//            String path = masterSampahService.saveImage(file);
            String result = masterSampahService.createSampah(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal membuat data sampah", e);
        }
    }

    @PostMapping("/SaveImage")
    public ResponseEntity<String> saveImage(@RequestPart("file") MultipartFile file) { // Menggunakan @RequestPart untuk data
        try {
//            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String path = masterSampahService.saveImage(file);
//            String result = masterSampahService.createSampah(encodedData);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal membuat data sampah", e);
        }
    }

    @PostMapping("/EditImage")
    public ResponseEntity<String> editImage(@RequestPart("file") MultipartFile file,
                                            @RequestPart("path") String jalur) { // Menggunakan @RequestPart untuk data
        try {
//            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String path = masterSampahService.updateImage(jalur,file);
//            String result = masterSampahService.createSampah(encodedData);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal membuat data sampah", e);
        }
    }


    @PostMapping("/EditSampah")
    public ResponseEntity<String> editSampah(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterSampahService.editSampah(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mengedit data sampah", e);
        }
    }

    @PostMapping("/SetStatusSampah")
    public ResponseEntity<String> setStatusSampah(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterSampahService.setStatusSampah(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mengubah status sampah", e);
        }
    }

    @PostMapping("/GetSampahById")
    public ResponseEntity<String> getSampahById(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterSampahService.getSampahById(encodedData);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal mendapatkan data sampah", e);
        }
    }

    @PostMapping("/GetListSampah")
    public ResponseEntity<String> getListLomba(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = masterSampahService.getListSampah(encodedData);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to get list", e);
        }
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable String id) {
//        Sampah sampah = sampahService.getSampahById(id);
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

    // Method untuk mengambil gambar berdasarkan fileName
    @GetMapping("/uploads/{fileName}")
    public ResponseEntity<Resource> getImagePath(@PathVariable String fileName) {
        try {
            // Path ke direktori tempat menyimpan gambar
            Path imagePath = Paths.get("uploads").resolve(fileName);
            Resource imageResource = new UrlResource(imagePath.toUri());

            if (imageResource.exists() || imageResource.isReadable()) {
                // Mengembalikan gambar jika ditemukan dan dapat dibaca
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)  // Ubah jika gambar formatnya berbeda
                        .body(imageResource);
            } else {
                // Jika gambar tidak ditemukan atau tidak bisa dibaca
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (IOException e) {
            // Jika terjadi kesalahan dalam membaca file
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
