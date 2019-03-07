## 编译后运行这个jar，需要传入6个变量：

     java -jar convertTTS.jar <Source FileName Path> <Gender> <Customer Voice Name> <Target FileName Path> <Key> <Endpoint>

     举例：

     java -jar ttsConvert.jar C:/test/test.txt M zyl041688 C:/test/output.mp3 ABC******* "https://eastasia.voice.speech.microsoft.com/cognitiveservices/v1?deploymentId=****************"