/************************************************************************************************************
* Developer: Minhas Kamal(BSSE-0509, IIT, DU)																*
* Date: 03-Dec-2013; Modified: 10-Jun-2014																	*
* Comment: This is my first game using Graphics. Actually this is my 5th version of the game most parts are	*									
* 	as it were in the previous versions. The first version was written in C which had no graphics. Then I	*
* 	Made 2nd version, again in C, which had some extended features then I made This game in Java(3rd 		*
* 	version) it had no graphical interface too. Next I made the game with a GUI(4th). But the graphics was	*
* 	not good enough and it was very low in design perspective. So I made this 5th version. I think it is 	*
* 	good. :)																								*
*************************************************************************************************************/

package mainFrame.gui;


import help.about.gui.About;
import help.developer.gui.Profile;
import help.instruction.gui.Instruction;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import robot.operation.ComputerMove;

import mainFrame.operation.Move;
import mainFrame.operation.Verification;


@SuppressWarnings("serial")
public class Frame extends JFrame {
	//**
	// Variable Declaration 																				#*******D*******#
	//**
	private JLabel jLabelMain;
	private JLabel jLabelCourt;
	private JLabel[] jLabelCourtCells;
	private JLabel[] jLabelActivePlayer;
	private JLabel[] jLabelPlayers;
	private JTextField[] jTextFieldsPlayer;
	private JLabel jLabelResult;
	
	private JMenuBar jMenuBarMain;
	private JMenu jMenuMode, jMenuOptions, jMenuHelp;
	private JCheckBoxMenuItem jCBMIHumanVsHuman, jCBMIAbirVsHuman, jCBMIAloyVsHuman;
	private JMenuItem jMINewGame, jMIPlayer2First;
	private JMenuItem jMIInstruction, jMIDeveloper, jMIAbout;
	
	//operational variables
	private Move move;
	private Verification verification;
	private ComputerMove computerMove;
	
	private int mode;		//3 types of mode; mode=1 HumanVsHuman,  mode=2 AbirVsHuman,  mode=3 AloyVsHuman
	private int player;		//player giving move
	private int moveNo;		//number of moves given 0<=move<=9
	// End of Variable Declaration 																			#_______D_______#

	/***##Constructor##***/
	public Frame(int mode) {
		this.mode = mode;	//playing mode
		
		initialComponent();
		initialOperation();
	}

	
	/**
	 * Method for Initializing all the GUI variables, placing them all to specific space on the frame and adding action
	 * listener to them. Also specifies criteria of the main frame.
	 */
	private void initialComponent() {
		//**
		// Initialization 																					#*******I*******#
		//**
		jLabelMain = new JLabel();
		jLabelCourt = new JLabel();
		jLabelCourtCells = new JLabel[9];
		jLabelActivePlayer = new JLabel[2];
		jLabelPlayers = new JLabel[2];
		jTextFieldsPlayer = new JTextField[2];
		jLabelResult = new JLabel();
		
		jMenuBarMain = new JMenuBar();
		jMenuMode = new JMenu(); jMenuOptions = new JMenu(); jMenuHelp = new JMenu();
		jCBMIHumanVsHuman = new JCheckBoxMenuItem(); jCBMIAbirVsHuman = new JCheckBoxMenuItem(); 
				jCBMIAloyVsHuman = new JCheckBoxMenuItem();
		jMINewGame = new JMenuItem(); jMIPlayer2First = new JMenuItem();
		jMIInstruction = new JMenuItem(); jMIDeveloper = new JMenuItem(); jMIAbout = new JMenuItem();
		
		//operational variables
		move = new Move();
		verification = new Verification();
		computerMove = new ComputerMove();
		
		player = 1;	//Player-1 gives first move in default
		moveNo = 0;	//no move is given yet
		// End of Initialization																			#_______I_______#

		//**
		// Setting Bounds and Attributes of the Elements 													#*******S*******#
		//**
		jLabelMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainFrame/pictures/MainBackGround.png")));
		jLabelMain.setBounds(0, 0, 360, 500);
		jLabelMain.setLayout(null);
		
		jLabelCourt.setBounds(60, 160, 235, 235);
		jLabelCourt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainFrame/pictures/Board.png")));
		
		for(int i=0; i<9; i++){
			jLabelCourtCells[i] = new JLabel();
			jLabelCourtCells[i].setSize(65, 65);
			jLabelCourtCells[i].setLocation((i%3)*70 + 15, (i/3)*70 + 15);
			
			final int j=i;
			jLabelCourtCells[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					jLabelCourtCellsActionPerformed(j);
	            }
	        });
		}
