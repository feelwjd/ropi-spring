package com.ropi.ropispring.DAO;

import com.ropi.ropispring.Model.Summary;

import java.util.List;

public interface SummaryDAO {
    List<Summary> listSummary();
    void insert(Summary summary); //추가
    void delete(Summary summary); //삭제
    void update(Summary summary); //수정

}
