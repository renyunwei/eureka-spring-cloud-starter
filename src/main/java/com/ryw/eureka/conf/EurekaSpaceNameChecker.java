package com.ryw.eureka.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EurekaSpaceNameChecker {

	private static final Logger logger = LoggerFactory.getLogger(EurekaSpaceNameChecker.class);
	
	//这个参数作为元数据存在，在开发测试环境中用作 SPACE权限控制，如果没有，写上这个参数引入不影响正常运行
	@Value("${eureka.instance.matadataMap.application-space:}")
	private String spaceName;
	
	public void eurekaConfigurationCheck() {
		if (spaceName.isEmpty()) {
			logger.error("Eureka space name is null,please set the value of ${eureka.instance.matadataMap.application-space}");
		}
	}
	
}
