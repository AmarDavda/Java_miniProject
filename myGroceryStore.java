// Code Developed by AMAR DAVDA(M.no.8200585066) MU-Student(R.no.92200104020/GR.no.116208) 4th semester,B.Tech(Information & Technology)
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.sql.*;
class groc implements ActionListener{
    JFrame f,f2,f3,f4,f5,f6,bil,adm,adm2;
    PrinterJob pj;
    JRadioButton r1,r2,r3,r4,r5;
    JButton b1,b2,pay,ok1,ok2,ok3,bac,bac2,bac3,bac4,entr,entr2;
    JTextField tf1,tf2,tf3,tf4;
    JTextField ta0,ta1,ta2,ta3,ta4,tb1,at,at2,pt,pt2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,c33,c34,c35,c36,c37,c38,c39,c40;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39,t40;
    DateTimeFormatter dt;
    LocalDateTime now;
    int count;
    float bill=0;
    String str1="",str2="",str3="",str4="",str5="",str6="",str7="",str8="",str9="",str10="",str11="",str12="",str13="",str14="",str15="",str16="",str17="",str18="",str19="",str20="",str21="",str22="",str23="",str24="",str25="",str26="",str27="",str28="",str29="",str30="",str31="",str32="",str33="",str34="",str35="",str36="",str37="",str38="",str39="",str40="";
    String nm,mo,dob,city,dat1,dat2,rdat,billList,data="";
// Code Developed by AMAR DAVDA(M.no.8200585066) MU-Student(R.no.92200104020/GR.no.116208) 4th semester,B.Tech(Information & Technology)
    groc(){
        f = new JFrame();
        f.getRootPane().setBorder(BorderFactory.createMatteBorder(9, 9, 9, 9, new Color(0xfcbc49)));
        f.setTitle("MY COZY GROCERY STORE!!");

        JLabel l = new JLabel("What's your Choice???");
        //l.setBounds(50,50,80,80);
        l.setHorizontalAlignment(JLabel.CENTER);l.setVerticalAlignment(JLabel.TOP);l.setForeground(new Color(0xfba01d));l.setFont(new Font("MV boli",Font.BOLD,40));
        f.add(l);

        ButtonGroup bg=new ButtonGroup();
        r1=new JRadioButton("SHOPPING");
        r2=new JRadioButton("RETURN");
        r3=new JRadioButton("READ DATABASE FOR SURVEY!! (Authorized)");
        r4=new JRadioButton("DELETE ANY ENTRY!! (Authorized)");
        r5=new JRadioButton("Exit");

        r1.setBounds(200,90,90,20);r2.setBounds(200,190,80,20);r3.setBounds(200,290,300,20);r4.setBounds(200,390,230,20);r5.setBounds(200,490,70,20);

        r1.setBackground(new Color(0xfcbc49));r2.setBackground(new Color(0xfcbc49));r3.setBackground(new Color(0xfcbc49));r4.setBackground(new Color(0xfcbc49));r5.setBackground(new Color(0xfcbc49));

        r1.addActionListener(this);r2.addActionListener(this);r3.addActionListener(this);r4.addActionListener(this);r5.addActionListener(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900,680);
        f.setVisible(true);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon img = new ImageIcon("Amo.png");
        f.setIconImage(img.getImage());
        f.getContentPane().setBackground(new Color(0xa3de83));
        f.setLayout(null);
        bg.add(r1);bg.add(r2);bg.add(r3);bg.add(r4);bg.add(r5);
        f.add(r1);f.add(r2);f.add(r3);f.add(r4);f.add(r5);
    }
// Code Developed by AMAR DAVDA(M.no.8200585066) MU-Student(R.no.92200104020/GR.no.116208) 4th semester,B.Tech(Information & Technology)
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==r1){
            try{
                Class.forName("com.mysql.jdbc.Driver");
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery","root","");
		        System.out.println("\nConnected Successfully!!\n");
		        Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM cust ORDER BY bill_no DESC limit 1");
                while(rs.next()){
                    count=rs.getInt("bill_no");
                }
                con.close();
            }
            catch(Exception ex){System.out.println(ex);}
            count++;
            f.dispose();
            JLabel l1,l2,l3,l4;
            JTextField t1;
            f2 = new JFrame();
            f2.getRootPane().setBorder(BorderFactory.createMatteBorder(9, 9, 9, 9, new Color(0xac3b61)));
            f2.setTitle("MY COZY GROCERY STORE!!");
            ImageIcon img = new ImageIcon("Amo.png");
            f2.setIconImage(img.getImage());
            f2.getContentPane().setBackground(new Color(0xedc7b7));
            f2.setSize(900,680);
            f2.setExtendedState(JFrame.MAXIMIZED_BOTH);
            
            dt=DateTimeFormatter.ofPattern("  dd/MM/yyyy   HH:mm:ss ");
            now=LocalDateTime.now();
            dat1 = dt.format(now);

            JLabel lab1=new JLabel("< REGISTRATION PAGE >");
            lab1.setBounds(400,20,500,40);
            lab1.setForeground(new Color(0xdc747d));
            lab1.setFont(new Font("Calibri",Font.BOLD,40));f2.add(lab1);
            
            t1=new JTextField();t1.setBounds(1120,10,130,20);t1.setEditable(false);t1.setBackground(new Color(0xdc747d));t1.setText(dat1);

            l1=new JLabel("Enter your Name:");l1.setBounds(475,70,150,30);
            tf1=new JTextField();tf1.setBounds(475,95,250,25);tf1.setBackground(new Color(0xdc747d));
            JLabel mc=new JLabel("(* Maximum 12 characters)");mc.setBounds(570,110,250,30);mc.setForeground(Color.red);f2.add(mc);
            bac2=new JButton("BACK");bac2.setBounds(490,490,100,30);bac2.setBackground(new Color(0xdc747d));bac2.addActionListener(this);f2.add(bac2);
            
            l2=new JLabel("Enter your Mobile-Number:");l2.setBounds(475,170,180,30);
            tf2=new JTextField();tf2.setBounds(475,195,250,25);tf2.setBackground(new Color(0xdc747d));

            l3=new JLabel("Enter your BirthDate:");l3.setBounds(475,270,150,30);
            tf3=new JTextField();tf3.setBounds(475,295,250,25);tf3.setBackground(new Color(0xdc747d));

            l4=new JLabel("Enter your City:");l4.setBounds(475,370,150,30);
            tf4=new JTextField();tf4.setBounds(475,395,250,25);tf4.setBackground(new Color(0xdc747d));

            b1 = new JButton("SUBMIT");b1.setBounds(610,490,100,30);b1.setBackground(new Color(0xdc747d));
            b1.addActionListener(this);

            f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f2.setLayout(null);
            f2.setVisible(true);
            f2.add(l1);f2.add(l2);f2.add(l3);f2.add(l4);
            f2.add(t1);f2.add(tf1);f2.add(tf3);f2.add(tf4);f2.add(tf2);f2.add(b1);f2.add(lab1);f2.add(bac2);
        }
        else if(e.getSource()==bac2){
            f2.dispose();
            f.setVisible(true);
        }
