package net.chinahrd.mvc.pc.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.chinahrd.entity.dto.pc.admin.OrganDto;
import net.chinahrd.entity.dto.pc.admin.TreeDto;
import net.chinahrd.entity.dto.pc.common.ResultDto;
import net.chinahrd.mvc.pc.controller.BaseController;
import net.chinahrd.mvc.pc.service.admin.OrganService;
import net.chinahrd.mvc.pc.service.common.CommonService;

/**
 * 通用Controller
 *
 * @author wqcai
 */
@Controller
@RequestMapping(value = "/common")
public class CommonController extends BaseController {

	@Autowired
	private CommonService commonService;
	@Autowired
	private OrganService organService;

	/***
	 * 跳转到临时页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/noAuthor")
	public String getNoAuthor() {
		return "biz/noAuthor";
	}



	/* ============================================================== */
	/* 配置页面使用-配置数据权限 */
	/* ============================================================== */
	/**
	 * 使用时机构树，提供给 @see organTreeSeletor
	 *
	 * @param id
	 * @return name
	 */
	@ResponseBody
	@RequestMapping(value = "/getOrganNameById", method = RequestMethod.POST)
	public ResultDto<String> getOrganNameById(@RequestParam(value = "id", required = false) String id) {
		ResultDto<String> rs = new ResultDto<String>();
		OrganDto dto = organService.findOrganById(id, getCustomerId());
		String organName = dto == null ? null : dto.getOrganizationName();
		rs.setType(true);
		rs.setT(organName);
		return rs;
	}
	/* ============================================================== */
	/* 指标页面使用-查出机构树 */
	/* ============================================================== */

	/**
	 * 使用时机构树，提供给 @see organTreeSeletor
	 *
	 * @param id
	 * @param isSingleOrgan
	 *            是否独立核算
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryOrganTree", method = RequestMethod.POST)
	public List<TreeDto> queryOrganTree(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "isSingleOrgan", required = false) Boolean isSingleOrgan) {

		List<TreeDto> list = organService.queryOrganTree(getUserId(), getCustomerId(), isSingleOrgan);

		return list;
	}

};
