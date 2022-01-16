/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryapp;

/**
 *
 * @author plank
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.io.*;
import java.util.HashMap;
import java.util.Set;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import java.awt.*;

import java.util.List;

public class DictionaryApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyFrame frame = new MyFrame();
        frame.setTitle("Dictonary");
        ImageIcon image = new ImageIcon("book-icon.png");
        frame.setIconImage(image.getImage());
        
        frame.getContentPane().setBackground(new Color(213,220,203));
        frame.setResizable(false);
    }
    
}
class MyFrame extends JFrame implements ActionListener {
    AutoCompleteTextField field;
    JButton textSubmitButton;
    JButton clearButton;
    JLabel meaningLabel; 
    HashMap<String,List<String>> hash_dictonary;
    
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(500,500));
        field = new AutoCompleteTextField(16);
        textSubmitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        
        
        textSubmitButton.setFont(new Font("Times New Roman",Font.BOLD,17));
        textSubmitButton.addActionListener(this);
        clearButton.setFont(new Font("Times New Roman",Font.BOLD,17));
        clearButton.addActionListener(this);
     
        
        field.setPreferredSize(new Dimension(500,45));
        field.setFont(new Font("Times New Roman",Font.PLAIN,35));
        
        meaningLabel = new JLabel("");
        Border blackline = BorderFactory.createLineBorder(Color.black);
        meaningLabel.setPreferredSize(new Dimension(450,300));
        
        
        
        meaningLabel.setLocation(100, 100);
        meaningLabel.setBounds(700,700,700,700);
        meaningLabel.setBorder(blackline);
        meaningLabel.setForeground(Color.BLACK);
        meaningLabel.setBackground(Color.red);
        
        
        this.add(field);
        this.add(textSubmitButton);
        this.add(clearButton);
        hash_dictonary = addDictonaryWords(field,"DictonaryHashMap.txt");
        this.add(meaningLabel,BorderLayout.SOUTH);
        

        this.pack();
        this.setVisible(true);
        
        
    }
    
    final public HashMap<String,List<String>> 
        addDictonaryWords(AutoCompleteTextField feild, String fileName){
        HashMap<String,List<String>> meaningHashMaps = null;
         
        try 
        {
            java.io.FileInputStream reader = 
                    new java.io.FileInputStream(fileName);
            ObjectInputStream objectInput = new ObjectInputStream(reader);

            meaningHashMaps = (HashMap)objectInput.readObject();
//            
//            Set<String> wordkeys = meaningHashMaps.keySet();
//            String entered = field.getText();
//            for(String word : wordkeys){
//                feild.addPossibility(word);
//            }
            
            return meaningHashMaps;
        } 
        
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
    public void actionPerformed(ActionEvent act){
        if(act.getSource() == textSubmitButton){
            String word = field.getText();
            field.addHistoryWord(word);
            String means = "";
            
            
            List<String> meanings = hash_dictonary.get(word);
            try{
                int meaningNumber = 1;
                means = "<html>";
                for(String w : meanings){
                    means = means + meaningNumber +") ";
                    means = means + w;
                    means = means + "<br/><br/>";
                    meaningNumber++;
                }
                means = means + "</html>";
                meaningLabel.setText(means);
                meaningLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
            } catch(NullPointerException e){
                means = "<html>Meaning Not Found</html>";
                meaningLabel.setForeground(Color.red);
                meaningLabel.setText(means);
            }
            
        }
        if(act.getSource() == clearButton){
            field.setText("");
            meaningLabel.setText("");
        }
    }
}
