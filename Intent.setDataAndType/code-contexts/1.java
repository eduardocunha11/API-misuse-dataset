/**
 * Source: https://github.com/1000ren/androidvideocode/blob/master/Demo28Intent/src/com/fangwei/intent/MainActivity.java
 */
public void openActivity(View v){
    	Intent intent = new Intent();
    	intent.setAction("cn.fangwei.laoli");
    	intent.addCategory("cn.fangwei.category.zhangxx");
    	intent.setDataAndType(Uri.parse("fangwei://www.fangwei.cn/liming"), "image/gif");
    	/*
    	intent.setData(Uri.parse("itcast://www.itcast.cn/liming"));
    	intent.setType("image/gif");
    	*/
    	startActivity(intent);
}
