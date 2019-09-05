package cn.lqcnb.mall.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/9/3 9:06
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */
public class UploadLocalUtil {

    public static String addImg(MultipartFile file){
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize()/1024/1024;
        System.out.println(fileName + "-->" + size+"Mb");

        String path = "E:/Study/Junior/JavaEE/idea_Program/mall/src/main/resources/static/common/img" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "/common/img/"+fileName;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return e.getMessage();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
