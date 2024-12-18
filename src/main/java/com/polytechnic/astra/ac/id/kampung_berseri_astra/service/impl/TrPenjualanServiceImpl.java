package com.polytechnic.astra.ac.id.kampung_berseri_astra.service.impl;

import com.polytechnic.astra.ac.id.kampung_berseri_astra.service.TrPenjualanService;

import com.polytechnic.astra.ac.id.kampung_berseri_astra.repository.PolmanAstraRepository;
import com.polytechnic.astra.ac.id.kampung_berseri_astra.service.TrPenjualanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional

public class TrPenjualanServiceImpl implements TrPenjualanService {

    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String getDataPenjualan(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
//        String result = polmanAstraRepository.callProcedure("kba_getDataPenjualan", dataList.toArray(new String[0]));
        String result = polmanAstraRepository.callProcedure("kba_getListTrPenjualan", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String getDataPenjualanById(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_getDataPenjualanById", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String createPenjualan(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_createPenjualan", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String detailPenjualan(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_detailPenjualan", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String editPenjualan(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_editPenjualan", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String setStatusPenjualan(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_setStatusPenjualan", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String getListPenjualan(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kba_getListPenjualan", dataList.toArray(new String[0]));
        return result;
    }

}

