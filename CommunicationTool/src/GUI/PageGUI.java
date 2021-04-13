/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Objects.CurrentUser;
import Methods.SearchUser;


/**
 *
 * @author Pierre
 */
public class PageGUI extends javax.swing.JFrame {
        private SearchUser searchUser;

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
        spSoktaAnvandare.setVisible(false);
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
        pnlAdminfunktionalitet.setVisible(false);
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
        selForum.setVisible(true);
        pnlForum.setVisible(true);
        isSelForum = true;
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
    }

    public void selectSokfunktion() {
        resetPanel();
        resetMenu();
        selSokfunktion.setVisible(true);
        pnlSokfunktion.setVisible(true);
        isSelSokfunktion = true;
        
        tblSoktaAnvandare.setVisible(false);
    }
    
    public String getSearchText(){
        String searchText = tfSokText.getText();
        return searchText;
    }

    public void selectProfilinstallningar() {
        resetPanel();
        resetMenu();
        selProfilinstallningar.setVisible(true);
        pnlProfilinstallningar.setVisible(true);
        isSelProfilinstallningar = true;
    }

    public void selectAdminfunktionalitet() {
        resetPanel();
        resetMenu();
        selAdminfunktionalitet.setVisible(true);
        pnlAdminfunktionalitet.setVisible(true);
        isSelAdminfunktionalitet= true;
    }

    public void welcomeText(String name) {

        lblWelcome.setText("Välkommen " + name + "!");
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
        btnAdminfunktionalitet = new javax.swing.JPanel();
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
        pnlForum = new javax.swing.JPanel();
        lblForum = new javax.swing.JLabel();
        pnlKalender = new javax.swing.JPanel();
        lblKalender = new javax.swing.JLabel();
        pnlMeddelanden = new javax.swing.JPanel();
        lblMeddelanden = new javax.swing.JLabel();
        pnlSokfunktion = new javax.swing.JPanel();
        lblSokfunktion = new javax.swing.JLabel();
        tfSokText = new javax.swing.JTextField();
        btnSokAnvandare = new javax.swing.JPanel();
        lblbtnSokAnvandare = new javax.swing.JLabel();
        spSoktaAnvandare = new javax.swing.JScrollPane();
        tblSoktaAnvandare = new javax.swing.JTable();
        lblIngetSokresultat = new javax.swing.JLabel();
        pnlProfilinstallningar = new javax.swing.JPanel();
        lblProfilinstallningar = new javax.swing.JLabel();
        pnlAdminfunktionalitet = new javax.swing.JPanel();
        lblAdminfunktionalitet = new javax.swing.JLabel();

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

        btnAdminfunktionalitet.setBackground(new java.awt.Color(77, 85, 92));
        btnAdminfunktionalitet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdminfunktionalitetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdminfunktionalitetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdminfunktionalitetMouseExited(evt);
            }
        });

        lblBtnAdminfunktionalitet.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lblBtnAdminfunktionalitet.setForeground(new java.awt.Color(158, 174, 187));
        lblBtnAdminfunktionalitet.setText("Adminfunktionalitet");

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

        javax.swing.GroupLayout btnAdminfunktionalitetLayout = new javax.swing.GroupLayout(btnAdminfunktionalitet);
        btnAdminfunktionalitet.setLayout(btnAdminfunktionalitetLayout);
        btnAdminfunktionalitetLayout.setHorizontalGroup(
            btnAdminfunktionalitetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAdminfunktionalitetLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblBtnAdminfunktionalitet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(selAdminfunktionalitet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnAdminfunktionalitetLayout.setVerticalGroup(
            btnAdminfunktionalitetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selAdminfunktionalitet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnAdminfunktionalitetLayout.createSequentialGroup()
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
                    .addComponent(btnAdminfunktionalitet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(btnAdminfunktionalitet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        pnlForum.setBackground(new java.awt.Color(158, 174, 187));

        lblForum.setBackground(new java.awt.Color(77, 85, 92));
        lblForum.setFont(new java.awt.Font("Poppins Medium", 1, 48)); // NOI18N
        lblForum.setForeground(new java.awt.Color(77, 85, 92));
        lblForum.setText("Forum");

        javax.swing.GroupLayout pnlForumLayout = new javax.swing.GroupLayout(pnlForum);
        pnlForum.setLayout(pnlForumLayout);
        pnlForumLayout.setHorizontalGroup(
            pnlForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlForumLayout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(lblForum)
                .addContainerGap(927, Short.MAX_VALUE))
        );
        pnlForumLayout.setVerticalGroup(
            pnlForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlForumLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblForum, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(898, Short.MAX_VALUE))
        );

        jLayeredPane2.add(pnlForum, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        lblMeddelanden.setBackground(new java.awt.Color(77, 85, 92));
        lblMeddelanden.setFont(new java.awt.Font("Poppins Medium", 1, 48)); // NOI18N
        lblMeddelanden.setForeground(new java.awt.Color(77, 85, 92));
        lblMeddelanden.setText("Meddelanden");

        javax.swing.GroupLayout pnlMeddelandenLayout = new javax.swing.GroupLayout(pnlMeddelanden);
        pnlMeddelanden.setLayout(pnlMeddelandenLayout);
        pnlMeddelandenLayout.setHorizontalGroup(
            pnlMeddelandenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMeddelandenLayout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(lblMeddelanden)
                .addContainerGap(927, Short.MAX_VALUE))
        );
        pnlMeddelandenLayout.setVerticalGroup(
            pnlMeddelandenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMeddelandenLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblMeddelanden, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(898, Short.MAX_VALUE))
        );

        jLayeredPane2.add(pnlMeddelanden, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlSokfunktion.setBackground(new java.awt.Color(158, 174, 187));

        lblSokfunktion.setBackground(new java.awt.Color(77, 85, 92));
        lblSokfunktion.setFont(new java.awt.Font("Poppins Medium", 1, 48)); // NOI18N
        lblSokfunktion.setForeground(new java.awt.Color(77, 85, 92));
        lblSokfunktion.setText("Sökfunktion");

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

        spSoktaAnvandare.setBackground(new java.awt.Color(158, 174, 187));
        spSoktaAnvandare.setForeground(new java.awt.Color(77, 85, 92));
        spSoktaAnvandare.setColumnHeader(null);
        spSoktaAnvandare.setColumnHeaderView(null);
        spSoktaAnvandare.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        spSoktaAnvandare.setOpaque(false);

        tblSoktaAnvandare.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
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
        spSoktaAnvandare.setViewportView(tblSoktaAnvandare);

        lblIngetSokresultat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblIngetSokresultat.setForeground(new java.awt.Color(77, 85, 92));
        lblIngetSokresultat.setText("Sökningen gav inget resultat.");

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
                            .addComponent(spSoktaAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlSokfunktionLayout.createSequentialGroup()
                                .addComponent(tfSokText, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSokAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblIngetSokresultat, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                        .addComponent(tfSokText, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                    .addComponent(lblIngetSokresultat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(spSoktaAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(496, Short.MAX_VALUE))
        );

        jLayeredPane2.add(pnlSokfunktion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlProfilinstallningar.setBackground(new java.awt.Color(158, 174, 187));

        lblProfilinstallningar.setBackground(new java.awt.Color(77, 85, 92));
        lblProfilinstallningar.setFont(new java.awt.Font("Poppins Medium", 1, 48)); // NOI18N
        lblProfilinstallningar.setForeground(new java.awt.Color(77, 85, 92));
        lblProfilinstallningar.setText("Profilinställningar");

        javax.swing.GroupLayout pnlProfilinstallningarLayout = new javax.swing.GroupLayout(pnlProfilinstallningar);
        pnlProfilinstallningar.setLayout(pnlProfilinstallningarLayout);
        pnlProfilinstallningarLayout.setHorizontalGroup(
            pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfilinstallningarLayout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(lblProfilinstallningar)
                .addContainerGap(927, Short.MAX_VALUE))
        );
        pnlProfilinstallningarLayout.setVerticalGroup(
            pnlProfilinstallningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfilinstallningarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblProfilinstallningar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(898, Short.MAX_VALUE))
        );

        jLayeredPane2.add(pnlProfilinstallningar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlAdminfunktionalitet.setBackground(new java.awt.Color(158, 174, 187));

        lblAdminfunktionalitet.setBackground(new java.awt.Color(77, 85, 92));
        lblAdminfunktionalitet.setFont(new java.awt.Font("Poppins Medium", 1, 48)); // NOI18N
        lblAdminfunktionalitet.setForeground(new java.awt.Color(77, 85, 92));
        lblAdminfunktionalitet.setText("Adminfunktionalitet");

        javax.swing.GroupLayout pnlAdminfunktionalitetLayout = new javax.swing.GroupLayout(pnlAdminfunktionalitet);
        pnlAdminfunktionalitet.setLayout(pnlAdminfunktionalitetLayout);
        pnlAdminfunktionalitetLayout.setHorizontalGroup(
            pnlAdminfunktionalitetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminfunktionalitetLayout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(lblAdminfunktionalitet)
                .addContainerGap(927, Short.MAX_VALUE))
        );
        pnlAdminfunktionalitetLayout.setVerticalGroup(
            pnlAdminfunktionalitetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminfunktionalitetLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblAdminfunktionalitet, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(898, Short.MAX_VALUE))
        );

        jLayeredPane2.add(pnlAdminfunktionalitet, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void btnAdminfunktionalitetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminfunktionalitetMouseEntered
        // TODO add your handling code here:
        if (!isSelAdminfunktionalitet) {
            selAdminfunktionalitet.setVisible(true);
        }
    }//GEN-LAST:event_btnAdminfunktionalitetMouseEntered

    private void btnAdminfunktionalitetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminfunktionalitetMouseExited
        // TODO add your handling code here:
        if (!isSelAdminfunktionalitet) {
            selAdminfunktionalitet.setVisible(false);
        }
    }//GEN-LAST:event_btnAdminfunktionalitetMouseExited

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

    private void btnAdminfunktionalitetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminfunktionalitetMouseClicked
        // TODO add your handling code here:
        selectAdminfunktionalitet();
    }//GEN-LAST:event_btnAdminfunktionalitetMouseClicked

    private void tfSokTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSokTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSokTextActionPerformed

    private void btnSokAnvandareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSokAnvandareMouseClicked
        // TODO add your handling code here:
        boolean foundUsers = searchUser.findUsers(tfSokText.getText(), tblSoktaAnvandare);
        if(foundUsers){
            spSoktaAnvandare.setVisible(true);
            tblSoktaAnvandare.setVisible(true);
            lblIngetSokresultat.setVisible(false);
        }else {
            spSoktaAnvandare.setVisible(false);
            tblSoktaAnvandare.setVisible(false);
            lblIngetSokresultat.setVisible(true);
        }
        
    }//GEN-LAST:event_btnSokAnvandareMouseClicked

    private void btnSokAnvandareMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSokAnvandareMouseEntered
        // TODO add your handling code here:
        btnSokAnvandare.setBackground(new java.awt.Color(158, 174, 187));

        btnSokAnvandare.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,94,125), 2, true));
        lblbtnSokAnvandare.setForeground(new java.awt.Color(0, 94, 125));
    }//GEN-LAST:event_btnSokAnvandareMouseEntered

    private void btnSokAnvandareMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSokAnvandareMouseExited
        // TODO add your handling code here:
        btnSokAnvandare.setBackground(new java.awt.Color(0, 94, 125));
        lblbtnSokAnvandare.setForeground(new java.awt.Color(158, 174, 187));
        btnSokAnvandare.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 94, 125), 2, true));
    }//GEN-LAST:event_btnSokAnvandareMouseExited

    private boolean isSelStartsida;
    private boolean isSelSokfunktion;
    private boolean isSelProfilinstallningar;
    private boolean isSelMeddelanden;
    private boolean isSelKalender;
    private boolean isSelForum;
    private boolean isSelAdminfunktionalitet;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel btnAdminfunktionalitet;
    public static javax.swing.JPanel btnForum;
    public static javax.swing.JPanel btnKalender;
    public static javax.swing.JPanel btnMeddelanden;
    public static javax.swing.JPanel btnProfilinstallningar;
    private javax.swing.JPanel btnSokAnvandare;
    public static javax.swing.JPanel btnSokfunktion;
    public static javax.swing.JPanel btnStartsida;
    private javax.swing.JLabel iconLogga;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLabel lblAdminfunktionalitet;
    private javax.swing.JLabel lblBtnAdminfunktionalitet;
    private javax.swing.JLabel lblBtnForum;
    private javax.swing.JLabel lblBtnKalender;
    private javax.swing.JLabel lblBtnProfilinstallningar;
    private javax.swing.JLabel lblBtnSokfunktion;
    private javax.swing.JLabel lblBtnStartsida;
    private javax.swing.JLabel lblBtnStartsida4;
    private javax.swing.JLabel lblForum;
    private javax.swing.JLabel lblIngetSokresultat;
    private javax.swing.JLabel lblKalender;
    private javax.swing.JLabel lblMeddelanden;
    private javax.swing.JLabel lblOrebro;
    private javax.swing.JLabel lblProfilinstallningar;
    private javax.swing.JLabel lblSokfunktion;
    private javax.swing.JLabel lblUniversitet;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblbtnSokAnvandare;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelMenuBackground;
    private javax.swing.JPanel panelMenuLogga;
    private javax.swing.JPanel pnlAdminfunktionalitet;
    private javax.swing.JPanel pnlForum;
    private javax.swing.JPanel pnlKalender;
    private javax.swing.JPanel pnlMeddelanden;
    private javax.swing.JPanel pnlProfilinstallningar;
    private javax.swing.JPanel pnlSokfunktion;
    private javax.swing.JPanel pnlStartsida;
    private javax.swing.JPanel selAdminfunktionalitet;
    private javax.swing.JPanel selForum;
    private javax.swing.JPanel selKalender;
    private javax.swing.JPanel selMeddelanden;
    private javax.swing.JPanel selProfilinstallningar;
    private javax.swing.JPanel selSokfunktion;
    private javax.swing.JPanel selStartsida;
    private javax.swing.JScrollPane spSoktaAnvandare;
    private javax.swing.JTable tblSoktaAnvandare;
    private javax.swing.JTextField tfSokText;
    // End of variables declaration//GEN-END:variables
}
