package ui;

import org.example.Calculadora;

import javax.swing.*;

/**
 * Representa una ventana de una calculadora basica
 */
public class VentanaCalculadora extends JFrame {

    /**
     * Panel principal
     */
    private JPanel principal;

    /**
     * tecla C
     */
    private JButton cButton;

    /**
     * tecla 7
     */
    private JButton b7;

    /**
     * tecla 4
     */
    private JButton b4;

    /**
     * tecla 1
     */
    private JButton b1;

    /**
     * tecla +/-
     */
    private JButton bCambiaSigno;

    /**
     * tecla CE
     */
    private JButton CEButton;

    /**
     * tecla 7
     */
    private JButton button7;

    /**
     * tecla /
     */
    private JButton bDivision;

    /**
     * tecla 8
     */
    private JButton b8;

    /**
     * tecla 9
     */
    private JButton b9;

    /**
     * tecla x
     */
    private JButton bMultiplicacion;

    /**
     * tecla 5
     */
    private JButton b5;

    /**
     * tecla 6
     */
    private JButton b6;

    /**
     * tecla -
     */
    private JButton bResta;

    /**
     * tecla 2
     */
    private JButton b2;

    /**
     * tecla 3
     */
    private JButton b3;

    /**
     * tecla +
     */
    private JButton bSuma;

    /**
     * tecla 0
     */
    private JButton b0;

    /**
     * tecla ,
     */
    private JButton bComa;

    /**
     * tecla =
     */
    private JButton bIgual;

    /**
     * label resultado
     */
    private JLabel resultado;

    /**
     * label con el primer operando
     */
    private JLabel labelOperando1;

    /**
     * label con el segundo operando
     */
    private JLabel labelOperando2;

    /**
     * label con la operacion
     */
    private JLabel labelOperacion;

    /**
     * tecla borrar
     */
    private JButton buttonBorrar;

    /**
     * tecla √
     */
    private JButton raizButton1;

    /**
     * tecla x²
     */
    private JButton cuadradoButton;

    /**
     * tecla 1/2
     */
    private JButton inverButton;

    /**
     * label especial para hacer calculos con un solo operando como raiz cuadrada y el cuadrado
     */
    private JLabel labelEspecial;

    /**
     * label especial para poner el signo igual (=)
     */
    private JLabel labelEqual;

    /**
     * Ventana de una interfaz grafica qu representa una calculadora
     */
    public VentanaCalculadora() {
        this.setContentPane(principal);
        this.setTitle("Calculadora");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFocusable(true);
        this.setAutoRequestFocus(true);
        this.pack();



        Calculadora calculadora = new Calculadora(labelOperando1,labelOperando2,resultado,labelOperacion,labelEspecial,labelEqual);

        //Listeners
        b1.addActionListener(e -> calculadora.aniadirDigito("1"));
        b2.addActionListener(e -> calculadora.aniadirDigito("2"));
        b3.addActionListener(e -> calculadora.aniadirDigito("3"));
        b4.addActionListener(e -> calculadora.aniadirDigito("4"));
        b5.addActionListener(e -> calculadora.aniadirDigito("5"));
        b6.addActionListener(e -> calculadora.aniadirDigito("6"));
        b7.addActionListener(e -> calculadora.aniadirDigito("7"));
        b8.addActionListener(e -> calculadora.aniadirDigito("8"));
        b9.addActionListener(e -> calculadora.aniadirDigito("9"));
        b0.addActionListener(e -> calculadora.aniadirDigito("0"));
        bSuma.addActionListener(e -> calculadora.aniadirEspecial("+"));
        bResta.addActionListener(e -> calculadora.aniadirEspecial("-"));
        bMultiplicacion.addActionListener(e -> calculadora.aniadirEspecial("x"));
        bDivision.addActionListener(e -> calculadora.aniadirEspecial("/"));
        button7.addActionListener(e -> calculadora.aniadirEspecial("%"));
        inverButton.addActionListener(e -> calculadora.invertir());
        bCambiaSigno.addActionListener(e -> calculadora.cambiaSigno());
        cButton.addActionListener(e -> calculadora.vaciar());
        CEButton.addActionListener(e -> calculadora.limpiar());
        buttonBorrar.addActionListener(e -> calculadora.borrarUno());
        bComa.addActionListener(e -> calculadora.addPunto());
        bIgual.addActionListener(e -> calculadora.resolver());
        cuadradoButton.addActionListener(e -> calculadora.cuadrado());
        raizButton1.addActionListener(e -> calculadora.raiz());
    }

    /**
     * Muestra la ventanna calculadora
     */
    public void mostrar() {
        this.setVisible(true);
    }
}
