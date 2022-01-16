/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author plank
 */

import java.util.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSON2hashDictonary {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) 
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        HashMap<String,List<String>> word2meaning = new HashMap<String,List<String>>();

        try (FileReader reader = new FileReader("data.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            Set<String> wordkeys = jsonObject.keySet();
            int len = wordkeys.size();
            
            
            for(String word : wordkeys){
                if(!word2meaning.containsKey(word)){
                    word2meaning.put(word,new ArrayList<String>());
                }
                JSONArray meaningArr = (JSONArray)jsonObject.getOrDefault(word, null);
                int lengthMeaning = meaningArr.size();
                for(int ii = 0; ii < lengthMeaning; ii++){
                    word2meaning.get(word).add(meaningArr.get(ii).toString());
//                    System.out.println(word + " : "+word2meaning.containsKey(word)+" : "
//                            + word2meaning.get(word).getClass());
                    }
            }
            
            
//            Set<String> wordskeys = word2meaning.keySet();
//            for(String w : wordskeys){
//                System.out.println(w + " : "+word2meaning.get(w));
//            }
            
//            JSONArray arr = (JSONArray)jsonObject.getOrDefault("acid", null);
//            if(arr != null){
//                int len =  arr.size();
//                for(int i =0; i < len; i++){
//                    System.out.println(arr.get(i).toString());
//                }
//            }
//            for(String word : keys){
//                System.out.println(word);
//            }
            
//            JSONArray array = new JSONArray();
//            
//            array.add(obj);
//            System.out.println(array);
//             
            //Iterate over employee array
            //employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        try {
            FileOutputStream myFileOutStream = new FileOutputStream("DictonaryHashMap.txt");
  
            ObjectOutputStream myObjectOutStream
                = new ObjectOutputStream(myFileOutStream);
  
            myObjectOutStream.writeObject(word2meaning);
  
            // closing FileOutputStream and
            // ObjectOutputStream
            myObjectOutStream.close();
            myFileOutStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
