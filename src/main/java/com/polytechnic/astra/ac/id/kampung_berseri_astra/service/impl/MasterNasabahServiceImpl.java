package com.polytechnic.astra.ac.id.kampung_berseri_astra.service.impl;

import com.polytechnic.astra.ac.id.kampung_berseri_astra.repository.PolmanAstraRepository;
import com.polytechnic.astra.ac.id.kampung_berseri_astra.service.MasterNasabahService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MasterNasabahServiceImpl implements MasterNasabahService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;
    @Override
    public String getDataNasabah(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_getListMsNasabah", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String createNasabah(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_createMsNasabah", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String editNasabah(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_updateMsNasabah", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String setStatusNasabah(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_setStatusMsNasabah", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String getNasabahById(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kab_getDataMsNasabahById", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String detailNasabah(Map<String, Object> data) {
        try {
            List<String> dataList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                dataList.add(entry.getValue().toString());
            }
            return polmanAstraRepository.callProcedure("kba_detailNasabah", dataList.toArray(new String[0]));
        } catch (Exception e) {
            throw new RuntimeException("Error detail in fetching nasabah", e);
        }
    }

    @Override
    public String getListNasabah(Map<String, Object> data) {
        try {
            List<String> dataList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                dataList.add(entry.getValue().toString());
            }
            // Assuming there's a stored procedure to call
            return polmanAstraRepository.callProcedure("kba_getListMsNasabah", dataList.toArray(new String[0]));
        } catch (Exception e) {
            throw new RuntimeException("Error in fetching list of nasabah", e);
        }
    }

    private static final String UPLOAD_DIR = "uploads/";

    public String saveImageNasabah(MultipartFile file) throws IOException {
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
        return saveImageNasabah(file); // Panggil metode saveImage yang sudah ada
    }
}
