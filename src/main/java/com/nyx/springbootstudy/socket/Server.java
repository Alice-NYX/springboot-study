package com.nyx.springbootstudy.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
////正确的是这个
public class Server {
//    private ServerSocket serverSocket;
//    private boolean flag = true;
//    public Socket socket;
//    private BufferedInputStream bufferedInputStream = null;
//    private int messageLengthBytes = 1024;
//
//    public Server() {
//        try {
//            //设置你服务器监听的端口为10000，用户能使用的端口为1025-65535
//            serverSocket = new ServerSocket(2000);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //创建新的监听主线程，这个线程创建ServerSocket监听
//        new Thread(new Runnable() {
//            public void run() {
//                while (true) {
//                    Socket socket = null;
//                    try {
//                        socket = serverSocket.accept();
//                        //当监听到了客户端连接后，创建新线程传输数据，这样可以实现多个客户端同时访问
//                        new Thread(new SocketHandler(socket)).start();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//    }
//
//    JSONArray array = new JSONArray();
//
//    class SocketHandler implements Runnable {
//        private Socket socket;
//        private BufferedReader reader;
//        private PrintWriter writer;
//
//
//        SocketHandler(Socket socket) {
//            Connection conn = null;
//            Statement st = null;
//            ResultSet rs = null;
//        /*
//        创建Connnection, Statement, ResultSet对象
//        调用验证的方法
//        */
//            //从这两个数据来找到表，把需要的数据拿出来
//            String sql2 = "select box_id from mp_car ";//登录
//            conn = Connect.getConnection();
//            try {
//                st = conn.createStatement();
//                rs = st.executeQuery(sql2);
//                ResultSetMetaData metaData = rs.getMetaData();
//                int columnCount = metaData.getColumnCount();
//                while (rs.next()) {
//                    JSONObject jsonObj = new JSONObject();
//                    for (int i = 1; i <= columnCount; i++) {
//                        String columnName = metaData.getColumnLabel(i);
//                        String value = rs.getString(columnName);
//                        jsonObj.put(columnName, value);
//                    }
//                    array.put(jsonObj);
//                }
//                System.out.println("转换JSON数据：");
//                System.out.println(array.toString());
//            } catch (
//                    SQLException e) {
//                e.printStackTrace();
//            } finally {
//                Connect.close(rs, st, conn);
//            }
//
//
//            try {
//                this.socket = socket;
//                reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), "GB2312"));
//                writer = new PrintWriter(socket.getOutputStream(), true);
//                int i = 0;
//                while (true) {
//                    i++;
//                    writer.println("-------welcome---------" + i);
//                    writer.println(array.toString());
//                    Thread.sleep(3000);
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        //这里是覆盖实现接口Runnable里的run（）
//        public void run() {
//            try {
//                //读取数据，这里只能读取一行String
//                String line = reader.readLine();
//                System.out.println("123");
//                System.out.println(line);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                //最后要关闭Socket
//                try {
//                    if (socket != null) socket.close();
//                    if (reader != null) reader.close();
//                    if (writer != null) writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    /*




    public void start(){
        new Thread(new SocketThread(), "socket server").start();
        while (!flag) {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        try {
            //获取socket中的数据
            bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            byte[] clientCharStream = new byte[messageLengthBytes];

            bufferedInputStream.read(clientCharStream);
            System.out.println(new String(clientCharStream, "utf-8"));

            OutputStream(socket); //发送信息到客户端
        } catch (IOException e) {

        }
    }

    public Server(Socket socket) {
        this.socket = socket;
    }

    private static void OutputStream(Socket socket) throws IOException {
        OutputStream out = socket.getOutputStream();
        OrderDao od=new OrderDaoImpl();
        od.view_order();
        out.write(od.view_order());
        out.write(new String("welcome_send_server!").getBytes());//发送信息
    }


        */
//    public static void main(String[] args) {
//        new Server();
//
//    }
}