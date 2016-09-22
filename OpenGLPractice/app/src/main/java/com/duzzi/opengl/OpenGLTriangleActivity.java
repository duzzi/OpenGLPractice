package com.duzzi.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * 文件名: OpenGLTriangleActivity
 * 描    述: [该类的简要描述]
 * 创建人: duzzi
 * 创建时间: 2016/9/22
 */
public class OpenGLTriangleActivity extends OpenGLBaseActivity {
    //OpenGL只能绘制点、线和三角形
    float vertexArray[] = {
            -0.8f, -0.4f * 1.732f, 0.0f,
            0.0f, -0.4f * 1.732f, 0.0f,
            -0.4f, 0.4f * 1.732f, 0.0f,

            0.0f, -0.0f * 1.732f, 0.0f,
            0.8f, -0.0f * 1.732f, 0.0f,
            0.8f, 0.4f * 1.732f, 0.0f,
    };
    private FloatBuffer mFloatBuffer;

    @Override
    protected void initBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertexArray.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        mFloatBuffer = byteBuffer.asFloatBuffer();
        mFloatBuffer.put(vertexArray).position(0);
    }

    @Override
    public void onDraw(GL10 gl) {
        gl.glLoadIdentity();
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(0, 0, -4);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mFloatBuffer);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);

//        gl.glColor4f(0.0f, 1.0f, 0.0f, 1.0f);
//        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 6);
//
//        gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
//        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 6);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
