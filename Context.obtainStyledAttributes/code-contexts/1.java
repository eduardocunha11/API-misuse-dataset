/**
 * Source: https://github.com/alexbrault/LegendaryRandomiser/blob/master/src/net/threedoubloons/legendaryrandomiser/SetsListPreference.java
 */
private void initAttributes(AttributeSet attrs) {
		TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SetsListPreference);
		
		entries = a.getTextArray(R.styleable.SetsListPreference_android_entries);
		CharSequence alwaysOn_raw = a.getText(R.styleable.SetsListPreference_alwaysOn);
		String alwaysOn_str = alwaysOn_raw != null ? alwaysOn_raw.toString(): "0";
		try {
			alwaysOn = Long.decode(alwaysOn_str).longValue();
		} catch (NumberFormatException e) {
			Log.e(getKey(), String.format("Couldn't parse the alwaysOn value: %s", alwaysOn_str));
			alwaysOn = 0L;
		}
		
		int icnsRes = a.getResourceId(R.styleable.SetsListPreference_entryIcons, 0);
		if (icnsRes != 0) {
			TypedArray icns = a.getResources().obtainTypedArray(icnsRes);
			entryIcons = new Drawable[icns.length()];
			for (int i = 0; i < icns.length(); ++i) {
				entryIcons[i] = icns.getDrawable(i);
			}
			
			icns.recycle();
		}
		a.recycle();
		
		fullEntries = new SetEntry[entries.length];
		for (int i = 0; i < entries.length; ++i) {
			fullEntries[i] = new SetEntry(entries[i], entryIcons[i]);
		}
}
