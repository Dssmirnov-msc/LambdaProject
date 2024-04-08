/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mephi.smirnov.lambdaproject;

import com.mephi.smirnov.lambdaproject.map.RegionFabric;

/**
 *
 * @author Dima
 */
public class Starter {
    private World world;
    
    public Starter() {
        
    }
    
    public void run(){
        world = new World();
        
        create_organization();
        
        create_regions();
        
        create_start_kindred();
    }
    
    private void create_regions(){
        RegionFabric rf = new RegionFabric();
        for (int i = 0; i < 20; i++) {
            world.addRegion(rf.create());
        }
    }

    private void create_organization() {
        world.addOrganization(new Organization("Camarilla"));
        world.addOrganization(new Organization("Anarchs"));
        world.addOrganization(new Organization("Sabbat"));
        world.addOrganization(new Organization("Thin-blooded"));
    }

    private void create_start_kindred() {
        
    }
}
