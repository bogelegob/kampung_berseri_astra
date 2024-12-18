package com.polytechnic.astra.ac.id.kampung_berseri_astra.service.impl;

import com.polytechnic.astra.ac.id.kampung_berseri_astra.repository.PolmanAstraRepository;
import com.polytechnic.astra.ac.id.kampung_berseri_astra.service.TrSetorSampahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional

public class TrSetorSampahServiceImpl implements TrSetorSampahService {

    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String getDataSetorSampah(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
//        String result = polmanAstraRepository.callProcedure("kba_getDataSetorSampah", dataList.toArray(new String[0]));
        String result = polmanAstraRepository.callProcedure("kba_getListTrSetorSampah", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String getDataSetorSampahById(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_getDataSetorSampahById", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String createSetorSampah(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_createSetorSampah", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String detailSetorSampah(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_detailSetorSampah", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String editSetorSampah(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_editSetorSampah", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String setStatusSetorSampah(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_setStatusSetorSampah", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String getListSetorSampah(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_getListSetorSampah", dataList.toArray(new String[0]));
        return result;
    }

}

