import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Gui extends JFrame {
    private JPanel fieldPanel, buttonsPanel;
    private JTextField field;
    private JButton sqrt, npower, square, recip,
                    clearAll, bckSpc, percent, div,
                    but7, but8, but9, mult,
                    but4, but5, but6, sub,
                    but1, but2, but3, add,
                    sign, but0, pnt, equals;

    private boolean powerPressed, divPressed, multPressed, subPressed, addPressed, cleared, dotQueued, newEq;
    private double storedVal;

    public Gui(String s) {
        super(s);
        setFocusable(true);
        requestFocusInWindow();

        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, 0), "0");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0), "1");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0), "2");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0), "3");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0), "4");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0), "5");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0), "6");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0), "7");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0), "8");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0), "9");

        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_0, 0), "0");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0), "1");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0), "2");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0), "3");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0), "4");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_5, 0), "5");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_6, 0), "6");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_7, 0), "7");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_8, 0), "8");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_9, 0), "9");

        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("shift 6"), "npower");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("shift 5"), "percent");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0), "div");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE, 0), "div");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("shift 8"), "mult");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0), "mult");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "sub");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0), "sub");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, InputEvent.SHIFT_DOWN_MASK), "add");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0), "add");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0), "dot");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DECIMAL, 0), "dot");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, 0), "equals");
        ((JPanel)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "equals");

        ((JPanel)getContentPane()).getActionMap().put("0", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                addNum(0);
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("1", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                addNum(1);
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("2", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                addNum(2);
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("3", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                addNum(3);
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("4", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                addNum(4);
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("5", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                addNum(5);
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("6", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                addNum(6);
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("7", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                addNum(7);
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("8", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                addNum(8);
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("9", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                addNum(9);
            }
        });

        ((JPanel)getContentPane()).getActionMap().put("npower", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                exponent();
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("percent", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                percentage();
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("div", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                divide();
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("mult", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                multiply();
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("sub", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                subtract();
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("add", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                addition();
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("dot", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (!field.getText().contains(".")) dotQueued = true;
            }
        });
        ((JPanel)getContentPane()).getActionMap().put("equals", new AbstractAction() {
            public void actionPerformed(ActionEvent actionEvent) {
                doEquals();
                newEq = true;
            }
        });

        setUIFont(new javax.swing.plaf.FontUIResource("SansSerif",Font.PLAIN,32));
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();

        powerPressed = false;
        divPressed = false;
        multPressed = false;
        subPressed = false;
        addPressed = false;
        cleared = false;
        dotQueued = false;
        newEq = false;
    }

    private void initComponents() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        fieldPanel = new JPanel();
        buttonsPanel = new JPanel(new GridLayout(6, 4));

        field = new JTextField() {
            public Dimension getPreferredSize() {
                return new Dimension(buttonsPanel.getWidth() - 6, 50);
            };
        };
        field.setEditable(false);
        field.setBackground(Color.WHITE);
        field.setText("0");
        field.setHorizontalAlignment(SwingConstants.RIGHT);

        sqrt = new JButton(new ImageIcon(new ImageIcon("sqrt.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
        sqrt.setBackground(Color.LIGHT_GRAY);
        sqrt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(String.valueOf(Math.sqrt(Double.parseDouble(field.getText()))));
            }
        });

        square = new JButton(new ImageIcon(new ImageIcon("squared.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
        square.setBackground(Color.LIGHT_GRAY);
        square.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(String.valueOf(Math.pow(Double.parseDouble(field.getText()), 2)));
                if (Double.parseDouble(field.getText()) == Math.round(Double.parseDouble(field.getText()))) field.setText(String.valueOf(Math.round(Double.parseDouble(field.getText()))));
            }
        });
        npower = new JButton(new ImageIcon(new ImageIcon("npower.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
        npower.setBackground(Color.LIGHT_GRAY);
        npower.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                exponent();
            }
        });
        recip = new JButton(new ImageIcon(new ImageIcon("inverse.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
        recip.setBackground(Color.LIGHT_GRAY);
        recip.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(String.valueOf(Math.pow(Double.parseDouble(field.getText()), -1)));
                if (Double.parseDouble(field.getText()) == Math.round(Double.parseDouble(field.getText()))) field.setText(String.valueOf(Math.round(Double.parseDouble(field.getText()))));
            }
        });
        clearAll = new JButton("C");
        clearAll.setBackground(Color.RED);
        clearAll.setForeground(Color.WHITE);
        clearAll.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("0");
                npower.setBackground(Color.LIGHT_GRAY);
                div.setBackground(Color.LIGHT_GRAY);
                mult.setBackground(Color.LIGHT_GRAY);
                sub.setBackground(Color.LIGHT_GRAY);
                add.setBackground(Color.LIGHT_GRAY);
                powerPressed = false;
                divPressed = false;
                multPressed = false;
                subPressed = false;
                addPressed = false;
                cleared = false;
            }
        });
        bckSpc = new JButton(new ImageIcon(new ImageIcon("back.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
        bckSpc.setBackground(Color.PINK);
        bckSpc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (field.getText() != null && field.getText().length() > 0) {
                    field.setText(field.getText().substring(0, field.getText().length() - 1));
                }
                if (field.getText().trim().length() == 0) field.setText("0");
            }
        });
        percent = new JButton("%");
        percent.setBackground(Color.LIGHT_GRAY);
        percent.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                percentage();
            }
        });
        div = new JButton(new ImageIcon(new ImageIcon("div.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
        div.setBackground(Color.LIGHT_GRAY);
        div.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                doEquals();
                storedVal = Double.parseDouble(field.getText());
                div.setBackground(Color.GRAY);
                divPressed = true;
            }
        });
        but7 = new JButton("7");
        but7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNum(7);
            }
        });
        but8 = new JButton("8");
        but8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNum(8);
            }
        });
        but9 = new JButton("9");
        but9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNum(9);
            }
        });
        mult = new JButton(new ImageIcon(new ImageIcon("mult.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
        mult.setBackground(Color.LIGHT_GRAY);
        mult.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                doEquals();
                storedVal = Double.parseDouble(field.getText());
                mult.setBackground(Color.GRAY);
                multPressed = true;
            }
        });
        but4 = new JButton("4");
        but4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNum(4);
            }
        });
        but5 = new JButton("5");
        but5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNum(5);
            }
        });
        but6 = new JButton("6");
        but6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNum(6);
            }
        });
        sub = new JButton("-");
        sub.setBackground(Color.LIGHT_GRAY);
        sub.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                subtract();
            }
        });
        but1 = new JButton("1");
        but1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNum(1);
            }
        });
        but2 = new JButton("2");
        but2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNum(2);
            }
        });
        but3 = new JButton("3");
        but3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNum(3);
            }
        });
        add = new JButton("+");
        add.setBackground(Color.LIGHT_GRAY);
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addition();
            }
        });
        sign = new JButton(new ImageIcon(new ImageIcon("sign.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
        sign.setBackground(Color.LIGHT_GRAY);
        sign.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!field.getText().equals("0")) {
                    if (field.getText().charAt(0) == '-') field.setText(field.getText().substring(1));
                    else field.setText("-" + field.getText());
                }
            }
        });
        but0 = new JButton("0");
        but0.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNum(0);
            }
        });
        pnt = new JButton(".");
        pnt.setBackground(Color.LIGHT_GRAY);
        pnt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!field.getText().contains(".")) dotQueued = true;
            }
        });
        equals = new JButton("=");
        equals.setBackground(Color.ORANGE);
        equals.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                doEquals();
                newEq = true;
            }
        });

        fieldPanel.add(field);

        buttonsPanel.add(sqrt);
        buttonsPanel.add(square);
        buttonsPanel.add(npower);
        buttonsPanel.add(recip);
        buttonsPanel.add(clearAll);
        buttonsPanel.add(bckSpc);
        buttonsPanel.add(percent);
        buttonsPanel.add(div);
        buttonsPanel.add(but7);
        buttonsPanel.add(but8);
        buttonsPanel.add(but9);
        buttonsPanel.add(mult);
        buttonsPanel.add(but4);
        buttonsPanel.add(but5);
        buttonsPanel.add(but6);
        buttonsPanel.add(sub);
        buttonsPanel.add(but1);
        buttonsPanel.add(but2);
        buttonsPanel.add(but3);
        buttonsPanel.add(add);
        buttonsPanel.add(sign);
        buttonsPanel.add(but0);
        buttonsPanel.add(pnt);
        buttonsPanel.add(equals);

        add(fieldPanel);
        add(buttonsPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit when close button clicked
        pack();
        setVisible(true);
    }

    private void setUIFont (javax.swing.plaf.FontUIResource f) {
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value instanceof javax.swing.plaf.FontUIResource) UIManager.put(key, f);
        }
    }

    private void addNum(int num) {
        if (newEq) {
            field.setText("");
            newEq = false;
        }

        if (dotQueued) {
            field.setText(field.getText() + ".");
            dotQueued = false;
        }
        if (powerPressed || divPressed || multPressed || subPressed || addPressed) {
            if (!cleared) {
                field.setText(String.valueOf(num));
                cleared = true;
            } else {
                if (field.getText().equals("0")) field.setText(String.valueOf(num));
                else field.setText(field.getText() + num);
            }
        } else {
            if (field.getText().equals("0")) field.setText(String.valueOf(num));
            else field.setText(field.getText() + num);
        }
    }

    private void doEquals() {
        if (powerPressed) {
            field.setText(String.valueOf(Math.pow(storedVal, Double.parseDouble(field.getText()))));
            npower.setBackground(Color.LIGHT_GRAY);
            powerPressed = false;
        } else if (divPressed) {
            field.setText(String.valueOf(storedVal / Double.parseDouble(field.getText())));
            div.setBackground(Color.LIGHT_GRAY);
            divPressed = false;
        } else if (multPressed) {
            field.setText(String.valueOf(storedVal * Double.parseDouble(field.getText())));
            mult.setBackground(Color.LIGHT_GRAY);
            multPressed = false;
        } else if (subPressed) {
            field.setText(String.valueOf(storedVal - Double.parseDouble(field.getText())));
            sub.setBackground(Color.LIGHT_GRAY);
            subPressed = false;
        } else if (addPressed) {
            field.setText(String.valueOf(storedVal + Double.parseDouble(field.getText())));
            add.setBackground(Color.LIGHT_GRAY);
            addPressed = false;
        }

        cleared = false;
        if (Double.parseDouble(field.getText()) == Math.round(Double.parseDouble(field.getText()))) field.setText(String.valueOf(Math.round(Double.parseDouble(field.getText()))));
    }

    private void exponent() {
        doEquals();
        storedVal = Double.parseDouble(field.getText());
        npower.setBackground(Color.GRAY);
        powerPressed = true;
    }

    private void percentage() {
        field.setText(String.valueOf(Double.parseDouble(field.getText())/100));
        if (Double.parseDouble(field.getText()) == Math.round(Double.parseDouble(field.getText()))) field.setText(String.valueOf(Math.round(Double.parseDouble(field.getText()))));
    }

    private void divide() {
        doEquals();
        storedVal = Double.parseDouble(field.getText());
        div.setBackground(Color.GRAY);
        divPressed = true;
    }

    private void multiply() {
        doEquals();
        storedVal = Double.parseDouble(field.getText());
        mult.setBackground(Color.GRAY);
        multPressed = true;
    }

    private void subtract() {
        doEquals();
        storedVal = Double.parseDouble(field.getText());
        sub.setBackground(Color.GRAY);
        subPressed = true;
    }

    private void addition() {
        doEquals();
        storedVal = Double.parseDouble(field.getText());
        add.setBackground(Color.GRAY);
        addPressed = true;
    }

    /** The entry main() method */
    public static void main(String[] args) {
      // Run GUI codes in the Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Gui("Calculator");
            }
        });
    }
}