package com.hiveview.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hxq on 2017/3/29.
 */
@Controller
@RequestMapping("/approva")
public class ApprovalAction {

    @RequestMapping(value="/toApproval/{type}/{id}")
    public ModelAndView toApproval(@PathVariable("id") long id, ModelAndView mav) {
        mav.getModel().put("productId", id);
        mav.setViewName("product/approval");
        return mav;
    }
}
