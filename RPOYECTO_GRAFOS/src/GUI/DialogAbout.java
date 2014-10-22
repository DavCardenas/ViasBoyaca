package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author  JUAN PABLO CONTRERAS
 */
public class DialogAbout extends JDialog{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea jTextAbout;
    private JLabel jLabelImage;
    private JPanel jPanelImage;
    private JPanel jPanelText;

    public DialogAbout(Events events, WindowsPrincipal windowsPrincipal) {
        
       setTitle("Acerca de");
       setSize(450, 200);
       setResizable(false);
       setLayout(new BorderLayout());
       setLocationRelativeTo(null);
       
       
       
       //Panel Texto
       jPanelText = new JPanel();
       jPanelText.setSize(235, 200);
       jPanelText.setLayout(new BorderLayout());
       
       
        jTextAbout = new JTextArea("                   VIAS BOYACÁ\n"
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