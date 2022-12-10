package com.bt_akademi.user_management.channel.utility;

import com.bt_akademi.user_management.utility.Util;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

// ****17 -> ProductService
public final class RetrofitUtil
{
    // burası request'i çalıştırıp response üzerinden body üretmek için
    // Callable'lar üzerinden Call<?> döndüren metotlar buraya paslanır
    // ve response'un body'si üretilir.
    public static <T> T callGenericBlock(Call<T> request)
    {
        try
        {
            Response<T> response = request.execute();

            if(!response.isSuccessful())
            {
                String message = "Unsuccessful response. Error reason: " + response.errorBody().string();
                Util.writeToLogFile(RetrofitUtil.class, Level.INFO, message);
            }

            return response.body(); // response üretilip body'si getirilir
        }
        catch (IOException e)
        {
            Util.showGeneralExceptionInfo(e);

            return null;
        }
    }
}
