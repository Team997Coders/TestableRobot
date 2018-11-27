# Hello World Testable Command Robot Template
Based on my controversial assertion of never using the default Command Robot WPI VSCode template
as a starting point for your robot, particularly if you have any hope of testing it, here is a 
suggested alternative. It is based on the command robot template, but poor practices that lead
to untestable subsystems, commands, and command groups have been addressed.

The project is a hello world example which flashes an LED when a button 1 is pressed on a joystick.
In it, I demonstrate exhaustive unit and system tests that you can write and execute, that do
not require a roboRio.

It also has a button 2 that will flash and LED and then when a digitial input is toggled high, a
second LED will flash. Testing of a command group is demonstrated.

Also, compared to the prior revision, I have upgraded the build to use the 2019.1.1-beta-2 WPILib revision and GradleRIO 2019.1.1-beta-2a.
In addition, the testing framework was upgraded to JUnit5 to be at the same level as WPI.

For an in-depth walkthough, see [Testable Command Groups](https://www.youtube.com/watch?v=DusNuZwCGAM). It is not nearly as long as the last one. Promise!

## Usage
1. Download [Visual Studio 2015 Community Edition](https://visualstudio.microsoft.com/vs/older-downloads/) - note 2017 will not work.
2. The 2019 image for the roboRio must be installed. At the time of this writing, I have not done that and so have not actually tested this revision
on live hardware. Junit tests can be run with gradlew however.
3. Change the team number in ```.wpilib/wpilib_preferences.json``` to your team number.
4. Modify the paths in ```.vscode/launch.test.json``` to match your environment. Sorry, but it does not appear that
MS substitution macros yet work here (arg!).
5. Type ```./gradlew build``` and marvel that testing can be a thing.
