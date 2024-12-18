package com.polytechnic.astra.ac.id.kampung_berseri_astra.service.impl;


import com.polytechnic.astra.ac.id.kampung_berseri_astra.repository.PolmanAstraRepository;
import com.polytechnic.astra.ac.id.kampung_berseri_astra.service.MasterSampahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class MasterSampahServiceImpl implements MasterSampahService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    public String getDataSampah(Map<String, Object> data) {
        try {
            List<String> dataList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                dataList.add(entry.getValue().toString());
            }
            return polmanAstraRepository.callProcedure("kba_getListMsSampah", dataList.toArray(new String[0]));
        } catch (Exception e) {
            throw new RuntimeException("Error in fetching data sampah", e);
        }
    }

    @Override
    public String createSampah(Map<String, Object> data) {
        try {
            List<String> dataList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                dataList.add(entry.getValue().toString());
            }
            return polmanAstraRepository.callProcedure("kba_createMsSampah", dataList.toArray(new String[0]));
        } catch (Exception e) {
            throw new RuntimeException("Error in creating sampah", e);
        }
    }

    @Override
    public String editSampah(Map<String, Object> data) {
        try {
            List<String> dataList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                dataList.add(entry.getValue().toString());
            }
            return polmanAstraRepository.callProcedure("kba_updateMsSampah", dataList.toArray(new String[0]));
        } catch (Exception e) {
            throw new RuntimeException("Error in editing sampah", e);
        }
    }

    @Override
    public String setStatusSampah(Map<String, Object> data) {
        try {
            List<String> dataList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                dataList.add(entry.getValue().toString());
            }
            return polmanAstraRepository.callProcedure("kba_setStatusMsSampah", dataList.toArray(new String[0]));
        } catch (Exception e) {
            throw new RuntimeException("Error in setting sampah status", e);
        }
    }

    @Override
    public String getSampahById(Map<String, Object> data) {
        try {
            List<String> dataList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                dataList.add(entry.getValue().toString());
            }
            return polmanAstraRepository.callProcedure("kba_getDataMsSampahById", dataList.toArray(new String[0]));
        } catch (Exception e) {
            throw new RuntimeException("Error in fetching sampah by ID", e);
        }
    }

    @Override
    public String detailSampah(Map<String, Object> data) {
        try {
            List<String> dataList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                dataList.add(entry.getValue().toString());
            }
            return polmanAstraRepository.callProcedure("kba_detailSampah", dataList.toArray(new String[0]));
        } catch (Exception e) {
            throw new RuntimeException("Error detail in fetching sampah", e);
        }
    }

    @Override
    public String getListSampah(Map<String, Object> data) {
        try {
            List<String> dataList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                dataList.add(entry.getValue().toString());
            }
            // Assuming there's a stored procedure to call
            return polmanAstraRepository.callProcedure("kba_getListMsSampah", dataList.toArray(new String[0]));
        } catch (Exception e) {
            throw new RuntimeException("Error in fetching list of sampah", e);
        }
    }

    private static final String UPLOAD_DIR = "uploads/";

    public String saveImage(MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(UPLOAD_DIR);

        // Membuat direktori jika belum ada
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Buat nama file unik dan simpan
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filePath.toString(); // Kembalikan path gambar untuk digunakan di front end
    }

    public String updateImage(String path, MultipartFile file) throws IOException {
        // Langkah 1: Dapatkan path gambar yang ada dari database berdasarkan ID
//        String existingImagePath = path;

        // Langkah 2: Hapus gambar yang ada jika ada
        if (path != null) {
            Path existingPath = Paths.get(path);
            if (Files.exists(existingPath)) {
                Files.delete(existingPath); // Menghapus file yang ada
            }
        }

        // Langkah 3: Simpan gambar baru
        return saveImage(file); // Panggil metode saveImage yang sudah ada
    }


}
