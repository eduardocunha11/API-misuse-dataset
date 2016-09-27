/**
 * Source: https://github.com/DCPUTools/dcpu16-emulator/blob/master/src/main/java/com/kokakiwi/dcpu16/emulator/args/EmulationSpeedOptionHandler.java
 */
public int parseArguments(Parameters params) throws CmdLineException
{
  String value = params.getParameter(0);
  EmulationSpeed speed = EmulationSpeed.REAL_SPEED;
  if (value.equalsIgnoreCase("max"))
  {
      speed = EmulationSpeed.MAX_SPEED;
  }
  setter.addValue(speed);
  return 1;
}
