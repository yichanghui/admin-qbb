package com.hiveview.action;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.hiveview.action.base.BaseController;
import com.hiveview.entity.ApprovalRecord;
import com.hiveview.entity.Member;
import com.hiveview.entity.Paging;
import com.hiveview.service.IApprovalRecordService;
import com.hiveview.service.IMemberService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import utils.IssueType;
import utils.MemberType;
import utils.log.LogMgr;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/member")
public class AdviserAction extends BaseController {

    @Autowired
    private IMemberService memberService;
    @Autowired
    private IApprovalRecordService approvalRecordService;



    @RequestMapping(value="/list")
    public String list() {
        return "member/member_list";
    }

    /**
     * 去审批
     * @param id
     * @param mav
     * @return
     */
    @RequestMapping(value="/toApproval/{id}")
    public ModelAndView toApproval(@PathVariable("id") long id,ModelAndView mav) {
        Member member = memberService.getMemberById(id);
        mav.getModel().put("member", member);
        mav.setViewName("member/approval");
        return mav;
    }
    @RequestMapping(value="/page")
    public ModelAndView page(HttpServletRequest request, ModelAndView mav) {
        Paging paging = super.getPaging(request);
        Member member = new Member();
        String checkStatus = request.getParameter("checkStatus");
        if (StringUtil.isNotEmpty(checkStatus)) {
                member.setCheckStatus(Integer.parseInt(checkStatus));
        }
        member.setType(MemberType.ADVISER.getVal());
        Page<Object> page = PageHelper.startPage(paging.getCurrentPage(), paging.getPageSize());
        List<Member> members =  memberService.getOpendMemberPage(member);
        paging.setTotalPages(page.getPages());
        mav.getModel().put("paging",paging);
        mav.getModel().put("members",members);
        mav.setViewName("member/paging");
        return mav;
    }

    /**
     * 审批记录列表
     * @param request
     * @param mav
     * @return
     */
    @RequestMapping(value="/approvalPage")
    public ModelAndView approvalPage(HttpServletRequest request, ModelAndView mav) {
        Paging paging = super.getPaging(request);
        String relateId = request.getParameter("relateId");
        if (StringUtils.isNotEmpty(relateId)) {
            ApprovalRecord approvalRecord = new ApprovalRecord();
            approvalRecord.setType(IssueType.ADVISER.getVal());
            approvalRecord.setRelateId(Long.parseLong(relateId));
            Page<Object> page = PageHelper.startPage(paging.getCurrentPage(), paging.getPageSize());
            List<ApprovalRecord> approvalRecords =  approvalRecordService.getApprovalList(approvalRecord);
            paging.setTotalPages(page.getPages());
            mav.getModel().put("paging",paging);
            mav.getModel().put("approvalRecords",approvalRecords);
        }
        mav.setViewName("member/approvalPage");
        return mav;
    }

    /**
     * 添加审批记录
     * @param request
     * @param approvalRecord
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/approval")
    public Boolean approval(HttpServletRequest request,ApprovalRecord approvalRecord) {
        Boolean flag = false;
        Integer status = approvalRecord.getStatus();
        if (approvalRecord.getRelateId() != null  && status != null && status >0) {
            try {
                approvalRecord.setAddTime(new Date());
                approvalRecord.setType(IssueType.ADVISER.getVal());
                approvalRecord.setOperationId(super.getSysUserId(request));
                approvalRecordService.saveApproval(approvalRecord);
                Member member = new Member();
                member.setId(approvalRecord.getRelateId());
                member.setCheckStatus(status);
                memberService.updateMember(member);
                flag = true;
            } catch (Exception e) {
                LogMgr.writeErrorLog(e);
            }
        }
        return flag;
    }
    @ResponseBody
    @RequestMapping(value="/operation")
    public Boolean operation(Member member) {
        Boolean flag = false;
        if (member.getId() != null) {
            try {
                member.setUpdateTime(new Date());
                memberService.updateMember(member);
                flag = true;
            } catch (Exception e) {
                LogMgr.writeErrorLog(e);
            }
        }
        return flag;
    }

    /**
     * 去设置页面
     * @param id
     * @param mav
     * @return
     */
    @RequestMapping(value="/toSetting/{id}")
    public ModelAndView toSetting(@PathVariable("id") long id,ModelAndView mav) {
        Member member = memberService.getMemberById(id);
        mav.getModel().put("member", member);
        mav.setViewName("member/setting");
        return mav;
    }


}
