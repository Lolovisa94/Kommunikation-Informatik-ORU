/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Connectivity.ConnectionClass;
import Objects.CurrentUser;
import Methods.SearchUser;
import Validation.Validation;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import methods.EditForum;
import methods.FetchChat;
import methods.FetchPosts;
import methods.User;

/**
 *
 * @author Pierre
 */
public class PageGUI extends javax.swing.JFrame {

    private SearchUser searchUser;
    public static FetchPosts currentFetchPosts;

    /**
     * Creates new form StartingPageGUI
     */
    public PageGUI() {
        initComponents();
        resetMenu();
        resetPanel();
        selectStartsida();
        initializeMethods();
        initializeGUIComponents();

        welcomeText(CurrentUser.currentUser.getName());
        
        
    }
    


    public void initializeGUIComponents() {
        lblIngetSokresultat.setVisible(false);
        tblSoktaAnvandare.setVisible(false);

    }

    public void initializeMethods() {
        searchUser = new SearchUser();
    }

    public void resetMenu() {

        selStartsida.setVisible(false);
        selForum.setVisible(false);
        selKalender.setVisible(false);
        selMeddelanden.setVisible(false);
        selSokfunktion.setVisible(false);
        selProfilinstallningar.setVisible(false);
        selAdminfunktionalitet.setVisible(false);
        if(!CurrentUser.currentUser.isAdmin()){
        btnLaggTillAnvandare.setVisible(false);
        }

        isSelStartsida = false;
        isSelSokfunktion = false;
        isSelMeddelanden = false;
        isSelKalender = false;
        isSelProfilinstallningar = false;
        isSelForum = false;
        isSelAdminfunktionalitet = false;
    }

    public void resetPanel() {
        pnlStartsida.setVisible(false);
        pnlForum.setVisible(false);
        pnlKalender.setVisible(false);
        pnlMeddelanden.setVisible(false);
        pnlSokfunktion.setVisible(false);
        pnlProfilinstallningar.setVisible(false);
        pnlLaggTillAnvandare.setVisible(false);
    }

    public void selectStartsida() {
        resetPanel();
        resetMenu();
        selStartsida.setVisible(true);
        pnlStartsida.setVisible(true);
        isSelStartsida = true;
    }

    public void selectForum() {
        resetPanel();
        resetMenu();
        currentFetchPosts = new FetchPosts();
        selForum.setVisible(true);
        pnlForum.setVisible(true);
        isSelForum = true;
        if(!CurrentUser.currentUser.isAdmin())
        {
            btnTaBortBloggtrad.setVisible(false);
        } 
    }

    public void selectKalender() {
        resetPanel();
        resetMenu();
        selKalender.setVisible(true);
        pnlKalender.setVisible(true);
        isSelKalender = true;
    }

    public void selectMeddelanden() {
        resetPanel();
        resetMenu();
        selMeddelanden.setVisible(true);
        pnlMeddelanden.setVisible(true);
        isSelMeddelanden = true;
        new FetchChat();
    }

    public void selectSokfunktion() {
        resetPanel();
        resetMenu();
        selSokfunktion.setVisible(true);
        pnlSokfunktion.setVisible(true);
        isSelSokfunktion = true;

        tblSoktaAnvandare.setVisible(false);
        if(!CurrentUser.currentUser.isAdmin()){
        btnTaBortAnvändare.setVisible(false);
        }
    }

    public String getSearchText() {
        String searchText = tfSokText.getText();
        return searchText;
    }

    public void selectProfilinstallningar() {
        resetPanel();
        resetMenu();
        selProfilinstallningar.setVisible(true);
        pnlProfilinstallningar.setVisible(true);
        isSelProfilinstallningar = true;
                setInfoPersonligInfo();
                setRadio();
    }

    public void selectAdminfunktionalitet() {
        resetPanel();
        resetMenu();
        selAdminfunktionalitet.setVisible(true);
        pnlLaggTillAnvandare.setVisible(true);
        isSelAdminfunktionalitet = true;
    }

    public void welcomeText(String name) {

        lblWelcome.setText("Välkommen " + name + "!");
    }

    public static void setFelmeddelandePIUppdatera() {
        Validation.setLabelText(lblPIFelmeddelandeUppdatera, "Inga ändringar har gjorts!");
    }

    public void setInfoPersonligInfo() {
        lblPIUserName.setText(CurrentUser.currentUser.getName());

        int ii = CurrentUser.currentUser.getPhone();
        String phone = Integer.toString(ii);

        tfPITlfn.setText(phone);
        tfPIEmail.setText(CurrentUser.currentUser.getEmail());

        // förhindrar att den automatiskt fokuserar på ett textfält och användaren råka ändra
        pnlStartsida.requestFocus();

        //int > String
        int i = 10;
        String s = Integer.toString(i);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenuBackground = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        panelMenuLogga = new javax.swing.JPanel();
        iconLogga = new javax.swing.JLabel();
        lblOrebro = new javax.swing.JLabel();
        lblUniversitet = new javax.swing.JLabel();
        btnStartsida = new javax.swing.JPanel();
        lblBtnStartsida = new javax.swing.JLabel();
        selStartsida = new javax.swing.JPanel();
        btnLaggTillAnvandare = new javax.swing.JPanel();
        lblBtnAdminfunktionalitet = new javax.swing.JLabel();
        selAdminfunktionalitet = new javax.swing.JPanel();
        btnProfilinstallningar = new javax.swing.JPanel();
        lblBtnProfilinstallningar = new javax.swing.JLabel();
        selProfilinstallningar = new javax.swing.JPanel();
        btnSokfunktion = new javax.swing.JPanel();
        lblBtnSokfunktion = new javax.swing.JLabel();
        selSokfunktion = new javax.swing.JPanel();
        btnMeddelanden = new javax.swing.JPanel();
        lblBtnStartsida4 = new javax.swing.JLabel();
        selMeddelanden = new javax.swing.JPanel();
        btnKalender = new javax.swing.JPanel();
        lblBtnKalender = new javax.swing.JLabel();
        selKalender = new javax.swing.JPanel();
        btnForum = new javax.swing.JPanel();
        lblBtnForum = new javax.swing.JLabel();
        selForum = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        pnlStartsida = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        pnlKalender = new javax.swing.JPanel();
        lblKalender = new javax.swing.JLabel();
        pnlMeddelanden = new javax.swing.JPanel();
        lblMeddelanden = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChats = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelBoxChat = new javax.swing.JPanel();
        panelChat = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taCreateChatMessage = new javax.swing.JTextArea();
        btnSendChat = new javax.swing.JButton();
        btnRefreshChat = new javax.swing.JButton();
        pnlSokfunktion = new javax.swing.JPanel();
        lblSokfunktion = new javax.swing.JLabel();
        tfSokText = new javax.swing.JTextField();
        btnSokAnvandare = new javax.swing.JPanel();
        lblbtnSokAnvandare = new javax.swing.JLabel();
        lblIngetSokresultat = new javax.swing.JLabel();
        spSoktaAnvandare = new javax.swing.JScrollPane();
        tblSoktaAnvandare = new javax.swing.JTable();
        btnTaBortAnvändare = new javax.swing.JButton();
        btnStartChat = new javax.swing.JButton();
        pnlForum = new javax.swing.JPanel();
        btnSkapaBloggtrad = new javax.swing.JPanel();
        lblbtnSkapaBloggtrad = new javax.swing.JLabel();
        lblForum = new javax.swing.JLabel();
        pnlFVisaKategorier = new javax.swing.JPanel();
        lblFVisaKategorier = new javax.swing.JLabel();
        lblFForskning = new javax.swing.JLabel();
        lblFUtbildning = new javax.swing.JLabel();
        lblFAllmant = new javax.swing.JLabel();
        cbFForskning = new javax.swing.JCheckBox();
        cbFUtbildning = new javax.swing.JCheckBox();
        cbFOvrigt = new javax.swing.JCheckBox();
        sPForum = new javax.swing.JScrollPane();
        tblForum = new javax.swing.JTable();
        pnlFSok = new javax.swing.JPanel();
        sepFSok = new javax.swing.JSeparator();
        tfFSok = new javax.swing.JTextField();
        iconSearch = new javax.swing.JLabel();
        btnTaBortBloggtrad = new javax.swing.JPanel();
        lblbtnTaBortBloggtrad = new javax.swing.JLabel();
        pnlProfilinstallningar = new javax.swing.JPanel();
        lblPIRubrik = new javax.swing.JLabel();
        lblPIEmail = new javax.swing.JLabel();
        lblPITlfn = new javax.swing.JLabel();
        lblPIPW = new javax.swing.JLabel();
        lblPINamn = new javax.swing.JLabel();
        tfPITlfn = new javax.swing.JTextField();
        tfPIEmail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblPersonligaInstallningarText = new javax.swing.JLabel();
        pnlPIUserName = new javax.swing.JPanel();
        lblPIUserName = new javax.swing.JLabel();
        btnPIUppdatera = new javax.swing.JButton();
        lblPIFelmeddelandeNamn = new javax.swing.JLabel();
        lblPIFelmeddelandeUppdatera = new javax.swing.JLabel();
        lblPITlfn1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        pnlLaggTillAnvandare = new javax.swing.JPanel();
        lblLaggTillAnvandare = new javax.swing.JLabel();
        lblAnvTele = new javax.swing.JLabel();
        btnLaggTillAnv = new javax.swing.JButton();
        tfAnvNamn = new javax.swing.JTextField();
        lblAdminFraga = new javax.swing.JLabel();
        lblAnvNamn = new javax.swing.JLabel();
        cbAdminFraga = new javax.swing.JCheckBox();
        tfLosenord = new javax.swing.JTextField();
        lblAnvLosenord = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lblAnvEpost = new javax.swing.JLabel();
        tfAnvTelefon = new javax.swing.JTextField();
        lblLaggTillAnvError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenuBackground.setBackground(new java.awt.Color(158, 174, 187));
        panelMenuBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMenu.setBackground(new java.awt.Color(77, 85, 92));

        panelMenuLogga.setBackground(new java.awt.Color(77, 85, 92));
        panelMenuLogga.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconLogga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logga.png"))); // NOI18N
        panelMenuLogga.add(iconLogga, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 26, -1, -1));

