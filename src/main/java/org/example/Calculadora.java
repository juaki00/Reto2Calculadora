package org.example;

import javax.swing.*;

/**
 * Realiza las diferentes operaciones que tienen cada uno de los botones de una calculadora
 */
public class Calculadora {
    /**
     * primer operando del calculo
     */
    JLabel labelOperando1;

    /**
     * segundo operando del calculo
     */
    JLabel labelOperando2;

    /**
     *  y lugar donde se introducen los numeros
     */
    JLabel resultado;

    /**
     * operacion que se va a realizar
     */
    JLabel labelOperacion;

    /**
     * label especial para hacer calculos con un solo operando como raiz cuadrada y el cuadrado
     */
    JLabel labelEspecial;

    /**
     * label especial para poner el signo igual (=)
     */
    JLabel labelEqual;

    /**
     *Constructor Calculadora
     * @param labelOperando1 primer operando del calculo
     * @param labelOperando2 segundo operando del calculo
     * @param resultado resultado del calculo y lugar donde se introducen los numeros
     * @param labelOperacion operacion que se va a realizar
     * @param labelEspecial label especial para hacer calculos con un solo operando como raiz cuadrada y el cuadrado
     * @param labelEqual label especial para poner el signo igual (=)
     */
    public Calculadora(JLabel labelOperando1, JLabel labelOperando2, JLabel resultado, JLabel labelOperacion, JLabel labelEspecial, JLabel labelEqual) {
        this.labelOperando1 = labelOperando1;
        this.labelOperando2 = labelOperando2;
        this.resultado = resultado;
        this.labelEspecial = labelEspecial;
        this.labelOperacion = labelOperacion;
        this.labelEqual = labelEqual;
    }

    /**
     * Se pulsa la tecla raiz
     */
    public void raiz() {
        limpiarIgualYEspecial();

        limpiarOperando2();

        labelEspecial.setText("√" + resultado.getText());
        labelOperacion.setText("");
        labelOperando1.setText("");
        labelEqual.setText("=");
        if(Double.parseDouble(resultado.getText()) >=0) {
            resultado.setText(formatear(Math.sqrt(Double.parseDouble(resultado.getText()))));
        }
        else {
            resultado.setText("0");
        }
    }

    /**
     * Se pulsa la tecla cuadrado
     */
    public void cuadrado() {
        limpiarIgualYEspecial();
        limpiarOperando2();
        labelEspecial.setText(resultado.getText() + "²");
        labelOperacion.setText("");
        labelOperando1.setText("");
        labelEqual.setText("=");
        resultado.setText(formatear(Math.pow(Double.parseDouble(resultado.getText()), 2)));
    }

    /**
     * Se borra el texto del labelEspecial
     */
    private void limpiarEspecial() {
        labelEspecial.setText("");
    }

    /**
     * Se borra el texto de label igual
     */
    private void limpiarIgual() {
        labelEqual.setText("");
    }

    /**
     * Se borra el texto del segundo operando
     */
    private void limpiarOperando2() {
        labelOperando2.setText("");
    }

    /**
     * se borran el texto de label especial y label igual
     */
    private void limpiarIgualYEspecial() {
        limpiarEspecial();
        limpiarIgual();
    }

    /**
     * Se pulsa la tecla invertir (1/x)
     */
    public void invertir() {
        labelOperando1.setText("1");
        labelOperacion.setText("/");
        labelOperando2.setText(resultado.getText());
        labelEqual.setText("=");
        if (!resultado.getText().equals("0")) {
            resultado.setText(formatear(1 / Double.parseDouble(resultado.getText())));
        }
        limpiarEspecial();
    }

    /**
     * se pulsa la tecla borrar
     */
    public void borrarUno() {
        if (!this.resultado.getText().equals("0") && resultado.getText().length() != 1) {
            resultado.setText(resultado.getText().substring(0, resultado.getText().length() - 1));
        } else if (this.resultado.getText().length() == 1) {
            resultado.setText("0");
        }
        limpiarIgualYEspecial();
    }

    /**
     * Se pulsa la tecla limpiar (CE)
     */
    public void limpiar() {
        resultado.setText("0");
        if (labelOperacion.getText().isEmpty() || labelOperando1.getText().equals("0")) {
            labelOperando1.setText("");
        } else {
            labelOperando2.setText("");
        }
        limpiarIgualYEspecial();
    }

