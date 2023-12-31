/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package moirottoiec.GUI;

import java.sql.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import moirottoiec.BLL.OfflineCourseBLL;
import moirottoiec.DTO.OfflineCourse;

/**
 *
 * @author minhv
 */
public class Course_Offline extends javax.swing.JPanel {
    OfflineCourse offlineCourse;
    OfflineCourseBLL offlineCourseBLL;
    DefaultTableModel dtm;
    String tuKhoa = "";
    /**
     * Creates new form Course_Offline
     */
    public Course_Offline() {
        initComponents();
        offlineCourse = new OfflineCourse();
        offlineCourseBLL = new OfflineCourseBLL();
        loadOfflineCourseList();
    }
    
    public void loadOfflineCourseList(){
        dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dtm.addColumn("CourseID");
        dtm.addColumn("Location");
        dtm.addColumn("Days");
        dtm.addColumn("Time");
        offlineCourseTable.setModel(dtm);
        OfflineCourseBLL off = new OfflineCourseBLL();
        Vector<OfflineCourse> arr = new Vector<OfflineCourse>();
        arr = off.getAllOfflineCourse();
        System.out.println(arr);
        for(int i = 0; i < arr.size(); i++){
            OfflineCourse em = arr.get(i);
            int CourseID = em.getCourseID();
            String Location = em.getLocation();
            String Days = em.getDays();
            Date Time = em.getTime();
            Object[] row = {CourseID,Location , Days , Time};
            dtm.addRow(row);
        } 
        addButton.setEnabled(true);
    }
    
