import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFirstCalculator {

    public static void createAndShowGUI() {
    // Setup
        JFrame jf = new JFrame("My First Calculator");
        String text = "";

    // Pole text i przyciski
        JTextField line = new JTextField(22);
        line.setFont(new Font("Courier", Font.BOLD,22));
        line.setHorizontalAlignment(SwingConstants.RIGHT);
        line.setText(text);

        JButton ZeroButton = new JButton("0");
        ZeroButton.setPreferredSize(new Dimension(65,28));
        JButton OneButton = new JButton("1");
        OneButton.setPreferredSize(new Dimension(65,28));
        JButton TwoButton = new JButton("2");
        TwoButton.setPreferredSize(new Dimension(65,28));
        JButton ThreeButton = new JButton("3");
        ThreeButton.setPreferredSize(new Dimension(65,28));
        JButton FourButton = new JButton("4");
        FourButton.setPreferredSize(new Dimension(65,28));
        JButton FiveButton = new JButton("5");
        FiveButton.setPreferredSize(new Dimension(65,28));
        JButton SixButton = new JButton("6");
        SixButton.setPreferredSize(new Dimension(65,28));
        JButton SevenButton = new JButton("7");
        SevenButton.setPreferredSize(new Dimension(65,28));
        JButton EightButton = new JButton("8");
        EightButton.setPreferredSize(new Dimension(65,28));
        JButton NineButton = new JButton("9");
        NineButton.setPreferredSize(new Dimension(65,28));
        JButton PlusButton = new JButton("+");
        PlusButton.setPreferredSize(new Dimension(65,28));
        JButton MinusButton = new JButton("-");
        MinusButton.setPreferredSize(new Dimension(65,28));
        JButton MulButton = new JButton("*");
        MulButton.setPreferredSize(new Dimension(65,28));
        JButton DivButton = new JButton("/");
        DivButton.setPreferredSize(new Dimension(65,28));
        JButton ClearButton = new JButton("C");
        ClearButton.setPreferredSize(new Dimension(65,28));
        JButton EqualButton = new JButton("=");
        EqualButton.setPreferredSize(new Dimension(65,28));

        jf.getContentPane().add(line);
        jf.getContentPane().add(OneButton);
        jf.getContentPane().add(TwoButton);
        jf.getContentPane().add(ThreeButton);
        jf.getContentPane().add(PlusButton);
        jf.getContentPane().add(FourButton);
        jf.getContentPane().add(FiveButton);
        jf.getContentPane().add(SixButton);
        jf.getContentPane().add(MinusButton);
        jf.getContentPane().add(SevenButton);
        jf.getContentPane().add(EightButton);
        jf.getContentPane().add(NineButton);
        jf.getContentPane().add(MulButton);
        jf.getContentPane().add(ZeroButton);
        jf.getContentPane().add(EqualButton);
        jf.getContentPane().add(ClearButton);
        jf.getContentPane().add(DivButton);

        ZeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(" Button = 0");
            }
        });


        jf.pack();
        jf.setLayout(new FlowLayout());
        jf.setBackground(Color.GRAY);
        jf.setSize(330,210);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
    }

}