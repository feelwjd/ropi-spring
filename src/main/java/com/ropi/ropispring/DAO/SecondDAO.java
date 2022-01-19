package com.ropi.ropispring.DAO;

import com.ropi.ropispring.Model.Second;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SecondDAO {

    List<Second> listSummary2();
    void setSummary2(Second second); //추가
    void deleteSummary2(Second second); //삭제
    void updateSummary2(Second second); //수정
    Second getSummary2(String symbol);

}
