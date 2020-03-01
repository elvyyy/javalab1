package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {

    private JFrame frame;


    public MainWindow() {
        initFrame();

        Container container = frame.getContentPane();
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
        JLabel degreeLabel = new JLabel("Градусы");
        container.add(degreeLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 0.3;
        constraints.anchor = GridBagConstraints.LAST_LINE_START;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0, 10, 5, 40);
        JTextField degreeField = new JTextField();
        container.add(degreeField, constraints);


        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.01;
        constraints.weighty = 0.1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.fill = GridBagConstraints.NONE;
        JLabel radiansLabel = new JLabel("Радианы");
        constraints.insets = new Insets(15, 40, 5, 0);
        container.add(radiansLabel, constraints);
//
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weighty = 0.1;
        constraints.weightx = 1;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(15, 10, 5, 40);
        JTextField radiansField = new JTextField();
        container.add(radiansField, constraints);


        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1;
        constraints.weighty = 0.005;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0, 40, 0, 0);
        JLabel angleLabel = new JLabel("Угол");
        container.add(angleLabel, constraints);


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
        JButton convertDegreesToRadiansButton = new JButton("Посчитать радианы");
        JButton convertRadiansToDegreesButton = new JButton("Посчитать градусы");
        buttonPanel.add(convertRadiansToDegreesButton);
        buttonPanel.add(convertDegreesToRadiansButton);
        container.add(buttonPanel, constraints);

        convertDegreesToRadiansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double degrees;
                try {
                    degrees = Double.valueOf(degreeField.getText());
                } catch (Exception exc) {
                    angleLabel.setText("Ошибка ввода");
                    return;
                }
                double radians = Math.toRadians(degrees);
                radiansField.setText(String.valueOf(radians));

                if (Math.abs(degrees) > 90) {
                    angleLabel.setText("Тупой угол");
                } else if (Math.abs(degrees) == 90) {
                    angleLabel.setText("Угол прямой");
                } else {
                    angleLabel.setText("Угол острый");
                }
            }
        });

        convertRadiansToDegreesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double radians;
                try {
                    radians = Double.valueOf(radiansField.getText());
                } catch (Exception exc) {
                    angleLabel.setText("Ошибка ввода");
                    return;
                }
                double degrees = Math.toDegrees(radians);
                degreeField.setText(String.valueOf(degrees));

                if (Math.abs(degrees) > 90) {
                    angleLabel.setText("Тупой угол");
                } else if (Math.abs(degrees) == 90) {
                    angleLabel.setText("Угол прямой");
                } else {
                    angleLabel.setText("Угол острый");
                }
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

    private void initFrame() {
        frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 230);
        frame.setMinimumSize(new Dimension(400, 200));
//        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - 200, dim.height / 2 - 150);
    }

}
