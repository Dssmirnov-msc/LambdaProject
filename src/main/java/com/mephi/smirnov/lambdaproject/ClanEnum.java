/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mephi.smirnov.lambdaproject;

/**
 *
 * @author Dmitry
 */
public enum ClanEnum {
    TOREADOR ("Toreador"),
    VENTRUE ("Ventrue");
    
    private String title;

    private ClanEnum(String title) {
        this.title = title;
    }
    
    public String getTitle() {
       return title;
   }

}