// Code Developed by AMAR DAVDA(M.no.8200585066) MU-Student(R.no.92200104020/GR.no.116208) 4th semester,B.Tech(Information & Technology)
        else if(e.getSource()==b1){
            nm=tf1.getText();mo=tf2.getText();dob=tf3.getText();city=tf4.getText();
            f2.dispose();
            f3 = new JFrame();
            f3.getRootPane().setBorder(BorderFactory.createMatteBorder(9, 9, 9, 9, new Color(170,150,40)));
            f3.setTitle("MY COZY GROCERY STORE!!");
            f3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f3.setSize(1200,685);
            f3.setExtendedState(JFrame.MAXIMIZED_BOTH);
            ImageIcon img = new ImageIcon("Amo.png");
            f3.setIconImage(img.getImage());
           
            JLabel inst1 = new JLabel("Click");
            inst1.setBounds(1140,50,100,30);
            inst1.setForeground(Color.RED);
            inst1.setFont(new Font("Calibri",Font.BOLD,20));
            f3.add(inst1);
            JLabel inst2 = new JLabel("Checkbox");
            inst2.setBounds(1135,100,100,30);
            inst2.setForeground(Color.RED);
            inst2.setFont(new Font("Calibri",Font.BOLD,20));
            f3.add(inst2);
            JLabel inst3 = new JLabel("As many");
            inst3.setBounds(1137,150,100,30);
            inst3.setForeground(Color.RED);
            inst3.setFont(new Font("Calibri",Font.BOLD,20));
            f3.add(inst3);
            JLabel inst4 = new JLabel("Time");
            inst4.setBounds(1141,200,80,30);
            inst4.setForeground(Color.RED);
            inst4.setFont(new Font("Calibri",Font.BOLD,20));
            f3.add(inst4);
            JLabel inst5 = new JLabel("As you");
            inst5.setBounds(1140,250,100,30);
            inst5.setForeground(Color.RED);
            inst5.setFont(new Font("Calibri",Font.BOLD,20));
            f3.add(inst5);
            JLabel inst6 = new JLabel("Want");
            inst6.setBounds(1141,300,100,30);
            inst6.setForeground(Color.RED);
            inst6.setFont(new Font("Calibri",Font.BOLD,20));
            f3.add(inst6);
            JLabel inst7 = new JLabel("That");
            inst7.setBounds(1141,350,100,30);
            inst7.setForeground(Color.RED);
            inst7.setFont(new Font("Calibri",Font.BOLD,20));
            f3.add(inst7);
            JLabel inst8 = new JLabel("Particular");
            inst8.setBounds(1135,400,120,30);
            inst8.setForeground(Color.RED);
            inst8.setFont(new Font("Calibri",Font.BOLD,20));
            f3.add(inst8);
            JLabel inst9 = new JLabel("Item!");
            inst9.setBounds(1141,450,120,30);
            inst9.setForeground(Color.RED);
            inst9.setFont(new Font("Calibri",Font.BOLD,20));
            f3.add(inst9);

            JLabel l = new JLabel("<  Here is your MENU  >");
            l.setHorizontalAlignment(JLabel.CENTER);
            l.setVerticalAlignment(JLabel.TOP);
            l.setForeground(new Color(0xffa334));
            l.setFont(new Font("Calibri",Font.BOLD,30));
            f3.add(l);
            b2 = new JButton("BILL");b2.setBounds(1150,580,65,30);b2.setBackground(new Color(0xffa334));b2.addActionListener(this);
            
            JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
            l1=new JLabel("FLOUR");
            l1.setBounds(20,30,100,30);
            c1=new JCheckBox("WHEAT FLOUR [₹140/3kg]");c1.setBounds(10,60,190,25);
            c2=new JCheckBox("RICE FLOUR [₹100/1kg]");c2.setBounds(10,130,190,25);
            c3=new JCheckBox("CORN FLOUR [₹20/500g]");c3.setBounds(10,200,190,25);
            c4=new JCheckBox("MAIDA [₹30/500g]");c4.setBounds(10,270,190,25);

            t1=new JTextField("0");t1.setBounds(20,90,40,25);t1.setEditable(false);
            t2=new JTextField("0");t2.setBounds(20,160,40,25);t2.setEditable(false);
            t3=new JTextField("0");t3.setBounds(20,230,40,25);t3.setEditable(false);
            t4=new JTextField("0");t4.setBounds(20,300,40,25);t4.setEditable(false);

            l2=new JLabel("DRYFRUITS");
            l2.setBounds(230,30,100,30);
            c5=new JCheckBox("ALMOND [₹100/100g]");c5.setBounds(215,60,180,25);
            c6=new JCheckBox("CASHEW [₹80/100g]");c6.setBounds(215,130,180,25);
            c7=new JCheckBox("PISTA [₹280/250g]");c7.setBounds(215,200,180,25);
            c8=new JCheckBox("DATE [₹150/500g]");c8.setBounds(215,270,180,25);

            t5=new JTextField("0");t5.setBounds(225,90,40,25);t5.setEditable(false);
            t6=new JTextField("0");t6.setBounds(225,160,40,25);t6.setEditable(false);
            t7=new JTextField("0");t7.setBounds(225,230,40,25);t7.setEditable(false);
            t8=new JTextField("0");t8.setBounds(225,300,40,25);t8.setEditable(false);

            l3=new JLabel("PULSES");
            l3.setBounds(430,30,100,30);
            c9=new JCheckBox("GREEN PEAS [₹100/1kg]");c9.setBounds(420,60,190,25);
            c10=new JCheckBox("GREEN GRAMS [₹120/1kg]");c10.setBounds(420,130,190,25);
            c11=new JCheckBox("CHICKPEAS [₹120/1kg]");c11.setBounds(420,200,190,25);
            c12=new JCheckBox("DRY BEANS [₹100/1kg]");c12.setBounds(420,270,190,25);

            t9=new JTextField("0");t9.setBounds(430,90,40,25);t9.setEditable(false);
            t10=new JTextField("0");t10.setBounds(430,160,40,25);t10.setEditable(false);
            t11=new JTextField("0");t11.setBounds(430,230,40,25);t11.setEditable(false);
            t12=new JTextField("0");t12.setBounds(430,300,40,25);t12.setEditable(false);

            l4=new JLabel("CEREALS");
            l4.setBounds(630,30,100,30);
            c13=new JCheckBox("WHEAT [₹700/20kg]");c13.setBounds(620,60,190,25);
            c14=new JCheckBox("RICE [₹120/1kg]");c14.setBounds(620,130,190,25);
            c15=new JCheckBox("OATS [₹180/1kg]");c15.setBounds(620,200,190,25);
            c16=new JCheckBox("CORN [₹40/1kg]");c16.setBounds(620,270,190,25);

            t13=new JTextField("0");t13.setBounds(630,90,40,25);t13.setEditable(false);
            t14=new JTextField("0");t14.setBounds(630,160,40,25);t14.setEditable(false);
            t15=new JTextField("0");t15.setBounds(630,230,40,25);t15.setEditable(false);
            t16=new JTextField("0");t16.setBounds(630,300,40,25);t16.setEditable(false);

            l5=new JLabel("MILLET");
            l5.setBounds(830,30,100,30);
            c17=new JCheckBox("PEARL(BAJRA) [₹30/1kg]");c17.setBounds(830,60,200,25);
            c18=new JCheckBox("SORGHUM(JOWAR) [₹35/1kg]");c18.setBounds(830,130,200,25);
            c19=new JCheckBox("FINGE1R(RAGI) [₹100/1kg]");c19.setBounds(830,200,200,25);
            c20=new JCheckBox("LITTLE(MORAIYA) [₹80/500g]");c20.setBounds(830,270,200,25);

            t17=new JTextField("0");t17.setBounds(840,90,40,25);t17.setEditable(false);
            t18=new JTextField("0");t18.setBounds(840,160,40,25);t18.setEditable(false);
            t19=new JTextField("0");t19.setBounds(840,230,40,25);t19.setEditable(false);
            t20=new JTextField("0");t20.setBounds(840,300,40,25);t20.setEditable(false);
            
            l6=new JLabel("FRYUMS");
            l6.setBounds(20,330,100,30);
            c21=new JCheckBox("PAPAD [₹90/250g]");c21.setBounds(10,360,190,25);
            c22=new JCheckBox("RING [₹100/1kg]");c22.setBounds(10,430,190,25);
            c23=new JCheckBox("PIPES [₹100/1kg]");c23.setBounds(10,500,190,25);
            c24=new JCheckBox("STAR [₹100/1kg]");c24.setBounds(10,570,190,25);

            t21=new JTextField("0");t21.setBounds(20,390,40,25);t21.setEditable(false);
            t22=new JTextField("0");t22.setBounds(20,460,40,25);t22.setEditable(false);
            t23=new JTextField("0");t23.setBounds(20,530,40,25);t23.setEditable(false);
            t24=new JTextField("0");t24.setBounds(20,600,40,25);t24.setEditable(false);

            l7=new JLabel("SPICES");
            l7.setBounds(230,330,100,30);
            c25=new JCheckBox("CHILLI POWDER [₹600/1kg]");c25.setBounds(215,360,190,25);
            c26=new JCheckBox("BLACK PEPPER[₹170/100g]");c26.setBounds(215,430,190,25);
            c27=new JCheckBox("CUMIN POWDER [₹459/1kg]");c27.setBounds(215,500,190,25);
            c28=new JCheckBox("BLACK SALT [₹60/1kg]");c28.setBounds(215,570,190,25);

            t25=new JTextField("0");t25.setBounds(225,390,40,25);t25.setEditable(false);
            t26=new JTextField("0");t26.setBounds(225,460,40,25);t26.setEditable(false);
            t27=new JTextField("0");t27.setBounds(225,530,40,25);t27.setEditable(false);
            t28=new JTextField("0");t28.setBounds(225,600,40,25);t28.setEditable(false);

            l8=new JLabel("SWEETNERS");
            l8.setBounds(428,330,100,30);
            c29=new JCheckBox("DICED SUGAR [₹300/5kg]");c29.setBounds(420,360,190,25);
            c30=new JCheckBox("POWDER SUGAR [₹65/1kg]");c30.setBounds(420,430,190,25);
            c31=new JCheckBox("HONEY [₹80/200g]");c31.setBounds(420,500,190,25);
            c32=new JCheckBox("JAGGERY [₹50/500g]");c32.setBounds(420,570,190,25);

            t29=new JTextField("0");t29.setBounds(430,390,40,25);t29.setEditable(false);
            t30=new JTextField("0");t30.setBounds(430,460,40,25);t30.setEditable(false);
            t31=new JTextField("0");t31.setBounds(430,530,40,25);t31.setEditable(false);
            t32=new JTextField("0");t32.setBounds(430,600,40,25);t32.setEditable(false);

            l9=new JLabel("OIL");
            l9.setBounds(635,330,100,30);
            c33=new JCheckBox("SUNFLOWER OIL[₹1700/15litre]");c33.setBounds(620,360,215,25);
            c34=new JCheckBox("GROUNDNUT OIL[₹2500/15litre]");c34.setBounds(620,430,215,25);
            c35=new JCheckBox("OLIVE OIL [₹2000/15litre]");c35.setBounds(620,500,215,25);
            c36=new JCheckBox("SESAME OIL [₹3000/15litre]");c36.setBounds(620,570,215,25);

            t33=new JTextField("0");t33.setBounds(630,390,40,25);t33.setEditable(false);
            t34=new JTextField("0");t34.setBounds(630,460,40,25);t34.setEditable(false);
            t35=new JTextField("0");t35.setBounds(630,530,40,25);t35.setEditable(false);
            t36=new JTextField("0");t36.setBounds(630,600,40,25);t36.setEditable(false);

            l10=new JLabel("PASTAS");
            l10.setBounds(840,330,100,30);
            c37=new JCheckBox("NOODLES [₹180/1kg]");c37.setBounds(850,360,175,25);
            c38=new JCheckBox("SPIRAL [₹170/1kg]");c38.setBounds(850,430,175,25);
            c39=new JCheckBox("MACARONI [₹180/1kg]");c39.setBounds(850,500,175,25);
            c40=new JCheckBox("SPAGHETTI [₹120/500g]");c40.setBounds(850,570,175,25);

            t37=new JTextField("0");t37.setBounds(860,390,40,25);t37.setEditable(false);
            t38=new JTextField("0");t38.setBounds(860,460,40,25);t38.setEditable(false);
            t39=new JTextField("0");t39.setBounds(860,530,40,25);t39.setEditable(false);
            t40=new JTextField("0");t40.setBounds(860,600,40,25);t40.setEditable(false);

            c1.setBackground(new Color(0xec4176));c2.setBackground(new Color(0xec4176));c3.setBackground(new Color(0xec4176));c4.setBackground(new Color(0xec4176));

            c5.setBackground(new Color(0xe8ba40));c6.setBackground(new Color(0xe8ba40));c7.setBackground(new Color(0xe8ba40));c8.setBackground(new Color(0xe8ba40));

            c9.setBackground(new Color(0xec4176));c10.setBackground(new Color(0xec4176));c11.setBackground(new Color(0xec4176));c12.setBackground(new Color(0xec4176));

            c13.setBackground(new Color(0xe8ba40));c14.setBackground(new Color(0xe8ba40));c15.setBackground(new Color(0xe8ba40));c16.setBackground(new Color(0xe8ba40));

            c17.setBackground(new Color(0xec4176));c18.setBackground(new Color(0xec4176));c19.setBackground(new Color(0xec4176));c20.setBackground(new Color(0xec4176));
            c21.setBackground(new Color(0xe8ba40));c22.setBackground(new Color(0xe8ba40));c23.setBackground(new Color(0xe8ba40));c24.setBackground(new Color(0xe8ba40));

            c25.setBackground(new Color(0xec4176));c26.setBackground(new Color(0xec4176));c27.setBackground(new Color(0xec4176));c28.setBackground(new Color(0xec4176));

            c29.setBackground(new Color(0xe8ba40));c30.setBackground(new Color(0xe8ba40));c31.setBackground(new Color(0xe8ba40));c32.setBackground(new Color(0xe8ba40));

            c33.setBackground(new Color(0xec4176));c34.setBackground(new Color(0xec4176));c35.setBackground(new Color(0xec4176));c36.setBackground(new Color(0xec4176));

            c37.setBackground(new Color(0xe8ba40));c38.setBackground(new Color(0xe8ba40));c39.setBackground(new Color(0xe8ba40));c40.setBackground(new Color(0xe8ba40));

            t1.setBackground(new Color(0xfefae0));t2.setBackground(new Color(0xfefae0));t3.setBackground(new Color(0xfefae0));t4.setBackground(new Color(0xfefae0));t5.setBackground(new Color(0xfefae0));t6.setBackground(new Color(0xfefae0));t7.setBackground(new Color(0xfefae0));t8.setBackground(new Color(0xfefae0));t9.setBackground(new Color(0xfefae0));t10.setBackground(new Color(0xfefae0));t11.setBackground(new Color(0xfefae0));t12.setBackground(new Color(0xfefae0));t13.setBackground(new Color(0xfefae0));t14.setBackground(new Color(0xfefae0));t15.setBackground(new Color(0xfefae0));t16.setBackground(new Color(0xfefae0));t17.setBackground(new Color(0xfefae0));t18.setBackground(new Color(0xfefae0));t19.setBackground(new Color(0xfefae0));t20.setBackground(new Color(0xfefae0));t21.setBackground(new Color(0xfefae0));t22.setBackground(new Color(0xfefae0));t23.setBackground(new Color(0xfefae0));t24.setBackground(new Color(0xfefae0));t25.setBackground(new Color(0xfefae0));t26.setBackground(new Color(0xfefae0));t27.setBackground(new Color(0xfefae0));t28.setBackground(new Color(0xfefae0));t29.setBackground(new Color(0xfefae0));t30.setBackground(new Color(0xfefae0));t31.setBackground(new Color(0xfefae0));t32.setBackground(new Color(0xfefae0));t33.setBackground(new Color(0xfefae0));t34.setBackground(new Color(0xfefae0));t35.setBackground(new Color(0xfefae0));t36.setBackground(new Color(0xfefae0));t37.setBackground(new Color(0xfefae0));t38.setBackground(new Color(0xfefae0));t39.setBackground(new Color(0xfefae0));t40.setBackground(new Color(0xfefae0));
// Code Developed by AMAR DAVDA(M.no.8200585066) MU-Student(R.no.92200104020/GR.no.116208) 4th semester,B.Tech(Information & Technology)
            c1.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c1.isSelected()==true){
                        t1.setEditable(true);
                        String n=t1.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t1.setText(qu);
                        String num1=t1.getText();
                        float num=Float.parseFloat(num1);
                        float price=140*num;
                        bill+=140;
                        str1="";
                        str1=str1+"WHEAT FLOUR [₹140/3kg]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c2.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c2.isSelected()==true){
                        t2.setEditable(true);
                        String n=t2.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t2.setText(qu);
                        String num1=t2.getText();
                        float num=Float.parseFloat(num1);
                        float price=100*num;
                        bill+=100;
                        str2="";
                        str2=str2+"RICE FLOUR [₹100/1kg]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c3.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c3.isSelected()==true){
                        t3.setEditable(true);
                        String n=t3.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t3.setText(qu);
                        String num1=t3.getText();
                        float num=Float.parseFloat(num1);
                        float price=20*num;
                        bill+=20;
                        str3="";
                        str3=str3+"CORN FLOUR [₹20/500g]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c4.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c4.isSelected()==true){
                        t4.setEditable(true);
                        String n=t4.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t4.setText(qu);
                        String num1=t4.getText();
                        float num=Float.parseFloat(num1);
                        float price=30*num;
                        bill+=30;
                        str4="";
                        str4=str4+"MAIDA [₹30/500g]          x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c5.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c5.isSelected()==true){
                        t5.setEditable(true);
                        String n=t5.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t5.setText(qu);
                        String num1=t5.getText();
                        float num=Float.parseFloat(num1);
                        float price=100*num;
                        bill+=100;
                        str5="";
                        str5=str5+"ALMOND [₹100/100g]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c6.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c6.isSelected()==true){
                        t6.setEditable(true);
                        String n=t6.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t6.setText(qu);
                        String num1=t6.getText();
                        float num=Float.parseFloat(num1);
                        float price=80*num;
                        bill+=80;
                        str6="";
                        str6=str6+"CASHEW [₹80/100g]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c7.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c7.isSelected()==true){
                        t7.setEditable(true);
                        String n=t7.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t7.setText(qu);
                        String num1=t7.getText();
                        float num=Float.parseFloat(num1);
                        float price=280*num;
                        bill+=280;
                        str7="";
                        str7=str7+"PISTA [₹280/250g]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c8.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c8.isSelected()==true){
                        t8.setEditable(true);
                        String n=t8.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t8.setText(qu);
                        String num1=t8.getText();
                        float num=Float.parseFloat(num1);
                        float price=150*num;
                        bill+=150;
                        str8="";
                        str8=str8+"DATE [₹150/500g]          x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c9.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c9.isSelected()==true){
                        t9.setEditable(true);
                        String n=t9.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t9.setText(qu);
                        String num1=t9.getText();
                        float num=Float.parseFloat(num1);
                        float price=100*num;
                        bill+=100;
                        str9="";
                        str9=str9+"GREEN PEAS [₹100/1kg]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c10.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c10.isSelected()==true){
                        t10.setEditable(true);
                        String n=t10.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t10.setText(qu);
                        String num1=t10.getText();
                        float num=Float.parseFloat(num1);
                        float price=120*num;
                        bill+=120;
                        str10="";
                        str10=str10+"GREEN GRAMS [₹120/1kg]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c11.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c11.isSelected()==true){
                        t11.setEditable(true);
                        String n=t11.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t11.setText(qu);
                        String num1=t11.getText();
                        float num=Float.parseFloat(num1);
                        float price=120*num;
                        bill+=120;
                        str11="";
                        str11=str11+"CHICKPEAS [₹120/1kg]      x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c12.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c12.isSelected()==true){
                        t12.setEditable(true);
                        String n=t12.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t12.setText(qu);
                        String num1=t12.getText();
                        float num=Float.parseFloat(num1);
                        float price=100*num;
                        bill+=100;
                        str12="";
                        str12=str12+"DRY BEANS [₹100/1kg]       x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c13.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c13.isSelected()==true){
                        t13.setEditable(true);
                        String n=t13.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t13.setText(qu);
                        String num1=t13.getText();
                        float num=Float.parseFloat(num1);
                        float price=700*num;
                        bill+=700;
                        str13="";
                        str13=str13+"WHEAT [₹700/20kg]            x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c14.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c14.isSelected()==true){
                        t14.setEditable(true);
                        String n=t14.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t14.setText(qu);
                        String num1=t14.getText();
                        float num=Float.parseFloat(num1);
                        float price=120*num;
                        bill+=120;
                        str14="";
                        str14=str14+"RICE [₹120/1kg]             x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c15.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c15.isSelected()==true){
                        t15.setEditable(true);
                        String n=t15.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t15.setText(qu);
                        String num1=t15.getText();
                        float num=Float.parseFloat(num1);
                        float price=180*num;
                        bill+=180;
                        str15="";
                        str15=str15+"OATS [₹180/20kg]             x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c16.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c16.isSelected()==true){
                        t16.setEditable(true);
                        String n=t16.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t16.setText(qu);
                        String num1=t16.getText();
                        float num=Float.parseFloat(num1);
                        float price=40*num;
                        bill+=40;
                        str16="";
                        str16=str16+"CORN [₹40/1kg]             x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c17.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c17.isSelected()==true){
                        t17.setEditable(true);
                        String n=t17.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t17.setText(qu);
                        String num1=t17.getText();
                        float num=Float.parseFloat(num1);
                        float price=30*num;
                        bill+=30;
                        str17="";
                        str17=str17+"PEARL(BAJRA) [₹30/1kg]      x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });          
            c18.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c18.isSelected()==true){
                        t18.setEditable(true);
                        String n=t18.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t18.setText(qu);
                        String num1=t18.getText();
                        float num=Float.parseFloat(num1);
                        float price=35*num;
                        bill+=35;
                        str18="";
                        str18=str18+"SORGHUM(JOWAR) [₹35/1kg]      x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c19.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c19.isSelected()==true){
                        t19.setEditable(true);
                        String n=t19.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t19.setText(qu);
                        String num1=t19.getText();
                        float num=Float.parseFloat(num1);
                        float price=100*num;
                        bill+=100;
                        str19="";
                        str19=str19+"FINGE1R(RAGI) [₹100/1kg]      x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c20.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c20.isSelected()==true){
                        t20.setEditable(true);
                        String n=t20.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t20.setText(qu);
                        String num1=t20.getText();
                        float num=Float.parseFloat(num1);
                        float price=80*num;
                        bill+=80;
                        str20="";
                        str20=str20+"LITTLE(MORAIYA) [₹80/500g]      x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
// Code Developed by AMAR DAVDA(M.no.8200585066) MU-Student(R.no.92200104020/GR.no.116208) 4th semester,B.Tech(Information & Technology)
            c21.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c21.isSelected()==true){
                        t21.setEditable(true);
                        String n=t21.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t21.setText(qu);
                        String num1=t21.getText();
                        float num=Float.parseFloat(num1);
                        float price=90*num;
                        bill+=90;
                        str21="";
                        str21=str21+"PAPAD [₹90/250g]            x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c22.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c22.isSelected()==true){
                        t22.setEditable(true);
                        String n=t22.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t22.setText(qu);
                        String num1=t22.getText();
                        float num=Float.parseFloat(num1);
                        float price=100*num;
                        bill+=100;
                        str22="";
                        str22=str22+"RING [₹100/1kg]            x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c23.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c23.isSelected()==true){
                        t23.setEditable(true);
                        String n=t23.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t23.setText(qu);
                        String num1=t23.getText();
                        float num=Float.parseFloat(num1);
                        float price=100*num;
                        bill+=100;
                        str23="";
                        str23=str23+"PIPES [₹100/1kg]            x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c24.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c24.isSelected()==true){
                        t24.setEditable(true);
                        String n=t24.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t24.setText(qu);
                        String num1=t24.getText();
                        float num=Float.parseFloat(num1);
                        float price=100*num;
                        bill+=100;
                        str24="";
                        str24=str24+"STAR [₹100/1kg]             x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c25.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c25.isSelected()==true){
                        t25.setEditable(true);
                        String n=t25.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t25.setText(qu);
                        String num1=t25.getText();
                        float num=Float.parseFloat(num1);
                        float price=600*num;
                        bill+=600;
                        str25="";
                        str25=str25+"CHILLI POWDER [₹600/1kg]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c26.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c26.isSelected()==true){
                        t26.setEditable(true);
                        String n=t26.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t26.setText(qu);
                        String num1=t26.getText();
                        float num=Float.parseFloat(num1);
                        float price=170*num;
                        bill+=170;
                        str26="";
                        str26=str26+"BLACK PEPPER [₹170/100g]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c27.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c27.isSelected()==true){
                        t27.setEditable(true);
                        String n=t27.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t27.setText(qu);
                        String num1=t27.getText();
                        float num=Float.parseFloat(num1);
                        float price=459*num;
                        bill+=459;
                        str27="";
                        str27=str27+"CUMIN POWDER [₹459/1kg]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c28.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c28.isSelected()==true){
                        t28.setEditable(true);
                        String n=t28.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t28.setText(qu);
                        String num1=t28.getText();
                        float num=Float.parseFloat(num1);
                        float price=60*num;
                        bill+=60;
                        str28="";
                        str28=str28+"BLACK SALT [₹60/1kg]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c29.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c29.isSelected()==true){
                        t29.setEditable(true);
                        String n=t29.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t29.setText(qu);
                        String num1=t29.getText();
                        float num=Float.parseFloat(num1);
                        float price=300*num;
                        bill+=300;
                        str29="";
                        str29=str29+"DICED SUGAR [₹300/5kg]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c30.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c30.isSelected()==true){
                        t30.setEditable(true);
                        String n=t30.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t30.setText(qu);
                        String num1=t30.getText();
                        float num=Float.parseFloat(num1);
                        float price=65*num;
                        bill+=65;
                        str30="";
                        str30=str30+"POWDER SUGAR [₹65/1kg]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c31.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c31.isSelected()==true){
                        t31.setEditable(true);
                        String n=t31.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t31.setText(qu);
                        String num1=t31.getText();
                        float num=Float.parseFloat(num1);
                        float price=80*num;
                        bill+=80;
                        str31="";
                        str31=str31+"HONEY [₹80/200g]           x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c32.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c32.isSelected()==true){
                        t32.setEditable(true);
                        String n=t32.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t32.setText(qu);
                        String num1=t32.getText();
                        float num=Float.parseFloat(num1);
                        float price=50*num;
                        bill+=50;
                        str32="";
                        str32=str32+"JAGGERY [₹50/500g]          x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c33.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c33.isSelected()==true){
                        t33.setEditable(true);
                        String n=t33.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t33.setText(qu);
                        String num1=t33.getText();
                        float num=Float.parseFloat(num1);
                        float price=1700*num;
                        bill+=1700;
                        str33="";
                        str33=str33+"SUNFLOWER OIL[₹1700/15litre]  x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c34.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c34.isSelected()==true){
                        t34.setEditable(true);
                        String n=t34.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t34.setText(qu);
                        String num1=t34.getText();
                        float num=Float.parseFloat(num1);
                        float price=2500*num;
                        bill+=2500;
                        str34="";
                        str34=str34+"GROUNDNUT OIL[₹2500/15litre]  x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c35.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c35.isSelected()==true){
                        t35.setEditable(true);
                        String n=t35.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t35.setText(qu);
                        String num1=t35.getText();
                        float num=Float.parseFloat(num1);
                        float price=2000*num;
                        bill+=2000;
                        str35="";
                        str35=str35+"OLIVE OIL [₹2000/15litre]       x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c36.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c36.isSelected()==true){
                        t36.setEditable(true);
                        String n=t36.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t36.setText(qu);
                        String num1=t36.getText();
                        float num=Float.parseFloat(num1);
                        float price=3000*num;
                        bill+=3000;
                        str36="";
                        str36=str36+"SESAME OIL [₹3000/15litre]       x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c37.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c37.isSelected()==true){
                        t37.setEditable(true);
                        String n=t37.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t37.setText(qu);
                        String num1=t37.getText();
                        float num=Float.parseFloat(num1);
                        float price=180*num;
                        bill+=180;
                        str37="";
                        str37=str37+"NOODLES [₹180/1kg]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c38.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c38.isSelected()==true){
                        t38.setEditable(true);
                        String n=t38.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t38.setText(qu);
                        String num1=t38.getText();
                        float num=Float.parseFloat(num1);
                        float price=170*num;
                        bill+=170;
                        str38="";
                        str38=str38+"SPIRAL [₹170/1kg]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c39.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c39.isSelected()==true){
                        t39.setEditable(true);
                        String n=t39.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t39.setText(qu);
                        String num1=t39.getText();
                        float num=Float.parseFloat(num1);
                        float price=180*num;
                        bill+=180;
                        str39="";
                        str39=str39+"MACARONI [₹180/1kg]        x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });
            c40.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent i){
                    if(c40.isSelected()==true){
                        t40.setEditable(true);
                        String n=t40.getText();
                        float q=Float.parseFloat(n);
                        q+=1;
                        String qu = String.valueOf(q);
                        t40.setText(qu);
                        String num1=t40.getText();
                        float num=Float.parseFloat(num1);
                        float price=120*num;
                        bill+=120;
                        str40="";
                        str40=str40+"SPAGHETTI [₹120/500g]       x"+num+":"+"\t"+"₹ "+price+"\n";
                    }
                }
            });

            f3.getContentPane().setBackground(new Color(0xded4e8));
            f3.setVisible(true);
            f3.setLayout(null);
            f3.add(l);f3.add(inst1);f3.add(inst2);f3.add(inst3);f3.add(inst4);f3.add(inst5);f3.add(inst6);f3.add(inst7);f3.add(inst8);f3.add(inst9);f3.add(b2);
            f3.add(l1);f3.add(l2);f3.add(l3);f3.add(l4);f3.add(l5);f3.add(l6);f3.add(l7);f3.add(l8);f3.add(l9);f3.add(l10);
            f3.add(c1);f3.add(c2);f3.add(c3);f3.add(c4);f3.add(c5);f3.add(c6);f3.add(c7);f3.add(c8);f3.add(c9);f3.add(c10);f3.add(c11);f3.add(c12);f3.add(c13);f3.add(c14);f3.add(c15);f3.add(c16);f3.add(c17);f3.add(c18);f3.add(c19);f3.add(c20);f3.add(c21);f3.add(c22);f3.add(c23);f3.add(c24);f3.add(c25);f3.add(c26);f3.add(c27);f3.add(c28);f3.add(c29);f3.add(c30);f3.add(c31);f3.add(c32);f3.add(c33);f3.add(c34);f3.add(c35);f3.add(c36);f3.add(c37);f3.add(c38);f3.add(c39);f3.add(c40);
            f3.add(t1);f3.add(t2);f3.add(t3);f3.add(t4);f3.add(t5);f3.add(t6);f3.add(t7);f3.add(t8);f3.add(t9);f3.add(t10);f3.add(t11);f3.add(t12);f3.add(t13);f3.add(t14);f3.add(t15);f3.add(t16);f3.add(t17);f3.add(t18);f3.add(t19);f3.add(t20);f3.add(t21);f3.add(t22);f3.add(t23);f3.add(t24);f3.add(t25);f3.add(t26);f3.add(t27);f3.add(t28);f3.add(t29);f3.add(t30);f3.add(t31);f3.add(t32);f3.add(t33);f3.add(t34);f3.add(t35);f3.add(t36);f3.add(t37);f3.add(t38);f3.add(t39);f3.add(t40);
        }
