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
package net.hibiznet.comm.exception;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * EgovBizException : ����Ͻ� ���� ����ü���� �߻���Ű�� Biz Exception .
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
public class CmmBizException extends BaseException {

	private static final long serialVersionUID = 1L;

	/**
	 * EgovBizException ������.
	 * @param object3 
	 * @param locale 
	 * @param object2 
	 * @param object 
	 * @param messageKey 
	 * @param messageSource 
	 */
	public CmmBizException(MessageSource messageSource, String messageKey, Object object, Object object2, Locale locale, Object object3) {
		this("BaseException without message", null, null);
	}

	/**
	 * EgovBizException ������.
	 * 
	 * @param defaultMessage �޼��� ����
	 */
	public CmmBizException(String defaultMessage) {
		this(defaultMessage, null, null);
	}

	/**
	 * EgovBizException ������.
	 * 
	 * @param defaultMessage �޼��� ����
	 * @param wrappedException ���� Exception
	 */
	public CmmBizException(String defaultMessage, Exception wrappedException) {
		this(defaultMessage, null, wrappedException);
	}

	/**
	 * EgovBizException ������.
	 * 
	 * @param defaultMessage �޼��� ����(��������)
	 * @param messageParameters ġȯ�� �޼��� ����Ʈ
	 * @param wrappedException ���� Exception
	 */
	public CmmBizException(String defaultMessage, Object[] messageParameters, Exception wrappedException) {
		String userMessage = defaultMessage;
		
		if (messageParameters != null) {
			userMessage = MessageFormat.format(defaultMessage, messageParameters);
		}
		
		this.message = userMessage;
		this.wrappedException = wrappedException;
	}

	/**
	 * EgovBizException ������.
	 * 
	 * @param messageSource �޼��� ���ҽ�
	 * @param messageKey �޼���Ű��
	 */
	public CmmBizException(MessageSource messageSource, String messageKey) {
		this(messageSource, messageKey, null, null, Locale.getDefault(), null);
	}

	/**
	 * EgovBizException ������.
	 * 
	 * @param messageSource �޼��� ���ҽ�
	 * @param messageKey �޼���Ű��
	 * @param wrappedException ���� Exception
	 */
	public CmmBizException(MessageSource messageSource, String messageKey, Exception wrappedException) {
		this(messageSource, messageKey, null, null, Locale.getDefault(), wrappedException);
	}

	/**
	 * EgovBizException ������.
	 * 
	 * @param messageSource �޼��� ���ҽ�
	 * @param messageKey �޼���Ű��
	 * @param locale ����/�������
	 * @param wrappedException ���� Exception
	 */
	public CmmBizException(MessageSource messageSource, String messageKey, Locale locale, Exception wrappedException) {
		this(messageSource, messageKey, null, null, locale, wrappedException);
	}

	/**
	 * EgovBizException ������.
	 * 
	 * @param messageSource �޼��� ���ҽ�
	 * @param messageKey �޼���Ű��
	 * @param messageParameters ġȯ�� �޼��� ����Ʈ
	 * @param locale ����/�������
	 * @param wrappedException ���� Exception
	 */
	public CmmBizException(MessageSource messageSource, String messageKey, Object[] messageParameters, Locale locale, Exception wrappedException) {
		this(messageSource, messageKey, messageParameters, null, locale, wrappedException);
	}

	/**
	 * EgovBizException ������.
	 * 
	 * @param messageSource �޼��� ���ҽ�
	 * @param messageKey �޼���Ű��
	 * @param messageParameters ġȯ�� �޼��� ����Ʈ
	 * @param wrappedException ���� Exception
	 */
	public CmmBizException(MessageSource messageSource, String messageKey, Object[] messageParameters, Exception wrappedException) {
		this(messageSource, messageKey, messageParameters, null, Locale.getDefault(), wrappedException);
	}

	/**
	 * EgovBizException ������.
	 * 
	 * @param messageSource �޼��� ���ҽ�
	 * @param messageKey �޼���Ű��
	 * @param messageParameters ġȯ�� �޼��� ����Ʈ
	 * @param defaultMessage �⺻ �޽���
	 * @param wrappedException ���� Exception
	 */
	public CmmBizException(MessageSource messageSource, String messageKey, Object[] messageParameters, String defaultMessage, Exception wrappedException) {
		this(messageSource, messageKey, messageParameters, defaultMessage, Locale.getDefault(), wrappedException);
	}

	/**
	 *  EgovBizException ������.
	 *  
	 * @param messageSource �޼��� ���ҽ�
	 * @param messageKey �޼���Ű��
	 * @param messageParameters ġȯ�� �޼��� ����Ʈ
	 * @param defaultMessage �⺻ �޽���
	 * @param locale ����/�������
	 * @param wrappedException ���� Exception
	 */
	public CmmBizException(MessageSource messageSource, String messageKey, Object[] messageParameters, String defaultMessage, Locale locale, Exception wrappedException) {
		this.messageKey = messageKey;
		this.messageParameters = messageParameters;
		this.message = messageSource.getMessage(messageKey, messageParameters, defaultMessage, locale);
		this.wrappedException = wrappedException;
	}
}