    public void search(){
        dtm.setRowCount(0);
        OfflineCourseBLL offlineCourseBLL = new OfflineCourseBLL();
        Vector<OfflineCourse> arr = new Vector<OfflineCourse>();
        arr = offlineCourseBLL.findOfflineCourse(tuKhoa);
        for(int i = 0; i < arr.size(); i++){
            OfflineCourse em = arr.get(i);
            int CourseID = em.getCourseID();
            String Location = em.getLocation();
            String Days = em.getDays();
            Date Time = em.getTime();
            Object[] row = {CourseID, Location, Days , Time};
            dtm.addRow(row);
        }
    
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
        jLabel1 = new javax.swing.JLabel();
        findTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        offlineCourseTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CoureIDTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DaysTextField = new javax.swing.JTextField();
        LocationTextField = new javax.swing.JTextField();
        TimeTextField = new javax.swing.JTextField();

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moirottoiec/GUI/img/teacher.png"))); // NOI18N
        jLabel1.setText("COURSE OFFLINE MANAGEMENT");

        findTextField.setText("Searching...");
        findTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                findTextFieldMouseClicked(evt);
            }
        });
        findTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findTextFieldActionPerformed(evt);
            }
        });
        findTextField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                findTextFieldPropertyChange(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 0, 0));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moirottoiec/GUI/img/plus.png"))); // NOI18N
        addButton.setText("Add new");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonaddLecActionPerformed(evt);
            }
        });

        offlineCourseTable.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        offlineCourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CourseID", "Location", "Days", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        offlineCourseTable.setRowHeight(18);
        offlineCourseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                offlineCourseTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(offlineCourseTable);

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 0, 0));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moirottoiec/GUI/img/delete.png"))); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonaddLecActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 0, 0));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moirottoiec/GUI/img/refresh.png"))); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonaddLecActionPerformed(evt);
            }
        });

        refreshButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        refreshButton.setForeground(new java.awt.Color(255, 0, 0));
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moirottoiec/GUI/img/refresh.png"))); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("CourseID");

        CoureIDTextField.setEditable(false);
        CoureIDTextField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Location");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Days");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Time");

        DaysTextField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        LocationTextField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        TimeTextField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(88, 88, 88)
                        .addComponent(updateButton)
                        .addGap(86, 86, 86)
                        .addComponent(deleteButton)
                        .addGap(97, 97, 97)
                        .addComponent(refreshButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(findTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(109, 109, 109)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1035, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addGap(78, 78, 78)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(DaysTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                .addComponent(CoureIDTextField))
                            .addGap(85, 85, 85)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5))
                            .addGap(45, 45, 45)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(findTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(searchButton)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(CoureIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(TimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(DaysTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addButton)
                            .addComponent(updateButton)
                            .addComponent(deleteButton))))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1065, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void findTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findTextFieldMouseClicked
        // TODO add your handling code here:
        findTextField.setText("");
    }//GEN-LAST:event_findTextFieldMouseClicked

    private void findTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_findTextFieldActionPerformed

    private void findTextFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_findTextFieldPropertyChange
            tuKhoa = findTextField.getText();
            search();
    }//GEN-LAST:event_findTextFieldPropertyChange

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        tuKhoa = findTextField.getText();
        search();

    }//GEN-LAST:event_searchButtonActionPerformed

    private void addButtonaddLecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonaddLecActionPerformed
        // TODO add your handling code here:
        String location = LocationTextField.getText();
        String days = DaysTextField.getText();
        String time = TimeTextField.getText();

        if(location.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập location!");
        }
        else if(days.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập days!");
        }
        else if(time.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày time!");
        }else{
            offlineCourse.setLocation(location);
            offlineCourse.setDays(days);
            offlineCourse.setTime(Date.valueOf(TimeTextField.getText()));
            offlineCourseBLL.addOfflineCourse(offlineCourse);
            JOptionPane.showMessageDialog(this, "Thêm khoá học offline thành công!");
            loadOfflineCourseList();
            LocationTextField.setText("");
            DaysTextField.setText("");
            TimeTextField.setText("");
        }
    }//GEN-LAST:event_addButtonaddLecActionPerformed

    private void offlineCourseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offlineCourseTableMouseClicked
        // TODO add your handling code here:
        offlineCourseBLL = new OfflineCourseBLL();
        int row = offlineCourseTable.getSelectedRow();
        offlineCourse = offlineCourseBLL.getOfflineCourseByID((int) offlineCourseTable.getValueAt(row, 0));

        CoureIDTextField.setText(String.valueOf(offlineCourse.getCourseID()));
        LocationTextField.setText(offlineCourse.getLocation());
        DaysTextField.setText(offlineCourse.getDays());
        TimeTextField.setText(String.valueOf(offlineCourse.getTime()));
        addButton.setEnabled(false);
    }//GEN-LAST:event_offlineCourseTableMouseClicked

    private void deleteButtonaddLecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonaddLecActionPerformed
        // TODO add your handling code here:
        OfflineCourseBLL offlineCourseBLL = new OfflineCourseBLL();
        int row = offlineCourseTable.getSelectedRow();
        if (row == -1){
            JOptionPane.showMessageDialog(Course_Offline.this, "Vui long chon khoa hoc can xoa!", "Loi", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int confirm = JOptionPane.showConfirmDialog(Course_Offline.this, "Ban chac chan muon xoa chu?");
            if(confirm == JOptionPane.YES_OPTION){
                int courseID = (int) offlineCourseTable.getValueAt(row, 0);
                offlineCourseBLL.deleteOfflineCourse(courseID);
                loadOfflineCourseList();
                CoureIDTextField.setText("");
                LocationTextField.setText("");
                DaysTextField.setText("");
                TimeTextField.setText("");
            }
        }
    }//GEN-LAST:event_deleteButtonaddLecActionPerformed

    private void updateButtonaddLecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonaddLecActionPerformed
        // TODO add your handling code here:
        OfflineCourseBLL offlineCourseBLL = new OfflineCourseBLL();
        OfflineCourse offlineCourse = new OfflineCourse();
        int row = offlineCourseTable.getSelectedRow();
        if (row == -1){
            JOptionPane.showMessageDialog(Course_Offline.this, "Vui lòng chọn khoá học cần sửa!",  "Loi", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int CoureID = (int) offlineCourseTable.getValueAt(row, 0);

            offlineCourse.setCourseID(CoureID);
            offlineCourse.setLocation(LocationTextField.getText());
            offlineCourse.setDays(DaysTextField.getText());
            offlineCourse.setTime(Date.valueOf(TimeTextField.getText()));
            offlineCourseBLL.updateOfflineCourse(offlineCourse);
            CoureIDTextField.setText("");
            LocationTextField.setText("");
            DaysTextField.setText("");
            TimeTextField.setText("");
            loadOfflineCourseList();
        }

    }//GEN-LAST:event_updateButtonaddLecActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        this.loadOfflineCourseList();
        CoureIDTextField.setText("");
        LocationTextField.setText("");
        DaysTextField.setText("");
        TimeTextField.setText("");
        findTextField.setText("Searching...");
    }//GEN-LAST:event_refreshButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CoureIDTextField;
    private javax.swing.JTextField DaysTextField;
    private javax.swing.JTextField LocationTextField;
    private javax.swing.JTextField TimeTextField;
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField findTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable offlineCourseTable;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

}
