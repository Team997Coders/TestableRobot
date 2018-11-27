package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;

/**
 * An example subsystem which encapsuates an LED with the added behavior
 * of silencing it on demand from external stimulus. Note that we do not
 * need to rip up our rigorously tested HelloWorldSubsystem. Just extend and
 * add the needed additional behavior. Object orientation. Yes!
 */
public class SilenceableHelloWorldSubsystem extends HelloWorldSubsystem {

  /**
   * Stimulus sensor example hardware that the subsystem encapsulates. We keep it private
   * because the user of the class should have no business fooling with
   * internal state directly. Use instance methods to perform actions on hardware.
   * We make it final because the instance needs to count on the fact that the
   * hardware will not change out from under it throughout its life.
   */
  private final DigitalInput silencer;

  /**
   * We create a constructor to inject "dependencies" into our class. Do not instantiate
   * external dependencies directly. Instead, invite them in and simply use them. In this
   * way, we can always instantiate this class, even if hardware does not actually exist.
   * The requirement of instantiation is an "invariant". In order to even have the hope
   * of automated testing, we must always be able to instantiate our class.
   * 
   * @param led         Digital output hardware our led is connected to
   * @param silencer    Digital input hardware to sense when to be silent
   */
  public SilenceableHelloWorldSubsystem(DigitalOutput led, DigitalInput silencer) {
    // Must call superclass to set its instance variables and do any other initialization
    super(led);

    // Another invariant is that our class always assumes that a
    // valid reference to our sensor will exist. So complain 
    // if our invited guest is nothingness.
    if (silencer == null) {
        throw new IllegalArgumentException("I must have what at least looks like a silencer!");
    }

    // Assign our invited guest to an instance variable, so we can use it later.
    this.silencer = silencer;
  }

  /**
   * Accessor method to let a consumer know we want silence.
   * @return    True if silence is sensed
   */
  public boolean beSilent() {
    return silencer.get(); 
  }
}
