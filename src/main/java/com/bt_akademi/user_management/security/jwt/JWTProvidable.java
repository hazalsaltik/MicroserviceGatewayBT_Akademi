package com.bt_akademi.user_management.security.jwt;

import com.bt_akademi.user_management.security.model.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;

public interface JWTProvidable
{

    String ERR_JWT_INVALID_KEY = "InvalidKeySpecException has been occured.";
    String ERR_JWT_ALGORITHM = "NoSuchAlgorithmException has been occured.";

    // JWT Temel Mantik seklindeki 3. asama Bearer
    String HEADER_STRING = "Authorization";
    String TOKEN_PREFIX = "Bearer";
    int TOKEN_START_DIGIT = 7;

    default  KeyFactory getKeyFactory() throws NoSuchAlgorithmException
    {
        return KeyFactory.getInstance("RSA");
    }

    /**
     *
     * @param request
     *      cozumlenip token uretilecek istek
     *
     * @return
     *      son kullanma tarihi gecmisse false
     *      aksi halde true
     *
     * Detay:
     * Uretilen token'dan kullanici detaylari alinabilir (Claims nesnesi)
     * (Claims nesnesi key-value seklinde bilgi icerir.)
     */
    boolean isValidToken(HttpServletRequest request);

    /**
     *
     * @param request
     *          cozumlenip token uretilecek istek
     *
     * @return
     *      kullanici ad, id ve rol bilgilerini iceren Authentication nesnesi
     *
     * Detay:
     *      Uretilen token'dan kullanici detaylari alinabilir. (key-value seklinde - Claims)
     *      Claims uzerinden kullanici ad, id ve roller bilgisi cekilebilir.
     *      Bu bilgilerle, UsernamePasswordAuthenticationToken nesnesi uretilebilir.
     */
    Authentication getAuthentication(HttpServletRequest request);


    /**
     @param authentication
        oturum acma isleminden sonra olusturulan UserPrinciple nesnesi

     @return
        Kimligi dogrulanmis kullanicilarin kimlik bilgilerini (credentials)
        ve rollerini iceren String
     */
    String generateToken(UserPrincipal authentication);
}
