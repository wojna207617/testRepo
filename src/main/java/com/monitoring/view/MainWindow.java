package com.monitoring.view;

import com.monitoring.logic.ErrorLogRecord;
import com.monitoring.logic.ErrorsRepository;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

/**
 * Created by dawid.wojna on 31.10.2016.
 */
public class MainWindow extends JFrame{
    private JLabel errorName;
    private JList errorsList;
    private JPanel scrollPane;
    private ErrorsRepository repository=ErrorsRepository.getInstance();

    public MainWindow()
    {
        super("S.T.A.L.K.E.R.");
        
        
        System.out.println("\n\nStan repo:\n\n");
        String labels[] = new String[repository.getList().size()];
        
        int i=0;
        for(ErrorLogRecord r : repository.getList())
        {
        	labels[i]=r.toString();
        	System.out.println(labels[i]);
        	i++;
        }
        //errorsList.add();
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JList list = new JList(labels);
        Container contentPane = this.getContentPane();
        
        JScrollPane scrollPane_1 = new JScrollPane();
        getContentPane().add(scrollPane_1, BorderLayout.SOUTH);

        this.setSize(500, 500);
        this.setVisible(true);

    }
}
