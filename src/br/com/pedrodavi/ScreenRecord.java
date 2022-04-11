package br.com.pedrodavi;

import com.wet.wired.jsr.converter.RecordingConverter;
import com.wet.wired.jsr.recorder.ScreenRecorderListener;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ScreenRecord implements ScreenRecorderListener {

    @Override
    public void frameRecorded(boolean b) throws IOException {

    }

    @Override
    public void recordingStopped() {

    }

    public boolean record() throws IOException {

        JFrame parentFrame = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        File file = null;

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            file = new File(fileToSave.getAbsolutePath() + ".cap");
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
        }

        OutputStream out = new FileOutputStream(file);

        MyScreenRecorder screenRecorder = new MyScreenRecorder(out, this);

        int option = JOptionPane.showConfirmDialog(null, "Iniciar gravação / Cancelar", "Please select", JOptionPane.YES_NO_OPTION);

        if (option == 0) {

            JOptionPane.showMessageDialog(null, "Gravação iniciada!");

            while (option == 0) {
                screenRecorder.startRecording();
                option = JOptionPane.showConfirmDialog(null, "Continuar gravando?", "Please select", JOptionPane.YES_NO_OPTION);
            }

//            try {
//                Thread.sleep(Integer.parseInt(tempo) * 1000L);
//            } catch (Exception e) {
//            }

//            System.out.println("PARANDO A GRAVACAO");
            screenRecorder.stopRecording();

//            System.out.println("CONVERTENDO VIDEO PARA MOVIE");
            RecordingConverter.main(new String[] { file.getAbsolutePath() });

//            System.out.println("VIDEO CONVERTIDO");

            out.close();

            JOptionPane.showMessageDialog(null, "Gravação concluída!");

            return true;
//            System.out.println("FIM");

        } else if (option == 1) {
            screenRecorder.stopRecording();
            out.close();
            JOptionPane.showMessageDialog(null, "Gravação cancelada!");
            return true;
        }

//        screenRecorder.startRecording();

        return false;



    }

}
