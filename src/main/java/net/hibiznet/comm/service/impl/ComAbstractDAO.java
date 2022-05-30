/**
 *
 */
package net.hibiznet.comm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.hibiznet.comm.AbstractMapper;

/**
 * ComAbstractDAO.java Ŭ����
 *
 * @author ���ؽ�
 * @since 2011. 9. 23.
 * @version 1.0
 * @see
 *
 * <pre>
 * << �����̷�(Modification Information) >>
 *
 *   ������      ������           ��������
 *  -------    -------------    ----------------------
 *   2011. 9. 23.   ���ؽ�        ���� ����
 *   2016. 5. 11.   �嵿��        myBatis ��� ����
 * </pre>
 */
@SuppressWarnings("unchecked")
public abstract class ComAbstractDAO extends AbstractMapper{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="base.sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}
	
	/**
	 * �Է� ó�� SQL mapping �� �����Ѵ�.
	 *
	 * @param queryId -  �Է� ó�� SQL mapping ���� ID
	 *
	 * @return DBMS�� �����ϴ� ��� insert ���� ��� count
	 */
	@Override
	public int insert(String queryId) {
		LOGGER.debug("queryId = "+queryId);
		return getSqlSession().insert(queryId);
	}

	/**
	 * �Է� ó�� SQL mapping �� �����Ѵ�.
	 *
	 * @param queryId -  �Է� ó�� SQL mapping ���� ID
	 * @param parameterObject - �Է� ó�� SQL mapping �Է� �����͸� ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
	 *
	 * @return DBMS�� �����ϴ� ��� insert ���� ��� count
	 */
	@Override
	public int insert(String queryId, Object parameterObject) {
		LOGGER.debug("queryId = "+queryId);
		return getSqlSession().insert(queryId, parameterObject);
	}

	/**
	 * ���� ó�� SQL mapping �� �����Ѵ�.
	 *
	 * @param queryId - ���� ó�� SQL mapping ���� ID
	 *
	 * @return DBMS�� �����ϴ� ��� update ���� ��� count
	 */
	@Override
	public int update(String queryId) {
		LOGGER.debug("queryId = "+queryId);
		return getSqlSession().update(queryId);
	}

	/**
	 * ���� ó�� SQL mapping �� �����Ѵ�.
	 *
	 * @param queryId - ���� ó�� SQL mapping ���� ID
	 * @param parameterObject - ���� ó�� SQL mapping �Է� ������(key ���� �� ���� ������)�� ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
	 *
	 * @return DBMS�� �����ϴ� ��� update ���� ��� count
	 */
	@Override
	public int update(String queryId, Object parameterObject) {
		LOGGER.debug("queryId = "+queryId);
		return getSqlSession().update(queryId, parameterObject);
	}

	/**
	 * ���� ó�� SQL mapping �� �����Ѵ�.
	 *
	 * @param queryId - ���� ó�� SQL mapping ���� ID
	 *
	 * @return DBMS�� �����ϴ� ��� delete ���� ��� count
	 */
	@Override
	public int delete(String queryId) {
		LOGGER.debug("queryId = "+queryId);
		return getSqlSession().delete(queryId);
	}

	/**
	 * ���� ó�� SQL mapping �� �����Ѵ�.
	 *
	 * @param queryId - ���� ó�� SQL mapping ���� ID
	 * @param parameterObject - ���� ó�� SQL mapping �Է� ������(�Ϲ������� key ����)��  ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
	 *
	 * @return DBMS�� �����ϴ� ��� delete ���� ��� count
	 */
	@Override
	public int delete(String queryId, Object parameterObject) {
		LOGGER.debug("queryId = "+queryId);
		return getSqlSession().delete(queryId, parameterObject);
	}

	//CHECKSTYLE:OFF
	/**
	 * ����Ģ�� ���� selectOne()�� �����Ѵ�.
	 * @deprecated select() �޼ҵ�� ��ü
	 * 
	 * @see EgovAbstractMapper.selectOne()
	 */
	//CHECKSTYLE:ON
	@Deprecated
	public Object selectByPk(String queryId, Object parameterObject) {
		LOGGER.debug("queryId = "+queryId);
		return getSqlSession().selectOne(queryId, parameterObject);
	}

	/**
	 * �ܰ���ȸ ó�� SQL mapping �� �����Ѵ�.
	 *
	 * @param queryId - �ܰ� ��ȸ ó�� SQL mapping ���� ID
	 *
	 * @return ��� ��ü - SQL mapping ���Ͽ��� ������ resultType/resultMap �� ���� ���� ��� ��ü(���� VO �Ǵ� Map)
	 */
	@Override
	public <T> T selectOne(String queryId) {
		LOGGER.debug("queryId = "+queryId);
		return (T) getSqlSession().selectOne(queryId);
	}

