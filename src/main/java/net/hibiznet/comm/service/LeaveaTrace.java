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

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * LeaveaTrace.
 *
 * <p><b>NOTE:</b> LeaveaTrace Ŭ������ ������ Exception �� �߻����� �ʰ� ��ó���������� �����ϰ��� ���������.
 * EgovAbstractServiceImpl �� ��ӹ��� ��� leavaTrace(�޼���Ű) ���·� ������ �ϸ� ������ ��ϵ� ��ó�� ������ �����Ѵ�.
 * �׸��� ���� ���� �������� ���ƿ� ������ ������ �Ѵ�. </p>
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
public class LeaveaTrace {

	@Resource(name = "messageSource")
	private MessageSource messageSource;

	private TraceHandlerService[] traceHandlerServices;

	private PathMatcher pm = new AntPathMatcher();

	/**
	 * setTraceHandlerServices.
	 * 
	 * @param traceHandlerServices �����ϰ��� �ϴ� Handler �� ���� Manager����
	 */
	public void setTraceHandlerServices(TraceHandlerService[] traceHandlerServices) {
		this.traceHandlerServices = traceHandlerServices;
	}

	/**
	 * ��ϵ� TraceHandlerService ������ �����Ѵ�.
	 * @return TraceHandlerService ����
	 */
	public int countOfTheTraceHandlerService() {
		return (traceHandlerServices != null) ? traceHandlerServices.length : 0;
	}

	/**
	 * trace �޼ҵ�.
	 * 
	 * @param msgKey �޼����� �������� ���� �޼���Ű��
	 * @param clazz leaveaTrace ���� ��ġ�� Ŭ���� ����
	 */
	public void trace(String msgKey, Class<?> clazz) {
		this.trace(msgKey, new String[] {}, clazz);
	}

	/**
	 * trace �޼ҵ�.
	 * 
	 * @param msgKey �޼����� �������� ���� �޼���Ű��
	 * @param msgArgs �޼��� ���� ������ ġȯ�ϱ� ���� ������Ʈ
	 * @param clazz leaveaTrace ���� ��ġ�� Ŭ���� ����
	 */
	public void trace(String msgKey, String[] msgArgs, Class<?> clazz) {
		this.trace(msgKey, msgArgs, null, clazz);
	}

	/**
	 * trace �޼ҵ�.
	 * 
	 * @param msgKey �޼����� �������� ���� �޼���Ű��
	 * @param msgArgs �޼��� ���� ������ ġȯ�ϱ� ���� ������Ʈ
	 * @param clazz leaveaTrace ���� ��ġ�� Ŭ���� ����
	 */
	public void trace(String msgKey, String[] msgArgs, Locale locale, Class<?> clazz) {
		this.trace(clazz, messageSource, msgKey, msgArgs, locale, null);
	}

	/**
	 * trace �޼ҵ�.
	 * 
	 * @param clazz leaveaTrace ���� ��ġ�� Ŭ���� ����
	 * @param messageKey �޼����� �������� ���� �޼���Ű��
	 * @param messageParameters �޼��� ���� ������ ġȯ�ϱ� ���� ������Ʈ
	 * @param locale ����/�������
	 */
	public void trace(Class<?> clazz, MessageSource messageSource, String messageKey, Object[] messageParameters, Locale locale) {
		this.trace(clazz, messageSource, messageKey, messageParameters, locale, null);
	}

	/**
	 * trace �޼ҵ�.
	 * 
	 * @param clazz leaveaTrace ���� ��ġ�� Ŭ���� ����
	 * @param messageKey �޼����� �������� ���� �޼���Ű��
	 * @param messageParameters �޼��� ���� ������ ġȯ�ϱ� ���� ������Ʈ
	 * @param locale ����/�������
	 * @param log �αװ�ü����
	 */
	public void trace(Class<?> clazz, MessageSource messageSource, String messageKey, Object[] messageParameters, Locale locale, Logger log) {

		String message = messageSource.getMessage(messageKey, messageParameters, null, locale);

		if (log != null) {
			log.info(" LeaveaTrace.trace() this.message =>" + message);
		}

		if (traceHandlerServices == null) {
			return;
		}
		
		for (TraceHandlerService traceHandlerService : traceHandlerServices) {
			if (traceHandlerService.hasReqExpMatcher()) {
				traceHandlerService.setReqExpMatcher(pm);
			}
			traceHandlerService.setPackageName(clazz.getCanonicalName());
			traceHandlerService.trace(clazz, message);
		}
	}
}