package com.ropi.ropispring.DAO;

import com.ropi.ropispring.Model.Summary;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SummaryDAOImpl implements SummaryDAO {
    @Autowired
    SqlSession sqlSession;

    @Override
    public List<Summary> listSummary(){
        return sqlSession.selectList("listSummary");
    }

    @Override
    public void setSummary(Summary summary) {
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
    public Summary getSummary(String symbol, String countrycode){
        return sqlSession.selectOne("getSummary");
    }

	@Override
	public int checkSummary(Summary summary) {
		return sqlSession.selectOne("checkSummary", summary);
	}

    @Override
    public String dbCheck(){return sqlSession.selectOne("dbCheck");}
    
  
}
