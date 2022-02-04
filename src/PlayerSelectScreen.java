
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//needs massive aesthetic rewrites
public class PlayerSelectScreen extends JPanel {

    JButton go;
    JButton quit;
    MainWindow mw;

    JRadioButton opt1;
    JRadioButton opt2;
    JRadioButton opt3;

    public void quitButtonActionListener() {
        mw.showCard("One");
    }

    public void goButtonActionListener() {
        playerOptions();
        mw.s4.setUpPlayers();
        mw.showCard("Three");
    }

    public void playerOptions() {
        int m = 5;
        if (opt1.isSelected() == true) {
            m = 1;
        } else if (opt2.isSelected() == true) {
            m = 2;
        } else if (opt3.isSelected() == true) {
            m = 3;
        }
        mw.s4.setMaxPlayers(m);
    }

    public PlayerSelectScreen(MainWindow mw) {
        this.mw = mw;
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);

        setLayout(boxLayout);
        String select_Players = "Select Players: ";

        JLabel mess = new JLabel(select_Players);
        add(mess);
        String default_1Player = "Default: 1Player";

        JLabel uc = new JLabel(default_1Player);
        add(uc);

        //set up radio buttons
        String PlayerDefault = "1 Player(Default)";
        opt1 = new JRadioButton(PlayerDefault);
        opt1.setSelected(true);
        
        String twoPlayers = "2 Players";
        opt2 = new JRadioButton(twoPlayers);
        
        String threePlayers = "3 Players";
        opt3 = new JRadioButton(threePlayers);

        ButtonGroup grp = new ButtonGroup();
        grp.add(opt1);
        grp.add(opt2);
        grp.add(opt3);

        add(opt1);
        add(opt2);
        add(opt3);

        ActionListener actionListenerPlayerOption = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                playerOptions();
            }
        };

        opt1.addActionListener(actionListenerPlayerOption);
        opt2.addActionListener(actionListenerPlayerOption);
        opt3.addActionListener(actionListenerPlayerOption);

        String customize_Board = "Customize Board";
        go = new JButton(customize_Board);

        String back = "Back";
        quit = new JButton(back);

        ActionListener actionListenerGo = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                goButtonActionListener();
            }
        };
        go.addActionListener(actionListenerGo);

        ActionListener actionListenerQuit = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                quitButtonActionListener();
            }
        };
        quit.addActionListener(actionListenerQuit);

        add(go);
        add(quit);

    }

}
