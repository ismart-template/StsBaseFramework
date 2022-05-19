/*
 * Copyright 2008-2009 MOPAS(Ministry of Public Administration and Security).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hibiznet.comm.service;

import org.springframework.util.PathMatcher;


/**
 * TraceHandlerService �������̽��� Handler Service �޼ҵ带 �����ϰ� �ִ�.
 * 
 * @author Judd Cho (horanghi@gmail.com)
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << �����̷�(Modification Information) >>
 *   
 *   ������      ������           ��������
 *  -------    --------    ---------------------------
 *   2009.05.30  Judd Cho        ���� ����
 *   2015.01.31 Vincent Han		�ڵ� ǰ�� ���� 
 *
 * </pre>
 */
public interface TraceHandlerService {

	/**
	 * ��Ű��, Ŭ���� �̸����� ���ϵ��(Ant������ ��Ī).
	 * 
	 * @param patterns ���ϸ���Ʈ
	 */

	public void setPatterns(String[] patterns);

	/**
	 * ExceptionHandler ����Ʈ ���.
	 * 
	 * @param handlers handler����Ʈ
	 */
	public void setHandlers(TraceHandler[] handlers);

	/**
	 * ���� Ŭ���� ����.
	 * 
	 * @param canonicalName ���� Ŭ������
	 */
	public void setPackageName(String canonicalName);

	/**
	 * setReqExpMatcher �޼ҵ�.
	 * 
	 * @param pm ����ڿ� ���� ����ϰ����ϴ� PathMatcher 
	 */
	public void setReqExpMatcher(PathMatcher pm);

	/**
	 * PathMatcher �� �ִ��� ���� ��ȯ.
	 * 
	 * @return boolean true|false
	 */
	public boolean hasReqExpMatcher();

	/**
	 * trace �޼ҵ�.
	 * 
	 * @param clazz Ŭ��������
	 * @param message �����ְ����ϴ� �޼���
	 * @return boolean true|false
	 */
	public boolean trace(Class<?> clazz, String message);

}