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
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;

/**
 *
 * @author Dmitry
 */
public class KindredLoader {
    
    private Kindred currentReaded;
    private ArrayList<Kindred> readedList;
    private String key;
    private int keyCounter = 0;

    public ArrayList<Kindred> getReadedList() {
        return readedList;
    }
    
    public void loadFile(String path) throws FileNotFoundException, IOException, Exception{
        Yaml yaml = new Yaml();
        InputStream inputStream = findFile(path);
        Iterable<Event> data = yaml.parse(new InputStreamReader(inputStream));
        inputStream.close();
        handleFile(data);
    }

    private InputStream findFile(String path) throws FileNotFoundException{
        InputStream inputStream = new FileInputStream(path);
        return inputStream;
    }

    private ArrayList<Kindred> handleFile(Iterable<Event> data) throws Exception {
        for (Event event : data) {
            parseEvent(event);
        }
        
        return null;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void parseEvent(Event event) throws Exception {
        
        
        switch(event.getEventId()){
            case StreamStart:
                break;
            case StreamEnd:
                break;
            case DocumentStart:
                createCurrent();
            case DocumentEnd:
                addCurrentToList();
            case Scalar:
                parseScalarEvent((ScalarEvent) event);
            default:
                throw new Exception("UnknownEvent");
        }
    }

    private void parseScalarEvent(ScalarEvent event) {
        if(keyCounter==0) {
            key = event.getValue();
        } else {
            String value = event.getValue();
            currentReaded.addCharacteristic(key, value);
        }
        
    }
    

    private void createCurrent() {
        this.currentReaded = KindredCreator.create();
    }

    private void addCurrentToList() {
        this.readedList.add(currentReaded);
    }
    
    
}
