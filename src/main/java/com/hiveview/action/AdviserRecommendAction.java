package com.hiveview.action;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.hiveview.action.base.BaseController;
import com.hiveview.entity.Member;
import com.hiveview.entity.MemberRecommend;
import com.hiveview.entity.Paging;
import com.hiveview.service.IMemberRecommendService;
import com.hiveview.service.IMemberService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import utils.MemberType;
import utils.StatusUtil;
import utils.log.LogMgr;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/memberRecommend")
public class AdviserRecommendAction extends BaseController {

    @Autowired
    private IMemberRecommendService memberRecommendService;
    @Autowired
    private IMemberService memberService;


    @RequestMapping(value="/list")
    public String list() {
        return "memberRecommend/recommend_list";
    }

    @RequestMapping(value="/toSetting/{type}/{memberId}")
    public ModelAndView toSetting(@PathVariable("type")String type,@PathVariable("memberId")long memberId,ModelAndView mav) {
        MemberRecommend memberRecommend;
        if (!"add".equals(type)) {
             memberRecommend = memberRecommendService.getMemberRecommendByMId(memberId);
        }else {
            memberRecommend = new MemberRecommend();
            memberRecommend.setMemberId(memberId);
        }
        mav.getModel().put("memberRecommend", memberRecommend);
        mav.setViewName("memberRecommend/setting");
        return mav;
    }

    @RequestMapping(value="/page")
    public ModelAndView page(HttpServletRequest request, ModelAndView mav) {
        Paging paging = super.getPaging(request);
        MemberRecommend memberRecommend = new MemberRecommend();
        String memberName = request.getParameter("memberName");
        if (StringUtil.isNotEmpty(memberName)) {
                memberRecommend.setMemberName(memberName);
        }
        memberRecommend.setStatus(StatusUtil.VALID.getVal());
        Page<Object> page = PageHelper.startPage(paging.getCurrentPage(), paging.getPageSize());
        List<MemberRecommend> memberRecommends =  memberRecommendService.getMemberRecommendPage(memberRecommend);
        paging.setTotalPages(page.getPages());
        mav.getModel().put("paging",paging);
        mav.getModel().put("memberRecommends",memberRecommends);
        mav.setViewName("memberRecommend/paging");
        return mav;
    }


    @RequestMapping(value="/memberList")
    public String memberList() {
        return "memberRecommend/member_list";
    }

    @RequestMapping(value="/memberPage")
    public ModelAndView memberPage(HttpServletRequest request, ModelAndView mav) {
        Paging paging = super.getPaging(request);
        Page<Object> page = PageHelper.startPage(paging.getCurrentPage(), paging.getPageSize());
        Member member = new Member();
        String memberName = request.getParameter("memberName");
        if (StringUtil.isNotEmpty(memberName)) {
            member.setName(memberName);
        }
        member.setType(MemberType.ADVISER.getVal());
        member.setStatus(StatusUtil.VALID.getVal());
        member.setCheckStatus(StatusUtil.CHECK_SUCCESS.getVal());
        member.setRecommendShow(true);
        List<Member> members =  memberService.getOpendMemberPage(member);
        paging.setTotalPages(page.getPages());
        mav.getModel().put("paging",paging);
        mav.getModel().put("members",members);
        mav.setViewName("memberRecommend/member_paging");
        return mav;
    }

    /**
     * 添加推荐
     */
    @ResponseBody
    @RequestMapping(value="/addRecommend")
    public Boolean addRecommend(HttpServletRequest request,MemberRecommend memberRecommend) {
        Boolean flag = false;
        Long memberId = memberRecommend.getMemberId();
        try {
            if (memberId != null) {
                MemberRecommend isHave = memberRecommendService.getMemberRecommendByMId(memberId);//查看是否已有推荐记录
                Long rmId = memberRecommend.getId();
                if (isHave == null || rmId != null) {
                    if (rmId == null) {
                        memberRecommend.setAddTime(new Date());
                        memberRecommend.setOperatorId(super.getSysUserId(request));
                        memberRecommendService.saveRecommend(memberRecommend);
                    }else {
                        memberRecommend.setUpdateTime(new Date());
                        memberRecommend.setOperatorId(super.getSysUserId(request));
                        memberRecommendService.updateRecommend(memberRecommend);
                    }
                }
                flag = true;
            }
        } catch (Exception e) {
            LogMgr.writeErrorLog(e);
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
                memberRecommendService.deleteById(Long.parseLong(recommendId));
                flag = true;
            } catch (Exception e) {
                LogMgr.writeErrorLog(e);
            }
        }
        return flag;
    }

}