        lblOrebro.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        lblOrebro.setForeground(new java.awt.Color(202, 100, 91));
        lblOrebro.setText("Universitet");
        panelMenuLogga.add(lblOrebro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, 22));

        lblUniversitet.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        lblUniversitet.setForeground(new java.awt.Color(202, 100, 91));
        lblUniversitet.setText("Örebro");
        panelMenuLogga.add(lblUniversitet, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        btnStartsida.setBackground(new java.awt.Color(77, 85, 92));
        btnStartsida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStartsidaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnStartsidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnStartsidaMouseExited(evt);
            }
        });

        lblBtnStartsida.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lblBtnStartsida.setForeground(new java.awt.Color(158, 174, 187));
        lblBtnStartsida.setText("Startsida");

        selStartsida.setBackground(new java.awt.Color(202, 100, 91));

        javax.swing.GroupLayout selStartsidaLayout = new javax.swing.GroupLayout(selStartsida);
        selStartsida.setLayout(selStartsidaLayout);
        selStartsidaLayout.setHorizontalGroup(
            selStartsidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        selStartsidaLayout.setVerticalGroup(
            selStartsidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnStartsidaLayout = new javax.swing.GroupLayout(btnStartsida);
        btnStartsida.setLayout(btnStartsidaLayout);
        btnStartsidaLayout.setHorizontalGroup(
            btnStartsidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnStartsidaLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblBtnStartsida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                .addComponent(selStartsida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnStartsidaLayout.setVerticalGroup(
            btnStartsidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selStartsida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnStartsidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBtnStartsida)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        selStartsida.getAccessibleContext().setAccessibleDescription("");

        btnLaggTillAnvandare.setBackground(new java.awt.Color(77, 85, 92));
        btnLaggTillAnvandare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaggTillAnvandareMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLaggTillAnvandareMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLaggTillAnvandareMouseExited(evt);
            }
        });

        lblBtnAdminfunktionalitet.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lblBtnAdminfunktionalitet.setForeground(new java.awt.Color(158, 174, 187));
        lblBtnAdminfunktionalitet.setText("Lägg Till Användare");

        selAdminfunktionalitet.setBackground(new java.awt.Color(202, 100, 91));

        javax.swing.GroupLayout selAdminfunktionalitetLayout = new javax.swing.GroupLayout(selAdminfunktionalitet);
        selAdminfunktionalitet.setLayout(selAdminfunktionalitetLayout);
        selAdminfunktionalitetLayout.setHorizontalGroup(
            selAdminfunktionalitetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        selAdminfunktionalitetLayout.setVerticalGroup(
            selAdminfunktionalitetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnLaggTillAnvandareLayout = new javax.swing.GroupLayout(btnLaggTillAnvandare);
        btnLaggTillAnvandare.setLayout(btnLaggTillAnvandareLayout);
        btnLaggTillAnvandareLayout.setHorizontalGroup(
            btnLaggTillAnvandareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLaggTillAnvandareLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblBtnAdminfunktionalitet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addComponent(selAdminfunktionalitet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnLaggTillAnvandareLayout.setVerticalGroup(
            btnLaggTillAnvandareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selAdminfunktionalitet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnLaggTillAnvandareLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBtnAdminfunktionalitet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnProfilinstallningar.setBackground(new java.awt.Color(77, 85, 92));
        btnProfilinstallningar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProfilinstallningarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProfilinstallningarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProfilinstallningarMouseExited(evt);
            }
        });

        lblBtnProfilinstallningar.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lblBtnProfilinstallningar.setForeground(new java.awt.Color(158, 174, 187));
        lblBtnProfilinstallningar.setText("Profilinställningar");

        selProfilinstallningar.setBackground(new java.awt.Color(202, 100, 91));

        javax.swing.GroupLayout selProfilinstallningarLayout = new javax.swing.GroupLayout(selProfilinstallningar);
        selProfilinstallningar.setLayout(selProfilinstallningarLayout);
        selProfilinstallningarLayout.setHorizontalGroup(
            selProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        selProfilinstallningarLayout.setVerticalGroup(
            selProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnProfilinstallningarLayout = new javax.swing.GroupLayout(btnProfilinstallningar);
        btnProfilinstallningar.setLayout(btnProfilinstallningarLayout);
        btnProfilinstallningarLayout.setHorizontalGroup(
            btnProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProfilinstallningarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblBtnProfilinstallningar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addComponent(selProfilinstallningar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnProfilinstallningarLayout.setVerticalGroup(
            btnProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selProfilinstallningar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnProfilinstallningarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBtnProfilinstallningar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSokfunktion.setBackground(new java.awt.Color(77, 85, 92));
        btnSokfunktion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSokfunktionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSokfunktionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSokfunktionMouseExited(evt);
            }
        });

        lblBtnSokfunktion.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lblBtnSokfunktion.setForeground(new java.awt.Color(158, 174, 187));
        lblBtnSokfunktion.setText("Sökfunktion");

        selSokfunktion.setBackground(new java.awt.Color(202, 100, 91));

        javax.swing.GroupLayout selSokfunktionLayout = new javax.swing.GroupLayout(selSokfunktion);
        selSokfunktion.setLayout(selSokfunktionLayout);
        selSokfunktionLayout.setHorizontalGroup(
            selSokfunktionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        selSokfunktionLayout.setVerticalGroup(
            selSokfunktionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnSokfunktionLayout = new javax.swing.GroupLayout(btnSokfunktion);
        btnSokfunktion.setLayout(btnSokfunktionLayout);
        btnSokfunktionLayout.setHorizontalGroup(
            btnSokfunktionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSokfunktionLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblBtnSokfunktion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                .addComponent(selSokfunktion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnSokfunktionLayout.setVerticalGroup(
            btnSokfunktionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selSokfunktion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnSokfunktionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBtnSokfunktion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnMeddelanden.setBackground(new java.awt.Color(77, 85, 92));
        btnMeddelanden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMeddelandenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMeddelandenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMeddelandenMouseExited(evt);
            }
        });

        lblBtnStartsida4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lblBtnStartsida4.setForeground(new java.awt.Color(158, 174, 187));
        lblBtnStartsida4.setText("Meddelanden");

        selMeddelanden.setBackground(new java.awt.Color(202, 100, 91));

        javax.swing.GroupLayout selMeddelandenLayout = new javax.swing.GroupLayout(selMeddelanden);
        selMeddelanden.setLayout(selMeddelandenLayout);
        selMeddelandenLayout.setHorizontalGroup(
            selMeddelandenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        selMeddelandenLayout.setVerticalGroup(
            selMeddelandenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnMeddelandenLayout = new javax.swing.GroupLayout(btnMeddelanden);
        btnMeddelanden.setLayout(btnMeddelandenLayout);
        btnMeddelandenLayout.setHorizontalGroup(
            btnMeddelandenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMeddelandenLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblBtnStartsida4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                .addComponent(selMeddelanden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnMeddelandenLayout.setVerticalGroup(
            btnMeddelandenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selMeddelanden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnMeddelandenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBtnStartsida4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnKalender.setBackground(new java.awt.Color(77, 85, 92));
        btnKalender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKalenderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnKalenderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnKalenderMouseExited(evt);
            }
        });

        lblBtnKalender.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lblBtnKalender.setForeground(new java.awt.Color(158, 174, 187));
        lblBtnKalender.setText("Kalender");

        selKalender.setBackground(new java.awt.Color(202, 100, 91));

        javax.swing.GroupLayout selKalenderLayout = new javax.swing.GroupLayout(selKalender);
        selKalender.setLayout(selKalenderLayout);
        selKalenderLayout.setHorizontalGroup(
            selKalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        selKalenderLayout.setVerticalGroup(
            selKalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnKalenderLayout = new javax.swing.GroupLayout(btnKalender);
        btnKalender.setLayout(btnKalenderLayout);
        btnKalenderLayout.setHorizontalGroup(
            btnKalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnKalenderLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblBtnKalender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                .addComponent(selKalender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnKalenderLayout.setVerticalGroup(
            btnKalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selKalender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnKalenderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBtnKalender)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnForum.setBackground(new java.awt.Color(77, 85, 92));
        btnForum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnForumMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnForumMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnForumMouseExited(evt);
            }
        });

        lblBtnForum.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lblBtnForum.setForeground(new java.awt.Color(158, 174, 187));
        lblBtnForum.setText("Forum");

        selForum.setBackground(new java.awt.Color(202, 100, 91));

        javax.swing.GroupLayout selForumLayout = new javax.swing.GroupLayout(selForum);
        selForum.setLayout(selForumLayout);
        selForumLayout.setHorizontalGroup(
            selForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        selForumLayout.setVerticalGroup(
            selForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnForumLayout = new javax.swing.GroupLayout(btnForum);
        btnForum.setLayout(btnForumLayout);
        btnForumLayout.setHorizontalGroup(
            btnForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnForumLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblBtnForum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                .addComponent(selForum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnForumLayout.setVerticalGroup(
            btnForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selForum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnForumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBtnForum)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnStartsida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMenuLogga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(btnLaggTillAnvandare, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProfilinstallningar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSokfunktion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMeddelanden, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKalender, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnForum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(panelMenuLogga, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStartsida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnForum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKalender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMeddelanden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSokfunktion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProfilinstallningar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLaggTillAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(818, 818, 818))
        );

        panelMenuBackground.add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1010));

        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlStartsida.setBackground(new java.awt.Color(158, 174, 187));

        lblWelcome.setBackground(new java.awt.Color(77, 85, 92));
        lblWelcome.setFont(new java.awt.Font("Poppins Medium", 1, 48)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(77, 85, 92));
        lblWelcome.setText("Välkommen användare!");

        javax.swing.GroupLayout pnlStartsidaLayout = new javax.swing.GroupLayout(pnlStartsida);
        pnlStartsida.setLayout(pnlStartsidaLayout);
        pnlStartsidaLayout.setHorizontalGroup(
            pnlStartsidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStartsidaLayout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(lblWelcome)
                .addContainerGap(505, Short.MAX_VALUE))
        );
        pnlStartsidaLayout.setVerticalGroup(
            pnlStartsidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStartsidaLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(898, Short.MAX_VALUE))
        );

        jLayeredPane2.add(pnlStartsida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlKalender.setBackground(new java.awt.Color(158, 174, 187));

        lblKalender.setBackground(new java.awt.Color(77, 85, 92));
        lblKalender.setFont(new java.awt.Font("Poppins Medium", 1, 48)); // NOI18N
        lblKalender.setForeground(new java.awt.Color(77, 85, 92));
        lblKalender.setText("Kalender");

        javax.swing.GroupLayout pnlKalenderLayout = new javax.swing.GroupLayout(pnlKalender);
        pnlKalender.setLayout(pnlKalenderLayout);
        pnlKalenderLayout.setHorizontalGroup(
            pnlKalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKalenderLayout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(lblKalender)
                .addContainerGap(927, Short.MAX_VALUE))
        );
        pnlKalenderLayout.setVerticalGroup(
            pnlKalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKalenderLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblKalender, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(898, Short.MAX_VALUE))
        );

        jLayeredPane2.add(pnlKalender, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlMeddelanden.setBackground(new java.awt.Color(158, 174, 187));
        pnlMeddelanden.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMeddelanden.setBackground(new java.awt.Color(77, 85, 92));
        lblMeddelanden.setFont(new java.awt.Font("Poppins Medium", 1, 48)); // NOI18N
        lblMeddelanden.setForeground(new java.awt.Color(77, 85, 92));
        lblMeddelanden.setText("Meddelanden");
        pnlMeddelanden.add(lblMeddelanden, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 58, -1, 60));

        tblChats.setAutoCreateRowSorter(true);
        tblChats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {
                "Chattar"
            }
        ));
        jScrollPane1.setViewportView(tblChats);

        pnlMeddelanden.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 161, 290, 633));

        jScrollPane2.setBackground(new java.awt.Color(158, 174, 187));
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelBoxChat.setBackground(new java.awt.Color(158, 174, 187));
        panelBoxChat.setAlignmentY(0.0F);
        panelBoxChat.setLayout(new javax.swing.BoxLayout(panelBoxChat, javax.swing.BoxLayout.PAGE_AXIS));

        panelChat.setBackground(new java.awt.Color(158, 174, 187));
        panelChat.setToolTipText("");
        panelChat.setRequestFocusEnabled(false);
        panelChat.setLayout(new javax.swing.BoxLayout(panelChat, javax.swing.BoxLayout.LINE_AXIS));
        panelBoxChat.add(panelChat);

        jScrollPane2.setViewportView(panelBoxChat);

        pnlMeddelanden.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 162, 810, 450));

        taCreateChatMessage.setColumns(20);
        taCreateChatMessage.setLineWrap(true);
        taCreateChatMessage.setRows(5);
        jScrollPane3.setViewportView(taCreateChatMessage);

        pnlMeddelanden.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 625, 720, 169));

        btnSendChat.setText("Skicka");
        btnSendChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendChatActionPerformed(evt);
            }
        });
        pnlMeddelanden.add(btnSendChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 630, -1, -1));

        btnRefreshChat.setText("Refresh");
        btnRefreshChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshChatActionPerformed(evt);
            }
        });
        pnlMeddelanden.add(btnRefreshChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        jLayeredPane2.add(pnlMeddelanden, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlSokfunktion.setBackground(new java.awt.Color(158, 174, 187));

        lblSokfunktion.setBackground(new java.awt.Color(77, 85, 92));
        lblSokfunktion.setFont(new java.awt.Font("Poppins Medium", 1, 48)); // NOI18N
        lblSokfunktion.setForeground(new java.awt.Color(77, 85, 92));
        lblSokfunktion.setText("Sökfunktion");

        tfSokText.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfSokText.setForeground(new java.awt.Color(77, 85, 92));
        tfSokText.setText("Sök efter användare");
        tfSokText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfSokTextMouseClicked(evt);
            }
        });
        tfSokText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSokTextActionPerformed(evt);
            }
        });

        btnSokAnvandare.setBackground(new java.awt.Color(0, 94, 125));
        btnSokAnvandare.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 94, 125), 2, true));
        btnSokAnvandare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSokAnvandareMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSokAnvandareMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSokAnvandareMouseExited(evt);
            }
        });

        lblbtnSokAnvandare.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        lblbtnSokAnvandare.setForeground(new java.awt.Color(158, 174, 187));
        lblbtnSokAnvandare.setText("Sök");
        lblbtnSokAnvandare.setIconTextGap(5);
        btnSokAnvandare.add(lblbtnSokAnvandare);

        lblIngetSokresultat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblIngetSokresultat.setForeground(new java.awt.Color(77, 85, 92));
        lblIngetSokresultat.setText("Sökningen gav inget resultat.");

        spSoktaAnvandare.setBackground(new java.awt.Color(158, 174, 187));
        spSoktaAnvandare.setForeground(new java.awt.Color(77, 85, 92));

        tblSoktaAnvandare.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tblSoktaAnvandare.setForeground(new java.awt.Color(77, 85, 92));
        tblSoktaAnvandare.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Namn", "Telefon", "Email"
            }
        ));
        tblSoktaAnvandare.setName(""); // NOI18N
        tblSoktaAnvandare.setRowHeight(20);
        tblSoktaAnvandare.getTableHeader().setReorderingAllowed(false);
        tblSoktaAnvandare.setPreferredScrollableViewportSize(
            new Dimension(
                tblSoktaAnvandare.getPreferredSize().width,
                tblSoktaAnvandare.getRowHeight() * tblSoktaAnvandare.getRowCount()));
        spSoktaAnvandare.setViewportView(tblSoktaAnvandare);

        btnTaBortAnvändare.setText("Ta bort användare");
        btnTaBortAnvändare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortAnvändareActionPerformed(evt);
            }
        });

        btnStartChat.setText("Starta en chatt med användaren");
        btnStartChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartChatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSokfunktionLayout = new javax.swing.GroupLayout(pnlSokfunktion);
        pnlSokfunktion.setLayout(pnlSokfunktionLayout);
        pnlSokfunktionLayout.setHorizontalGroup(
            pnlSokfunktionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSokfunktionLayout.createSequentialGroup()
                .addGroup(pnlSokfunktionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSokfunktionLayout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(lblSokfunktion))
                    .addGroup(pnlSokfunktionLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(pnlSokfunktionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSokfunktionLayout.createSequentialGroup()
                                .addComponent(tfSokText, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSokAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblIngetSokresultat, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlSokfunktionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pnlSokfunktionLayout.createSequentialGroup()
                                    .addComponent(btnStartChat)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTaBortAnvändare))
                                .addComponent(spSoktaAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(717, Short.MAX_VALUE))
        );
        pnlSokfunktionLayout.setVerticalGroup(
            pnlSokfunktionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSokfunktionLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblSokfunktion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(pnlSokfunktionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSokfunktionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSokAnvandare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfSokText))
                    .addComponent(lblIngetSokresultat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(spSoktaAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(pnlSokfunktionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaBortAnvändare)
                    .addComponent(btnStartChat))
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jLayeredPane2.add(pnlSokfunktion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlForum.setBackground(new java.awt.Color(158, 174, 187));
        pnlForum.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSkapaBloggtrad.setBackground(new java.awt.Color(0, 94, 125));
        btnSkapaBloggtrad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 94, 125), 2, true));
        btnSkapaBloggtrad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkapaBloggtradMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSkapaBloggtradMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSkapaBloggtradMouseExited(evt);
            }
        });

        lblbtnSkapaBloggtrad.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblbtnSkapaBloggtrad.setForeground(new java.awt.Color(158, 174, 187));
        lblbtnSkapaBloggtrad.setText("Skapa Bloggtråd");
        lblbtnSkapaBloggtrad.setIconTextGap(5);
        lblbtnSkapaBloggtrad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblbtnSkapaBloggtradKeyPressed(evt);
            }
        });
        btnSkapaBloggtrad.add(lblbtnSkapaBloggtrad);

        pnlForum.add(btnSkapaBloggtrad, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 260, 270, -1));

        lblForum.setBackground(new java.awt.Color(77, 85, 92));
        lblForum.setFont(new java.awt.Font("Poppins Medium", 1, 48)); // NOI18N
        lblForum.setForeground(new java.awt.Color(77, 85, 92));
        lblForum.setText("Forum");
        pnlForum.add(lblForum, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, 60));

        pnlFVisaKategorier.setBackground(new java.awt.Color(158, 174, 187));

        lblFVisaKategorier.setBackground(new java.awt.Color(77, 85, 92));
        lblFVisaKategorier.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        lblFVisaKategorier.setForeground(new java.awt.Color(77, 85, 92));
        lblFVisaKategorier.setText("Visa kategorier");

        lblFForskning.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblFForskning.setForeground(new java.awt.Color(77, 85, 92));
        lblFForskning.setText("Forskning");

        lblFUtbildning.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblFUtbildning.setForeground(new java.awt.Color(77, 85, 92));
        lblFUtbildning.setText("Utbildning");

        lblFAllmant.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblFAllmant.setForeground(new java.awt.Color(77, 85, 92));
        lblFAllmant.setText("Allmänt");

        cbFForskning.setBackground(new java.awt.Color(158, 174, 187));
        cbFForskning.setSelected(true);
        cbFForskning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbFForskningMouseClicked(evt);
            }
        });
        cbFForskning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFForskningActionPerformed(evt);
            }
        });

        cbFUtbildning.setBackground(new java.awt.Color(158, 174, 187));
        cbFUtbildning.setSelected(true);
        cbFUtbildning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbFUtbildningMouseClicked(evt);
            }
        });
        cbFUtbildning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFUtbildningActionPerformed(evt);
            }
        });

        cbFOvrigt.setBackground(new java.awt.Color(158, 174, 187));
        cbFOvrigt.setSelected(true);
        cbFOvrigt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbFOvrigtMouseClicked(evt);
            }
        });
        cbFOvrigt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFOvrigtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFVisaKategorierLayout = new javax.swing.GroupLayout(pnlFVisaKategorier);
        pnlFVisaKategorier.setLayout(pnlFVisaKategorierLayout);
        pnlFVisaKategorierLayout.setHorizontalGroup(
            pnlFVisaKategorierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFVisaKategorierLayout.createSequentialGroup()
                .addGroup(pnlFVisaKategorierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFVisaKategorierLayout.createSequentialGroup()
                        .addComponent(lblFVisaKategorier)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlFVisaKategorierLayout.createSequentialGroup()
                        .addComponent(lblFForskning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFForskning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(lblFUtbildning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFUtbildning)
                        .addGap(18, 18, 18)
                        .addComponent(lblFAllmant)
                        .addGap(4, 4, 4)
                        .addComponent(cbFOvrigt)))
                .addContainerGap())
        );
        pnlFVisaKategorierLayout.setVerticalGroup(
            pnlFVisaKategorierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFVisaKategorierLayout.createSequentialGroup()
                .addComponent(lblFVisaKategorier)
                .addGap(18, 18, 18)
                .addGroup(pnlFVisaKategorierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFVisaKategorierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbFForskning, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlFVisaKategorierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFForskning)
                            .addComponent(lblFAllmant)))
                    .addComponent(cbFOvrigt)
                    .addComponent(lblFUtbildning)
                    .addComponent(cbFUtbildning))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pnlForum.add(pnlFVisaKategorier, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        sPForum.setBackground(new java.awt.Color(158, 174, 187));
        sPForum.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(77, 85, 92), 1, true));
        sPForum.setForeground(new java.awt.Color(158, 174, 187));
        sPForum.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        sPForum.getViewport().setBackground(new java.awt.Color(158, 174, 187));

        tblForum.setBackground(new java.awt.Color(158, 174, 187));
        tblForum.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        tblForum.setForeground(new java.awt.Color(77, 85, 92));
        tblForum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kategori", "Titel", "Trådförfattare", "Publicerad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblForum.setGridColor(new java.awt.Color(77, 85, 92));
        tblForum.setOpaque(false);
        tblForum.setRowHeight(40);
        tblForum.setSelectionBackground(new java.awt.Color(0, 94, 125));
        tblForum.setSelectionForeground(new java.awt.Color(158, 174, 187));
        tblForum.setShowGrid(true);
        tblForum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblForumMouseClicked(evt);
            }
        });
        sPForum.setViewportView(tblForum);
        tblForum.getTableHeader().setFont(new java.awt.Font("Poppins Medium", 0, 18));

        tblForum.getTableHeader().setForeground(new java.awt.Color(77,85,92));

        tblForum.getTableHeader().setBackground(new java.awt.Color(158, 174, 187));

        tblForum.getTableHeader().setBorder(new javax.swing.border.LineBorder(new java.awt.Color(77, 85, 92), 1, true));

        tblForum.setAutoCreateRowSorter(true);

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblForum.getModel());
        tblForum.setRowSorter(sorter);
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int columnIndexToSort = 3;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();

        tblForum.getColumnModel().getColumn(0).setPreferredWidth(8);
        tblForum.getColumnModel().getColumn(1).setPreferredWidth(400);
        tblForum.getColumnModel().getColumn(2).setPreferredWidth(20);
        tblForum.getColumnModel().getColumn(3).setPreferredWidth(20);

        pnlForum.add(sPForum, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 1150, 465));

        pnlFSok.setBackground(new java.awt.Color(158, 174, 187));

        sepFSok.setBackground(new java.awt.Color(0, 94, 125));
        sepFSok.setForeground(new java.awt.Color(0, 94, 125));

        tfFSok.setBackground(new java.awt.Color(158, 174, 187));
        tfFSok.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        tfFSok.setForeground(new java.awt.Color(0, 94, 125));
        tfFSok.setBorder(null);
        tfFSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFSokActionPerformed(evt);
            }
        });

        iconSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/searchIcon.png"))); // NOI18N

        javax.swing.GroupLayout pnlFSokLayout = new javax.swing.GroupLayout(pnlFSok);
        pnlFSok.setLayout(pnlFSokLayout);
        pnlFSokLayout.setHorizontalGroup(
            pnlFSokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFSokLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFSokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sepFSok)
                    .addComponent(tfFSok, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconSearch)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        pnlFSokLayout.setVerticalGroup(
            pnlFSokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFSokLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(pnlFSokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFSok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepFSok, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pnlForum.add(pnlFSok, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, -1, -1));

        btnTaBortBloggtrad.setBackground(new java.awt.Color(0, 94, 125));
        btnTaBortBloggtrad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 94, 125), 2, true));
        btnTaBortBloggtrad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaBortBloggtradMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTaBortBloggtradMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTaBortBloggtradMouseExited(evt);
            }
        });

        lblbtnTaBortBloggtrad.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblbtnTaBortBloggtrad.setForeground(new java.awt.Color(158, 174, 187));
        lblbtnTaBortBloggtrad.setText("Ta Bort Bloggtråd");
        lblbtnTaBortBloggtrad.setIconTextGap(5);
        lblbtnTaBortBloggtrad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblbtnTaBortBloggtradKeyPressed(evt);
            }
        });
        btnTaBortBloggtrad.add(lblbtnTaBortBloggtrad);

        pnlForum.add(btnTaBortBloggtrad, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 310, 270, -1));

        jLayeredPane2.add(pnlForum, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlProfilinstallningar.setBackground(new java.awt.Color(158, 174, 187));

        lblPIRubrik.setBackground(new java.awt.Color(77, 85, 92));
        lblPIRubrik.setFont(new java.awt.Font("Poppins Medium", 1, 24)); // NOI18N
        lblPIRubrik.setForeground(new java.awt.Color(77, 85, 92));
        lblPIRubrik.setText("Personliga inställningar:");

        lblPIEmail.setBackground(new java.awt.Color(77, 85, 92));
        lblPIEmail.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        lblPIEmail.setForeground(new java.awt.Color(77, 85, 92));
        lblPIEmail.setText("Email:");

        lblPITlfn.setBackground(new java.awt.Color(77, 85, 92));
        lblPITlfn.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        lblPITlfn.setForeground(new java.awt.Color(77, 85, 92));
        lblPITlfn.setText("Telefonnummer:");

        lblPIPW.setBackground(new java.awt.Color(77, 85, 92));
        lblPIPW.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        lblPIPW.setForeground(new java.awt.Color(77, 85, 92));
        lblPIPW.setText("Lösenord:");

        lblPINamn.setBackground(new java.awt.Color(77, 85, 92));
        lblPINamn.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        lblPINamn.setForeground(new java.awt.Color(77, 85, 92));
        lblPINamn.setText("Namn:");

        tfPIEmail.setColumns(8);
        tfPIEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPIEmailActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(202, 100, 91));
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Byt lösenord");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblPersonligaInstallningarText.setBackground(new java.awt.Color(77, 85, 92));
        lblPersonligaInstallningarText.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        lblPersonligaInstallningarText.setForeground(new java.awt.Color(77, 85, 92));
        lblPersonligaInstallningarText.setText("Välkommen! Här finns möjligheten att när som helst se och ändra sin personliga information!");

        pnlPIUserName.setForeground(new java.awt.Color(153, 153, 153));
        pnlPIUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPIUserNameMouseClicked(evt);
            }
        });

        lblPIUserName.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        lblPIUserName.setForeground(new java.awt.Color(0, 0, 0));
        lblPIUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPIUserNameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlPIUserNameLayout = new javax.swing.GroupLayout(pnlPIUserName);
        pnlPIUserName.setLayout(pnlPIUserNameLayout);
        pnlPIUserNameLayout.setHorizontalGroup(
            pnlPIUserNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPIUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
        );
        pnlPIUserNameLayout.setVerticalGroup(
            pnlPIUserNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPIUserNameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblPIUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnPIUppdatera.setBackground(new java.awt.Color(202, 100, 91));
        btnPIUppdatera.setForeground(new java.awt.Color(204, 204, 204));
        btnPIUppdatera.setText("Uppdatera");
        btnPIUppdatera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPIUppdateraActionPerformed(evt);
            }
        });

        lblPIFelmeddelandeNamn.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        lblPIFelmeddelandeNamn.setForeground(new java.awt.Color(255, 51, 51));

        lblPITlfn1.setBackground(new java.awt.Color(77, 85, 92));
        lblPITlfn1.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        lblPITlfn1.setForeground(new java.awt.Color(77, 85, 92));
        lblPITlfn1.setText("Notifiering via e-post:");

        jRadioButton1.setFont(new java.awt.Font(".SF NS Text", 1, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton1.setText("Ja");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font(".SF NS Text", 1, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton2.setText("Nej");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProfilinstallningarLayout = new javax.swing.GroupLayout(pnlProfilinstallningar);
        pnlProfilinstallningar.setLayout(pnlProfilinstallningarLayout);
        pnlProfilinstallningarLayout.setHorizontalGroup(
            pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfilinstallningarLayout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addGroup(pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProfilinstallningarLayout.createSequentialGroup()
                        .addComponent(lblPITlfn1)
                        .addGroup(pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProfilinstallningarLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPIFelmeddelandeUppdatera, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(879, Short.MAX_VALUE))
                            .addGroup(pnlProfilinstallningarLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jRadioButton1)
                                .addGap(74, 74, 74)
                                .addComponent(jRadioButton2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pnlProfilinstallningarLayout.createSequentialGroup()
                        .addGroup(pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPersonligaInstallningarText)
                            .addComponent(lblPIRubrik)
                            .addGroup(pnlProfilinstallningarLayout.createSequentialGroup()
                                .addGroup(pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPIEmail)
                                    .addComponent(lblPITlfn)
                                    .addComponent(lblPINamn))
                                .addGap(87, 87, 87)
                                .addGroup(pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfPITlfn, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfPIEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pnlPIUserName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblPIFelmeddelandeNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlProfilinstallningarLayout.createSequentialGroup()
                                .addComponent(lblPIPW)
                                .addGap(182, 182, 182)
                                .addGroup(pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(btnPIUppdatera))))
                        .addContainerGap(717, Short.MAX_VALUE))))
        );
        pnlProfilinstallningarLayout.setVerticalGroup(
            pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfilinstallningarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblPIRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPersonligaInstallningarText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPINamn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlProfilinstallningarLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(pnlPIUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblPIFelmeddelandeNamn)
                .addGap(49, 49, 49)
                .addGroup(pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPIEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPIEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPITlfn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPITlfn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProfilinstallningarLayout.createSequentialGroup()
                        .addComponent(lblPIFelmeddelandeUppdatera, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)))
                    .addComponent(lblPITlfn1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPIUppdatera)
                .addGap(52, 52, 52)
                .addGroup(pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPIPW, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(218, Short.MAX_VALUE))
        );

        jLayeredPane2.add(pnlProfilinstallningar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlLaggTillAnvandare.setBackground(new java.awt.Color(158, 174, 187));

        lblLaggTillAnvandare.setBackground(new java.awt.Color(77, 85, 92));
        lblLaggTillAnvandare.setFont(new java.awt.Font("Poppins Medium", 1, 48)); // NOI18N
        lblLaggTillAnvandare.setForeground(new java.awt.Color(77, 85, 92));
        lblLaggTillAnvandare.setText("Lägg till användare");

        lblAnvTele.setText("Telefon");

        btnLaggTillAnv.setText("Lägg till ny använadare");
        btnLaggTillAnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillAnvActionPerformed(evt);
            }
        });

        lblAdminFraga.setText("Admin");

        lblAnvNamn.setText("Namn");

        cbAdminFraga.setText("Ja");
        cbAdminFraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAdminFragaActionPerformed(evt);
            }
        });

        tfLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLosenordActionPerformed(evt);
            }
        });

        lblAnvLosenord.setText("Lösenord");

        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });

        lblAnvEpost.setText("Email");

        lblLaggTillAnvError.setForeground(new java.awt.Color(202, 100, 91));

        javax.swing.GroupLayout pnlLaggTillAnvandareLayout = new javax.swing.GroupLayout(pnlLaggTillAnvandare);
        pnlLaggTillAnvandare.setLayout(pnlLaggTillAnvandareLayout);
        pnlLaggTillAnvandareLayout.setHorizontalGroup(
            pnlLaggTillAnvandareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLaggTillAnvandareLayout.createSequentialGroup()
                .addGroup(pnlLaggTillAnvandareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLaggTillAnvandareLayout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(lblLaggTillAnvandare))
                    .addGroup(pnlLaggTillAnvandareLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(pnlLaggTillAnvandareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLaggTillAnv, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlLaggTillAnvandareLayout.createSequentialGroup()
                                .addGroup(pnlLaggTillAnvandareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAdminFraga)
                                    .addComponent(lblAnvNamn)
                                    .addComponent(lblAnvTele)
                                    .addComponent(lblAnvEpost)
                                    .addComponent(lblAnvLosenord))
                                .addGap(89, 89, 89)
                                .addGroup(pnlLaggTillAnvandareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfAnvTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfAnvNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbAdminFraga)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblLaggTillAnvError))))
                .addContainerGap(950, Short.MAX_VALUE))
        );
        pnlLaggTillAnvandareLayout.setVerticalGroup(
            pnlLaggTillAnvandareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLaggTillAnvandareLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblLaggTillAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(pnlLaggTillAnvandareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdminFraga)
                    .addComponent(cbAdminFraga))
                .addGap(18, 18, 18)
                .addGroup(pnlLaggTillAnvandareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnvNamn)
                    .addComponent(tfAnvNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLaggTillAnvandareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnvTele)
                    .addComponent(tfAnvTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(pnlLaggTillAnvandareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnvEpost)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLaggTillAnvandareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnvLosenord))
                .addGap(36, 36, 36)
                .addComponent(btnLaggTillAnv)
                .addGap(18, 18, 18)
                .addComponent(lblLaggTillAnvError)
                .addContainerGap(538, Short.MAX_VALUE))
        );

        jLayeredPane2.add(pnlLaggTillAnvandare, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelMenuBackground.add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 1500, 1020));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnForumMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForumMouseEntered
        // TODO add your handling code here:
        if (!isSelForum) {
            selForum.setVisible(true);
        }
    }//GEN-LAST:event_btnForumMouseEntered

    private void btnForumMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForumMouseExited
        // TODO add your handling code here:
        if (!isSelForum) {
            selForum.setVisible(false);
        }
    }//GEN-LAST:event_btnForumMouseExited

    private void btnKalenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKalenderMouseEntered
        // TODO add your handling code here:
        if (!isSelKalender) {
            selKalender.setVisible(true);
        }
    }//GEN-LAST:event_btnKalenderMouseEntered

    private void btnKalenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKalenderMouseExited
        // TODO add your handling code here:
        if (!isSelKalender) {
            selKalender.setVisible(false);
        }
    }//GEN-LAST:event_btnKalenderMouseExited

    private void btnMeddelandenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMeddelandenMouseEntered
        // TODO add your handling code here:
        if (!isSelMeddelanden) {
            selMeddelanden.setVisible(true);           
        }
    }//GEN-LAST:event_btnMeddelandenMouseEntered

    private void btnMeddelandenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMeddelandenMouseExited
        // TODO add your handling code here:
        if (!isSelMeddelanden) {
            selMeddelanden.setVisible(false);
        }
    }//GEN-LAST:event_btnMeddelandenMouseExited

    private void btnSokfunktionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSokfunktionMouseEntered
        // TODO add your handling code here:
        if (!isSelSokfunktion) {
            selSokfunktion.setVisible(true);
        }
    }//GEN-LAST:event_btnSokfunktionMouseEntered

    private void btnSokfunktionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSokfunktionMouseExited
        // TODO add your handling code here:
        if (!isSelSokfunktion) {
            selSokfunktion.setVisible(false);
        }
    }//GEN-LAST:event_btnSokfunktionMouseExited

    private void btnProfilinstallningarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfilinstallningarMouseEntered
        // TODO add your handling code here:
        if (!isSelProfilinstallningar) {
            selProfilinstallningar.setVisible(true);
        }
    }//GEN-LAST:event_btnProfilinstallningarMouseEntered

    private void btnProfilinstallningarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfilinstallningarMouseExited
        // TODO add your handling code here:
        if (!isSelProfilinstallningar) {
            selProfilinstallningar.setVisible(false);
        }
    }//GEN-LAST:event_btnProfilinstallningarMouseExited

    private void btnLaggTillAnvandareMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaggTillAnvandareMouseEntered
        // TODO add your handling code here:
        if (!isSelAdminfunktionalitet) {
            selAdminfunktionalitet.setVisible(true);
        }
    }//GEN-LAST:event_btnLaggTillAnvandareMouseEntered

    private void btnLaggTillAnvandareMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaggTillAnvandareMouseExited
        // TODO add your handling code here:
        if (!isSelAdminfunktionalitet) {
            selAdminfunktionalitet.setVisible(false);
        }
    }//GEN-LAST:event_btnLaggTillAnvandareMouseExited

    private void btnStartsidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStartsidaMouseEntered
        // TODO add your handling code here:
        if (!isSelStartsida) {
            selStartsida.setVisible(true);
        }

    }//GEN-LAST:event_btnStartsidaMouseEntered

    private void btnStartsidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStartsidaMouseExited
        // TODO add your handling code here:
        if (!isSelStartsida) {
            selStartsida.setVisible(false);
        }
    }//GEN-LAST:event_btnStartsidaMouseExited

    private void btnStartsidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStartsidaMouseClicked
        // TODO add your handling code here:
        selectStartsida();
    }//GEN-LAST:event_btnStartsidaMouseClicked

    private void btnForumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForumMouseClicked
        // TODO add your handling code here:
        selectForum();
    }//GEN-LAST:event_btnForumMouseClicked

    private void btnKalenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKalenderMouseClicked
        // TODO add your handling code here:
        selectKalender();
    }//GEN-LAST:event_btnKalenderMouseClicked

    private void btnMeddelandenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMeddelandenMouseClicked
        // TODO add your handling code here:
        selectMeddelanden();
    }//GEN-LAST:event_btnMeddelandenMouseClicked

    private void btnSokfunktionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSokfunktionMouseClicked
        // TODO add your handling code here:
        selectSokfunktion();
    }//GEN-LAST:event_btnSokfunktionMouseClicked

    private void btnProfilinstallningarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfilinstallningarMouseClicked
        // TODO add your handling code here:
        selectProfilinstallningar();
    }//GEN-LAST:event_btnProfilinstallningarMouseClicked

    private void btnLaggTillAnvandareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaggTillAnvandareMouseClicked
        // TODO add your handling code here:
        selectAdminfunktionalitet();
    }//GEN-LAST:event_btnLaggTillAnvandareMouseClicked

    private void tfSokTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSokTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSokTextActionPerformed

    private void btnSokAnvandareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSokAnvandareMouseClicked
        // TODO add your handling code here:
        boolean foundUsers = searchUser.findUsers(tfSokText.getText(), tblSoktaAnvandare);
        if (foundUsers) {
            tblSoktaAnvandare.setVisible(true);
            lblIngetSokresultat.setVisible(false);
        } else {
            tblSoktaAnvandare.setVisible(false);
            lblIngetSokresultat.setVisible(true);
        }
    }//GEN-LAST:event_btnSokAnvandareMouseClicked

    private void btnSokAnvandareMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSokAnvandareMouseEntered
        // TODO add your handling code here:
        btnSokAnvandare.setBackground(new java.awt.Color(158, 174, 187));

        btnSokAnvandare.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 94, 125), 2, true));
        lblbtnSokAnvandare.setForeground(new java.awt.Color(0, 94, 125));
    }//GEN-LAST:event_btnSokAnvandareMouseEntered

    private void btnSokAnvandareMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSokAnvandareMouseExited
        // TODO add your handling code here:
        btnSokAnvandare.setBackground(new java.awt.Color(0, 94, 125));
        lblbtnSokAnvandare.setForeground(new java.awt.Color(158, 174, 187));
        btnSokAnvandare.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 94, 125), 2, true));
    }//GEN-LAST:event_btnSokAnvandareMouseExited

    private void tfSokTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSokTextMouseClicked
        // TODO add your handling code here:
        tfSokText.setText("");
    }//GEN-LAST:event_tfSokTextMouseClicked

    private void lblbtnSkapaBloggtradKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblbtnSkapaBloggtradKeyPressed

    }//GEN-LAST:event_lblbtnSkapaBloggtradKeyPressed

    private void btnSkapaBloggtradMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkapaBloggtradMouseClicked
        // TODO add your handling code here:
        new CreatePostGUI().setVisible(true);
    }//GEN-LAST:event_btnSkapaBloggtradMouseClicked

    private void btnSkapaBloggtradMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkapaBloggtradMouseEntered
        // TODO add your handling code here:
        btnSkapaBloggtrad.setBackground(new java.awt.Color(158, 174, 187));

        btnSkapaBloggtrad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 94, 125), 2, true));
        lblbtnSkapaBloggtrad.setForeground(new java.awt.Color(0, 94, 125));
    }//GEN-LAST:event_btnSkapaBloggtradMouseEntered

    private void btnSkapaBloggtradMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkapaBloggtradMouseExited
        // TODO add your handling code here:
        btnSkapaBloggtrad.setBackground(new java.awt.Color(0, 94, 125));
        lblbtnSkapaBloggtrad.setForeground(new java.awt.Color(158, 174, 187));
        btnSkapaBloggtrad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 94, 125), 2, true));
    }//GEN-LAST:event_btnSkapaBloggtradMouseExited

    private void cbFForskningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFForskningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFForskningActionPerformed

    private void cbFUtbildningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFUtbildningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFUtbildningActionPerformed

    private void cbFOvrigtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFOvrigtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFOvrigtActionPerformed

    private void tblForumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblForumMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblForumMouseClicked

    private void tfFSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFSokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFSokActionPerformed

    private void tfPIEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPIEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPIEmailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        changePassword cp = new changePassword();
        cp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblPIUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPIUserNameMouseClicked
        // TODO add your handling code here:

        lblPIFelmeddelandeNamn.setText("Du kan inte ändra på namnet var vänlig och kontakta universitetet!");
    }//GEN-LAST:event_lblPIUserNameMouseClicked

    private void pnlPIUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPIUserNameMouseClicked
        // TODO add your handling code here:
        lblPIFelmeddelandeNamn.setText("Du kan inte ändra på namnet var vänlig och kontakta universitetet!");
    }//GEN-LAST:event_pnlPIUserNameMouseClicked

    private void btnPIUppdateraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPIUppdateraActionPerformed
        // TODO add your handling code here:
        methods.ChangeUserInfo cUi = new methods.ChangeUserInfo();
        cUi.changeMailTel(tfPIEmail.getText(), tfPITlfn.getText());
        // cUi.controlRadio();

    }//GEN-LAST:event_btnPIUppdateraActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

        if (jRadioButton1.isSelected()) {

            jRadioButton2.setSelected(false);

        }

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed

        if (jRadioButton2.isSelected()) {

            jRadioButton1.setSelected(false);

        }

    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void btnLaggTillAnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillAnvActionPerformed
        ResultSet userInfo = null;
        boolean anvAdmin = cbAdminFraga.isSelected();
        String anvNamn = tfAnvNamn.getText();
        int anvTele = Integer.parseInt(tfAnvTelefon.getText());
        String anvEmail = tfEmail.getText();
        String anvLosenord = tfLosenord.getText();
        lblLaggTillAnvError.setText("");

        User user = new User(0, anvNamn, anvTele, anvLosenord, "J", anvEmail);
        Validation validate = new Validation();

        if (validate.verifyInformation(tfAnvNamn, tfAnvTelefon, tfEmail, tfLosenord)) {
            user.addNewUser(anvNamn, anvTele, anvEmail, anvLosenord, anvAdmin);
            
            tfAnvNamn.setText("");
            tfAnvTelefon.setText("");
            tfEmail.setText("");
            tfLosenord.setText("");
            
            
            try{
                
                System.out.println("1");
                Statement st = ConnectionClass.conn.createStatement();
                System.out.println("2");
                String getID = "SELECT Användare_ID FROM Användare WHERE Namn = '" + anvNamn + "' AND Telefon = " + anvTele +" AND Email = '" + anvEmail +"' AND Lösenord = '"+ anvLosenord +"'";
                System.out.println("33");
                userInfo = st.executeQuery(getID);
                System.out.println("34");
                userInfo.next();
                int id = userInfo.getInt("Användare_ID");
                System.out.println("ID är " + id);
                System.out.println("3");
                String insertNotifikation = "INSERT INTO Notifikation VALUES (" + id + ", 'J', " + id +")";
                System.out.println("4");
                st.executeUpdate(insertNotifikation);
                System.out.println("5");
            
            
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Något gick väldigt fel kontakta IT med felkod" + e);
            }
            JOptionPane.showMessageDialog(null, "Ny användare vid namn " + anvNamn + " tillagd!");
            
        }
    }//GEN-LAST:event_btnLaggTillAnvActionPerformed

    private void cbAdminFragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAdminFragaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAdminFragaActionPerformed

    private void tfLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLosenordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLosenordActionPerformed

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed

    private void btnTaBortAnvändareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortAnvändareActionPerformed
        {
            int row = tblSoktaAnvandare.getSelectedRow();
            String email = tblSoktaAnvandare.getValueAt(row, 2).toString();
            if(searchUser.removeUser(email)){
                JOptionPane.showMessageDialog(null, "Användare borttagen!");
            
            }
        }

    }//GEN-LAST:event_btnTaBortAnvändareActionPerformed

    private void lblbtnTaBortBloggtradKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblbtnTaBortBloggtradKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblbtnTaBortBloggtradKeyPressed

    private void btnTaBortBloggtradMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaBortBloggtradMouseClicked
        // TODO add your handling code here:
        int row = tblForum.getSelectedRow();
        String threadName = tblForum.getValueAt(row, 1).toString();
        EditForum.removeThread(threadName);
        currentFetchPosts.postList();
    }//GEN-LAST:event_btnTaBortBloggtradMouseClicked

    private void btnTaBortBloggtradMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaBortBloggtradMouseEntered
        // TODO add your handling code here:
        btnTaBortBloggtrad.setBackground(new java.awt.Color(158, 174, 187));
        lblbtnTaBortBloggtrad.setForeground(new java.awt.Color(0, 94, 125));
        btnTaBortBloggtrad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 94, 125), 2, true));
    }//GEN-LAST:event_btnTaBortBloggtradMouseEntered

    private void btnTaBortBloggtradMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaBortBloggtradMouseExited
        // TODO add your handling code here:
        btnTaBortBloggtrad.setBackground(new java.awt.Color(0, 94, 125));
        lblbtnTaBortBloggtrad.setForeground(new java.awt.Color(158, 174, 187));
        btnTaBortBloggtrad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 94, 125), 2, true));
    }//GEN-LAST:event_btnTaBortBloggtradMouseExited

    private void cbFForskningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFForskningMouseClicked
        // TODO add your handling code here:
        currentFetchPosts.postList();
        
    }//GEN-LAST:event_cbFForskningMouseClicked

    private void cbFUtbildningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFUtbildningMouseClicked
        // TODO add your handling code here:
        currentFetchPosts.postList();
    }//GEN-LAST:event_cbFUtbildningMouseClicked

    private void cbFOvrigtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFOvrigtMouseClicked
        // TODO add your handling code here:
        currentFetchPosts.postList();
    }//GEN-LAST:event_cbFOvrigtMouseClicked

    private void btnRefreshChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshChatActionPerformed
        // TODO add your handling code here:
        methods.FetchChat.reloadChat();
    }//GEN-LAST:event_btnRefreshChatActionPerformed

    private void btnSendChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendChatActionPerformed
        methods.FetchChat.sendChatMessage();
        
       methods.FetchChat.reloadChat();
       
       taCreateChatMessage.setText("");
    }//GEN-LAST:event_btnSendChatActionPerformed

    private void btnStartChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartChatActionPerformed
        // TODO add your handling code here:
        
        int row = tblSoktaAnvandare.getSelectedRow();
            String chatUserName = tblSoktaAnvandare.getValueAt(row, 0).toString();
        if(methods.FetchChat.checkIfChatExists(chatUserName)){
        
            JOptionPane.showMessageDialog(null, "Du har redan en chatt med användaren, gå in på meddelande för att chatta :)");
        }
        else {
            JOptionPane.showMessageDialog(null, "Chatt skapad med användaren, gå in på meddelande för att chatta :)");
        }
    }//GEN-LAST:event_btnStartChatActionPerformed

    
    
        public void setRadio() {
        
        if (CurrentUser.currentUser.getNotify().equals("J")) {
            
             jRadioButton1.setSelected(true);
           
        }
        
        else {
            
             jRadioButton2.setSelected(true);
        }
        
    }
    
    
    private boolean isSelStartsida;
    private boolean isSelSokfunktion;
    private boolean isSelProfilinstallningar;
    private boolean isSelMeddelanden;
    private boolean isSelKalender;
    private boolean isSelForum;
    private boolean isSelAdminfunktionalitet;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel btnForum;
    public static javax.swing.JPanel btnKalender;
    private javax.swing.JButton btnLaggTillAnv;
    public static javax.swing.JPanel btnLaggTillAnvandare;
    public static javax.swing.JPanel btnMeddelanden;
    private javax.swing.JButton btnPIUppdatera;
    public static javax.swing.JPanel btnProfilinstallningar;
    private javax.swing.JButton btnRefreshChat;
    private javax.swing.JButton btnSendChat;
    private javax.swing.JPanel btnSkapaBloggtrad;
    private javax.swing.JPanel btnSokAnvandare;
    public static javax.swing.JPanel btnSokfunktion;
    private javax.swing.JButton btnStartChat;
    public static javax.swing.JPanel btnStartsida;
    private javax.swing.JButton btnTaBortAnvändare;
    public static javax.swing.JPanel btnTaBortBloggtrad;
    private javax.swing.JCheckBox cbAdminFraga;
    public static javax.swing.JCheckBox cbFForskning;
    public static javax.swing.JCheckBox cbFOvrigt;
    public static javax.swing.JCheckBox cbFUtbildning;
    private javax.swing.JLabel iconLogga;
    private javax.swing.JLabel iconSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLayeredPane jLayeredPane2;
    public static javax.swing.JRadioButton jRadioButton1;
    public static javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAdminFraga;
    private javax.swing.JLabel lblAnvEpost;
    private javax.swing.JLabel lblAnvLosenord;
    private javax.swing.JLabel lblAnvNamn;
    private javax.swing.JLabel lblAnvTele;
    private javax.swing.JLabel lblBtnAdminfunktionalitet;
    private javax.swing.JLabel lblBtnForum;
    private javax.swing.JLabel lblBtnKalender;
    private javax.swing.JLabel lblBtnProfilinstallningar;
    private javax.swing.JLabel lblBtnSokfunktion;
    private javax.swing.JLabel lblBtnStartsida;
    private javax.swing.JLabel lblBtnStartsida4;
    private javax.swing.JLabel lblFAllmant;
    private javax.swing.JLabel lblFForskning;
    private javax.swing.JLabel lblFUtbildning;
    private javax.swing.JLabel lblFVisaKategorier;
    private javax.swing.JLabel lblForum;
    private javax.swing.JLabel lblIngetSokresultat;
    private javax.swing.JLabel lblKalender;
    private javax.swing.JLabel lblLaggTillAnvError;
    private javax.swing.JLabel lblLaggTillAnvandare;
    private javax.swing.JLabel lblMeddelanden;
    private javax.swing.JLabel lblOrebro;
    private javax.swing.JLabel lblPIEmail;
    private static javax.swing.JLabel lblPIFelmeddelandeNamn;
    public static javax.swing.JLabel lblPIFelmeddelandeUppdatera;
    private javax.swing.JLabel lblPINamn;
    private javax.swing.JLabel lblPIPW;
    private javax.swing.JLabel lblPIRubrik;
    private javax.swing.JLabel lblPITlfn;
    private javax.swing.JLabel lblPITlfn1;
    private javax.swing.JLabel lblPIUserName;
    private javax.swing.JLabel lblPersonligaInstallningarText;
    private javax.swing.JLabel lblSokfunktion;
    private javax.swing.JLabel lblUniversitet;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblbtnSkapaBloggtrad;
    private javax.swing.JLabel lblbtnSokAnvandare;
    private javax.swing.JLabel lblbtnTaBortBloggtrad;
    public static javax.swing.JPanel panelBoxChat;
    public static javax.swing.JPanel panelChat;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelMenuBackground;
    private javax.swing.JPanel panelMenuLogga;
    private javax.swing.JPanel pnlFSok;
    private javax.swing.JPanel pnlFVisaKategorier;
    private javax.swing.JPanel pnlForum;
    private javax.swing.JPanel pnlKalender;
    private javax.swing.JPanel pnlLaggTillAnvandare;
    private javax.swing.JPanel pnlMeddelanden;
    private javax.swing.JPanel pnlPIUserName;
    private javax.swing.JPanel pnlProfilinstallningar;
    private javax.swing.JPanel pnlSokfunktion;
    private javax.swing.JPanel pnlStartsida;
    private javax.swing.JScrollPane sPForum;
    private javax.swing.JPanel selAdminfunktionalitet;
    private javax.swing.JPanel selForum;
    private javax.swing.JPanel selKalender;
    private javax.swing.JPanel selMeddelanden;
    private javax.swing.JPanel selProfilinstallningar;
    private javax.swing.JPanel selSokfunktion;
    private javax.swing.JPanel selStartsida;
    private javax.swing.JSeparator sepFSok;
    private javax.swing.JScrollPane spSoktaAnvandare;
    public static javax.swing.JTextArea taCreateChatMessage;
    public static javax.swing.JTable tblChats;
    public static javax.swing.JTable tblForum;
    private javax.swing.JTable tblSoktaAnvandare;
    private javax.swing.JTextField tfAnvNamn;
    private javax.swing.JTextField tfAnvTelefon;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFSok;
    private javax.swing.JTextField tfLosenord;
    private javax.swing.JTextField tfPIEmail;
    private javax.swing.JTextField tfPITlfn;
    private javax.swing.JTextField tfSokText;
    // End of variables declaration//GEN-END:variables
}
