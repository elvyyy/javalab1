package ru.com.java.handlers;

import ru.com.java.models.Angle;
import ru.com.java.view.MainWindow;

public class AngleTypeController {
    MainWindow mainWindow;

    AngleTypeController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    public void setAngleType(double degrees) {
        int cornerType = Angle.getTypeOf(degrees);
        switch (cornerType) {
            case Angle.OBTUSE_CORNER: {
                mainWindow.getAngleLabel().setText("Тупой угол");
                break;
            }

            case  Angle.RIGHT_ANGLE: {
                mainWindow.getAngleLabel().setText("Угол прямой");
                break;
            }

            case Angle.SHARP_CORNER: {
                mainWindow.getAngleLabel().setText("Угол острый");
                break;
            }
        }
    }
}
