package com.wk.controller;

import com.wk.dao.FileDao;
import com.wk.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileController {
    @Resource
    private FileService fileService;

    @RequestMapping("file/addChapter")//添加章节
    @ResponseBody
    public void addChapter(){
        File file = new File("D:\\MyPrograms\\Java\\library\\src\\main\\resources\\static\\chapter.txt");
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = "";
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                list.add(s);
            }
            for (String item : list) {
                fileService.addChapter(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("file/addKeywords")//添加关键词
    @ResponseBody
    public void addKeywords(){
        File file = new File("D:\\MyPrograms\\Java\\library\\src\\main\\resources\\static\\word2DocText.txt");
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = "";
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                list.add(s);
            }
            for (int i=0;i<list.size();i++) {
                String item = list.get(i);
                if (i == 0)
                    fileService.addKeywords(item);
                else {
                    if (!list.get(i).split(",")[0].equals(list.get(i - 1).split(",")[0]) && null == fileService.getKeywordId(item)){
                        fileService.addKeywords(item);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("file/addSimw2f")//添加关键词对应文件信息
    @ResponseBody
    public void addSimw2f(){
        File file = new File("D:\\MyPrograms\\Java\\library\\src\\main\\resources\\static\\word2DocData.txt");
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = "";
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                list.add(s);
            }
            for (String item : list) {
                fileService.addSimw2f(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("file/addSimw2w")//添加关键词之间信息
    @ResponseBody
    public void addSimw2w(){
        File file = new File("D:\\MyPrograms\\Java\\library\\src\\main\\resources\\static\\word2wordData.txt");
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = "";
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                list.add(s);
            }
            for (String item : list) {
                fileService.addSimw2w(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("file/addText")//添加关键词对应文本
    @ResponseBody
    public void addText(){
        File file = new File("D:\\MyPrograms\\Java\\library\\src\\main\\resources\\static\\word2DocText.txt");
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = "";
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                list.add(s);
            }
            for (String item : list) {
                fileService.addText(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
