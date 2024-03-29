package com.ropi.ropispring.DAO;

import com.ropi.ropispring.Model.Industry;
import com.ropi.ropispring.Model.Sector;
import com.ropi.ropispring.Model.Summary;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SummaryDAOImpl implements SummaryDAO {
    @Autowired
    SqlSession sqlSession;

    @Override
    public List<Summary> listSummary(Map<String, Integer> map){
    	List<Summary> list = sqlSession.selectList("listSummary", map);
        return list;
    }

    @Override
    public int setSummary(Summary summary) {
    	System.out.println("impl summ : " + summary.toString());
        int result = sqlSession.insert("setSummary",summary);
        System.out.println("implresult : " + result);
        return result;
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
    	return sqlSession.selectOne("dbCheck");
    }

	@Override
	public int getSummaryCount() {
		return sqlSession.selectOne("getSummaryCount");
	}

	@Override
	public List<Sector> getSectorList() {
		List<Sector> list = sqlSession.selectList("getSectorList");
		return list;
	}

	@Override
	public List<Industry> getIndustryList() {
		List<Industry> list = sqlSession.selectList("getIndustryList");
		return list;
	}
}
