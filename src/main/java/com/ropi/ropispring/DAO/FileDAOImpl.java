package com.ropi.ropispring.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ropi.ropispring.Model.Summary;

@Repository
public class FileDAOImpl implements FileDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertSummaryList(List<Summary> summaryList) {
		return sqlSession.insert("insertSummaryList", summaryList);
	}
}
