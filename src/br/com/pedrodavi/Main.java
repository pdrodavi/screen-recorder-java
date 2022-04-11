package br.com.pedrodavi;

public class Main {

    public static void main(String[] args) {

        try {
            ScreenRecord screenRecorder = new ScreenRecord();
            boolean record = screenRecorder.record();
            if (record) {
                System.exit(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
