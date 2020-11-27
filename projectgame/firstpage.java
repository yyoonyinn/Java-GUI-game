/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgame;

import java.awt.*;
import java.awt.EventQueue;
import javax.swing.Timer;
import java.awt.event.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Hashtable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class firstpage extends JFrame implements ItemListener,ActionListener {

    //frame
    private int frameWidth = 1000, frameHeight = 600;
    private JPanel contentpane;

    //Menus_AddComponent
    private JLabel Menu_drawpane, snowpane;
    private JButton settingpane, startpane, exitpane, howtoplaypane;
    private MyImageIcon backgroundImg, settingImg,settingfadeImg, startImg,startfadeImg, exitImg,exitfadeImg, howtoplayImg,howtoplayfadeImg, snow1Img, snow2Img, introducebg;
    private MySoundEffect jinglebellSound;
    private Thread snowthread;

    //Dialog
    private JDialog setting;
    private JPanel firstPanel, secondPanel , thirdPanel;
    private JLabel thirdPane,soundoption,bgcolour,speedofchar,blue,purple,yellow;
    private JCheckBox  themesong, soundeffect;
    private JSlider speedSlider;
    private JRadioButton blueradio,purpleradio,yellowradio;
    private ButtonGroup radioGroup;
    private Font headfont, bodyfont;

    //introduce game
    private Font comboFont, comboFontmain;
    private int TextLength1 = 0, TextLength2 = 0, TextLength3 = 0, TextLength4 = 0, TextLength5 = 0, TextLength6 = 0;
    private Timer tm1, tm2, tm3, tm4, tm5, tm6;
    private int counter1 = 0, counter2 = 0, counter3 = 0, counter4 = 0, counter5 = 0, counter6 = 0;
    private JLabel introducepane, bigsantapane, biggrinchpane, whiteblockpane1, whiteblockpane2, whitenarratepane;
    private MyImageIcon bigsantaImg, biggrinchImg, whiteblockgrinchImg, whiteblocksantaImg, whitenarrateImg;
    private MySoundEffect textSound1, textSound2, textSound3;
    
    //main game
    private JLabel dp,tp,testlabel;
    private MyImageIcon bg,ladder,test;
    private MyImageIcon DiceGrinchImg,DiceSantaImg, GrinchTagImg,GrinchTagDarkImg,SantaTagImg,SantaTagDarkImg,RedlampImg,RedlampDarkImg,GreenlampImg,GreenlampDarkImg,YTredImg,YTgreenImg,YTredDarkImg,YTgreenDarkImg,RedGiveupImg,GreenGiveupImg;
    private JLabel DiceGrinch,DiceSanta ,GrinchTag,GrinchTagDark,SantaTag,SantaTagDark,Redlamp,RedlampDark,Greenlamp,GreenlampDark,YTred,YTgreen,YTredDark,YTgreenDark,RedGiveup,GreenGiveup;        
    private int speed = 300;
    private String colorBackground="resource/bgblue.png" ,colorladder = "resource/tableblue.png";
    
    //how to play
    private MyImageIcon nexthowtoplayImg,backhowtoplayImg,gotomenuImg;
    private JButton next_1,next_2,next_3,next_4,next_5,back_1,back_2,back_3,back_4,back_5,gotomenu;
    private MyImageIcon htw_page_1_Img, htw_page_2_Img,htw_page_3_Img,htw_page_4_Img,htw_page_5_Img,htw_page_6_Img;
    private JLabel htw_page_1,speedgif, htw_page_2,htw_page_3,htw_page_4,htw_page_5,htw_page_6;
    private ImageIcon speedgifImg;
    
    private int soundchoose = 1,soundeffectchoose = 1;

    public firstpage() {
        setTitle("Is chirstmas coming to town ?? ");
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        contentpane = (JPanel) getContentPane();
        contentpane.setLayout(new BorderLayout());
        Menu_AddComponents();
        Menu_addListen();
        setSnowThread();

    }

    //addcomponent 1st frame
    public void Menu_AddComponents() {
        backgroundImg = new MyImageIcon("resource/firstbg.png");
        settingImg = new MyImageIcon("resource/setting.png").resize(80, 85);
        settingfadeImg = new MyImageIcon("resource/settingfade.png").resize(80, 85);
        startImg = new MyImageIcon("resource/start.png");
        startfadeImg = new MyImageIcon("resource/startfade.png");
        exitImg = new MyImageIcon("resource/exit.png");
        exitfadeImg = new MyImageIcon("resource/exitfade.png");
        howtoplayImg = new MyImageIcon("resource/howtoplay.png");
        howtoplayfadeImg = new MyImageIcon("resource/howtoplayfade.png");
        snow1Img = new MyImageIcon("resource/snow1.png");
        snow2Img = new MyImageIcon("resource/snow2.png");
       
        jinglebellSound = new MySoundEffect("resource/jinglebellsong.wav");
        jinglebellSound.playLoop();
        

        Menu_drawpane = new JLabel();
        Menu_drawpane.setIcon(backgroundImg);
        Menu_drawpane.setLayout(null);

        snowpane = new JLabel(snow1Img);
        snowpane.setBounds(0, 0, 1000, 600);
        Menu_drawpane.add(snowpane);

        startpane = new JButton(startImg);
        startpane.setContentAreaFilled(false);
        startpane.setBorder(null);
        startpane.setBounds(70, 420, 210, 115);
        Menu_drawpane.add(startpane);

        howtoplaypane = new JButton(howtoplayImg);
        howtoplaypane.setContentAreaFilled(false);
        howtoplaypane.setBorder(null);
        howtoplaypane.setBounds(380, 410, 210, 130);
        Menu_drawpane.add(howtoplaypane);

        exitpane = new JButton(exitImg);
        exitpane.setContentAreaFilled(false);
        exitpane.setBorder(null);
        exitpane.setBounds(700, 420, 210, 115);
        Menu_drawpane.add(exitpane);

        settingpane = new JButton(settingImg);
        settingpane.setContentAreaFilled(false);
        settingpane.setBorder(null);
        settingpane.setBounds(880, 10, 80, 104);
        Menu_drawpane.add(settingpane);

        contentpane.add(Menu_drawpane);

        validate();
    }

    //addlistener 1st frame
    public void Menu_addListen() {

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                jinglebellSound.stop();
            }
        });

        startpane.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                startpane.setIcon(startfadeImg);
                startpane.setContentAreaFilled(false);
                startpane.setBorder(null);
            }

            public void mouseClicked(MouseEvent e) {
                //start game
                contentpane.removeAll();
                repaint();
                Dialog_character();
                Dialog_listener();

            }

            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                startpane.setIcon(startImg);
                startpane.setContentAreaFilled(false);
                startpane.setBorder(null);
            }
        });

        howtoplaypane.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                howtoplaypane.setIcon(howtoplayfadeImg);
                howtoplaypane.setContentAreaFilled(false);
                howtoplaypane.setBorder(null);
            }

            public void mouseClicked(MouseEvent e) {
                /////how to play game
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                contentpane.removeAll();
                repaint();
                How_To_Play_1();
            }

            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                howtoplaypane.setIcon(howtoplayImg);
                howtoplaypane.setContentAreaFilled(false);
                howtoplaypane.setBorder(null);
            }
        });

        exitpane.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                exitpane.setIcon(exitfadeImg);
                exitpane.setContentAreaFilled(false);
                exitpane.setBorder(null);
            }

            public void mouseClicked(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                int ex = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (ex == 0) {
                    System.exit(0);
                }
            }

            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                exitpane.setIcon(exitImg);
                exitpane.setContentAreaFilled(false);
                exitpane.setBorder(null);
            }
        });

        settingpane.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                settingpane.setIcon(settingfadeImg);
                settingpane.setContentAreaFilled(false);
                settingpane.setBorder(null);
            }

            public void mouseClicked(MouseEvent e) {
                Dialog_setting();
                repaint();

            }

            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                settingpane.setIcon(settingImg);
                settingpane.setContentAreaFilled(false);
                settingpane.setBorder(null);
            }
        });

    }

    public void Dialog_setting() {
        headfont = new Font("Monospaced", Font.BOLD, 14);
        bodyfont = new Font("Monospaced", Font.PLAIN, 14);
        setting = new JDialog();
        setting.setLayout(new GridLayout(3, 4));
        setting.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                e.getComponent().setSize(250, 350);
            }

            public void componentMoved(ComponentEvent e) {
                e.getComponent().setLocation(1000, 150);
            }
        });
        firstPanel = new JPanel();
        firstPanel.setLayout(new GridLayout(3, 2));
        soundoption = new JLabel("  SOUND OPTION  ");
        soundoption.setFont(headfont);
        themesong = new JCheckBox("Theme song", true); 
        themesong.setFont(bodyfont);
        soundeffect = new JCheckBox("Sound effects", true);
        soundeffect.setFont(bodyfont);
        firstPanel.add(soundoption);
        firstPanel.add(themesong);
        firstPanel.add(soundeffect);
        themesong.addItemListener(this);
        soundeffect.addItemListener(this);
        
        secondPanel = new JPanel();
        secondPanel.setLayout(new GridLayout(4, 2));
        bgcolour = new JLabel("  BACKGROUND OF GAME");
        bgcolour.setFont(headfont);
        blueradio = new JRadioButton("BLUE                 ",true);
        purpleradio = new JRadioButton("PURPLE             ");
        yellowradio = new JRadioButton("YELLOW             ");
        radioGroup = new ButtonGroup();
        radioGroup.add(blueradio);
        radioGroup.add(purpleradio);
        radioGroup.add(yellowradio);
        secondPanel.add(bgcolour);
        secondPanel.add(blueradio);
        secondPanel.add(purpleradio);
        secondPanel.add(yellowradio);
        blueradio.addItemListener(this);
        purpleradio.addItemListener(this);
        yellowradio.addItemListener(this);
        
        thirdPanel = new JPanel();
        thirdPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        speedofchar = new JLabel("  SPEED OF CHARACTER ");
        speedofchar.setFont(headfont);
        thirdPanel.add(speedofchar);
        JSlider speedSlider = new JSlider(100, 500);
        speedSlider.setMajorTickSpacing(100);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
        thirdPane = new JLabel("    ");
        position.put(100, new JLabel("100"));
        position.put(200, new JLabel("200"));
        position.put(300, new JLabel("300"));
        position.put(400, new JLabel("400"));
        position.put(500, new JLabel("500"));
        speedSlider.setLabelTable(position);
        speedSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                thirdPane.setText("Speed of the slider is: " + ((JSlider) e.getSource()).getValue() + " ms");
                speed = ((JSlider) e.getSource()).getValue();
            }
        });
        thirdPanel.add(speedSlider);
        thirdPanel.add(thirdPane);

        ///////////
        setting.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setting.setModal(true);
        setting.add(firstPanel);
        setting.add(secondPanel);
        setting.add(thirdPanel);
        setting.pack();
        setting.setBounds(950, 150, 300, 400);
        setting.setTitle("setting");
        setting.setVisible(true);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getItemSelectable()  == themesong){
            if(e.getStateChange() == ItemEvent.SELECTED) {
                jinglebellSound.playLoop();
                soundchoose =1 ;
            }
            else{
                jinglebellSound.stop();
                soundchoose = 0;
            }
        }
        if(e.getItemSelectable()  == soundeffect){
            if(e.getStateChange() == ItemEvent.SELECTED) {
                soundeffectchoose = 1;
            }
            else {
                ///////////// หยุดที่เป็นพวกเสียงลงไป
                soundeffectchoose = 0;
            }
        }
        if(e.getItemSelectable() == blueradio ){
                bg = new MyImageIcon("resource/bgblue.png");
                colorBackground="resource/bgblue.png";
                ladder = new MyImageIcon("resource/tableblue.png");
                colorladder = "resource/tableblue.png";
               
        }
        else if(e.getItemSelectable() == purpleradio){
            bg = new MyImageIcon("resource/bgpurple.png");
            colorBackground= "resource/bgpurple.png";
            ladder = new MyImageIcon("resource/tablepurple.png");
            colorladder = "resource/tablepurple.png";
            
        }
        else if(e.getItemSelectable() == yellowradio){
            bg = new MyImageIcon("resource/bgyellow.png");
            colorBackground= "resource/bgyellow.png";
            ladder = new MyImageIcon("resource/tableyellow.png");
            colorladder = "resource/tableyellow.png";
        }
        
    }
     public void How_To_Play_1(){
        nexthowtoplayImg = new MyImageIcon("resource/nexthowtoplay.png").resize(61, 52);
        backhowtoplayImg = new MyImageIcon("resource/backhowtoplay.png").resize(61, 52);
        gotomenuImg = new MyImageIcon("resource/gotomenu.png").resize(138, 61);
        
        htw_page_1_Img = new MyImageIcon("resource/htwpage1.png");
        htw_page_1 = new JLabel(htw_page_1_Img);
        
        speedgifImg = new MyImageIcon("resource/speedgif.GIF");
        speedgif = new JLabel(speedgifImg);
        speedgif.setBounds(500, 500, 420, 50);
        
        next_1 = new JButton(nexthowtoplayImg);
        next_1.setContentAreaFilled(false);
        next_1.setBorder(null);
        next_1.setBounds(940, 300, 61, 52);
        next_1.addActionListener(this);
        gotomenu= new JButton(gotomenuImg);
        gotomenu.setContentAreaFilled(false);
        gotomenu.setBorder(null);
        gotomenu.setBounds(820, 15, 138, 61);
        gotomenu.addActionListener(this);
        
        htw_page_1.add(speedgif);
        htw_page_1.add(gotomenu);
        htw_page_1.add(next_1);
        contentpane.add(htw_page_1);
        validate();
        
         
    }
    
    public void How_To_Play_2(){
        htw_page_2_Img = new MyImageIcon("resource/htwpage2.png");
        htw_page_2 = new JLabel(htw_page_2_Img);
        
        next_2 = new JButton(nexthowtoplayImg);
        next_2.setContentAreaFilled(false);
        next_2.setBorder(null);
        next_2.setBounds(940, 300, 61, 52);
        next_2.addActionListener(this);
        back_1 = new JButton(backhowtoplayImg);
        back_1.setContentAreaFilled(false);
        back_1.setBorder(null);
        back_1.setBounds(10, 300, 61, 52);
        back_1.addActionListener(this);
        gotomenu= new JButton(gotomenuImg);
        gotomenu.setContentAreaFilled(false);
        gotomenu.setBorder(null);
        gotomenu.setBounds(820, 15, 138, 61);
        gotomenu.addActionListener(this);
        
        htw_page_2.add(gotomenu);
        htw_page_2.add(next_2);
        htw_page_2.add(back_1);
        contentpane.add(htw_page_2);
        validate();
    }
    public void How_To_Play_3(){
        htw_page_3_Img = new MyImageIcon("resource/htwpage3.png");
        htw_page_3 = new JLabel(htw_page_3_Img);
        
        next_3 = new JButton(nexthowtoplayImg);
        next_3.setContentAreaFilled(false);
        next_3.setBorder(null);
        next_3.setBounds(940, 300, 61, 52);
        next_3.addActionListener(this);
        back_2 = new JButton(backhowtoplayImg);
        back_2.setContentAreaFilled(false);
        back_2.setBorder(null);
        back_2.setBounds(10, 300, 61, 52);
        back_2.addActionListener(this);
        gotomenu= new JButton(gotomenuImg);
        gotomenu.setContentAreaFilled(false);
        gotomenu.setBorder(null);
        gotomenu.setBounds(820, 15, 138, 61);
        gotomenu.addActionListener(this);
        
        htw_page_3.add(gotomenu);
        htw_page_3.add(next_3);
        htw_page_3.add(back_2);
        contentpane.add(htw_page_3);
        validate();
    }
    public void How_To_Play_4(){
        htw_page_4_Img = new MyImageIcon("resource/htwpage4.png");
        htw_page_4 = new JLabel(htw_page_4_Img);
        
        next_4 = new JButton(nexthowtoplayImg);
        next_4.setContentAreaFilled(false);
        next_4.setBorder(null);
        next_4.setBounds(940, 300, 61, 52);
        next_4.addActionListener(this);
        back_3 = new JButton(backhowtoplayImg);
        back_3.setContentAreaFilled(false);
        back_3.setBorder(null);
        back_3.setBounds(10, 300, 61, 52);
        back_3.addActionListener(this);
        gotomenu= new JButton(gotomenuImg);
        gotomenu.setContentAreaFilled(false);
        gotomenu.setBorder(null);
        gotomenu.setBounds(820, 15,138, 61);
        gotomenu.addActionListener(this);
        
        htw_page_4.add(gotomenu);
        htw_page_4.add(next_4);
        htw_page_4.add(back_3);
        contentpane.add(htw_page_4);
        validate();
    }
    public void How_To_Play_5(){
        htw_page_5_Img = new MyImageIcon("resource/htwpage5.png");
        htw_page_5 = new JLabel(htw_page_5_Img);
        
        next_5 = new JButton(nexthowtoplayImg);
        next_5.setContentAreaFilled(false);
        next_5.setBorder(null);
        next_5.setBounds(940, 300, 61, 52);
        next_5.addActionListener(this);
        back_4 = new JButton(backhowtoplayImg);
        back_4.setContentAreaFilled(false);
        back_4.setBorder(null);
        back_4.setBounds(10, 300, 61, 52);
        back_4.addActionListener(this);
        gotomenu= new JButton(gotomenuImg);
        gotomenu.setContentAreaFilled(false);
        gotomenu.setBorder(null);
        gotomenu.setBounds(820, 15, 138, 61);
        gotomenu.addActionListener(this);
        
        htw_page_5.add(gotomenu);
        htw_page_5.add(next_5);
        htw_page_5.add(back_4);
        contentpane.add(htw_page_5);
        validate();
    }
    public void How_To_Play_6(){
        htw_page_6_Img = new MyImageIcon("resource/htwpage6.png");
        htw_page_6 = new JLabel(htw_page_6_Img);
        
        back_5 = new JButton(backhowtoplayImg);
        back_5.setContentAreaFilled(false);
        back_5.setBorder(null);
        back_5.setBounds(10, 300,61, 52);
        back_5.addActionListener(this);
        gotomenu= new JButton(gotomenuImg);
        gotomenu.setContentAreaFilled(false);
        gotomenu.setBorder(null);
        gotomenu.setBounds(820, 15, 138, 61);
        gotomenu.addActionListener(this);
        
        htw_page_6.add(gotomenu);
        htw_page_6.add(back_5);
        contentpane.add(htw_page_6);
        validate();
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gotomenu) {
            contentpane.removeAll();
            repaint();
            Menu_AddComponents();
            Menu_addListen();
            setSnowThread();
        }
        else if (e.getSource() == next_1) {
            contentpane.removeAll();
            repaint();
            How_To_Play_2();
            
        }
        else if (e.getSource() == next_2) {
            contentpane.removeAll();
            repaint();
            How_To_Play_3();
            
        }
        else if (e.getSource() == next_3) {
            contentpane.removeAll();
            repaint();
            How_To_Play_4();
            
           
        }
        else if (e.getSource() == next_4) {
            contentpane.removeAll();
            repaint();
            How_To_Play_5();
            
        }
        else if (e.getSource() == next_5) {
            contentpane.removeAll();
            repaint();
            How_To_Play_6();
        }
        else if (e.getSource() == back_1) {
            contentpane.removeAll();
            repaint();
            How_To_Play_1();
        }
        else if (e.getSource() == back_2) {
            contentpane.removeAll();
            repaint();
            How_To_Play_2();
        }
        else if (e.getSource() == back_3) {
            contentpane.removeAll();
            repaint();
            How_To_Play_3();
        }
        else if (e.getSource() == back_4) {
            contentpane.removeAll();
            repaint();
            How_To_Play_4();
        }
        else if (e.getSource() == back_5) {
            contentpane.removeAll();
            repaint();
            How_To_Play_5();
        }
    }
    
    
    public void Dialog_character() {
        comboFont = new Font("Monospaced", Font.BOLD, 14);
        comboFontmain = new Font("Monospaced", Font.BOLD + Font.ITALIC, 17);
        introducebg = new MyImageIcon("resource/introbg.jpg").resize(1000, 600);
        bigsantaImg = new MyImageIcon("resource/bigsanta.png").resize(200, 200);
        biggrinchImg = new MyImageIcon("resource/biggrinch.png").resize(200, 200);
        whiteblockgrinchImg = new MyImageIcon("resource/grinchblock.png").resize(530, 100);
        whiteblocksantaImg = new MyImageIcon("resource/santablock.png").resize(530, 100);
        whitenarrateImg = new MyImageIcon("resource/narrateblock.png").resize(900, 200);

        //set level_drawnpane
        introducepane = new JLabel();
        introducepane.setIcon(introducebg);
        introducepane.setLayout(null);

        snowpane = new JLabel(snow1Img);
        snowpane.setBounds(0, 0, 1000, 600);
        introducepane.add(snowpane);
        setSnowThread();

        contentpane.add(introducepane);
        validate();

    }
    int countclick = 0;

    public void Dialog_listener() {
        introducepane.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseClicked(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                if (countclick == 0) {
                    Dialog_grinch();
                    countclick++;
                } else if (countclick == 1) {
                    Dialog_santa();
                    countclick++;
                } else if (countclick == 2) {
                    Dialog_narrate();
                    countclick++;
                } else if (countclick == 3) {
                    choosenumberPlayer c = new choosenumberPlayer(speed,colorBackground,colorladder,soundchoose,soundeffectchoose);
                    setVisible(false);
                    dispose(); 
                    jinglebellSound.stop();
                                  
                }

            }

            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

    }

    public void Dialog_grinch() {

        biggrinchpane = new JLabel(biggrinchImg);
        biggrinchpane.setBounds(10, 30, 200, 200);
        introducepane.add(biggrinchpane);

        whiteblockpane1 = new JLabel(whiteblockgrinchImg);
        whiteblockpane1.setBounds(150, 50, 530, 130);

        textSound1 = new MySoundEffect("resource/keyboard.wav");
        textSound1.playLoop();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JLabel msg1 = new JLabel();
                    JLabel msg2 = new JLabel();
                    String text1 = "My name is Grinch. I hate the noise of Christmas.";
                    String text2 = "So, I will do every way to steal Christmas.";
                    msg1.setText(text1);
                    msg1.setFont(comboFont);
                    msg2.setText(text2);
                    msg2.setFont(comboFont);
                    msg1.setBounds(230, 10, 600, 180);
                    msg2.setBounds(230, 35, 600, 180);
                    introducepane.add(msg1);
                    introducepane.add(msg2);
                    introducepane.add(whiteblockpane1);
                    TextLength1 = text1.length();
                    TextLength2 = text2.length();
                    tm1 = new Timer(50, new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {

                            counter1++;

                            if (counter1 > TextLength1) {
                                msg1.setText("");
                                counter1 = 0;
                            } else {
                                msg1.setText(text1.substring(0, counter1));
                            }
                            if (counter1 == TextLength1) {
                                tm1.stop();
                                textSound1.stop();
                            }
                        }
                    });

                    tm2 = new Timer(50, new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            counter2++;
                            if (counter2 > TextLength2) {
                                msg2.setText("");
                                counter2 = 0;
                            } else {
                                msg2.setText(text2.substring(0, counter2));
                                if (counter2 == TextLength2) {
                                    tm2.stop();
                                }
                            }

                        }
                    });
                    tm1.start();
                    tm2.start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void Dialog_santa() {
        bigsantapane = new JLabel(bigsantaImg);
        bigsantapane.setBounds(780, 160, 200, 200);
        introducepane.add(bigsantapane);

        whiteblockpane2 = new JLabel(whiteblocksantaImg);
        whiteblockpane2.setBounds(300, 220, 530, 130);

        textSound2 = new MySoundEffect("resource/keyboard.wav");
        textSound2.playLoop();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JLabel msg3 = new JLabel();
                    JLabel msg4 = new JLabel();
                    String text3 = "My name is Santa Claus. I have to give presents  ";
                    String text4 = "to children on the night of Christmas Eve.";
                    msg3.setText(text3);
                    msg3.setFont(comboFont);
                    msg4.setText(text4);
                    msg4.setFont(comboFont);
                    msg3.setBounds(370, 180, 500, 180);
                    msg4.setBounds(370, 205, 500, 180);
                    introducepane.add(msg3);
                    introducepane.add(msg4);
                    introducepane.add(whiteblockpane2);
                    TextLength3 = text3.length();
                    TextLength4 = text4.length();
                    tm3 = new Timer(50, new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {

                            counter3++;

                            if (counter3 > TextLength3) {
                                msg3.setText("");
                                counter3 = 0;
                            } else {
                                msg3.setText(text3.substring(0, counter3));
                            }
                            if (counter3 == TextLength3) {
                                tm3.stop();
                            }
                        }
                    });
                    tm4 = new Timer(50, new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            counter4++;
                            if (counter4 > TextLength4) {
                                msg4.setText("");
                                counter4 = 0;
                            } else {
                                msg4.setText(text4.substring(0, counter4));
                                if (counter4 == TextLength4) {
                                    tm4.stop();
                                    textSound2.stop();
                                }
                            }

                        }
                    });
                    tm3.start();
                    tm4.start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void Dialog_narrate() {
        whitenarratepane = new JLabel(whitenarrateImg);
        whitenarratepane.setBounds(0, 340, 950, 250);

        textSound3 = new MySoundEffect("resource/keyboard.wav");
        textSound3.playLoop();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JLabel msg5 = new JLabel();
                    JLabel msg6 = new JLabel();
                    String text5 = "Before the early morning hours of 25th December,";
                    String text6 = "Santa must arrive at the town before Grinch so that Christmas will happen.";
                    msg5.setText(text5);
                    msg5.setForeground(Color.WHITE);
                    msg5.setFont(comboFontmain);
                    msg6.setText(text6);
                    msg6.setForeground(Color.WHITE);
                    msg6.setFont(comboFontmain);
                    msg5.setBounds(165, 375, 600, 180);
                    msg6.setBounds(165, 415, 800, 180);
                    introducepane.add(msg5);
                    introducepane.add(msg6);
                    introducepane.add(whitenarratepane);
                    TextLength5 = text5.length();
                    TextLength6 = text6.length();
                    tm5 = new Timer(40, new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {

                            counter5++;

                            if (counter5 > TextLength5) {
                                msg5.setText("");
                                counter5 = 0;
                            } else {
                                msg5.setText(text5.substring(0, counter5));
                            }
                            if (counter5 == TextLength5) {
                                tm5.stop();
                                textSound3.stop();
                            }
                        }
                    });
                    tm6 = new Timer(30, new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            counter6++;
                            if (counter6 > TextLength6) {
                                msg6.setText("");
                                counter6 = 0;
                            } else {
                                msg6.setText(text6.substring(0, counter6));
                                if (counter6 == TextLength6) {
                                    tm6.stop();
                                }
                            }

                        }
                    });

                    tm5.start();
                    tm6.start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void setSnowThread() {
        snowthread = new Thread() {
            public void run() {
                while (true) {
                    if (snowpane.getIcon() == snow1Img) {
                        snowpane.setIcon(snow2Img);

                    } else {
                        snowpane.setIcon(snow1Img);
                    }
                    repaint();

                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } // end run
        }; // end thread creation
        snowthread.start();
    }



    public static void main(String[] args) {
        new firstpage();
    }

}
