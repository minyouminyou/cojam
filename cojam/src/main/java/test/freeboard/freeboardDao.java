package test.freeboard;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class freeboardDao extends SqlSessionDaoSupport {
	
	public List<freeboardDto> getAlldatas() {
		List<freeboardDto> list=getSqlSession().selectList("freeboardAlldata");
		return list;
	}

	public void insertFreeboard(freeboardDto dto) {
		getSqlSession().insert("freeboardInsert", dto);
	}
	
	public freeboardDto selectseqfree(int Seq) {
		return getSqlSession().selectOne("freeboardContent", Seq);
	}
	
	public freeboardDto delete(int Seq) {
		return getSqlSession().selectOne("freeboardDelete", Seq);
	}

	public List<freeboardDto> getList(int start,int end) {
	  HashMap <String,Object>map=new HashMap<String,Object>();
	  map.put("start", start);
	  map.put("end", end);
	  List<freeboardDto> list=getSqlSession().selectList("selectDatas",map);
	  return list;
	 }
	
	public int getCount() {
		return getSqlSession().selectOne("freegetCount");
	}
	public List<freeboardDto> getMainList(){
		return getSqlSession().selectList("getMainList");
	}

}
