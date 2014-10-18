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
        
       setTitle("Acerca de");
       setSize(450, 200);
       setResizable(false);
       setLayout(new BorderLayout());
       setLocationRelativeTo(null);
       
       
       
       //Panel Texto
       jPanelText = new JPanel();
       jPanelText.setSize(235, 200);
       jPanelText.setLayout(new BorderLayout());
       
       
        jTextAbout = new JTextArea("                     VIAS BOYACÁ\n"
        	   +"                    Versión: 1.0\n"
        	   +"                         2014\n"
        	   +"                    CONTACTO \n"
        	   +"           David Leonardo Cardenas\n"
        	   +"      david.cardenas01@uptc.edu.co\n"
               +"              Juan Pablo Contreras\n"
               +"      juan.contreras01@uptc.edu.co\n"
               +"     Todos los derechos reservados   \n");
       
        jTextAbout.setFont(new Font("Lucida Fax", Font.BOLD, 14));
        jTextAbout.setForeground(Color.BLACK);
        jTextAbout.setEditable(false);
        jTextAbout.setFocusable(false);
        jTextAbout.setBorder(null);
        jTextAbout.setBackground(new Color(214, 217, 223));
        jPanelText.add(jTextAbout,BorderLayout.WEST);
     
       
       //Panel imagen
       jPanelImage = new JPanel();
       jPanelImage.setSize(165, 200);
       jPanelImage.setLayout(new BorderLayout());
       jLabelImage = new JLabel(new ImageIcon(getClass().getResource("/img/Icon.png")));
       jPanelImage.add(jLabelImage,BorderLayout.EAST);
           
      
       
           
       //Agregar
         this.add(jPanelText,BorderLayout.WEST);
    
         this.add(jPanelImage,BorderLayout.EAST);
    }
    
    
}