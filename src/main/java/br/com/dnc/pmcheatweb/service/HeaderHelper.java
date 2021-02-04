package br.com.dnc.pmcheatweb.service;

import java.util.Map;

public class HeaderHelper {

    public static void buildHeaders(Map<String, String> headers, UserInfo infoKeeper){

        headers.put("access-token", infoKeeper.getToken());
//        headers.set("token-type", "Bearer");
        headers.put("uid", infoKeeper.getUid());
        headers.put("uuid", infoKeeper.getUuid());
        headers.put("client", infoKeeper.getClient());
        headers.put("expiry", infoKeeper.getExpiry());
        headers.put("origin", "https://app.pontomaisweb.com.br");
        headers.put("content-type", "application/json;charset=UTF-8");

        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36");
        headers.put("Accept", "application/json");
        headers.put("Cache-Control","no-cache");
        headers.put("Accept-Encoding","gzip, deflate, br");
    }

}
