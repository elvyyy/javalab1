package ru.com.java.handlers;

import ru.com.java.view.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateRadiansHandler implements ActionListener {
    private MainWindow mainWindow;

    public CalculateRadiansHandler(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double degrees;
        try {
            degrees = Double.valueOf(mainWindow.getDegreeField().getText());
        } catch (Exception exc) {
            mainWindow.getAngleLabel().setText("Ошибка ввода");
            return;
        }
        double radians = Math.toRadians(degrees);
        mainWindow.getRadiansField().setText(String.valueOf(radians));

        AngleTypeController angleTypeController = new AngleTypeController(mainWindow);
        angleTypeController.setAngleType(degrees);
    }
}
