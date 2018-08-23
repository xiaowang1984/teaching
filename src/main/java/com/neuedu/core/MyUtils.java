package com.neuedu.core;

import org.apache.commons.io.FilenameUtils;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

public class MyUtils {
    public static String fileUpload(MultipartFile multipartFile) throws Exception {
        String result="";
        ClassPathResource resource=new ClassPathResource("fdfs_client.conf");
        ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
        TrackerClient trackerClient=new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient1 storageClient=new StorageClient1(trackerServer, null);
        result= storageClient.upload_file1(multipartFile.getBytes(),FilenameUtils.getExtension(multipartFile.getOriginalFilename()) , null);
        return result;
    }
}