// Code Developed by AMAR DAVDA(M.no.8200585066) MU-Student(R.no.92200104020/GR.no.116208) 4th semester,B.Tech(Information & Technology)
        else if(e.getSource()==b2){
            billList=str1+str2+str3+str4+str5+str6+str7+str8+str9+str10+str11+str12+str13+str14+str15+str16+str17+str18+str19+str20+str21+str22+str23+str24+str25+str26+str27+str28+str29+str30+str31+str32+str33+str34+str35+str36+str37+str38+str39+str40;
            dt=DateTimeFormatter.ofPattern(" dd/MM/yyyy (HH:mm:ss)");
            now=LocalDateTime.now();
            dat2 = dt.format(now);
            f3.dispose();
            String str="                                                                                  "+dat2+"\nName: "+nm+"\nMo.No.: "+mo+"\nB.Date: "+dob+"\nCity: "+city+"\n--------------------------------------------------------------------------------------------\n"+billList+"--------------------------------------------------------------------------------------------\n               TOTAL AMOUNT:"+"\t\t"+"₹ "+bill+" /-";
            bil = new JFrame("MY COZY GROCERY STORE!!");
            String cnt="( "+count+" )";
            JLabel c = new JLabel(cnt);
            c.setHorizontalAlignment(JLabel.LEFT);
            c.setVerticalAlignment(JLabel.TOP);
            c.setForeground(new Color(0xe97451));
            c.setFont(new Font("MV Boli",Font.BOLD,20));
            bil.add(c);
            JLabel l = new JLabel("₹ ₹ BILL ₹ ₹");
            l.setHorizontalAlignment(JLabel.CENTER);
            l.setVerticalAlignment(JLabel.TOP);
            l.setForeground(new Color(0xda9100));
            l.setFont(new Font("Calibri",Font.BOLD,30));
            bil.add(l);
            JTextArea ta = new JTextArea();
            ta.setBounds(40,30,400,480);ta.setBackground(new Color(0xfddc5c));
            ta.setEditable(false);
            ta.setText(str);
            bil.setSize(500,680);
            bil.setLocationRelativeTo(null);
            bil.setVisible(true);
            bil.getContentPane().setBackground(new Color(0xffbf00));
            ImageIcon img = new ImageIcon("Amo.png");
            bil.setIconImage(img.getImage());
            bil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            pay = new JButton("PAY");
            pay.setSize(new Dimension(100,30));pay.setLocation(200,550);pay.setBackground(Color.pink);
            pay.addActionListener(this);
            bil.add(pay);bil.add(ta);bil.add(l);bil.add(c);
        }
        else if(e.getSource()==pay){
            int yn=JOptionPane.showConfirmDialog(null,"Do you want to pay??","Confirmation",JOptionPane.YES_NO_OPTION);
            if(yn==JOptionPane.YES_OPTION){
                try{
                    pay.setText("PAID !!");
                    pay.setBackground(new Color(0xffbf00));
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery","root","");
                    System.out.println("\nConnected Successfully!!\n");
                    Statement stmt = con.createStatement();
                    String sql="INSERT INTO cust(cname,mobno,birthdate,city,bill_date,bill_amt) values('"+nm+"','"+mo+"','"+dob+"','"+city+"','"+dat2+"',"+bill+")";
                    int m = stmt.executeUpdate(sql);
                    if(m==1){System.out.println("Inserted successfully!!\n");}
                    con.close();
                }
                catch(Exception ex){System.out.println(ex);}
                printRecord(bil);
                bil.dispose();
                str1="";str2="";str3="";str4="";str5="";str6="";str7="";str8="";str9="";str10="";str11="";str12="";str13="";str14="";str15="";str16="";str17="";str18="";str19="";str20="";str21="";str22="";str23="";str24="";str25="";str26="";str27="";str28="";str29="";str30="";str31="";str32="";str33="";str34="";str35="";str36="";str37="";str38="";str39="";str40="";
                bill=0;
                f.setVisible(true);
            }
            else{
                bil.dispose();
                f.setVisible(true);
            }
        }
