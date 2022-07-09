package com.vtiger.genericUtility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListenerImplementationClass implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(com.vtiger.genericUtility.RetryImplementation.class);
	}

}
