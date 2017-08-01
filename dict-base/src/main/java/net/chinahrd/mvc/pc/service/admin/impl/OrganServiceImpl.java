package net.chinahrd.mvc.pc.service.admin.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chinahrd.core.tools.Identities;
import net.chinahrd.eis.permission.EisWebContext;
import net.chinahrd.eis.permission.model.RbacUser;
import net.chinahrd.entity.dto.pc.admin.OrganDto;
import net.chinahrd.entity.dto.pc.admin.OrganTypeDto;
import net.chinahrd.entity.dto.pc.admin.RoleOrganizationDto;
import net.chinahrd.entity.dto.pc.admin.TreeDto;
import net.chinahrd.entity.dto.pc.admin.UserDto;
import net.chinahrd.mvc.pc.dao.admin.OrganDao;
import net.chinahrd.mvc.pc.dao.admin.OrganTypeDao;
import net.chinahrd.mvc.pc.service.admin.OrganService;
import net.chinahrd.utils.CacheHelper;
import net.chinahrd.utils.CollectionKit;
import net.chinahrd.utils.DateUtil;
import net.chinahrd.utils.PropertiesUtil;

/**
 * Created by jxzhang on 15/6/23.
 */
@Service("organService")
public class OrganServiceImpl implements OrganService {

	@Autowired
	private OrganDao organDao;

	@Autowired
	private OrganTypeDao organTypeDao;

	/* ============================================================== */
	/* shiro框架使用-rbacAuthorizaerService */
	/* ============================================================== */
	/**
	 * @see chkboxType: { "Y" : "s", "N" : "ps" }
	 */
	@Override
	public List<OrganDto> queryOrganPermit2(String userId, boolean isOrganPermit) {
		List<OrganDto> list = CollectionKit.newList();
		String superAdminId = CacheHelper.getSuperAdminId();
		if (userId.equals(superAdminId)) {
			list = organDao.queryOrganPermitBySuperAdmin(EisWebContext.getCustomerId());
		} else {
			list = organDao.queryOrganPermit(userId, EisWebContext.getCustomerId(), isOrganPermit);

			// 对List去重相关id
			Iterator<OrganDto> iterator = list.iterator();
			String id = "";
			while (iterator.hasNext()) {
				OrganDto organDto = (OrganDto) iterator.next();
				if (id.equals(organDto.getOrganizationId())) {
					iterator.remove();
				}
				id = organDto.getOrganizationId();
			}
		}
		return list;
	}

	/* ============================================================== */
	/* 配置页面使用-配置数据权限-role2organ */
	/* ============================================================== */
	@Override
	public boolean addRoleOrganization(String roleId, String createUserId, String customerId, List<OrganDto> organDtos)
			throws RuntimeException {

		if (CollectionKit.isEmpty(organDtos)) {
			return false;
		}

		List<RoleOrganizationDto> dtos = CollectionKit.newList();

		for (OrganDto organDto : organDtos) {
			RoleOrganizationDto dto = new RoleOrganizationDto();
			dto.setRoleOrganizationId(Identities.uuid2());
			dto.setCustomerId(customerId);
			dto.setRoleId(roleId);
			dto.setHalfCheck(organDto.getHalfCheck());
			dto.setOrganizationId(organDto.getOrganizationId());
			dto.setCreateUserId(createUserId);
			dto.setCreateTime(DateUtil.getTimestamp());
			dtos.add(dto);
		}
		organDao.deleteRoleOrganization(roleId, customerId);
		organDao.addRoleOrganization(dtos);
		return true;
	}

	@Override
	public List<OrganDto> queryRoleOrgans(String roleId, String customerId, Boolean isOrganPermit) {
		return organDao.queryRoleOrgans(roleId, customerId, isOrganPermit);
	}

	@Override
	public OrganDto findOrganById(String organId, String customerId) {
		return organDao.findOrganById(organId, customerId);
	}

	@Override
	public boolean deleteRoleOrganization(String roleId, String customerId) {
		try {
			organDao.deleteRoleOrganization(roleId, customerId);
			return true;
		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}
	}

	/* ============================================================== */
	/* 配置页面使用-整棵树组装 */
	/* ============================================================== */
	@Override
	public List<TreeDto> dbToZtree(List<OrganDto> existOrgans) {
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getPrincipal();
		if (!(principal instanceof RbacUser)) {
			return CollectionKit.newList();
		}
		RbacUser rbacUser = (RbacUser) principal;
		List<OrganDto> organPermit = rbacUser.getOrganAllStatus();
		if (null == organPermit || organPermit.isEmpty()) {
			return CollectionKit.newList();
		}
		// 获取第1个是因为数据按好序，level = 1并且只有一个level=1也就是集团公司只有一个
		List<TreeDto> notTopOrgans = packageTree(organPermit, organPermit.get(0).getOrganizationId(), existOrgans);

		if (organPermit.get(0).getOrganizationParentId().equals("-1")) {
			TreeDto topTreeDto = new TreeDto();
			topTreeDto.setId(organPermit.get(0).getOrganizationId());
			topTreeDto.setName(organPermit.get(0).getOrganizationName());
			topTreeDto.setParentId(organPermit.get(0).getOrganizationParentId());
			// topTreeDto.setChecked(true);
			for (OrganDto existOrgan : existOrgans) {
				String existFP = existOrgan.getFullPath();
				String orgFP = organPermit.get(0).getFullPath();
				if (existFP.contains(orgFP)) {
					topTreeDto.setChecked(true);
					// topTreeDto.setHalfCheck(true);
				}
			}
			topTreeDto.setIsParent(true);
			topTreeDto.setOpen(true);
			topTreeDto.setChildren(notTopOrgans);
			List<TreeDto> topOrgans = CollectionKit.newList();
			topOrgans.add(topTreeDto);
			return topOrgans;
		} else {
			return notTopOrgans;
		}
	}

