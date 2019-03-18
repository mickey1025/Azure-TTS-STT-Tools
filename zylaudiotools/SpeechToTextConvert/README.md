## 需要赋值的变量：

:star: [SimpleExample.java](https://github.com/mickey1025/Azure-TTS-STT-Tools/blob/master/zylaudiotools/SpeechToTextConvert/src/main/java/com/microsoft/speech/SimpleExample.java)

:small_blue_diamond: [key](https://github.com/mickey1025/Azure-TTS-STT-Tools/blob/9294d238904caf12f6efcabee8c1f8d21e779328/zylaudiotools/SpeechToTextConvert/src/main/java/com/microsoft/speech/SimpleExample.java#L35): 在Azure平台上创建speech服务后生成的key

:small_blue_diamond: [path](https://github.com/mickey1025/Azure-TTS-STT-Tools/blob/9294d238904caf12f6efcabee8c1f8d21e779328/zylaudiotools/SpeechToTextConvert/src/main/java/com/microsoft/speech/SimpleExample.java#L42): 要批量生成对应文本的文件夹路径


:star: [Authentication.java](https://github.com/mickey1025/Azure-TTS-STT-Tools/blob/master/zylaudiotools/SpeechToTextConvert/src/main/java/com/microsoft/speech/Authentication.java)

:small_orange_diamond: [FETCH_TOKEN_URI](https://github.com/mickey1025/Azure-TTS-STT-Tools/blob/9294d238904caf12f6efcabee8c1f8d21e779328/zylaudiotools/SpeechToTextConvert/src/main/java/com/microsoft/speech/Authentication.java#L33)：Azure用来生成验证token的URL，根据服务所在的区域选择不同的URL：
  
  ```text
West US	                    https://westus.api.cognitive.microsoft.com/sts/v1.0/issueToken
West US2	            https://westus2.api.cognitive.microsoft.com/sts/v1.0/issueToken
East US	                    https://eastus.api.cognitive.microsoft.com/sts/v1.0/issueToken
East US2	            https://eastus2.api.cognitive.microsoft.com/sts/v1.0/issueToken
East Asia	            https://eastasia.api.cognitive.microsoft.com/sts/v1.0/issueToken
South East Asia	            https://southeastasia.api.cognitive.microsoft.com/sts/v1.0/issueToken
North Europe	            https://northeurope.api.cognitive.microsoft.com/sts/v1.0/issueToken
West Europe	            https://westeurope.api.cognitive.microsoft.com/sts/v1.0/issueToken
```
  
