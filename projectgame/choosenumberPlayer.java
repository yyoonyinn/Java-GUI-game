package projectgame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Naisu
 */
public class choosenumberPlayer extends JFrame implements ActionListener, ItemListener, MouseListener {

    // Constructor MainApplication
    private final int frameWidth = 1000, frameHeight = 600;
    private JPanel contentpane;

    //function first_page
    private JButton n;

    //onePlayerMode
    private MyImageIcon background;
    private JLabel drawpane;

    private MyImageIcon selectPlayer;
    private JLabel textLabel;

    private final String[] numPlayer = {" Player 1 ", " Player 2 "};
    private JComboBox numberPlayer;

    private MyImageIcon[] Santapic = new MyImageIcon[3];

    private MyImageIcon santapicfade1;
    private MyImageIcon santapicfade2;
    private MyImageIcon santapicfade3;

    private JLabel[] santapane = new JLabel[3];

    private JLabel namePlayer1;
    private JTextField inputname1;
    private String getnameofplayer1;
    
    private String getnameof1Player = "name";

//    private int choosePlayer ;
    //twoPlayerMode
    private MyImageIcon[] grinchpic = new MyImageIcon[3];

    private JLabel select1;
    private final String[] sancolor = {"red", "orange", "yellow"};
    private JComboBox santacolor;
    private JLabel grinchpane;

    private JLabel namePlayer2;
    private JTextField inputname2;
    private String getnameofplayer2;
    
    private JTextField inputnamePlayer1Mode ;

    private JLabel select2;
    private final String[] grinchcol = {"blue", "green", "purple"};
    private JComboBox grinchcolor;

    private int choosePlayersanta = 0;
    private int choosePlayergrinch = 0;

    private JButton nextSelectPlayer;
    private MyImageIcon nextbuttonImg;
    //setlocation
    private Point position[] = new Point[100];
    private JLabel name;

    //addBoardGame
    private MyImageIcon ladder;
    private JLabel tablepane;
    private JLabel dicesanta;
    private JLabel dicegrinch;

    private MySoundEffect santasound;
    private MySoundEffect grinchsound;
    private MySoundEffect themesound;

    //dice เป็นภาพ gif
    private ImageIcon dice;
    private MyImageIcon rollsanta;
    private MyImageIcon rollgrinch;
    private MyImageIcon grinchframe;

    private int player1;

    Random random = new Random();
    private int numrandom = 0;

    private int numSelect = 0;
    private int playercount1;
    private int playercount2;

    private int soundchoose, soundeffectchoose;

    private int speed;
    MySoundEffect jinglebellSound;

    private String nameofplayer1, nameofplayer2;
    private String colorBackground, colorladder;

    public choosenumberPlayer(int speed, String colorBackground, String colorladder, int sound, int soundeffect) {
        this.colorBackground = colorBackground;
        this.colorladder = colorladder;
        System.out.println(colorBackground + "  " + colorBackground);
        this.speed = speed;       
        this.soundchoose = sound;
        this.soundeffectchoose = soundeffect;
        System.out.println(soundchoose+" "+soundchoose);
        setTitle("Is chirstmas coming to town ?? ");
        setSize(frameWidth, frameHeight);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        contentpane = (JPanel) getContentPane();
        onePlayerMode();
    }

    public void onePlayerMode() {
        //setbackground
        name = new JLabel("Fill in your name and press ENTER");
        name.setBounds(400, 155, 400, 200);
        background = new MyImageIcon("resource/introbg.png").resize(this.getWidth(), this.getHeight());
        drawpane = new JLabel(background);
        drawpane.setLayout(null);
        //หัวข้อว่าselectPlayer
        selectPlayer = new MyImageIcon("resource/Select Player.png").resize(350, 40);
        textLabel = new JLabel(selectPlayer);
        textLabel.setBounds(245, 75, 500, 50);
        //เลือกจำนวนผู้เล่น JCombobox
        numberPlayer = new JComboBox(numPlayer);
        numberPlayer.setBounds(425, 150, 150, 50);
        numberPlayer.setFont(new Font("TimesRoman", Font.BOLD, 25));
        numberPlayer.addItemListener(this);
        //รูปsanta
        Santapic[0] = new MyImageIcon("resource/santa1.PNG").resize(200, 200);
        Santapic[1] = new MyImageIcon("resource/santa2.PNG").resize(200, 200);
        Santapic[2] = new MyImageIcon("resource/santa3.PNG").resize(200, 200);
        //รูปsantaที่fadeแล้ว
        santapicfade1 = new MyImageIcon("resource/nosanta1.png").resize(200, 200);
        santapicfade2 = new MyImageIcon("resource/nosanta2.png").resize(200, 200);
        santapicfade3 = new MyImageIcon("resource/nosanta3.png").resize(200, 200);
        //ใส่santaในหน้าจอ
        //santaสีแดง
        santapane[0] = new JLabel(Santapic[0]);
        santapane[0].setBounds(100, 275, 200, 200);
        santapane[0].addMouseListener(this);
        //santaสีส้ม
        santapane[1] = new JLabel(Santapic[1]);
        santapane[1].setBounds(400, 275, 200, 200);
        santapane[1].addMouseListener(this);
        //santaสีเหลือง
        santapane[2] = new JLabel(Santapic[2]);
        santapane[2].setBounds(700, 275, 200, 200);
        santapane[2].addMouseListener(this);
        //ใส่JTextField
        namePlayer1 = new JLabel("NAME PLAYER 1 : ");
        namePlayer1.setFont(new Font("TimesRoman", Font.BOLD, 14));
        namePlayer1.setBounds(393, 220, 150, 25);
        namePlayer1.setForeground(new Color(11, 3, 124));
        
        inputnamePlayer1Mode = new JTextField("name", 15);
        inputnamePlayer1Mode.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        inputnamePlayer1Mode.setBounds(525, 220, 75, 25);
        inputnamePlayer1Mode.addActionListener(this);
        
        contentpane.add(name);
        contentpane.add(namePlayer1);
        contentpane.add(inputnamePlayer1Mode);
        contentpane.add(santapane[2]);
        contentpane.add(santapane[1]);
        contentpane.add(santapane[0]);
        contentpane.add(numberPlayer);
        contentpane.add(textLabel);
        contentpane.add(drawpane);
        validate();
        if (soundchoose == 1) {
            jinglebellSound = new MySoundEffect("resource/jinglebellsong.wav");
            jinglebellSound.playLoop();
        }
    }

