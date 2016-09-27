/**
 * Source: https://github.com/teamblueridge/gerrit/blob/master/gerrit-server/src/main/java/com/google/gerrit/server/args4j/SubcommandHandler.java
 */
public final int parseArguments(final Parameters params) throws CmdLineException {
  setter.addValue(params.getParameter(0));
  owner.stopOptionParsing();
  return 1;
}
