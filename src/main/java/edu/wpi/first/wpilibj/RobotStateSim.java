package edu.wpi.first.wpilibj;

/**
 * Simulate the robot state for JUnit testing. This will not be needed for
 * the 2019 release.
 */
public class RobotStateSim implements RobotState.Interface {
  public boolean isAutonomous() {
    return false;
  }
  public boolean isEnabled() {
    return true;
  }
  public boolean isTest() {
    return true;
  }
  public boolean isDisabled() {
    return false;
  }
  public boolean isOperatorControl() {
    return true;
  }
}