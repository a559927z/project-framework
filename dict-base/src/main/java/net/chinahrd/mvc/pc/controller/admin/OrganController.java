package net.chinahrd.mvc.pc.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import net.chinahrd.entity.dto.pc.admin.OrganDto;
import net.chinahrd.mvc.pc.controller.BaseController;
import net.chinahrd.mvc.pc.service.admin.OrganService;
import net.chinahrd.utils.ExcelUtil;

/**
 * Created by jxzhang on 15/6/23.
 */
@Controller
@RequestMapping(value = "/organ")
public class OrganController extends BaseController {

	@Autowired
	private OrganService organService;


	/* ============================================================== */
	/* 指标页面使用-获取机构名称 */
	/* ============================================================== */

	/**
	 * 组件机构管理页面
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	// @RequiresPermissions("XiTongGuanLi_ZuZhiGuanLi")
	@RequestMapping(value = "list")
	public String organList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "biz/admin/organ/organ-list";
	}

	/**
	 * 执行解析excel
	 */
	@RequestMapping(value = "doImportExcel", method = RequestMethod.POST)
	public String doImportExcel(@RequestParam(value = "inputfile") MultipartFile file, Model model,
			HttpServletRequest request) throws IOException {
		List<Map<String, Object>> excelData = new ArrayList<Map<String, Object>>();

		String fileName = file.getOriginalFilename();
		String extensionName = ExcelUtil.getExtensionName(fileName);
		if (extensionName.equalsIgnoreCase("xls")) {
			excelData = ExcelUtil.readExcel2003(file, null);
		} else if (extensionName.equalsIgnoreCase("xlsx")) {
			excelData = ExcelUtil.readExcel2007(file, null);
		}
		String excelDataJson = JSON.toJSONString(excelData);
		request.setAttribute("excelDataJson", excelDataJson);

		return "biz/admin/organ/organ-list";
	}

	@ResponseBody
	@RequestMapping(value = "findList")
	public List<OrganDto> findList(OrganDto org) {
		org.setCustomerId(getCustomerId());
		return organService.findList(org);
	}

}
