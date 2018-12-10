package frc.robot;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import edu.wpi.first.wpilibj.buttons.Button;

import frc.robot.commandgroups.SayHelloInTurnCommandGroup;
import frc.robot.commands.SayHelloCommand;

/**
 * Define the operator interface by passing in the buttons and commands
 */
public class OI {
  @Inject
  public OI( 
      @Named("simpleButton") Button simpleButton, 
      @Named("commandGroupButton") Button commandGroupButton, 
      SayHelloCommand sayHelloCommand, 
      SayHelloInTurnCommandGroup sayHelloInTurnCommandGroup) {
    // Wire up actions to buttons
    simpleButton.whileHeld(sayHelloCommand);
    commandGroupButton.whileHeld(sayHelloInTurnCommandGroup);
  }
}