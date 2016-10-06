/**
 * Source: https://github.com/Harshada-webonise/zomato_application/blob/master/src/com/pack/Zomato/LocationActivity.java
 */
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener ll = new mylocationlistener();
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
        
        Intent intent=new Intent(LocationActivity.this,Login.class);
        startActivity(intent);
}