// Code Developed by AMAR DAVDA(M.no.8200585066) MU-Student(R.no.92200104020/GR.no.116208) 4th semester,B.Tech(Information & Technology)
        else if(e.getSource()==r2){
            //return..
            f.dispose();
            f4 = new JFrame();
            JLabel l1,l2,l3,l4;
            f4.getRootPane().setBorder(BorderFactory.createMatteBorder(9, 9, 9, 9, new Color(0x02605c)));
            f4.setTitle("MY COZY GROCERY STORE!!");
            f4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f4.setSize(650,680);
            ImageIcon img = new ImageIcon("Amo.png");
            f4.setIconImage(img.getImage());
            f4.getContentPane().setBackground(new Color(0xcbd5d8));
            f4.setLayout(null);
            f4.setExtendedState(JFrame.MAXIMIZED_BOTH);
            dt=DateTimeFormatter.ofPattern(" dd/MM/yyyy (HH:mm:ss) ");
            now=LocalDateTime.now();
            rdat = dt.format(now);
            JLabel lab=new JLabel("< RETURNING PAGE >");lab.setBounds(415,5,450,60);lab.setForeground(new Color(0x2a8a81));lab.setFont(new Font("Courier",Font.BOLD,35));f4.add(lab);
            ta0=new JTextField();ta0.setBounds(1120,10,120,20);ta0.setEditable(false);ta0.setBackground(new Color(0x9ac5c3));ta0.setText(rdat);
            l1=new JLabel("Enter your Bill_No.:");l1.setBounds(450,65,200,30);
            ta1=new JTextField();ta1.setBounds(450,95,300,25);ta1.setBackground(new Color(0x9ac5c3));
            JLabel l5=new JLabel("Enter your Name:");l5.setBounds(450,165,200,30);
            JTextField ta5=new JTextField();ta5.setBounds(450,195,300,25);ta5.setBackground(new Color(0x9ac5c3));
            l2=new JLabel("Enter your Mobile-Number:");l2.setBounds(450,265,200,30);
            ta2=new JTextField();ta2.setBounds(450,295,300,25);ta2.setBackground(new Color(0x9ac5c3));
            l3=new JLabel("What's your return item/s??");l3.setBounds(450,365,200,30);
            ta3=new JTextField();ta3.setBounds(450,395,300,25);ta3.setBackground(new Color(0x9ac5c3));
            l4=new JLabel("Total price of the returning item/s:");l4.setBounds(450,465,200,30);
            ta4=new JTextField();ta4.setBounds(450,495,300,25);ta4.setBackground(new Color(0x9ac5c3));
            ok1 = new JButton("RETURN");ok1.setBounds(630,580,100,30);ok1.setBackground(new Color(0x2a8a81));
            ok1.addActionListener(this);f4.add(ok1);
            bac=new JButton("BACK");bac.setBounds(470,580,100,30);bac.setBackground(new Color(0x2a8a81));bac.addActionListener(this);
            f4.add(bac);
            f4.setVisible(true);
            f4.add(ok1);f4.add(ta0);
            f4.add(l1);f4.add(l2);f4.add(l3);f4.add(l4);f4.add(l5);f4.add(ta1);f4.add(ta2);f4.add(ta3);f4.add(ta4);f4.add(ta5);f4.add(lab);f4.add(bac);
        }
        else if(e.getSource()==bac){
            f4.dispose();
            f.setVisible(true);
        }
        else if(e.getSource()==ok1){
            String bn,rItem,ramt,rdate;
            rdate=ta0.getText();bn=ta1.getText();rItem=ta3.getText();ramt=ta4.getText();
                int yn=JOptionPane.showConfirmDialog(null,"Are you Sure, you want to Return it??","Confirmation",JOptionPane.YES_NO_OPTION);
            if(yn==JOptionPane.YES_OPTION){
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery","root","");
                        System.out.println("\nConnected Successfully!!");
                        Statement stmt = con.createStatement();
                        float rAmt=Float.parseFloat(ramt);
                        String sql="UPDATE cust SET bill_amt = bill_amt-"+rAmt+", ret_date ='"+rdate+"', ret_list ='"+rItem+"', deducted_amt = "+rAmt+" WHERE bill_no="+bn;
                        int m = stmt.executeUpdate(sql);
                        if(m==1){System.out.println("Updated successfully!!\n");}
                        con.close();
                    }
                    catch(Exception ex){System.out.println(ex);}
                    f4.dispose();
                    f.setVisible(true);
            }
            else{
                f4.dispose();
                f.setVisible(true);
            }
            
        }
