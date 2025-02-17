// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutoRunTheLauncher extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final LauncherSubsystem launch_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
   private double startTime;
   private double time;
   private double endTime;
   private boolean hasLauncherEnded = false;
  public AutoRunTheLauncher(LauncherSubsystem subsystem, double seconds) {
    launch_subsystem = subsystem;
    startTime = Timer.getFPGATimestamp();
    endTime = startTime + seconds;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    if(time < endTime)
    {
      launch_subsystem.rev();
    }
    else
    {
      hasLauncherEnded = true;
    }
  }

  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    launch_subsystem.stop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return hasLauncherEnded;
    
  }
}
