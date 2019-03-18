## 创建并使用微软[Customer Voice](https://eastasia.cris.ai/Home/CustomSpeech)的相关工具


:star: [CutAudioByFfmpeg](https://github.com/mickey1025/Azure-TTS-STT-Tools/tree/master/zylaudiotools/CutAudioByFfmpeg): 用来将一段较长的音频文件批量切割为定长的短音频

:star: [OneTimeCutAndSTT](https://github.com/mickey1025/Azure-TTS-STT-Tools/tree/master/zylaudiotools/OneTimeCutAndSTT): CutAudioByFfmpeg 和 SpeechToTextConvert 的合并升级版，一键执行，实现批量切割音频文件，生成音频文件对应的文本，最终输出到本地

:star: [SpeechToTextConvert](https://github.com/mickey1025/Azure-TTS-STT-Tools/tree/master/zylaudiotools/SpeechToTextConvert)：调用微软[Speech To Text](https://azure.microsoft.com/en-us/services/cognitive-services/speech-to-text/)服务，将语音转换成文字

:star: [TextToSpeechConvert](https://github.com/mickey1025/Azure-TTS-STT-Tools/tree/master/zylaudiotools/TextToSpeechConvert)：调用创建好的个性化 Customer Voice TTS （文字转语音）服务

:star: [TextToSpeechConvertJar](https://github.com/mickey1025/Azure-TTS-STT-Tools/tree/master/zylaudiotools/TextToSpeechConvertJar): TextToSpeechConvert 的打包版，通过传递参数直接运行jar，从而生成本地音频 