// Code Developed by AMAR DAVDA(M.no.8200585066) MU-Student(R.no.92200104020/GR.no.116208) 4th semester,B.Tech(Information & Technology)
        else if(e.getSource()==r3){
            //Database read...
            f.dispose();
            adm = new JFrame();
            adm.getRootPane().setBorder(BorderFactory.createMatteBorder(9, 9, 9, 9, new Color(0x38817a)));
            adm.setTitle("MY COZY GROCERY STORE!!");
            adm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            adm.setSize(800,690);
            ImageIcon img = new ImageIcon("Amo.png");
            adm.setIconImage(img.getImage());
            adm.getContentPane().setBackground(new Color(0xa3dd83));
            adm.setLayout(null);
            adm.setVisible(true);
            adm.setExtendedState(JFrame.MAXIMIZED_BOTH);
            JLabel l1=new JLabel("ADMIN:");l1.setBounds(450,80,200,30);
            at=new JTextField();at.setBounds(450,110,300,25);at.setBackground(new Color(0xf7f39a));
            JLabel l2=new JLabel("PASSWORD:");l2.setBounds(450,180,200,30);
            pt=new JTextField();pt.setBounds(450,210,300,25);pt.setBackground(new Color(0xf7f39a));
            entr = new JButton("LOGIN");entr.setBounds(630,300,90,30);entr.setBackground(new Color(0x49ae86));
            entr.addActionListener(this);adm.add(entr);
            bac3 = new JButton("BACK");bac3.setBounds(480,300,90,30);bac3.setBackground(new Color(0x49ae86));
            bac3.addActionListener(this);adm.add(bac3);
            JLabel lab=new JLabel(" AUTHORIZED PAGE");
            lab.setBounds(450,5,600,70);
            lab.setForeground(new Color(0x38817a));
            lab.setFont(new Font("Courier",Font.BOLD,30));adm.add(lab);
            adm.add(entr);adm.add(l1);adm.add(l2);adm.add(at);adm.add(pt);adm.add(bac3);
        }
            else if(e.getSource()==bac3){
                adm.dispose();
                f.setVisible(true);
            }
            else if(e.getSource()==entr){
                String ad=at.getText().trim();
                String pw=pt.getText().trim();
                if(ad.equals("amar") && pw.equals("1715")){
                    adm.dispose();
                    f5 = new JFrame();
                    f5.getRootPane().setBorder(BorderFactory.createMatteBorder(9, 9, 9, 9, new Color(0x797ef6)));
                    f5.setTitle("MY COZY GROCERY STORE!!");
                    f5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    f5.setSize(800,690);
                    ImageIcon img = new ImageIcon("Amo.png");
                    f5.setIconImage(img.getImage());
                    f5.getContentPane().setBackground(new Color(0x1aa7ec));
                    f5.setLayout(null);
                    f5.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery","root","");
                        System.out.println("\nConnected Successfully!!\n");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM cust");
                        while(rs.next()){
                            data =data+" "+rs.getString(1)+".\t"+rs.getString(2)+"\t"+"  "+rs.getString(3)+"\t"+"  "+rs.getString(4)+"\t"+"  "+rs.getString(5)+"\t"+"  "+rs.getString(6)+"\t"+"  "+rs.getString(7)+"\n";
                        }
                        con.close();
                    }
                    catch(Exception ex){System.out.println(ex);}
                    JLabel lab=new JLabel(">> SELLING RECORDS..");
                    lab.setBounds(20,5,600,70);
                    lab.setForeground(new Color(0x4adede));
                    lab.setFont(new Font("Courier",Font.BOLD,35));f5.add(lab);
                    JTextArea dbase=new JTextArea();
                    dbase.setBounds(30,70,600,500);dbase.setBackground(new Color(0x4adede));
                    dbase.setText(data);
                    ok2 = new JButton("OK!");ok2.setBounds(310,580,60,30);ok2.setBackground(new Color(0x797ef6));
                    ok2.addActionListener(this);f5.add(ok2);
                    f5.setVisible(true);f5.add(dbase);
                    f5.add(ok2);f5.add(lab);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Wrong Admin or Password!!");
                }
            }
        else if(e.getSource()==ok2){
            data="";
            f5.dispose();
            f.setVisible(true);
        }
