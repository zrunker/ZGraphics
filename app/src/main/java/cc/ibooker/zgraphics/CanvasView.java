package cc.ibooker.zgraphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 画布View
 * Created by 邹峰立 on 2018/3/1.
 */
public class CanvasView extends View {

    private Paint mPaint;

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
    }

    // 绘画
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 取消画笔锯齿效果
        mPaint.setAntiAlias(true);
        // 设置画笔颜色
        mPaint.setColor(Color.RED);

        // 设置画布颜色
        canvas.drawColor(Color.BLACK);

        // 设置裁剪区域
        canvas.clipRect(10, 10, 680, 360);

        // 锁定画布
        canvas.save();

        // 旋转画布45度
        canvas.rotate(45);

        // 绘制矩形
        canvas.drawRect(new Rect(15, 15, 140, 70), mPaint);

        // 解除画布锁定
        canvas.restore();

        // 设置画笔颜色并绘制一个矩形
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(new Rect(150, 75, 360, 120), mPaint);


        // 绘制圆形 - 有部分区域被裁剪
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(170, 230, 70, mPaint);


        // 绘制椭圆
        mPaint.setColor(Color.CYAN);
        RectF rectF = new RectF(80, 30, 150, 70);
        canvas.drawOval(rectF, mPaint);


        // 绘制多边形
        Path path = new Path();
        // 设置多边形的点
        path.moveTo(155, 30);
        path.lineTo(195, 30);
        path.lineTo(180, 70);
        path.lineTo(170, 70);
        // 使这些点构成封闭的多边形
        path.close();
        // 绘制多边形
        canvas.drawPath(path, mPaint);


        // 绘制直线
        mPaint.setColor(Color.LTGRAY);
        mPaint.setStrokeWidth(3);
        canvas.drawLine(5, 110, 315, 110, mPaint);

        // 画图片
        Bitmap bitmapI = ((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap();
//        BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmapI, 360, 80, null);

        // Matrix 3x3矩阵  实现旋转图片
        Matrix matrix = new Matrix();
        // 设置旋转
        matrix.setRotate(30);
        Bitmap bitmap = Bitmap.createBitmap(bitmapI, 0, 0, bitmapI.getWidth(), bitmapI.getHeight(), matrix, true);
        canvas.drawBitmap(bitmap, 460, 80, null);

        // Matrix 3x3矩阵  实现缩放图片
        matrix.postScale(1.5F, 1.5F);
        Bitmap bitmap2 = Bitmap.createBitmap(bitmapI, 0, 0, bitmapI.getWidth(), bitmapI.getHeight(), matrix, true);
        canvas.drawBitmap(bitmap2, 460, 120, null);
    }
}
