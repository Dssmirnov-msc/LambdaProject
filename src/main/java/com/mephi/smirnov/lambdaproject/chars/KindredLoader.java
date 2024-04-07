/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mephi.smirnov.lambdaproject.chars;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.events.*;

/**
 *
 * @author Dmitry
 */
public class KindredLoader {
    
    private Kindred currentReaded;
    private ArrayList<Kindred> readedList;
    private String key;
    private int keyCounter = 0;
    private boolean collectionFlag = false;
    private String collectionTag = "none";
    private int counter = 0;
    private int level;
    public ArrayList<Kindred> getReadedList() {
        return readedList;
    }
    
    public void loadFile(String path) throws FileNotFoundException, IOException {
        Yaml yaml = new Yaml();
        InputStream inputStream = findFile(path);
        Iterable<Event> data = yaml.parse(new InputStreamReader(inputStream));
        readedList = new ArrayList<>();
        handleFile(data);
        inputStream.close();
    }

    private InputStream findFile(String path) throws FileNotFoundException{
        InputStream inputStream = new FileInputStream(path);
        return inputStream;
    }

    private ArrayList<Kindred> handleFile(Iterable<Event> data)  {
        counter = 0;
        for (Event event : data) {
            parseEvent(event);
            counter++;
        }
        
        return null;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void parseEvent(Event event) {
        
        System.out.println(event.getEventId().toString());
        switch(event.getEventId()){
            case StreamStart:
                break;
            case StreamEnd:
                break;
            case DocumentStart:
                createCurrent();
                break;
            case DocumentEnd:
                addCurrentToList();
            case MappingStart:
                parseMapping((MappingStartEvent) event);break;
            case MappingEnd:
                collectionTag = "none";level--;
                break;
            case Scalar:
                parseScalarEvent((ScalarEvent) event);break;
            default:
                break;
                //throw new Exception("UnknownEvent");
        }
    }

    private void parseScalarEvent(ScalarEvent event) {
//        if (collectionFlag) {
//            coolectionTag = event.getValue();
//            collectionFlag = false;
//            return;
//        }
//        
//        
        if(keyCounter==0) {
            key = event.getValue();
            keyCounter++;
        } else {
            String value = event.getValue();
            currentReaded.addCharacteristic(key, value, collectionTag);
            keyCounter = 0;
        }
        
    }
    

    private void createCurrent() {
        this.currentReaded = KindredCreator.create();
    }

    private void addCurrentToList() {
        this.readedList.add(currentReaded);
    }

    private void parseMapping(MappingStartEvent mappingStartEvent) {
        if (level > 0){
            collectionFlag = true;
            keyCounter = 0;
            collectionTag = key;
        }
    }
    
    
}
