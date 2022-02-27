import javax.swing.*;
import javax.swing.border.Border;
import java.util.Random;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RockPaperScissorsFrame extends JFrame {

    Border blackline, raisedetched, loweredetched,
            raisedbevel, loweredbevel, empty;
    JPanel main;

    JPanel titlePnl;
    JLabel title;
    ImageIcon game;
    JTextArea results;
    JScrollPane resultsScroller;

    JPanel choicePnl;

    int playerChoice = 0;
    int aiChoice = 0;
    Random rnd;

    JButton rockBtn;
    ImageIcon rockIco;
    JButton paperBtn;
    ImageIcon paperIco;
    JButton scissorBtn;
    ImageIcon scissorIco;

    JPanel winCntPnl;

    JLabel usrWins;
    ImageIcon userIco;
    JLabel aiWins;
    ImageIcon aiIco;
    JLabel ties;
    ImageIcon tieIco;
    JTextField usrWinField;
    int usrWinCnt = 0;
    JTextField aiWinField;
    int aiWinCnt = 0;
    JTextField tieCntField;
    int tieCnt = 0;

    JButton quitBtn;
    ImageIcon quitIco;

    public RockPaperScissorsFrame(){
        main = new JPanel();
        main.setLayout(new BorderLayout());
        setSize(900, 900);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ROCK PAPER SCISSORS GAME");
        add(main);

        CreateTitlePnl();
        main.add(titlePnl, BorderLayout.NORTH);

        CreateChoicePnl();
        main.add(choicePnl, BorderLayout.SOUTH);

        CreateWinCntPnl();
        main.add(winCntPnl, BorderLayout.CENTER);

    }
    private void CreateTitlePnl(){
        titlePnl = new JPanel();
        titlePnl.setLayout(new BorderLayout());

        game = new ImageIcon("game.png");
        title = new JLabel("ROCK PAPER SCISSORS", game, JLabel.CENTER);
        title.setFont(new Font("Dialog", Font.BOLD, 50));
        title.setVerticalTextPosition(JLabel.NORTH);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.NORTH);
        titlePnl.add(title, BorderLayout.NORTH);

        results = new JTextArea(8, 25);
        results.setFont(new Font("UbuntuMono", Font.PLAIN, 16));
        results.setEditable(false);
        resultsScroller = new JScrollPane(results);
        resultsScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        titlePnl.add(resultsScroller, BorderLayout.CENTER);

    }
    private void CreateChoicePnl(){
        choicePnl = new JPanel();
        raisedbevel = BorderFactory.createRaisedBevelBorder();
        choicePnl.setBorder(raisedbevel);
        choicePnl.setLayout(new GridLayout(1, 4));

        rockIco = new ImageIcon("rockIco.png");
        rockBtn = new JButton("ROCK", rockIco);
        rockBtn.setVerticalTextPosition(JButton.BOTTOM);
        rockBtn.setHorizontalTextPosition(JButton.CENTER);
        rockBtn.setFont(new Font("Dialog", Font.BOLD, 15));
        choicePnl.add(rockBtn);

        rockBtn.addActionListener((ActionEvent ae) ->{
            playerChoice = 1;
            rnd = new Random();
            aiChoice = rnd.nextInt(3) + 1;
            if(aiChoice == 1){
                results.append("Tie Game!\n\n");
                tieCnt = tieCnt + 1;
                tieCntField.setText(String.valueOf(tieCnt));
            }
            if(aiChoice == 2){
                results.append("Paper Covers Rock. AI Wins!\n\n");
                aiWinCnt = aiWinCnt + 1;
                aiWinField.setText(String.valueOf(aiWinCnt));
            }
            if(aiChoice == 3){
                results.append("Rock Crushes Scissors. You Win!\n\n");
                usrWinCnt = usrWinCnt + 1;
                usrWinField.setText(String.valueOf(usrWinCnt));
            }
        });

        paperIco = new ImageIcon("paperIco.png");
        paperBtn = new JButton("PAPER", paperIco);
        paperBtn.setVerticalTextPosition(JButton.BOTTOM);
        paperBtn.setHorizontalTextPosition(JButton.CENTER);
        paperBtn.setFont(new Font("Dialog", Font.BOLD, 15));
        choicePnl.add(paperBtn);

        paperBtn.addActionListener((ActionEvent ae) ->{
            playerChoice = 2;
            rnd = new Random();
            aiChoice = rnd.nextInt(3) + 1;
            if(aiChoice == 1){
                results.append("Paper Covers Rock. You Win!\n\n");
                usrWinCnt = usrWinCnt + 1;
                usrWinField.setText(String.valueOf(usrWinCnt));
            }
            if(aiChoice == 2){
                results.append("Tie Game!\n\n");
                tieCnt = tieCnt + 1;
                tieCntField.setText(String.valueOf(tieCnt));
            }
            if(aiChoice == 3){
                results.append("Scissors Cut Paper. AI Wins!\n\n");
                aiWinCnt = aiWinCnt + 1;
                aiWinField.setText(String.valueOf(aiWinCnt));
            }
        });

        scissorIco = new ImageIcon("scissorIco.png");
        scissorBtn = new JButton("SCISSORS", scissorIco);
        scissorBtn.setVerticalTextPosition(JButton.BOTTOM);
        scissorBtn.setHorizontalTextPosition(JButton.CENTER);
        scissorBtn.setFont(new Font("Dialog", Font.BOLD, 15));

        scissorBtn.addActionListener((ActionEvent ae) ->{
            playerChoice = 3;
            rnd = new Random();
            aiChoice = rnd.nextInt(3) + 1;
            if(aiChoice == 1){
                results.append("Rock Crushes Scissors. AI Wins!\n\n");
                aiWinCnt = aiWinCnt + 1;
                aiWinField.setText(String.valueOf(aiWinCnt));
            }
            if(aiChoice == 2){
                results.append("Scissors Cut Paper. You win!\n\n");
                usrWinCnt = usrWinCnt + 1;
                usrWinField.setText(String.valueOf(usrWinCnt));
            }
            if(aiChoice == 3){
                results.append("AI Chose Scissors. Tie Game!\n\n");
                tieCnt = tieCnt + 1;
                tieCntField.setText(String.valueOf(tieCnt));
            }
        });

        choicePnl.add(scissorBtn);

        quitIco = new ImageIcon("quitIco.png");
        quitBtn = new JButton("QUIT", quitIco);
        quitBtn.setVerticalTextPosition(JButton.BOTTOM);
        quitBtn.setHorizontalTextPosition(JButton.CENTER);
        quitBtn.setFont(new Font("Dialog", Font.BOLD, 15));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        choicePnl.add(quitBtn);

    }
    private void aiChoice(){

    }
    private void CreateWinCntPnl(){
        winCntPnl = new JPanel();
        winCntPnl.setBackground(Color.WHITE);
        winCntPnl.setLayout(new GridLayout(0, 1));

        userIco = new ImageIcon("userIco.png");
        usrWins = new JLabel("User Win Count", userIco, JLabel.CENTER);
        usrWins.setFont(new Font("Oswald", Font.PLAIN, 16));
        usrWins.setVerticalTextPosition(JLabel.BOTTOM);
        usrWins.setHorizontalTextPosition(JLabel.CENTER);

        usrWinField = new JTextField();
        usrWinField.setHorizontalAlignment(JTextField.CENTER);
        empty = BorderFactory.createEmptyBorder();
        usrWinField.setBorder(empty);
        usrWinField.setFont(new Font("Jersey M54", Font.PLAIN, 18));
        usrWinField.setEditable(false);

        tieIco = new ImageIcon("tieIco.png");
        ties = new JLabel("Tie Count", tieIco, JLabel.CENTER);
        ties.setFont(new Font("Oswald", Font.PLAIN, 16));
        ties.setVerticalTextPosition(JLabel.BOTTOM);
        ties.setHorizontalTextPosition(JLabel.CENTER);

        tieCntField = new JTextField();
        tieCntField.setHorizontalAlignment(JTextField.CENTER);
        tieCntField.setBorder(empty);
        tieCntField.setFont(new Font("Jersey M54", Font.PLAIN, 18));
        tieCntField.setEditable(false);

        aiIco = new ImageIcon("aiIco.png");
        aiWins = new JLabel("AI Win Count", aiIco, JLabel.CENTER);
        aiWins.setFont(new Font("Oswald", Font.PLAIN, 16));
        aiWins.setVerticalTextPosition(JLabel.BOTTOM);
        aiWins.setHorizontalTextPosition(JLabel.CENTER);

        aiWinField = new JTextField();
        aiWinField.setHorizontalAlignment(JTextField.CENTER);
        aiWinField.setBorder(empty);
        aiWinField.setFont(new Font("Jersey M54", Font.PLAIN, 18));
        aiWinField.setEditable(false);

        winCntPnl.add(usrWins);
        winCntPnl.add(usrWinField);
        winCntPnl.add(ties);
        winCntPnl.add(tieCntField);
        winCntPnl.add(aiWins);
        winCntPnl.add(aiWinField);
    }
}