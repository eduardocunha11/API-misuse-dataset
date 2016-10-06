/**
 * Source: https://github.com/saumitrab/AndroidGridImageSearch/blob/master/src/com/example/gridimagesearch/SearchActivity.java
 */
public void setupViews() {
    	etQuery = (EditText) findViewById(R.id.etQuery);
    	gvResults = (GridView) findViewById(R.id.gvResults);
    	btnSearch = (Button) findViewById(R.id.btnSearch);
    	btnLoadMore = (Button) findViewById(R.id.btnLoadMore);
    	btnLoadMore.setVisibility(Button.INVISIBLE);
}
