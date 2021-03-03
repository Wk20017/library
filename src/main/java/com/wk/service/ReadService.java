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
}
