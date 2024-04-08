/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mephi.smirnov.lambdaproject.chars;

/**
 *
 * @author Dima
 */
public class Ability {
    private String title;
    private int level;
    
    Ability(String title, int level){
        this.level = level;
        this.title = title;
    }
    
    public static Ability create(String key, int level){
        String title = AbilityEnum.valueOf(key.toUpperCase()).getTitle();
        return new Ability(title, level);
    }
    
}