	/**
	 * �ܰ���ȸ ó�� SQL mapping �� �����Ѵ�.
	 *
	 * @param queryId - �ܰ� ��ȸ ó�� SQL mapping ���� ID
	 * @param parameterObject - �ܰ� ��ȸ ó�� SQL mapping �Է� ������(key)�� ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
	 *
	 * @return ��� ��ü - SQL mapping ���Ͽ��� ������ resultType/resultMap �� ���� ���� ��� ��ü(���� VO �Ǵ� Map)
	 */
	@Override
	public <T> T selectOne(String queryId, Object parameterObject) {
		LOGGER.debug("queryId = "+queryId);
		return (T) getSqlSession().selectOne(queryId, parameterObject);
	}

	/**
	 * ��� ����� Map �� ��ȯ�Ѵ�.
	 * ��� ������ �Ķ���͸� �ʿ�� ������ �ʱ� ������, �Ķ���� ��ü�� �䱸���� �ʴ� ���·� �����ε�Ǿ���.
	 *
	 * @param queryId - �ܰ� ��ȸ ó�� SQL mapping ���� ID
	 * @param mapKey - ��� ��ü�� ������Ƽ �� �ϳ��� Ű�� ���
	 *
	 * @return ��� ��ü - SQL mapping ���Ͽ��� ������ resultType/resultMap �� ���� ���� ��� ��ü(���� VO �Ǵ� Map)�� Map
	 */
	@Override
	public <K, V> Map<K, V> selectMap(String queryId, String mapKey) {
		LOGGER.debug("queryId = "+queryId);
		return ((AbstractMapper) getSqlSession()).selectMap(queryId, mapKey);
	}

	/**
	 * ��� ����� Map �� ��ȯ�Ѵ�.
	 * ��� ������ �Ķ���͸� �ʿ�� ������ �ʱ� ������, �Ķ���� ��ü�� �䱸���� �ʴ� ���·� �����ε�Ǿ���.
	 *
	 * @param queryId - �ܰ� ��ȸ ó�� SQL mapping ���� ID
	 * @param parameterObject - �� ��ȸ ó�� SQL mapping �Է� ������(��ȸ ����)�� ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
	 * @param mapKey - ��� ��ü�� ������Ƽ �� �ϳ��� Ű�� ���
	 *
	 * @return ��� ��ü - SQL mapping ���Ͽ��� ������ resultType/resultMap �� ���� ���� ��� ��ü(���� VO �Ǵ� Map)�� Map
	 */
	@Override
	public <K, V> Map<K, V> selectMap(String queryId, Object parameterObject, String mapKey) {
		LOGGER.debug("queryId = "+queryId);
		return ((AbstractMapper) getSqlSession()).selectMap(queryId, parameterObject, mapKey);
	}

	/**
	 * ��� ����� Map �� ��ȯ�Ѵ�.
	 * ��� ������ �Ķ���͸� �ʿ�� ������ �ʱ� ������, �Ķ���� ��ü�� �䱸���� �ʴ� ���·� �����ε�Ǿ���.
	 *
	 * @param queryId - �ܰ� ��ȸ ó�� SQL mapping ���� ID
	 * @param parameterObject - �� ��ȸ ó�� SQL mapping �Է� ������(��ȸ ����)�� ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
	 * @param mapKey - ��� ��ü�� ������Ƽ �� �ϳ��� Ű�� ���
	 * @param rowBounds - Ư�� ���� ��ŭ�� ���ڵ带 �ǳʶ�� ��
	 *
	 * @return ��� ��ü - SQL mapping ���Ͽ��� ������ resultType/resultMap �� ���� ���� ��� ��ü(���� VO �Ǵ� Map)�� Map
	 */
	@Override
	public <K, V> Map<K, V> selectMap(String queryId, Object parameterObject, String mapKey, RowBounds rowBounds) {
		LOGGER.debug("queryId = "+queryId);
		return ((AbstractMapper) getSqlSession()).selectMap(queryId, parameterObject, mapKey, rowBounds);
	}

	//CHECKSTYLE:OFF
	/**
	 * ����Ģ�� ���� selectList()�� �����Ѵ�.
	 * 
	 * @see EgovAbstractMapper.selectList()
	 * @deprecated List<?> �޼ҵ�� ��ü
	 */
	//CHECKSTYLE:ON
	@Deprecated
	public List<?> list(String queryId, Object parameterObject) {
		LOGGER.debug("queryId = "+queryId);
		return getSqlSession().selectList(queryId, parameterObject);
	}

