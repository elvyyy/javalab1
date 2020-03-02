package ru.com.java.view;

import ru.com.java.handlers.CalculateDegreesHandler;
import ru.com.java.handlers.CalculateRadiansHandler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;


public class MainWindow {
    private JFrame mainFrame;
    private JLabel degreeLabel;
    private JLabel radiansLabel;
    private JLabel angleLabel;
    private JTextField degreeField;
    private JTextField radiansField;
    private JButton convertDegreesToRadiansButton;
    private JButton convertRadiansToDegreesButton;


    public MainWindow() {
        init();
    }

    private void init() {
        mainFrame = new JFrame("Main Window");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 230);
        mainFrame.setMinimumSize(new Dimension(400, 200));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(dim.width / 2 - 200, dim.height / 2 - 150);

        degreeLabel = new JLabel("Градусы");
        radiansLabel = new JLabel("Радианы");
        angleLabel = new JLabel("Угол");
        degreeField = new JTextField();
        radiansField = new JTextField();
        convertDegreesToRadiansButton = new JButton("Посчитать радианы");
        convertRadiansToDegreesButton = new JButton("Посчитать градусы");

        convertDegreesToRadiansButton.addActionListener(new CalculateRadiansHandler(this));
        convertRadiansToDegreesButton.addActionListener(new CalculateDegreesHandler(this));
    }

    public void exec() {
    EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                createView();
                mainFrame.setVisible(true);
            }
        });
    }

    private void createView() {
        Container container = mainFrame.getContentPane();
        GridBagLayout gridBagLayout = new GridBagLayout();
        container.setLayout(gridBagLayout);
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);


        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.01;
        constraints.weighty = 0.3;
        constraints.anchor = GridBagConstraints.LAST_LINE_START;
        constraints.insets = new Insets(0, 40, 5, 0);
        container.add(this.degreeLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 0.3;
        constraints.anchor = GridBagConstraints.LAST_LINE_START;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0, 10, 5, 40);
        container.add(this.degreeField, constraints);


        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.01;
        constraints.weighty = 0.1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(15, 40, 5, 0);
        container.add(this.radiansLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weighty = 0.1;
        constraints.weightx = 1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(15, 10, 5, 40);
        container.add(this.radiansField, constraints);


        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1;
        constraints.weighty = 0.005;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0, 40, 0, 0);
        container.add(this.angleLabel, constraints);


        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx = 1;
        constraints.weighty = 0.3;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.NONE;

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(this.convertRadiansToDegreesButton);
        buttonPanel.add(this.convertDegreesToRadiansButton);
        container.add(buttonPanel, constraints);
    }

    public JLabel getAngleLabel() {
        return angleLabel;
    }

    public JTextField getDegreeField() {
        return degreeField;
    }

    public JTextField getRadiansField() {
        return radiansField;
    }
}
