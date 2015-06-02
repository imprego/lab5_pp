package com.miet.clock;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class ArrowPanel extends JPanel {
    /**
     * Class constructor.
     */
    public ArrowPanel() {
        setPreferredSize(new Dimension(300, 400));
    }
    /**
     * Painting clockface and arrows.
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.LIGHT_GRAY);
        g2.fill(new Ellipse2D.Double(x0-radius-50/2,y0-radius-50/2,radius*2+50,radius*2+50));
        g2.setColor(Color.BLUE);
        g2.draw(new Ellipse2D.Double(x0-radius-50/2,y0-radius-50/2,radius*2+50,radius*2+50));

        x1s = (int) (x0 + (radius * Math.cos(as)));
        y1s = (int) (y0 + (radius * Math.sin(as)));
        g2.setColor(Color.RED);
        g2.draw(new Line2D.Double(x0, y0, x1s, y1s));


        x1m = (int) (x0 + (radius * Math.cos(am)));
        y1m = (int) (y0 + (radius * Math.sin(am)));

        g2.setColor(Color.BLACK);
        g2.draw(new Line2D.Double(x0, y0, x1m, y1m));

        x1h = (int) (x0 + ((radius-50) * Math.cos(ah)));
        y1h = (int) (y0 + ((radius-50) * Math.sin(ah)));


        g2.setColor(Color.MAGENTA);
        g2.draw(new Line2D.Double(x0, y0, x1h, y1h));

        g2.setColor(Color.BLACK);

        for(int j=1; j<=60; j++){
            int xcbeg,yscbeg, xscend, yscend;
            double andsc;
            int radsc=100;
            if(j%5==0) {

                andsc= j* 6 * Math.PI / 180-Math.PI/2;
                xcbeg = (int) (x0 + ((radius-20) * Math.cos(andsc)));
                yscbeg = (int) (y0 + ((radius-20) * Math.sin(andsc)));
                xscend=(int) (x0+(radsc*Math.cos(andsc)));
                yscend = (int) (y0 + (radsc * Math.sin(andsc)));

                g2.draw(new Line2D.Double(xcbeg, yscbeg, xscend, yscend));


                int textx, texty;
                textx = (int) (x0-5 + ((radius+12) * Math.cos(andsc)));
                texty = (int) (y0+5 + ((radius+12) * Math.sin(andsc)));
                g2.setColor(Color.BLACK);
                Font textnumber = new Font("Arial", Font.BOLD | Font.ITALIC, 14);
                g2.setFont(textnumber);
                String message = j / 5 + "";

                if(j==60) {
                    message = 12 + "";

                }
                g2.drawString(message, textx, texty);



            }
            else {
                andsc = j * 6 * Math.PI / 180;
                xcbeg = (int) (x0 + ((radius - 5) * Math.cos(andsc)));
                yscbeg = (int) (y0 + ((radius - 5) * Math.sin(andsc)));
                xscend = (int) (x0 + (radsc * Math.cos(andsc)));
                yscend = (int) (y0 + (radsc * Math.sin(andsc)));

                g2.draw(new Line2D.Double(xcbeg, yscbeg, xscend, yscend));
            }
        }
    }


    private static final int x0 = 150;
    private static final int y0 = 150;
    private static final int radius = 100;

    /**
     * Setting a new angle and repainting second arrow.
     * @param ang angle for second arrow.
     */
    public void setASecond(double ang) {
        as = ang-Math.PI/2;
        repaint();
    }
    /**
     * Setting a new angle and repainting minute arrow.
     * @param ang angle for minute arrow.
     */
    public void setAMinute(double ang) {
        am=ang-Math.PI/2;
        repaint();
    }
    /**
     * Setting a new angle and repainting minute arrow.
     * @param ang angle for minute arrow.
     */
    public void setAHour(double ang) {
        ah = ang-Math.PI/2;
        repaint();
    }

    private double as;
    private double am;
    private double ah;
    private int x1s;
    private int y1s;
    private int x1m;
    private int y1m;
    private int x1h;
    private int y1h;
}
