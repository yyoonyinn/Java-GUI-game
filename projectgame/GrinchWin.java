/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgame;

/**
 *
 * @author user
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

class GrinchWin extends JFrame implements MouseListener{
    private JPanel contentpane;
    private MyImageIcon background;
    private Icon gif;
    private JLabel drawpane;
    private Thread grinchThread;
    private MyImageIcon grinchWheel;
    private JLabel grinch;
    private int grinchCurx = 1000,grinchCury = 50; 
    private MySoundEffect themeSound;
    private JLabel memberpane,gifpane;
    private int soundchoose;
    private int soundeffectchoose;
        Thread memberThread;
    int memCurX = 0 ,memCurY=0;
    
    public GrinchWin(int sound, int soundeffect) {
        this.soundchoose = sound;
        this.soundeffectchoose = soundeffect;
        setTitle("Is chirstmas coming to town ?? ");
        setSize(1000, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentpane = (JPanel) getContentPane();
        grinchWinEnd();
        setGrinchThread();
        this.addMouseListener(this);
    }
    public void grinchWinEnd(){
        themeSound =  new MySoundEffect("resource/grinch.wav");
        if(soundchoose == 1 ){
        themeSound.playLoop();
        }
        background = new MyImageIcon("resource/background .PNG").resize(this.getWidth(), this.getHeight());
        drawpane = new JLabel(background);
        grinchWheel = new MyImageIcon("resource/Wheel.PNG");
        gif = new ImageIcon("resource/grinchstolechristmas.GIF");
        gifpane = new JLabel(gif);
        gifpane.setBounds(0, 0, 1000, 600);
        grinch = new JLabel(grinchWheel);
        grinch.setBounds(grinchCurx, grinchCury,grinchWheel.getIconWidth(),grinchWheel.getIconHeight());
        drawpane.add(grinch);
        contentpane.add(gifpane);
        contentpane.add(drawpane);
        validate();
    } 

    public void setGrinchThread(){
        grinchThread = new Thread(){
            public void run(){
                while(true){
                    grinch.setLocation(grinchCurx, grinchCury);
                    grinchCurx = grinchCurx-20;
                    if(grinchCurx<-grinchWheel.getIconWidth()) grinchCurx=1000;
                    else if(grinchCurx> 1000+grinchWheel.getIconHeight()) grinchCurx=0;
                    repaint();
                    try { Thread.sleep(150);} catch (InterruptedException e) { e.printStackTrace(); }
                }
            }
        };
        grinchThread.start();
    }
    
public void endcredit(){
       drawpane = new JLabel(new MyImageIcon("resource/creditbg.png").resize(this.getWidth(), this.getHeight()));
       memberpane = new JLabel(new MyImageIcon("resource/endcredits.PNG").resize(1000, 600));
       memberpane.setBounds(memCurX,memCurY,this.getWidth() ,this.getHeight());
       contentpane.add(memberpane);
       contentpane.add(drawpane);
       validate();
   }
 public void setThread(){

        memberThread = new Thread(){
            public void run(){
                while(true){
                    memberpane.setLocation(memCurX, memCurY);
                    memCurX += 50;
                    if(memCurX > 1000) memCurX = -1000;
                    repaint(); 
                    validate();
                    try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
                }
            }
        };
        memberThread.start();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        contentpane.removeAll();
        contentpane.removeAll();
        endcredit();
        setThread();
        
        if(e.getClickCount() == 2)
        {
            firstpage k=  new firstpage();
            setVisible(false);
            dispose();
            if(soundchoose == 1)
            {
                themeSound.stop();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

