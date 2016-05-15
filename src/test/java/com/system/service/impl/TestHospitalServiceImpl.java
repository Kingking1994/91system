package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.system.GenericTest;
import com.system.entity.Hospital;
import com.system.service.HospitalService;
import com.system.util.CollectionUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by king on 2016/4/23.
 */
public class TestHospitalServiceImpl extends GenericTest {

    private static final Logger LOGGER = Logger.getLogger(TestHospitalServiceImpl.class);

    @Autowired
    private HospitalService hospitalService;

    @Test
    public void testGet(){
        LOGGER.info(hospitalService.get(1));
    }

    @Test
    public void testFindByQuality(){
        List<Hospital> hospitalList = hospitalService.findByQuality(0);
        String json = JSON.toJSONString(hospitalList);
        LOGGER.info(json);
        if(CollectionUtil.isNotEmpty(hospitalList)){
            for(Hospital hospital : hospitalList){
                LOGGER.info(hospital);
            }
        }
    }

}
