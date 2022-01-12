package com.ropi.ropispring.Service;

import com.ropi.ropispring.DAO.SummaryDAO;
import com.ropi.ropispring.Model.Summary;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SummaryDAOImpl implements SummaryDAO {
    SqlSession sqlSession;

    @Override
    public List<Summary> listSummary(){
        return null;
    }

    @Override
    public void insert(Summary summary) {
        sqlSession.insert("summary.insert",summary);
    }

    @Override
    public void delete(Summary summary) {
        sqlSession.delete("summary.delete",summary);
    }

    @Override
    public void update(Summary summary) {
        sqlSession.update("summary.update",summary);
    }
}
