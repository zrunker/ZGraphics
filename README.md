# ZGraphics
Graphics类开发相关应用实例。

>作者：邹峰立，微博：zrunker，邮箱：zrunker@yahoo.com，微信公众号：书客创作，个人平台：[www.ibooker.cc](http://www.ibooker.cc)。

>本文选自[书客创作](http://www.ibooker.cc)平台第134篇文章。[阅读原文](http://ibooker.cc/article/134/detail) 。

![书客创作](http://upload-images.jianshu.io/upload_images/3480018-54de3e6256c62d67..jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

Graphics中包括了Canvas（画布），Paint（画笔），Color（颜色），Bitmap（图像），Matrix（矩阵），Camera（相机），2D几何图形等常用类。Graphics具有绘制点，线，颜色，图像处理，2D几何图像等功能。Graphics应用也十分广泛，例如视图的3D旋转，视图缩放等。下面分别介绍Graphics各种类的使用。

#### 一、Paint类

Paint为画笔的意思，要将图像绘制在画布上，就必须先调整画笔，画笔除了可以绘制点，线，面之外，还能通过画笔绘制文字等。Paint中包含了很多属性，该类也提供了很多方法来设置其属性值，主要方法如下：

- 设置画笔的锯齿效果
```
setAntiAlias(boolean aa)
```
- 设置画笔的颜色
```
setColor(@ColorInt int color)
```
- 设置画笔的a，r，p，g值
```
setARGB(int a, int r, int g, int b)
```
- 设置Alpha值
```
setAlpha(int a)
```
- 设置字体尺寸
```
setTextSize(float textSize)
```
- 设置画笔风格，空心或实心
```
setStyle(Style style)
```
- 设置空心的边框宽度
```
setStrokeWidth(float width)
```
- 得到画笔的颜色
```
int getColor()
```
- 得到画笔的Alpha值
```
int getAlpha()
```

Graphics中还提供了Color类，Color类更加简单，主要定义了一些颜色的常量，以及对颜色的转换等。

| 颜色常量 | 含义 |
|:------|:-------:|
| Color.BLACK | 黑色 |
| Color.DKGRAY | 灰黑色 |
| Color.GRAY | 灰色 |
| Color.LTGRAY | 浅灰色 |
| Color.WHITE | 白色 |
| Color.RED | 红色 |
| Color.GREEN | 绿色 |
| Color.BLUE | 蓝色 |
| Color.YELLOW | 黄色 |
| Color.CYAN | 青绿色 |
| Color.MAGENTA | 红紫色 |
| Color.TRANSPARENT | 透明 |

同时Color还提供了Color.rgb方法将整形的颜色转换成Color类型。

```
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
```

![Paint效果图](http://upload-images.jianshu.io/upload_images/3480018-1eef5d7ea5700484..jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 二、Canvas类

Canvas类为画布的意思，当画笔调整好之后，就可以在指定的画布上就行绘制。Canvas类有非常多的属性，例如画布的颜色，尺寸，形状等，下面是Canvas类提供的主要方法：

- 创建一个空的画布，可以使用setBitmap()方法来设置绘制的具体画布。
```
Canvas()
```
- 以bitmap对象创建一个画布，则将内容都会之在bitmap上，因此bitmap不能为NULL
```
Canvas(@NonNull Bitmap bitmap)
```
- 设置画布的背景颜色
```
drawColor(@ColorInt int color)
```
- 设置具体画布
```
setBitmap(@Nullable Bitmap bitmap)
```
- 设置显示区域，即设置裁剪区
```
boolean clipRect(int left, int top, int right, int bottom)
```
- 检测是否支持透明
```
boolean isOpaque()
```
- 旋转画布
```
rotate(float degrees)
```
- 设置偏移量
```
skew(float sx, float sy)
```
Graphics中还提供了Matrix类，该类包含3X3矩阵，专门用于进行图像变化匹配。例如实现图像旋转一定角度可使用setRotate方法；实现图像缩放，可使用postScale方法，实现图像平移，可使用postTranslate方法。Matrix提供了很多操作图像的方法，这里不一一列出。

最后，这里给出关于Canvas实例部分：
```
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
```

![Canvas实例图](http://upload-images.jianshu.io/upload_images/3480018-130a037875a489e9..jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 三、Camera类

在Android中Camera类有两个，一个是用来拍照，而另外一个一般用来计算和实现3D旋转效果，也就是Graphics中的Camera类。Camera类提供的方法不是很多，主要是用来实现视图变换，主要方法如下：

- 锁定Camera
```
save()
```
- Camera解除锁定
```
restore()
```
- 在X、Y、Z三个轴上偏移变换
```
translate(float x, float y, float z)
```
- 在X轴旋转变换
```
rotateX(float deg)
```
- 在Y轴旋转变换
```
rotateY(float deg)
```
- 在Z轴旋转变换
```
rotateZ(float deg)
```
- 在X、Y、Z三个轴上旋转变换
```
rotate(float x, float y, float z)
```
- 获取x轴上的值
```
float getLocationX()
```
- 获取y轴上的值
```
float getLocationY()
```
- 获取z轴上的值
```
float getLocationZ()
```
- 设置X、Y、Z三个轴上的值
```
setLocation(float x, float y, float z)
```
最后简单的实现视图View随手势进行3D旋转效果：
```
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
```
![Camera实现3D旋转效果图](http://upload-images.jianshu.io/upload_images/3480018-dcbbe5ecd6858a83..jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

[Github地址](https://github.com/zrunker/ZGraphics)
[阅读原文](http://ibooker.cc/article/134/detail)

----------
![微信公众号：书客创作](http://upload-images.jianshu.io/upload_images/3480018-f71297ebc20fc9c4..jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
