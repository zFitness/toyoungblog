package pers.zheng.blog.util;

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
}
