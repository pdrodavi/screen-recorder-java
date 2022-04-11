package br.com.pedrodavi;

import com.wet.wired.jsr.recorder.DesktopScreenRecorder;
import com.wet.wired.jsr.recorder.ScreenRecorderListener;

import java.awt.*;
import java.io.OutputStream;

public class MyScreenRecorder extends DesktopScreenRecorder {

    public MyScreenRecorder(OutputStream oStream, ScreenRecorderListener listener) {
        super(oStream, listener);
    }

    public Rectangle initialiseScreenCapture() {

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
//        System.out.println("A resolução da sua máquina é: " +d.width + " x " +d.height);

        super.initialiseScreenCapture();
        Rectangle rec = new Rectangle(0, 0, d.width, d.height);
        return rec;
    }

}
