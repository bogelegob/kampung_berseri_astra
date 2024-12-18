package com.polytechnic.astra.ac.id.kampung_berseri_astra.service.impl;

import com.polytechnic.astra.ac.id.kampung_berseri_astra.repository.PolmanAstraRepository;
import com.polytechnic.astra.ac.id.kampung_berseri_astra.service.MasterPembeliService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MasterPembeliServiceImpl implements MasterPembeliService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String getDataPembeli(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_getListMsPembeli", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String createPembeli(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        return polmanAstraRepository.callProcedure("kba_createMsPembeli", dataList.toArray(new String[0]));
    }

    @Override
    public String editPembeli(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        return polmanAstraRepository.callProcedure("kba_updateMsPembeli", dataList.toArray(new String[0]));
    }

    @Override
    public String setStatusPembeli(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        return polmanAstraRepository.callProcedure("kba_setStatusMsPembeli", dataList.toArray(new String[0]));
    }

    @Override
    public String getPembeliById(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        return polmanAstraRepository.callProcedure("kab_getDataMsPembeliById", dataList.toArray(new String[0]));
    }
}
