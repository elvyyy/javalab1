package handlers;

import view.MainWindow;

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

        if (Math.abs(degrees) > 90) {
            mainWindow.getAngleLabel().setText("Тупой угол");
        } else if (Math.abs(degrees) == 90) {
            mainWindow.getAngleLabel().setText("Угол прямой");
        } else {
            mainWindow.getAngleLabel().setText("Угол острый");
        }
    }
}
