package com.ropi.ropispring.DAO7;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ropi.ropispring.DAO.SummaryDAO;
import com.ropi.ropispring.Model.Summary;

@Repository
public class SummaryRopi7DAOImpl implements SummaryRopi7DAO {
    @Autowired
    SqlSession sqlSession;

    @Override
    public List<Summary> listSummary(Map<String, Integer>map){
    	System.out.println("dao 7 : " + map.toString());
    	List<Summary> list = sqlSession.selectList("listSummary", map);
		return list;
    }

    @Override
    public void setSummary(Summary summary) {
    	System.out.println("summary : " + summary.toString());
        sqlSession.insert("setSummary",summary);
    }

    @Override
    public int deleteSummary(Summary summary) {
        return sqlSession.delete("deleteSummary",summary);
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
    public String dbCheck(){
        try {
            return sqlSession.selectOne("dbCheck");
        }catch (Exception e){
            return "db-connect-error";
        }
    }

	@Override
	public int getSummaryCount() {
		return sqlSession.selectOne("getSummaryCount");
	}
}
