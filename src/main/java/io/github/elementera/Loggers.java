package io.github.elementera;

import org.apache.logging.log4j.*;


public interface Loggers {
	Logger proxys = LogManager.getLogger("proxy"); Logger itemreg= LogManager.getLogger("items register");
	Logger blockreg = LogManager.getLogger("block register"); Logger configs = LogManager.getLogger("Config");
	Logger itemdelete = LogManager.getFormatterLogger("item delete");
}
