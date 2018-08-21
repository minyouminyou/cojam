package test.sites;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;


@Repository
public class SitesDao extends SqlSessionDaoSupport {
	
	public List<SitesDto> getAllDatas() {
		return getSqlSession().selectList("getAllDatas");	
	}
	
	public int getTotalCount() {
		return getSqlSession().selectOne("getTotalCount");
	}
	
	public List<SitesDto> getList(int start,int end) {
		  HashMap <String,Object>map=new HashMap<String,Object>();
		  map.put("start", start);
		  map.put("end", end);
		  List<SitesDto> list=getSqlSession().selectList("sitesselectDatas",map);
		  return list;
		 }
	
}
