/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ieee;

import javax.swing.JOptionPane;

/**
 *
 * @author VALENTINA
 */
public class ControladorIEEE {
    private VistaIEEE vista; 
 

    public ControladorIEEE(VistaIEEE vista) {
        this.vista = vista;
    }
    
      public void convertirADecimalIEEE() {
            String numeroTexto = vista.getTxtNumAIEEE().getText();
            if (numeroTexto.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Profe Ingrese un número válido :C.");
                return;
            }
            
            double numero = Double.parseDouble(numeroTexto);
            String formato = (String) vista.getCmbFormDecAIEEE().getSelectedItem();
            
            String resultado = convertirDecimalAIEEE(numero, formato);
            
            vista.getTxtSigno().setText(resultado.substring(0, 1));
            vista.getTxtExponente().setText(resultado.substring(1, 9));
            vista.getTxtMantisa().setText(resultado.substring(9));
    }
    
    public void convertirAIEEEADecimal() {
            String numeroIEEE = vista.getTxtIEEEANum().getText();
            if (numeroIEEE.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Teacher ingrese un número IEEE válido.");
                return;
            }
            
            String formato = (String) vista.getCmbFormIEEADec().getSelectedItem();
            double resultado = convertirIEEEADecimal(numeroIEEE, formato);
            
            vista.getTxtNumEnDec().setText(String.valueOf(resultado));
   
    }
    
    private String convertirDecimalAIEEE(double numero, String formato) {
        
        if ("Precisión Simple".equals(formato)) {
            return String.format("%32s", Integer.toBinaryString(Float.floatToIntBits((float) numero))).replace(' ', '0');
        } else {
            return String.format("%64s", Long.toBinaryString(Double.doubleToLongBits(numero))).replace(' ', '0');
        }
    }
    
    private double convertirIEEEADecimal(String numeroIEEE, String formato) {
        if ("Precisión Simple".equals(formato)) {
            int intBits = Integer.parseUnsignedInt(numeroIEEE, 2);
            return Float.intBitsToFloat(intBits);
        } else {
            long longBits = Long.parseUnsignedLong(numeroIEEE, 2);
            return Double.longBitsToDouble(longBits);
        }
    }
}
