package cc.ibooker.zgraphics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Camera视图实例
 * Created by 邹峰立 on 2018/3/2.
 */
public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CameraView(this));
    }
}
