package com.zzh.service;

import com.zzh.domain.Girl;
import com.zzh.enums.ResultEnum;
import com.zzh.exception.GirlException;
import com.zzh.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/3.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        /**
         * 如果没有事务注解
         * 正确的girlB放在girlA前面
         * 数据库还是会存储girlB的信息
         */
        Girl girlB = new Girl();
        girlB.setCupSize("G");
        girlB.setAge(19);
        girlRepository.save(girlB);

        Girl girlA = new Girl();
        girlA.setCupSize("DDDD");
        girlA.setAge(18);
        girlRepository.save(girlA);

    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            //返回你还在上小学吧 code = 100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            //返回你可能在上初中 code = 101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}
