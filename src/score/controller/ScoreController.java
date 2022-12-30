package score.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import score.view.ScoreView;
import score.vo.ScoreDAO;
import score.vo.ScoreVO;

public class ScoreController extends JFrame {

	JTable table;
	ScoreDAO dao;
	ArrayList<ScoreVO> scoreVOList;
	ScoreView view;
	public ScoreController (){
		dao = new ScoreDAO();
		view = new ScoreView();
		scoreVOList = dao.select();
		view.setScoreVOList(scoreVOList);
		view.initView();
		
		JButton btnAdd = view.getBtnAdd();
		btnAdd.addActionListener(btnAddL);
		
		table = view.getTable();
		table.addMouseListener(tableL);
		
		add(view, "Center");
		
		setTitle("성적관리시스템");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200,200);
		setSize(600,500);
		setVisible(true);
	}
		
	public static void main(String[] args) {
		
		new ScoreController();
		// 오늘의 저녁 : 쌀밥, 들깨감자국, 메추리알장조림, 청경채겉절이, 콩나물불고기, 배추김치		
	
	}
	ActionListener btnAddL = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// neededInsertData() : panS에 있는 JTextField에 입력된 값들과 JComboBox의 값을
			// BookVO에 필드값들을 초기화하여 BookVO 객체 참조값을 반환하는 메소드 
			ScoreVO vo = view.neededInsertData();
			dao.insert(vo);
			scoreVOList = dao.select();
			view.setScoreVOList(scoreVOList);
			view.putResult();
			view.initInsertData();
		}
	};
	
	MouseAdapter tableL = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int state = 0;
			if(e.getClickCount() == 2) {
				 state = JOptionPane.showConfirmDialog(ScoreController.this, "정말 삭제하시겠습니까?", "삭제여부", JOptionPane.YES_NO_OPTION);
				 if(state == JOptionPane.YES_OPTION) {
					 dao.delete(table.getSelectedRow());
					 scoreVOList = dao.select();
					 view.setScoreVOList( scoreVOList);
					 view.putResult();
					 view.initInsertData();
				 }
			}
		}
	};

	
}

	