    /**
     * Se pulsa la tecla punto
     */
    public void addPunto() {
        if (!resultado.getText().contains(".")) {
            resultado.setText(resultado.getText() + ".");
            limpiarIgualYEspecial();
        }
    }

    /**
     * Se pulsa la tecla vacia (C)
     */
    public void vaciar() {
        this.labelOperando1.setText("");
        this.labelOperando2.setText("");
        this.labelOperacion.setText("");
        this.resultado.setText("0");
        limpiarIgualYEspecial();
    }

    /**
     * Se pulsa la tecla cambiar signo (+/-)
     */
    public void cambiaSigno() {

        if (!resultado.getText().equals("0")) {
            if (this.resultado.getText().charAt(0) == '-') {
                this.resultado.setText(this.resultado.getText().substring(1));

            } else {
                this.resultado.setText("-" + this.resultado.getText());
            }
        }
        limpiarIgualYEspecial();
    }

    /**
     * Se pulsa una tecla de operaciones basicas (+ - * /)
     * @param s operando de la tecla pulsada en formato String
     */
    public void aniadirEspecial(String s) {
        if (!resultado.getText().equals("0")) {
            if (labelOperando1.getText().isEmpty()) {
                labelOperando1.setText(resultado.getText());
                labelOperacion.setText(s);
                resultado.setText("0");
            } else if (labelOperando2.getText().isEmpty()) {

                labelOperando1.setText(resultado());
                labelOperacion.setText(s);
                resultado.setText("0");

            } else {
                labelOperando1.setText(resultado.getText());
                labelOperacion.setText(s);
                resultado.setText("0");
                labelOperando2.setText("");
            }
        }
        limpiarIgualYEspecial();
    }

    /**
     * Calcula el resultado si hay datos en los labels operando1 y operando2
     * @return resultado del calculo o null si no hay datos en los labels operando 1 y operando2
     */
    private String resultado() {

        String resul = null;

        if (!labelOperando1.getText().isEmpty() || !labelOperando1.getText().equals("0")) {
            switch (this.labelOperacion.getText()) {
                case "+":
                    resul = formatear(Double.parseDouble(labelOperando1.getText()) + Double.parseDouble(resultado.getText()));
                    break;
                case "-":
                    resul = formatear(Double.parseDouble(labelOperando1.getText()) - Double.parseDouble(resultado.getText()));
                    break;
                case "/":
                    if (resultado.getText().equals("0") && (labelOperando1.getText().isEmpty() || labelOperando1.getText().equals("0"))) {
                        resul = "0";
                    } else {
                        resul = formatear(Double.parseDouble(labelOperando1.getText()) / Double.parseDouble(resultado.getText()));
                    }
                    break;
                case "x":
                    resul = formatear(Double.parseDouble(labelOperando1.getText()) * Double.parseDouble(resultado.getText()));
                    break;
                case "%":
                    resul = formatear(Double.parseDouble(labelOperando1.getText()) * (Double.parseDouble(resultado.getText()) / 100));
                    break;
            }
        }
        return resul;
    }

    /**
     * Se pulsa la tecla igual
     */
    public void resolver() {
        if (!labelOperando1.getText().isEmpty() && !labelOperando1.getText().equals("0")) {
            labelOperando2.setText(resultado.getText());
            resultado.setText(resultado());
            labelEqual.setText("=");
        }
        limpiarEspecial();

    }

    /**
     * Convierte un double a string y le quita los decimales si el numero es entero
     * @param v numero double
     * @return numero en formato String
     */
    private String formatear(double v) {
        String result;
        if (v % 1 == 0) {
            result = "" + ((int) v);
        } else {
            result = "" + v;
        }
        return result;
    }

    /**
     * Se pulsa una tecla numerica
     * @param i tecla pulsada en formato String
     */
    public void aniadirDigito(String i) {
        if (!labelEqual.getText().isEmpty()) {
            vaciar();
        }
        if (resultado.getText().equals("0")) {
            resultado.setText(i);
        } else {
            resultado.setText(resultado.getText() + i);
        }

        limpiarEspecial();
    }
}