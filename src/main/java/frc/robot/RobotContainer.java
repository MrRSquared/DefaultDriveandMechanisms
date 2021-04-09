// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Drive;
import frc.robot.commands.SetIntake;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //Drivetrain
  private final RomiDrivetrain m_romiDrivetrain = new RomiDrivetrain();
  //Intake
  private final Intake m_intake = new Intake();
  //XboxController
  private final XboxController m_controller = new XboxController(0);

  

  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Set the default command for the drivetrain as a new instance of the Drive Command.
    m_romiDrivetrain.setDefaultCommand(new Drive(m_romiDrivetrain, ()-> -(m_controller.getRawAxis(1)), ()-> -(m_controller.getRawAxis(0))));
    //Atttempt to set the default command of the intake as a new instance of the SetIntake command.
    m_intake.setDefaultCommand(new SetIntake(m_intake, () -> m_controller.getRawAxis(4)));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new PrintCommand("Hello World; You are in Auo Mode. It is in our hands now..");
  }
}
