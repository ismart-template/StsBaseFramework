/*
 * Copyright 2008-2014 MOSPA(Ministry of Security and Public Administration).
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
package net.hibiznet.comm.service.impl;

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import net.hibiznet.comm.exception.CmmBizException;
import net.hibiznet.comm.service.LeaveaTrace;

/**
 * ����Ͻ� ���� ����ü�� ��ӹ޴� �߻�Ŭ����
 * <p><b>NOTE:</b> ����Ͻ� ���� ������ ������� Exception �߻��� ���� processException �޼ҵ��
 * leaveaTrace �޼ҵ带 ������ �ִ�. processException / leaveaTrace �� ������Ÿ���� �Ķ���͸� ���� �� �ֵ��� �����ϰ� �ִ�.</p>
 * 
 * <p>
 *  �� Ŭ������ eGovFrame 3.0���� Deprecated �ȴ�.
 * ���� AbstractServiceImpl�� ����ϰ� �ִٸ� EgovAbstractServiceImpl Ŭ������ �����ϴ� ���� �����Ѵ�. 
 * (�� Ŭ���� ������ ��� �����ϸ�, AbstractServiceImpl ���� ���ŵ� ����)
 * </p>
 * @deprecated EgovAbstractServiceImpl�� ��ü
 * @author Judd Cho (horanghi@gmail.com)
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << �����̷�(Modification Information) >>
 *
 *   ������			������				��������
 *  ---------------------------------------------------------------------------------
 *   2009.05.30	Judd Cho			���� ����
 *   2014.06.01	Daniela Kwon		@Deprecated �߰�
 *   2015.01.31 Vincent Han		�ڵ� ǰ�� ���� 
 * </pre>
 */
@Deprecated
public abstract class AbstractServiceImpl {

	protected Logger egovLogger = LoggerFactory.getLogger(AbstractServiceImpl.class);

	@Resource(name = "messageSource")
	private MessageSource messageSource;

	@Resource(name = "leaveaTrace")
	private LeaveaTrace traceObj;

	/**
	 * EgovBizException �߻��� ���� �޼ҵ�.
	 * 
	 * @param msgKey �޼������ҽ����� �����Ǵ� �޼����� Ű��
	 * @return Exception EgovBizException ��ü
	 */
	protected Exception processException(final String msgKey) {
		return processException(msgKey, new String[] {});
	}

	/**
	 * EgovBizException �߻��� ���� �޼ҵ�.
	 * 
	 * @param msgKey �޼������ҽ����� �����Ǵ� �޼����� Ű��
	 * @param exception �߻��� Exception(���������� ���ϰ� �ִٰ� �����ڵ鸵�� ���)
	 * @return Exception EgovBizException ��ü
	 */
	protected Exception processException(final String msgKey, Exception e) {
		return processException(msgKey, new String[] {}, e);
	}

	/**
	 * EgovBizException �߻��� ���� �޼ҵ�.
	 * 
	 * @param msgKey �޼������ҽ����� �����Ǵ� �޼����� Ű��
	 * @param msgArgs msgKey�� �޼������� ������ ��ȯ�Ǵ� ����
	 * @return Exception EgovBizException ��ü
	 */
	protected Exception processException(final String msgKey, final String[] msgArgs) {
		return processException(msgKey, msgArgs, null);
	}

	/**
	 * EgovBizException �߻��� ���� �޼ҵ�.
	 * 
	 * @param msgKey �޼������ҽ����� �����Ǵ� �޼����� Ű��
	 * @param msgArgs msgKey�� �޼������� ������ ��ȯ�Ǵ� ����
	 * @param exception �߻��� Exception(���������� ���ϰ� �ִٰ� �����ڵ鸵�� ���)
	 * @return Exception EgovBizException ��ü
	 */
	protected Exception processException(final String msgKey, final String[] msgArgs, final Exception e) {
		return processException(msgKey, msgArgs, e, LocaleContextHolder.getLocale());
	}

	/**
	 * EgovBizException �߻��� ���� �޼ҵ�.
	 * 
	 * @param msgKey �޼������ҽ����� �����Ǵ� �޼����� Ű��
	 * @param msgArgs msgKey�� �޼������� ������ ��ȯ�Ǵ� ����
	 * @param exception �߻��� Exception(���������� ���ϰ� �ִٰ� �����ڵ鸵�� ���)
	 * @param locale ����� ����/�������
	 * @return Exception EgovBizException ��ü
	 */
	protected Exception processException(final String msgKey, final String[] msgArgs, final Exception e, Locale locale) {
		return processException(msgKey, msgArgs, e, locale, null);
	}

	/**
	 * EgovBizException �߻��� ���� �޼ҵ�.
	 * 
	 * @param msgKey �޼������ҽ����� �����Ǵ� �޼����� Ű��
	 * @param msgArgs msgKey�� �޼������� ������ ��ȯ�Ǵ� ����
	 * @param exception �߻��� Exception(���������� ���ϰ� �ִٰ� �����ڵ鸵�� ���)
	 * @param locale ����� ����/�������
	 * @param exceptionCreator �ܺο��� ������ Exception ������ ����
	 * @return Exception EgovBizException ��ü
	 */
	protected Exception processException(final String msgKey, final String[] msgArgs, final Exception e, final Locale locale, ExceptionCreator exceptionCreator) {
		ExceptionCreator eC = null;
		if (exceptionCreator == null) {
			eC = new ExceptionCreator() {
				public Exception createBizException(MessageSource messageSource) {
					return new CmmBizException(messageSource, msgKey, msgArgs, locale, e);
				}
			};
		} else {
			eC = exceptionCreator;
		}
		
		return eC.createBizException(messageSource);
	}

	protected interface ExceptionCreator {
		Exception createBizException(MessageSource messageSource);
	}

	/**
	 * Exception �߻����� ��ó������ ������ ���� �޼ҵ�.
	 * 
	 * @param msgKey �޼������ҽ����� �����Ǵ� �޼����� Ű��
	 */
	protected void leaveaTrace(String msgKey) {
		leaveaTrace(msgKey, new String[] {});
	}

	/**
	 * Exception �߻����� ��ó������ ������ ���� �޼ҵ�.
	 * 
	 * @param msgKey �޼������ҽ����� �����Ǵ� �޼����� Ű��
	 * @param msgArgs msgKey�� �޼������� ������ ��ȯ�Ǵ� ����
	 */
	protected void leaveaTrace(String msgKey, String[] msgArgs) {
		leaveaTrace(msgKey, msgArgs, null);
	}

	/**
	 * Exception �߻����� ��ó������ ������ ���� �޼ҵ�.
	 * 
	 * @param msgKey �޼������ҽ����� �����Ǵ� �޼����� Ű��
	 * @param msgArgs msgKey�� �޼������� ������ ��ȯ�Ǵ� ����
	 * @param locale ����� ����/�������
	 */
	protected void leaveaTrace(String msgKey, String[] msgArgs, Locale locale) {
		traceObj.trace(this.getClass(), messageSource, msgKey, msgArgs, locale, egovLogger);
	}
}