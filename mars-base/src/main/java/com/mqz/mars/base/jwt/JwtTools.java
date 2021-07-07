package com.mqz.mars.base.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mqz
 * @description jwt工具
 * @since 2020/4/24
 */
@Component
public class JwtTools {


    @Data
    @AllArgsConstructor
    public static class Info{
        private String token;
        private Long userId;
        private List<Integer> roleIdList;
    }

    private static String secret;
    private static String tokenKey;
    private static String userIdKey;
    private static String roleIdListKey;

    // TODO 通用的配置移到配置中心
    @Value("${jwt.secret:Mars-Cloud}")
    public void setSecret(String secret){
        JwtTools.secret = secret;
    }
    @Value("${jwt.key.token:TOKEN}")
    public void setTokenKey(String tokenKey){
        JwtTools.tokenKey = tokenKey;
    }
    @Value("${jwt.key.userId:USER_ID}")
    public void setUserIdKey(String userIdKey){
        JwtTools.userIdKey = userIdKey;
    }
    @Value("${jwt.key.roleIdList:ROLE_ID_LIST}")
    public void setRoleIdListKey(String roleIdListKey){
        JwtTools.roleIdListKey = roleIdListKey;
    }


    /**
     * 生成jwt
     * @param token
     * @param userId
     * @param roleIdList
     * @return
     */
    public static String getJwt(String token, String userId, List<String> roleIdList){

        Map<String,Object> claims = new HashMap<String,Object>(){
            {
                put(tokenKey,token);
                put(userIdKey,userId);
                put(roleIdListKey,roleIdList);
            }
        };
        //签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //密钥签名
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder()
                            .setClaims(claims)
                            .setIssuedAt(new Date())
                            .signWith(signatureAlgorithm, signingKey);
        return builder.compact();
    }

    /**
     * 解析jwt
     * @param jwt
     * @return
     */
    public static Info toJwt(String jwt){
        Claims claims = Jwts.parser()
                        .setSigningKey(DatatypeConverter.parseBase64Binary(secret))
                        .parseClaimsJws(jwt).getBody();
        String token = (String) claims.get(tokenKey);
        String userId = (String) claims.get(userIdKey);
        List<Integer> roleIdList = (List<Integer>) claims.get(roleIdListKey);
        return new Info(token,Long.valueOf(userId),roleIdList);
    }


}
