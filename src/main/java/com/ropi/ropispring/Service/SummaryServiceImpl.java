package com.ropi.ropispring.Service;

import com.ropi.ropispring.DAO.SummaryDAO;
import com.ropi.ropispring.Model.Summary;

import java.util.List;

public class SummaryServiceImpl implements SummaryService{
    SummaryDAO summaryDAO;

    @Override
    public List<Summary> listSummary() {
        return null;
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
