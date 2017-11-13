package net.chinahrd.homepage.mvc.pc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chinahrd.eis.permission.EisWebContext;
import net.chinahrd.entity.dto.KVItemDto;
import net.chinahrd.entity.dto.pc.common.UserExpDto;
import net.chinahrd.entity.dto.pc.home.PhotoDto;
import net.chinahrd.homepage.mvc.pc.dao.ProfileDao;
import net.chinahrd.homepage.mvc.pc.enums.PhotoCode;
import net.chinahrd.homepage.mvc.pc.service.ProfileService;
import net.chinahrd.mvc.pc.service.admin.impl.BaseServiceImpl;
import net.chinahrd.utils.CollectionKit;
import net.chinahrd.utils.FileUtil;
import net.chinahrd.utils.WebUtils;

@Service("profileService")
public class ProfileServiceImpl extends BaseServiceImpl implements ProfileService {

	@Autowired
	private ProfileDao profileDao;

	@Override
	public UserExpDto findUserExpInfo() {
		return profileDao.findUserExpInfo(this.paramsMap());
	}

	@Override
	public void savePhoto(String uuid, String filePath) {
		String userId = EisWebContext.getCurrentUser().getUserId();
		PhotoDto dto = new PhotoDto();
		dto.setPhotoId(uuid);
		dto.setFilePath(filePath);
		dto.setCreateUserId(userId);
		dto.setType(PhotoCode.avatar.getCode());
		profileDao.savePhoto(dto);

	}

	@Override
	public void savePhotoUser(String photoId) {
		String userId = EisWebContext.getCurrentUser().getUserId();
		profileDao.delectAvatar(userId);
		profileDao.savePhotoUser(photoId, userId);
		List<KVItemDto> kvs = profileDao.queryNotUsePhoto(photoId, userId);
		if (kvs.size() > 0) {
			delFileImgs(kvs);
		}
	}

	/**
	 * 文件删除<br>
	 * 表删除<br>
	 * 
	 * @param kvs
	 * @return
	 */
	private boolean delFileImgs(List<KVItemDto> kvs) {
		String path = WebUtils.getAbsolutePath();
		boolean flag = false;
		try {
			List<String> delList = CollectionKit.extractToList(kvs, "k");
			boolean delectFile = false;
			for (KVItemDto kv : kvs) {
				delectFile = FileUtil.delectFile(path + kv.getV());
			}
			if (delectFile) {
				profileDao.delectPhoto(delList);
			}
			flag = true;
		} catch (Exception e) {
		}
		return flag;
	}

}
