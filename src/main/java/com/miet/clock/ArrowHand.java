package com.miet.clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class ArrowHand implements ActionListener {
    /**
     * Class constructor.
     */
    public ArrowHand() {
        Main.getArrowPanel().setASecond(getSecondAngle());
        Main.getArrowPanel().setAMinute(getMinAngle());
        Main.getArrowPanel().setAHour(getHourAngle());
    }
    /**
     * Setting a some time.
     * @param h Count of hours(0-24)(formed to 12-clock format)
     * @param m Count of minutes(0-60 or above(will be formated)
     * @param s Count of seconds(0-60 or above(will be formated)
     */
    void setTime(int h, int m, int s) {
        sec =s%60;
        hour =h%12*5+m/12;
        min =m%60;
        Main.getArrowPanel().setASecond(getSecondAngle());
        Main.getArrowPanel().setAMinute(getMinAngle());
        Main.getArrowPanel().setAHour(getHourAngle());
    }

    /**
     * Setting current local time.
     */
    public void setCurTime() {
        LocalTime lt=LocalTime.now();
        sec =lt.getSecond()+1;
        min =lt.getMinute();
        hour =lt.getHour()%12*5+ min /12;
        Main.getArrowPanel().setASecond(getSecondAngle());
        Main.getArrowPanel().setAMinute(getMinAngle());
        Main.getArrowPanel().setAHour(getHourAngle());
    }
    /**
     * Getting time from clock.
     * @return String with format "hours:minutes:seconds"
     */
    public String getTime() {
        if(hour == 0){
            return 12+":"+ min +":"+ sec;
        }
        else
        {
            return hour / 5 + ":" + min + ":" + sec;
        }
    }
    /**
     * Action for timer.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.getArrowPanel().setASecond(getSecondAngle());
        Main.getArrowPanel().setAMinute(getMinAngle());
        Main.getArrowPanel().setAHour(getHourAngle());
        sec++;
        if (sec >= 60) {
            sec = 0;
            min++;
            if(min == 12 || min == 24 || min == 36 || min == 48 || min == 60) {
                hour++;
            }
            if(hour >=60) {
                hour =0;
            }
            if (min >= 60) {
                min =0;
            }
        }
    }
    /**
     * Getting angle for second arrow.
     * @return new angle's value
     * @see ArrowHand#angle
     */
    public double getSecondAngle() {
        return (sec * angle);
    }
    /**
     * Getting angle for second arrow.
     * @return new angle's value
     * @see ArrowHand#angle
     */
    public double getMinAngle() {
        return(min * angle);
    }
    /**
     * Getting angle for second arrow.
     * @return new angle's value
     * @see ArrowHand#angle
     */
    public double getHourAngle() {
        return(hour * angle);
    }

    private int sec = 0;
    private int min =0;
    private int hour =0;
    /**
     * {@value #angle} value for calculating new angle
     */
    public static final double angle = 6 * Math.PI / 180;
}

