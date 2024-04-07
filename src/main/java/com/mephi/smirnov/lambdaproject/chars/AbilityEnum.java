/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mephi.smirnov.lambdaproject.chars;

/**
 *
 * @author Dmitry
 */
public enum AbilityEnum {
    
    STRENGTH ("strength"),
    DEXTERITY ("dexterity"),
    STAMINA ("stamina"),
    CHARISMA ("charisma"), 
    MANIPULATION ("manipulation"),
    APPEARANCE ("appearance"), 
    PERCEPTION ("perception"), 
    INTELLIGENCE ("intelligence"), 
    WITS ("wits"), ;
    
    
    private String title;

    private AbilityEnum(String title) {
        this.title = title;
    }
    
    public String getTitle() {
       return title;
   }
    
}
