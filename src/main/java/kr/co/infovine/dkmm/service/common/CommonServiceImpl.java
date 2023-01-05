package kr.co.infovine.dkmm.service.common;

import kr.co.infovine.dkmm.db.model.common.TCommonCodeModel;
import kr.co.infovine.dkmm.mapper.common.TCommonCodeMapper;
import kr.co.infovine.dkmm.util.CommonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CommonServiceImpl implements CommonService {
	private final String TYPE_DISTANCE = "distance_limit";
	private final String TYPE_SMS = "sms_auth_daily_max";
	private final String TYPE_EMAIL = "email_auth_daily_max";
	private final String TYPE_TEST_PHONE = "judge_test_phone_number";
	private final String TYPE_ANALYSIS_LIST_VISIBLE = "analysis_list_visible";
	private final String TYPE_CTGRY_VISIBLE = "ctgry_visible";
	private final String TYPE_LIKE_CNT_VISIBLE = "like_cnt_visible";
	private final String TYPE_WAIT_LIST_TIME = "wait_list_time";
	
	@Autowired
	TCommonCodeMapper tCommonCodeMapper;

	@Override
	public int deleteByPrimaryKey(String codeGroup, String codeValue) {
		return tCommonCodeMapper.deleteByPrimaryKey(codeGroup, codeValue);
	}

	@Override
	public int insert(TCommonCodeModel row) {
		return tCommonCodeMapper.insert(row);
	}

	@Override
	public TCommonCodeModel selectByPrimaryKey(String codeGroup, String codeValue) {
		return tCommonCodeMapper.selectByPrimaryKey(codeGroup, codeValue);
	}
	
	@Override
	public List<TCommonCodeModel> selectByCodeGroup(String codeGroup) {
		return tCommonCodeMapper.selectByCodeGroup(codeGroup);
	}

	@Override
	public List<TCommonCodeModel> selectAll() {
		return tCommonCodeMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(TCommonCodeModel row) {
		return tCommonCodeMapper.updateByPrimaryKey(row);
	}


	@Override
	public List<TCommonCodeModel> selectCommonCodeByPromotion(String mode) {
		return tCommonCodeMapper.selectByPromotion(mode);
	}
}
