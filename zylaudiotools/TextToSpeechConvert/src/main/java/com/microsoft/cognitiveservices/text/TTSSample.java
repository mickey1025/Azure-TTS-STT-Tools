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

import java.io.File;
import java.io.FileOutputStream;

public class TTSSample {

    public static void main(String[] args) {

       // String textToSynthesize = "This is a demo to call microsoft text to speech service in java.";
        //TODO Change to your test sentence
        String textToSynthesize = "测试语句";

        String outputFormat = AudioOutputFormat.Audio24khz96KbitrateMonoMp3;
        String deviceLanguage = "zh-CN";
        String genderName = Gender.Male;

        //TODO Change to your custom voice font name
        String voiceName = "voiceName";

        try{
        	byte[] audioBuffer = TTSService.Synthesize(textToSynthesize, outputFormat, deviceLanguage, genderName, voiceName);

        	//TODO Change to your own output path
        	String outputWave = "C:\\test\\output.mp3";
        	File outputAudio = new File(outputWave);
        	FileOutputStream fstream = new FileOutputStream(outputAudio);
            fstream.write(audioBuffer);
            fstream.flush();
            fstream.close();

            System.out.println("Convert Successfully!");

            System.exit(0);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
