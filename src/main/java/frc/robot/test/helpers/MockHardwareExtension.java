/*----------------------------------------------------------------------------*/
/* Copyright (c) 2016-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.test.helpers;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;

import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.RobotStateSim;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.TimerSim;
import edu.wpi.first.wpilibj.hal.HAL;
import edu.wpi.first.wpilibj.DriverStation;

/**
 * JUnit 5 testing extension which ensures all WPILib foundational bits
 * are initialized to be able to run the scheduler. 
 */
public final class MockHardwareExtension implements BeforeAllCallback, AfterAllCallback {
  private static ExtensionContext getRoot(ExtensionContext context) {
    return context.getParent().map(MockHardwareExtension::getRoot).orElse(context);
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    getRoot(context).getStore(Namespace.GLOBAL).getOrComputeIfAbsent("HAL Initalized", key -> {
      initializeHardware();
      return true;
    }, Boolean.class);
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    getRoot(context).getStore(Namespace.GLOBAL).getOrComputeIfAbsent("DS Release", key -> {
      DriverStation.getInstance().release();
      HAL.releaseDSMutex();
      return true;
    }, Boolean.class);
  }

  private void initializeHardware() {
    HAL.initialize(500, 0);
    RobotState.SetImplementation(new RobotStateSim());
    Timer.SetImplementation(new TimerSim());
  }
}
