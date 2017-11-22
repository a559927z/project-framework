package net.chinahrd.eis.permission.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import net.chinahrd.eis.permission.model.RbacFunction;
import net.chinahrd.eis.permission.model.RbacPermission;
import net.chinahrd.eis.permission.model.RbacRole;
import net.chinahrd.eis.permission.model.RbacUser;

@Repository("authorizerDao")
public interface RbacAuthorizerDao {

	/**
	 * 更新最后登录时间
	 * 
	 * @param params
	 */
	void updateLastTime(Map<String, Object> params);


	/**
	 * 
	 * 查出用户具备角色、功能权限
	 * 
	 * @param customerId
	 * @return
	 */
	List<RbacPermission> queryPerms(Map<String, Object> params);

	Integer queryPermsCount(Map<String, Object> params);

	/**
	 * 检查用户是否存在
	 * 
	 * @param customerId
	 * @param userKey
	 * @param password
	 * @return
	 */
	List<RbacUser> checkUserExist(@Param("customerId") String customerId, @Param("userKey") String userKey,
			@Param("password") String password);

	/**
	 * 根据条件查询用户角色信息
	 * 
	 * @param userId
	 * @return
	 */
	List<RbacRole> findRoleList(@Param("customerId") String customerId, @Param("userId") String userId);

	/**
	 * 根据角色查询功能和操作信息
	 * 
	 * @param roleIds
	 * @return
	 */
	List<RbacFunction> findRbacPermissionByRole(@Param("customerId") String customerId,
			@Param("roleIds") List<String> roleIds);


}
