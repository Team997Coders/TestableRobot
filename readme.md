# Hello World Testable Command Robot Template
Here is a suggested approach, based on the command robot template, to create a robot project that can be automation tested using JUnit.

The project is a hello world example which flashes an LED when a button 1 is pressed on a joystick.
In it, I demonstrate exhaustive unit and system tests that you can write and execute, that do
not require a roboRio, the HAL, nor local simulation (mocking using Mockito is demonstrated).

It also has a button 2 that will flash an LED, and then when a digital input is toggled high, a
second LED will flash, turning off the first. Testing of a command group is thus demonstrated.

Also, compared to the prior revision, I have upgraded the build to use the 2019.1.1-beta-2 WPILib revision and GradleRIO 2019.1.1-beta-2a.
In addition, the testing framework was upgraded to JUnit5 to be at the same level as WPILib. Current revisons of the beta VSCode plugin generated command robot template
use JUnit 4, so it remains to be seen which version WPI will settle on once released.

For an in-depth walkthough, see [Testable Command Robot](https://www.youtube.com/watch?v=rbSPkhAgLk0) and [Testable Command Groups](https://www.youtube.com/watch?v=DusNuZwCGAM). These videos were recorded against tagged versions of this repository (see comments on video). The master version has changed somewhat.

## Usage
1. Download [Visual Studio 2017 Community Edition](https://visualstudio.microsoft.com/downloads/). Install C++ desktop support. If you do not, you will
receive a ```java.io.IOException /windows/x86-64/wpiHaljni.hash Resource not found``` exception. See pending below.
2. The 2019 image for the roboRio must be installed. At the time of this writing, I have not done that and so have not actually tested this revision
on live hardware. Junit tests can be run with gradlew however.
3. Change the team number in ```.wpilib/wpilib_preferences.json``` to your team number.
4. Modify the paths in ```.vscode/launch.test.json``` to match your environment. Sorry, but it does not appear that
MS substitution macros yet work here (arg!).
5. Type ```./gradlew build``` and marvel that testing can be a thing.

## Pending
The allwpilib branch now represents a close revision to the testablerobot example that we are attempting to integrate into allwpilib. See [Add java testablerobot example](https://github.com/wpilibsuite/allwpilib/pull/1461). The master branch will represent additional work including more advanced testing topics, like use of inversion of 
control containers. It is not intended that these more advanced features will appear in the VSCode plugin example. The master version has also been modified to run against the lastest beta of allwpilib, which means that you should be able to download it and run the tests irrespective of whether WPI merges our PR.

Also, VS2017 should not need to be installed after 2019 release (just the VS runtime, which I hope will be bundled with all the other dependencies). At present, the beta version of WPILib is linked to the debug version of the Visual C runtime, which is why you need to install Visual Studio at present.
