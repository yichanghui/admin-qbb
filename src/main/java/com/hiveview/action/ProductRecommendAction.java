package com.hiveview.action;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.hiveview.action.base.BaseController;
import com.hiveview.entity.Paging;
import com.hiveview.entity.Product;
import com.hiveview.entity.ProductRecommend;
import com.hiveview.service.IProductRecommendService;
import com.hiveview.service.IProductService;
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
@RequestMapping("/productRecommend")
public class ProductRecommendAction extends BaseController {

    @Autowired
    private IProductRecommendService productRecommendService;
    @Autowired
    private IProductService productService;


    @RequestMapping(value="/list")
    public String list() {
        return "productRecommend/recommend_list";
    }

    @RequestMapping(value="/toSetting/{type}/{productId}")
    public ModelAndView toSetting(@PathVariable("type")String type,@PathVariable("productId")long productId,ModelAndView mav) {
        ProductRecommend productRecommend;
        if (!"add".equals(type)) {
            productRecommend = productRecommendService.getProductRecommendByPId(productId);
        }else {
            productRecommend = new ProductRecommend();
            productRecommend.setProductId(productId);
        }
        mav.getModel().put("productRecommend", productRecommend);
        mav.setViewName("productRecommend/setting");
        return mav;
    }


    @RequestMapping(value="/page")
    public ModelAndView page(HttpServletRequest request, ModelAndView mav) {
        Paging paging = super.getPaging(request);
        ProductRecommend productRecommend = new ProductRecommend();
        String productName = request.getParameter("productName");
        if (StringUtil.isNotEmpty(productName)) {
                productRecommend.setProductName(productName);
        }
        productRecommend.setStatus(StatusUtil.VALID.getVal());
        Page<Object> page = PageHelper.startPage(paging.getCurrentPage(), paging.getPageSize());
        List<ProductRecommend> productRecommends =  productRecommendService.getProductRecommendPage(productRecommend);
        paging.setTotalPages(page.getPages());
        mav.getModel().put("paging",paging);
        mav.getModel().put("productRecommends",productRecommends);
        mav.setViewName("productRecommend/paging");
        return mav;
    }


    @RequestMapping(value="/productList")
    public String productList() {
        return "productRecommend/product_list";
    }

    @RequestMapping(value="/productPage")
    public ModelAndView prductPage(HttpServletRequest request, ModelAndView mav) {
        Paging paging = super.getPaging(request);
        Page<Object> page = PageHelper.startPage(paging.getCurrentPage(), paging.getPageSize());
        Product product = new Product();
        String productName = request.getParameter("productName");
        if (StringUtil.isNotEmpty(productName)) {
            product.setTitle(productName);
        }
        product.setStatus(StatusUtil.CHECK_SUCCESS.getVal());
        product.setRecommendShow(true);
        List<Product> products =  productService.getProductPage(product);
        paging.setTotalPages(page.getPages());
        mav.getModel().put("paging",paging);
        mav.getModel().put("products",products);
        mav.setViewName("productRecommend/product_paging");
        return mav;
    }

    /**
     * 添加推荐
     */
    @ResponseBody
    @RequestMapping(value="/addRecommend")
    public Boolean addRecommend(HttpServletRequest request,ProductRecommend productRecommend) {
        Boolean flag = false;
        Long productId = productRecommend.getProductId();
        if (productId != null ) {
            try {
                ProductRecommend isHave = productRecommendService.getProductRecommendByPId(productId);
                Long prId = productRecommend.getId();
                if (isHave == null || prId != null) {
                    if (prId == null) {
                        productRecommend.setAddTime(new Date());
                        productRecommend.setOperatorId(super.getSysUserId(request));
                        productRecommendService.saveRecommend(productRecommend);
                    } else {
                        productRecommend.setUpdateTime(new Date());
                        productRecommend.setOperatorId(super.getSysUserId(request));
                        productRecommendService.updateRecommend(productRecommend);
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
                productRecommendService.deleteById(Long.parseLong(recommendId));
                flag = true;
            } catch (Exception e) {
                LogMgr.writeErrorLog(e);
            }
        }
        return flag;
    }


}
