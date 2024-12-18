package com.polytechnic.astra.ac.id.kampung_berseri_astra.service;

import java.util.Map;

public interface TrSetorSampahService {
    String getDataSetorSampah(Map<String, Object> data);
    String getDataSetorSampahById(Map<String, Object> data);
    String createSetorSampah(Map<String, Object> data);
    String detailSetorSampah(Map<String, Object> data);
    String editSetorSampah(Map<String, Object> data);
    String setStatusSetorSampah(Map<String, Object> data);
    String getListSetorSampah(Map<String, Object> data);
}