    public void twoPlayerMode() {
        //resizeรูปsantaใหม่
        Santapic[0] = new MyImageIcon("resource/santa1.PNG").resize(200, 200);
        Santapic[1] = new MyImageIcon("resource/santa2.PNG").resize(200, 200);
        Santapic[2] = new MyImageIcon("resource/santa3.PNG").resize(200, 200);
        //รูปตัวgrinch
        grinchpic[0] = new MyImageIcon("resource/grinch1.PNG").resize(200, 200);
        grinchpic[1] = new MyImageIcon("resource/grinch2.PNG").resize(200, 200);
        grinchpic[2] = new MyImageIcon("resource/grinch3.PNG").resize(200, 200);
        //ใส่และsetตัวsantaใหม่ เพราะใช้varเดียวกับonePlayerMode(ของsanta)
        santapane[0].setIcon(Santapic[0]);
        santapane[0].setBounds(145, 200, 200, 200);
        santapane[0].removeMouseListener(this);
        //ใส่และsetJTextใหม่เพราะใช้varเดียวกับonePlayerMode(ของsanta)
        namePlayer1.setBounds(135, 404, 150, 50);
        namePlayer1.setFont(new Font("TimesRoman", Font.BOLD, 12));
        namePlayer1.setForeground(Color.LIGHT_GRAY);
        
        inputname1 = new JTextField("name", 15);
        inputname1.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        inputname1.setBounds(250, 418, 100, 25);
        inputname1.addActionListener(this);
        //ใส่JComboboxเลือกสีตัวsanta
        select1 = new JLabel("CHOOSE ICON 1 : ");
        select1.setFont(new Font("TimesRoman", Font.BOLD, 12));
        select1.setForeground(Color.LIGHT_GRAY);
        select1.setBounds(135, 443, 150, 50);
        santacolor = new JComboBox(sancolor);
        santacolor.setToolTipText("CHOOSE ICON 1 : ");
        santacolor.addItemListener(this);
        santacolor.setBounds(250, 460, 100, 20);
        //ใส่รูปตัวgrinch
        grinchpane = new JLabel(grinchpic[0]);
        grinchpane.setBounds(700, 200, 200, 200);
        //ใส่JTextของตัวgrinch
        namePlayer2 = new JLabel("NAME PLAYER 2 : ");
        namePlayer2.setFont(new Font("TimesRoman", Font.BOLD, 12));
        namePlayer2.setForeground(new Color(123, 123, 127));
        namePlayer2.setBounds(659, 403, 150, 50);
        inputname2 = new JTextField("name", 15);
        inputname2.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        getnameofplayer2 = inputname2.getText();
        inputname2.setBounds(776, 418, 100, 25);
        inputname2.addActionListener(this);
        //ใส่JComboboxเลือกสีตัวgrinch
        select2 = new JLabel("CHOOSE ICON 2 : ");
        select2.setFont(new Font("TimesRoman", Font.BOLD, 12));
        select2.setForeground(new Color(123, 123, 127));
        select2.setBounds(659, 443, 150, 50);
        grinchcolor = new JComboBox(grinchcol);
        grinchcolor.addItemListener(this);
        grinchcolor.setBounds(776, 460, 100, 20);
        //ใส่ปุ่มnext
        nextbuttonImg = new MyImageIcon("resource/next.PNG").resize(150, 70);
        nextSelectPlayer = new JButton(nextbuttonImg);
        nextSelectPlayer.setContentAreaFilled(false);
        nextSelectPlayer.setBorder(null);
        nextSelectPlayer.setBounds(430, 480, 150, 70);
        
        name = new JLabel("Fill in your name and press ENTER");
        name.setBounds(405, 125, 400, 200);
        
        nextSelectPlayer.addActionListener(this);
        contentpane.add(name);
        contentpane.add(nextSelectPlayer);
        contentpane.add(select1);
        contentpane.add(select2);
        contentpane.add(namePlayer1);
        contentpane.add(namePlayer2);
        contentpane.add(santacolor);
        contentpane.add(grinchcolor);
        contentpane.add(inputname1);
        contentpane.add(inputname2);
        contentpane.add(grinchpane);
        contentpane.add(santapane[0]);
        contentpane.add(numberPlayer);
        contentpane.add(textLabel);
        contentpane.add(drawpane);

        repaint();
        validate();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == numberPlayer) {
            if (numberPlayer.getSelectedIndex() == 0) {
                contentpane.removeAll();
                onePlayerMode();
            } else if (numberPlayer.getSelectedIndex() == 1) {
                contentpane.removeAll();
                twoPlayerMode();
            }
        } else if (e.getSource() == santacolor) {
            if (santacolor.getSelectedIndex() == 0) {
                santapane[0].setIcon(Santapic[0]);
                choosePlayersanta = 0;
            } else if (santacolor.getSelectedIndex() == 1) {
                santapane[0].setIcon(Santapic[1]);
                choosePlayersanta = 1;
//                System.out.println("55555");
            } else {
                santapane[0].setIcon(Santapic[2]);
                choosePlayersanta = 2;
            }
        } else if (e.getSource() == grinchcolor) {
            if (grinchcolor.getSelectedIndex() == 0) {
                grinchpane.setIcon(grinchpic[0]);
                choosePlayergrinch = 0;
            } else if (grinchcolor.getSelectedIndex() == 1) {
                grinchpane.setIcon(grinchpic[1]);
                choosePlayergrinch = 1;
            } else {
                grinchpane.setIcon(grinchpic[2]);
                choosePlayergrinch = 2;
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == santapane[0]) {
            contentpane.removeAll();
            choosePlayersanta = 0;
            choosePlayergrinch = 0;
            oneplayer n = new oneplayer(choosePlayersanta, speed, getnameof1Player, colorBackground, colorladder, soundchoose, soundeffectchoose);
            if(soundchoose == 1)
            jinglebellSound.stop();
            setVisible(false);
            dispose();
        } 
        else if (e.getSource() == santapane[1]) {
            contentpane.removeAll();
            choosePlayersanta = 1;
            choosePlayergrinch = 0;
            oneplayer n = new oneplayer(choosePlayersanta, speed, getnameof1Player, colorBackground, colorladder, soundchoose, soundeffectchoose);
            if(soundchoose == 1)jinglebellSound.stop();
            setVisible(false);
            dispose();    
        } 
        else if (e.getSource() == santapane[2]) {
            contentpane.removeAll();
            choosePlayersanta = 2;
            choosePlayergrinch = 0;
            player1 = 1;
            oneplayer n = new oneplayer(choosePlayersanta, speed, getnameof1Player, colorBackground, colorladder, soundchoose, soundeffectchoose);
            if(soundchoose == 1)jinglebellSound.stop();
            setVisible(false);
            dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setCursor(Cursor.HAND_CURSOR);
        if (e.getSource() == santapane[0]) {
            santapane[0].setIcon(santapicfade1);
        } else if (e.getSource() == santapane[1]) {
            santapane[1].setIcon(santapicfade2);
        } else if (e.getSource() == santapane[2]) {
            santapane[2].setIcon(santapicfade3);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setCursor(Cursor.DEFAULT_CURSOR);
        if (e.getSource() == santapane[0]) {
            santapane[0].setIcon(Santapic[0]);
        } else if (e.getSource() == santapane[1]) {
            santapane[1].setIcon(Santapic[1]);
        } else if (e.getSource() == santapane[2]) {
            santapane[2].setIcon(Santapic[2]);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextSelectPlayer) {
            System.out.println(player1);
            MaingametwoPlayer m = new MaingametwoPlayer(choosePlayersanta, choosePlayergrinch, speed, nameofplayer1, nameofplayer2, colorBackground, colorladder,soundchoose,soundeffectchoose);
            if(soundchoose == 1)jinglebellSound.stop();
            setVisible(false);
            dispose();  
        } 
        else if (e.getSource() == inputname1) {
            nameofplayer1 = inputname1.getText();
            System.out.println(nameofplayer1);
        } 
        else if (e.getSource() == inputname2) {
            nameofplayer2 = inputname2.getText();
            System.out.println(nameofplayer2);
        }
        else if (e.getSource() == inputnamePlayer1Mode) {
            getnameof1Player = inputnamePlayer1Mode.getText();
            System.out.println(inputnamePlayer1Mode);
        } 
    }

}
