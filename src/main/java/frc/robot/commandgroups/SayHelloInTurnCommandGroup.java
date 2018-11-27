package frc.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.SayHelloUntilSilencedCommand;
import frc.robot.commands.SayHelloCommand;

/**
 * A command group to say hello twice, in turn, after the first hello has been silenced.
 */
public class SayHelloInTurnCommandGroup extends CommandGroup {
    /**
     * Pass in your external dependencies...don't create them inside your constructor. It makes the
     * command group untestable. If you have parameters you want to set on your commands before
     * execution, just store off references to your subsystems, and create method(s)
     * to change them inside the command group, since those settings pertain to operation of the group.
     * 
     * @param sayHelloUntilSilencedCommand  Our first say hello command to run until silenced
     * @param sayHelloCommand               Our second say hello to run thereafter
     */
    public SayHelloInTurnCommandGroup(SayHelloUntilSilencedCommand sayHelloUntilSilencedCommand, SayHelloCommand sayHelloCommand) {
        // Note that these references are not stored off...but they could be.
        addSequential(sayHelloUntilSilencedCommand);
        addSequential(sayHelloCommand);
    }
}