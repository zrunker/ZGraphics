package cc.ibooker.zgraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 画笔View
 * Created by 邹峰立 on 2018/3/1.
 */
public class PaintView extends View {
    private Paint mPaint;

    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // 初始化画笔
        mPaint = new Paint();
    }

    // 绘画
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 设置画笔的锯齿效果
        mPaint.setAntiAlias(true);

        // 设置画笔颜色
        mPaint.setColor(Color.RED);

        // 设置画笔的a,r,g,b值
        mPaint.setARGB(255, 255, 0, 0);

        // 设置画笔Alpha值
        mPaint.setAlpha(200);

        // 设置画笔风格，实心
        mPaint.setStyle(Paint.Style.FILL);

        // 设置画笔风格，空心
        mPaint.setStyle(Paint.Style.STROKE);

        // 设置空心的边框宽度
        mPaint.setStrokeWidth(5);

        Log.d("得到画笔的颜色", mPaint.getColor() + "");
        Log.d("得到画笔的Alpha值", mPaint.getAlpha() + "");

        // 调整画布
        // 绘制一个矩形
        canvas.drawRect(20, 20, 100, 60, mPaint);

        // 绘制字体
        Typeface typeface = Typeface.create(Typeface.DEFAULT, Typeface.ITALIC);
        mPaint.setColor(Color.BLUE);
        mPaint.setTypeface(typeface);
        // 设置字体大小
        mPaint.setTextSize(30);
        canvas.drawText("画出来的字体", 0, 200, mPaint);
    }
}
