package com.hiveview.action;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.google.common.collect.Lists;
import com.hiveview.action.base.BaseController;
import com.hiveview.entity.ApprovalRecord;
import com.hiveview.entity.Paging;
import com.hiveview.entity.Category;
import com.hiveview.service.IApprovalRecordService;
import com.hiveview.service.ICategoryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import utils.IssueType;
import utils.log.LogMgr;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/category")
public class CategoryAction extends BaseController {

    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IApprovalRecordService approvalRecordService;



    @RequestMapping(value="/list")
    public String list() {
        return "category/category_list";
    }

    /**
     * 去审批
     * @param id
     * @param mav
     * @return
     */
    @RequestMapping(value="/toApproval/{id}")
    public ModelAndView toApproval(@PathVariable("id") long id,ModelAndView mav) {
        Category category = categoryService.getCategoryById(id);
        mav.getModel().put("category", category);
        mav.setViewName("category/approval");
        return mav;
    }
    @RequestMapping(value="/page")
    public ModelAndView page(HttpServletRequest request, ModelAndView mav) {
        Paging paging = super.getPaging(request);
        Category category = new Category();
        String categoryName = request.getParameter("categoryName");
        if (StringUtil.isNotEmpty(categoryName)) {
                category.setName(categoryName);
        }
        String categoryLevel = request.getParameter("categoryLevel");
        if (StringUtil.isNotEmpty(categoryLevel)) {
                category.setLevel(Integer.parseInt(categoryLevel));
        }
        Page<Object> page = PageHelper.startPage(paging.getCurrentPage(), paging.getPageSize());
        List<Category> categorys =  categoryService.getCategory(category);
        paging.setTotalPages(page.getPages());
        mav.getModel().put("paging",paging);
        mav.getModel().put("categorys",categorys);
        mav.setViewName("category/paging");
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
            approvalRecord.setType(IssueType.PRODUCT.getVal());
            approvalRecord.setRelateId(Long.parseLong(relateId));
            Page<Object> page = PageHelper.startPage(paging.getCurrentPage(), paging.getPageSize());
            List<ApprovalRecord> approvalRecords =  approvalRecordService.getApprovalList(approvalRecord);
            paging.setTotalPages(page.getPages());
            mav.getModel().put("paging",paging);
            mav.getModel().put("approvalRecords",approvalRecords);
        }
        mav.setViewName("category/approvalPage");
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
                approvalRecord.setType(IssueType.PRODUCT.getVal());
                approvalRecord.setOperationId(super.getSysUserId(request));
                approvalRecordService.saveApproval(approvalRecord);
                Category category = new Category();
                category.setId(approvalRecord.getRelateId());
                category.setStatus(status);
                categoryService.updateCategory(category);
                flag = true;
            } catch (Exception e) {
                LogMgr.writeErrorLog(e);
            }
        }
        return flag;
    }
    @ResponseBody
    @RequestMapping(value="/operation")
    public Boolean operation(Category category) {
        Boolean flag = false;
        if (category.getId() != null) {
            try {
                category.setUpdateTime(new Date());
                categoryService.updateCategory(category);
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
        Boolean flag = false;
        String code = request.getParameter("code");
        if (StringUtils.isNotEmpty(code)) {
            try {
                Category category = new Category();
                category.setCode(code);
                List<Category> categorys = categoryService.getCategory(category);
//                List<Long> ids = categorys.stream().map(category1 -> category1.getId()).collect(Collectors.toList());
                List<Long> ids = Lists.newArrayList();
                for (Category tempCategory : categorys) {
                    ids.add(tempCategory.getId());
                }
                categoryService.batchDelete(ids);
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
        Category category = categoryService.getCategoryById(id);
        mav.getModel().put("category", category);
        mav.setViewName("category/setting");
        return mav;
    }


}
