/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mephi.smirnov.lambdaproject.map;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
 *
 * @author Dima
 */
public class RegionFabric {
    private final ArrayList<String> name_list;
    private int i = 0;

    public RegionFabric() {
        String[] rg = {"South Priosk","Weem Hills", "Kollald Square","Nopheg Side",
            "Fort Brurrioc","Upper North Plegeap", "Karusp Avenue",
            "Wrettoant East","West Qattithin Corner", "West Smettustram East"};
        name_list = Arrays.stream(rg).collect(() -> new ArrayList<>(),
                                                (c, e) -> c.add(e),
                                                (c1, c2) -> c1.addAll(c2) );
        Collections.shuffle(name_list);
    }
    
    
    
    public Region create() {
        Region region = new Region(name_list.get(i));
        i++;
        return region;
    }
    
}
