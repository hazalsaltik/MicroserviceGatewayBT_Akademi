package com.bt_akademi.user_management.channel.utility;

import com.bt_akademi.user_management.channel.repository.ProductCallable;
import com.bt_akademi.user_management.channel.repository.TransactionCallable;
import com.google.gson.Gson;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

// ****24
@Configuration
public class RetrofitConfiguration
{
    // 1- varsayilan bir OkHttpClient.Builder
    // 2- Builder uzerinden OkHttpClient 
    // 3- RetrofitBuilder 

    @Value("${retrofit.timeout}")
    private Long TIMEOUT_IN_SECS;

    // ******e
    @Bean
    public TransactionCallable createTransactionServiceRequest(Retrofit.Builder secureKeyBuilder,
                                                                      @Value("${transaction.service.url}") String baseUrl)
    {
        return secureKeyBuilder.baseUrl(baseUrl).build().create(TransactionCallable.class);
    }

    // ******d secureKeyBuilder üzerinden
    @Bean
    public ProductCallable createProductServiceRequest(Retrofit.Builder secureKeyBuilder,
                                                       @Value("${product.service.url}") String baseUrl)
    {
        return secureKeyBuilder.baseUrl(baseUrl).build().create(ProductCallable.class);
    }

    // ******c SecureKeyClient'i kullanarak -> Retrofit.Builder
    @Bean
    public Retrofit.Builder secureKeyBuilder(OkHttpClient secureKeyClient, Gson gson)
    {
        return new Retrofit.Builder()
                .client(secureKeyClient)
                .addConverterFactory(GsonConverterFactory.create(gson));
    }

    // ******b (Builder uzerinden guvenli bir OkHttpClient)
    @Bean
    public OkHttpClient secureKeyClient(@Value("${service.security.secure-key-username}")String secureKeyUsername,
                                        @Value("${service.security.secure-key-password}")String secureKeyPassword)
    {
        return createDefaultClientBuilder().addInterceptor(interceptor -> interceptor.proceed(interceptor.request().newBuilder()
                                           .header("Authorization", Credentials.basic(secureKeyUsername, secureKeyPassword))
                                           .build())).build();

    }

    // ******a (varsayilan bir OkHttpClient.Builder)
    private OkHttpClient.Builder createDefaultClientBuilder()
    {
        //servisle kurulacak "handshake" zaman asimi
        return new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_IN_SECS, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_IN_SECS, TimeUnit.SECONDS) // TCP soket ve I/O operasyonlari icin varsayilan 10 saniye
                .writeTimeout(TIMEOUT_IN_SECS, TimeUnit.SECONDS);  // istegi sunucuya yollarken, 2 veri paketi arasindaki iletisimsizlik süresi

    }
}
