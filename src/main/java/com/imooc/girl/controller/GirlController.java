package com.imooc.girl.controller;

import com.imooc.girl.aspect.HttpAspect;
import com.imooc.girl.domain.Girl;
import com.imooc.girl.domain.Result;
import com.imooc.girl.repository.GirlRepository;
import com.imooc.girl.service.GirlService;
import com.imooc.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;
    /**
     * 查询列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            //logger.info(bindingResult.getFieldError().getDefaultMessage());
            //return bindingResult.getFieldError().getDefaultMessage();

            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());


        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return  ResultUtil.success(girlRepository.save(girl));


    }

    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){

        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){

        girlService.inserTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
