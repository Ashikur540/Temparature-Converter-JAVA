
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Ashikur Rahman
 */
public class ProTempConverter extends JFrame implements ActionListener {

    JComboBox cb, cb1;
    String[] Options = {"Farenhite", "Celcious", "Kelvin"};
    String[] Options1 = {"Celcious", "Farenhite", "Kelvin"};
    JLabel li, l1, l2, l3, l4r,lp;
    JButton b1, b2;
    JTextField tf1;
    ImageIcon img;

    ProTempConverter() {
        components();
    }

    public void components() {
        
        ImageIcon img=new ImageIcon("temp.png");
        
        
         lp = new JLabel();
        lp.setBounds(20, 0, 330, 95);
       lp.setIcon(img); 
        add(lp);
        
        l1 = new JLabel("TEMPARATURE CONVERTER V1.0");
        l1.setBounds(100, 10, 330, 45);
        l1.setFont(new Font("Montserrat", Font.BOLD, 14));
        add(l1);

        li = new JLabel("Enter Value:");//input
        li.setBounds(200, 100, 150, 35);
        add(li);

        tf1 = new JTextField();
        tf1.setBounds(200, 150, 130, 35);
        add(tf1);

        l2 = new JLabel("FROM");
        l2.setBounds(40, 88, 330, 35);
        add(l2);

        l3 = new JLabel("TO");
        l3.setBounds(40, 180, 330, 35);
        add(l3);

        l4r = new JLabel("Result: ?");
        l4r.setBounds(50, 270, 330, 45);
        l4r.setFont(new Font("Montserrat", Font.BOLD, 12));
        add(l4r);

        setLayout(null);
        cb = new JComboBox(Options);
        cb.setBounds(50, 137, 100, 30);
//        cb.setEditable(true);
        add(cb);

        cb1 = new JComboBox(Options);
        cb1.setBounds(50, 230, 100, 30);
//        cb1.setEditable(true);
        add(cb1);

        b1 = new JButton("Exit");
        b1.setBounds(265, 380, 70, 30);
        b1.setBackground(Color.darkGray);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Clear");
        b2.setBounds(50, 380, 70, 30);
        b2.setBackground(Color.ORANGE);
        b2.setForeground(Color.BLACK);
        add(b2);

        getContentPane().setBackground(Color.WHITE);
        setSize(400, 480);
        setLocation(400, 140);
        setVisible(true);

        //action1
        tf1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                String input = tf1.getText();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a number");
                } else {
                    String s = tf1.getText();
//                   JOptionPane.showMessageDialog(null, ""+input);
                }
            }

        });//end of ActionListener
        //action 2
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                dispose();
            }

        });//end of ActionListener
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                tf1.setText("");
                l4r.setText("");
            }

        });//end of ActionListener
//        //action 2
        cb.addActionListener(this);
        cb1.addActionListener(this);
        tf1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    Strtf1.getText();
        String op1 = cb.getSelectedItem().toString();
        String op2 = cb1.getSelectedItem().toString();
        //f-c
        if (op1 == "Celcious" && op2 == "Farenhite") {
            float c;
            c = (float) ((Double.parseDouble(tf1.getText())) * 1.8 + 32);
            l4r.setText("Farenhite: " + c);
        } else if (op1 == "Farenhite" && op2 == "Celcious") {
            float f;
            f = (float) (((Double.parseDouble(tf1.getText())) - 32) * 0.56);
            l4r.setText("Farenhite: " + f);
        } //c-k
        else if (op1 == "Celcious" && op2 == "Kelvin") {
            float c1;
            c1 = (float) (((Double.parseDouble(tf1.getText())) + 273.15));
            l4r.setText("Kelvin: " + c1);
        } else if (op1 == "Kelvin" && op2 == "Celcious") {
            float k;
            k = (float) (((Double.parseDouble(tf1.getText())) - 273.15));
            l4r.setText("Celcious: " + k);
        }
        //f-k
        if (op1 == "Farenhite" && op2 == "Kelvin") {
            float f1;
            f1 = (float) (273.15 + ((Double.parseDouble(tf1.getText())) - 32) * 0.56);
            l4r.setText("Kelvin: " + f1);
        }
        if (op1 == "Kelvin" && op2 == "Farenhite") {
            float k1;
            k1 = (float) (((Double.parseDouble(tf1.getText())) - 273.15) * 1.8 + 32);
//        k1=(9.0 / 5) * (kel - 273.15) + 32
            l4r.setText("Farenhite: " + k1);
        } //empty
        else if (op1 == "Celcious" && op2 == "Celcious") {
            JOptionPane.showMessageDialog(null, "Please select different parameter");
        } else if (op1 == "Farenhite" && op2 == "Farenhite") {
            JOptionPane.showMessageDialog(null, "Please select different parameter");
        }
        //end
    }
    //end of action method

    public static void main(String[] args) {
        ProTempConverter frame = new ProTempConverter();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
