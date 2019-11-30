package com.oss.alioss.controller;


import com.oss.alioss.entity.AliOssConfig;
import com.oss.alioss.sevice.AliOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("/v1")
public class FilesControl {
    @Autowired
    private AliOssService aliOssService;
    @Autowired
    private AliOssConfig config;


    @PostMapping(headers = "content-type=multipart/form-data", value = "/filesUpload")
    public void filesUpload(@RequestParam("files")
                                    MultipartFile[] files, HttpServletResponse response) {
        List<Map<String, String>> fileUrlList = new ArrayList<>();
        try {
            Long size = 0L;
            for (MultipartFile file : files) {
                size += file.getSize();
                String fileName = file.getOriginalFilename();
                if (size > 1024 * 1024 * 200) {
//                    OutDataUtil.writeFailJSON(response, "上传的文件大小不能大于200MB", null);
                    return;
                }
                String suffix = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
                if (!(suffix.equals("jpg") || suffix.equals("gif") || suffix.equals("jpeg") || suffix.equals("png")
                        || suffix.equals("bmp") || suffix.equals("zip") || suffix.equals("rar") || suffix.equals("doc")
                        || suffix.equals("docx") || suffix.equals("pdf") || suffix.equals("xls") || suffix.equals("xlsx"))) {
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

//    @PostMapping(headers = "content-type=multipart/form-data", value = "/filesUploadAdmin")
//    public void filesUploadAdmin(HttpServletRequest request, HttpServletResponse response) {
//        //转型为MultipartHttpServletRequest
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        //获取文件到map容器中
//        List<MultipartFile> fileMap = multipartRequest.getFiles("input-b3[]");
//        List<String> fileUrlList = new ArrayList<>();
//        try {
//            Long size = 0L;
//            for (MultipartFile file : fileMap) {
//                size += file.getSize();
//                String fileName = file.getOriginalFilename();
//                if (size > 1024 * 1024 * 200) {
//                    OutDataUtil.writeFailJSON(response, "上传的文件大小不能大于200MB", null);
//                    return;
//                }
//                String suffix = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
//                if (!(suffix.equals("jpg") || suffix.equals("gif") || suffix.equals("jpeg") || suffix.equals("png")
//                        || suffix.equals("bmp") || suffix.equals("zip") || suffix.equals("rar") || suffix.equals("doc")
//                        || suffix.equals("docx") || suffix.equals("pdf") || suffix.equals("xls") || suffix.equals("xlsx"))) {
//                    OutDataUtil.writeFailJSON(response, "请上传正确的格式", null);
//                    return;
//                }
//            }
//            for (MultipartFile file : fileMap) {
//                Map<String, String> mapFlie = new HashMap<>();
//                InputStream stream = file.getInputStream();
//                Long size1 = file.getSize();
//                String fileName = file.getOriginalFilename();
//                String fileNameOSS = UploadOss.uploadFile(fileName, stream, size1);
//                String fileUrls = UploadOss.GET_ALI_BUCK_URL + "/" + UploadOss.fileName + fileNameOSS;
//                mapFlie.put("fileName", fileName);
//                mapFlie.put("fileUrl", fileUrls);
//                fileUrlList.add(fileUrls);
//            }
//            OutDataUtil.writeSuccessJSON(response, "上传成功", fileUrlList);
//        } catch (
//                Exception e) {
//            OutDataUtil.writeFailJSON(response, "上传失败", null);
//        }
//    }
//
//    @PostMapping(headers = "content-type=multipart/form-data", value = "/filesUpload/admin")
//    public void filesUpload(HttpServletRequest request, HttpServletResponse response) {
//        //转型为MultipartHttpServletRequest
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        //获取文件到map容器中
//        List<MultipartFile> fileMap = multipartRequest.getFiles("file");
//        List<String> fileUrlList = new ArrayList<>();
//        try {
//            Long size = 0L;
//            for (MultipartFile file : fileMap) {
//                size += file.getSize();
//                String fileName = file.getOriginalFilename();
//                if (size > 1024 * 1024 * 200) {
//                    OutDataUtil.writeFailJSON(response, "上传的文件大小不能大于200MB", null);
//                    return;
//                }
//                String suffix = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
//                if (!(suffix.equals("jpg") || suffix.equals("gif") || suffix.equals("jpeg") || suffix.equals("png")
//                        || suffix.equals("bmp") || suffix.equals("zip") || suffix.equals("rar") || suffix.equals("doc")
//                        || suffix.equals("docx") || suffix.equals("pdf") || suffix.equals("xls") || suffix.equals("xlsx"))) {
//                    OutDataUtil.writeFailJSON(response, "请上传正确的格式", null);
//                    return;
//                }
//            }
//            for (MultipartFile file : fileMap) {
//                Map<String, String> mapFlie = new HashMap<>();
//                InputStream stream = file.getInputStream();
//                Long size1 = file.getSize();
//                String fileName = file.getOriginalFilename();
//                String suffix = fileName.substring(fileName.lastIndexOf("."));
//                String fileNameOSS = UploadOss.uploadFile(getRandomFileName()+suffix, stream, size1);
//                String fileUrls = UploadOss.GET_ALI_BUCK_URL + "/" + UploadOss.fileName + fileNameOSS;
//                mapFlie.put("fileName", fileName);
//                mapFlie.put("fileUrl", fileUrls);
//                fileUrlList.add(fileUrls);
//            }
//            OutDataUtil.writeSuccessJSON(response, "上传成功", fileUrlList);
//        } catch (
//                Exception e) {
//            OutDataUtil.writeFailJSON(response, "上传失败", null);
//        }
//    }


}