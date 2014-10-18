package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.util.Properties;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;

/**
 *
 * @author  JUAN PABLO CONTRERAS
 */
public class PanelAbout extends JDialog{
 
    private JTextArea jTextAbout;
    private JLabel jLabelImage;
    private Image imagen;
    private JButton jButtonAccept;
    private JPanel jPanelImage;
    private JPanel jPanelButton;
    private JPanel jPanelText;
    private VentanaPrincipal principal;

    public PanelAbout(PanelAcciones acciones, VentanaPrincipal ventanaPrincipal) {
        
       setTitle("About");
       setSize(450, 200);
       setResizable(false);
       setLayout(new BorderLayout());
       setLocationRelativeTo(null);
       
       
       
       //Panel Texto
       jPanelText = new JPanel();
       jPanelText.setSize(235, 200);
       jPanelText.setLayout(new BorderLayout());
       
        jTextAbout = new JTextArea("                WORLD CUP ALMBUN\n"
               +"         Autor: Juan Pablo Contreras Barrera\n"
               +"                    Código: 201311312\n"
               +"                         ©2014\n"
               +"                      Versión: 1.0\n"
               +"            Todos los derechos reservados\n"
               +"          email: juancho.1910@hotmail.com     \n");
       jPanelText.add(jTextAbout,BorderLayout.WEST);
       jTextAbout.setBackground(new Color(57, 88, 19));
       jTextAbout.setFont(new Font("Segoe Print", Font.BOLD, 12));
       jTextAbout.setForeground(Color.white);
       jTextAbout.setEditable(false);
       
       //Panel imagen
       jPanelImage = new JPanel();
       jPanelImage.setSize(165, 200);
       jPanelImage.setLayout(new BorderLayout());
       jLabelImage = new JLabel(new ImageIcon(getClass().getResource("/Img/Logo.png")));
       jPanelImage.add(jLabelImage,BorderLayout.EAST);
           
      
       
           
       //Agregar
         this.add(jPanelText,BorderLayout.WEST);
    
         this.add(jPanelImage,BorderLayout.EAST);
    }
    
    
    
}