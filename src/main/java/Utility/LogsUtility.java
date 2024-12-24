package Utility;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogsUtility {
	
	public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);

}}
