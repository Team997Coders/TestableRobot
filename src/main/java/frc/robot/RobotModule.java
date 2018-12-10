/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Guice module to configure bindings. Note that since most WPI usage
 * involves extending concrete classes rather than implementing interfaces,
 * concrete classes do not need to be bound to themselves. Guice knows how to
 * do that by itself. So the only binding that is necessary is to specify,
 * at runtime, parameters that are needed to instantiate hardware.
 */
public class RobotModule extends AbstractModule {
  @Override 
  protected void configure() {
    // Configured named parameters that Guice will inject into a constructor when 
    // it sees @Named decorator. A singleton is needed because the HAL enforces
    // that not more than one hardware object can be instantiated at a time on
    // a given port.
    bind(DigitalOutput.class).annotatedWith(Names.named("perpetualLED")).toProvider(
      () -> new DigitalOutput(RobotMap.perpetualLED)
    ).in(Scopes.SINGLETON);
    bind(DigitalOutput.class).annotatedWith(Names.named("silenceableLED")).toProvider(
      () -> new DigitalOutput(RobotMap.silenceableLED)
    ).in(Scopes.SINGLETON);
    bind(DigitalInput.class).annotatedWith(Names.named("silencer")).toProvider(
      () -> new DigitalInput(RobotMap.silencer)
    ).in(Scopes.SINGLETON);
    // Instantiate the button to activate the simple hello world command
    bind(Button.class).annotatedWith(Names.named("simpleButton")).toProvider(
      () -> new JoystickButton(new Joystick(RobotMap.joystickPort), 
                RobotMap.simpleButtonNumber)
    ).in(Scopes.SINGLETON);
    // Instantiate the button to activate the silenceable command group
    bind(Button.class).annotatedWith(Names.named("commandGroupButton")).toProvider(
      () -> new JoystickButton(new Joystick(RobotMap.joystickPort),
                RobotMap.commandGroupButtonNumber)
    ).in(Scopes.SINGLETON);
  }
}