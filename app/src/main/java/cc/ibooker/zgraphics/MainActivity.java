package cc.ibooker.zgraphics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intnet = new Intent(this, PaintActivity.class);
        startActivity(intnet);

//        Intent intent = new Intent(this, CanvasActivity.class);
//        startActivity(intent);

    }
}
