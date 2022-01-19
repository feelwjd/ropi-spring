package com.ropi.ropispring.Service;

import com.ropi.ropispring.DAO.SummaryDAO;
import com.ropi.ropispring.Model.Summary;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import javax.inject.Inject;

import java.util.List;

@Repository
public class SummaryDAOImpl implements SummaryDAO {
    @Inject
    SqlSession sqlSession;
    SqlSession sqlSession2;

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
    public Summary getSummary(String symbol){
        return sqlSession.selectOne("getSummary");
    }

}
