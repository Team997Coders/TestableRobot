package frc.robot.commandgroups;

import edu.wpi.first.wpilibj.MockHardwareExtension;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.WPISchedulerTestHelper;
import frc.robot.commands.SayHelloCommand;
import frc.robot.commands.SayHelloUntilSilencedCommand;
import frc.robot.subsystems.HelloWorldSubsystem;
import frc.robot.subsystems.SilenceableHelloWorldSubsystem;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;

@ExtendWith(MockHardwareExtension.class)
public class SayHelloInTurnCommandGroupIntegrationTest {
    private WPISchedulerTestHelper scheduler;

    @BeforeEach
    public void schedulerSetup() {
        scheduler = new WPISchedulerTestHelper(20);
    }

    @AfterEach
    public void schedulerTeardown() {
        scheduler.destroy();
    }

    @Test
    public void itCanSayHelloASecondTimeOnlyAfterSilencingTheFirst() throws InterruptedException {
        //Assemble
        // The only thing we mock out here is the hardware...run everything else.
        // This is an integration test to make sure our command group operates
        // on the hardware as intended when external stimulus is encountered.
        DigitalOutput firstHelloLEDMock = mock(DigitalOutput.class);
        DigitalOutput secondHelloLEDMock = mock(DigitalOutput.class);
        DigitalInput silencerMock = mock(DigitalInput.class);

        // Mock up our sensor to not call for silence at first
        when(silencerMock.get()).thenReturn(false);

        // Our two subsystems
        SilenceableHelloWorldSubsystem silenceableHelloWorldSubsystem = new SilenceableHelloWorldSubsystem(firstHelloLEDMock, silencerMock);
        HelloWorldSubsystem helloWorldSubsystem = new HelloWorldSubsystem(secondHelloLEDMock);

        // Our two commands
        SayHelloCommand sayHelloCommand = new SayHelloCommand(helloWorldSubsystem);
        SayHelloUntilSilencedCommand sayHelloUntilSilencedCommand = new SayHelloUntilSilencedCommand(silenceableHelloWorldSubsystem);

        // And finally the command group
        SayHelloInTurnCommandGroup classUnderTest = new SayHelloInTurnCommandGroup(sayHelloUntilSilencedCommand, sayHelloCommand);
        classUnderTest.start();

        //Act
        // Start your engines
        scheduler.runForDuration(1000);

        // Pre-assertion...second led should not have come on, but first should have
        verify(firstHelloLEDMock, atLeast(1)).set(true);
        verify(secondHelloLEDMock, times(0)).set(true);

        // Trigger our sensor...Silence!
        // You could start to get fancy and for reusability, hide this
        // in a static function with a clever name.
        when(silencerMock.get()).thenReturn(true);

        // Start your engines, again...
        scheduler.runForDuration(1000);

        // Final Assert...second LED came on and run until interrupted
        verify(firstHelloLEDMock, atMost(5)).set(true);
        verify(secondHelloLEDMock, atLeast(4)).set(true);
        verify(secondHelloLEDMock, atMost(5)).set(true);
    }
}
