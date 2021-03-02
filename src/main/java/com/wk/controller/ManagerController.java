package com.wk.controller;

import com.wk.model.Msg;
import com.wk.service.ManagerService;
import com.wk.utils.RemoveDir;
import com.wk.utils.UploadFileUtil;
import com.wk.vo.Book;
import com.wk.vo.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Controller
public class ManagerController {

    private static final String PATH = "./file";


    @Resource
    private ManagerService managerService;

    @RequestMapping("manager/login")//管理员登录
    @ResponseBody
    public Msg login(@RequestBody Manager manager){
        return managerService.login(manager);
    }

    @RequestMapping("manager/addBook")//添加图书
    @ResponseBody
    public Msg addBook(@RequestParam("bookname") String bookname, @RequestParam("isbn") String isbn, @RequestParam("author") String author, @RequestParam("pressname") String pressname, @RequestParam("picture") MultipartFile picture, @RequestParam("file") MultipartFile file) throws IOException {
        Book book = new Book();
        book.setBookname(bookname);
        book.setIsbn(isbn);
        book.setAuthor(author);
        book.setPressname(pressname);

        String picture_name = picture.getOriginalFilename();
        String file_name = file.getOriginalFilename();


        String currentTime = String.valueOf(System.currentTimeMillis());
        String savePictureName =  "./picture/" + currentTime + "/" + picture_name ;
        String saveFileName =  "./book/" + currentTime + "/" + file_name ;

        UploadFileUtil.uploadFile(picture, PATH + "/picture/" + currentTime + "/").replace("./file", "");
        UploadFileUtil.uploadFile(file, PATH + "/book/" + currentTime + "/").replace("./file", "");


        book.setPicture(savePictureName);
        book.setFile(saveFileName);

        System.out.println(book.toString());
        return managerService.addBook(book);
    }

    @RequestMapping("manager/deleteBook")//删除图书
    @ResponseBody
    public Msg deleteBook(@RequestParam("bookId") Integer bookId){
        String file = managerService.getFilePath(bookId);
        if (!"null".equals(file)){
            String path = file.split("/")[2];
            String pic_path = "./file/picture/" + path;
            String book_path = "./file/book/" + path;
            System.out.println(pic_path + book_path);
            try {
                RemoveDir.remove(new File(pic_path));
                RemoveDir.remove(new File(book_path));
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return managerService.deleteBook(bookId);
    }
}
