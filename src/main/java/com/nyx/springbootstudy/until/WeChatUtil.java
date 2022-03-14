package com.nyx.springbootstudy.until;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;


/**
 * 微信小程序工具类
 */
public class WeChatUtil {

    public static String httpRequest(String requestUrl, String requestMethod, String output) {
        try {
            URL url = new URL(requestUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(requestMethod);
            if (null != output) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(output.getBytes(StandardCharsets.UTF_8));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            StringBuilder buffer = new StringBuilder();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            connection.disconnect();
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url  发送请求的 URL
     * @param json 请求参数，请求参数应该是 json 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String httpPost(String url, JSONObject json) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数

            out.print(json);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result = result.concat(line);
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    public static JSONObject getUserInfo(String encryptedData, String iv, String session_key) {
        // 被加密的数据
        byte[] dataByte = cn.hutool.core.codec.Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = cn.hutool.core.codec.Base64.decode(session_key);
        // 偏移量
        byte[] ivByte = cn.hutool.core.codec.Base64.decode(iv);

        try {
            // 如果密钥不足16位，那么就补足.

            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchProviderException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            }
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = null;
            try {
                parameters = AlgorithmParameters.getInstance("AES");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            try {
                parameters.init(new IvParameterSpec(ivByte));
            } catch (InvalidParameterSpecException e) {
                e.printStackTrace();
            }
            try {
                cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
            }
            byte[] resultByte = new byte[0];
            try {
                resultByte = cipher.doFinal(dataByte);
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            }
            if (null != resultByte && resultByte.length > 0) {
                String result = null;
                try {
                    result = new String(resultByte, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                System.out.println(result);
                return JSONUtil.parseObj(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
