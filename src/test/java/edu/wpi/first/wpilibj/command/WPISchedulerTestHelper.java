package edu.wpi.first.wpilibj.command;

import java.util.concurrent.TimeUnit;

/**
 * Integration test help class for those tests, ala command group tests, that need the
 * WPI Scheduler to run, so that all commands in the group get executed in the right order
 * at the right time. Use of this class requires that your test class be decorated with
 * {@code @ExtendsWith(MockHardwareExtension.class)}
 */
public class WPISchedulerTestHelper {
    private int heartbeatMilliseconds = 0;

    /**
     * Initialized a runner with your own heartbeat (in ms)
     */
    public WPISchedulerTestHelper(int heartbeatMilliseconds) {
        this.heartbeatMilliseconds = heartbeatMilliseconds;
        // Stolen from the pages of NEW WPILib automated tests.
        // Good artists copy, great artists steal!
        // See https://github.com/wpilibsuite/allwpilib/blob/876c6504714859eb7aa453e4c378b5bb78efc2a9/wpilibj/src/test/java/edu/wpi/first/wpilibj/command/AbstractCommandTest.java
        // And https://github.com/wpilibsuite/allwpilib/blob/876c6504714859eb7aa453e4c378b5bb78efc2a9/wpilibj/src/test/java/edu/wpi/first/wpilibj/command/CommandSequentialGroupTest.java
        // Yikes, those URLs are long!
        Scheduler.getInstance().removeAll();
        Scheduler.getInstance().enable();
    }

    /**
     * Default constructor initialized runner heartbeat to 20 ms
     */
    public WPISchedulerTestHelper() {
        this(20);
    }


    /**
     * Do not let an instance to this class go to the garbage collector
     * without calling the destroy method first. I am not sure that the WPI
     * scheduler needs this, but it won't hurt.
     */
    public void destroy() {
        Scheduler.getInstance().disable();
        Scheduler.getInstance().close();
    }

    /**
     * Run our fakey robot command scheduler for a given amount of time.
     * 
     * @param durationInMs  Duration to run in milliseconds
     * @throws InterruptedException
     */
    public void runForDuration(long durationInMs) throws InterruptedException {
        long start = System.nanoTime();
        while (System.nanoTime() < (start + TimeUnit.MILLISECONDS.toNanos(durationInMs))) {
            // The run function only pumps the scheduled commands once
            Scheduler.getInstance().run();
            Thread.sleep(heartbeatMilliseconds);
        }
    }
}