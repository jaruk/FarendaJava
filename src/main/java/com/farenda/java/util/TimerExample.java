package com.farenda.java.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerExample {

    private static class WebClawlerTask extends TimerTask {

        private int count = 0;

        @Override
        public void run() {
            System.out.println("Crawling the web count: " + ++count);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        int delay = 100;
        int period = 200;
        timer.scheduleAtFixedRate(new WebClawlerTask(), delay, period);

        TimeUnit.SECONDS.sleep(2);

        System.out.println("Stopping the timer.");
        timer.cancel();
    }
}