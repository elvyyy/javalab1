package handlers;

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

        if (Math.abs(degrees) > 90) {
            mainWindow.getAngleLabel().setText("Тупой угол");
        } else if (Math.abs(degrees) == 90) {
            mainWindow.getAngleLabel().setText("Угол прямой");
        } else {
            mainWindow.getAngleLabel().setText("Угол острый");
        }
    }
}
