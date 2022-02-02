package com.ropi.ropispring.DAO6;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ropi.ropispring.Model.Summary;

@Repository
public class SummaryRopi6DAOImpl implements SummaryRopi6DAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<Summary> listSummary(Map<String, Integer>map) {
		System.out.println("dao 6 : " + map.toString());
		List<Summary> list = sqlSession.selectList("listSummary", map);
		return list;
	}

	@Override
	public void setSummary(Summary summary) {
		System.out.println("summary : " + summary.toString());
		sqlSession.insert("setSummary", summary);
	}

	@Override
	public void deleteSummary(Summary summary) {
		sqlSession.delete("deleteSummary", summary);
	}

	@Override
	public void updateSummary(Summary summary) {
		sqlSession.update("updateSummary", summary);
	}

	@Override
	public Summary getSummary(String symbol, String countrycode) {
		return sqlSession.selectOne("getSummary");
	}

	@Override
	public int checkSummary(Summary summary) {
		return sqlSession.selectOne("checkSummary", summary);
	}

	@Override
	public String dbCheck() {
		return sqlSession.selectOne("dbCheck");
	}
}
