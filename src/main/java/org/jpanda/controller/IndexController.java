package org.jpanda.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jpanda.model.system.SysLoginUser;
import org.jpanda.service.system.SysLoginUserService;
import org.jpanda.util.Constant;
import org.jpanda.util.MD5StrGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	
	@Autowired
	private SysLoginUserService sysLoginUserService;
	
	
	/**
	 * 
	 * 功能 :跳转到首页
	
	 * 开发：wuyechun 2015-5-29
	
	 * @return
	 */
	@RequestMapping({"/","/index","/welcome"})
	public String index(){
		return "index";
	}
	
	
	
	/**
	 * 
	 * 功能 :系统用户登录
	
	 * 开发：wuyechun 2015-6-1
	
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String username,String password,HttpSession session){
		List<SysLoginUser> userList=sysLoginUserService.findByLoginAccount(username);
		if(userList!=null&&!userList.isEmpty()){
			SysLoginUser sysLoginUser=userList.get(0);
			if(sysLoginUser!=null){
				password=MD5StrGen.GetMD5Str32(MD5StrGen.GetMD5Str32(password));
				if(password.equals(sysLoginUser.getLoginPwd())&&!"D".equals(sysLoginUser.getUserState())){
					session.setAttribute(Constant.CURRENT_USER, sysLoginUser);
					return "/system/main";
				}
				
			}else{
				
			}
		}
		return "index";
	}
	
	
	
	/**
	 * 
	 * 功能 :系统用户登录
	
	 * 开发：wuyechun 2015-6-1
	
	 * @return
	 */
	@RequestMapping("/download")
	public void download(String fileName,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="+ fileName);
        try {
        	
        	 //远程FTP服务器路径地址
            String remote="cos/20150624/20150624140047304-biz001.doc";
        	
        	//这个download目录为啥建立在classes下的
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String localFile=path+ fileName;
            File file=new File(localFile);
            file.createNewFile();
            //传递两个参数,一个是FTP远程文件路径，另一个是本地文件路径
            //FileUtil.download(remote, localFile);
             InputStream inputStream = new FileInputStream(file);
            
            
            //InputStream inputStream =FileUtil.download(remote);
           
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            os.close();
            inputStream.close();
            
            if(file.exists()){
            	file.delete();
            }
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

	
	
	/**
	 * 
	 * 功能 :系统用户登录
	
	 * 开发：wuyechun 2015-6-1
	
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(){
		return "logout";
	}
	
	
	/***
	 * 
	 * 功能 :退出系统
	 * 
	 * 开发：wuyechun 2013-9-24
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/loginout")
	public String doLoginOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(Constant.CURRENT_USER);
		session.invalidate();
		return "index";
	}
	
	
	/**
	 * 
	 * 功能 :系统跳转页面公用方法
	
	 * 开发：wuyechun 2013-9-3
	
	 * @param module
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "views/{module}/{page}")
	public String getDefinedPage(@PathVariable("module") String module,@PathVariable("page") String page) {
		return module+"/"+page;
	}

}
