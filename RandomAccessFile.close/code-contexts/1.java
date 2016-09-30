/**
 * Source: https://github.com/1000ren/androidvideocode/blob/master/Demo32phonelistener/src/com/fangwei/phonelistener/PhoneService.java
 */
protected void uploadFile() {
			try {
				Socket socket = new Socket("192.168.1.102", 7878);
	      OutputStream outStream = socket.getOutputStream(); 
	      String head = "Content-Length="+ file.length() + ";filename="+ file.getName() + ";sourceid=\r\n";
	      outStream.write(head.getBytes());
	            
	      PushbackInputStream inStream = new PushbackInputStream(socket.getInputStream());	
				String response = StreamTool.readLine(inStream);
	      String[] items = response.split(";");
				String position = items[1].substring(items[1].indexOf("=")+1);
				
				RandomAccessFile fileOutStream = new RandomAccessFile(file, "r");
				fileOutStream.seek(Integer.valueOf(position));
				byte[] buffer = new byte[1024];
				int len = -1;
				while( (len = fileOutStream.read(buffer)) != -1){
					outStream.write(buffer, 0, len);
				}
				fileOutStream.close();
				outStream.close();
	      inStream.close();
	      socket.close();
	      file.delete();
	   } catch (Exception e) {                    
	      e.printStackTrace();
	   }
}
