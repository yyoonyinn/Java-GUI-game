package projectgame;

import projectgame.GrinchWin;
import projectgame.MyImageIcon;
import projectgame.MySoundEffect;
import projectgame.SantaWin;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Naisu
 */
public class oneplayer extends JFrame implements KeyListener, MouseListener {

    private JPanel contentpane;
    private int numbericonsanta, speed;
    private Point position[] = new Point[100];
    private Random random = new Random();
    private int numSelect = 0, numrandom = 0, playercount1, playercount2;
    private MyImageIcon bg, ladder;
    private JLabel dp, tp;
    private MyImageIcon DiceGrinchImg, DiceSantaImg, GrinchTagImg, GrinchTagDarkImg, SantaTagImg, SantaTagDarkImg, RedlampImg, RedlampDarkImg, GreenlampImg, GreenlampDarkImg, YTredImg, YTgreenImg, YTredDarkImg, YTgreenDarkImg, RedGiveupImg, GreenGiveupImg;
    private JLabel DiceGrinch, DiceSanta, GrinchTag, GrinchTagDark, SantaTag, SantaTagDark, Redlamp, RedlampDark, Greenlamp, GreenlampDark, YTred, YTgreen, YTredDark, YTgreenDark, RedGiveup, GreenGiveup;
    private MyImageIcon santapicgameMode, grinchpicgameMode;
    //private JLabel santachess, grinchchess;
    private JLabel[] p = new JLabel[2];
    private Thread player1, player2;
    private MySoundEffect santasound, grinchsound, themesound, up, down;
    private int num[] = {1, 1};
    private String namePlayer1, namePlayer2;
    private JLabel namePlayerlb1, namePlayerlb2;
    private String colorbackground, colorladder;

    private JLabel numlocation1, numlocation2;
    private JLabel locationPlayer1, locationPlayer2;
    private int soundchoose;
    private int soundeffectchoose;

    public oneplayer(int numbericonsanta, int speed, String namePlayer1, String colorbackground, String colorladder, int sound, int soundeffect) {
        this.colorbackground = colorbackground;
        this.colorladder = colorladder;
        this.namePlayer1 = namePlayer1;
        this.numbericonsanta = numbericonsanta;
        this.speed = speed;
        this.soundchoose = sound;
        this.soundeffectchoose = soundeffect;

        setTitle("Is chirstmas coming to town ?? ");
        setSize(1000, 600);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentpane = (JPanel) getContentPane();
        //System.out.println(numbericonsanta + "  " + numbericongrunch + "  " + speed);
        setLocation();
        add_component();
        selectPlayerToStart();
        this.addKeyListener(this);
        if (soundchoose == 0) {
            themesound.stop();
        }

        if (playercount2 == 1) {
            grinchturn();
        }
    }

    public void setLocation() {
        int x = 255;
        int y = 495;
        int d = 0;

        for (int i = 1; i <= 10; i++) {
            if (x == 755) {
                x -= 50;
            } else if (x == 205) {
                x += 50;
            }
            for (int j = 1; j <= 10; j++) {
                position[d] = new Point(x, y);
                if (i % 2 == 1) {
                    x += 50;
                } else {
                    x -= 50;
                }
                d++;
            }
            y -= 50;
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(position[i].getLocation());
        }
    }

    public void selectPlayerToStart() {
        numSelect = random.nextInt(3);
        if (numSelect == 0) {
            selectPlayerToStart();
        } else if (numSelect == 1) {
            playercount1 = 1;
            playercount2 = 0;
            GrinchTag.setIcon(GrinchTagDarkImg);
            Greenlamp.setIcon(GreenlampDarkImg);
            YTgreen.setIcon(YTgreenDarkImg);

            namePlayerlb1.setForeground(Color.WHITE);
            //namePlayerlb2.setForeground(Color.DARK_GRAY);
            SantaTag.setIcon(SantaTagImg);
            Redlamp.setIcon(RedlampImg);
            YTred.setIcon(YTredImg);

        } else if (numSelect == 2) {
            playercount1 = 0;
            playercount2 = 1;
            GrinchTag.setIcon(GrinchTagImg);
            Greenlamp.setIcon(GreenlampImg);
            YTgreen.setIcon(YTgreenImg);

            namePlayerlb1.setForeground(Color.DARK_GRAY);
            //namePlayerlb2.setForeground(Color.WHITE);
            SantaTag.setIcon(SantaTagDarkImg);
            Redlamp.setIcon(RedlampDarkImg);
            YTred.setIcon(YTredDarkImg);
        }
        System.out.println("choose plyer to start " + numSelect);
    }

