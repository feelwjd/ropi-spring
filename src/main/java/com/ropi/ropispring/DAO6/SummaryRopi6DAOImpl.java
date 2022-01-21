package com.ropi.ropispring.DAO6;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ropi.ropispring.Model.Summary;

@Repository
public class SummaryRopi6DAOImpl implements SummaryRopi6DAO {
    @Autowired
    SqlSession sqlSession;

    @Override
    public List<Summary> listSummary(){
        return sqlSession.selectList("listSummary");
    }

    @Override
    public void setSummary(Summary summary) {
    	System.out.println("summary : " + summary.toString());
        sqlSession.insert("setSummary",summary);
    }

    @Override
    public void deleteSummary(Summary summary) {
        sqlSession.delete("deleteSummary",summary);
    }

    @Override
    public void updateSummary(Summary summary) {
        sqlSession.update("updateSummary",summary);
    }

    @Override
    public Summary getSummary(String symbol, String sectorcode){
        return sqlSession.selectOne("getSummary");
    }
    
    @Override
    public int checkSummary(Summary summary) {
    	return sqlSession.selectOne("checkSummary", summary);
    }

    @Override
    public String dbCheck(){return sqlSession.selectOne("dbCheck");}
}
