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

    @Override
    public List<Summary> listSummary(){
        return sqlSession.selectList("listSummary");
    }

    @Override
    public void insert(Summary summary) {
        sqlSession.insert("setSummary",summary);
    }

    @Override
    public void delete(Summary summary) {
        sqlSession.delete("deleteSummary",summary);
    }

    @Override
    public void update(Summary summary) {
        sqlSession.update("updateSummary",summary);
    }
}
