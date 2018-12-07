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

/**
 * Guice module to configure bindings. Note that since most WPI usage
 * involves extending concrete classes rather than implementing interfaces,
 * concrete classes do not need to be bound to themselves. Guice knows how to
 * do that by itself. So the only binding that is necessary are specifying
 * at runtime parameters that are needed to instantiate hardware.
 */
public class RobotModule extends AbstractModule {
  @Override 
  protected void configure() {
    // Configured named parameters that Guice will inject into a constructor when 
    // it sees @Named decorator.
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