//		jLabelCourtCells[1].addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent arg0) {
//				jLabelCourtCellsActionPerformed(1);
//            }
//        });
//		jLabelCourtCells[2].addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent arg0) {
//				jLabelCourtCellsActionPerformed(2);
//            }
//        });
//		jLabelCourtCells[3].addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent arg0) {
//				jLabelCourtCellsActionPerformed(3);
//            }
//        });
//		jLabelCourtCells[4].addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent arg0) {
//				jLabelCourtCellsActionPerformed(4);
//            }
//        });
//		jLabelCourtCells[5].addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent arg0) {
//				jLabelCourtCellsActionPerformed(5);
//            }
//        });
//		jLabelCourtCells[6].addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent arg0) {
//				jLabelCourtCellsActionPerformed(6);
//            }
//        });
//		jLabelCourtCells[7].addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent arg0) {
//				jLabelCourtCellsActionPerformed(7);
//            }
//        });
//		jLabelCourtCells[8].addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent arg0) {
//				jLabelCourtCellsActionPerformed(8);
//            }
//        });
		
		for(int i=0; i<2; i++){
			jLabelActivePlayer[i] = new JLabel();
			jLabelActivePlayer[i].setSize(320, 45);
			jLabelActivePlayer[i].setLocation(15, 50*i+45);		
		}
		jLabelActivePlayer[player-1].setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/mainFrame/pictures/ActivePlayer.png")));
		
		for(int i=0; i<2; i++){
			jLabelPlayers[i] = new JLabel();
			jLabelPlayers[i].setText("Player - " + (i+1));
			jLabelPlayers[i].setFont(new java.awt.Font("Bell MT", 1, 22));
			jLabelPlayers[i].setSize(100, 35);
			jLabelPlayers[i].setLocation(5, 5);			
		}
		
		for(int i=0; i<2; i++){
			jTextFieldsPlayer[i] = new JTextField();
			jTextFieldsPlayer[i].setText("Player " + (i+1));
			jTextFieldsPlayer[i].setFont(new java.awt.Font("Lucida Bright", 1, 18));
			jTextFieldsPlayer[i].setSize(205, 35);
			jTextFieldsPlayer[i].setLocation(110, 5);			
		}
		
		jLabelResult.setBounds(27, 398, 300, 42);
		jLabelResult.setFont(new java.awt.Font("Gabriola", 1, 28));
		jLabelResult.setHorizontalAlignment(0);
		jLabelResult.setText("Player-"+player+"'s Turn");
		jLabelResult.setForeground(new java.awt.Color(0, 70, 35));
		//jLabelResult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainFrame/pictures/ko.png")));

		//menus
		jMenuMode.setText("Mode     ");
		jMenuMode.setFont(new java.awt.Font("Lucida Bright", 1, 13));
		jMenuMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainFrame/pictures/IconMode.png")));
		jMenuOptions.setText("Options     ");
		jMenuOptions.setFont(new java.awt.Font("Lucida Bright", 1, 13));
		jMenuOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainFrame/pictures/IconOption.png")));
		jMenuHelp.setText("Help     ");
		jMenuHelp.setFont(new java.awt.Font("Lucida Bright", 1, 13));
		jMenuHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainFrame/pictures/IconHelp.png")));
		
		//menu items
		jCBMIHumanVsHuman.setText("  Human Vs Human");
		jCBMIHumanVsHuman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainFrame/pictures/IconHumanVsHuman.png")));
		jCBMIHumanVsHuman.setFont(new java.awt.Font("Lucida Bright", 3, 15));
    	jCBMIHumanVsHuman.addActionListener(new java.awt.event.ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			jCBMIVsActionPerformed(1);
    		}
    	});
		jCBMIAbirVsHuman.setText("  Abir Vs Human"); 
		jCBMIAbirVsHuman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainFrame/pictures/IconHumanVsAbir.png")));
		jCBMIAbirVsHuman.setFont(new java.awt.Font("Lucida Bright", 3, 15));
    	jCBMIAbirVsHuman.addActionListener(new java.awt.event.ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			jCBMIVsActionPerformed(2);
    		}
    	});
		jCBMIAloyVsHuman.setText("  Aloy Vs Human");
		jCBMIAloyVsHuman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainFrame/pictures/IconHumanVsAloy.png")));
		jCBMIAloyVsHuman.setFont(new java.awt.Font("Lucida Bright", 3, 15));
    	jCBMIAloyVsHuman.addActionListener(new java.awt.event.ActionListener() {
    		public void actionPerformed(java.awt.event.ActionEvent evt) {
    			jCBMIVsActionPerformed(3);
    		}
    	});
		
		jMINewGame.setText("New Game");
		jMINewGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainFrame/pictures/IconNewGame.png")));
		jMINewGame.setFont(new java.awt.Font("Lucida Bright", 2, 13));
    	jMINewGame.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		jMINewGameActionPerformed();
        	}
        });
    	jMIPlayer2First.setText("Player-2 First");
    	jMIPlayer2First.setToolTipText("Let Player-2 give first move");
    	jMIPlayer2First.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainFrame/pictures/IconPlayer2First.png")));
    	jMIPlayer2First.setFont(new java.awt.Font("Lucida Bright", 2, 13));
    	jMIPlayer2First.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		jMIPlayer2FirstActionPerformed();
        	}
        });
        
		jMIInstruction.setText("Instruction"); 
		jMIInstruction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainFrame/pictures/IconInstruction.png")));
		jMIInstruction.setFont(new java.awt.Font("Lucida Bright", 2, 13));
    	jMIInstruction.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		jMIInstructionActionPerformed(evt);
        	}
        });
		jMIDeveloper.setText("Developer"); 
		jMIDeveloper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainFrame/pictures/IconDeveloper.png")));
		jMIDeveloper.setFont(new java.awt.Font("Lucida Bright", 2, 13));
    	jMIDeveloper.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		jMIDeveloperActionPerformed(evt);
        	}
        });
		jMIAbout.setText("About");
		jMIAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainFrame/pictures/IconAbout.png")));
		jMIAbout.setFont(new java.awt.Font("Lucida Bright", 2, 13));
    	jMIAbout.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		jMIAboutActionPerformed(evt);
        	}
        });
		// End of Setting Bounds and Attributes 															#_______S_______#
		
		//**
		// Adding Components 																				#*******A*******#
		//**
		jLabelMain.add(jLabelCourt);
		
		for(int i=0; i<9; i++){
			jLabelCourt.add(jLabelCourtCells[i]);
		}
		
		for(int i=0; i<2; i++){
			jLabelMain.add(jLabelActivePlayer[i]);
		}
		for(int i=0; i<2; i++){
			jLabelActivePlayer[i].add(jLabelPlayers[i]);
			jLabelActivePlayer[i].add(jTextFieldsPlayer[i]);
		}
		
		jLabelMain.add(jLabelResult);
		
		jMenuBarMain.add(jMenuMode); jMenuBarMain.add(jMenuOptions); jMenuBarMain.add(jMenuHelp);
		
		jMenuMode.add(jCBMIHumanVsHuman); jMenuMode.add(jCBMIAbirVsHuman); jMenuMode.add(jCBMIAloyVsHuman);
		jMenuOptions.add(jMINewGame); jMenuOptions.add(jMIPlayer2First);
		jMenuHelp.add(jMIInstruction); jMenuHelp.add(jMIDeveloper); jMenuHelp.add(jMIAbout);
		// End of Adding Components 																		#_______A_______#

		//**Setting Criterion of the Frame**//
		setIconImage(new ImageIcon(getClass().getResource("/mainFrame/pictures/Icon.png")).getImage());
		setBounds(200, 100, 360, 500);
		setTitle("Criss-Cross");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		add(jLabelMain);
		setJMenuBar(jMenuBarMain);
	}

	//**
	// Action Events 																						#********AE*******#
	//**
	private void jLabelCourtCellsActionPerformed(int cellNo){
		if(jLabelCourtCells[cellNo].isFocusable()){
			ImageIcon icon;
			char symbol;
			int nextPlayer;
			
	    	if(player==1){ 
	    		icon = new ImageIcon(getClass().getResource("/mainFrame/pictures/X.png"));
	    		symbol = 'X';
	    		nextPlayer = 2;
	    	}else {
	        	icon = new ImageIcon(getClass().getResource("/mainFrame/pictures/O.png"));
	    		symbol = 'O';
	    		nextPlayer = 1;
	        }
	    	
	
			jLabelCourtCells[cellNo].setIcon(icon);
			jLabelCourtCells[cellNo].setFocusable(false);
			
			move.setMove(cellNo/3, cellNo%3, symbol);
	        
	        
			moveNo++;
	        
	        if(verification.verify(move)!=0){
	        	WinOperation(player);
	        }else if(moveNo==9){
	        	drawOperation();
	        }else{
	        	jLabelResult.setText("Player-"+nextPlayer+"'s Turn");
	        	jLabelActivePlayer[player-1].setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("")));
	    		jLabelActivePlayer[nextPlayer-1].setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/mainFrame/pictures/ActivePlayer.png")));
	        }
	        
	        player = nextPlayer;
	        
	        //for computer move
	        if((moveNo<9) && (mode==2 || mode==3)){
	        	ComputerTurn(cellNo);
	        }
	        
		}
	}
	
	private void jCBMIVsActionPerformed(int mod){
		refresh(1);
		mode=mod;
		initialOperation();
	}
	
	private void jMINewGameActionPerformed(){
		refresh(1);
	}
	
	private void jMIPlayer2FirstActionPerformed(){
		refresh(2);
				
		if(mode==2 || mode==3){
			ComputerTurn(-1);
		}
		
		jMIPlayer2First.setEnabled(false);
	}
	
	private void jMIInstructionActionPerformed(ActionEvent evt){
		new Instruction().setVisible(true);
	}
  	private void jMIDeveloperActionPerformed(ActionEvent evt) {                                         
		new Profile("11-Jun-2014").setVisible(true);
  	} 
  	private void jMIAboutActionPerformed(ActionEvent evt){
  		new About().setVisible(true);
  	}
	// End of Action Events 																				#________AE_______#

	/********* Main Method *********/
	public static void main(String args[]) {
		/*// Set the NIMBUS look and feel //*/
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception ex) {
			// do nothing if operation is unsuccessful
		}

		/* Create and display the form */
		Frame gui = new Frame(1);
		gui.setVisible(true);
	}

	//**
	// Auxiliary Methods 																					#********AM*******#
	//**
	private void initialOperation(){
		jCBMIHumanVsHuman.setSelected(false);
		jCBMIAbirVsHuman.setSelected(false);
		jCBMIAloyVsHuman.setSelected(false);
		
		if(mode==1){
			jCBMIHumanVsHuman.setSelected(true);
			jTextFieldsPlayer[1].setText("Player 2");
			jTextFieldsPlayer[1].setEditable(true);
		}else if(mode==2){
			jCBMIAbirVsHuman.setSelected(true);
    		jTextFieldsPlayer[1].setText("" + (char)258 + (char)98 + (char)301 + (char)343);
    		jTextFieldsPlayer[1].setEditable(false);
    	}else if(mode==3){
    		jCBMIAloyVsHuman.setSelected(true);
    		jTextFieldsPlayer[1].setText("" + (char)258 + (char)316 + (char)335 + (char)255);
    		jTextFieldsPlayer[1].setEditable(false);
    	}
	}
	
	private void refresh(int pler){
		player = pler;	//Player-1 gives first move in default
		moveNo = 0;	//no move is given yet
		for(int i=0; i<9; i++){
			jLabelCourtCells[i].setFocusable(true);
			jLabelCourtCells[i].setIcon(null);
		}
		
		move.initialize();
		jLabelResult.setText("Player-"+player+"'s Turn");
		jLabelActivePlayer[player-1].setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/mainFrame/pictures/ActivePlayer.png")));
		jLabelActivePlayer[2-player].setIcon(null);
		
		jMIPlayer2First.setEnabled(true);
	}
	
	private void ComputerTurn(int humnSelection){	//works with computer move    	
		int cMove;
		
		while(true){	//my computer logic can give wrong answer too so for safety use a loop
	    	cMove = computerMove.move(moveNo, humnSelection+1, mode-1, move)-1;
	    	
	    	if(jLabelCourtCells[cMove].isFocusable()) break;
    	}
    	
		ImageIcon icon;
		char symbol;
		int nextPlayer;
		
    	if(player==1){ 
    		icon = new ImageIcon(getClass().getResource("/mainFrame/pictures/X.png"));
    		symbol = 'X';
    		nextPlayer = 2;
    	}else {
        	icon = new ImageIcon(getClass().getResource("/mainFrame/pictures/O.png"));
    		symbol = 'O';
    		nextPlayer = 1;
        }
		
    	jLabelCourtCells[cMove].setIcon(icon);
		jLabelCourtCells[cMove].setFocusable(false);
		
		move.setMove(cMove/3, cMove%3, symbol);
        
    	moveNo++;
    	
    	if(verification.verify(move)!=0){
    		WinOperation(player);
    	}else if(moveNo==9){
    		drawOperation();
    	}else{
    		jLabelResult.setText("Player-"+nextPlayer+"'s Turn");
    		jLabelActivePlayer[player-1].setIcon(null);
    		jLabelActivePlayer[nextPlayer-1].setIcon(new javax.swing.ImageIcon(getClass()
					.getResource("/mainFrame/pictures/ActivePlayer.png")));
    	}
    	
    	player=nextPlayer;
    }
	
	private void drawOperation(){
    	jLabelResult.setText("The Match is draw!");
    }
    
    private void WinOperation(int pla){
    	jLabelResult.setText(jTextFieldsPlayer[pla-1].getText() + " Wins !");
    	
    	for(int i=0; i<9; i++){
    		jLabelCourtCells[i].setFocusable(false);
    	}
    }
	// End of Auxiliary Methods 																			#________AM_______#
}
