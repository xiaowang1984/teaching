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
    public static int maxday(int year,int month){
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            return 31;
        }else if(month==4||month==6||month==9||month==11){
            return 30;
        }else{
            return isLeap(year);
        }
    }
    public static int isLeap(int year){
        if((year%4==0&&year%100!=0)||year%400==0){
            return 29;
        }else{
            return 28;
        }
    }
}
