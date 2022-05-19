package net.hibiznet.comm.service;

import java.util.List;

public interface UserDetailsService {

	/**
	 * ������ ����ڰ�ü�� VO�������� �����´�.
	 * @return Object - ����� ValueObject
	 */
	public Object getAuthenticatedUser();

	/**
	 * ������ ������� ���� ������ �����´�.
	 * ��) [ROLE_ADMIN, ROLE_USER, ROLE_A, ROLE_B, ROLE_RESTRICTED, IS_AUTHENTICATED_FULLY, IS_AUTHENTICATED_REMEMBERED, IS_AUTHENTICATED_ANONYMOUSLY]
	 * @return List - ����� �������� ���
	 */
	public List<String> getAuthorities();
	
	/**
	 * ������ ����� ���θ� üũ�Ѵ�.
	 * @return Boolean - ������ ����� ����(TRUE / FALSE)	
	 */
	public Boolean isAuthenticated(); 

}
