package test.lecture;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class lectureDao extends SqlSessionDaoSupport {
	public List<lectureDto> getAlldatas() {
		List<lectureDto> list=getSqlSession().selectList("lectureAlldata");
		return list;
	}

	public void insertLecture(lectureDto dto) {
		getSqlSession().insert("lectureInsert", dto);
	}
	
	public List<lectureDto> getList(int start,int end) {
		  HashMap <String,Object>map=new HashMap<String,Object>();
		  map.put("start", start);
		  map.put("end", end);
		  List<lectureDto> list=getSqlSession().selectList("lecselectDatas",map);
		  return list;
		 }
		
	public int getCount() {
		return getSqlSession().selectOne("lecgetCount");
	}

}
