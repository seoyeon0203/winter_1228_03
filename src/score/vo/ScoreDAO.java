package score.vo;

import java.util.ArrayList;

public class ScoreDAO {
	ArrayList<ScoreVO> svoList = new ArrayList<ScoreVO>();
	
	public void insert(ScoreVO svo) {
		svoList.add(svo);
	}
	public ArrayList<ScoreVO> select(){
		return svoList;
	}
	
	// 더블 클릭하면 삭제하는 메소드 
	public void delete(int row) {
		svoList.remove(row);
	}
}

	