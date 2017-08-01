package com.study.ssm.service;

import com.study.ssm.domain.Items;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by luhaobin on 2017/7/14.
 */

public interface ItemsService {


    List<Items> findAll();

    Items finByID(Integer id);

    void saveOrUpdate(Items items);

    void deleteByID(Integer id);
}
