package pers.zheng.blog.service;

import com.redfin.sitemapgenerator.ChangeFreq;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.ArticleDao;
import pers.zheng.blog.model.vo.ArticleItemVO;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/22
 */
@Slf4j
@Service
public class SeoService {
    @Value("${domain}")
    private String domain;

    @Autowired
    private ArticleDao articleDao;

    public String createSiteMapXmlContent() {
        String baseUrl = domain;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        WebSitemapGenerator wsg = null;
        try {
            wsg = new WebSitemapGenerator(baseUrl);
            // 首页 url
            WebSitemapUrl url = new WebSitemapUrl.Options(baseUrl + "")
                    .lastMod(dateTimeFormatter.format(LocalDateTime.now())).priority(1.0).changeFreq(ChangeFreq.DAILY).build();
            wsg.addUrl(url);

            // 查询所有的问题方案数据
            List<ArticleItemVO> articles = articleDao.listAllArticleSiteMap();
            // 动态添加 url
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            for (ArticleItemVO article : articles) {
                WebSitemapUrl tmpUrl = new WebSitemapUrl.Options(baseUrl + "/article/" + article.getArticleSlug())
                        .lastMod(sd.format(article.getUpdateTime()))
                        .priority(0.9)
                        .changeFreq(ChangeFreq.DAILY).build();
                wsg.addUrl(tmpUrl);
            }
        } catch (Exception e) {
            log.error("create sitemap xml error:", e);
        }
        return String.join("", wsg.writeAsStrings());
    }
}
