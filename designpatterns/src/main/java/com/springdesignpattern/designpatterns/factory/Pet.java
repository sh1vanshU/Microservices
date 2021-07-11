/**
 * 
 */
package com.springdesignpattern.designpatterns.factory;

/**
 * @author shivanshu.gua
 *
 */
public interface Pet {
	void setName(String name);
	String getName();
	String getType();
	boolean isHungry();
	void feed();
}
