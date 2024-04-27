package riddles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowsUI extends JFrame implements ActionListener {

    private JButton setUsernameBtn, playAgainBtn, newUserBtn, exitBtn, submitBtn;
    private JTextField usernameField, answerField;
    private JLabel scoreLabel, questionLabel;

    private Game game;

    public WindowsUI() {
        game = new Game();
        JPanel north = createNorthPanel();
        add(north, BorderLayout.NORTH);
        JPanel south = createSouthPanel();
        add(south, BorderLayout.SOUTH);
        JPanel center = createCenterPanel();
        add(center, BorderLayout.CENTER);

        setTitle("Riddle Game");
        setBounds(300, 300, 500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel createNorthPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Username: ");
        panel.add(label);
        usernameField = new JTextField(8);
        panel.add(usernameField);
        setUsernameBtn = new JButton("Set");
        setUsernameBtn.addActionListener(this);
        panel.add(setUsernameBtn);
        return panel;
    }

    public JPanel createCenterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("<html><h1>RIDDLE</h1></html>");
        titlePanel.add(title);
        JPanel riddlePanel = new JPanel();
        questionLabel = new JLabel("-");
        questionLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        riddlePanel.add(questionLabel);
        JPanel answerPanel = new JPanel();
        JLabel label = new JLabel("Answer:");
        answerPanel.add(label);
        answerField = new JTextField(17);
        answerPanel.add(answerField);
        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(this);
        submitBtn.setEnabled(false);
        answerPanel.add(submitBtn);

        panel.add(titlePanel);
        panel.add(riddlePanel);
        panel.add(answerPanel);
        return panel;
    }

    public JPanel createSouthPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel scorePanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        JLabel label = new JLabel("Score:");
        scorePanel.add(label);
        scoreLabel = new JLabel("/");
        scorePanel.add(scoreLabel);
        playAgainBtn = new JButton("Play Again");
        playAgainBtn.addActionListener(this);
        playAgainBtn.setEnabled(false);
        buttonsPanel.add(playAgainBtn);
        newUserBtn = new JButton("New User");
        newUserBtn.addActionListener(this);
        newUserBtn.setEnabled(false);
        buttonsPanel.add(newUserBtn);
        exitBtn = new JButton("EXIT");
        exitBtn.addActionListener(this);
        buttonsPanel.add(exitBtn);
        panel.add(scorePanel);
        panel.add(buttonsPanel);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == setUsernameBtn) {
            System.out.println("set new user");
            String username = usernameField.getText();
            if(!username.isEmpty()) {
                game.startNewGame();
                game.setUsername(username);
                nextRiddle();
                setUsernameBtn.setEnabled(false);
                submitBtn.setEnabled(true);
            }
        }
        else if(e.getSource() == submitBtn) {
            System.out.println("submit answer");
            String answer = answerField.getText();
            if(!answer.isEmpty()) {
                game.isCorrectAnswer(answer);
                nextRiddle();
            }
        }
        else if(e.getSource() == playAgainBtn) {
            System.out.println("play again");
            game.startNewGame();
            scoreLabel.setText("/");
            submitBtn.setEnabled(true);
            playAgainBtn.setEnabled(false);
            newUserBtn.setEnabled(false);
            nextRiddle();
        }
        else if(e.getSource() == newUserBtn) {
            System.out.println("play as new user");
            usernameField.setText("");
            usernameField.requestFocus();
            scoreLabel.setText("/");
            playAgainBtn.setEnabled(false);
            newUserBtn.setEnabled(false);
            setUsernameBtn.setEnabled(true);
        }
        else if(e.getSource() == exitBtn) {
            System.out.println("exit");
            System.exit(0);
        }
    }

    public void nextRiddle() {
        if(game.hasMoreQuestions()) {
            questionLabel.setText("<html><div style='width: 260px'>" + game.getCurrentQuestion() + "</div></html>");
            answerField.setText("");
            answerField.requestFocus();
        }
        else {
            scoreLabel.setText(game.getScore() + " / 4");
            game.saveScore();
            submitBtn.setEnabled(false);
            playAgainBtn.setEnabled(true);
            newUserBtn.setEnabled(true);
        }
    }
}