	/**
	 * 递归子孙部门List
	 *
	 * @param targetList
	 * @param orgId
	 * @param existOrgans
	 * @return
	 */
	private List<TreeDto> packageTree(List<OrganDto> targetList, String orgId, List<OrganDto> existOrgans) {
		List<TreeDto> rs = CollectionKit.newList();
		for (OrganDto orgDto : targetList) {
			String targetParendId = orgDto.getOrganizationParentId();
			if (targetParendId.equals(orgId)) {
				TreeDto treeDto = new TreeDto();
				treeDto.setId(orgDto.getOrganizationId());
				treeDto.setName(orgDto.getOrganizationName());
				treeDto.setParentId(orgDto.getOrganizationParentId());

				treeDto.setHalfCheck(orgDto.getHalfCheck());
				for (int i = 0; i < existOrgans.size(); i++) {
					if (existOrgans.get(i).getOrganizationId().equals(orgDto.getOrganizationId())) {
						existOrgans.remove(i);
						treeDto.setChecked(true);
						treeDto.setOpen(true);
					}
				}

				if (orgDto.getHasChildren() == 1) {
					treeDto.setIsParent(true);
					List<TreeDto> childrenList = packageTree(targetList, orgDto.getOrganizationId(), existOrgans);
					treeDto.setChildren(childrenList);
				} else {
					treeDto.setIsParent(false);
				}
				rs.add(treeDto);
			}
		}
		return rs;
	}

	/* ============================================================== */
	/* 指标页面使用-机构树选择 */
	/* ============================================================== */
	@Override
	public List<UserDto> queryEmpsByOrganId(String customerId, String organizationId) {
		return organDao.queryEmpsByOrganId(customerId, organizationId);
	}

	@Override
	public List<TreeDto> queryOrganTree(String userId, String customerId, Boolean isSingleOrgan) {

		List<TreeDto> list = CollectionKit.newList();
		String superAdminId = CacheHelper.getSuperAdminId();

		// 因为 PermissionCode.SUPER_ADMIN_ID
		// 在base包下会影响别的子项目。所以这里硬编码dim_user表里的superAdmin账号
		// if (userId.equals(PermissionCode.SUPER_ADMIN_ID.getValue())) {
		if (userId.equals(superAdminId)) {
			list = organDao.queryOrganTreeBySuperAdmin(customerId);
		} else {
			list = organDao.queryOrganTree(userId, customerId);
		}
		if (list.size() > 0) { // 设置第一节点为展开状态
			list.get(0).setOpen(Boolean.TRUE);
		}
		return list;
	}

	@Override
	public Integer getEmpCountByOrganId(String customerId, String organizationId) {
		return organDao.getEmpCountByOrganId(customerId, organizationId);
	}

	// @Override
	// public List<OrganDto> queryOrganPermitTop(String userId, String
	// customerId) {
	// return organDao.queryOrganPermitTop(userId, customerId);
	// }

	@Override
	public List<OrganDto> queryDirectOrgans(String customerId, String orgPid, boolean isShowSelf) {
		return organDao.queryDirectOrgans(customerId, orgPid, isShowSelf);
	}

	/**
	 * 通过pid查出所有子孙机构
	 *
	 * @param customerId
	 * @param orgPid
	 * @param isHideSelf
	 *            不包含自己
	 * @return
	 */
	public List<String> queryOrgansByPid(String orgPid, boolean isHideSelf) {
		return organDao.queryOrgansByPid(EisWebContext.getCustomerId(), orgPid, isHideSelf);
	}

	@Override
	public List<OrganDto> findList(OrganDto org) {
		return organDao.findList(org);
	}

	public List<OrganDto> findCompanyList(OrganDto org) {
		String orgTypeLevelCompany = PropertiesUtil.getProperty("ORGANIZATION.TYPE.LEVEL.COMPANY");
		List<OrganTypeDto> orgTypelist = organTypeDao.findList(new OrganTypeDto(orgTypeLevelCompany));
		if (orgTypelist == null || orgTypelist.isEmpty()) {
			return null;
		}
		org.setOrganizationTypeId(orgTypelist.get(0).getOrganizationTypeId());
		return organDao.findList(org);
	}

}
