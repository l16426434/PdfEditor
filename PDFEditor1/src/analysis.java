
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.awt.Point;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * analysis.java
 *check for the soxml.xml in your working directory
 * Created on 19 Mar, 2012, 4:54:32 PM
 */

/**
 *
 * @author aditya
 */
public class analysis extends javax.swing.JFrame  {

    /** Creates new form analysis
     type = 0:examiner 1:student
     */
    question ques;
    check chk;
    JLabel subs;
    boolean type;
    DOMParser parser;
    Document doc;
    XPath xpath;
    XPathExpression expr,expr1;
    NodeList nodes,nodes1,nodes2;
    Object result;
    DefaultListModel listmodel;
    String dregno,dsub,sreg;
    public analysis(boolean typ,String branch,String year,String reg) {
        type=typ;
        sreg=reg;
        initComponents();
        init();
    }

    void init() {
        try {
        parser = new DOMParser();
        parser.parse("soxml.xml");
        doc = parser.getDocument();
        xpath = XPathFactory.newInstance().newXPath();
        listmodel = new DefaultListModel();
        }
        catch(Exception e) {
            System.out.println("parse: "+e.getMessage());

        }
        showstudent();
       disablelabel();

    }
    void disablelabel() {
         jls1.setVisible(false);
        jlm1.setVisible(false);
        jbv1.setVisible(false);
        jbd1.setVisible(false);
        jls2.setVisible(false);
        jlm2.setVisible(false);
        jbv2.setVisible(false);
        jbd2.setVisible(false);
        jls3.setVisible(false);
        jlm3.setVisible(false);
        jbv3.setVisible(false);
        jbd3.setVisible(false);
        jls4.setVisible(false);
        jlm4.setVisible(false);
        jbv4.setVisible(false);
        jbd4.setVisible(false);
        jls5.setVisible(false);
        jlm5.setVisible(false);
        jbv5.setVisible(false);
        jbd5.setVisible(false);
        jls6.setVisible(false);
        jlm6.setVisible(false);
        jbv6.setVisible(false);
        jbd6.setVisible(false);
    }
    void showstudent() {
        try {        
        expr = xpath.compile("//student/@regno");
        result = expr.evaluate(doc, XPathConstants.NODESET);
        nodes = (NodeList) result;
        String tr;
        boolean fr=false;
        for(int i=0;i<nodes.getLength();i++) {
                tr=nodes.item(i).getNodeValue();
                if(type==false) {
                listmodel.addElement(tr);
                 }
                else if(type==true) {
                    System.out.println(":: "+tr+" "+sreg);
                    if(tr.matches(sreg)) {
                        System.out.println(" matched");
                        listmodel.addElement(tr);
                        fr=true;
                    }
                }
            }
        jList1.setModel(listmodel);
        if(fr==false && type==true) {
            JOptionPane.showMessageDialog(this,"Reg no dont exist","Error!!",JOptionPane.ERROR_MESSAGE);
            this.dispose();
         }
        }

        catch(Exception e) {
            System.out.println("showstudent: "+e.getMessage());
        }

    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        canvas1 = new java.awt.Canvas();
        jSeparator1 = new javax.swing.JSeparator();
        jls1 = new javax.swing.JLabel();
        jls2 = new javax.swing.JLabel();
        jls3 = new javax.swing.JLabel();
        jls4 = new javax.swing.JLabel();
        jls5 = new javax.swing.JLabel();
        jls6 = new javax.swing.JLabel();
        jlm1 = new javax.swing.JLabel();
        jlm2 = new javax.swing.JLabel();
        jlm3 = new javax.swing.JLabel();
        jlm4 = new javax.swing.JLabel();
        jlm5 = new javax.swing.JLabel();
        jlm6 = new javax.swing.JLabel();
        jbv1 = new javax.swing.JButton();
        jbd1 = new javax.swing.JButton();
        jbv2 = new javax.swing.JButton();
        jbd2 = new javax.swing.JButton();
        jbv3 = new javax.swing.JButton();
        jbd3 = new javax.swing.JButton();
        jbv4 = new javax.swing.JButton();
        jbd4 = new javax.swing.JButton();
        jbv5 = new javax.swing.JButton();
        jbd5 = new javax.swing.JButton();
        jbv6 = new javax.swing.JButton();
        jbd6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Subjects");

        jLabel2.setText("Marks/Total");

        jRadioButton1.setText("View Mode");

        jRadioButton2.setText("Analysis Mode");

        jLabel3.setText("Domain");

        jRadioButton3.setText("Subject");

        jRadioButton4.setText("Class");

        jls1.setText("jLabel4");

        jls2.setText("jLabel5");

        jls3.setText("jLabel6");

        jls4.setText("jLabel7");

        jls5.setText("jLabel8");

        jls6.setText("jLabel9");

        jlm1.setText("jLabel10");

        jlm2.setText("jLabel11");

        jlm3.setText("jLabel12");

        jlm4.setText("jLabel13");

        jlm5.setText("jLabel14");

        jlm6.setText("jLabel15");

        jbv1.setText("View PDF");

        jbd1.setText("Details");
        jbd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbd1MouseClicked(evt);
            }
        });

        jbv2.setText("View PDF");

        jbd2.setText("Details");
        jbd2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbd2MouseClicked(evt);
            }
        });

        jbv3.setText("View PDF");

        jbd3.setText("Details");
        jbd3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbd3MouseClicked(evt);
            }
        });

        jbv4.setText("View PDF");

        jbd4.setText("Details");
        jbd4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbd4MouseClicked(evt);
            }
        });

        jbv5.setText("View PDF");

        jbd5.setText("Details");
        jbd5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbd5MouseClicked(evt);
            }
        });

        jbv6.setText("View PDF");

        jbd6.setText("Details");
        jbd6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbd6MouseClicked(evt);
            }
        });

        jButton1.setText("Check Consistency");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(jRadioButton3)
                        .addGap(27, 27, 27)
                        .addComponent(jRadioButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jls1)
                                    .addComponent(jls2)
                                    .addComponent(jls3)
                                    .addComponent(jls4)
                                    .addComponent(jls5)
                                    .addComponent(jls6))
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlm1)
                                            .addComponent(jlm2)
                                            .addComponent(jlm3)
                                            .addComponent(jlm4)
                                            .addComponent(jlm5)
                                            .addComponent(jlm6))
                                        .addGap(159, 159, 159)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbv1)
                                            .addComponent(jbv2)
                                            .addComponent(jbv3)
                                            .addComponent(jbv4)
                                            .addComponent(jbv5)
                                            .addComponent(jbv6))
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbd6)
                                            .addComponent(jbd5)
                                            .addComponent(jbd4)
                                            .addComponent(jbd3)
                                            .addComponent(jbd2)
                                            .addComponent(jbd1)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jButton1)))))
                .addGap(224, 224, 224))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jLabel3)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jls1)
                            .addComponent(jlm1)
                            .addComponent(jbv1)
                            .addComponent(jbd1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jls2)
                            .addComponent(jlm2)
                            .addComponent(jbv2)
                            .addComponent(jbd2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jls3)
                            .addComponent(jlm3)
                            .addComponent(jbv3)
                            .addComponent(jbd3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jls4)
                            .addComponent(jlm4)
                            .addComponent(jbv4)
                            .addComponent(jbd4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jls5)
                            .addComponent(jlm5)
                            .addComponent(jbv5)
                            .addComponent(jbd5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jls6)
                            .addComponent(jlm6)
                            .addComponent(jbv6)
                            .addComponent(jbd6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()>=2) {
            disablelabel();
         String regno = (String)jList1.getSelectedValue();
         dregno= regno;
        if(regno!=null) {
            loadstudent(regno);
            System.out.println("hell=="+regno);
        }
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jList1ValueChanged

    private void jbd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbd1MouseClicked
        // TODO add your handling code here:
        dsub=nodes.item(0).getNodeValue();
        loadquestion();
    }//GEN-LAST:event_jbd1MouseClicked

    private void jbd2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbd2MouseClicked
        dsub=nodes.item(1).getNodeValue();
       loadquestion();
        // TODO add your handling code here:
    }//GEN-LAST:event_jbd2MouseClicked

    private void jbd3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbd3MouseClicked
        // TODO add your handling code here:
        dsub=nodes.item(2).getNodeValue();
        loadquestion();
    }//GEN-LAST:event_jbd3MouseClicked

    private void jbd4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbd4MouseClicked
        // TODO add your handling code here:
        dsub=nodes.item(3).getNodeValue();
        loadquestion();
    }//GEN-LAST:event_jbd4MouseClicked

    private void jbd5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbd5MouseClicked
        // TODO add your handling code here:
        dsub=nodes.item(4).getNodeValue();
        loadquestion();
    }//GEN-LAST:event_jbd5MouseClicked

    private void jbd6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbd6MouseClicked
        // TODO add your handling code here
        dsub=nodes.item(5).getNodeValue();
        loadquestion();
    }//GEN-LAST:event_jbd6MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        //delete
    }//GEN-LAST:event_formWindowClosed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(chk!=null) chk.dispose();
        chk =new check(dregno);
        chk.setVisible(true);

    }//GEN-LAST:event_jButton1MouseClicked

    void loadquestion() {
        if(ques!=null) ques.dispose();
        ques =new question(dregno, dsub);
        ques.setVisible(true);

    }

    void loadstudent(String regno) {
        try {
            String tmp;
            int m,f;
            Point p1=jLabel1.getLocationOnScreen(),p2=jLabel2.getLocationOnScreen();
            expr = xpath.compile("//student[@regno='"+regno+"']/subject/@code"); 
            result = expr.evaluate(doc, XPathConstants.NODESET);
            nodes = (NodeList) result;
           System.out.println("ls:A");
            for(int i=0;i<nodes.getLength();i++) {
                m=f=0;
                 expr = xpath.compile("//student[@regno='"+regno+"']/subject[@code='"+nodes.item(i).getNodeValue()+"']//marks/text()");
                  expr1 = xpath.compile("//student[@regno='"+regno+"']/subject[@code='"+nodes.item(i).getNodeValue()+"']//full_marks/text()");
                  result = expr.evaluate(doc, XPathConstants.NODESET);
                  nodes1 = (NodeList) result;
                  result = expr1.evaluate(doc, XPathConstants.NODESET);
                  nodes2 =(NodeList) result;
                  System.out.println("ls:B");
                  for(int j=0;j<nodes1.getLength();j++) {
                     // System.out.println(nodes1.item(j).getNodeValue());
                      m=m+Integer.parseInt(nodes1.item(j).getNodeValue().trim());
                      f=f+Integer.parseInt(nodes2.item(j).getNodeValue().trim());
                  }
                 System.out.println("ls:C");
                if(i==0)
                {

                  jls1.setText(nodes.item(i).getNodeValue());
                  jlm1.setText(m+"/"+f);
                  jls1.setVisible(true);
                  jlm1.setVisible(true);
                  jbv1.setVisible(true);
                  jbd1.setVisible(true);
                }
                else if(i==1) {
                    jls2.setText(nodes.item(i).getNodeValue());
                    jlm2.setText(m+"/"+f);
                  jls2.setVisible(true);
                  jlm2.setVisible(true);
                  jbv2.setVisible(true);
                  jbd2.setVisible(true);
                }
                else if(i==2) {
                    jls3.setText(nodes.item(i).getNodeValue());
                    jlm3.setText(m+"/"+f);
                  jls3.setVisible(true);
                  jlm3.setVisible(true);
                  jbv3.setVisible(true);
                  jbd3.setVisible(true);
                }
                else if(i==3) {
                    jls4.setText(nodes.item(i).getNodeValue());
                    jlm4.setText(m+"/"+f);
                  jls4.setVisible(true);
                  jlm4.setVisible(true);
                  jbv4.setVisible(true);
                  jbd4.setVisible(true);
                }
                else if(i==4) {
                    jls5.setText(nodes.item(i).getNodeValue());
                    jlm5.setText(m+"/"+f);
                  jls5.setVisible(true);
                  jlm5.setVisible(true);
                  jbv5.setVisible(true);
                  jbd5.setVisible(true);
                }
                else if(i==5) {
                    jls6.setText(nodes.item(i).getNodeValue());
                    jlm6.setText(m+"/"+f);
                  jls6.setVisible(true);
                  jlm6.setVisible(true);
                  jbv6.setVisible(true);
                  jbd6.setVisible(true);
                }
             }
        }
        catch(Exception e){
            System.out.println("loadstud: "+e.getMessage());
        }
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new analysis(false,null,null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbd1;
    private javax.swing.JButton jbd2;
    private javax.swing.JButton jbd3;
    private javax.swing.JButton jbd4;
    private javax.swing.JButton jbd5;
    private javax.swing.JButton jbd6;
    private javax.swing.JButton jbv1;
    private javax.swing.JButton jbv2;
    private javax.swing.JButton jbv3;
    private javax.swing.JButton jbv4;
    private javax.swing.JButton jbv5;
    private javax.swing.JButton jbv6;
    private javax.swing.JLabel jlm1;
    private javax.swing.JLabel jlm2;
    private javax.swing.JLabel jlm3;
    private javax.swing.JLabel jlm4;
    private javax.swing.JLabel jlm5;
    private javax.swing.JLabel jlm6;
    private javax.swing.JLabel jls1;
    private javax.swing.JLabel jls2;
    private javax.swing.JLabel jls3;
    private javax.swing.JLabel jls4;
    private javax.swing.JLabel jls5;
    private javax.swing.JLabel jls6;
    // End of variables declaration//GEN-END:variables

}
