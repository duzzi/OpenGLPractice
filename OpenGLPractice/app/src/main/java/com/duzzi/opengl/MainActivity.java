package com.duzzi.opengl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    String[] mStringArray = new String[]{
            "绘制点", "绘制线", "绘制三角形", "绘制多面体"
    };
    private MyAdapter.OnItemClickListener mOnItemClickListener = new MyAdapter.OnItemClickListener() {
        @Override
        public void callback(int position) {
            switch (position) {
                case 0:
                    startActivity(new Intent(MainActivity.this, OpenGLPointActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(MainActivity.this, OpenGLLineActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(MainActivity.this, OpenGLTriangleActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(MainActivity.this, OpenGL20FaceActivity.class));
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        assert recyclerView != null;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(this, mStringArray);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(mOnItemClickListener);
    }
}
