/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Tweet;
import model.User;
import persistence.Persistence;
import view.View;

/**
 *
 * @author kevingamboa17
 */
public class ControllerView implements ActionListener{
    View view;

    public ControllerView(View view) {
        this.view = view;
        this.view.getjButton_ShowTweets().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (view.getjButton_ShowTweets() == e.getSource()){
            //Provisional Code
            //Init the controller
            Controller controller = new Controller();
            
            String fileName = getFileName();
            try {
                ArrayList<Tweet> arrayTweets = controller.getTweets(fileName);
                fillJtable(arrayTweets);
                
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(ControllerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void fillJtable(ArrayList<Tweet> arrayTweets){
         JTable jtable = view.getjTable_Tweets();
         String[] tuitInfo = new String[2];
         DefaultTableModel model = new DefaultTableModel();
         model.addColumn("User");
         model.addColumn("tweet");
         for (Tweet tuit: arrayTweets){
             tuitInfo[0] = "@" + ((User)tuit.getUser()).getScreen_name();
             tuitInfo[1] = tuit.getText();
             model.addRow(tuitInfo);
         }
         jtable.setModel(model);
    }
    
    public String getFileName(){
        switch ((int)view.getjComboBox_TT().getSelectedIndex()){
            case 0:
                return "LocalTweets.txt";
            case 1:
                return "prueba.txt";
            case 2:
                return "fileName3.txt";
            case 3:
                return "fileName4.txt";
            case 4:
                return "fileName5.txt";
        }
        return null;
    }
    
    
}
