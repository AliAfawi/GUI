import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lab4OnlyMain {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Box Volume & area");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout b = new BorderLayout();
        b.setHgap(20);
        b.setVgap(20);
        frame.setLayout(b);

        JPanel p1 = new JPanel();
        GridLayout g1 = new GridLayout(3, 2);

        JTextField txfWidth = new JTextField("width");
        JTextField txfHight = new JTextField("hight");
        JTextField txfLength = new JTextField("length");
        p1.setLayout(g1);
        p1.add(new JLabel("width:"));
        p1.add(txfWidth);
        p1.add(new JLabel("hight:"));
        p1.add(txfHight);
        p1.add(new JLabel("length:"));
        p1.add(txfLength);

        JPanel p2 = new JPanel();
        FlowLayout f = new FlowLayout();
        f.setVgap(30);
        p2.setLayout(f);
        JButton btnCalc = new JButton("Calculate");
        JLabel lblVolume = new JLabel("Volume");
        JLabel lblArea = new JLabel("Area");
        btnCalc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lblArea.setText("Area = " + calcArea());
                lblVolume.setText("Volume = " + calcVolume());
                // resize frame due to text change
                frame.pack();
            }

            private String calcArea() {
                int res = 0;
                res += Integer.parseInt(txfHight.getText()) * Integer.parseInt(txfLength.getText()) * 2;
                res += Integer.parseInt(txfHight.getText()) * Integer.parseInt(txfWidth.getText()) * 2;
                res += Integer.parseInt(txfWidth.getText()) * Integer.parseInt(txfLength.getText()) * 2;
                return String.valueOf(res);
            }

            private String calcVolume() {
                return String.valueOf((Integer.parseInt(txfHight.getText())) * (Integer.parseInt(txfLength.getText()))
                        * (Integer.parseInt(txfWidth.getText())));
            }
        });

        p2.add(btnCalc);
        p2.add(lblArea);
        p2.add(lblVolume);
        frame.getContentPane().add(p1, BorderLayout.NORTH);
        frame.getContentPane().add(p2, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

    }

}
