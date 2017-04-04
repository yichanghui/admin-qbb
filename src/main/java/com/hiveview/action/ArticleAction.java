package com.hiveview.action;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.hiveview.action.base.BaseController;
import com.hiveview.entity.Article;
import com.hiveview.entity.Paging;
import com.hiveview.service.IArticleService;
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
@RequestMapping("/article")
public class ArticleAction extends BaseController {

    @Autowired
    private IArticleService articleService;


    @RequestMapping(value="/list")
    public String list() {
        return "article/article_list";
    }

    @RequestMapping(value="/page")
    public ModelAndView page(HttpServletRequest request, ModelAndView mav) {
        Paging paging = super.getPaging(request);
        Article article = new Article();
        String title = request.getParameter("title");
        if (StringUtil.isNotEmpty(title)) {
                article.setTitle(title);
        }
        article.setStatus(StatusUtil.VALID.getVal());
        Page<Object> page = PageHelper.startPage(paging.getCurrentPage(), paging.getPageSize());
        List<Article> articles =  articleService.getArticleList(article);
        paging.setTotalPages(page.getPages());
        mav.getModel().put("paging",paging);
        mav.getModel().put("articles",articles);
        mav.setViewName("article/paging");
        return mav;
    }

    @RequestMapping(value="/toAdd/{articleId}")
    public ModelAndView toAdd(ModelAndView mav, @PathVariable("articleId")long articleId) {
        if (articleId >0) {
            Article article = articleService.getArticleById(articleId);
            mav.getModel().put("article", article);
        }
        mav.setViewName("article/article_add");
        return mav;
    }

    /**
     * 添加文章
     */
    @ResponseBody
    @RequestMapping(value="/addOrUpdate")
    public Boolean addOrUpdateArticle(HttpServletRequest request,Article article) {
        Boolean flag = false;
        try {
            if (article.getId() == null ) {
                article.setAddTime(new Date());
                article.setOperatorId(super.getSysUserId(request));
                articleService.saveArticle(article);
            }else {
                article.setUpdateTime(new Date());
                article.setOperatorId(super.getSysUserId(request));
                articleService.updateArticle(article);
            }
            flag = true;
        } catch (Exception e) {
            LogMgr.writeErrorLog(e);
        }
        return flag;
    }
    @ResponseBody
    @RequestMapping(value="/delete")
    public Boolean delete(HttpServletRequest request) {
        String articleId = request.getParameter("articleId");
        Boolean flag = false;
        if (StringUtils.isNotEmpty(articleId)) {
            try {
                Article article = new Article();
                article.setId(Long.parseLong(articleId));
                article.setUpdateTime(new Date());
                article.setOperatorId(super.getSysUserId(request));
                article.setStatus(StatusUtil.INVALID.getVal());
                articleService.updateArticle(article);
                flag = true;
            } catch (Exception e) {
                LogMgr.writeErrorLog(e);
            }
        }
        return flag;
    }

}
