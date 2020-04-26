package io.github.elementera;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

interface Loggers {
	Logger proxys = LogManager.getLogger("proxy"); Logger itemreg= LogManager.getLogger("items register");
}
