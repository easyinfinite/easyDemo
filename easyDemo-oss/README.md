# 文件上传oss
### 阿里云OSS

  **1.引入架包**


    <!-- https://mvnrepository.com/artifact/com.aliyun.oss/aliyun-sdk-oss -->
       <dependency>
           <groupId>com.aliyun.oss</groupId>
           <artifactId>aliyun-sdk-oss</artifactId>
           <version>3.4.0</version>
       </dependency>
       
 **2.关键配置**  
 
    aliyun:
      info:
        accessKeyId: //产品accessKeyId
        accessKeySecret: //产品accessKeySecret
      oss:
        endpoint: //节点域名
        bucketName: //快照名称
        backUrl: //返回文件地址前缀
        fileName: //文件夹名称
       

### 七牛云OSS

**1.引入架包**

    <dependency>
        <groupId>com.qiniu</groupId>
        <artifactId>qiniu-java-sdk</artifactId>
        <version>[7.2.0, 7.2.99]</version>
    </dependency>

**2.关键配置**  
 
    qiniu:
      info:
        accessKeyId: //产品accessKeyId
        accessKeySecret: //产品accessKeySecret
        bucketName: //快照名称
        path: //返回文件地址前缀
    
### 本地上传 
 
**1.关键代码**
    
    /**
     * @description: 上传本地
     * @author: chenyunxuan
     * @updateTime: 2019-12-20 16:17
     */
    @PostMapping(value = "/local", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Dict local(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Dict.create().set("code", 400).set("msg", "文件内容为空");
        }
        String fileName = file.getOriginalFilename();
        String rawFileName = StrUtil.subBefore(fileName, ".", true);
        String fileType = StrUtil.subAfter(fileName, ".", true);
        Long fileNameNew = DateUtil.current(false);
        String localFilePath = StrUtil.appendIfMissing("/win/images", "/") + fileNameNew + "." + fileType;
        try {
            file.transferTo(new File(localFilePath));
        } catch (IOException e) {
            return Dict.create().set("code", 500).set("msg", "文件上传失败");
        }
        return Dict.create().set("code", 200).set("msg", "上传成功").set("data", Dict.create().set("filePath", "xxxx" + fileNameNew + "." + fileType));
