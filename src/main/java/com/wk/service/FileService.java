package com.wk.service;

import com.wk.dao.FileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    @Autowired(required = false)
    private FileDao fileDao;

    public void addChapter(String fileName){
        try {
            String chapterName = fileName.split("\\.")[0];
            String path = "./book/1614682367975/" + fileName;
            Integer bookId = 468;
            fileDao.addChapter(bookId, chapterName, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addKeywords(String keyword){
        Integer keywordId = Integer.parseInt(keyword.split(",")[0]);
        String word = keyword.split(",")[1];
        System.out.println(keywordId + word);
        try {
            if (null == fileDao.getKeywords(word))
                fileDao.addKeywords(keywordId, word);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSimw2f(String info){
        int keywordId = Integer.parseInt(info.split(",")[0]);
        int chapterId = Integer.parseInt(info.split(",")[2]);
        String value = info.split(",")[5];//值越大，相关性越大
        System.out.println(keywordId + " " + chapterId + " " + value);
        try {
            fileDao.addSimw2f(keywordId, chapterId, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSimw2w(String info){
        int keyword1Id = Integer.parseInt(info.split(",")[0]);
        int keyword2Id = Integer.parseInt(info.split(",")[3]);
        String value = info.split(",")[8];//值越小，相关性越大
        System.out.println(keyword1Id + " " + keyword2Id + " " + value);
        try {
            fileDao.addSimw2w(keyword1Id, keyword2Id, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getKeywordId(String searchWord){
        return fileDao.getKeyword(searchWord);
    }
}
