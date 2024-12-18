package com.polytechnic.astra.ac.id.kampung_berseri_astra.service.impl;

import com.polytechnic.astra.ac.id.kampung_berseri_astra.repository.PolmanAstraRepository;
import com.polytechnic.astra.ac.id.kampung_berseri_astra.service.MasterPengurusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MasterPengurusServiceImpl implements MasterPengurusService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String getDataPengurus(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_getListMsPengurus", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String createPengurus(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_createMsPengurus", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String editPengurus(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_updateMsPengurus", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String setStatusPengurus(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_setStatusMsPengurus", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String getPengurusById(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kab_getDataMsPengurusById", dataList.toArray(new String[0]));
        return result;
    }
}
