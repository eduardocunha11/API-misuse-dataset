/**
 * Source: https://github.com/chaitanyakonduru/MihirCampusMate/blob/master/src/com/mms/mcm/activities/BookSearchActivity.java
 */
protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_book_search);
		initializeViews();
		MihirApp app=(MihirApp) getApplication();
		authenticateResponse=app.getCurUserInfo();
		Utils.setActionBar(campusName, studentName, authenticateResponse, null);
		searchListView.setAdapter(new BookSearchAdapter(BookSearchActivity.this,-1, booksList,"search"));
		searchListView.setOnItemClickListener(BookSearchActivity.this);
}
