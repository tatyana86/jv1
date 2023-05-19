package ThreeDimFigures; // пакет для работы с трехмерными фигурами

import TwoDimFigures.Triangle;

public class Tetrahedron {
    // a - основание треугольника - одной из граней тетраэдра
    // h - высота, проведенная к основанию a
    // H - высота тетраэдра, опущенная к выбранной грани
    public static double volume(double a, double h, double H) {
        double S = Triangle.square(a, h);
        return S * H / 3;
    }
}