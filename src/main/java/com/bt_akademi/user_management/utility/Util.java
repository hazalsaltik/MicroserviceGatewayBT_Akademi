package com.bt_akademi.user_management.utility;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Util
{
    private Util() {}

    public static void writeToLogFile(Class<?> clazz, Level level, String message)
    {
        Logger logger = Logger.getLogger(clazz.getPackage().getName());

        try
        {
            Handler handler = new FileHandler("C:/log/BT Akademi/microservices.log");

            logger.addHandler(handler);

            logger.log(level, message);
        }
        catch (IOException e)
        {
            System.err.println("Message: " + createGeneralException(e));
        }
        catch (SecurityException e)
        {
            System.err.println("Message: " + createGeneralException(e));
        }
        catch (IllegalArgumentException e)
        {
            System.err.println("Message: " + createGeneralException(e));
        }
    }

    public static String createGeneralException(Exception e)
    {
        return e.getClass().getSimpleName()
                + " is occured. Error message: " + e.getMessage();
    }

    public static void showGeneralExceptionInfo(Exception e)
    {
        System.err.println(e.getClass().getSimpleName()
                + " is occured. Exception message: " + e.getMessage());
    }
}
