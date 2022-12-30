package score.vo;

public class ScoreVO {
	//필드 
	private int stuId; // 학번
	private String name; //이름
	private int grade; // 학년
	private int roomNum; //반
	private int kor; //국어
	private int eng; //영어
	private int math; //수학
	private int scien; //과학
	private int tot; 
	private double average;
	
	// 기본 생성자
	public ScoreVO() {}

	// 생성자 
	public ScoreVO(int stuId, String name, int grade, int roomNum, int kor, int eng, int math, int scien, int tot, double average) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.grade = grade;
		this.roomNum = roomNum;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.scien = scien;
		this.tot = tot;
		this.average = average;
	}

	// Getter, Setter
	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getScien() {
		return scien;
	}

	public void setScien(int scien) {
		this.scien = scien;
	}
	
	public int getTot() {
		return tot;
	}

	public void setTot() {
		this.tot = kor+eng+math+scien;
	}
	
	public double getAverage() {
		return average ;
	}

	public void setAverage() {
		this.average = tot/4.0;
	}
	
	// toString 
	@Override
	public String toString() {
		return "ScoreVO [stuId=" + stuId + ", name=" + name + ", grade=" + grade + ", roomNum=" + roomNum + ", kor="
				+ kor + ", eng=" + eng + ", math=" + math + ", scien=" + scien + ", tot=" + tot + ", average=" + average
				+ "]";
	}
	
	
}
