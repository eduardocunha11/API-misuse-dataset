/**
 * Source: https://github.com/wuchubuzai/OpenIMAJ/blob/master/thirdparty/ImprovedArgs4J/src/main/java/org/kohsuke/args4j/FImageOptionHandler.java
 */
public int parseArguments(Parameters params) throws CmdLineException {
  File file = new File(params.getParameter(0));
  try {
    setter.addValue(ImageUtilities.readF(file));
  } catch (IOException e) {
    throw new CmdLineException(owner, "Error opening image file " + file, e);
  }
  return 1;
}
