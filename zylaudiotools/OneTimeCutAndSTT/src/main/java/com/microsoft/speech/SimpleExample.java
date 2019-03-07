/*
Copyright (c) Microsoft Corporation
All rights reserved. 
MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy of this 
software and associated documentation files (the "Software"), to deal in the Software 
without restriction, including without limitation the rights to use, copy, modify, merge, 
publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons 
to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Software.
THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.microsoft.speech;

import com.google.gson.JsonParser;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SimpleExample {

  public static void main(String[] args) throws Exception {

    try {

      //TODO Change NO
      int offset = 1171;

      //TODO Change to your own File Path
      String filePath = "C:\\test\\001.mp3";

      //TODO Change to your own ffmpeg.exe path
      String ffmpge = "C:\\test\\ffmpeg.exe";

      //TODO Change to your own output path
      String targetPath = "C:\\test\\result\\";

      //TODO Change to your own output audio lenth
      double splitLen = 4;


      // TODO 改为你自己的 KEY
      String key = "*****************";

      SpeechClientREST client = new SpeechClientREST(new Authentication(key));

      File uploadFile = null;

      InputStream input = null;

      String returnJson = null;

      String speechResult = null;

      File sourceFile = new File(filePath);
      long totalLen = getTimeLen(sourceFile);
      System.out.println("Source File lenth is: " + totalLen);

      double splits = totalLen / splitLen ;

      System.out.println("splits = " + splits);

      List<String> filePaths = new ArrayList<>();

      StringBuilder sb = new StringBuilder();

      for (int i = 0; i <= splits; i++) {

        String[] cmd = {ffmpge, "-ss", i * splitLen + "", "-i", "concat:"+ filePath, "-t", splitLen + "", "-acodec", "pcm_s16le", "-ac", "1", targetPath + "0000000" + (i + offset) + ".wav"};

        Runtime.getRuntime().exec(cmd);

        System.out.println("ffplay -autoexit -loop 3 0000000" + (i + offset) + ".wav");

        filePaths.add(targetPath + "0000000" + (i + offset) + ".wav");

      }

      Thread.sleep(5000);

      for (String fPath : filePaths ) {

        uploadFile = new File(fPath);

        input = new FileInputStream(Paths.get(uploadFile.getAbsolutePath()).toFile());

        returnJson =  client.process(input);

        speechResult = new JsonParser().parse(returnJson).getAsJsonObject().get("DisplayText").getAsString();

        sb.append(uploadFile.getName() + "\t" + speechResult + "\n");

      }

      FileUtils.writeStringToFile(new File(targetPath + "001.txt"), sb.toString(), Charset.forName("UTF-8"));

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

