/**
 * Source: https://github.com/HieuLt92/AndroidVolleyExample/blob/master/VolleyImageLoading/src/com/technotalkative/volleyimageloading/MainActivity.java
 */
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		networkImageView = (NetworkImageView) findViewById(R.id.networkImageView);
		imageView = (ImageView) findViewById(R.id.imageView1);
		mRequestQueue = Volley.newRequestQueue(this);
		imageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache(
				BitmapLruCache.getDefaultLruCacheSize()));
}
