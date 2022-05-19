package net.hibiznet.comm;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Spring�� MyBatis ���� ���� ���� parent DAO Ŭ����
 */
public abstract class AbstractMapper extends SqlSessionDaoSupport {

    /**
     * Annotation �������� sqlSession(SqlSessionFactoryBean)�� �޾ƿ�
     * �̸� super(SqlSessionDaoSupport)�� setSqlSessionFactory �޼��带 ȣ���Ͽ� ������ �ش�.
     * <p>
     * SqlSessionTemplate�� ������ ���� ��� �� SqlSessionFactory�� ���õȴ�. (Batch ó���� ���ؼ��� SqlSessionTemplate�� �ʿ�)
     *
     *
     * @param sqlSession SqlSessionFactory�� MyBatis���� ���踦 ���� �⺻ Ŭ����
     */
    @Resource(name = "sqlSessionFactory")
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
    public int insert(String queryId) {
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
    public int insert(String queryId, Object parameterObject) {
    	return getSqlSession().insert(queryId, parameterObject);
    }

    /**
     * ���� ó�� SQL mapping �� �����Ѵ�.
     *
     * @param queryId - ���� ó�� SQL mapping ���� ID
     *
     * @return DBMS�� �����ϴ� ��� update ���� ��� count
     */
    public int update(String queryId) {
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
    public int update(String queryId, Object parameterObject) {
        return getSqlSession().update(queryId, parameterObject);
    }

    /**
     * ���� ó�� SQL mapping �� �����Ѵ�.
     *
     * @param queryId - ���� ó�� SQL mapping ���� ID
     *
     * @return DBMS�� �����ϴ� ��� delete ���� ��� count
     */
    public int delete(String queryId) {
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
    public int delete(String queryId, Object parameterObject) {
        return getSqlSession().delete(queryId, parameterObject);
    }

    /**
     * ����Ģ�� ���� selectOne()�� �����Ѵ�.
     * @see EgovAbstractMapper.selectOne()
     */
    @Deprecated
    public Object selectByPk(String queryId, Object parameterObject) {
        return getSqlSession().selectOne(queryId, parameterObject);
    }

    /**
     * �ܰ���ȸ ó�� SQL mapping �� �����Ѵ�.
     *
     * @param queryId - �ܰ� ��ȸ ó�� SQL mapping ���� ID
     *
     * @return ��� ��ü - SQL mapping ���Ͽ��� ������ resultType/resultMap �� ���� ���� ��� ��ü(���� VO �Ǵ� Map)
     */
    public <T> T selectOne(String queryId) {
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
    public <T> T selectOne(String queryId, Object parameterObject) {
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
    public <K, V> Map<K, V> selectMap(String queryId, String mapKey) {
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
    public <K, V> Map<K, V> selectMap(String queryId, Object parameterObject, String mapKey) {
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
    public <K, V> Map<K, V> selectMap(String queryId, Object parameterObject, String mapKey, RowBounds rowBounds) {
        return ((AbstractMapper) getSqlSession()).selectMap(queryId, parameterObject, mapKey, rowBounds);
    }

    /**
     * ����Ģ�� ���� selectList()�� �����Ѵ�.
     * @see EgovAbstractMapper.selectList()
     */
    @Deprecated
	public List<?> list(String queryId, Object parameterObject) {
        return getSqlSession().selectList(queryId, parameterObject);
    }

    /**
     * ����Ʈ ��ȸ ó�� SQL mapping �� �����Ѵ�.
     *
     * @param queryId - ����Ʈ ��ȸ ó�� SQL mapping ���� ID
     *
     * @return ��� List ��ü - SQL mapping ���Ͽ��� ������  resultType/resultMap �� ���� ��� ��ü(���� VO �Ǵ� Map)�� List
     */
	public <E> List<E> selectList(String queryId) {
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
	public <E> List<E> selectList(String queryId, Object parameterObject) {
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
	public <E> List<E> selectList(String queryId, Object parameterObject, RowBounds rowBounds) {
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
	public List<?> listWithPaging(String queryId, Object parameterObject, int pageIndex, int pageSize) {
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
    @SuppressWarnings("rawtypes")
	public void  listToOutUsingResultHandler(String queryId, ResultHandler handler) {
		getSqlSession().selectOne(queryId, handler);
    }
}
