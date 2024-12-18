package com.polytechnic.astra.ac.id.kampung_berseri_astra.service;

import java.util.Map;

public interface MasterPembeliService {
    String  getDataPembeli(Map<String, Object> data);
    String createPembeli(Map<String, Object> data);
    String editPembeli(Map<String, Object> data);
    String setStatusPembeli(Map<String, Object> data);
    String getPembeliById(Map<String, Object> data);
}
