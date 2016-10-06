/**
 * Source: https://github.com/sasasaiki/Android-application-Umanyoro/blob/master/Thesnake/src/jp/saiki/newsnake/SnakeEnd.java
 */ 
void initText() {
    TextView t[] = new TextView[5];
		for (int i = 0; i < 5; i++) {
			t[i] = new TextView(getApplicationContext());
		}

		t[0] = (TextView) findViewById(R.id.textView2);
		t[1] = (TextView) findViewById(R.id.TextView3);
		t[2] = (TextView) findViewById(R.id.TextView4);
		t[3] = (TextView) findViewById(R.id.TextView5);
		t[4] = (TextView) findViewById(R.id.TextView6);
}
