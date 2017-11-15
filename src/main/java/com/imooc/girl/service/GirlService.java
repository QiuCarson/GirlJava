package com.imooc.girl.service;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.enums.ResultEnum;
import com.imooc.girl.exception.GileException;
import com.imooc.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void inserTwo(){
        Girl girl=new Girl();
        girl.setAge(14);
        girl.setCupSize("C");
        girlRepository.save(girl);

        Girl girlB=new Girl();
        girlB.setAge(16);
        girlB.setCupSize("DD");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id)throws Exception{
        Girl girl=girlRepository.findOne(id);
        Integer age=girl.getAge();
        if(age<10){
            //上小学 code=100
            throw new GileException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age>10 && age<16){
            //上初中 code=101
            throw new GileException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
