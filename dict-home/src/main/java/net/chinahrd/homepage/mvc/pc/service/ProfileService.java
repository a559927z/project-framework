package net.chinahrd.homepage.mvc.pc.service;

import net.chinahrd.entity.dto.pc.common.UserExpDto;

public interface ProfileService {

	/**
	 * 用户扩展信息
	 */
	UserExpDto findUserExpInfo();

	/**
	 * 保存用户图片关系 <br>
	 * 1.删除全部有关userId的头像关系的图片 <br>
	 * 2.保存用户图片关系<br>
	 * 3.在图片库里查找没有在用的头像图片<br>
	 * 4.文件删除，图片库表内容删除<br>
	 * 
	 * @param photoId
	 */
	void savePhotoUser(String photoId);

	/**
	 * 保存图片
	 * 
	 * @param uuid
	 * @param filePath
	 */
	void savePhoto(String uuid, String filePath);

}
