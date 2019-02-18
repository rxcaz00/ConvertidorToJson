package vista;

import controlador.Metodos;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame implements ActionListener {

    private JTextArea ent;
    private JTextArea sal;
    private JButton con;
    private JComboBox sel;
    private JPanel panel;
    private JScrollPane scrollE;
    private JScrollPane scrollS;
    Metodos metodos;

    Border border = BorderFactory.createLineBorder(Color.BLACK,1);

    public Ventana() {
        ent = new JTextArea();
        sal = new JTextArea();
        con = new JButton("Convertir");
        sel = new JComboBox();
        panel = new JPanel();
        metodos = new Metodos();
        panel.setLayout(null);

        scrollE = new JScrollPane(ent);
        scrollE.setBounds(20,60,250,400);
        scrollE.setBorder(border);
        scrollE.setVerticalScrollBarPolicy(20);
        scrollE.setHorizontalScrollBarPolicy(30);

        sal.setEditable(false);
        scrollS = new JScrollPane(sal);
        scrollS.setBounds(500,60,250,400);
        scrollS.setBorder(border);
        scrollS.setVerticalScrollBarPolicy(20);
        scrollS.setHorizontalScrollBarPolicy(30);

        con.setBounds(335,220,100,40);

        sel.addItem("XML");
        sel.addItem("JAVA");
        sel.setBounds(70,470,150,30);

        panel.add(scrollE);
        panel.add(scrollS);
        panel.add(con);
        panel.add(sel);

        con.addActionListener(this);

        this.add(panel);
        this.setSize(new Dimension(800,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String textoE = ent.getText();
        String textoS;
        if(textoE.trim().length() == 0)
            JOptionPane.showMessageDialog(this,"No hay texto","Texto vacío", JOptionPane.WARNING_MESSAGE);
        else {
            if(sel.getSelectedItem().toString() == "XML" && textoE.charAt(0) == '<') {
                textoS = metodos.convertidorXML(textoE);
                if(textoS == "no")
                    JOptionPane.showMessageDialog(this,"Ingrese de nuevo","Formato incorrecto", JOptionPane.WARNING_MESSAGE);
                else
                    sal.setText(textoS);
            }
            if(sel.getSelectedItem().toString() == "JAVA") {
                textoS = metodos.convertidorJAVA(textoE);
                if (textoS == "no")
                    JOptionPane.showMessageDialog(this,"Ingrese de nuevo","Formato incorrecto", JOptionPane.WARNING_MESSAGE);
                else
                    sal.setText(textoS);
            }
        }
    }
}
