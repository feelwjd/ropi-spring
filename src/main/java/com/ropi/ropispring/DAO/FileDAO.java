package com.ropi.ropispring.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.ropi.ropispring.Model.Summary;

@Component
@Mapper
public interface FileDAO {
	int insertSummaryList(List<Summary> summaryList);

}
