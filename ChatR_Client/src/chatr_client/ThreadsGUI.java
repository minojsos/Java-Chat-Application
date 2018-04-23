/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatr_client;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceException;

/**
 *
 * @author Minoj
 */
public class ThreadsGUI extends javax.swing.JFrame {

    private static final String MESSAGE_PLACEHOLDER = "Type your message here.";
    private static final String SEARCH_PLACEHOLDER = "Search Threads.";
    
    private static int selected_id = 0;             // Store the currently selected thread
    private List<Threads> threads;                  // Store the list of threads present in the Database
    private List<List<Messages>> messages;          // Store the list of messages corresponding to the threads
    private List<List<Users>> participants;         // Store the list of participants of each thread
    
    /**
     * Creates new form ThreadsGUI
     */
    public ThreadsGUI() {
        
        messages = new ArrayList();
        participants = new ArrayList();
        this.setResizable(false);
        
        initComponents();
        
        this.setLocationRelativeTo(this);
        
        btnSettings.setHorizontalTextPosition(javax.swing.JButton.CENTER);
        btnSettings.setVerticalTextPosition(javax.swing.JButton.BOTTOM);
        btnSettings.setText("Settings");
        
        btnLogout.setHorizontalTextPosition(javax.swing.JButton.CENTER);
        btnLogout.setVerticalTextPosition(javax.swing.JButton.BOTTOM);
        btnLogout.setText("Logout");
        
        btnCreateThread.setHorizontalTextPosition(javax.swing.JButton.CENTER);
        btnCreateThread.setVerticalTextPosition(javax.swing.JButton.BOTTOM);
        btnCreateThread.setText("New Thread");
        
        btnInfo.setHorizontalTextPosition(javax.swing.JButton.CENTER);
        btnInfo.setVerticalTextPosition(javax.swing.JButton.BOTTOM);
        btnInfo.setText("Info");
        
        btnSend.setEnabled(false);
        
        txtMessage.setLineWrap(true);
        txtMessage.setWrapStyleWord(true);
        txtMessage.setEnabled(false);
        
        lblNickname.setText(ChatR_Client.getUser().getNickname());
        
        try {
            threads = getThreads();
        } catch(WebServiceException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable to Connect to Server.", "Server Down", JOptionPane.ERROR_MESSAGE);
        }
        
        if(threads.size() > 0) {
            
            for(int i = 0; i < threads.size(); i++) {
                try {
                    messages.add(getMessages(threads.get(i)));
                    participants.add(getParticipants(threads.get(i)));
                } catch (WebServiceException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Unable to Connect to Server.", "Server Down", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            this.addThreads(threads);
            
            
        } else {
            
            panelThreads = new javax.swing.JPanel();
            
            lblEmptyLeft = new javax.swing.JLabel("No Threads found!");
            lblEmptyLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/information-128-red.png")));
            lblEmptyLeft.setHorizontalTextPosition(javax.swing.JLabel.CENTER);
            lblEmptyLeft.setVerticalTextPosition(javax.swing.JLabel.BOTTOM);
            
            panelThreads.setLayout(new java.awt.GridBagLayout());
            java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
            
            panelThreads.setBackground(Color.WHITE);
            panelThreads.setForeground(Color.GRAY);
            panelThreads.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));
            panelThreads.add(lblEmptyLeft, gbc);
            
            jScrollPane2.setViewportView(panelThreads);
            
            threadsList.setVisible(false);
            
        }
        
        panelMessages = new javax.swing.JPanel();
        
        lblEmptyMessages = new javax.swing.JLabel("Please Pick a Thread!");
        lblEmptyMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/information-128-green.png")));
        lblEmptyMessages.setHorizontalTextPosition(javax.swing.JLabel.CENTER);
        lblEmptyMessages.setVerticalTextPosition(javax.swing.JLabel.BOTTOM);
        
        panelMessages.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        
        panelMessages.setBackground(Color.WHITE);
        panelMessages.setForeground(Color.GRAY);
        panelMessages.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));
        panelMessages.add(lblEmptyMessages, gbc);
        
        jScrollPane3.setViewportView(panelMessages);
        jScrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        messagesList.setVisible(false);
        messagesList.setLayoutOrientation(JList.VERTICAL);
        messagesList.setVisibleRowCount(-1);
        
        usersList = new javax.swing.JList<Users>();
        
        usersList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));
        usersList.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        usersList.setToolTipText("Click to Message User");
        usersList.setSelectionBackground(new java.awt.Color(186, 220, 88));
        usersList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersListMouseClicked(evt);
            }
        });
        
        backgroundTask();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSettings = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        threadsList = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        lblNickname = new javax.swing.JLabel();
        btnCreateThread = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        messagesList = new javax.swing.JList<>();
        lblMsgLength = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblConversationTitle = new javax.swing.JLabel();
        btnInfo = new javax.swing.JButton();
        lblLastMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome :: ChatR - Send and Receive Messages");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(186, 220, 88));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/chat-logo-128-white.png"))); // NOI18N

        btnSettings.setBackground(new java.awt.Color(186, 220, 88));
        btnSettings.setForeground(new java.awt.Color(255, 255, 255));
        btnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/settings-48-white.png"))); // NOI18N
        btnSettings.setToolTipText("Click to Change Password.");
        btnSettings.setBorder(null);
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(186, 220, 88));
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/logout-48-white.png"))); // NOI18N
        btnLogout.setToolTipText("Click to Logout.");
        btnLogout.setBorder(null);
        btnLogout.setFocusPainted(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1020, 1020, 1020)
                .addComponent(btnSettings)
                .addGap(18, 18, 18)
                .addComponent(btnLogout)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSettings)
                        .addComponent(btnLogout)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBorder(null);

        threadsList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));
        threadsList.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        threadsList.setToolTipText("Click to Open Thread. Double click to rename");
        threadsList.setSelectionBackground(new java.awt.Color(186, 220, 88));
        threadsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                threadsListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(threadsList);

        jPanel6.setBackground(new java.awt.Color(236, 240, 241));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));

        lblNickname.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblNickname.setForeground(new java.awt.Color(149, 165, 166));

        btnCreateThread.setBackground(new java.awt.Color(236, 240, 241));
        btnCreateThread.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnCreateThread.setForeground(new java.awt.Color(149, 165, 166));
        btnCreateThread.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/add-32-green.png"))); // NOI18N
        btnCreateThread.setBorder(null);
        btnCreateThread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateThreadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNickname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateThread)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCreateThread, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNickname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtSearch.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtSearch.setText("Search Threads.");
        txtSearch.setToolTipText("Alphabets and Numbers Only. Max 15 Chars.");
        txtSearch.setMargin(new java.awt.Insets(2, 5, 2, 5));
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/search-32-green.png"))); // NOI18N
        btnSearch.setBorder(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/back-32-green.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setEnabled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearch)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMinimumSize(new java.awt.Dimension(998, 741));

        jScrollPane1.setBorder(null);

        txtMessage.setColumns(10);
        txtMessage.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtMessage.setRows(2);
        txtMessage.setText("Type your message here.");
        txtMessage.setToolTipText("Max 125 Characters");
        txtMessage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));
        txtMessage.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtMessage.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMessageFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMessageFocusLost(evt);
            }
        });
        txtMessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMessageKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtMessage);

        btnSend.setBackground(new java.awt.Color(186, 220, 88));
        btnSend.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSend.setForeground(new java.awt.Color(255, 255, 255));
        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/send-48-white.png"))); // NOI18N
        btnSend.setToolTipText("Click to Send Message.");
        btnSend.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 195, 199)));
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(null);

        messagesList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 195, 199)));
        messagesList.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        messagesList.setFocusable(false);
        messagesList.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(messagesList);

        lblMsgLength.setText("0/125 Characters");

        jPanel7.setBackground(new java.awt.Color(236, 240, 241));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));

        lblConversationTitle.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblConversationTitle.setForeground(new java.awt.Color(149, 165, 166));

        btnInfo.setBackground(new java.awt.Color(236, 240, 241));
        btnInfo.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnInfo.setForeground(new java.awt.Color(149, 165, 166));
        btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/info-32-green.png"))); // NOI18N
        btnInfo.setToolTipText("Click to View Participants.");
        btnInfo.setBorder(null);
        btnInfo.setEnabled(false);
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        lblLastMsg.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblConversationTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(71, 71, 71))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblLastMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(btnInfo)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInfo)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblConversationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLastMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblMsgLength)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMsgLength)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Function defining btnLogout ActionEvent - Button Clicked.
     * Log the user out of Application.
     * @param evt ActionEvent - Button Clicked
     */
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        ChatR_Client.deleteUser();
        LoginGUI gui = new LoginGUI();
        this.dispose();
        gui.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed
    
    /**
     * Function defining btnSettings ActionEvent - Button Clicked.
     * Open the Settings GUI to allow the user to change their password.
     * ThreadsGUI is disabled until SettingsGUI is closed.
     * @param evt ActionEvent - Button Clicked
     */
    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        SettingsGUI gui = new SettingsGUI();
        
        gui.setVisible(true);
        gui.setThreadsGUI(this);
        this.setEnabled(false);
    }//GEN-LAST:event_btnSettingsActionPerformed
    
    /**
     * Function defining threadsList MouseEvent - MouseClicked.
     * @param evt MouseEvent - MouseClicked
     * 
     * The selected thread's id is stored in the 'selected_id' variable.
     * User will be able to post a message in the thread.
     * 
     * If the User double clicks on the thread, the user will be able presented with a Input Dialog through
     * which the user will be able to change the thread title. The thread will then be updated.
     * And also the messages under the selected thread will be loaded into the messages list.
     * The messages are loaded from the messages List<Messages> variable.
     */
    private void threadsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_threadsListMouseClicked
        
        XMLGregorianCalendar date = null;
        
        Threads thread = threadsList.getSelectedValue();
        
        selected_id = threadsList.getSelectedValue().getId();
        
        btnSend.setEnabled(true);
        txtMessage.setEnabled(true);
        
        if(evt.getClickCount() == 2) {
            String title = JOptionPane.showInputDialog(null, "Input Thread Title:","Rename Thread",JOptionPane.INFORMATION_MESSAGE);
            
            // If user hasn't pressed cancel
            if(!(title == null)) {
                try {
                    // Ensure title follows the naming rules and length
                    while(!(title.trim().length() > 0) || title.length() > 15 || !title.matches("[a-zA-Z0-9 ]+")) {
                        if(title.length() > 15) {
                            title = JOptionPane.showInputDialog(null, "Thread Title Max Length: 15 Characters\nInput Thread Title:", "Invalid Thread Title", JOptionPane.ERROR_MESSAGE);
                        } else if(!(title.trim().length() > 0) || !title.matches("[a-zA-Z0-9]*")){
                            title = JOptionPane.showInputDialog(null, "Thread Title may only contain Letters and Numbers\nInput Thread Title:", "Invalid Thread Title", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (NullPointerException e) {
                    Logger.getLogger("Thread Creation Cancelled");
                }
            
                thread.setTitle(title);
                GregorianCalendar c = new GregorianCalendar();
                c.setTime(new Date());
                try {
                    date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
                    thread.setLastEdited(date);
                } catch (DatatypeConfigurationException ex) {
                    Logger.getLogger(ThreadsGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    threads.get(threadsList.getSelectedIndex()).setTitle(title);
                    updateThread(thread);
                } catch (WebServiceException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Unable to Connect to Server.", "Server Down", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        // Load the Messages under the thread
        for(int i = 0; i < threads.size(); i++) {
            
            if(threadsList.getSelectedValue().getId() == threads.get(i).getId()) {
                if(messages.get(i).size() > 0) {
                    addMessages(messages.get(i));
                } else {
                    lblEmptyMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/information-128-red.png")));
                    lblEmptyMessages.setText("No Messages found in Thread.");
                    jScrollPane3.setViewportView(panelMessages);
                }
                
                break;
            }
            
        }
        
        lblConversationTitle.setText(thread.getTitle());
            
        Date dDate = new Date(thread.getLastEdited().toGregorianCalendar().getTimeInMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
        lblLastMsg.setText(format.format(dDate));
        
        btnInfo.setEnabled(true);
        usersList.clearSelection();
        
    }//GEN-LAST:event_threadsListMouseClicked
    
    /**
     * Function defining usersList MouseEvent - MouseClicked.
     * @param evt MouseEvent - MouseClicked
     * 
     * The selected User is stored as the receiver while the selector is the author.
     * The messages exchanged between the users are loaded. If there are messages exchanged, they are listed in the
     * messages list and if not, a message stating that there are no messages that have been exchanged is displayed.
     */
    private void usersListMouseClicked(java.awt.event.MouseEvent evt) {
        
        XMLGregorianCalendar date = null;
        
        Users receiver = usersList.getSelectedValue();
        
        if(!Objects.equals(receiver.getId(), ChatR_Client.getUser().getId())) {
            
            selected_id = -1;
            btnSend.setEnabled(true);
            txtMessage.setEnabled(true);
        
            List<Messages> messages = null;
            
            try {
                // Messages loaded by making a call to the Web Service Method
                messages = getPersonalMessages(ChatR_Client.getUser(), receiver);
                
                // List the messages (if any) or display a informative message.
                if(messages.size() > 0) {
                
                    date = messages.get(messages.size() - 1).getPostedAt();
                    addMessages(messages);
                } else {
                    lblEmptyMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/information-128-red.png")));
                    lblEmptyMessages.setText("No messages found exchanged.");
                    jScrollPane3.setViewportView(panelMessages);
                }
        
                lblConversationTitle.setText(receiver.getNickname());
                
                if(messages.size() > 0) {
                    Date dDate = new Date(date.toGregorianCalendar().getTimeInMillis());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
                    lblLastMsg.setText(format.format(dDate));
                } else {
                    lblLastMsg.setText("");
                }
                btnInfo.setEnabled(false);
            
            } catch (WebServiceException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Unable to Connect to Server.", "Server Down", JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            usersList.clearSelection();
            JOptionPane.showMessageDialog(null, "You can't message yourself", "Messaging Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    /**
     * Function defining txtMessage textarea's FocusEvent - Focus Gained.
     * @param evt FocusEvent - Focus Gained
     * If the focus is on the textarea and if it contains the placeholder text, the placeholder string is replaced with an empty text.
     * Also the border is changed to green.
     */
    private void txtMessageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMessageFocusGained
        if(txtMessage.getText().equals(MESSAGE_PLACEHOLDER)) {
            txtMessage.setText("");
        }
        txtMessage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 220, 80), 1, true));
    }//GEN-LAST:event_txtMessageFocusGained
    
    /**
     * Function defining txtMessage textarea's FocusEvent - Focus Lost.
     * @param evt FocusEvent - Focus Lost
     * 
     * If the focus is removed from the textarea and if it doesn't contain any text, the placeholder string is added into the text area.
     * The border is reverted back to it's original colour.
     */
    private void txtMessageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMessageFocusLost
        if(txtMessage.getText().equals("")) {
            txtMessage.setText(MESSAGE_PLACEHOLDER);
        }
        txtMessage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));
    }//GEN-LAST:event_txtMessageFocusLost
    
    /**
     * Function defining btnSend's ActionEvent - Button Clicked.
     * @param evt ActionEvent - Button Clicked
     * 
     * It is ensured that the user is not sending an empty message and also that the message is within the specified length.
     * If the message is posted to a thread, it is sent with the Thread Object that it belongs to, 
     * If the message is for a another fellow participant of a thread, it is sent with the Author and Receiver.
     * Finally the messages list is updated as well as the GUI.
     */
    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        if(!txtMessage.getText().equals(MESSAGE_PLACEHOLDER) && txtMessage.getText().trim().length() > 0) {
            
            if(txtMessage.getText().length() <= 125) {
                
                // If a user has been selected from the usersList, if yes - the message is to be sent to the user.
                if(usersList.getSelectedIndex() == -1) {
            
                    // Create the Message with the text
                    Messages message = new Messages();
                    message.setTitle(txtMessage.getText());
                    message.setThread(threadsList.getSelectedValue());
                    message.setAuthor(ChatR_Client.getUser());
            
                    GregorianCalendar c = new GregorianCalendar();
                    c.setTime(new Date());
                    
                    try {
                        XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
                        message.setPostedAt(date);
                    } catch (DatatypeConfigurationException ex) {
                        Logger.getLogger(ThreadsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
                    // Send the Message to the Server
                    try {
                        createMessage(message);
                        
                        // Update the Messages List
                        addMessages(messages.get(threadsList.getSelectedIndex()));
                    } catch (WebServiceException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Unable to Connect to Server.", "Server Down", JOptionPane.ERROR_MESSAGE);
                    }
                    txtMessage.setText(MESSAGE_PLACEHOLDER);
                    
                } else {
                    // Message to another user
                    
                    // Create the Message with the text
                    Messages message = new Messages();
                    message.setTitle(txtMessage.getText());
                    message.setAuthor(ChatR_Client.getUser());
                    message.setReceiver(usersList.getSelectedValue());
                    message.setThread(null);
                    
                    GregorianCalendar c = new GregorianCalendar();
                    c.setTime(new Date());
                    
                    try {
                        XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
                        message.setPostedAt(date);
                    } catch (DatatypeConfigurationException ex) {
                        Logger.getLogger(ThreadsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    // Send the Message to the Server
                    try {
                        createMessage(message);
                        //Update the Messages List
                        addMessages(getPersonalMessages(ChatR_Client.getUser(), usersList.getSelectedValue()));
                    } catch (WebServiceException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Unable to Connect to Server.", "Server Down", JOptionPane.ERROR_MESSAGE);
                    }
                    txtMessage.setText(MESSAGE_PLACEHOLDER);
                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Message cannot be longer than 150 characters", "Invalid Message", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No message to send.", "Invalid Message", JOptionPane.ERROR_MESSAGE);
        }
        
        lblMsgLength.setText("0/125 Characters");
    }//GEN-LAST:event_btnSendActionPerformed
    
    /**
     * Function defining btnCreate's ActionEvent - Button Clicked.
     * @param evt ActionEvent - Button Clicked
     * 
     * The title of the thread is received by getting the input through an Input Dialog.
     * Checked if user hasn't clicked null and against the other rules and is then created.
     * The Thread object is then created and is checked if created. If not, the user is presented with an error.
     */
    private void btnCreateThreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateThreadActionPerformed
        String title = JOptionPane.showInputDialog("Input Thread Title: ");
        
        try {
            while(!(title.trim().length() > 0) || title.length() > 15 || !title.matches("[a-zA-Z0-9 ]+")) {
                if(title.length() > 15) {
                    title = JOptionPane.showInputDialog(null, "Thread Title Max Length: 15 Characters\nInput Thread Title:", "Invalid Thread Title", JOptionPane.ERROR_MESSAGE);
                } else if(!(title.trim().length() > 0) || !title.matches("[a-zA-Z0-9]*")){
                    title = JOptionPane.showInputDialog(null, "Thread Title may only contain Letters and Numbers\nInput Thread Title:", "Invalid Thread Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            Logger.getLogger("Thread Creation Cancelled");
        }
        
        if(title != null && title.trim().length() > 0) {
            
            // Create Thread object with input title and currently logged in user as the author.
            Threads thread = new Threads();
            thread.setTitle(title);
            thread.setAuthor(ChatR_Client.getUser());
            
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            try {
                XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
                thread.setLastEdited(date);
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(ThreadsGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Create the Thread by passing it to the thread.
            try {
                // Check if Thread Creation is successful.
                if(createThread(thread)) {
                    JOptionPane.showMessageDialog(null, "Successfully Created Thread.", "Success", JOptionPane.ERROR_MESSAGE);
                    // Update Threads
                    int chosen_index = threadsList.getSelectedIndex();
                    addThreads(getThreads());
                    threadsList.setSelectedIndex(chosen_index);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to Create Thread.\nTry again later!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch(WebServiceException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Unable to Connect to Server.", "Server Down", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btnCreateThreadActionPerformed
    
    /**
     * Function defining txtMessages's KeyEvent - Key Released.
     * @param evt KeyEvent - Key Released
     * 
     * When the user has completed pressing a key, the number of characters typed in is updated in the GUI.
     * lblMsgLength color is set to red if the number of characters is greater than 125.
     * lblMsgLength color is set to black if the number of characters is less than 125.
     */
    private void txtMessageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMessageKeyReleased
        // Ensure that the text area isn't containing the placeholder text.
        if(!txtMessage.getText().equals(MESSAGE_PLACEHOLDER)) {
            lblMsgLength.setText(txtMessage.getText().length()+"/125 Characters");
        }
        
        if(txtMessage.getText().length() > 125) {
            lblMsgLength.setForeground(Color.red);
        } else {
            lblMsgLength.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtMessageKeyReleased
    
    /**
     * Function defining txtSearch's FocusEvent - Focus Gained.
     * The Placeholder text of search textfield is removed and the textfield is made empty.
     * The border of the textfield is changed to green.
     * @param evt 
     */
    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if(txtSearch.getText().equals(SEARCH_PLACEHOLDER)) {
            txtSearch.setText("");
        }
        txtSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 220,80), 1, true));
    }//GEN-LAST:event_txtSearchFocusGained
    
    /**
     * Function defining txtSearch's FocusEvent - Focus Lost.
     * @param evt ActionEvent - Button Clicked
     * 
     * If the Search textfield is empty, the placeholder text is added into the textfield.
     * The border is then changed back to it's original color.
     */
    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if(txtSearch.getText().equals("")) {
            txtSearch.setText(SEARCH_PLACEHOLDER);
        }
        txtSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(txtSearch.getText().trim().length() > 0 && !txtSearch.getText().equals(SEARCH_PLACEHOLDER) && txtSearch.getText().matches("[a-zA-Z0-9 ]+")) {
            
            btnBack.setEnabled(true);
            
            addThreads(search(txtSearch.getText()));
            
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Search Term or Empty!", "Search Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtSearchKeyReleased
    
    /**
     * Function defining btnSearch's ActionEvent - Button Clicked.
     * btnBack is enabled so that the user can list to the original threads list.
     * The search term is validated - Ensure it's not empty and also is not the same as the placeholder text.
     * The search term is validated against the rules used for the Thread title.
     * The threads are then searched using the web service or using the local threads list and is then added the threadsList.
     * @param evt 
     */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // Ensure text field isn't empty, same as the placeholder text and only contains text and numbers and spaces (Only spaces not allowed).
        if(txtSearch.getText().trim().length() > 0 && !txtSearch.getText().equals(SEARCH_PLACEHOLDER) && txtSearch.getText().matches("[a-zA-Z0-9 ]+")) {
            
            btnBack.setEnabled(true);
            
            addThreads(search(txtSearch.getText()));
            
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Search Term or Empty!", "Search Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed
    
    /**
     * Function defining btnBack's ActionEvent - Button Clicked.
     * Back button is disabled.
     * Left panel will display the list of threads. If usersList is displayed, threadsList is set to replace the threadsList
     * in the Scroll Pane. Search TextField is set with the Placeholder text.
     * @param evt ActionEvent - Button Clicked
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        btnBack.setEnabled(false);
        // Threads added back to the jList
        addThreads(threads);
        txtSearch.setText(SEARCH_PLACEHOLDER);
        
        // Threads that was previously selected is selected in the threadsList.
        for(int i = 0; i < threadsList.getModel().getSize(); i++) {
            if(threadsList.getModel().getElementAt(i).getId() == selected_id) {
                threadsList.setSelectedIndex(i);
                break;
            }
        }
        
        jScrollPane2.setViewportView(threadsList);
        threadsList.setVisible(true);
        usersList.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed
    
    /**
     * Function defining btnInfo's ActionEvent - Button Clicked.
     * Back button is disabled.
     * List of participants of the currently open thread is loaded from the users list to the jScrollPane2 - on the left.
     * If there are no participants, a informative message is displayed to the user on the jScrollPane2 on the left.
     * @param evt ActionEvent - Button Clicked
     */
    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        
        btnBack.setEnabled(true);
        
        for(int i = 0; i < threads.size(); i++) {
            
            if(threads.get(i).getId() == threadsList.getSelectedValue().getId()) {
                
                if(participants.get(i).size() > 0) {
                    this.addUsers(participants.get(i));
                    usersList.setVisible(true);
                    jScrollPane2.setViewportView(usersList);
                } else {
                    panelUsers = new javax.swing.JPanel();
            
                    lblEmptyLeft = new javax.swing.JLabel("No Participants found!");
                    lblEmptyLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/information-128-red.png")));
                    lblEmptyLeft.setHorizontalTextPosition(javax.swing.JLabel.CENTER);
                    lblEmptyLeft.setVerticalTextPosition(javax.swing.JLabel.BOTTOM);
            
                    panelUsers.setLayout(new java.awt.GridBagLayout());
                    java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
            
                    panelUsers.setBackground(Color.WHITE);
                    panelUsers.setForeground(Color.GRAY);
                    panelUsers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 195, 199), 1, true));
                    panelUsers.add(lblEmptyLeft, gbc);
            
                    jScrollPane2.setViewportView(panelUsers);
            
                    usersList.setVisible(false);
                }
                
                break;
            }
        }
        
    }//GEN-LAST:event_btnInfoActionPerformed
    
    /**
     * Function to add threads to the threadsList jList.
     * The threads are added to the DefaultListModel and then added to the threadsList.
     * The ThreadListCellRenderer is used as the CellRenderer for threadsList jList.
     * @param threads List of threads that need to be added to the threadsList jList.
     */
    private void addThreads(List<Threads> threads) {
        
        DefaultListModel<Threads> dlm = new DefaultListModel();
            
        for(int i = 0; i < threads.size(); i++) {
            Threads thread = threads.get(i);
        
            dlm.addElement(thread);
        }
            
        threadsList.setModel(dlm);
        threadsList.setCellRenderer(new ThreadListCellRenderer());
    }
    
    /**
     * Function to add users to the usersList jList.
     * The users are added to the DefaultListModel and then added to the usersList.
     * The UserListCellRenderer is used as the CellRenderer for usersList jList.
     * @param users List of users that need to be added to the usersList jList.
     */
    private void addUsers(List<Users> users) {
        
        DefaultListModel<Users> dlm = new DefaultListModel();
        
        for(int i = 0; i < users.size(); i++) {
            Users user = users.get(i);
            // If the logged in user's id and the id of the user object is the same, Nickname is set to you.
            // User will not be able to message himself.
            if(user.getId() == ChatR_Client.getUser().getId()) {
                user.setNickname("You");
            }
            dlm.addElement(user);
        }
        
        usersList.setModel(dlm);
        usersList.setCellRenderer(new UserListCellRenderer());
    }
    
    /**
     * Function to add messages to the messagesList jList.
     * The messages are added to the DefaultListModel and then added to the messagesList.
     * The MessageListCellRenderer is used as the CellRenderer for messagesList jList.
     * @param messages List of messages that need to be added to the messagesList jList.
     */
    private void addMessages(List<Messages> messages) {
        
        DefaultListModel<Messages> dlm = new DefaultListModel();
        jScrollPane3.setViewportView(messagesList);
        messagesList.setVisible(true);
            
        for(int i = 0; i < messages.size(); i++) {
            Messages message = messages.get(i);
            dlm.addElement(message);
        }
            
        messagesList.setModel(dlm);
        messagesList.setCellRenderer(new MessageListCellRenderer());
        
        // Ensure the list scrolls vertically and not horizontally
        messagesList.setLayoutOrientation(JList.VERTICAL);
        messagesList.setVisibleRowCount(-1);
        
    }
    
    /**
     * Function to search Threads.
     * Search by calling the web service, but if the web service is down,
     * search the threads List<Threads> that contains all the threads locally.
     * @param title Search term.
     * @return the list of Threads that has a title containing the search term.
     */
    private List<Threads> search(String title) {
        
        List<Threads> result = new ArrayList<Threads>();
        
        try {
            result = findThreadByTitle(title.toLowerCase());
        } catch(WebServiceException e) {
            System.out.println(e.getMessage());
            for(int i = 0; i < threads.size(); i++) {
                if(threads.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
                    result.add(threads.get(i));
                }
            }
        }
        
        return result;
    }
    
    /**
     * Function that performs the background tasks.
     * Used to update GUI constantly if there are any changes.
     * The thread sleeps 1 second at the end of every loop.
     * Threads are loaded from the web service and GUI is updated.
     * Messages are loaded from the web service and GUI is updated.
     * Participants are loaded from the web service and GUI is updated.
     * If a personal message conversation is open, Personal Messages are loaded
     * and then the GUI is updated.
     */
    private void backgroundTask() {
        
        Thread update = new Thread() {
                
            public void run() {
                    
                while(true) {
                    
                    // If user has logged out, exit loop.
                    if(ChatR_Client.getUser() == null) {
                        break;
                    }
                    
                    try {
                        
                        // If the threads from web service is not the same as the Threads<List>, load the Threads and update the GUI
                        if(getThreads().size() != threads.size()) {
                            threads = getThreads();
                            int selected_index = threadsList.getSelectedIndex();
                            
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    addThreads(threads);
                                    threadsList.setSelectedIndex(selected_index);
                                }    
                            });
                            threadsList.setSelectedIndex(selected_index);
                        
                        }
                    } catch (WebServiceException e) {
                        System.out.println(e.getMessage());
                    }
                    
                    /* If there is atleast one thread, check if messages from the web service is same as that of the List<Messages>
                     * thread index size. If they are not the same, load the messages and replace index. If index doesn't exist, add
                     * it into the messages List<Messages>.
                     */
                    if(threads.size() > 0) {
                        
                        for(int i = 0; i < threads.size(); i++) {
                            try {
                                
                                try {
                                    if(getMessages(threads.get(i)).size() != messages.get(i).size()) {
                                        messages.set(i, getMessages(threads.get(i)));
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                    messages.add(getMessages(threads.get(i)));
                                }
                                
                            } catch (WebServiceException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        
                    }
                    
                    /* If there is atleast one thread, check if participants List<Participants> size() at index same as that of the thread
                     * is same as the list size of the participants for that thread retrieved from the web service. If not same, update the participants
                     * list and update the GUI. If new participant, add to the list and update the GUI.
                     */
                    if(threads.size() > 0) {
                        
                        for(int i = 0; i < threads.size(); i++) {
                            try {
                                
                                try {
                                    if(getParticipants(threads.get(i)).size() != participants.get(i).size()) {
                                        participants.set(i, getParticipants(threads.get(i)));
                                        
                                        if(threadsList.getSelectedIndex() != -1) {
                                            if(usersList.getSelectedIndex() != 1) {
                                                if(i == threadsList.getSelectedIndex()) {
                                                    int chosen_user = usersList.getSelectedIndex();
                                                    final int index = i;
                                                    SwingUtilities.invokeLater(new Runnable(){
                                                        @Override
                                                        public void run() {
                                                            addUsers(participants.get(index));
                                                            usersList.setSelectedIndex(chosen_user);
                                                        }
                                                    });
                                                }
                                            }
                                        }
                                    }
                                } catch(IndexOutOfBoundsException e) {
                                    participants.add(getParticipants(threads.get(i)));
                                    if(threadsList.getSelectedIndex() != -1) {
                                        if(usersList.getSelectedIndex() != 1) {
                                            if(i == threadsList.getSelectedIndex()) {
                                                int chosen_user = usersList.getSelectedIndex();
                                                final int index = i;
                                                SwingUtilities.invokeLater(new Runnable(){
                                                    @Override
                                                    public void run() {
                                                        addUsers(participants.get(index));
                                                        usersList.setSelectedIndex(chosen_user);
                                                    }
                                                });
                                            }
                                        }
                                    }
                                }
                            
                            } catch (WebServiceException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        
                    }
                    
                    /*
                     * If a thread has been selected, update the messages list for that thread
                     * and update the GUI. If no messages in that thread, display an informative 
                     * message to the user.
                     */
                    if(threadsList.getSelectedIndex() != -1) {
                        
                        for(int i = 0; i < threads.size(); i++) {
                            
                            if(threadsList.getSelectedValue().getId() == threads.get(i).getId()) {
                                    if(selected_id != -1) {
                                        try {
                                            messages.set(i, getMessages(threads.get(i)));
                                            final int index = i;
                                            SwingUtilities.invokeLater(new Runnable(){
                                                @Override
                                                public void run() {
                                                    
                                                    if(messages.get(index).size() > 0) {
                                                        addMessages(messages.get(index));
                                                    } else {
                                                        lblEmptyMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatr_client/information-128-red.png")));
                                                        lblEmptyMessages.setText("No Messages found in Thread.");
                                                        jScrollPane3.setViewportView(panelMessages);
                                                    }
                                                    
                                                }
                                            
                                            });
                                        } catch (WebServiceException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    }
                                
                                break;
                            }
                            
                        }
                    }
                    
                    // If a user is selected from the users list, load messages for that user and display it in the messagesList.
                    if(usersList.getSelectedIndex() != -1) {
                        Users user = usersList.getSelectedValue();
                        addMessages(getPersonalMessages(ChatR_Client.getUser(), user));
                    }
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ThreadsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
                
        };
        
        // Make the thread a Background Thread and Start it.
        update.setDaemon(true);
        update.start();
    }
    
    /**
     * Defines how the items in the threadsList jList should be rendered.
     */
    private class ThreadListCellRenderer extends DefaultListCellRenderer {
        
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            Threads label = (Threads) value;
            
            String title = label.getTitle();
            
            Date dDate = new Date(label.getLastEdited().toGregorianCalendar().getTimeInMillis());
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            String nickname = label.getAuthor().getNickname();
            
            String labelText = "<html><div style='margin: 5px;'><b>" + title + "</b><br/><div style='font-size: 10px; color: #7f8c8d;'>Last Modified: " + format.format(dDate) + "<br/>Created By: " + nickname + "</div></div></html>";
            setText(labelText);

            return this;
        }
        
    }
    
    /**
     * Defines how the items in the messagesList jList should be rendered.
     */
    private class MessageListCellRenderer extends DefaultListCellRenderer {
        
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            Messages label = (Messages) value;
            
            String message = label.getTitle();
            
            Date dDate = new Date(label.getPostedAt().toGregorianCalendar().getTimeInMillis());
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            String nickname = label.getAuthor().nickname;
            
            String labelText = "<html>[" + format.format(dDate) + "]<b>"+nickname+"</b>: " + message + "</html>";
            setText(labelText);
            
            return this;
        }
        
    }
    
    /**
     * Defines how the items in the usersList jList should be rendered.
     */
    private class UserListCellRenderer extends DefaultListCellRenderer {
        
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            Users label = (Users) value;
            
            String login_id = label.getLoginId();
            String nickname = label.getNickname();
            
            Date dDate = new Date(label.getRegisteredDate().toGregorianCalendar().getTimeInMillis());
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            String labelText = "<html><b>"+nickname+"</b><br /><div style='font-size: 10px; color: #7f8c8d;'>"+login_id+"<br />Member Since: "+format.format(dDate)+"</div></html>";
            setText(labelText);
            
            return this;
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    //javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThreadsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThreadsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThreadsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThreadsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form if User is Logged in*/
        if(ChatR_Client.getUser() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ThreadsGUI().setVisible(true);
                }
            });
                    
        } else {
            LoginGUI gui = new LoginGUI();
            gui.setVisible(true);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateThread;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSettings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblConversationTitle;
    private javax.swing.JLabel lblLastMsg;
    private javax.swing.JLabel lblMsgLength;
    private javax.swing.JLabel lblNickname;
    private javax.swing.JList<Messages> messagesList;
    private javax.swing.JList<Threads> threadsList;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
    
    // Custom Variable declarations
    private javax.swing.JPanel panelMessages;       // Panel to Display the Messages
    private javax.swing.JPanel panelThreads;        // Panel to Display the Threads
    private javax.swing.JPanel panelUsers;          // Panel to Display the Users
    private javax.swing.JLabel lblEmptyMessages;    // Label to provide an informative message about no messages found.
    private javax.swing.JLabel lblEmptyLeft;        // Label to provide an informative message about no threads or no pariticipants in a Thread.
    private javax.swing.JList<Users> usersList;     // List to display all the Participants of a Thread
    
    /**
     * Retrieve the Threads from the Web Service.
     * @return List<Threads> - Contains the threads received from the Web Service
     */
    private static java.util.List<chatr_client.Threads> getThreads() {
        chatr_client.ChatR_Service service = new chatr_client.ChatR_Service();
        chatr_client.ChatR port = service.getChatRPort();
        return port.getThreads();
    }
    
    /**
     * Retrieve the Messages for a Specific Thread from the Web Service.
     * @param threadId ID of the Thread whose messages need to be retrieved.
     * @return List<Messages> - Contains the messages received from the Web Service.
     */
    private static java.util.List<chatr_client.Messages> getMessages(chatr_client.Threads threadId) {
        chatr_client.ChatR_Service service = new chatr_client.ChatR_Service();
        chatr_client.ChatR port = service.getChatRPort();
        return port.getMessages(threadId);
    }
    
    /**
     * Create a New Thread.
     * @param thread Thread Object that contains the attributes for the thread that needs to be created.
     * @return true if thread created successfully, false if thread creation failed.
     */
    private static boolean createThread(chatr_client.Threads thread) {
        chatr_client.ChatR_Service service = new chatr_client.ChatR_Service();
        chatr_client.ChatR port = service.getChatRPort();
        return port.createThread(thread);
    }
    
    /**
     * Update an existing Thread.
     * @param thread Thread object that contains the attributes for the thread that needs to be updated.
     * @return true if thread updated successfully, false if thread update failed.
     */
    private static boolean updateThread(chatr_client.Threads thread) {
        chatr_client.ChatR_Service service = new chatr_client.ChatR_Service();
        chatr_client.ChatR port = service.getChatRPort();
        return port.updateThread(thread);
    }

    /**
     * Create a New Message.
     * @param message Message Object that contains the attributes for the message that needs to be created.
     * @return true if message created successfully, false if message creation failed.
     */
    private static boolean createMessage(chatr_client.Messages message) {
        chatr_client.ChatR_Service service = new chatr_client.ChatR_Service();
        chatr_client.ChatR port = service.getChatRPort();
        return port.createMessage(message);
    }

    /**
     * Find Threads by the Title of the Thread.
     * @param title Search Term used to Find Threads.
     * @return List<Threads> that contain Threads which is the obtained from the result of the Search.
     */
    private static java.util.List<chatr_client.Threads> findThreadByTitle(java.lang.String title) {
        chatr_client.ChatR_Service service = new chatr_client.ChatR_Service();
        chatr_client.ChatR port = service.getChatRPort();
        return port.findThreadByTitle(title);
    }
    
    /**
     * Retrieve the Participants of a Thread.
     * @param thread Thread Object that defines a specific thread. Participants of this thread needs to be retrieved.
     * @return List<Users> that contain the participants of the specified Thread.
     */
    private static java.util.List<chatr_client.Users> getParticipants(chatr_client.Threads thread) {
        chatr_client.ChatR_Service service = new chatr_client.ChatR_Service();
        chatr_client.ChatR port = service.getChatRPort();
        return port.getParticipants(thread);
    }
    
    /**
     * Retrieve the Personal Messages between participants of a Thread.
     * @param author Author of the Message
     * @param receiver Receiver of the Message
     * @return List<Messages> that contain the personal messages exchanged between the two specified participants.
     */
    private static java.util.List<chatr_client.Messages> getPersonalMessages(chatr_client.Users author, chatr_client.Users receiver) {
        chatr_client.ChatR_Service service = new chatr_client.ChatR_Service();
        chatr_client.ChatR port = service.getChatRPort();
        return port.getPersonalMessages(author, receiver);
    }
    
}
