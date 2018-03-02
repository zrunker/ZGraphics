package cc.ibooker.zgraphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 相机View
 * Created by 邹峰立 on 2018/3/2.
 */
public class CameraView extends View {
    private Bitmap showBmp;
    private Matrix matrix; // 作用矩阵
    private Camera camera;
    private int deltaX, deltaY; // 翻转角度差值
    private int centerX, centerY; // 图片中心点
    private int lastMouseX;
    private int lastMouseY;

    public CameraView(Context context) {
        this(context, null);
    }

    public CameraView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CameraView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData() {
        showBmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_512);
        centerX = showBmp.getWidth() / 2;
        centerY = showBmp.getHeight() / 2;
        matrix = new Matrix();
        camera = new Camera();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastMouseX = x;
                lastMouseY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = x - lastMouseX;
                int dy = y - lastMouseY;
                deltaX += dx;
                deltaY += dy;
                break;
        }
        // 强制刷新View
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 锁定相机
        camera.save();
        // 绕X轴翻转
        camera.rotateX(-deltaY);
        // 绕Y轴翻转
        camera.rotateY(deltaX);
        // 设置camera作用矩阵
        camera.getMatrix(matrix);
        // 解除相机锁定
        camera.restore();

        // 设置翻转中心点
        matrix.preTranslate(-this.centerX, -this.centerY);
        matrix.postTranslate(this.centerX, this.centerY);

        canvas.drawBitmap(showBmp, matrix, null);
    }

}
