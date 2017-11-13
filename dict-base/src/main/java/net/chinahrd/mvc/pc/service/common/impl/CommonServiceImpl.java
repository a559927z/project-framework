package net.chinahrd.mvc.pc.service.common.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.chinahrd.eis.permission.EisWebContext;
import net.chinahrd.entity.enums.ProcedureInfoEnum;
import net.chinahrd.entity.enums.TipsEnum;
import net.chinahrd.mvc.pc.dao.common.CommonDao;
import net.chinahrd.mvc.pc.service.common.CommonService;
import net.chinahrd.utils.CollectionKit;
import net.chinahrd.utils.DateUtil;
import net.chinahrd.utils.Identities;
import net.chinahrd.utils.holiday.DaysDto;
import net.chinahrd.utils.holiday.EasybotsGetDays;
import net.chinahrd.utils.holiday.GetDays;

/**
 * 公共Service实现类
 */
@Service("commonService")
@Transactional
public class CommonServiceImpl implements CommonService {

	private static final Logger log = LoggerFactory.getLogger(CommonServiceImpl.class);

	@Autowired
	private CommonDao commonDao;

	@Override
	public boolean insertDays(String endDay, String startDay) {
		GetDays c = new EasybotsGetDays();
		List<DaysDto> days = c.calcDays(endDay, startDay);
		for (DaysDto d : days) {
			System.out
					.println(d.getDays() + "_" + d.getIsWorkFlag() + ":" + d.getIsHoliday() + ":" + d.getIsVacation());
		}
		try {
			commonDao.insertDays(days);
			insertLog("sysJob", "days", "插入新的一年每天工作或假期情况", new Date(), TipsEnum.NOT_IS_ERROR.getCode(),
					ProcedureInfoEnum.DAYS.getShowIndex());
			return true;
		} catch (Exception e) {
			insertLog("sysJob", "days", e.toString(), new Date(), TipsEnum.IS_ERROR.getCode(), null);
			log.debug(e.toString());
			return false;
		}
	}
	

	@Override
	public void insertLog(String userId, String module, String text, Date startTime, int isError, Integer showIndex) {
		int useTime = DateUtil.getBetweenDiff(startTime, new Date(), 3);
		Map<String, Object> paramMap = CollectionKit.newMap();
		paramMap.put("logId", Identities.uuid2());
		paramMap.put("customerId", EisWebContext.getCustomerId());
		paramMap.put("userId", userId);
		paramMap.put("module", module);
		paramMap.put("text", text);
		paramMap.put("useTime", useTime);
		paramMap.put("startTime", startTime);
		paramMap.put("endTime", new Date());
		paramMap.put("isError", isError);
		paramMap.put("showIndex", showIndex);
		paramMap.put("yearMonth", DateUtil.convertToIntYearMonth(new Date()));
		commonDao.insertLog(paramMap);
	}
	
    /**
     * 检查Days表是否有本年度数据
     * @param paramMap
     * @return
     */
	@Override
	public boolean checkDaysTable(String year) {
		Map<String, Integer> paramMap = CollectionKit.newMap();
		paramMap.put("beginTime", Integer.parseInt(year + "01"));
		paramMap.put("endTime", Integer.parseInt(year + "12"));
		return commonDao.checkDaysTable(paramMap) > 0 ? true : false;
	}

}
