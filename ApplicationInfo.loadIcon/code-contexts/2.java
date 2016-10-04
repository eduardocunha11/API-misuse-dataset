/**
 * Source: https://github.com/ductoanle/GTVHomePlus/blob/master/src/com/ep/gtvhomeplus/file/DirectoryScanner.java
 */
Drawable getDrawableForMimetype(File file, String mimetype) {
     if (mimetype == null) {
    	 return null;
     }
     
   	 PackageManager pm = context.getPackageManager();
   	
   	 if (mimetype.equals(MIME_APK)){
   		 String path = file.getPath();
   		 PackageInfo pInfo = pm.getPackageArchiveInfo(path, PackageManager.GET_ACTIVITIES);
   		 if (pInfo!=null) {
	   		 ApplicationInfo aInfo = pInfo.applicationInfo;
	   		 
	   		 if(Build.VERSION.SDK_INT >= 8){
	   			 aInfo.sourceDir = path;
	   			 aInfo.publicSourceDir = path;
	   		 }
	   		 
	   		 return aInfo.loadIcon(pm);
   		 }
   	 }
   	 
   	 ...
}
