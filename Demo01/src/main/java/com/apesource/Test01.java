package com.apesource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test01 {
    public static void main(String[] args) throws Exception {
        // 连接地址：时区改为Asia/Shanghai，增加useSSL=false
        String url = "jdbc:mysql://localhost:3306/demo_db?serverTimezone=Asia/Shanghai&useSSL=false";
        String user = "root";
        String pwd = "zxcv1234";

        // try-with-resources 自动关闭连接、pstmt、rs，不用手动close()
        try (Connection connection = DriverManager.getConnection(url, user, pwd);
             PreparedStatement pstmt = connection.prepareStatement("select sid, sname from student");
             ResultSet rs = pstmt.executeQuery()) {

            // 遍历student表数据
            while (rs.next()) {
                int sid = rs.getInt("sid");
                String sname = rs.getString("sname");
                System.out.println("学号：" + sid + " | 姓名：" + sname);
            }
        }
    }
}
