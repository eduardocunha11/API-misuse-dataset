/**
 * Source: https://github.com/saumitrab/TipCalculator/blob/master/src/com/yahoo/tipcalculator/MainActivity.java
 */
public void calculateTipFunction(View v) {
    	etBillAmount = (EditText) findViewById(R.id.etBillAmount);
    	tvTipAmount  = (TextView) findViewById(R.id.tvTipText);
    	final InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    	
    	lastTipPercent = Double.parseDouble(v.getTag().toString());
    	double tip = Double.parseDouble(etBillAmount.getText().toString()) * lastTipPercent / 100;
    	
    	tvTipAmount.setText("Tip is: " + String.format("%.2f", tip));
    	inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
}
