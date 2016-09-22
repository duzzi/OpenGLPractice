package com.duzzi.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * 文件名: OpenGLLineActivity
 * 描    述: [该类的简要描述]
 * 创建人: 杜舒
 * 创建时间: 2016/9/22
 */
public class OpenGLLineActivity extends OpenGLBaseActivity {
    float vertexArray[] = {
            -0.6f, -0.8f, 0.0f,
            -0.4f, 0.8f, 0.0f,
            0.6f, 0.8f, 0.0f,
            0.8f, -0.8f, 0.0f,
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
        gl.glTranslatef(0, 0, -4);
        gl.glLineWidth(22f);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mFloatBuffer);
        //GL_LINES模式下线的绘制 两两相连
//        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
//        gl.glDrawArrays(GL10.GL_LINES, 0, 4);//从第0个点开始，总共四个点

        //GL_LINE_STRIP模式下线的绘制 依次相连
//        gl.glColor4f(0.0f, 1.0f, 0.0f, 1.0f);
//        gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, 4);

        //GL_LINE_LOOP模式下线的绘制 循环相连
        gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
        gl.glDrawArrays(GL10.GL_LINE_LOOP, 0, 4);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }
}
