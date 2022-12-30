package score.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import info.vo.BookVO;
import score.vo.ScoreVO;

public class ScoreView extends JPanel {

	
	JTable table;
	DefaultTableModel model;
	ArrayList<ScoreVO> scoreVOList;
	String [] header = {"학번", "성명", "학년", "반", "국어", "영어", "수학","과학", "총점", "평균"};
	JPanel panS;
	JLabel[] lbls = new JLabel[header.length-2];
	JTextField[] tf = new JTextField[header.length-2];
	JButton btnAdd = new JButton("성적 추가");
	
	// 기본 생성자
		public ScoreView () {
			setLayout(new BorderLayout());
			
			
			
			panS = new JPanel(new GridLayout(5,4));
			for(int i=0; i <lbls.length; i++) {
				lbls[i] = new JLabel(header[i]);
				panS.add(lbls[i]);
					tf[i] = new JTextField();
					panS.add(tf[i]);
			
			}
			
			for(int i=0; i <3; i++) {
				panS.add(new JLabel(" "));
			}
			panS.add(btnAdd);
		}
		// initView() : JTable 관련 메소드 
		public void initView() {
			model = new DefaultTableModel(header, scoreVOList.size()) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
			table = new JTable(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(50);
			table.getColumnModel().getColumn(4).setPreferredWidth(50);
			
			JScrollPane scroll = new JScrollPane(table);
			
			putResult();
			
			add("Center", scroll);
			add("South", panS);
		}
		
		// DefaultTableModel에 도서정보들을 설정한다.
		public void putResult() {
			// modeldlml 행 개수 설정 
			model.setRowCount(scoreVOList.size());
			ScoreVO vo = null; 
			for(int i =0; i <scoreVOList.size(); i++) {
				vo = scoreVOList.get(i);
				// 1 : 행 번호, 0 : 열 번호
				model.setValueAt(vo.getStuId(), i, 0);;
				model.setValueAt(vo.getName(), i, 1);;
				model.setValueAt(vo.getGrade(), i, 2);;
				model.setValueAt(vo.getRoomNum(), i, 3);;
				model.setValueAt(vo.getKor(), i, 4);;
				model.setValueAt(vo.getEng(), i, 5);;
				model.setValueAt(vo.getMath(), i, 6);;
				model.setValueAt(vo.getScien(), i, 7);;
				model.setValueAt(vo.getTot(), i, 8);;
				model.setValueAt(vo.getAverage(), i, 9);;
			}
			
		}
		public void setScoreVOList(ArrayList<ScoreVO> scoreVOList) {
			this.scoreVOList = scoreVOList;
		}


		public JButton getBtnAdd() {
			return btnAdd;
		}
		
		
		
		public ScoreVO neededInsertData() {
			ScoreVO vo = new ScoreVO();
			vo.setStuId(Integer.parseInt(tf[0].getText()));
			vo.setName(tf[1].getText());
			vo.setGrade(Integer.parseInt(tf[2].getText()));
			vo.setRoomNum(Integer.parseInt(tf[3].getText()));
			vo.setKor(Integer.parseInt(tf[4].getText()));
			vo.setEng(Integer.parseInt(tf[5].getText()));
			vo.setScien(Integer.parseInt(tf[6].getText()));
			vo.setTot();
			vo.setAverage();
			return vo;
		}
		
		public void initInsertData() {
			for(int i=0; i < tf.length;  i++) {
				tf[i].setText("");
			}
		}
		
		public JTable getTable() {
			return table;
		}
		

		

		
		
		
		
		
		
	
}
