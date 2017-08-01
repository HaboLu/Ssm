package com.study.ssm.service.impl;

import com.study.ssm.dao.ItemsMapper;
import com.study.ssm.domain.Items;
import com.study.ssm.service.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by luhaobin on 2017/7/14.
 */

@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {

    @Resource
    private ItemsMapper itemsMapper;

    public List<Items> findAll() {
        List<Items> list = itemsMapper.findAll();
        return list;
    }

    public Items finByID(Integer id) {
        Items items = itemsMapper.selectByPrimaryKey(id);
        return items;
    }

    public void saveOrUpdate(Items items) {

        itemsMapper.updateByPrimaryKey(items);

    }

    public void deleteByID(Integer id) {

        itemsMapper.deleteByPrimaryKey(id);

    }
}
