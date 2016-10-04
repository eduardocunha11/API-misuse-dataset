/**
 * Source: https://github.com/23278299/appsite/blob/master/appsite-platform/src/main/java/com/appsite/platform/generator/JspGenerator.java
 */
private static boolean saveFile(String workspaceWebBasePath, String modulePath, String module, String content) {
    
    ...
    
    File jspFile = new File(jspDir, module+".jsp");
    if (!jspFile.exists()) {
        try {
            jspFile.createNewFile();
            saveFile(jspFile,content);
            return true;
        } catch (IOException e) {
            LOG.error("生成JSP错误",e);
        }
    } else {
           LOG.info("源文件已经存在，请删除 "+jspFile.getAbsolutePath()+" 后再执行命令");                
    }
    return false;
}
