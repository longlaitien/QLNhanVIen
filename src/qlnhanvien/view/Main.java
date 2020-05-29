/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import qlnhanvien.controller.Combo_controller;
import qlnhanvien.controller.NhanVien_Controller;

/**
 *
 * @author nhatnguyen
 */
public class Main extends javax.swing.JFrame {

    public static String manv, hoten;
    public static String ngaysinh;
    public static String quequan, gioitinh, dantoc, sodt;
    public static String heso, luongcb;
    public static String image, mapb, macv, matdhv;
    public static String trangthai;
    public static ArrayList<String> list_MaNV = new ArrayList<>();
    DefaultTableModel model;
    NhanVien_Controller nv;

    Department_panel dp = new Department_panel();
    Position_panel ps = new Position_panel();
    TrinhDo_panel ms = new TrinhDo_panel();

    public Main() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        DataTable();
        Authen();
        //getDataTableColumn();
        nv = new NhanVien_Controller();

    }

    public void HidePanel() {
        pnTable.setVisible(false);
        this.dp.setVisible(false);
        this.ps.setVisible(false);
        this.ms.setVisible(false);
    }

    public void ShowPanel(JPanel pn) {
        HidePanel();
        pn.setBounds(235, 65, 1065, 460);
        pn.setVisible(true);
        this.add(pn);

    }

    public void Authen() {
        if (Login.role == 1) {
            btnAdd.setEnabled(false);
            btnDelete.setEnabled(false);
            lbUser.setText("XIN CHÀO: " + Login.user.toUpperCase());
            btnUpdate.setText("Thông tin");
        } else {
            lbUser.setText(Login.user.toUpperCase() + " (admin)".toLowerCase());
        }

        lbUser.setFont(lbUser.getFont().deriveFont(14.0F));
    }

    public void DataTable() {
        String[] columns = {"Mã NV", "Họ tên", "Ngày sinh", "Quê quán", "Giới tính", "Dân tộc", "Số ĐT", "Hệ số", "Lương CB", "Ảnh", "Phòng ban", "Chức vụ", "Trình độ", "Trạng thái"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        tblNhanVien.setModel(model);
        Combo_controller cbo = new Combo_controller();
        String manv;
        String hoten;
        String ngaysinh;
        String quequan;
        String gioitinh;
        String dantoc;
        String sodt;
        float heso;
        float luongcb;
        String image;
        String mapb = "";
        String macv = "";
        String matdhv = "";
        String trangthai = "";
        try {

            for (int i = 0; i < cbo.getDataTable().size(); i++) {

                manv = cbo.getDataTable().get(i).getManv();
                hoten = cbo.getDataTable().get(i).getHoten();
                ngaysinh = cbo.getDataTable().get(i).getNgaysinh();
                quequan = cbo.getDataTable().get(i).getQuequan();
                gioitinh = cbo.getDataTable().get(i).getGioitinh();
                sodt = cbo.getDataTable().get(i).getSodt();
                dantoc = cbo.getDataTable().get(i).getDantoc();
                heso = cbo.getDataTable().get(i).getHeso();
                luongcb = cbo.getDataTable().get(i).getLuongcb();
                image = cbo.getDataTable().get(i).getImage();
                switch (cbo.getDataTable().get(i).getMapb().trim()) {
                    case "pb1":
                        mapb = "Phòng phát triển";
                        break;
                    case "pb2":
                        mapb = "Phòng nhân sự";
                        break;
                    case "pb3":
                        mapb = "Phòng marketing";
                        break;
                    case "pb4":
                        mapb = "Phòng kế toán";
                        break;
                }

                switch (cbo.getDataTable().get(i).getMacv().trim()) {
                    case "cv1":
                        macv = "Giám đốc";
                        break;
                    case "cv2":
                        macv = "Trưởng phòng";
                        break;
                    case "cv3":
                        macv = "Phó trưởng phòng";
                        break;
                    case "cv4":
                        macv = "Nhân viên";
                        break;
                    case "cv5":
                        macv = "Thực tập sinh";
                        break;
                }

                switch (cbo.getDataTable().get(i).getMatdhv().trim()) {
                    case "td1":
                        matdhv = "Caohọc";
                        break;
                    case "td2":
                        matdhv = "Đại học";
                        break;
                    case "td3":
                        matdhv = "Cao đẳng";
                        break;
                    case "td4":
                        matdhv = "Trung cấp";
                }

                switch (cbo.getDataTable().get(i).getTrangthai()) {
                    case 1:
                        trangthai = "Active";
                        break;
                    case 0:
                        trangthai = "Disactive";
                        break;

                }

                model.addRow(new Object[]{
                    manv, hoten, ngaysinh, quequan, gioitinh, dantoc, sodt, heso, luongcb, image, mapb, macv, matdhv, trangthai
                });
//                System.out.println(mapb+macv+matdhv);

            }
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
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
        lbLogo = new javax.swing.JLabel();
        lbLogout = new javax.swing.JLabel();
        pnTable = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        lbDeparment = new javax.swing.JLabel();
        lbChucVu = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbTrinhDo = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ NHÂN VIÊN");

        jPanel1.setBackground(new java.awt.Color(0, 96, 181));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbLogo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLogo.setForeground(new java.awt.Color(255, 255, 255));
        lbLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ichome.png"))); // NOI18N
        lbLogo.setText("QUẢN LÝ NHÂN VIÊN");
        lbLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbLogout.setBackground(new java.awt.Color(0, 96, 181));
        lbLogout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbLogout.setForeground(new java.awt.Color(255, 255, 255));
        lbLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        lbLogout.setText("Đăng xuất");
        lbLogout.setOpaque(true);
        lbLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbLogoutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnTable.setBackground(new java.awt.Color(255, 255, 255));
        pnTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAdd.setBackground(new java.awt.Color(0, 102, 255));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icadd.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setToolTipText("Thêm nhân viên");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 102, 102));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icreload.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.setToolTipText("Sửa thông tin nhân viên");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icdelete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setToolTipText("Xóa nhân viên");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblNhanVien.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tblNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblNhanVien.setFillsViewportHeight(true);
        tblNhanVien.setRowHeight(30);
        jScrollPane1.setViewportView(tblNhanVien);
        tblNhanVien.getAccessibleContext().setAccessibleParent(pnTable);

        btnSearch.setBackground(new java.awt.Color(0, 102, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icsearch.png"))); // NOI18N
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnTableLayout = new javax.swing.GroupLayout(pnTable);
        pnTable.setLayout(pnTableLayout);
        pnTableLayout.setHorizontalGroup(
            pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTableLayout.createSequentialGroup()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addGap(61, 61, 61)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnTableLayout.setVerticalGroup(
            pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTableLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd)
                        .addComponent(btnUpdate)
                        .addComponent(btnDelete)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch))
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 96, 181));
        jPanel2.setFocusable(false);

        jLabel6.setForeground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("Powered by ChickenTeam");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(612, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(545, 545, 545))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        lbDeparment.setBackground(new java.awt.Color(0, 96, 181));
        lbDeparment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDeparment.setForeground(new java.awt.Color(255, 255, 204));
        lbDeparment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDeparment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icdepartment.png"))); // NOI18N
        lbDeparment.setLabelFor(btnAdd);
        lbDeparment.setText("PHÒNG BAN");
        lbDeparment.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbDeparment.setOpaque(true);
        lbDeparment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDeparmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbDeparmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbDeparmentMouseExited(evt);
            }
        });

        lbChucVu.setBackground(new java.awt.Color(0, 96, 181));
        lbChucVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbChucVu.setForeground(new java.awt.Color(255, 255, 204));
        lbChucVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icposition.png"))); // NOI18N
        lbChucVu.setText("CHỨC VỤ");
        lbChucVu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbChucVu.setOpaque(true);
        lbChucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbChucVuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbChucVuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbChucVuMouseExited(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 96, 181));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lookup.png"))); // NOI18N
        jLabel3.setText("TRA CỨU THÔNG TIN");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        lbTrinhDo.setBackground(new java.awt.Color(0, 96, 181));
        lbTrinhDo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTrinhDo.setForeground(new java.awt.Color(255, 255, 204));
        lbTrinhDo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iclevel.png"))); // NOI18N
        lbTrinhDo.setText("TRÌNH ĐỘ");
        lbTrinhDo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbTrinhDo.setOpaque(true);
        lbTrinhDo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTrinhDoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbTrinhDoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbTrinhDoMouseExited(evt);
            }
        });

        lbUser.setBackground(new java.awt.Color(0, 96, 181));
        lbUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbUser.setForeground(new java.awt.Color(255, 255, 204));
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icuser.png"))); // NOI18N
        lbUser.setText("XIN CHÀO");
        lbUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbUser.setOpaque(true);
        lbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbUserMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbUser, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbDeparment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTrinhDo, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDeparment, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(pnTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 92, Short.MAX_VALUE))
                    .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited

        jLabel3.setBackground(new Color(0, 96, 181));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered

        jLabel3.setBackground(new Color(153, 190, 236));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        int selectRow = tblNhanVien.getSelectedRow();
        if (selectRow >= 0) {

            manv = tblNhanVien.getValueAt(selectRow, 0).toString().trim();
            hoten = tblNhanVien.getValueAt(selectRow, 1).toString().trim();
            ngaysinh = tblNhanVien.getValueAt(selectRow, 2).toString().trim();
            quequan = tblNhanVien.getValueAt(selectRow, 3).toString().trim();
            gioitinh = tblNhanVien.getValueAt(selectRow, 4).toString().trim();
            dantoc = tblNhanVien.getValueAt(selectRow, 5).toString().trim();
            sodt = tblNhanVien.getValueAt(selectRow, 6).toString().trim();
            heso = tblNhanVien.getValueAt(selectRow, 7).toString().trim();
            luongcb = tblNhanVien.getValueAt(selectRow, 8).toString().trim();
            image = tblNhanVien.getValueAt(selectRow, 9).toString().trim();
            mapb = tblNhanVien.getValueAt(selectRow, 10).toString().trim();
            macv = tblNhanVien.getValueAt(selectRow, 11).toString().trim();
            matdhv = tblNhanVien.getValueAt(selectRow, 12).toString().trim();
            trangthai = tblNhanVien.getValueAt(selectRow, 13).toString().trim();
            UpdateEmployee updateEmployee = new UpdateEmployee();
            updateEmployee.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Click vào nhân viên trên bảng để thực hiện chức năng này!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        DataTable();
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        String[] columns = {"Mã NV", "Họ tên", "Ngày sinh", "Quê quán", "Giới tính", "Dân tộc", "Số ĐT", "Hệ số", "Lương CB", "Ảnh", "Phòng ban", "Chức vụ", "Trình độ"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        tblNhanVien.setModel(model);
        String manv;
        String hoten;
        String ngaysinh;
        String quequan;
        String gioitinh;
        String dantoc;
        String sodt;
        float heso;
        float luongcb;
        String image;
        String mapb = "";
        String macv = "";
        String matdhv = "";

        String tk_nv = txtSearch.getText();
        try {

            for (int i = 0; i < nv.TimKiem(tk_nv).size(); i++) {

                manv = nv.TimKiem(tk_nv).get(i).getManv();
                hoten = nv.TimKiem(tk_nv).get(i).getHoten();
                ngaysinh = nv.TimKiem(tk_nv).get(i).getNgaysinh();
                quequan = nv.TimKiem(tk_nv).get(i).getQuequan();
                gioitinh = nv.TimKiem(tk_nv).get(i).getGioitinh();
                sodt = nv.TimKiem(tk_nv).get(i).getSodt();
                dantoc = nv.TimKiem(tk_nv).get(i).getDantoc();
                heso = nv.TimKiem(tk_nv).get(i).getHeso();
                luongcb = nv.TimKiem(tk_nv).get(i).getLuongcb();
                image = nv.TimKiem(tk_nv).get(i).getImage();

                switch (nv.TimKiem(tk_nv).get(i).getMapb().trim()) {
                    case "pb1":
                        mapb = "Phòng phát triển";
                        break;
                    case "pb2":
                        mapb = "Phòng nhân sự";
                        break;
                    case "pb3":
                        mapb = "Phòng marketing";
                        break;
                    case "pb4":
                        mapb = "Phòng kế toán";
                        break;
                }

                switch (nv.TimKiem(tk_nv).get(i).getMacv().trim()) {
                    case "cv1":
                        macv = "Giám đốc";
                        break;
                    case "cv2":
                        macv = "Trưởng phòng";
                        break;
                    case "cv3":
                        macv = "Phó trưởng phòng";
                        break;
                    case "cv4":
                        macv = "Nhân viên";
                        break;
                    case "cv5":
                        macv = "Thực tập sinh";
                        break;
                }

                switch (nv.TimKiem(tk_nv).get(i).getMatdhv().trim()) {
                    case "td1":
                        matdhv = "Cao học";
                        break;
                    case "td2":
                        matdhv = "Đại học";
                        break;
                    case "td3":
                        matdhv = "Cao đẳng";
                        break;
                    case "td4":
                        matdhv = "Trung cấp";
                }

                model.addRow(new Object[]{
                    manv, hoten, ngaysinh, quequan, gioitinh, dantoc, sodt, heso, luongcb, image, mapb, macv, matdhv
                });
            }
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    //Logout ra man hinh chinh cua ung ung
    private void lbLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoutMouseClicked
        Login lg = new Login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbLogoutMouseClicked

    private void lbLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoutMouseEntered
        lbLogout.setBackground(new Color(243, 0, 0));
    }//GEN-LAST:event_lbLogoutMouseEntered

    private void lbLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoutMouseExited
        lbLogout.setBackground(new Color(0, 96, 181));
    }//GEN-LAST:event_lbLogoutMouseExited

    //Hien thi form them nhan vien
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddEmployee obj = new AddEmployee();
        obj.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    //Xoa nhan vien khoi danh sach
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectRow = tblNhanVien.getSelectedRow();
        if (selectRow >= 0) {
            manv = tblNhanVien.getValueAt(selectRow, 0).toString();
            hoten = tblNhanVien.getValueAt(selectRow, 1).toString();
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn xóa \"" + hoten + "\" khỏi danh sách không?", "Xác nhận", dialogButton);

            if (dialogResult == JOptionPane.YES_NO_OPTION) {
                int rowDeleted = nv.DeleteNV(manv);
                if (rowDeleted > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Xóa nhân viên thành công");
                    DataTable();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Xóa nhân viên thất bại");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Click vào nhân viên trên bảng để thực hiện chức năng này!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void lbTrinhDoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTrinhDoMouseClicked
        ShowPanel(ms);
    }//GEN-LAST:event_lbTrinhDoMouseClicked

    private void lbChucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbChucVuMouseClicked
        ShowPanel(ps);
    }//GEN-LAST:event_lbChucVuMouseClicked

    private void lbDeparmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDeparmentMouseClicked
        ShowPanel(dp);
    }//GEN-LAST:event_lbDeparmentMouseClicked

    private void lbDeparmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDeparmentMouseEntered
        lbDeparment.setBackground(new Color(153, 190, 236));
    }//GEN-LAST:event_lbDeparmentMouseEntered

    private void lbDeparmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDeparmentMouseExited
        lbDeparment.setBackground(new Color(0, 96, 181));
    }//GEN-LAST:event_lbDeparmentMouseExited

    private void lbChucVuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbChucVuMouseEntered
        lbChucVu.setBackground(new Color(153, 190, 236));
    }//GEN-LAST:event_lbChucVuMouseEntered

    private void lbChucVuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbChucVuMouseExited
        lbChucVu.setBackground(new Color(0, 96, 181));
    }//GEN-LAST:event_lbChucVuMouseExited

    private void lbTrinhDoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTrinhDoMouseEntered
        lbTrinhDo.setBackground(new Color(153, 190, 236));
    }//GEN-LAST:event_lbTrinhDoMouseEntered

    private void lbTrinhDoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTrinhDoMouseExited
        lbTrinhDo.setBackground(new Color(0, 96, 181));
    }//GEN-LAST:event_lbTrinhDoMouseExited

    private void lbUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserMouseClicked
        ShowPanel(pnTable);
    }//GEN-LAST:event_lbUserMouseClicked

    private void lbUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserMouseEntered
        lbDeparment.setBackground(new Color(153, 190, 236));
    }//GEN-LAST:event_lbUserMouseEntered

    private void lbUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserMouseExited
        lbDeparment.setBackground(new Color(0, 96, 181));
    }//GEN-LAST:event_lbUserMouseExited

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Main().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbChucVu;
    private javax.swing.JLabel lbDeparment;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbLogout;
    private javax.swing.JLabel lbTrinhDo;
    private javax.swing.JLabel lbUser;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnTable;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
