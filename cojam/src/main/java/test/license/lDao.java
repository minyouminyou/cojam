package test.license;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class lDao extends SqlSessionDaoSupport {
	
	public List<lDto> getAlldatas() {
		List<lDto> list=getSqlSession().selectList("licenseAlldata");
		return list;
	}

	public void insertlc(lDto dto) {
		getSqlSession().insert("LcInsert", dto);
	}
	
	public List<lDto> getList(int start,int end) {
		  HashMap <String,Object>map=new HashMap<String,Object>();
		  map.put("start", start);
		  map.put("end", end);
		  List<lDto> list=getSqlSession().selectList("licselectDatas",map);
		  return list;
		 }
		
	public int getCount() {
		return getSqlSession().selectOne("licgetCount");
	}

}
