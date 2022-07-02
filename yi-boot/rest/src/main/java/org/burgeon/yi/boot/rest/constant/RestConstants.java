package org.burgeon.yi.boot.rest.constant;

import java.util.regex.Pattern;

/**
 * @author Sam Lu
 * @date 2022/07/02
 */
public class RestConstants {

    /**
     * 静态资源Pattern
     */
    public static final Pattern PATTERN_STATIC_URI = Pattern.compile("^/\\w+(/\\w+)*\\.html$");

}
