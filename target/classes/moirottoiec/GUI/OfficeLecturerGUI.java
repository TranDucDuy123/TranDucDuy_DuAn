/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package moirottoiec.GUI;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import moirottoiec.BLL.OfficeLecturerBLL;
import moirottoiec.DTO.Course;
import moirottoiec.DTO.Lecturer;
import moirottoiec.DTO.OfficeLecturer;


/**
 *
 * @author Duy
 */
public class OfficeLecturerGUI extends javax.swing.JPanel {
    OfficeLecturerBLL officeBll;
    List<Lecturer> listLecturer;
     List<Course> listCourse;
    /**
     * Creates new form OfficeAssignmentGUI
     */
    public OfficeLecturerGUI() {
         initComponents();
         setComboboxLecturer();
         setComboboxCourse();
         showOnsiteTable();
         showOnlineTable();
      }
    
 
    public void setComboboxLecturer(){
        officeBll = new OfficeLecturerBLL();
        listLecturer = officeBll.getAllLecturerEmpty(); 
        ComboLboxecturer.removeAllItems();
        
        if(officeBll.getAllLecturerEmpty().size()==0){
            ComboLboxecturer.addItem("Empty");
            ComboLboxecturer.setForeground(Color.red);
        }else{
            for(Lecturer str : listLecturer){
                ComboLboxecturer.addItem(str.getFullName());
                ComboLboxecturer.setForeground(Color.black);
            }
        }
        
        
    }
    
//    Combobox Course
    public void setComboboxCourse(){
        officeBll = new OfficeLecturerBLL();
        listCourse = officeBll.getAllCourseEmpty();
        ComboboxCourse.removeAllItems();
        if(officeBll.getAllCourseEmpty().size()==0){
            ComboboxCourse.addItem("Empty");
            ComboboxCourse.setForeground(Color.red);
        }else{
            for(Course c : listCourse){
                ComboboxCourse.addItem(c.getTitle());
                 ComboboxCourse.setForeground(Color.black);
            }
        }
    }
   
    
    
///////Table top
public void showOnsiteTable(){
        officeBll = new OfficeLecturerBLL();
        DefaultTableModel model = new DefaultTableModel(){
            @Override
           public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        onsiteTable.setModel(model);
        model.addColumn("PersonID");
        model.addColumn("LastName");
        model.addColumn("FirstName");
        model.addColumn("Cousre");
        model.addColumn("Location");
        model.addColumn("Days");
        model.addColumn("Time");
        List<OfficeLecturer> stgs = officeBll.getAllOnsiteCourse();
        for (OfficeLecturer stg : stgs) {
            model.addRow(new Object[]{stg.getPersonID(),stg.getLastName(),stg.getFirstName(),
                                      stg.getCourse(),stg.getLocation(),stg.getDays(),stg.getTime()});
        }
    }
    
    
    
    
/////////Table bot
    public void showOnlineTable(){
        officeBll = new OfficeLecturerBLL();
        DefaultTableModel model = new DefaultTableModel(){
            @Override
           public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        onlineTable.setModel(model);
        model.addColumn("PersonID");
        model.addColumn("LastName");
        model.addColumn("FirstName");
        model.addColumn("Cousre");
        model.addColumn("URL");
        List<OfficeLecturer> stgs = officeBll.getAllOnlineCourse();
        for (OfficeLecturer stg : stgs) {
            model.addRow(new Object[]{stg.getPersonID(),stg.getLastName(),stg.getFirstName(),
                                      stg.getCourse(),stg.getUrl()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPaneview = new javax.swing.JPanel();
        jPanelList = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ComboLboxecturer = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ComboboxCourse = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        instructorID = new javax.swing.JLabel();
        courseID = new javax.swing.JLabel();
        jPanelbutton = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        ButtonAssingment = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        ButtonCancel = new javax.swing.JButton();
        jPanelOnsite = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        onsiteTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanelOnline = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        onlineTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OFFICE COURSEINSTRUCTOR");
        jLabel1.setPreferredSize(new java.awt.Dimension(37, 30));
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPaneview.setLayout(new java.awt.GridLayout(3, 0));

        jPanelList.setLayout(new java.awt.GridLayout(1, 4));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 100));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Empty CourseInstructor");
        jPanel1.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        ComboLboxecturer.setMaximumRowCount(6);
        jPanel1.add(ComboLboxecturer, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanelList.add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 100));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Empty Course");
        jPanel2.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        ComboboxCourse.setMaximumRowCount(6);
        ComboboxCourse.setToolTipText("");
        jPanel2.add(ComboboxCourse, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        jPanelList.add(jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        instructorID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        instructorID.setPreferredSize(new java.awt.Dimension(59, 59));
        jPanel3.add(instructorID, java.awt.BorderLayout.NORTH);

        courseID.setPreferredSize(new java.awt.Dimension(59, 59));
        jPanel3.add(courseID, java.awt.BorderLayout.SOUTH);

        jPanelList.add(jPanel3);

        jPanelbutton.setLayout(new java.awt.BorderLayout());

        jPanel9.setPreferredSize(new java.awt.Dimension(193, 50));
        jPanel9.setLayout(new java.awt.BorderLayout());

        ButtonAssingment.setBackground(new java.awt.Color(67, 110, 238));
        ButtonAssingment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonAssingment.setForeground(new java.awt.Color(255, 255, 255));
        ButtonAssingment.setLabel("OfficeAssignment");
        ButtonAssingment.setPreferredSize(new java.awt.Dimension(150, 50));
        ButtonAssingment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAssingmentActionPerformed(evt);
            }
        });
        jPanel9.add(ButtonAssingment, java.awt.BorderLayout.CENTER);

        jPanelbutton.add(jPanel9, java.awt.BorderLayout.NORTH);

        jPanel5.setPreferredSize(new java.awt.Dimension(102, 67));
        jPanel5.setLayout(new java.awt.BorderLayout());

        ButtonCancel.setBackground(new java.awt.Color(67, 110, 238));
        ButtonCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonCancel.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCancel.setText("Cancel");
        ButtonCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonCancel.setPreferredSize(new java.awt.Dimension(100, 50));
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });
        jPanel5.add(ButtonCancel, java.awt.BorderLayout.NORTH);

