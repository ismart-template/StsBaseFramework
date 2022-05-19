package net.hibiznet.comm.service;

import java.util.List;
import java.util.Map;

import net.hibiznet.comm.ComDefaultCodeVO;



/**
 *
 * �����ڵ�� ��ü �������� �����ؼ� ����ؾ� �ϴ� ���񽺸� �����ϱ� ���� ���� �������̽�
 * @author ���뼭�� ������ �̻Ｗ
 * @since 2009.04.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << �����̷�(Modification Information) >>
 *
 *   ������      ������           ��������
 *  -------    --------    ---------------------------
 *   2009.03.11  �̻Ｗ          ���� ����
 *
 * </pre>
 */
public interface CmmUseService {

    /**
     * �����ڵ带 ��ȸ�Ѵ�.
     *
     * @param vo
     * @return List(�ڵ�)
     * @throws Exception
     */
    public List<CmmnDetailCode> selectCmmCodeDetail(ComDefaultCodeVO vo) throws Exception;

    /**
     * ComDefaultCodeVO�� ����Ʈ�� �޾Ƽ� �������� �ڵ� ����Ʈ�� �ʿ� ��Ƽ� �����Ѵ�.
     *
     * @param voList
     * @return Map(�ڵ�)
     * @throws Exception
     */
    public Map<String, List<CmmnDetailCode>> selectCmmCodeDetails(List<?> voList) throws Exception;

    /**
     * ���������� �ڵ����·� �����Ѵ�.
     *
     * @param ��ȸ�������� vo
     * @return �������� List
     * @throws Exception
     */
    public List<CmmnDetailCode> selectOgrnztIdDetail(ComDefaultCodeVO vo) throws Exception;

    /**
     * �׷������� �ڵ����·� �����Ѵ�.
     *
     * @param ��ȸ�������� vo
     * @return �׷����� List
     * @throws Exception
     */
    public List<CmmnDetailCode> selectGroupIdDetail(ComDefaultCodeVO vo) throws Exception;
}
