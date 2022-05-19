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
 * BaseException �� EgovBizException�� ����Ŭ�����̴�.
 *
 * <p><b>NOTE:</b> Exception Handling ���� BaseException ��
 * EgovBizException, RuntimeException, FdlException�� ������
 * ������ Exception �� �߻��ϴ� ��� BaseException �� �ٲ�� �Ǿ� �ִ�.
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
public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;

	protected String message = null;
	protected String messageKey = null;
	protected Object[] messageParameters = null;
	protected Exception wrappedException = null;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public Object[] getMessageParameters() {
		return messageParameters;
	}

	public void setMessageParameters(Object[] messageParameters) {
		this.messageParameters = messageParameters;
	}

	public Throwable getWrappedException() {
		return wrappedException;
	}

	public void setWrappedException(Exception wrappedException) {
		this.wrappedException = wrappedException;
	}

	/**
	 * BaseException �⺻ ������.
	 */
	public BaseException() {
		this("BaseException without message", null, null);
	}

	/**
	 * BaseException ������.
	 * 
	 * @param defaultMessage �޼��� ����
	 */
	public BaseException(String defaultMessage) {
		this(defaultMessage, null, null);
	}

	/**
	 * BaseException ������.
	 * 
	 * @param wrappedException  ���� Exception
	 */
	public BaseException(Throwable wrappedException) {
		this("BaseException without message", null, wrappedException);
	}

	/**
	 * BaseException ������.
	 * 
	 * @param defaultMessage �޼��� ����
	 * @param wrappedException ���� Exception
	 */
	public BaseException(String defaultMessage, Throwable wrappedException) {
		this(defaultMessage, null, wrappedException);
	}

	/**
	 * BaseException ������.
	 * 
	 * @param defaultMessage �޼��� ����(��������)
	 * @param messageParameters ġȯ�� �޼��� ����Ʈ
	 * @param wrappedException ���� Exception
	 */
	public BaseException(String defaultMessage, Object[] messageParameters, Throwable wrappedException) {
		super(wrappedException);

		String userMessage = defaultMessage;
		if (messageParameters != null) {
			userMessage = MessageFormat.format(defaultMessage, messageParameters);
		}
		
		this.message = userMessage;
	}

	/**
	 * BaseException ������.
	 * 
	 * @param messageSource �޼��� ���ҽ�
	 * @param messageKey �޼���Ű��
	 */
	public BaseException(MessageSource messageSource, String messageKey) {
		this(messageSource, messageKey, null, null, Locale.getDefault(), null);
	}

	/**
	 * BaseException ������.
	 * 
	 * @param messageSource �޼��� ���ҽ�
	 * @param messageKey �޼���Ű��
	 */
	public BaseException(MessageSource messageSource, String messageKey, Throwable wrappedException) {
		this(messageSource, messageKey, null, null, Locale.getDefault(), wrappedException);
	}

	/**
	 * BaseException ������.
	 * 
	 * @param messageSource �޼��� ���ҽ�
	 * @param messageKey �޼���Ű��
	 * @param locale ����/�������
	 * @param wrappedException ���� Exception
	 */
	public BaseException(MessageSource messageSource, String messageKey, Locale locale, Throwable wrappedException) {
		this(messageSource, messageKey, null, null, locale, wrappedException);
	}

	/**
	 * BaseException ������.
	 * 
	 * @param messageSource �޼��� ���ҽ�
	 * @param messageKey �޼���Ű��
	 * @param messageParameters ġȯ�� �޼��� ����Ʈ
	 * @param locale ����/�������
	 * @param wrappedException ���� Exception
	 */
	public BaseException(MessageSource messageSource, String messageKey, Object[] messageParameters, Locale locale, Throwable wrappedException) {
		this(messageSource, messageKey, messageParameters, null, locale, wrappedException);
	}

	/**
	 * BaseException ������.
	 * 
	 * @param messageSource �޼��� ���ҽ�
	 * @param messageKey �޼���Ű��
	 * @param messageParameters ġȯ�� �޼��� ����Ʈ
	 * @param wrappedException ���� Exception
	 */
	public BaseException(MessageSource messageSource, String messageKey, Object[] messageParameters, Throwable wrappedException) {
		this(messageSource, messageKey, messageParameters, null, Locale.getDefault(), wrappedException);
	}

	/**
	 * BaseException ������.
	 * 
	 * @param messageSource �޼��� ���ҽ�
	 * @param messageKey �޼���Ű��
	 * @param messageParameters ġȯ�� �޼��� ����Ʈ
	 * @param defaultMessage �޼��� ����(��������)
	 * @param wrappedException ���� Exception
	 */
	public BaseException(MessageSource messageSource, String messageKey, Object[] messageParameters, String defaultMessage, Throwable wrappedException) {
		this(messageSource, messageKey, messageParameters, defaultMessage, Locale.getDefault(), wrappedException);
	}

	/**
	 * BaseException ������.
	 * 
	 * @param messageSource �޼��� ���ҽ�
	 * @param messageKey �޼���Ű��
	 * @param messageParameters ġȯ�� �޼��� ����Ʈ
	 * @param defaultMessage �޼��� ����(��������)
	 * @param locale ����/�������
	 * @param wrappedException ���� Exception
	 */
	public BaseException(MessageSource messageSource, String messageKey, Object[] messageParameters, String defaultMessage, Locale locale, Throwable wrappedException) {
		super(wrappedException);

		this.messageKey = messageKey;
		this.messageParameters = messageParameters;
		this.message = messageSource.getMessage(messageKey, messageParameters, defaultMessage, locale);
	}
}
