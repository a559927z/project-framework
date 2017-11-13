package net.chinahrd.homepage.mvc.pc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import net.chinahrd.entity.dto.KVItemDto;
import net.chinahrd.entity.dto.pc.common.UserExpDto;
import net.chinahrd.entity.dto.pc.home.PhotoDto;

@Repository("profileDao")
public interface ProfileDao {

	/**
	 * 查找用户扩展信息
	 * 
	 * @param params
	 * @return
	 */
	UserExpDto findUserExpInfo(Map<String, Object> params);

	/**
	 * 保存图片库
	 * 
	 * @param photoDto
	 */
	void savePhoto(PhotoDto photoDto);

	/**
	 * 删除用户头像图片关系
	 * 
	 * @param photoId
	 */
	void delectAvatar(@Param("userId") String userId);

	/**
	 * 保存用户图片关系
	 * 
	 * @param photoId
	 * @param userId
	 */
	void savePhotoUser(@Param("photoId") String photoId, @Param("userId") String userId);

	/**
	 * 清空图片库
	 */
	void delectPhoto(@Param("photoIds") List<String> photoIds);

	/**
	 * 查询没再有用的图片
	 * 
	 * @param photoId
	 *            在用的photoId
	 * @param userId
	 * @return
	 */
	List<KVItemDto> queryNotUsePhoto(@Param("photoId") String photoId, @Param("userId") String userId);
}
