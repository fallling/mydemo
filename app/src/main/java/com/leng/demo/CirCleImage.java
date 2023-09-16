package com.leng.demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;


@SuppressLint("AppCompatCustomView")
public class CirCleImage extends ImageView {

    private String TAG = "CirCleImage";
    private int width;
    private int height;
    private Path path;
    private Path srcPath;
    private Paint paint;
    private RectF srcRectF;
    private Xfermode xfermode;


    public CirCleImage(Context context) {

        this(context, null);
    }

    public CirCleImage(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CirCleImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public CirCleImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr,int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        path = new Path();
        srcPath = new Path();
        paint = new Paint();
        xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(srcRectF, null, Canvas.ALL_SAVE_FLAG);
        super.onDraw(canvas);

        path.reset();
        paint.reset();

        path.addCircle(width/2, height/2, width/2, Path.Direction.CW);

        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setXfermode(xfermode);//设置混合模式 DST_OUT
        srcPath.addRect(srcRectF, Path.Direction.CCW);
        srcPath.op(path, Path.Op.DIFFERENCE);
        canvas.drawPath(srcPath, paint);
        paint.setXfermode(null);
        canvas.restore();
        Log.d(TAG, "onDraw: width:" + width + "height:" + height);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        srcRectF =  new RectF(0, 0, w, h);

        Log.d(TAG, "onSizeChanged: srcRectF:" + srcRectF.toString());
    }
}
