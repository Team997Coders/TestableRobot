# Hello World Testable Command Robot Example
Here is a suggested approach, based on the command robot template, to create a robot project that can be automation tested using JUnit.

The project is a hello world example which flashes an LED when a button 1 is pressed on a joystick.
In it, I demonstrate exhaustive unit and system tests that you can write and execute, that do
not require a roboRio, the HAL, nor local simulation (mocking using Mockito is demonstrated).

It also has a button 2 that will flash an LED, and then when a digital input is toggled high, a
second LED will flash, turning off the first. Testing of a command group is thus demonstrated.

Finally, the master revision has been clean up though the use of Google Guice. This combines the best of preserving the use of dependency injection to promote testability while at the same time minimizing the down sides of messy object graphs.

The master branch has been coded against the publically available 2019 alpha WPI version (which uses the 2018 roboRio image). There is a new branch called 2019CleanedUpDI which has been upgraded to 2019.1.1-beta-2 WPILib revision and GradleRIO 2019.1.1-beta-2a. Problem with that branch at this point is that unless you are a beta team, you do not have access to the beta roboRio image, and thus you cannot run this version of the branch as of yet. But there are differences between testing with the 2018 vs. 2019 versions.
In addition, the testing framework was upgraded to JUnit5 to be at the same level as WPILib. Current revisons of the beta VSCode plugin generated command robot template
use JUnit 4, so it remains to be seen which version WPI will settle on once released.

For an in-depth walkthough, see [Testable Command Robot](https://www.youtube.com/watch?v=rbSPkhAgLk0) and [Testable Command Groups](https://www.youtube.com/watch?v=DusNuZwCGAM). These videos were recorded against tagged versions of this repository (see comments on video). The master version has changed somewhat and use of Google Guice is discussed in [Cleaning Up Dependency Injection With Guice](https://www.youtube.com/watch?v=QSOkuEqTuSg) 

## Usage
1. Change the team number in ```.wpilib/wpilib_preferences.json``` to your team number.
2. Modify the paths in ```.vscode/launch.test.json``` to match your environment. Sorry, but it does not appear that
MS substitution macros yet work here (arg!).
3. Type ```./gradlew build``` and marvel that testing can be a thing.

## Pending
The allwpilib branch now represents a close revision to the testablerobot example that we are attempting to integrate into allwpilib. See [Add java testablerobot example](https://github.com/wpilibsuite/allwpilib/pull/1461).
