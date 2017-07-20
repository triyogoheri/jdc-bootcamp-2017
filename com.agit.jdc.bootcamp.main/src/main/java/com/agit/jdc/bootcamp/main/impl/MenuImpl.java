package com.agit.jdc.bootcamp.main.impl;

import com.agit.jdc.bootcamp.util.JDCStringUtil;
import com.agit.jdc.bootcamp.main.model.Menu;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

import java.net.URL;

public class MenuImpl {

    public List<Menu> getListMenu(String arg) {
        List<Menu> lsRes = new ArrayList<Menu>();
        Map<String, Object> outParam = new LinkedHashMap<String, Object>();

        ObjectMapper mapper = new ObjectMapper();
        try {
            outParam = mapper.readValue(new URL("http://localhost:9091/adira-acction/init/menus.json"), 
                    new TypeReference<HashMap<String, Object>>() {
            });
        } catch (Exception e) {
            System.out.println(e);
        }
        
        List<Map<String, Object>> lsData = (List<Map<String, Object>>) outParam.get("P_RC1");
        for (Map<String, Object> mapData : lsData) {
            Menu m = new Menu();
            m.setFlagDelete((String) JDCStringUtil.nvl(mapData.get("FDELETE"), null));
            m.setIsActive((String) JDCStringUtil.nvl(mapData.get("IS_ACTIVE"), null));
            m.setKeterangan((String) JDCStringUtil.nvl(mapData.get("KETERANGAN"), null));
            m.setLogId((String) JDCStringUtil.nvl(mapData.get("LOG_ID"), null));
            m.setMenuId((String) JDCStringUtil.nvl(mapData.get("ID"), null));
            m.setMenuIdId((String) JDCStringUtil.nvl(mapData.get("MENU_ID"), null));
            m.setMenuLevel((String) JDCStringUtil.nvl(mapData.get("MENU_LEVEL"), null));
            m.setMenuName((String) JDCStringUtil.nvl(mapData.get("MENU_NAME"), null));
            m.setMenuType((String) JDCStringUtil.nvl(mapData.get("MENU_TYPE"), null));
            m.setParentId((String) JDCStringUtil.nvl(mapData.get("PARENT_ID"), null));
            m.setPathContent((String) JDCStringUtil.nvl(mapData.get("PATH_CONTENT"), null));
            m.setSortChild(Integer.parseInt(JDCStringUtil.nvl(mapData.get("SORT_CHILD"), null).toString()));
            lsRes.add(m);
        }
        return lsRes;
    }
}
