package cc.ibooker.zgraphics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView paintTv = findViewById(R.id.tv_paint);
        paintTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnet = new Intent(MainActivity.this, PaintActivity.class);
                startActivity(intnet);
            }
        });

        TextView canvasTv = findViewById(R.id.tv_canvas);
        canvasTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CanvasActivity.class);
                startActivity(intent);
            }
        });

        TextView cameraTv = findViewById(R.id.tv_camera);
        cameraTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

    }
}
