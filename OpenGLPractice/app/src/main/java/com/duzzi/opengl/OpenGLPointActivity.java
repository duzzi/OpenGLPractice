package com.duzzi.opengl;

import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class OpenGLPointActivity extends OpenGLBaseActivity {

    private FloatBuffer mFloatBuffer;

    @Override
    protected void initBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertexArray.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        mFloatBuffer = byteBuffer.asFloatBuffer();
        mFloatBuffer.put(vertexArray).position(0);
    }

    float[] vertexArray = new float[]{
            0.8f, -0.4f, 0.0f,
            -0.8f, -0.4f, 0.0f,
            0.0f, 0.8f, 0.0f,
    };

    @Override
    public void onDraw(GL10 gl) {
        Log.d("---", "onDraw");
        gl.glLoadIdentity();

        gl.glColor4f(0.9f, 0.0f, 0.0f, 1f);
        gl.glTranslatef(0, 0, -4);
        gl.glPointSize(20f);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mFloatBuffer);


        gl.glDrawArrays(GL10.GL_POINTS, 0, 3);//从第0个点开始，总共3个点

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
