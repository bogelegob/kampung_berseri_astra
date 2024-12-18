package com.polytechnic.astra.ac.id.kampung_berseri_astra.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface MasterNasabahService {
    String getDataNasabah(Map<String, Object> data);
    String createNasabah(Map<String, Object> data);
    String editNasabah(Map<String, Object> data);
    String setStatusNasabah(Map<String, Object> data);
    String getNasabahById(Map<String, Object> data);
    String detailNasabah(Map<String, Object> data);
    String getListNasabah(Map<String, Object> data);
    String saveImageNasabah(MultipartFile file) throws IOException;
    String updateImage(String path, MultipartFile file) throws IOException;
}