    public void add_component() {
        santapicgameMode = new MyImageIcon("resource/santa" + (numbericonsanta + 1) + ".png").resize(35, 35);
        p[0] = new JLabel(santapicgameMode);
        p[0].setBounds(255, 495, 35, 35);

        grinchpicgameMode = new MyImageIcon("resource/grinch1.png").resize(35, 35);
        p[1] = new JLabel(grinchpicgameMode);
        p[1].setBounds(255, 495, 35, 35);

        bg = new MyImageIcon(colorbackground);
        ladder = new MyImageIcon(colorladder);
        dp = new JLabel(bg);
        dp.setLayout(null);
        tp = new JLabel(ladder);
        tp.setBounds(230, 20, 540, 540);
        dp.add(tp);

        locationPlayer1 = new JLabel(Integer.toString(num[0]));
        locationPlayer1.setFont(new Font("TimesRoman", Font.BOLD, 20));
        locationPlayer1.setBounds(175, 70, 190, 210);
        locationPlayer1.setForeground(Color.WHITE);

        locationPlayer2 = new JLabel(Integer.toString(num[1]));
        locationPlayer2.setFont(new Font("TimesRoman", Font.BOLD, 20));
        locationPlayer2.setBounds(810, 70, 190, 210);
        locationPlayer2.setForeground(Color.WHITE);

        namePlayerlb1 = new JLabel(namePlayer1);
        namePlayerlb1.setBounds(87, 230, 190, 210);
        namePlayerlb1.setFont(new Font("TimesRoman", Font.BOLD, 20));
        namePlayerlb1.setForeground(Color.WHITE);

        ///// เตรียมไปadd ในของไนซ์////////////////////
        GrinchTagImg = new MyImageIcon("resource/grinchtag.png").resize(190, 210);
        GrinchTagDarkImg = new MyImageIcon("resource/grinchtag-dark.png").resize(190, 210);
        SantaTagImg = new MyImageIcon("resource/santatag.png").resize(190, 210);
        SantaTagDarkImg = new MyImageIcon("resource/santatag-dark.png").resize(190, 210);

        RedlampImg = new MyImageIcon("resource/light-red.png").resize(70, 160);
        RedlampDarkImg = new MyImageIcon("resource/light-red-dark.png").resize(70, 160);
        GreenlampImg = new MyImageIcon("resource/light-green.png").resize(70, 160);
        GreenlampDarkImg = new MyImageIcon("resource/light-green-dark.png").resize(70, 160);

        YTredImg = new MyImageIcon("resource/yt-red.png").resize(170, 70);
        YTredDarkImg = new MyImageIcon("resource/yt-red-dark.png").resize(170, 70);
        YTgreenImg = new MyImageIcon("resource/yt-green.png").resize(165, 90);
        YTgreenDarkImg = new MyImageIcon("resource/yt-green-dark.png").resize(165, 90);

        RedGiveupImg = new MyImageIcon("resource/redGiveup.png").resize(80, 80);
        GreenGiveupImg = new MyImageIcon("resource/greenGiveup.png").resize(80, 80);
        DiceSantaImg = new MyImageIcon("resource/roll1.png").resize(90, 90);
        DiceGrinchImg = new MyImageIcon("resource/roll1.png").resize(90, 90);

        santasound = new MySoundEffect("resource/santasound.wav");
        grinchsound = new MySoundEffect("resource/grinchsound.wav");
        themesound = new MySoundEffect("resource/theme.wav");
        up = new MySoundEffect("resource/drawnwheel.wav");
        down = new MySoundEffect("resource/falldowntube.wav");
        if (soundchoose == 1) {
            themesound.playLoop();
        }
        RedGiveup = new JLabel(RedGiveupImg);
        RedGiveup.setBounds(10, 490, 80, 80);
        RedGiveup.addMouseListener(this);

        DiceSanta = new JLabel(DiceSantaImg);
        DiceSanta.setBounds(110, 420, 90, 90);
        DiceGrinch = new JLabel(DiceGrinchImg);
        DiceGrinch.setBounds(800, 420, 90, 90);

        GrinchTag = new JLabel(GrinchTagImg);
        GrinchTag.setBounds(790, 170, 190, 210);
        GrinchTagDark = new JLabel(GrinchTagDarkImg);
        GrinchTagDark.setBounds(790, 170, 190, 210);
        SantaTag = new JLabel(SantaTagImg);
        SantaTag.setBounds(25, 170, 190, 210);
        SantaTagDark = new JLabel(SantaTagDarkImg);
        SantaTagDark.setBounds(25, 170, 190, 210);

        Redlamp = new JLabel(RedlampImg);
        Redlamp.setBounds(150, 80, 70, 160);
        RedlampDark = new JLabel(RedlampDarkImg);
        RedlampDark.setBounds(150, 80, 70, 160);
        Greenlamp = new JLabel(GreenlampImg);
        Greenlamp.setBounds(785, 80, 70, 160);
        GreenlampDark = new JLabel(GreenlampDarkImg);
        GreenlampDark.setBounds(785, 80, 70, 160);

        YTred = new JLabel(YTredImg);
        YTred.setBounds(35, 30, 170, 70);
        YTredDark = new JLabel(YTredDarkImg);
        YTredDark.setBounds(35, 30, 170, 70);
        YTgreen = new JLabel(YTgreenImg);
        YTgreen.setBounds(800, 5, 165, 90);
        YTgreenDark = new JLabel(YTgreenDarkImg);
        YTgreenDark.setBounds(800, 5, 165, 90);

        contentpane.add(locationPlayer1);
        contentpane.add(locationPlayer2);
        contentpane.add(namePlayerlb1);
        contentpane.add(p[0]);
        contentpane.add(p[1]);
        contentpane.add(YTred);
        contentpane.add(YTgreen);
        contentpane.add(SantaTag);
        contentpane.add(GrinchTag);
        contentpane.add(Redlamp);
        contentpane.add(Greenlamp);
        contentpane.add(RedGiveup);
        contentpane.add(DiceSanta);
        contentpane.add(DiceGrinch);
        contentpane.add(dp);
        validate();

    }

