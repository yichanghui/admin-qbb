package com.hiveview.action;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.hiveview.action.base.BaseController;
import com.hiveview.entity.Member;
import com.hiveview.entity.Paging;
import com.hiveview.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import utils.MemberType;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/allMember")
public class MemberAction extends BaseController {

    @Autowired
    private IMemberService memberService;


    @RequestMapping(value="/list")
    public String list() {
        return "allMember/member_list";
    }

    @RequestMapping(value="/page")
    public ModelAndView page(HttpServletRequest request, ModelAndView mav) {
        Paging paging = super.getPaging(request);
        Member member = new Member();
        String memberName = request.getParameter("memberName");
        if (StringUtil.isNotEmpty(memberName)) {
                member.setName(memberName);
        }
        Page<Object> page = PageHelper.startPage(paging.getCurrentPage(), paging.getPageSize());
        List<Member> members =  memberService.getMemberList(member);
        paging.setTotalPages(page.getPages());
        mav.getModel().put("paging",paging);
        mav.getModel().put("members",members);
        mav.setViewName("allMember/paging");
        return mav;
    }

}
