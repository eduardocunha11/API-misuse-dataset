/**
 * Source: https://github.com/sasipraveen39/Vowcher-mobile/blob/master/src/com/vowcher/mobile_app/LoginActivity.java
 */
public void requestLogin(View view) throws ClientProtocolException, IOException, JSONException {
		EditText uname = (EditText)findViewById(R.id.usernametext);
		String username = uname.getText().toString();
		EditText pwd = (EditText)findViewById(R.id.passwordtext);
		String password=pwd.getText().toString();
		
		LoginTask task = new LoginTask();
		String[] params = new String[2];
		params[0] = username;
		params[1] = password;
		String sid = task.doInBackground(params);
		if(sid.equals("AUTH_ERROR")){
			TextView error = (TextView)findViewById(R.id.errorMsg);
			error.setText("Invalid username or password");
			uname.requestFocus();
		}
		else {
			JSONObject json_obj = new JSONObject(sid);
			GlobalVars.userId = json_obj.getString("USERNAME");
			GlobalVars.userFullName = json_obj.getString("FULLNAME");
			GlobalVars.secureId = json_obj.getString("SECUREID");
			
			Intent intent = new Intent(this, DashboardActivity.class);
		    startActivity(intent);
		}
}
