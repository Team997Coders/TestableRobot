/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;

public class RobotModule extends AbstractModule {
  @Override 
  protected void configure() {
    bind(DigitalOutput.class).annotatedWith(Names.named("perpetualLED")).toProvider(
      () -> new DigitalOutput(RobotMap.perpetualLED)
    );
    bind(DigitalOutput.class).annotatedWith(Names.named("silenceableLED")).toProvider(
      () -> new DigitalOutput(RobotMap.silenceableLED)
    );
    bind(DigitalInput.class).annotatedWith(Names.named("silencer")).toProvider(
      () -> new DigitalInput(RobotMap.silencer)
    );
  }
}