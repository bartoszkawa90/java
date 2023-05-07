import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MyFirstCalculator{
    JTextField line = new JTextField(22);
    static String[] cyfra = {"0","0","0","0","0"};
    static String operator = "";
    static int nrCyfry = 0;
    static int afterNumber = 0, afterEqual = 0;
    static int result = 0;
    public static void createAndShowGUI() {
    // Setup
        JFrame jf = new JFrame("My First Calculator");
        JPanel jp = new JPanel();
        cyfra[0] = "0";


    // Setup pola tekstowego
        JTextField line = new JTextField(22);
        String text = "0";
        line.setFont(new Font("Courier", Font.BOLD,22));
        line.setHorizontalAlignment(SwingConstants.RIGHT);
        line.setEnabled(false);
        line.setText(text);
        jf.getContentPane().add(line);


    // Przyciski
        JButton ZeroButton = new JButton("0");
        ZeroButton.setPreferredSize(new Dimension(70,30));
        JButton OneButton = new JButton("1");
        OneButton.setPreferredSize(new Dimension(70,30));
        JButton TwoButton = new JButton("2");
        TwoButton.setPreferredSize(new Dimension(70,30));
        JButton ThreeButton = new JButton("3");
        ThreeButton.setPreferredSize(new Dimension(70,30));
        JButton FourButton = new JButton("4");
        FourButton.setPreferredSize(new Dimension(70,30));
        JButton FiveButton = new JButton("5");
        FiveButton.setPreferredSize(new Dimension(70,30));
        JButton SixButton = new JButton("6");
        SixButton.setPreferredSize(new Dimension(70,30));
        JButton SevenButton = new JButton("7");
        SevenButton.setPreferredSize(new Dimension(70,30));
        JButton EightButton = new JButton("8");
        EightButton.setPreferredSize(new Dimension(70,30));
        JButton NineButton = new JButton("9");
        NineButton.setPreferredSize(new Dimension(70,30));
        JButton PlusButton = new JButton("+");
        PlusButton.setPreferredSize(new Dimension(70,30));
        JButton MinusButton = new JButton("-");
        MinusButton.setPreferredSize(new Dimension(70,30));
        JButton MulButton = new JButton("*");
        MulButton.setPreferredSize(new Dimension(70,30));
        JButton DivButton = new JButton("/");
        DivButton.setPreferredSize(new Dimension(70,30));
        JButton ClearButton = new JButton("C");
        ClearButton.setPreferredSize(new Dimension(70,30));
        JButton EqualButton = new JButton("=");
        EqualButton.setPreferredSize(new Dimension(70,30));

        jp.setLayout(new GridLayout(4,4));

        jp.add(OneButton);
        jp.add(TwoButton);
        jp.add(ThreeButton);
        jp.add(PlusButton);
        jp.add(FourButton);
        jp.add(FiveButton);
        jp.add(SixButton);
        jp.add(MinusButton);
        jp.add(SevenButton);
        jp.add(EightButton);
        jp.add(NineButton);
        jp.add(MulButton);
        jp.add(ZeroButton);
        jp.add(EqualButton);
        jp.add(ClearButton);
        jp.add(DivButton);



    // Akcje
        ActionListener myActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (afterEqual == 0) {
                    if (e.getSource() == EqualButton || ((e.getSource() == PlusButton || e.getSource() == MinusButton ||
                            e.getSource() == MulButton || e.getSource() == DivButton) && afterNumber == 1)) {
                        int intCyfry[] = new int[nrCyfry + 1];
                        for (int i = 0; i < nrCyfry + 1; i++) {
                            intCyfry[i] = Integer.parseInt(cyfra[i]);
                            System.out.println(intCyfry[i]);
                        }

                        if (!operator.equals("")) {
                            switch (operator) {
                                case "+":
                                    result = intCyfry[0] + intCyfry[1];
                                    break;
                                case "-":
                                    result = intCyfry[0] - intCyfry[1];
                                    break;
                                case "*":
                                    result = intCyfry[0] * intCyfry[1];
                                    break;
                                case "/":
                                    result = intCyfry[0] / intCyfry[1];
                                    break;

                            }
                            cyfra[0] = Integer.toString(result);
//                            for (int i = 1; i < nrCyfry + 1; i++) {
//                                cyfra[i] = "0";
//                            }
//                            nrCyfry = 0;
                            afterNumber = 0;
                            line.setText(Integer.toString(result));
                        }
                        if (e.getSource() == PlusButton) {
                            operator = "+";
                        } else if (e.getSource() == MinusButton) {
                            operator = "-";
                        } else if (e.getSource() == MulButton) {
                            operator = "*";
                        } else if (e.getSource() == DivButton) {
                            operator = "/";
                        }
                        afterEqual = 1;
                    }
                }
                else if(afterEqual == 1){
                    if (e.getSource() == EqualButton ) {
                        int intCyfry[] = new int[nrCyfry + 1];
                        for (int i = 0; i < nrCyfry + 1; i++) {
                            intCyfry[i] = Integer.parseInt(cyfra[i]);
                            System.out.println(intCyfry[i]);
                        }

                        if (!operator.equals("")) {
                            switch (operator) {
                                case "+":
                                    result = intCyfry[0] + intCyfry[1];
                                    break;
                                case "-":
                                    result = intCyfry[0] - intCyfry[1];
                                    break;
                                case "*":
                                    result = intCyfry[0] * intCyfry[1];
                                    break;
                                case "/":
                                    result = intCyfry[0] / intCyfry[1];
                                    break;

                            }
                            cyfra[0] = Integer.toString(result);
//                            for (int i = 1; i < nrCyfry + 1; i++) {
//                                cyfra[i] = "0";
//                            }
//                            nrCyfry = 0;
                            afterNumber = 0;
                            line.setText(Integer.toString(result));
                        }
//                        if (e.getSource() == PlusButton) {
//                            operator = "+";
//                        } else if (e.getSource() == MinusButton) {
//                            operator = "-";
//                        } else if (e.getSource() == MulButton) {
//                            operator = "*";
//                        } else if (e.getSource() == DivButton) {
//                            operator = "/";
//                        }
//                        afterEqual = 1;
                    }
                }


                if(e.getSource() == ZeroButton){
                    if (afterEqual == 1) {
                        for (int i = 1; i < nrCyfry + 1; i++) {
                            cyfra[i] = "0";
                        }
                        nrCyfry = 1;
                        afterEqual = 0;
                        afterNumber = 0;
                    }
                    cyfra[nrCyfry] = cyfra[nrCyfry] + "0";
                    line.setText(cyfra[nrCyfry]);
                    afterNumber = 1;
                }
                else if (e.getSource() == OneButton) {
                    if (afterEqual == 1) {
                        for (int i = 1; i < nrCyfry + 1; i++) {
                            cyfra[i] = "0";
                        }
                        nrCyfry = 1;
                        afterEqual = 0;
                        afterNumber = 0;
                    }
                    cyfra[nrCyfry] = cyfra[nrCyfry] +  "1";
                    line.setText(cyfra[nrCyfry]);
                    afterNumber = 1;
                }
                else if (e.getSource() == TwoButton) {
                    if (afterEqual == 1) {
                        for (int i = 1; i < nrCyfry + 1; i++) {
                            cyfra[i] = "0";
                        }
                        nrCyfry = 1;
                        afterEqual = 0;
                        afterNumber = 0;
                    }
                    cyfra[nrCyfry] = cyfra[nrCyfry] +  "2";
                    line.setText(cyfra[nrCyfry]);
                    afterNumber = 1;
                }
                else if (e.getSource() == ThreeButton) {
                    if (afterEqual == 1) {
                        for (int i = 1; i < nrCyfry + 1; i++) {
                            cyfra[i] = "0";
                        }
                        nrCyfry = 1;
                        afterEqual = 0;
                        afterNumber = 0;
                    }
                    cyfra[nrCyfry] = cyfra[nrCyfry] +  "3";
                    line.setText(cyfra[nrCyfry]);
                    afterNumber = 1;
                }
                else if (e.getSource() == FourButton) {
                    if (afterEqual == 1) {
                        for (int i = 1; i < nrCyfry + 1; i++) {
                            cyfra[i] = "0";
                        }
                        nrCyfry = 1;
                        afterEqual = 0;
                        afterNumber = 0;
                    }
                    cyfra[nrCyfry] = cyfra[nrCyfry] +  "4";
                    line.setText(cyfra[nrCyfry]);
                    afterNumber = 1;
                }
                else if (e.getSource() == FiveButton) {
                    if (afterEqual == 1) {
                        for (int i = 1; i < nrCyfry + 1; i++) {
                            cyfra[i] = "0";
                        }
                        nrCyfry = 1;
                        afterEqual = 0;
                        afterNumber = 0;
                    }
                    cyfra[nrCyfry] = cyfra[nrCyfry] +  "5";
                    line.setText(cyfra[nrCyfry]);
                    afterNumber = 1;
                }
                else if (e.getSource() == SixButton) {
                    if (afterEqual == 1) {
                        for (int i = 1; i < nrCyfry + 1; i++) {
                            cyfra[i] = "0";
                        }
                        nrCyfry = 1;
                        afterEqual = 0;
                        afterNumber = 0;
                    }
                    cyfra[nrCyfry] = cyfra[nrCyfry] +  "6";
                    line.setText(cyfra[nrCyfry]);
                    afterNumber = 1;
                }
                else if (e.getSource() == SevenButton) {
                    if (afterEqual == 1) {
                        for (int i = 1; i < nrCyfry + 1; i++) {
                            cyfra[i] = "0";
                        }
                        nrCyfry = 1;
                        afterEqual = 0;
                        afterNumber = 0;
                    }
                    cyfra[nrCyfry] = cyfra[nrCyfry] +  "7";
                    line.setText(cyfra[nrCyfry]);
                    afterNumber = 1;
                }
                else if (e.getSource() == EightButton) {
                    if (afterEqual == 1) {
                        for (int i = 1; i < nrCyfry + 1; i++) {
                            cyfra[i] = "0";
                        }
                        nrCyfry = 1;
                        afterEqual = 0;
                        afterNumber = 0;
                    }
                    cyfra[nrCyfry] = cyfra[nrCyfry] +  "8";
                    line.setText(cyfra[nrCyfry]);
                    afterNumber = 1;
                }
                else if (e.getSource() == NineButton) {
                    if (afterEqual == 1) {
                        for (int i = 1; i < nrCyfry + 1; i++) {
                            cyfra[i] = "0";
                        }
                        nrCyfry = 1;
                        afterEqual = 0;
                        afterNumber = 0;
                    }
                    cyfra[nrCyfry] = cyfra[nrCyfry] +  "9";
                    line.setText(cyfra[nrCyfry]);
                    afterNumber = 1;
                }
                else if (e.getSource() == PlusButton) {
                    if (afterEqual == 1) {
                        for (int i = 1; i < nrCyfry + 1; i++) {
                            cyfra[i] = "0";
                        }
                        nrCyfry = 0;
                        afterEqual = 0;
                        afterNumber = 0;
                    }
                    nrCyfry++;
                    operator = "+";
                    afterNumber = 0;
                }
                else if (e.getSource() == MinusButton) {
                    if (afterEqual == 1) {
                        for (int i = 1; i < nrCyfry + 1; i++) {
                            cyfra[i] = "0";
                        }
                        nrCyfry = 0;
                        afterEqual = 0;
                        afterNumber = 0;
                    }
                    nrCyfry++;
                    operator = "-";
                    afterNumber = 0;
                }
                else if (e.getSource() == MulButton) {
                    if (afterEqual == 1) {
                        for (int i = 1; i < nrCyfry + 1; i++) {
                            cyfra[i] = "0";
                        }
                        nrCyfry = 0;
                        afterEqual = 0;
                        afterNumber = 0;
                    }
                    nrCyfry++;
                    operator = "*";
                    afterNumber = 0;
                }
                else if (e.getSource() == DivButton) {
                    if (afterEqual == 1) {
                        for (int i = 1; i < nrCyfry + 1; i++) {
                            cyfra[i] = "0";
                        }
                        nrCyfry = 0;
                        afterEqual = 0;
                        afterNumber = 0;
                    }
                    nrCyfry++;
                    operator = "/";
                    afterNumber = 0;
                }
                else if (e.getSource() == ClearButton) {
                    System.out.println("Clear");
                    Arrays.fill(cyfra,null);
                    cyfra[0] = "0";
                    operator = "";
                    nrCyfry = 0;
                    afterNumber = 0;
                    afterEqual = 0;
                    line.setText("0");
                }

                for(int i=0; i<nrCyfry+1; i++){
                    System.out.println("nrCyfry " + nrCyfry + " index " + i + " cyfra " + cyfra[i]);
                }
                System.out.println("operator " + operator + " afterEquals " + afterEqual);
            }
        };
        ZeroButton.addActionListener(myActionListener);
        OneButton.addActionListener(myActionListener);
        TwoButton.addActionListener(myActionListener);
        ThreeButton.addActionListener(myActionListener);
        FourButton.addActionListener(myActionListener);
        FiveButton.addActionListener(myActionListener);
        SixButton.addActionListener(myActionListener);
        SevenButton.addActionListener(myActionListener);
        EightButton.addActionListener(myActionListener);
        NineButton.addActionListener(myActionListener);
        PlusButton.addActionListener(myActionListener);
        MinusButton.addActionListener(myActionListener);
        MulButton.addActionListener(myActionListener);
        DivButton.addActionListener(myActionListener);
        ClearButton.addActionListener(myActionListener);
        EqualButton.addActionListener(myActionListener);




    // Finish
        jf.add(jp);
        jf.pack();
        jf.setLayout(new FlowLayout());
        jf.setBackground(Color.GRAY);
        jf.setSize(330,210);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
    }

}