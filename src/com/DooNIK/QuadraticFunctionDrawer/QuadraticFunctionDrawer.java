package com.DooNIK.QuadraticFunctionDrawer;

import javax.swing.*;
import java.awt.*;

public class QuadraticFunctionDrawer extends JFrame {
    private final GraphPanel gp;
    public QuadraticFunctionDrawer(int width, int height) {
        gp = new GraphPanel();
        gp.setPreferredSize(new Dimension(width, height));
        gp.setBackground(Color.GRAY);

        JPanel infoPanel = new JPanel(new BorderLayout());

        JLabel info = new JLabel();
        info.setText("ax^2 + bx + c");
        infoPanel.add(info, BorderLayout.PAGE_START);

        JTextField a = new JTextField();
        a.setPreferredSize(new Dimension(20,20));
        a.setText(String.valueOf(1));
        infoPanel.add(a, BorderLayout.LINE_START);

        JTextField b = new JTextField();
        b.setPreferredSize(new Dimension(20,20));
        b.setText(String.valueOf(0));
        infoPanel.add(b, BorderLayout.CENTER);

        JTextField c = new JTextField();
        c.setPreferredSize(new Dimension(20,20));
        c.setText(String.valueOf(0));
        infoPanel.add(c, BorderLayout.LINE_END);

        JPanel sp = new JPanel();

        JSlider scaleX = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
        scaleX.setMinorTickSpacing(10);
        scaleX.setMajorTickSpacing(20);
        scaleX.setPreferredSize(new Dimension(300,50));
        scaleX.setPaintTicks(true);
        scaleX.setPaintLabels(true);

        JSlider scaleY = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
        scaleY.setMinorTickSpacing(10);
        scaleY.setMajorTickSpacing(20);
        scaleY.setPreferredSize(new Dimension(300,50));
        scaleY.setPaintTicks(true);
        scaleY.setPaintLabels(true);

        JButton Redraw = new JButton("Redraw");
        Redraw.addActionListener(e -> gp.Redraw(scaleX.getValue(), scaleY.getValue(), 1
                ,Double.parseDouble(a.getText())
                ,Double.parseDouble(b.getText())
                ,Double.parseDouble(c.getText())
        ));

        sp.add(scaleX);
        sp.add(scaleY);
        sp.add(Redraw);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setVisible(true);

        add(gp, BorderLayout.PAGE_START);
        add(infoPanel, BorderLayout.LINE_START);
        add(sp, BorderLayout.CENTER);
        pack();
    }
}