// Code Developed by AMAR DAVDA(M.no.8200585066) MU-Student(R.no.92200104020/GR.no.116208) 4th semester,B.Tech(Information & Technology)
        else if(e.getSource()==r4)        {
            //Delete..
            f.dispose();
            adm2 = new JFrame();
            adm2.getRootPane().setBorder(BorderFactory.createMatteBorder(9, 9, 9, 9, new Color(0x38817a)));
            adm2.setTitle("MY COZY GROCERY STORE!!");
            adm2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            adm2.setSize(800,690);
            ImageIcon img = new ImageIcon("Amo.png");
            adm2.setIconImage(img.getImage());
            adm2.getContentPane().setBackground(new Color(0xa3dd83));
            adm2.setLayout(null);
            adm2.setVisible(true);
            adm2.setExtendedState(JFrame.MAXIMIZED_BOTH);
            JLabel l1=new JLabel("ADMIN:");l1.setBounds(450,80,200,30);
            at2=new JTextField();at2.setBounds(450,110,300,25);at2.setBackground(new Color(0xf7f39a));
            JLabel l2=new JLabel("PASSWORD:");l2.setBounds(450,180,200,30);
            pt2=new JTextField();pt2.setBounds(450,210,300,25);pt2.setBackground(new Color(0xf7f39a));
            entr2 = new JButton("LOGIN");entr2.setBounds(630,300,90,30);entr2.setBackground(new Color(0x49ae86));
            entr2.addActionListener(this);adm2.add(entr2);
            bac4 = new JButton("BACK");bac4.setBounds(480,300,90,30);bac4.setBackground(new Color(0x49ae86));
            bac4.addActionListener(this);adm2.add(bac4);
            JLabel lab=new JLabel("AUTHORIZED PAGE");
            lab.setBounds(450,5,600,70);
            lab.setForeground(new Color(0x38817a));
            lab.setFont(new Font("Courier",Font.BOLD,30));adm2.add(lab);
            adm2.add(entr2);adm2.add(l1);adm2.add(l2);adm2.add(at2);adm2.add(pt2);adm2.add(bac4);
        }
            else if(e.getSource()==bac4){
                adm2.dispose();
                f.setVisible(true);
            }
            else if(e.getSource()==entr2){
                String ad=at2.getText().trim();
                String pw=pt2.getText().trim();
                if(ad.equals("amar") && pw.equals("1715")){
                    adm2.dispose();
                    f6 = new JFrame();
                    f6.getRootPane().setBorder(BorderFactory.createMatteBorder(9, 9, 9, 9, new Color(0x253f4b)));
                    f6.setTitle("MY COZY GROCERY STORE!!");
                    f6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    f6.setSize(650,600);
                    ImageIcon img = new ImageIcon("Amo.png");
                    f6.setIconImage(img.getImage());
                    f6.getContentPane().setBackground(new Color(0x8eb1c2));
                    f6.setLayout(null);
                    f6.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    JLabel lab=new JLabel("DELETE THE RECORD!");
                    lab.setBounds(420,5,600,70);
                    lab.setForeground(new Color(0x253f4b));
                    lab.setFont(new Font("Courier",Font.BOLD,40));f6.add(lab);
                    JLabel lb1=new JLabel("Enter the Bill_No.:");lb1.setBounds(536,180,200,30);
                    lb1.setFont(new Font("Calibri",Font.BOLD,20));
                    tb1=new JTextField();tb1.setBounds(536,220,200,40);tb1.setBackground(new Color(0x537d90));
                    ok3 = new JButton("DELETE");ok3.setBounds(586,300,100,30);ok3.setBackground(new Color(0x537d90));
                    ok3.addActionListener(this);f6.add(ok3);
                    f6.setVisible(true);
                    f6.add(ok3);f6.add(lb1);f6.add(tb1);f6.add(lab);
        
                }
                else{
                    JOptionPane.showMessageDialog(null,"Wrong admin or Password!!");
                }
            }
        else if(e.getSource()==ok3){
            String bln=tb1.getText();
            int yn=JOptionPane.showConfirmDialog(null,"Are you Sure, you want to Delete it??","Confirmation",JOptionPane.YES_NO_OPTION);
            if(yn==JOptionPane.YES_OPTION){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery","root","");
                    System.out.println("\nConnected Successfully!!\n");
                    Statement stmt = con.createStatement();
                    String sql="DELETE from cust where bill_no="+bln; 
                    int m = stmt.executeUpdate(sql);
                    if(m==1){System.out.println("Removed successfully!!\n");}
                    con.close();
                }
                catch(Exception ex){System.out.println(ex);}
                f6.dispose();
                f.setVisible(true);
            }
            else{
                f6.dispose();
                f.setVisible(true);
            }
        }
        else if(e.getSource()==r5){
            //exit..
            f.dispose();
        }
    }
    public void printRecord(JFrame frame) {
        pj = PrinterJob.getPrinterJob();
        pj.setJobName("Print Bill");
        pj.setPrintable(new Printable() {
            public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.translate((int) pf.getImageableX() * 2, (int) pf.getImageableY() * 2);
                graphics2D.scale(0.5, 0.5);
                frame.print(graphics2D);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean printDialog = pj.printDialog();
        if (printDialog) {
            try {
                pj.print();
            } catch (PrinterException pe) {
                System.out.println("Printer Error!!");
            }
        }
    }
}
// Code Developed by AMAR DAVDA(M.no.8200585066) MU-Student(R.no.92200104020/GR.no.116208) 4th semester,B.Tech(Information & Technology)
class myGroceryStore{
    public static void main(String[] args) {
        new groc();
    }
}