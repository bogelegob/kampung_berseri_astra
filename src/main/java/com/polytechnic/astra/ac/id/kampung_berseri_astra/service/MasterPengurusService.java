package com.polytechnic.astra.ac.id.kampung_berseri_astra.service;

import java.util.Map;

public interface MasterPengurusService {
    String getDataPengurus(Map<String, Object> data);
    String createPengurus(Map<String, Object> data);
    String editPengurus(Map<String, Object> data);
    String setStatusPengurus(Map<String, Object> data);
    String getPengurusById(Map<String, Object> data);
}
