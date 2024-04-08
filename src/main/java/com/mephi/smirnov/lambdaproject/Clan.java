/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mephi.smirnov.lambdaproject;

/**
 *
 * @author Dima
 */
public class Clan {
    
    private String name;
    
    Clan(String name) {
        this.name = name;
    }
            
            
    public static Clan chooseClan(String clanName){
        ClanEnum foo = ClanEnum.valueOf(clanName);
        return new Clan(foo.getTitle());
    }

    public String getName() {
        return name;
    }

    
}
