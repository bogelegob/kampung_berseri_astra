package com.polytechnic.astra.ac.id.kampung_berseri_astra.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface MasterSampahService {
    String getDataSampah(Map<String, Object> data);
    String createSampah(Map<String, Object> data);
    String editSampah(Map<String, Object> data);
    String setStatusSampah(Map<String, Object> data);
    String getSampahById(Map<String, Object> data);
    String detailSampah(Map<String, Object> data);
    String getListSampah(Map<String, Object> data);
    String saveImage(MultipartFile file) throws IOException;
    String updateImage(String path, MultipartFile file) throws IOException;
}

