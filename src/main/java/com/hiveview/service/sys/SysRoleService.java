package com.hiveview.service.sys;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.sys.SysRoleAuthDao;
import com.hiveview.dao.sys.SysRoleDao;
import com.hiveview.entity.sys.SysRole;
import com.hiveview.entity.sys.SysRoleAuth;

/**
 * @author gonglixun
 */
@Service
public class SysRoleService{
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleAuthDao sysRoleAuthDao;
	
	/**
	 * 查询
	 * @param sysRole
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<SysRole> getSysRole_All(SysRole sysRole,int currentPage,int pageSize){
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sysRole", sysRole);
			map.put("currentPage", (currentPage-1)*pageSize);
			map.put("pageSize", pageSize);
			return sysRoleDao.getSysRole_All(map);	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 修改用户
	 * @param sysRole
	 * @return
	 */
	public int updateSysRole(SysRole sysRole,final List<SysRoleAuth> list){
		try {
			sysRole.setUpdatedTime(new Date());
			if(sysRoleAuthDao.deleteRoleAuth(sysRole.getRoleId())>=0){
				/** 新开一个线程 添加关联一股信息-->>角色与权限**/
				Thread thread = new Thread(new Runnable() {
					public void run() {
						for(SysRoleAuth roleAuth:list){
							sysRoleAuthDao.addRoleAuth(roleAuth);
						}
					}
				});
				thread.start();
			}
			return sysRoleDao.updateSysRole(sysRole);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * 添加系统角色
	 * @param sysRole
	 * @return
	 */
	public int addSysRole(SysRole sysRole,final String sysRoleAuth){
		try {
			sysRole.setIsEffective(1);
			sysRole.setCreatedTime(new Date());
			sysRole.setUpdatedTime(new Date());
			if(sysRoleDao.addSysRole(sysRole)>0){
				/*** 获得要添加的权限 start ***/
				String authIdArray[] = sysRoleAuth.split(",");
				final List<SysRoleAuth> roleAuthlist = new ArrayList<SysRoleAuth>();
				for(int authIdIndex=0;authIdIndex<authIdArray.length;authIdIndex++){
					SysRoleAuth ra = new SysRoleAuth();
					ra.setRoleId(sysRole.getRoleId());
					ra.setAuthId(new BigInteger(authIdArray[authIdIndex]));
					roleAuthlist.add(ra);
				}
				for (SysRoleAuth roleAuth : roleAuthlist) {
					sysRoleAuthDao.addRoleAuth(roleAuth);
				}
				/*** 获得要添加的权限 end ***/
			}else{
				System.out.println("权限设置失败!!!");
			}
			return Integer.parseInt(sysRole.getRoleId().toString());
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * 查询数量
	 * @param sysRole
	 * @return
	 */
	public int getCount(SysRole sysRole){
		try {
			return sysRoleDao.getCount(sysRole);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/**
	 * 删除 
	 * @param roleId
	 * @return
	 */
	public int deleteRole(BigInteger roleId){
		try {
			sysRoleAuthDao.deleteRoleAuth(roleId);
			return sysRoleDao.deleteRole(roleId);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
