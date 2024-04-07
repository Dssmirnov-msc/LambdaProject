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
import java.io.StringReader;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;

/**
 *
 * @author Dmitry
 */
public class KindredLoaderTest {
    
    public KindredLoaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    @Test
    public void testParseManyDocuments() {
        Yaml yaml = new Yaml();
        Event e = null;
        int counter = 0;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("./WorldFiles/Methuselahs.yml");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KindredLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Event event : yaml.parse(new InputStreamReader(inputStream))) {
            System.out.println(event.getEventId().toString());
          if (e == null) {
            assertTrue(event instanceof StreamStartEvent);
          }
          e = event;
          System.out.println(event.toString());
          counter++;
        }
        System.out.println("End");
        assertTrue(e instanceof StreamEndEvent);
        assertEquals(82, counter);
    }
    
    /**
     * Test of loadFile method, of class CharacterLoader.
     */
    
    
    
    @Test
    public void testLoadFile() {
        System.out.println("loadFile");
        KindredLoader instance = new KindredLoader();
        try {
            instance.loadFile("./WorldFiles/Methuselahs.yml");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KindredLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("FileNotFoundException");
        } catch(UnsupportedOperationException ex){
            fail("UnsupportedOperationException");
        } catch (IOException ex) {
            Logger.getLogger(KindredLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("IOException");
        } catch (Exception ex) {
            Logger.getLogger(KindredLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        System.out.println("End");
    }
    
    @Test
    public void testParse(){
        Yaml yaml = new Yaml();
        Iterator<Event> events = yaml.parse(new StringReader("%YAML 1.1\n---\na")).iterator();
        assertTrue(events.next() instanceof StreamStartEvent);
        DocumentStartEvent doc = (DocumentStartEvent) events.next();
        Map<String, String> ff = doc.getTags();
        for (Map.Entry<String, String> entry : ff.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
        }
    }

}
