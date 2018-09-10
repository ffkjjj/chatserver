package com.iremote.chatserver.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * @author jwzh
 */
public class LogUtils{
	private static Log log = LogFactory.getLog(LogUtils.class);

	public static void info(String format  , Object... args){
	    if (!log.isInfoEnabled()) {
	        return;
	    }
	    log.info(String.format(format, args));
	}
}
