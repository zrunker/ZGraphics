package cc.ibooker.zgraphics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 画笔工具类的简单实用实例
 * Created by 邹峰立 on 2018/3/1.
 */
public class PaintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new PaintView(this));
    }

}
