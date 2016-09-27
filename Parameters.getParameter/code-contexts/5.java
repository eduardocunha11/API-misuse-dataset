/**
 * Source: https://github.com/tart/closure-compiler/blob/master/src/com/google/javascript/jscomp/CommandLineRunner.java
 */
public int parseArguments(Parameters params) throws CmdLineException {
  String param = null;
  try {
    param = params.getParameter(0);
  } catch (CmdLineException e) {
    param = null; // to stop linter complaints
  }

  if (param == null) {
    setter.addValue(true);
    return 0;
  } else {
    String lowerParam = param.toLowerCase();
    if (TRUES.contains(lowerParam)) {
      setter.addValue(true);
    } else if (FALSES.contains(lowerParam)) {
      setter.addValue(false);
    } else {
      setter.addValue(true);
      return 0;
    }
    return 1;
  }
}
