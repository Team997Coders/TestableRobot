# Hello World Testable Command Robot Template
Based on my controversial assertion of never using the default Command Robot WPI VSCode template
as a starting point for your robot, particularly if you have any hope of testing it, here is a 
suggested alternative. It is based on the command robot template, but poor practices that lead
to untestable subsystems, commands, and command groups have been addressed.

The project is a hello world example which flashes an LED when a button is pressed on a joystick.
In it, I demonstrate exhaustive unit and system tests that you can write and execute, that do
not require a roboRio.

Other than not wiring the LED correctly (be sure to connect positive to the signal pin!), this code worked
the first time upon deployment to the roboRio. Yes, it's simple. But even one line of code can have a bug.

For an in-depth walkthough, see [The TestableCommandRobot](https://www.youtube.com/watch?v=rbSPkhAgLk0). Sorry ahead of time for the length. There is much
to cover.

## Usage
1. Change the team number in ```.wpilib/wpilib_preferences.json``` to your team number.
2. Modify the paths in ```.vscode/launch.test.json``` to match your environment. Sorry, but it does not appear that
MS substitution macros yet work here (arg!).
3. Type ```./gradlew build``` and marvel that testing can be a thing.
4. Plug in a roboRio, connect an LED to port 0 with a current limiting resistor, plug in a joystick, deploy code,
and push the A button.  LED should flash.