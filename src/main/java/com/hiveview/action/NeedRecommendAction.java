package com.hiveview.action;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.hiveview.action.base.BaseController;
import com.hiveview.entity.Need;
import com.hiveview.entity.NeedRecommend;
import com.hiveview.entity.Paging;
import com.hiveview.service.INeedRecommendService;
import com.hiveview.service.INeedService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import utils.StatusUtil;
import utils.log.LogMgr;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/needRecommend")
public class NeedRecommendAction extends BaseController {

    @Autowired
    private INeedRecommendService needRecommendService;
    @Autowired
    private INeedService needService;


    @RequestMapping(value="/list")
    public String list() {
        return "needRecommend/recommend_list";
    }

    @RequestMapping(value="/toSetting/{type}/{needId}")
    public ModelAndView toSetting(@PathVariable("type")String type,@PathVariable("needId")long needId,ModelAndView mav) {
        NeedRecommend needRecommend;
        if (!"add".equals(type)) {
            needRecommend = needRecommendService.getNeedRecommendByNId(needId);
        }else {
            needRecommend = new NeedRecommend();
            needRecommend.setNeedId(needId);
        }
        mav.getModel().put("needRecommend", needRecommend);
        mav.setViewName("needRecommend/setting");
        return mav;
    }


    @RequestMapping(value="/page")
    public ModelAndView page(HttpServletRequest request, ModelAndView mav) {
        Paging paging = super.getPaging(request);
        NeedRecommend needRecommend = new NeedRecommend();
        String needName = request.getParameter("needName");
        if (StringUtil.isNotEmpty(needName)) {
                needRecommend.setNeedName(needName);
        }
        needRecommend.setStatus(StatusUtil.VALID.getVal());
        Page<Object> page = PageHelper.startPage(paging.getCurrentPage(), paging.getPageSize());
        List<NeedRecommend> needRecommends =  needRecommendService.getNeedRecommendPage(needRecommend);
        paging.setTotalPages(page.getPages());
        mav.getModel().put("paging",paging);
        mav.getModel().put("needRecommends",needRecommends);
        mav.setViewName("needRecommend/paging");
        return mav;
    }


    @RequestMapping(value="/needList")
    public String needList() {
        return "needRecommend/need_list";
    }

    @RequestMapping(value="/needPage")
    public ModelAndView prductPage(HttpServletRequest request, ModelAndView mav) {
        Paging paging = super.getPaging(request);
        Page<Object> page = PageHelper.startPage(paging.getCurrentPage(), paging.getPageSize());
        Need need = new Need();
        String needName = request.getParameter("needName");
        if (StringUtil.isNotEmpty(needName)) {
            need.setTitle(needName);
        }
        need.setStatus(StatusUtil.CHECK_SUCCESS.getVal());
        need.setRecommendShow(true);
        List<Need> needs =  needService.getNeedPage(need);
        paging.setTotalPages(page.getPages());
        mav.getModel().put("paging",paging);
        mav.getModel().put("needs",needs);
        mav.setViewName("needRecommend/need_paging");
        return mav;
    }

    /**
     * 添加推荐
     */
    @ResponseBody
    @RequestMapping(value="/addRecommend")
    public Boolean addRecommend(HttpServletRequest request,NeedRecommend needRecommend) {
        Boolean flag = false;
        Long needId = needRecommend.getNeedId();
        if (needId != null ) {
            try {
                NeedRecommend isHave = needRecommendService.getNeedRecommendByNId(needId);
                Long nrId = needRecommend.getId();
                if (isHave == null || nrId != null) {
                    if (nrId == null) {
                        needRecommend.setAddTime(new Date());
                        needRecommend.setOperatorId(super.getSysUserId(request));
                        needRecommendService.saveRecommend(needRecommend);
                    } else {
                        needRecommend.setUpdateTime(new Date());
                        needRecommend.setOperatorId(super.getSysUserId(request));
                        needRecommendService.updateRecommend(needRecommend);
                    }
                }
                flag = true;
            } catch (Exception e) {
                LogMgr.writeErrorLog(e);
            }
        }
        return flag;
    }
    @ResponseBody
    @RequestMapping(value="/delete")
    public Boolean delete(HttpServletRequest request) {
        String recommendId = request.getParameter("recommendId");
        Boolean flag = false;
        if (StringUtils.isNotEmpty(recommendId)) {
            try {
                needRecommendService.deleteById(Long.parseLong(recommendId));
                flag = true;
            } catch (Exception e) {
                LogMgr.writeErrorLog(e);
            }
        }
        return flag;
    }


}
