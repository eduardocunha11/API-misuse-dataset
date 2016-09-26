/**
 * Source: https://github.com/zoozooll/Launcher_for_pad/blob/master/src/com/aaron/launcherics/StrokedTextView.java
 */
private void init(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.StrokedTextView,
                defStyle, 0);
        mStrokeColor = a.getColor(R.styleable.StrokedTextView_strokeColor, 0xFF000000);
        mStrokeWidth = a.getFloat(R.styleable.StrokedTextView_strokeWidth, 0.0f);
        mTextColor = a.getColor(R.styleable.StrokedTextView_strokeTextColor, 0xFFFFFFFF);
        a.recycle();
        mUpdateCachedBitmap = true;

        // Setup the text paint
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
}
