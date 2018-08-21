package test.academy;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import test.license.lDto;

@Repository
public class academyDao extends SqlSessionDaoSupport {
	
	public List<academyDto> getAlldatas() {
		List<academyDto> list=getSqlSession().selectList("academyAlldata");
		return list;
	}
	
	public void insertAcademy(academyDto dto) {
		getSqlSession().insert("academyInsert", dto);
	}
	public List<academyDto> getList(int start,int end) {
		  HashMap <String,Object>map=new HashMap<String,Object>();
		  map.put("start", start);
		  map.put("end", end);
		  List<academyDto> list=getSqlSession().selectList("acaselectDatas",map);
		  return list;
		 }
		
		public int getCount() {
			return getSqlSession().selectOne("acagetCount");
		}
}
