package com.ropi.ropispring.Service;

import com.ropi.ropispring.DAO.SecondDAO;
import com.ropi.ropispring.DAO.SummaryDAO;
import com.ropi.ropispring.Model.Second;
import com.ropi.ropispring.Model.Summary;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecondServiceImpl implements SecondService{

    @Autowired
    SecondDAO secondDAO;

    @Override
    public List<Second> listSummary2() {
        return secondDAO.listSummary2();
    }

    @Override
    public void setSummary2(Second second) {
        secondDAO.setSummary2(second);
    }

    @Override
    public void deleteSummary2(Second second) {
        secondDAO.deleteSummary2(second);
    }

    @Override
    public void updateSummary2(Second second) {
        secondDAO.updateSummary2(second);
    }

    @Override
    public Second getSummary2(String symbol){return secondDAO.getSummary2(symbol);}
}
