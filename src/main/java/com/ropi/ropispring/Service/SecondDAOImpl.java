package com.ropi.ropispring.Service;

import com.ropi.ropispring.DAO.SecondDAO;
import com.ropi.ropispring.Model.Second;
import com.ropi.ropispring.Model.Summary;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class SecondDAOImpl implements SecondDAO {
    @Inject
    SqlSession sqlSession2;

    @Override
    public List<Second> listSummary2(){
        return sqlSession2.selectList("listSummary2");
    }

    @Override
    public void setSummary2(Second second) {
        sqlSession2.insert("setSummary2",second);
    }

    @Override
    public void deleteSummary2(Second second) {
        sqlSession2.delete("deleteSummary2",second);
    }

    @Override
    public void updateSummary2(Second second) {
        sqlSession2.update("updateSummary2",second);
    }

    @Override
    public Second getSummary2(String symbol){
        return sqlSession2.selectOne("getSummary2");
    }

}
