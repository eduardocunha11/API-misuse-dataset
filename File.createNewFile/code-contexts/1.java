/**
 * Source: https://github.com/13leaf/MyTool/blob/master/src/android/SelectorMaker.java
 */
public void makeSelector(String resPath,boolean reWrite) throws IOException {
    
    ...

    for(String validDrawableName:validSelectAbleDrawables)
		{
			  File selectorFile=new File(drawableDir,validDrawableName+".xml");
			  if (selectorFile.exists()) {
				   System.err.println(validDrawableName+" has already exists in drawable directory");
				   if(!reWrite) continue; 
			  }
			  selectorFile.createNewFile();
			  Properties attribute=new Properties();
			  attribute.put(KEY_FOCUS_DRAWABLE, validDrawableName+split+focusSuffix);
			  attribute.put(KEY_NORMAL_DRAWABLE, validDrawableName+split+normalSuffix);
			  String makedSelector=TemplateParser.parseTemplate(TEMPLATE_SELECTOR, attribute);
			  Files.write(selectorFile, makedSelector);
			  System.out.println("make selector:"+validDrawableName+" complete!");
    }
}
