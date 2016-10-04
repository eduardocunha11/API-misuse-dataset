/**
 * Source: https://github.com/4ndrew/odisp/blob/master/src/org/valabs/odisp/standart/ObjectManager.java
 */
public final void storeHints() {
      Iterator it;
      String msg = "\n============================================\n";
      
      if (newHints.size() > 0) {
        msg += "Result hints file:\n";
        try {
          final File hintsFile = new File("hints");
          hintsFile.createNewFile();
          final PrintStream out = new PrintStream(new FileOutputStream(hintsFile));
          it = newHints.iterator();
          while (it.hasNext()) {
            final String elt = (String) it.next();
            out.println(elt);
            msg += "\t" + elt + "\n";
          }
        } catch (IOException e) {
          log.warning("Unable to write hints file.");
          dispatcher.getExceptionHandler().signalException(e);
        }
        msg += "Total: " + newHints.size() + "\n";
        msg += "============================================\n";
        log.fine(msg);
	}
}
