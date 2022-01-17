package com.ropi.ropispring.DAO;

import com.ropi.ropispring.Model.Summary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SummaryDAO {
    List<Summary> listSummary();
    void setSummary(Summary summary); //추가
    void delete(Summary summary); //삭제
    void update(Summary summary); //수정

}
