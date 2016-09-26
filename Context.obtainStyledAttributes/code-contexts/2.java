/**
 * Source: https://github.com/zyr3x/deepmine/blob/master/src/main/java/com/deepmine/by/components/TextViewPlus.java
 */
private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.TextViewPlus);
        String customFont = a.getString(R.styleable.TextViewPlus_customFont);
        setCustomFont(ctx, customFont);
        a.recycle();
}