        jPanelbutton.add(jPanel5, java.awt.BorderLayout.SOUTH);

        jPanelList.add(jPanelbutton);

        jPaneview.add(jPanelList);

        jPanelOnsite.setLayout(new java.awt.BorderLayout());

        onsiteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "PersonID", "LastName", "FirstName", "Course", "Location", "Days", "Timestamp"
            }
        ));
        jScrollPane2.setViewportView(onsiteTable);

        jPanelOnsite.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 100));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Assignment OnsiteCourse");
        jPanelOnsite.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPaneview.add(jPanelOnsite);

        jPanelOnline.setPreferredSize(new java.awt.Dimension(811, 200));
        jPanelOnline.setLayout(new java.awt.BorderLayout());

        onlineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PersonID", "LastName", "FirstName", "Course", "URL"
            }
        ));
        jScrollPane1.setViewportView(onlineTable);

        jPanelOnline.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 100));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Assignment OnlineCourse");
        jPanelOnline.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        jPaneview.add(jPanelOnline);

        add(jPaneview, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelActionPerformed
          int removeOnsite = onsiteTable.getSelectedRow();
          int removeOnline = onlineTable.getSelectedRow();
          if(removeOnsite == -1 && removeOnline == -1){
              JOptionPane.showMessageDialog(jPaneview, "You need to select the Assignment to delete !");
          }else if(removeOnline == -1){
              int comfirm = JOptionPane.showConfirmDialog(jPaneview,"Are you sure you want to delete (onsiteCourse)?");
              if(comfirm==JOptionPane.YES_OPTION){
                  int personID = Integer.valueOf(String.valueOf(onsiteTable.getValueAt(removeOnsite, 0))) ;
                  officeBll.deleteOfficeLecturer(personID);
              }
          }else if(removeOnsite == -1){
              int comfirm = JOptionPane.showConfirmDialog(jPaneview,"Are you sure you want to delete (onloineCouser)?");
              if(comfirm==JOptionPane.YES_OPTION){
                  int personID = Integer.valueOf(String.valueOf(onlineTable.getValueAt(removeOnline, 0))) ;
                  officeBll.deleteOfficeLecturer(personID);
              }
          }else{
              int comfirm = JOptionPane.showConfirmDialog(jPaneview,"Are you sure you want to delete (onsite + online)?");
              if(comfirm==JOptionPane.YES_OPTION){
                int personID1 = Integer.valueOf(String.valueOf(onsiteTable.getValueAt(removeOnsite, 0))) ;
                    officeBll.deleteOfficeLecturer(personID1);
                int personID2 = Integer.valueOf(String.valueOf(onlineTable.getValueAt(removeOnline, 0))) ;
                    officeBll.deleteOfficeLecturer(personID2);
              }
          }
        setComboboxLecturer();
        setComboboxCourse();
        onsiteTable.removeAll();
        onlineTable.removeAll();
        
        showOnsiteTable();
        showOnlineTable();
    }//GEN-LAST:event_ButtonCancelActionPerformed

    private void ButtonAssingmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAssingmentActionPerformed
        
    // lay ra ID de them officeLecturer
        String strLecturer = (String) ComboLboxecturer.getSelectedItem();
        String strCourse = (String) ComboboxCourse.getSelectedItem();
        String[] strsLecturer = strLecturer.split(" ");
        String[] strsCourse = strCourse.split(" ");
        // Lecturer vs Course selecet
        OfficeLecturer office = new OfficeLecturer();
        if(strsLecturer[0]=="Empty" && strsCourse[0]=="Empty"){
            JOptionPane.showMessageDialog(jPaneview,"Unable to assign !");
        }else if(strsLecturer[0]=="Empty"){
           JOptionPane.showMessageDialog(jPaneview,"Unable to assign because there is no instructor !");
        }else if( strsCourse[0]=="Empty"){
           JOptionPane.showMessageDialog(jPaneview, "Unable to assign because there are no courses available !"); 
        }else{ 
         office.setPersonID(Integer.parseInt(strsLecturer[0]));
         office.setCourseID(Integer.parseInt(strsCourse[0]));
        }
        officeBll.addOfficeLecturer(office);
       
       
        setComboboxCourse();
        setComboboxLecturer();
        showOnlineTable();
        showOnsiteTable();
      
    }//GEN-LAST:event_ButtonAssingmentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAssingment;
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JComboBox<String> ComboLboxecturer;
    private javax.swing.JComboBox<String> ComboboxCourse;
    private javax.swing.JLabel courseID;
    private javax.swing.JLabel instructorID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelList;
    private javax.swing.JPanel jPanelOnline;
    private javax.swing.JPanel jPanelOnsite;
    private javax.swing.JPanel jPanelbutton;
    private javax.swing.JPanel jPaneview;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable onlineTable;
    private javax.swing.JTable onsiteTable;
    // End of variables declaration//GEN-END:variables
    
}
