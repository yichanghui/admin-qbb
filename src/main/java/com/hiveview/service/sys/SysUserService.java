package com.hiveview.service.sys;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.hiveview.dao.sys.SysUserDao;
import com.hiveview.dao.sys.SysUserSessionDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.sys.SysUser;


@Service
public class SysUserService {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserSessionDao sysUserSessionDao;
	
	/**
	 * 获取用户信息
	 * @param userId
	 * @return
	 */
	public SysUser getSysUserById(int userId){
		return sysUserDao.getSysUserById(userId);
	}
	
	/**
	 * 登录
	 * @param sysUser
	 * @return
	 */
	public SysUser getLoginInfo(SysUser sysUser){
		try {
			sysUser.setUserPwd(DigestUtils.md5DigestAsHex(sysUser.getUserPwd().getBytes()));
			return sysUserDao.getLoginInfo(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取所有系统用户
	 * @param isEffective
	 * @return
	 */
	public ScriptPage getSysUserByAll(AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<SysUser> rows = sysUserDao.getUserList(map);
		scriptPage.setRows(rows);
		SysUser sysUser = new SysUser();
		int total = sysUserDao.getCount(sysUser);
		scriptPage.setTotal(total);
		return scriptPage;
	}
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public int updateSysUser(SysUser user){
		if(null!=user.getUserPwd())
			user.setUserPwd(DigestUtils.md5DigestAsHex(user.getUserPwd().getBytes()));
		SysUser u = new SysUser();
		if(user.getUserMail()==null){
			return sysUserDao.updateSysUser(user);
		}else{
			u.setUserMail(user.getUserMail());
			if(sysUserDao.getCount(u)==0){
				user.setUpdatedTime(new Date());
				return sysUserDao.updateSysUser(user);
			}else{
				return -1;
			}
		}
	}
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public int updateSysUserPwd(String pwd,SysUser user){
		//判断输入的旧密码是否正确
		SysUser sysUserOld=new SysUser();
		sysUserOld.setUserMail(user.getUserMail());
		sysUserOld.setUserPwd(DigestUtils.md5DigestAsHex(pwd.getBytes()));
		sysUserOld=sysUserDao.getLoginInfo(sysUserOld);
		if(null==sysUserOld)
			return -100;
		if(null!=user.getUserPwd())
			user.setUserPwd(DigestUtils.md5DigestAsHex(user.getUserPwd().getBytes()));
		else
			return -1;
		return sysUserDao.updateSysUser(user);
	}
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int addSysUser(SysUser user){
		SysUser u = new SysUser();
		u.setUserMail(user.getUserMail());
		if(sysUserDao.getCount(u)==0){
			user.setCreatedTime(new Date());
			user.setUpdatedTime(new Date());
			user.setUserPwd(DigestUtils.md5DigestAsHex(user.getUserPwd().getBytes()));
			return sysUserDao.addSysUser(user);
		}else{
			return -1;
		}
	}
	
	public Integer deleteSysUser(Integer sysUserId){
		try {
			return sysUserDao.deleteSysUserById(sysUserId);
		} catch (Exception e) {
			e.printStackTrace();
			return -1000;
		}
	}
	
	public int getCount(SysUser user){
		return sysUserDao.getCount(user);
	}
}

