package com.ropi.ropispring.Service;

import com.ropi.ropispring.Model.Summary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SummaryService {
    List<Summary> listSummary();
    void insert(Summary summary);
    void delete(Summary summary);
    void update(Summary summary);
}
