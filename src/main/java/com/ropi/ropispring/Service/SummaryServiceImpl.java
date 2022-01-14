package com.ropi.ropispring.Service;

import com.ropi.ropispring.DAO.SummaryDAO;
import com.ropi.ropispring.Model.Summary;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService{

    @Autowired
    SummaryDAO summaryDAO;

    @Override
    public List<Summary> listSummary() {
        return summaryDAO.listSummary();
    }

    @Override
    public void insert(Summary summary) {
        summaryDAO.insert(summary);
    }

    @Override
    public void delete(Summary summary) {
        summaryDAO.delete(summary);
    }

    @Override
    public void update(Summary summary) {
        summaryDAO.update(summary);
    }
}
