### Netty的介绍

1. Netty是由JBOSS提供的一个Java开源框架
2. Netty是一个**异步的**、基于**事件驱动**的**网络应用框架**，用以快速开发高性能、高可靠性的网络IO程序
3. Netty主要针对在TCP协议下，面向Clients端的高并发应用，或Peer-to-Pree场景下的大量数据持续传输的应用
4. Netty本质是一个NIO框架，适用于服务器通讯相关的多种应用场景

IO模型：BIO、NIO、AIO
BIO: 同步并阻塞（传统阻塞型），服务器实现模式为一个连接一个线程，即客户端由连接请求时服务器就需要启动一个
    线程进行处理，如果这个连接不做任何事情会造成不必要的线程开销
使用场景：连接数目比较小且固定的架构，这种方式对服务器资源要求比较高，并发局限于应用中，JDK1.4之前唯一的选择，程序简单易理解

NIO: 同步非阻塞，服务器实现模式为一个线程处理多个请求（连接），即客户端发送的连接请求都会注册到多路复用器上，
    多路复用器轮询到有I/O请求就进行处理
使用场景：连接数目多且连接比较短（轻操作）的架构，比如聊天服务器，弹幕系统，服务器间通讯等。编程较复杂，JDK1.4开始支持
    
AIO: 异步非阻塞，AIO引入异步通道的概念，采用Proactor模式，简化了程序的编写，有效的请求才启动线程，他的特点是
    先由操作系统完成之后才通知服务端程序启动线程去处理，一般适用于连接数较多且连接时间较长的应用
使用场景：连接数目较多且连接比较长（重操作）的架构，比如相册服务器，充分调用OS参与并发操作，编程较复杂，JDK7开始支持