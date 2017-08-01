package net.chinahrd.homepage.mvc.pc.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.chinahrd.core.tools.Identities;
import net.chinahrd.eis.annotation.log.ControllerAop;
import net.chinahrd.entity.dto.pc.common.UserExpDto;
import net.chinahrd.homepage.mvc.pc.service.ProfileService;
import net.chinahrd.mvc.pc.controller.BaseController;

@Controller
@RequestMapping("/home")
public class ProfileController extends BaseController {

	@Autowired
	private ProfileService profileService;

	/**
	 * 跳转到用户平台
	 * 
	 * @param request
	 * @return
	 */
	@ControllerAop(description = "跳转到用户平台")
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(HttpServletRequest request) {
		return "biz/home/profile";
	}

	/**
	 * 用户扩展信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findUserExpInfo", method = RequestMethod.POST)
	public UserExpDto findUserExpInfo() {
		return profileService.findUserExpInfo();
	}

	/**
	 * 保存用户图片关系 <br>
	 * 1.删除全部有关userId的头像关系的图片 <br>
	 * 2.保存用户图片关系<br>
	 * 3.在图片库里查找没有在用的头像图片<br>
	 * 4.文件删除，图片库表内容删除<br>
	 * 
	 * @param photoId
	 */
	@ResponseBody
	@RequestMapping(value = "/savePhotoUser", method = RequestMethod.POST)
	public void savePhotoUser(@RequestParam("photoId") String photoId) {
		profileService.savePhotoUser(photoId);
	}

	/**
	 * ajaxFileUpload，图片信息将会保存在dict_tmp_photo表里
	 * 
	 * @param uname
	 * @param myfiles
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/fileUpload")
	public String fileUpload(@RequestParam("uname") String uname, @RequestParam MultipartFile[] myfiles,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.debug("收到用户[{}]的文件上传请求 ", uname);
		String realPath = request.getSession().getServletContext().getRealPath("/upload");
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 上传文件的原名(即上传前的文件名字)
		String originalFilename = null;
		String uuid = Identities.uuid2();
		String filePath = null;
		for (MultipartFile myfile : myfiles) {
			if (myfile.isEmpty()) {
				out.print("1|请选择文件后上传");
				out.flush();
				return null;
			} else {
				originalFilename = myfile.getOriginalFilename();
				log.debug("文件原名: {} ", originalFilename);
				log.debug("文件名称: {}", myfile.getName());
				log.debug("文件长度: {}", myfile.getSize());
				log.debug("文件类型: {}", myfile.getContentType());
				String suffix = org.apache.commons.lang3.StringUtils.split(originalFilename, ".")[1];
				String serverFilename = uuid + "." + suffix;
				filePath = "/upload/" + serverFilename;
				try {
					FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, serverFilename));
					saveTmpPhoto(uuid, filePath);
				} catch (IOException e) {
					log.debug("文件[{}]上传失败,堆栈轨迹如下", originalFilename);
					e.printStackTrace();
					out.print("1|文件上传失败，请重试！！");
					out.flush();
					return null;
				}
			}
		}
		out.print("0|" + filePath + "|" + uuid);
		out.flush();
		return null;
	}

	/**
	 * 保存入临时数据表
	 * 
	 * @param uuid
	 * @param filePath
	 */
	private void saveTmpPhoto(String uuid, String filePath) {
		profileService.savePhoto(uuid, filePath);
	}

}
