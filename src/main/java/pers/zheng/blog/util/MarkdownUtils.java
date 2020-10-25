package pers.zheng.blog.util;

import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.util.misc.Extension;

import java.util.Arrays;

/**
 * @ClassName StringUtils
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/25 15:30
 * @Version 1.0
 */
public class MarkdownUtils {
    private static final String SUMMARY_TAG = "<!--more-->";

    public static String getSummaryInMD(String md) {
        int summaryTagIndex = md.indexOf(SUMMARY_TAG);
        if (summaryTagIndex == -1) {
            return "";
        } else {
            return md.substring(0, summaryTagIndex);
        }
    }

    public static String mdToHtml(String md) {
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);
        options.set(Parser.EXTENSIONS, Arrays.asList(new Extension[]{TablesExtension.create()}));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Node document = parser.parse(md);
        return renderer.render(document);
    }
}
