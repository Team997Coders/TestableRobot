package edu.wpi.first.wpilibj;

/**
 * Simulate the Timer on the FPGA. This is needed for JUnit testing.
 * It will not be needed for the 2019 release.
 */
public class TimerSim implements Timer.StaticInterface {
  public void delay(double seconds) {
    // Do nothing
  }
  public double getFPGATimestamp() {
    return (double)System.nanoTime() / 1_000_000_000.0;
  }
  public double getMatchTime() {
    return 90;
  }
  public Timer.Interface newTimer() {
    return null;
  }
}