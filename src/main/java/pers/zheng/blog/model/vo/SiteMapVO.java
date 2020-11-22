package pers.zheng.blog.model.vo;

import lombok.Data;
import org.thymeleaf.util.DateUtils;

import java.util.Date;
import java.util.Locale;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/22
 */
@Data
public class SiteMapVO {
    private String loc;
    private Date lastmod;
    private String changefreq;
    private String priority;

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("<url>");
        sb.append("<loc>" + loc + "</loc>");
        sb.append("<lastmod>" + DateUtils.format(lastmod, "yyyy-MM-dd", Locale.SIMPLIFIED_CHINESE) + "</lastmod>");
        sb.append("<changefreq>" + changefreq + "</changefreq>");
        sb.append("<priority>" + priority + "</priority>");
        sb.append("</url>");
        return sb.toString();
    }
}
