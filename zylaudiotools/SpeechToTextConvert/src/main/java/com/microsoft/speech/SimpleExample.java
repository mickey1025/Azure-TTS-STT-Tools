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

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;

public class SimpleExample {

  public static void main(String[] args) throws Exception {

    // TODO 改为你自己的 KEY
    String key = "****************";

    SpeechClientREST client = new SpeechClientREST(new Authentication(key));

    InputStream input = null;

    // TODO 改为存放音频文件的文件夹路径
    String path = "C:\\test\\result";

    File file = new File(path);

    File[] array = file.listFiles();

    String returnJson = null;

    String speechResult = null;

    for (File fileo : array) {

      if (fileo.isFile()) {

        input = new FileInputStream(Paths.get(fileo.getAbsolutePath()).toFile());

        returnJson =  client.process(input);

          System.out.println(fileo.getName() + "\t" + returnJson);

        /*  speechResult = new JsonParser().parse(returnJson).getAsJsonObject().get("DisplayText").getAsString();

          System.out.println(fileo.getName() + "\t" + speechResult);*/

      }
    }

  }
}

