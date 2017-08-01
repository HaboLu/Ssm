package com.study.ssm.controller;

import com.study.ssm.domain.Items;
import com.study.ssm.service.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by luhaobin on 2017/7/14.
 */
@Controller
@RequestMapping("/items")
public class ItemsController {


    @Resource
    private ItemsService itemsService;

    //查询所有商品
    @RequestMapping("list")
    public String list(Model model) {
        List<Items> list = itemsService.findAll();
        model.addAttribute("itemsList", list);
        return "itemsList";
    }

    //跳转到修改页面
    @RequestMapping("edit")
    public String edit(Integer id, Model model) {

        //根据Id查询商品
        Items items = itemsService.finByID(id);
        //页面回显
        model.addAttribute("item", items);

        return "editItem";
    }

    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Items items) {

        itemsService.saveOrUpdate(items);

        return "redirect:list.do";
    }

    @RequestMapping("deleteByID")
    public String deleteByID(Integer id) {
        itemsService.deleteByID(id);

        return "redirect:list.do";
    }

    @RequestMapping("deleteByIds")
    public String deleteByIds(Integer[] id) {

        for (Integer ids : id) {
            itemsService.deleteByID(ids);

        }

        return "redirect:list.do";
    }


}
