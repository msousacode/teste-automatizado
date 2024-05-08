package br.com.msousa.testeautomatizado.utils;

public class TempoUtil {

    public static void aguardar3Min() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void aguardar5Min() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
