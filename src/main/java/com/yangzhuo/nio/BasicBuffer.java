package com.yangzhuo.nio;

import java.nio.IntBuffer;

/**
 * BIO是基于字节流和字符流进行操作的
 * NIO是基于Channel(通道)和Buffer(缓冲区)进行操作的，数据总是从通道读取到缓冲区，或从缓冲区写到通道中
 */
public class BasicBuffer {
    public static void main(String[] args) {

        //举例说明 Buffer 的使用
        //创建一个Buffer,大小为5，即可以存放5个int
        IntBuffer intBuffer = IntBuffer.allocate(5);

        //向buffer 存放数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i + 1);
        }

        System.out.println("intBuffer.capacity(): " + intBuffer.capacity());
        System.out.println("intBuffer.position(): " + intBuffer.position());

        //如何从buffer读取数据
        //将buffer转换，读写切换
        intBuffer.flip();
        intBuffer.position(1);
        intBuffer.limit(3);
        System.out.println("intBuffer.capacity(): " + intBuffer.capacity());
        System.out.println("intBuffer.position(): " + intBuffer.position());
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }

        intBuffer.clear();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
