package com.mqz.mars.base.utils;

import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;


/**
 * 版权所有  copyright© 蒙大拿
 *
 * @author mqz
 * @date
 * @about https://www.github.com/DemoMeng
 * @description
 */

public class OkHttpUtils {
    /**
     * post请求，form方式请求
     * @param url
     * @param parmas
     * @return
     * @throws IOException
     */
    public static String formPost(String url, Map<String,String> parmas) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : parmas.keySet()) {
            builder.add(key,parmas.get(key));
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    /**
     * get请求
     * @param url
     * @return
     * @throws IOException
     */
    public static String get(String url) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * post请求，json传参
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String post(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String post(String urlParams) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlParams)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * post返回Response
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static Response Post(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = (new Request.Builder()).url(url).post(body).build();
        return client.newCall(request).execute();
    }

    /**
     * 文件上传
     * @param url
     * @param params
     * @param file
     * @return
     * @throws IOException
     */
    public static String fileUpload(String url, Map<String,String> params , File file) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
        RequestBody filebody = MultipartBody.create(MEDIA_TYPE_PNG, file);
        MultipartBody.Builder multiBuilder = new MultipartBody.Builder();
        //这里是 封装上传图片参数
        multiBuilder.addFormDataPart("data", file.getName(), filebody);
        for (String key : params.keySet()) {
            multiBuilder.addFormDataPart(key,params.get(key));
        }
        //参数以添加header方式将参数封装，否则上传参数为空
        // 设置请求体
        multiBuilder.setType(MultipartBody.FORM);

        RequestBody body = multiBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
