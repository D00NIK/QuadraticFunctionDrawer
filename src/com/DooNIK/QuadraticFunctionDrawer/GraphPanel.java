package com.DooNIK.QuadraticFunctionDrawer;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {
    private final int POINT_HEIGHT = 5;
    private int SCALE_X = 100;
    private int SCALE_Y = 100;
    private int POINT_FREQUENCY = 1;
    private final int POINT_SIZE = 3;

    private double A = 1;
    private double B = 0;
    private double C = 0;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int i;
        double ans;

        g2.setColor(Color.WHITE);
        g2.drawLine(getWidth()/2,0,getWidth()/2,getHeight()); // Y axis
        g2.drawLine(0, getHeight()/2, getWidth(),getHeight()/2); // X axis

        for (i=getWidth()/2;i <=getWidth();i+=SCALE_X*POINT_FREQUENCY) // X axis points
            g2.drawLine(i,getHeight()/2-POINT_HEIGHT, i, getHeight()/2+POINT_HEIGHT);
        for (i=getWidth()/2;i >=0;i-=(SCALE_X*POINT_FREQUENCY))
            g2.drawLine(i,getHeight()/2-POINT_HEIGHT, i, getHeight()/2+POINT_HEIGHT);

        for (i=getHeight()/2;i <=getHeight();i+=SCALE_Y*POINT_FREQUENCY) // Y axis points
            g2.drawLine(getWidth()/2-POINT_HEIGHT, i, getWidth()/2+POINT_HEIGHT, i);
        for (i=getHeight()/2;i >=0;i-=(SCALE_Y*POINT_FREQUENCY))
            g2.drawLine(getWidth()/2-POINT_HEIGHT, i, getWidth()/2+POINT_HEIGHT, i);

        g2.setColor(Color.BLACK);
        for (i = 0; i <= getWidth(); i++) {
            ans = f((double) (i-getWidth()/2)/SCALE_X)*SCALE_Y;
            g2.drawOval(i-POINT_SIZE, getHeight()/2-(int)ans-POINT_SIZE, 2*POINT_SIZE, 2*POINT_SIZE);
            //g2.drawLine(i,getHeight()/2-ans,i,getHeight()/2-ans);
        }

        double delta = Math.pow(B,2) - 4*A*C;

        g2.setColor(Color.CYAN);
        g2.drawString("Vertex = ("+ (-B/(2*A)) +"," + (-delta/(4*A))+")",1,10);

        if (delta > 0) {
            g2.drawString("X1 = " + ((-B-Math.pow(delta,0.5))/(2*A)), 1, 25);
            g2.drawString("X2 = " + ((-B+Math.pow(delta,0.5))/(2*A)), 1, 40);
        }
        else if (delta == 0) {
            g2.drawString("X0 = " + (-B/(2*A)), 1, 25);
        }
    }

    private double f(double x) {
        return A*Math.pow(x,2) + B*x+ C;
    }

    public void Redraw(int SCALE_X, int SCALE_Y, int POINT_FREQUENCY, double A, double B, double C) {

        if (SCALE_X == 0)
            SCALE_X = 1;
        if (SCALE_Y == 0)
            SCALE_Y = 1;

        this.SCALE_X = SCALE_X;
        this.SCALE_Y = SCALE_Y;
        this.POINT_FREQUENCY = POINT_FREQUENCY;
        this.A = A;
        this.B = B;
        this.C = C;

        this.repaint();
    }
}
