package handlers;

import models.Angle;
import view.MainWindow;

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
            }

            case  Angle.RIGHT_ANGLE: {
                mainWindow.getAngleLabel().setText("Угол прямой");
            }

            case Angle.SHARP_CORNER: {
                mainWindow.getAngleLabel().setText("Угол острый");
            }
        }
    }
}
