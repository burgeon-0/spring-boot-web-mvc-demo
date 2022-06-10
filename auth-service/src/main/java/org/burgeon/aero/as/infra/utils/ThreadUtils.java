package org.burgeon.aero.as.infra.utils;

/**
 * @author Sam Lu
 * @date 2021/11/27
 */
public class ThreadUtils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
