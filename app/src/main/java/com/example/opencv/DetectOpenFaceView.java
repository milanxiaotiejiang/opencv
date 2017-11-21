package com.example.opencv;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import org.opencv.core.Rect;

/**
 * Created by zhangyuanyuan on 2017/11/4.
 */

public class DetectOpenFaceView extends View {

    private Paint mPaint;
    private Paint mClearPaint;

    private Rect[] mFaces;
    private int mCameraId;

    public void setFaces(Rect[] faces, int cameaId) {
        this.mFaces = faces;
        mCameraId = cameaId;
        invalidate();
    }

    public DetectOpenFaceView(Context context) {
        super(context);
        init(context);
    }

    public DetectOpenFaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DetectOpenFaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5f);
        mPaint.setStyle(Paint.Style.STROKE);

        mClearPaint = new Paint();
        mClearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mFaces == null || mFaces.length < 0) {

            canvas.save();
            canvas.drawPaint(mClearPaint);
            canvas.restore();
            return;
        }
        canvas.save();
        for (int i = 0; i < mFaces.length; i++) {
            Rect face = mFaces[i];

            int x;
            int y;
            float width;
            float height;
            width = face.width* getWidth() / 480;
            height = face.height* getHeight() / 640;
            y = face.y * getHeight() / 640 ;
            if(mCameraId == android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT){
                x = (int) (getWidth() - face.x * getWidth() / 480 - width);
            }else{
                x = face.x * getWidth() / 480;
            }
            Log.d("DetectOpenFaceView", "x:" + x + ", y:" + y);
            canvas.drawRect(x, y, x + width, y + height, mPaint);

        }
        canvas.restore();
    }

    public void clear() {
        mFaces = null;
        invalidate();
    }
}
