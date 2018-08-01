package com.shiny.ucenter.service.impl;

import com.shiny.ucenter.config.cache.IdGenerator;
import com.shiny.ucenter.dao.MenuMapper;
import com.shiny.ucenter.dto.MenuDto;
import com.shiny.ucenter.entity.Menu;
import com.shiny.ucenter.exception.BusinessException;
import com.shiny.ucenter.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/7/18
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private IdGenerator idGenerator;

    @Override
    public List<MenuDto> selectMenuByUserId(String userId) {
        List<Menu> menuList=menuMapper.selectByUserId(userId);
        return changeMenu(menuList);
    }

    @Override
    public boolean addMenu(MenuDto menuDto) throws BusinessException {
        List<MenuDto> childs=menuDto.getChild();
        Long id=idGenerator.next("menu");
        menuDto.setId(String.valueOf(id));
        int count=menuMapper.insert(menuDto.getMenu());
        if(count==0){
            return false;
        }
        if(childs!=null&&childs.size()>0){
            for(MenuDto menu:childs){
                Long childId=idGenerator.next("menu");
                menu.setId(String.valueOf(childId));
                menu.setPid(String.valueOf(id));
                int childCount=menuMapper.insert(menu.getMenu());
                if(childCount==0){
                    throw new BusinessException("插入子节点错误");
                }
            }
        }
        return true;
    }

    List<MenuDto> changeMenu(List<Menu> menuList){
        List<MenuDto> parents=new ArrayList<>();
        Iterator<Menu> allIt=menuList.iterator();
        while(allIt.hasNext()){
            Menu menu=allIt.next();
            String pid=menu.getPid();
            if(StringUtils.isEmpty(pid)){
                parents.add(new MenuDto(menu));
                allIt.remove();
            }
        }
        Iterator<MenuDto> paIt=parents.iterator();
        while (paIt.hasNext()) {
            MenuDto parent=paIt.next();
            String id=parent.getId();
            List<MenuDto> child=new ArrayList<>();
            Iterator<Menu> childIt=menuList.iterator();
            while (childIt.hasNext()){
                Menu menu=childIt.next();
                String pid=menu.getPid();
                if(id.equals(pid)){
                    child.add(new MenuDto(menu));
                    childIt.remove();
                }
            }
            parent.setChild(child);
        }
        return parents;
    }
}
