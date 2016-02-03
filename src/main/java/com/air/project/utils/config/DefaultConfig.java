package com.air.project.utils.config;

/**
 * @author yh
 * 2015年12月22日下午10:37:04
 *  
 */
public class DefaultConfig extends AbstractConfig implements Config{

	
	private String url;
	
	private int method;
	
	private DefaultConfig(){
	}
	private DefaultConfig(String url){
		this.url=url;
	}
	private static DefaultConfig create(){
		return new DefaultConfig();
	}
	
	private DefaultConfig(String url,int method){
		this.url=url;
		this.method=method;
	}
	
	private DefaultConfig url(String url){
		 this.url=url;
		 return this;
	}
	private  DefaultConfig method(int method){
		 this.method=method;
		 return this;
	}
	
	public static void main(String[] args) {
		DefaultConfig.create().url("").method(1);
	}
}
