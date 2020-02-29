package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.constant.Constable;
import java.util.concurrent.Flow;

public class MainWindow {

    private JFrame frame;


    public MainWindow() {
        frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - 200, dim.height / 2 - 150);


        Container container = frame.getContentPane();
        GridBagLayout gridBagLayout = new GridBagLayout();
        container.setLayout(gridBagLayout);
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);


        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.2;
        constraints.weighty = 0.7;
        constraints.anchor = GridBagConstraints.LAST_LINE_END;
        constraints.insets = new Insets(0, 0, 5, 0);
        JLabel degreeLabel = new JLabel("Градусы");
        container.add(degreeLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 0.7;
        constraints.anchor = GridBagConstraints.LAST_LINE_START;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0, 10, 5, 40);
        JTextField degreeField = new JTextField();
        container.add(degreeField, constraints);


        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.2;
        constraints.weighty = 0.5;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.fill = GridBagConstraints.NONE;
        JLabel radiansLabel = new JLabel("Радианы");
        constraints.insets = new Insets(0, 0, 5, 0);
        container.add(radiansLabel, constraints);
//
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weighty = 1;
        constraints.weightx = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0, 10, 5, 40);
        JTextField radiansField = new JTextField();
        container.add(radiansField, constraints);


        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1;
        constraints.weighty = 0.005;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0, 0, 0, 0);
        JLabel angleLabel = new JLabel("Угол");
        container.add(angleLabel, constraints);


        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.NONE;

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton convertDegreesToRadiansButton = new JButton("Посчитать градусы");
        JButton convertRadiansToDegreesButton = new JButton("Посчитать радианы");
        buttonPanel.add(convertDegreesToRadiansButton);
        buttonPanel.add(convertRadiansToDegreesButton);
        container.add(buttonPanel, constraints);

        convertDegreesToRadiansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked");
                degreeField.setText("abs");
            }
        });
//
//        constraints.gridx = 1;
//        constraints.gridy = 3;
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        constraints.gridwidth = 1;
//        constraints.anchor = GridBagConstraints.WEST;
//        constraints.fill = GridBagConstraints.NONE;
//        JButton convertRadiansToDegreesButton = new JButton("Посчитать радианы");
//        container.add(convertRadiansToDegreesButton);
    }

    private void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

    public void show() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }

}
