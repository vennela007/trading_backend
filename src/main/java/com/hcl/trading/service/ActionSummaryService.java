package com.hcl.trading.service;

import java.util.List;

import com.hcl.trading.dto.ActionSummaryResponseDto;

public interface ActionSummaryService {

	List<ActionSummaryResponseDto> getAllActionSummary(Integer userId);

}
