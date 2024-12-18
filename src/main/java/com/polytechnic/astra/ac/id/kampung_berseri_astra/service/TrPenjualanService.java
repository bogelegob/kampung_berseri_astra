package com.polytechnic.astra.ac.id.kampung_berseri_astra.service;

import java.util.Map;

public interface TrPenjualanService {
    String getDataPenjualan(Map<String, Object> data);
    String getDataPenjualanById(Map<String, Object> data);
    String createPenjualan(Map<String, Object> data);
    String detailPenjualan(Map<String, Object> data);
    String editPenjualan(Map<String, Object> data);
    String setStatusPenjualan(Map<String, Object> data);
    String getListPenjualan(Map<String, Object> data);
}

