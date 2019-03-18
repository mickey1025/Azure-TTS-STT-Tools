## 需要赋值的变量：

:star: [SimpleExample.java](https://github.com/mickey1025/Azure-TTS-STT-Tools/blob/master/zylaudiotools/OneTimeCutAndSTT/src/main/java/com/microsoft/speech/SimpleExample.java)

:small_blue_diamond: [offset](https://github.com/mickey1025/Azure-TTS-STT-Tools/blob/28f9aa6390e29bc5b6ec6d0c6aeabb50963c3b7e/zylaudiotools/OneTimeCutAndSTT/src/main/java/com/microsoft/speech/SimpleExample.java#L42): 即将生成的第一个文件名，不包含文件名前缀000000

:small_blue_diamond: [filePath](https://github.com/mickey1025/Azure-TTS-STT-Tools/blob/28f9aa6390e29bc5b6ec6d0c6aeabb50963c3b7e/zylaudiotools/OneTimeCutAndSTT/src/main/java/com/microsoft/speech/SimpleExample.java#L45): 要切割并生成相应文本的文件路径

:small_blue_diamond: [ffmpge](https://github.com/mickey1025/Azure-TTS-STT-Tools/blob/28f9aa6390e29bc5b6ec6d0c6aeabb50963c3b7e/zylaudiotools/OneTimeCutAndSTT/src/main/java/com/microsoft/speech/SimpleExample.java#L48): 下载解压的ffmpge本地路径

:small_blue_diamond: [targetPath](https://github.com/mickey1025/Azure-TTS-STT-Tools/blob/28f9aa6390e29bc5b6ec6d0c6aeabb50963c3b7e/zylaudiotools/OneTimeCutAndSTT/src/main/java/com/microsoft/speech/SimpleExample.java#L51): 切割后的文件存放目录路径

:small_blue_diamond: [splitLen](https://github.com/mickey1025/Azure-TTS-STT-Tools/blob/28f9aa6390e29bc5b6ec6d0c6aeabb50963c3b7e/zylaudiotools/OneTimeCutAndSTT/src/main/java/com/microsoft/speech/SimpleExample.java#L54): 切割后每段音频文件的长度，单位为秒

:small_blue_diamond: [key](https://github.com/mickey1025/Azure-TTS-STT-Tools/blob/28f9aa6390e29bc5b6ec6d0c6aeabb50963c3b7e/zylaudiotools/OneTimeCutAndSTT/src/main/java/com/microsoft/speech/SimpleExample.java#L58): 在Azure平台上创建speech服务后生成的key

:star: [Authentication.java](https://github.com/mickey1025/Azure-TTS-STT-Tools/blob/master/zylaudiotools/OneTimeCutAndSTT/src/main/java/com/microsoft/speech/Authentication.java)

:small_orange_diamond: [FETCH_TOKEN_URI](https://github.com/mickey1025/Azure-TTS-STT-Tools/blob/28f9aa6390e29bc5b6ec6d0c6aeabb50963c3b7e/zylaudiotools/OneTimeCutAndSTT/src/main/java/com/microsoft/speech/Authentication.java#L33)：Azure用来生成验证token的URL，根据服务所在的区域选择不同的URL：
  
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
  
