package handlers;

import models.Angle;
import view.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateDegreesHandler implements ActionListener {
    MainWindow mainWindow;

    public CalculateDegreesHandler(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double radians;
        try {
            radians = Double.valueOf(mainWindow.getRadiansField().getText());
        } catch (Exception exc) {
            mainWindow.getAngleLabel().setText("Ошибка ввода");
            return;
        }
        double degrees = Math.toDegrees(radians);
        mainWindow.getDegreeField().setText(String.valueOf(degrees));

        AngleTypeController angleTypeController = new AngleTypeController(mainWindow);
        angleTypeController.setAngleType(degrees);
    }
}