    public void keyTyped(KeyEvent e) {
        if (playercount1 == 1 && e.getKeyChar() == KeyEvent.VK_SPACE) {
            santaturn();
        }

    }

    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public void santaturn() {
        numrandom = random.nextInt(6) + 1;
        DiceSantaImg = new MyImageIcon("resource/roll" + Integer.toString(numrandom) + ".png").resize(80, 80);
        DiceSanta.setIcon(DiceSantaImg);
        System.out.println(numrandom);

        System.out.println("santa dice : " + numrandom);
        setPlayer1();

    }

    public void grinchturn() {

        numrandom = random.nextInt(6) + 1;
        DiceGrinchImg = new MyImageIcon("resource/roll" + Integer.toString(numrandom) + ".png").resize(80, 80);
        DiceGrinch.setIcon(DiceGrinchImg);

        System.out.println("grinch dice : " + numrandom);
        setPlayer2();

    }

    public void setPlayer1() {
        player1 = new Thread() {
            public void run() {
                for (int k = 0; k < numrandom; k++) {
                    //System.out.println("sdasdsdasd");
                    if (num[0] == 100) {
                        break;
                    }
                    p[0].setLocation(position[num[0]]);
                    if (p[0].getBounds().intersects(p[1].getBounds())) {
                        if (soundeffectchoose == 1) {
                            santasound.playOnce();
                        }

                    }
                    num[0]++;
                    locationPlayer1.setText(Integer.toString(num[0]));
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
                System.out.println("santa channel: " + num[0]);

                if (num[0] == 100) {
                    JOptionPane.showMessageDialog(null, "Christmas is coming to this town :) ", "Congratulation!", JOptionPane.OK_OPTION);
                    setVisible(false);
                    dispose();
                    themesound.stop();
                    SantaWin s = new SantaWin(soundchoose, soundeffectchoose);

                }
                changeLocationPlayer(0);

                namePlayerlb1.setForeground(Color.DARK_GRAY);

                GrinchTag.setIcon(GrinchTagImg);
                Greenlamp.setIcon(GreenlampImg);
                YTgreen.setIcon(YTgreenImg);

                SantaTag.setIcon(SantaTagDarkImg);
                Redlamp.setIcon(RedlampDarkImg);
                YTred.setIcon(YTredDarkImg);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                numrandom = random.nextInt(6) + 1;
                DiceGrinchImg = new MyImageIcon("resource/roll" + Integer.toString(numrandom) + ".png").resize(80, 80);
                DiceGrinch.setIcon(DiceGrinchImg);
                for (int k = 0; k < numrandom; k++) {
                    //System.out.println("sdasdsdasd");
                    if (num[1] == 100) {
                        break;
                    }
                    p[1].setLocation(position[num[1]]);
                    if (p[1].getBounds().intersects(p[0].getBounds())) {
                        if (soundeffectchoose == 1) {
                            grinchsound.playOnce();
                        }
                    }
                    num[1]++;
                    locationPlayer2.setText(Integer.toString(num[1]));
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }

                if (num[1] == 100) {
                    JOptionPane.showMessageDialog(null, "OMG!!! Grinch can steal Christmas from this town", "Christmas disappears:( ", JOptionPane.OK_OPTION);
                    setVisible(false);
                    dispose();
                    themesound.stop();
                    GrinchWin g = new GrinchWin(soundchoose, soundeffectchoose);

                }
                changeLocationPlayer(1);
                namePlayerlb1.setForeground(Color.WHITE);

                GrinchTag.setIcon(GrinchTagDarkImg);
                Greenlamp.setIcon(GreenlampDarkImg);
                YTgreen.setIcon(YTgreenDarkImg);

                SantaTag.setIcon(SantaTagImg);
                Redlamp.setIcon(RedlampImg);
                YTred.setIcon(YTredImg);

            }

        };
        player1.start();

    }

    public void setPlayer2() {

        player2 = new Thread() {
            public void run() {
                for (int k = 0; k < numrandom; k++) {
                    //System.out.println("sdasdsdasd");
                    if (num[1] == 100) {
                        break;
                    }
                    p[1].setLocation(position[num[1]]);
                    if (p[1].getBounds().intersects(p[0].getBounds())) {
                        if (soundeffectchoose == 1) {
                            grinchsound.playOnce();
                        }
                    }
                    num[1]++;
                    locationPlayer2.setText(Integer.toString(num[1]));
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("grinch channel: " + num[1]);
                if (num[1] == 100) {
                    JOptionPane.showMessageDialog(null, "OMG!!! Grinch can steal Christmas from this town", "Christmas disappears:( ", JOptionPane.OK_OPTION);
                    setVisible(false);
                    dispose();
                    themesound.stop();
                    GrinchWin g = new GrinchWin(soundchoose, soundeffectchoose);

                }
                changeLocationPlayer(1);

                namePlayerlb1.setForeground(Color.WHITE);
                //namePlayerlb2.setForeground(Color.DARK_GRAY);
                GrinchTag.setIcon(GrinchTagDarkImg);
                Greenlamp.setIcon(GreenlampDarkImg);
                YTgreen.setIcon(YTgreenDarkImg);

                SantaTag.setIcon(SantaTagImg);
                Redlamp.setIcon(RedlampImg);
                YTred.setIcon(YTredImg);
            }

        };
        player2.start();
        try {
            //player2.join();
        } catch (Exception k) {

        }
    }

    public void changeLocationPlayer(int n) {

        //เมื่อsantaเจอปล่องไฟ
        if (num[n] == 17) {
            if (soundeffectchoose == 1) {
                down.playOnce();
            }
            num[n] = 4;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        }
        if (num[n] == 27) {
            if (soundeffectchoose == 1) {
                down.playOnce();
            }

            num[n] = 7;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        } else if (num[n] == 39) {
            if (soundeffectchoose == 1) {
                down.playOnce();
            }
            num[n] = 2;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        } else if (num[n] == 49) {
            if (soundeffectchoose == 1) {
                down.playOnce();
            }
            num[n] = 32;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        } else if (num[n] == 63) {
            if (soundeffectchoose == 1) {
                down.playOnce();
            }
            num[n] = 43;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        } else if (num[n] == 75) {
            if (soundeffectchoose == 1) {
                down.playOnce();
            }
            num[n] = 46;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        } else if (num[n] == 93) {
            if (soundeffectchoose == 1) {
                down.playOnce();
            }
            num[n] = 53;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        } else if (num[n] == 98) {
            if (soundeffectchoose == 1) {
                down.playOnce();
            }
            num[n] = 83;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        } else if (num[n] == 99) {
            if (soundeffectchoose == 1) {
                down.playOnce();
            }
            num[n] = 79;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        } else if (num[n] == 89) {
            if (soundeffectchoose == 1) {
                down.playOnce();
            }
            num[n] = 72;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        } //เมื่อsantaเจอม้าเลื่อน
        else if (num[n] == 11) {
            if (soundeffectchoose == 1) {
                up.playOnce();
            }

            num[n] = 29;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        } else if (num[n] == 40) {
            if (soundeffectchoose == 1) {
                up.playOnce();
            }
            num[n] = 42;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        } else if (num[n] == 35) {
            if (soundeffectchoose == 1) {
                up.playOnce();
            }
            num[n] = 45;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        } else if (num[n] == 52) {
            if (soundeffectchoose == 1) {
                up.playOnce();
            }
            num[n] = 68;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        } else if (num[n] == 76) {
            if (soundeffectchoose == 1) {
                up.playOnce();
            }
            num[n] = 86;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p[n].setLocation(position[num[n] - 1]);

        }

        if (n == 0) {
            playercount1 = 0;
            playercount2 = 1;

            GrinchTag.setIcon(GrinchTagImg);
            Greenlamp.setIcon(GreenlampImg);
            YTgreen.setIcon(YTgreenImg);
            locationPlayer1.setText(Integer.toString(num[0]));
            repaint();
            SantaTag.setIcon(SantaTagDarkImg);
            Redlamp.setIcon(RedlampDarkImg);
            YTred.setIcon(YTredDarkImg);

            // turn[1].setVisible(true);
        } else if (n == 1) {

            playercount1 = 1;
            playercount2 = 0;

            locationPlayer2.setText(Integer.toString(num[1]));
            repaint();

            GrinchTag.setIcon(GrinchTagDarkImg);
            Greenlamp.setIcon(GreenlampDarkImg);
            YTgreen.setIcon(YTgreenDarkImg);

            SantaTag.setIcon(SantaTagImg);
            Redlamp.setIcon(RedlampImg);
            YTred.setIcon(YTredImg);

            //turn[0].setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        /*if (e.getSource() == GreenGiveup) {
            //redwin
            int warn = JOptionPane.showConfirmDialog(null, "Are you sure to let Christmas happen?", "SERIOUSLY, GRINCH ?!!!!! ", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (warn == JOptionPane.YES_OPTION) {
                System.out.println("santa");
                setVisible(false);
                dispose();
                SantaWin s = new SantaWin();
            }

        } */
        if (e.getSource() == RedGiveup) {
            //greenwin
            int warn = JOptionPane.showConfirmDialog(null, "Are you sure to let Grinch steal Christmas? ", "SERIOUSLY,  SANTA ?!!!!!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (warn == JOptionPane.YES_OPTION) {
                GrinchWin g = new GrinchWin(soundchoose, soundeffectchoose);
                setVisible(false);
                dispose();
                themesound.stop();
                System.out.println("grinch");
            }
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
        if (e.getSource() == RedGiveup) {
            RedGiveup.setIcon(new MyImageIcon("resource/redGiveupBrightpng.png").resize(80, 80));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == RedGiveup) {
            RedGiveup.setIcon(RedGiveupImg);
        }
    }

}