	/**
	 * ����Ʈ ��ȸ ó�� SQL mapping �� �����Ѵ�.
	 *
	 * @param queryId - ����Ʈ ��ȸ ó�� SQL mapping ���� ID
	 *
	 * @return ��� List ��ü - SQL mapping ���Ͽ��� ������  resultType/resultMap �� ���� ��� ��ü(���� VO �Ǵ� Map)�� List
	 */
	@Override
	public <E> List<E> selectList(String queryId) {
		LOGGER.debug("queryId = "+queryId);
		return getSqlSession().selectList(queryId);
	}

	/**
	 * ����Ʈ ��ȸ ó�� SQL mapping �� �����Ѵ�.
	 *
	 * @param queryId - ����Ʈ ��ȸ ó�� SQL mapping ���� ID
	 * @param parameterObject - ����Ʈ ��ȸ ó�� SQL mapping �Է� ������(��ȸ ����)�� ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
	 *
	 * @return ��� List ��ü - SQL mapping ���Ͽ��� ������  resultType/resultMap �� ���� ��� ��ü(���� VO �Ǵ� Map)�� List
	 */
	@Override
	public <E> List<E> selectList(String queryId, Object parameterObject) {
		LOGGER.debug("queryId = "+queryId);
		return getSqlSession().selectList(queryId, parameterObject);
	}

	/**
	 * ����Ʈ ��ȸ ó�� SQL mapping �� �����Ѵ�.
	 *
	 * @param queryId - ����Ʈ ��ȸ ó�� SQL mapping ���� ID
	 * @param parameterObject - ����Ʈ ��ȸ ó�� SQL mapping �Է� ������(��ȸ ����)�� ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
	 * @param rowBounds - Ư�� ���� ��ŭ�� ���ڵ带 �ǳʶ�� ��
	 *
	 * @return ��� List ��ü - SQL mapping ���Ͽ��� ������  resultType/resultMap �� ���� ��� ��ü(���� VO �Ǵ� Map)�� List
	 */
	@Override
	public <E> List<E> selectList(String queryId, Object parameterObject, RowBounds rowBounds) {
		LOGGER.debug("queryId = "+queryId);
		return getSqlSession().selectList(queryId, parameterObject, rowBounds);
	}

	/**
	 * �κ� ���� ����Ʈ ��ȸ ó�� SQL mapping �� �����Ѵ�.
	 * (�κ� ���� - pageIndex �� pageSize ������� ���� �κ� ���� ��ȸ�� ���� skipResults, maxResults �� ����Ͽ� ibatis ȣ��)
	 *
	 * @param queryId - ����Ʈ ��ȸ ó�� SQL mapping ���� ID
	 * @param parameterObject - ����Ʈ ��ȸ ó�� SQL mapping �Է� ������(��ȸ ����)�� ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
	 * @param pageIndex - ���� ������ ��ȣ
	 * @param pageSize - �� ������ ��ȸ ��(pageSize)
	 *
	 * @return �κ� ���� ��� List ��ü - SQL mapping ���Ͽ��� ������ resultType/resultMap �� ���� �κ� ���� ��� ��ü(���� VO �Ǵ� Map) List
	 */
	@Override
	public List<?> listWithPaging(String queryId, Object parameterObject, int pageIndex, int pageSize) {
		LOGGER.debug("queryId = "+queryId);
		int skipResults = pageIndex * pageSize;
		//int maxResults = (pageIndex * pageSize) + pageSize;

		RowBounds rowBounds = new RowBounds(skipResults, pageSize);

		return getSqlSession().selectList(queryId, parameterObject, rowBounds);
	}

	/**
	 * SQL ��ȸ ����� ResultHandler�� �̿��ؼ� ����Ѵ�.
	 * ResultHandler�� ����� ������ Ŀ���� �ڵ鷯�� handleResult() �޼��忡 ���� ����ȴ�.
	 *
	 * @param queryId - ����Ʈ ��ȸ ó�� SQL mapping ���� ID
	 * @param handler - ��ȸ ����� �����ϱ� ���� ������ ResultHandler
	 * @return
	 *
	 * @return ��� List ��ü - SQL mapping ���Ͽ��� ������ resultType/resultMap �� ���� ��� ��ü(���� VO �Ǵ� Map)�� List
	 */
	@Override
	public void listToOutUsingResultHandler(String queryId, ResultHandler handler) {
		LOGGER.debug("queryId = "+queryId);
		getSqlSession().selectOne(queryId, handler);
	}
}
