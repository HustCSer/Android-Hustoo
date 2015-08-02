package com.scb.administrator.a;

/**
 * Created by Administrator on 2015/6/5 0005.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import android.widget.ImageView;



public class CircleImageView extends ImageView {

    Path path;
    public PaintFlagsDrawFilter mPaintFlagsDrawFilter;// ë�߹���
    Paint paint;
    public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        init();
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        init();
    }

    public CircleImageView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        init();
    }

    public void init() {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas cns) {
        // TODO Auto-generated method stub
        Drawable drawable = getDrawable();
        if (null != drawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap b = circleDraw(bitmap);
            final Rect rect1 = new Rect(0, 0, b.getWidth(), b.getHeight());
            final Rect rect2 = new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight());
            paint.reset();
            cns.drawBitmap(b, rect1, rect2, paint);
            b.recycle();
        } else {
            super.onDraw(cns);
        }
    }

    private Bitmap circleDraw(Bitmap bitmap) {
        int r=0;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Rect rectSource = null;
        if(width>height)
            r=height;
        else
        {
            r=width;
        }

        Bitmap output = Bitmap.createBitmap(r, r, Config.ARGB_8888);

        Canvas canvas = new Canvas(output);
        final Rect rect = new Rect(0, 0, r, r);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.BLUE);

        canvas.drawCircle(r/ 2, r / 2, r / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }
}
