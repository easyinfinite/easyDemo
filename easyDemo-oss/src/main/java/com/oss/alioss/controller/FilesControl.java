package com.oss.alioss.controller;


import com.oss.alioss.entity.AliOssConfig;
import com.oss.alioss.sevice.AliOssService;
import com.oss.util.Constant;
import com.oss.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param
 * @author chenkuidou
 * @description 文件上传
 * @date 2018/12/3 15:47
 * @return
 **/
@RestController
@RequestMapping("/aliyun")
public class FilesControl {
    @Autowired
    private AliOssService aliOssService;
    @Autowired
    private AliOssConfig config;


    @PostMapping(headers = "content-type=multipart/form-data", value = "/filesUpload")
    public void filesUpload(@RequestParam("files")
                                    MultipartFile[] files) {
        List<Map<String, String>> fileUrlList = new ArrayList<>();
        try {
            Long size = 0L;
            for (MultipartFile file : files) {
                size += file.getSize();
                String fileName = file.getOriginalFilename();
                if (size > Constant.limitSise.MIDSIZE) {
//                    OutDataUtil.writeFailJSON(response, "上传的文件大小不能大于200MB", null);
                    return;
                }
                String suffix = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
                if (FileUtil.isValid(suffix)) {
//                    OutDataUtil.writeFailJSON(response, "请上传正确的格式", null);
                    return;
                }
            }
            for (MultipartFile file : files) {
                Map<String, String> mapFlie = new HashMap<>();
                InputStream stream = file.getInputStream();
                Long size1 = file.getSize();
                //随机生成文件名
                //String fileName = FileUtil.getRandomFileName();
                //直接原名
                String fileName = file.getOriginalFilename();
                String fileNameOSS = aliOssService.uploadFile(fileName, stream, size1);
                String fileUrls = config.getBackUrl() + "/" + config.getFileName() + fileNameOSS;
                mapFlie.put("fileName", fileName);
                mapFlie.put("fileUrl", fileUrls);
                fileUrlList.add(mapFlie);
            }
//            OutDataUtil.writeSuccessJSON(response, "上传成功", fileUrlList);
        } catch (
                Exception e) {
//            OutDataUtil.writeFailJSON(response, "上传失败", null);
        }
    }

}