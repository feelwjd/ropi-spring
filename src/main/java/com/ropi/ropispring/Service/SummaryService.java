package com.ropi.ropispring.Service;

import com.ropi.ropispring.Model.Summary;

import java.util.List;

public interface SummaryService {
    List<Summary> listSummary();
    void insert(Summary summary);
    void delete(Summary summary);
    void update(Summary summary);
}
