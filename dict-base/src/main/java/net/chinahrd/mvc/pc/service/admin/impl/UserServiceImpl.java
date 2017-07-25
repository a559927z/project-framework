package net.chinahrd.mvc.pc.service.admin.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import net.chinahrd.eis.permission.EisWebContext;
import net.chinahrd.eis.permission.dao.RbacAuthorizerDao;
import net.chinahrd.eis.permission.model.RbacPermission;
import net.chinahrd.eis.permission.model.RbacRole;
import net.chinahrd.eis.permission.model.RbacUser;
import net.chinahrd.entity.dto.PaginationDto;
import net.chinahrd.entity.dto.pc.admin.OrganDto;
import net.chinahrd.entity.dto.pc.admin.TreeDto;
import net.chinahrd.entity.dto.pc.admin.UserDto;
import net.chinahrd.mvc.pc.dao.admin.UserDao;
import net.chinahrd.mvc.pc.service.admin.UserService;
import net.chinahrd.utils.CollectionKit;
import net.chinahrd.utils.Str;

/**
 * 用户Service实现类
 * Created by wqcai on 15/6/8.
 */

/**
 * @author 家安
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RbacAuthorizerDao rbacAuthorizerDao;

	/**
	 * 带入角色过滤
	 * 
	 * @return
	 * @author jxzhang by 2016-12-14
	 */
	private List<String> getRoleIds() {
		List<RbacRole> rbacRoles = EisWebContext.getCurrentUser().getRbacRoles();
		List<String> roleIds = null;
		if (null != rbacRoles) {
			roleIds = CollectionKit.extractToList(rbacRoles, "roleId");
		}
		return roleIds;
	}

	@Override
	public PaginationDto<UserDto> findAll(String customerId, String userName, PaginationDto<UserDto> pageDto) {
		RowBounds rowBounds = new RowBounds(pageDto.getOffset(), pageDto.getLimit());

		int count = userDao.findAllCount(customerId, userName, getRoleIds());
		pageDto.setRecords(count);

		Map<String, Object> paramsMap = this.paramsMap();
		paramsMap.put("userName", userName);
		paramsMap.put("rowBounds", rowBounds);

		List<UserDto> dtos = userDao.findAll(paramsMap);
		pageDto.setRows(dtos);
		return pageDto;
	}

	@Override
	public boolean addUser(UserDto userDto) {
		try {
			// 由License控制客户添加用户
			// LicenseData licenseData = License.getInstance().getLicenseData();
			// int liceNum =
			// licenseData.getInt(LicenseConfig.LicenseParm.EMPNUM);
			// int num = userDao.findAllCount(userDto.getCustomerId(), null,
			// null);
			if (Str.IsEmpty(userDto.getSysDeploy())) {
				userDto.setSysDeploy("0");
			}
			userDto.setPassword("123456");
			// 获取该客户端的最大用户数
			userDao.insertUser(userDto);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean editUser(UserDto userDto) {
		try {
			userDao.updateUser(userDto);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUserPasswd(String passwd, String userId, String customerId) {
		try {
			userDao.updateUserPasswd(passwd, userId, customerId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUserPWDbyUserName(String enPwd, String userName, String customerId) {
		try {
			userDao.updateUserPWDbyUserName(enPwd, userName, customerId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Integer existUser(String empId, String userName) {
		return userDao.existUser(empId, userName);
	}

	@Transactional
	@Override
	public boolean deleteUser(String customerId, List<String> userId) {
		try {
			if (userId.size() > 0) {
				userDao.deleteUser(customerId, userId);
				userDao.deleteUserRole(customerId, userId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean userBindEmp(String customerId, String userId, String empId) {
		try {
			userDao.updateUserEmp(customerId, userId, empId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public UserDto findUserById(String customerId, String userId) {
		if (StringUtils.isEmpty(userId)) {
			return null;
		}
		return userDao.findUserById(customerId, userId);
	}

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

	@Override
	public Map<String, Object> findAll2(String customerId, String search, int start, int length) {
		int count = userDao.findAllCount(customerId, null, null);
		if (count == 0) {
			return null;
		}
		Map<String, Object> rs = this.paramsMap();
		rs.put("recordsTotal", count);
		rs.put("recordsFiltered", count);
		List<UserDto> roleList = userDao.findAll(rs);
		rs.put("data", roleList);
		return rs;
	}

	@Override
	public Map<String, Object> queryPerms(String customerId, String search, int start, int length) {
		int count = rbacAuthorizerDao.queryPermsCount(this.paramsMap());
		if (count == 0) {
			return null;
		}
		List<RbacPermission> roleList = rbacAuthorizerDao.queryPerms(this.paramsMap());
		Map<String, Object> rs = CollectionKit.newMap();
		rs.put("recordsTotal", count);
		rs.put("recordsFiltered", count);
		rs.put("data", roleList);
		return rs;

	}

}
