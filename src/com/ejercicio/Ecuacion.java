package com.ejercicio;

import javax.swing.JOptionPane;

public class Ecuacion {

    public static void main(String[] args) {
        double x, y, z;
        try {
            x = solicitar_x();
            y = solicitar_y();
            z = solicitar_z();
            double resultado = calcular_ecuacion(x, y, z);
            JOptionPane.showMessageDialog(null, "El resultado es: " + String.format("%.2f", resultado));
        } catch (LogaritmoExcepcion e) {
            JOptionPane.showMessageDialog(null, "Error: el valor de x debe ser positivo.");
        } catch (RaizExcepcion e) {
            JOptionPane.showMessageDialog(null, "Error: el valor de y debe ser positivo.");
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "Error: el valor de z no puede ser cero.");
        }
    }

    public static double solicitar_x() throws LogaritmoExcepcion {
        double x = Double.parseDouble(JOptionPane.showInputDialog("Introduce el valor de x:"));
        if (x <= 0) {
            throw new LogaritmoExcepcion();
        }
        return x;
    }

    public static double solicitar_y() throws RaizExcepcion {
        double y = Double.parseDouble(JOptionPane.showInputDialog("Introduce el valor de y:"));
        if (y < 0) {
            throw new RaizExcepcion();
        }
        return y;
    }

    public static double solicitar_z() {
        double z = Double.parseDouble(JOptionPane.showInputDialog("Introduce el valor de z:"));
        return z;
    }

    public static double calcular_ecuacion(double x, double y, double z) {
        double resultado = Math.log10(x) + Math.sqrt(y) + 1/z;
        return resultado;
    }

}

class LogaritmoExcepcion extends Exception {}
class RaizExcepcion extends Exception {}
