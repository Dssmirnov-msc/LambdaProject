/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mephi.smirnov.lambdaproject;

import world.RegionFabric;
import world.World;

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
        create_regions();
    }
    
    private void create_regions(){
        RegionFabric rf = new RegionFabric();
        for (int i = 0; i < 20; i++) {
            world.addRegion(rf.create());
        }
    }
}
