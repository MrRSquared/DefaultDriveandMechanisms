// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /** Creates a new Shooter. */
  private final VictorSP m_intakeMotor = new VictorSP(2);
  public Intake() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setSpeed(double speed){
    m_intakeMotor.set(speed);

  }
}
