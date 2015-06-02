package com.miet.clock;
import com.miet.clock.Main;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.time.LocalTime;

public class ClockTest {
    @Test
    public void testPositiveSetting24() {

        ArrowHand arrowSec;


        arrowSec = new ArrowHand();

        arrowSec.setTime(24, 0, 0);
        System.out.println(arrowSec.getTime());
        Timer timer = new Timer(1000, arrowSec );
        timer.start();
        timer.stop();
        Assert.assertEquals("12:0:0", arrowSec.getTime());
    }

    @Test //Set to 17:0:0 not to set into 17:0:0
    public void testNotNegativeSetting24() {

        ArrowHand arrowSec;


        arrowSec = new ArrowHand();

        arrowSec.setTime(17, 0, 0);

        Timer timer = new Timer(1000, arrowSec );
        timer.start();
        timer.stop();
        Assert.assertFalse(arrowSec.getTime().equals("17:0:0"));
    }

    @Test
    public void testSettingSecondMoreThan60() {

        ArrowHand arrowSec;


        arrowSec = new ArrowHand();

        arrowSec.setTime(11, 34, 60);

        Timer timer = new Timer(1000, arrowSec );
        timer.start();
        timer.stop();

        Assert.assertEquals("11:34:0", arrowSec.getTime());
    }


    @Test
    public void testDynamicSettingTime() {

        ArrowHand arrowSec;


        arrowSec = new ArrowHand();
        arrowSec.setTime(11, 59, 59);


        Timer timer = new Timer(1000, arrowSec );
        timer.start();

        LocalTime lct=LocalTime.now();
        System.out.println(lct.getSecond());
        LocalTime lctcur=LocalTime.now();

        while(lctcur.getSecond() != (lct.getSecond()+2)%60) {
            lctcur = LocalTime.now();
            //System.out.println(lctcur.getSecond());
        }
        timer.stop();
        System.out.println(arrowSec.getTime());
        Assert.assertEquals("12:0:0", arrowSec.getTime());
    }



    @Test
    public void testDynamicCurrentTime() {
        System.out.println("testDynamicCurrentTime");

        ArrowHand arrowSec;
        int h=0,m=0,s=0;

        arrowSec = new ArrowHand();

        arrowSec.setCurTime();

        Timer timer = new Timer(1000, arrowSec );
        timer.start();

        LocalTime lct=LocalTime.now();
        System.out.println(lct.getSecond());
        LocalTime lctcur=LocalTime.now();

        while(lctcur.getSecond() != (lct.getSecond()+20)%60) {
            lctcur = LocalTime.now();
            h=lctcur.getHour()%12;
            m=lctcur.getMinute();
            s=lctcur.getSecond();

        }

        timer.stop();

        System.out.println(h+":"+m+":"+s+"     "+arrowSec.getTime());
        Assert.assertEquals(h+":"+m+":"+s, arrowSec.getTime());
    }

}
