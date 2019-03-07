package com.audio.cut;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CutAudio {

    public static void main(String[] args) {


        try {

            //TODO Change NO
            int offset = 1158;

            //TODO Change to your own File Path
            String filePath = "C:\\test\\P08-0001.wav";

            //TODO Change to your own ffmpeg.exe path
            String ffmpge = "C:\\test\\ffmpeg.exe";

            //TODO Change to your own output path
            String targetPath = "C:\\test\\000000";

            //TODO Change to your own output audio lenth
            double splitLen = 5;

            File sourceFile = new File(filePath);
            long totalLen = getTimeLen(sourceFile);
            System.out.println("Source File lenth is: " + totalLen);

           // List<String[]> cmds = new ArrayList<String[]>();


            double splits = totalLen / splitLen ;

            System.out.println("splits = " + splits);

            for (int i = 0; i <= splits; i++) {

                String[] cmd = {ffmpge, "-ss", i * splitLen + "", "-i", "concat:"+ filePath, "-t", splitLen + "", "-acodec", "pcm_s16le", "-ac", "1", targetPath + (i + offset) + ".wav"};

                System.out.println("ffplay -autoexit -loop 3 0000000" + (i + offset) + ".wav");

                Runtime.getRuntime().exec(cmd);

            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static long getTimeLen(File file){
        long tlen = 0;
        if(file!=null && file.exists()){
            Encoder encoder = new Encoder();
            try {
                MultimediaInfo m = encoder.getInfo(file);
                long ls = m.getDuration();
                tlen = ls/1000;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tlen;
    }

}
