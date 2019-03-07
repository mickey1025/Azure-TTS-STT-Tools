//
// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license.
//
// Microsoft Cognitive Services (formerly Project Oxford): https://www.microsoft.com/cognitive-services
//
// Microsoft Cognitive Services (formerly Project Oxford) GitHub:
// https://github.com/Microsoft/Cognitive-Speech-TTS
//
// Copyright (c) Microsoft Corporation
// All rights reserved.
//
// MIT License:
// Permission is hereby granted, free of charge, to any person obtaining
// a copy of this software and associated documentation files (the
// "Software"), to deal in the Software without restriction, including
// without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to
// permit persons to whom the Software is furnished to do so, subject to
// the following conditions:
//
// The above copyright notice and this permission notice shall be
// included in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED ""AS IS"", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
// LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
// OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
// WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//

package com.microsoft.cognitiveservices.text;

import java.io.*;

public class TTSSample {

    public static void main(String[] args) {

       if (args == null || args.length != 6 ){

           System.out.println("Please input right parameters: Input_File_path Gender Custom_voice_Name Output_mp3_path Key");
           System.exit(-1);
       }

        String textToSynthesize = "无效文档";

        File file = new File(args[0]);
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                sb.append(st).append("\n");
            }
            textToSynthesize = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String outputFormat = AudioOutputFormat.Audio24khz48kbitrateMonoMp3;
        String deviceLanguage = "zh-CN";

        String genderName = Gender.Male;
        if(args[1].equalsIgnoreCase("F")){
            genderName = Gender.Female;
        }else if(args[1].equalsIgnoreCase("M")){
            genderName = Gender.Male;
        }

        String voiceName = args[2];

        try{
            // args[1]: Output MP3 path
            String outputWave = args[3];
        	File outputAudio = new File(outputWave);
        	FileOutputStream fstream = new FileOutputStream(outputAudio);

        	byte[] audioBuffer = TTSService.Synthesize(textToSynthesize, outputFormat, deviceLanguage, genderName, voiceName, args[4], args[5]);

            fstream.write(audioBuffer);
            fstream.flush();
            fstream.close();
            System.out.println("Successfully convert Text to MP3!");
            System.exit(0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
