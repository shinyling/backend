package com.shiny.ucenter.dto;

import com.shiny.ucenter.entity.Menu;
import lombok.Data;

import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/7/18
 */
@Data
public class MenuDto{

    private String id;

    private String name;

    private String url;

    private String pid;

    private String icon;

    public MenuDto(Menu menu){
        this.id=menu.getId();
        this.name=menu.getName();
        this.url=menu.getUrl();
        this.pid=menu.getPid();
        this.icon=menu.getIcon();
    }

    private List<MenuDto> child;

    public Menu getMenu(){
        Menu menu=new Menu();
        menu.setName(name);
        menu.setIcon(icon);
        menu.setUrl(url);
        menu.setPid(pid);
        return menu;
    }
}
