package com.wk.service;

import com.wk.dao.ReadDao;
import com.wk.vo.Chapters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadService {
    @Autowired(required = false)
    private ReadDao readDao;

    public List<Chapters> getAllChapters(int bookId){
        List<Chapters> result = new ArrayList<>();
        try {
            result = readDao.getAllChapters(bookId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public Chapters getCurrentChapter(int bookId, int userId){
        Chapters result = new Chapters();
        try {
            Integer lastLocation = readDao.getLastLocation(bookId, userId);
//            if (null != readDao.getLastLocation(bookId, userId)){
            if (null != lastLocation){
                //没有记录直接从第一章开始
                result = readDao.getChapterByChapterId(0);
            } else {
                result = readDao.getChapterByChapterId(lastLocation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Chapters getChapterByChapterId(int chapterId){
        Chapters result = new Chapters();
        try {
            result = readDao.getChapterByChapterId(chapterId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
