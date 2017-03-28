package com.hiveview.action;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.hiveview.action.base.BaseController;
import com.hiveview.entity.Category;
import com.hiveview.entity.Paging;
import com.hiveview.entity.Product;
import com.hiveview.service.ICategoryService;
import com.hiveview.service.IProductService;
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
@RequestMapping("/product")
public class ProductAction extends BaseController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductService productService;



    @RequestMapping(value="/list")
    public String list() {
        return "product/product_list";
    }
    @RequestMapping(value="/toApproval/{id}")
    public ModelAndView toApproval(@PathVariable("id") long id,ModelAndView mav) {
        mav.getModel().put("productId", id);
        mav.setViewName("product/approval");
        return mav;
    }
    @RequestMapping(value="/page")
    public ModelAndView page(HttpServletRequest request, ModelAndView mav) {
        Paging paging = super.getPaging(request);
        Product product = new Product();
        String status = request.getParameter("status");
        if (StringUtil.isNotEmpty(status)) {
            Integer stat = Integer.parseInt(status);
            if (stat > 0) {
                product.setStatus(stat);
            }
        }
        Page<Object> page = PageHelper.startPage(paging.getCurrentPage(), paging.getPageSize());
        List<Product> products =  productService.getProductPage(product);
        paging.setTotalPages(page.getPages());
        mav.getModel().put("paging",paging);
        mav.getModel().put("products",products);
        mav.setViewName("product/paging");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value="/operation")
    public Boolean operation(HttpServletRequest request,Product product) {
        Boolean flag = false;
        Integer status = product.getStatus();
        if (product.getId() != null  && status != null && status >0) {
            try {
                productService.updateProduct(product);
                flag = true;
            } catch (Exception e) {
                LogMgr.writeErrorLog(e);
            }
        }
        return flag;
    }


    @RequestMapping(value="/toAdd/{productId}")
    public ModelAndView add(ModelAndView mav, @PathVariable("productId") Long productId) {
        Category category = new Category();
//        category.setLevel(LevelUtil.ONE_LEVEL.getVal());
        List<Category> oneLevelCategories = categoryService.getCategory(category);
        if (productId > 0 ) {
            Product product= productService.getProductById(productId);
            Category selectClass = categoryService.getCategoryById(product.getClassId());

            List<Category> twoLevelCategories = null;//二级类目
            List<Category> threeLevelCategories = null;//三级类目
            String code = selectClass.getCode();
            if (code!= null) {
                String[] ids = code.split("-");
                for (int i = 0; i < ids.length; i++) {
                    Long id = Long.parseLong(ids[i]);
                    if (i == 0 ) {
                        twoLevelCategories = categoryService.getSonCategory(id);
                        selectClass.setOneLevel(id);
                    }
                    if (i == 1) {
                        threeLevelCategories = categoryService.getSonCategory(id);
                        selectClass.setTwoLevel(id);
                    }
                    if (i == 2) {
                        selectClass.setThreeLevel(id);
                    }
                }
            }
            mav.getModel().put("selectClass", selectClass);
            mav.getModel().put("product", product);
            mav.getModel().put("twoLevelCategories", twoLevelCategories);
            mav.getModel().put("threeLevelCategories", threeLevelCategories);
        }
        mav.getModel().put("oneLevelCategories", oneLevelCategories);
        mav.setViewName("product/product_add");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value="/add")
    public Boolean addOrUpdate(HttpServletRequest request,Product product) {
        Boolean flag = false;
        long memberId = 0L;
        if (memberId > 0 ) {
            try {
                product.setMemberId(memberId);
                long companyId = 0L;
                if (companyId > 0) {
                    product.setCompanyId(companyId);
                }
                product.setStatus(StatusUtil.CHECKING.getVal());
                if (product.getId() != null) {
                    product.setUpdateTime(new Date());
                    productService.updateProduct(product);
                } else {
                    product.setAddTime(new Date());
                    productService.saveProduct(product);
                }
                flag = true;
            } catch (Exception e) {
                LogMgr.writeErrorLog(e);
            }
        }
        return flag;
    }


    @RequestMapping(value="/update")
    public String update(HttpServletRequest request) {
        request.setAttribute("nav","myshop");
        return "product/product_update";
    }

    @RequestMapping(value="/toSuccess")
    public String toSuccess() {
        return "product/success";
    }


}
