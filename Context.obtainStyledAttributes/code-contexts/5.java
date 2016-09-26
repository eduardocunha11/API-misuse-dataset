/**
 * Source: https://github.com/zjwgy2012/MainLibrary-1/blob/master/src/com/mobilelibrary/view/ShelvesView.java
 */
private void load(Context context, AttributeSet attrs, int defStyle) {
	        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ShelvesView, defStyle, 0);

	        final Resources resources = getResources();
	        final int background = a.getResourceId(R.styleable.ShelvesView_shelfBackground, 0);
	        final Bitmap shelfBackground = BitmapFactory.decodeResource(resources, background);
	        if (shelfBackground != null) {
	            mShelfWidth = shelfBackground.getWidth();
	            mShelfHeight = shelfBackground.getHeight();
	            mShelfBackground = shelfBackground;
	        }

	        mWebLeft = BitmapFactory.decodeResource(resources, R.drawable.web_left);

	        final Bitmap webRight = BitmapFactory.decodeResource(resources, R.drawable.web_right);
	        mWebRightWidth = webRight.getWidth();
	        mWebRight = webRight;

	        a.recycle();
}
