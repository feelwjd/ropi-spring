package com.ropi.ropispring.DAO;

import com.ropi.ropispring.Model.Summary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SummaryDAO {
    List<Summary> listSummary();
    void setSummary(Summary summary); //추가
    void deleteSummary(Summary summary); //삭제
    void updateSummary(Summary summary); //수정
    Summary getSummary(@Param("symbol") String symbol, @Param("countrycode") String countrycode);
    int checkSummary(Summary summary);
    String dbCheck();
}
