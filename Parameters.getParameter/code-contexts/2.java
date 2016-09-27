/**
 * Source: https://github.com/cjh1/gerrit/blob/master/gerrit-sshd/src/main/java/com/google/gerrit/sshd/args4j/AccountGroupIdHandler.java
 */
public final int parseArguments(final Parameters params) throws CmdLineException {
  final String n = params.getParameter(0);
  final AccountGroup group = groupCache.get(new AccountGroup.NameKey(n));
  if (group == null) {
    throw new CmdLineException(owner, "Group \"" + n + "\" does not exist");
  }
  setter.addValue(group.getId());
  return 1;
}
