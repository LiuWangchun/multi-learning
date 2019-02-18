package com.mystudy.multilearning;

import com.mystudy.multilearning.jwt.payload.UserInfo;
import com.mystudy.multilearning.jwt.util.JwtUtils;
import com.mystudy.multilearning.jwt.util.RsaUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @ClassName JwtTest
 * @Description TODO
 * @Author MrLiu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {
    private static final String pubKeyPath = "C:\\mystudy\\rsa\\rsa.pub";

    private static final String priKeyPath = "C:\\mystudy\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    //@Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU1MDQ3MTE3NX0.Lm1YBO9lE687xl7USaUMKZe7Zt7a2hggLiBJCJji-mPTf0wV8hSdMGNDTAFHCHFAWpeXcDk1VcybZWDVC1zTshoqoOhUNAwscBbb0nSePENsF2trVOMsoltcqtAZY2b8xIbArec7ABrlJYw8Oc0_9yDCIlvlFS1NVbZxYe9-MDU";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}
