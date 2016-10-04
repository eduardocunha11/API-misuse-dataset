/**
 * Source: https://github.com/MrLoog/Vehicle-ShowRoom-Management-System/blob/master/src/app/utility/AppUtility.java
 */
private static void loadConnection() {
        BufferedReader br = null;
        File f = new File(AppUtility.getCurrentDir() + "\\databaseconnection.vsm");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(AppUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            br = new BufferedReader(new FileReader(AppUtility.getCurrentDir() + "\\databaseconnection.vsm"));
            String driver = br.readLine();
            String url = br.readLine();
            String username = br.readLine();
            String password = br.readLine();
            String databasename = br.readLine();
            url = url + ";database=" + databasename;
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
        }
}
