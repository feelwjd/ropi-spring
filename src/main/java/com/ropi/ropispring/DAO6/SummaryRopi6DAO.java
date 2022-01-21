package com.ropi.ropispring.DAO6;

import com.ropi.ropispring.Model.Summary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SummaryRopi6DAO {
    List<Summary> listSummary();
    void setSummary(Summary summary); //추가
    void deleteSummary(Summary summary); //삭제
    void updateSummary(Summary summary); //수정
    Summary getSummary(String symbol, String sectorcode);
    int checkSummary(Summary summary);
    String dbCheck();
}
