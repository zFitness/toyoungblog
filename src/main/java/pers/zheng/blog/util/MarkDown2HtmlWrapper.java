package pers.zheng.blog.util;

import com.google.common.base.Joiner;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.ext.toc.SimTocExtension;
import com.vladsch.flexmark.ext.toc.TocExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import lombok.extern.slf4j.Slf4j;
import pers.zheng.blog.model.util.MarkdownEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName MarkDown2HtmlWrapper
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/26 8:08
 * @Version 1.0
 */
@Slf4j
public class MarkDown2HtmlWrapper {

    private static MutableDataSet options = null;
    private static Parser parser;
    private static HtmlRenderer renderer;

    static {
        try {
            options = new MutableDataSet();
            options.setFrom(ParserEmulationProfile.MARKDOWN);
            // enable table parse!
            options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(),
                    TocExtension.create(),
                    SimTocExtension.create()))
                    .set(TocExtension.LEVELS, 255)
                    .set(TocExtension.TITLE, "目录")
                    .set(TocExtension.DIV_CLASS, "toc");


            parser = Parser.builder(options).build();
            renderer = HtmlRenderer.builder(options).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 将流转为html文档输出
     *
     * @param stream 流
     * @return MarkDownEntity
     */
    public static MarkdownEntity ofStream(InputStream stream) {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(stream, Charset.forName("UTF-8")));
        List<String> lines = bufferedReader.lines().collect(Collectors.toList());
        String content = Joiner.on("\n").join(lines);
        return ofContent(content);
    }


    /**
     * 直接将markdown语义的文本转为html格式输出
     *
     * @param content markdown语义文本
     * @return
     */
    public static MarkdownEntity ofContent(String content) {
        String html = parse(content);
        MarkdownEntity entity = new MarkdownEntity();
        entity.setHtml(html);
        entity.setHtmlTOC(parseTOC(content));
        entity.addDivStyle("id", "write");
        return entity;
    }


    /**
     * markdown to image
     *
     * @param content markdown contents
     * @return parse html contents
     */
    public static String parse(String content) {
        Node document = parser.parse(content);
        return renderer.render(document);
    }

    /**
     * 从markdo文章中获取目录
     *
     * @param content markdown 文章
     * @return 目录html
     */
    public static String parseTOC(String content) {
        Node document = parser.parse("[TOC]\n" + content);
        String html = renderer.render(document);
        String toc = "";
        if (!html.contains("<div class=\"toc\">")) {
            toc = null;
        } else {
            toc = html.substring(0, 6 + html.indexOf("</div>"));
        }
        return toc;
    }

}
