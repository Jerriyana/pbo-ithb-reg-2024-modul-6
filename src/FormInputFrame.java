import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;

public class FormInputFrame extends JFrame {

    private JTextField createTextField(int width, int height) {
        JTextField textField = new JTextField();
        textField.setMaximumSize(new DimensionUIResource(width, height));
        textField.setAlignmentX(LEFT_ALIGNMENT);
        return textField;
    }

    public FormInputFrame() {
        // JFrame Input
        setTitle("Form Input E-KTP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);

        // JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 35, 0, 0));

        // 1. NIK : Text
        panel.add(new JLabel("NIK : "));
        JTextField nik = createTextField(300, 20);
        panel.add(nik);

        // 2. Nama : Text
        panel.add(new JLabel("Nama : "));
        JTextField nama = createTextField(300, 20);
        panel.add(nama);

        // 3. Tempat Lahir : Text
        panel.add(new JLabel("Tempat Lahir : "));
        JTextField tempatLahir = createTextField(300, 20);
        panel.add(tempatLahir);

        // 4. Tanggal Lahir : Date Picker
        panel.add(new JLabel("Tanggal Lahir (tanggal-bulan-tahun)"));
        JTextField tanggalLahir = createTextField(300, 20);
        panel.add(tanggalLahir);

        // 5. Jenis Kelamin : Radio Button (Pria / Wanita)
        panel.add(new JLabel("Jenis Kelamin : "));
        JRadioButton pria = new JRadioButton("Pria");
        JRadioButton wanita = new JRadioButton("Wanita");
        ButtonGroup gender = new ButtonGroup();
        gender.add(pria);
        gender.add(wanita);
        panel.add(pria);
        panel.add(wanita);

        // 6. Gol. Darah : Radio Button (A, B, O, AB)
        panel.add(new JLabel("Golongan Darah :"));
        JRadioButton golA = new JRadioButton("A");
        JRadioButton golB = new JRadioButton("B");
        JRadioButton golO = new JRadioButton("O");
        JRadioButton golAB = new JRadioButton("AB");
        ButtonGroup golDarah = new ButtonGroup();
        golDarah.add(golA);
        golDarah.add(golB);
        golDarah.add(golO);
        golDarah.add(golAB);
        panel.add(golA);
        panel.add(golB);
        panel.add(golO);
        panel.add(golAB);

        // 7. Alamat : Text
        panel.add(new JLabel("Alamat : "));
        JTextField alamat = createTextField(300, 20);
        panel.add(alamat);

        // 8. RT/RW : Text
        panel.add(new JLabel("RT/RW : "));
        JTextField rtRw = createTextField(300, 20);
        panel.add(rtRw);

        // 9. Kel/Desa : Text
        panel.add(new JLabel("Kel/Desa : "));
        JTextField kelDesa = createTextField(300, 20);
        panel.add(kelDesa);

        // 10. Kecamatan : Text
        panel.add(new JLabel("Kecamatan : "));
        JTextField kecamatan = createTextField(300, 20);
        panel.add(kecamatan);

        // 11. Agama : combo box
        panel.add(new JLabel("Agama : "));
        String[] agamaOptions = { "Islam", "Katolik", "Kristen", "Budha", "Hindu", "Konghucu" };
        JComboBox<String> agamaBox = new JComboBox<>(agamaOptions);
        agamaBox.setMaximumSize(new DimensionUIResource(200, 30));
        agamaBox.setAlignmentX(LEFT_ALIGNMENT);
        panel.add(agamaBox);

        // 12. Status Perkawinan : combo box (Belum Menikah, Menikah, Janda/Duda)
        panel.add(new JLabel("Status Perkawinan : "));
        String[] statusPerkawinanOptions = { "Belum Menikah", "Menikah", "Janda/Duda" };
        JComboBox<String> statusPerkawinanBox = new JComboBox<>(statusPerkawinanOptions);
        statusPerkawinanBox.setMaximumSize(new DimensionUIResource(200, 30));
        statusPerkawinanBox.setAlignmentX(LEFT_ALIGNMENT);
        panel.add(statusPerkawinanBox);

        // 13. Pekerjaan : Check Box (Karyawan Swasta, PNS, Wiraswasta, Akademisi,
        // Pengangguran)
        panel.add(new JLabel("Pekerjaan"));
        JCheckBox karyawanSwasta = new JCheckBox("Karyawan Swasta");
        JCheckBox pns = new JCheckBox("PNS");
        JCheckBox wiraswasta = new JCheckBox("Wiraswasta");
        JCheckBox akademisi = new JCheckBox("Akademisi");
        JCheckBox pengangguran = new JCheckBox("Pengangguran");

        // Action Listener Pengangguran
        pengangguran.addActionListener(e -> {
            boolean isPengangguran = pengangguran.isSelected();
            karyawanSwasta.setEnabled(!isPengangguran);
            karyawanSwasta.setVisible(!isPengangguran);
            pns.setEnabled(!isPengangguran);
            pns.setVisible(!isPengangguran);
            wiraswasta.setEnabled(!isPengangguran);
            wiraswasta.setVisible(!isPengangguran);
            akademisi.setEnabled(!isPengangguran);
            akademisi.setVisible(!isPengangguran);
        });

        panel.add(karyawanSwasta);
        panel.add(pns);
        panel.add(wiraswasta);
        panel.add(akademisi);
        panel.add(pengangguran);

        // 14. Kewarganegaraan : Radio Button (WNI atau WNA) (WNA : input
        // kewarganegaraan)
        panel.add(new JLabel("Kewarganegaraan"));
        JRadioButton wni = new JRadioButton("WNI");
        JRadioButton wna = new JRadioButton("WNA");
        JTextField wnaTextField = createTextField(300, 20);
        wnaTextField.setVisible(false);
        ButtonGroup kewarganegaraan = new ButtonGroup();
        kewarganegaraan.add(wni);
        kewarganegaraan.add(wna);

        wna.addActionListener(e -> {
            wnaTextField.setEnabled(true);
            wnaTextField.setVisible(true);
        });

        wni.addActionListener(e -> {
            wnaTextField.setEnabled(false);
            wnaTextField.setVisible(false);
        });
        panel.add(wni);
        panel.add(wna);
        panel.add(wnaTextField);

        // 15. Foto : File Chooser
        panel.add(new JLabel("Pilih Foto Muka : "));
        JButton foto = new JButton("Pilih");
        JLabel fotoImageLabel = new JLabel();

        foto.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Pilih Foto Muka");
            int result = fileChooser.showOpenDialog(this);
            String path = "";
            if (result == JFileChooser.APPROVE_OPTION) {
                path = fileChooser.getSelectedFile().getAbsolutePath();
            }
            if (path != null) {
                ImageIcon icon = new ImageIcon(path);
                ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, 50));
                fotoImageLabel.setIcon(resizedIcon);
            }
        });

        panel.add(foto);
        panel.add(fotoImageLabel);

        // 16. Tanda Tangan : File Chooser
        panel.add(new JLabel("Pilih Foto Tanda TAngan : "));
        JButton tandaTangan = new JButton("Pilih");
        JLabel tandaTanganImageLabel = new JLabel();

        tandaTangan.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Pilih Foto Tanda Tangan");
            int result = fileChooser.showOpenDialog(this);
            String path = "";
            if (result == JFileChooser.APPROVE_OPTION) {
                path = fileChooser.getSelectedFile().getAbsolutePath();
            }
            if (path != null) {
                ImageIcon icon = new ImageIcon(path);
                ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, 50));
                tandaTanganImageLabel.setIcon(resizedIcon);
            }
        });

        panel.add(tandaTangan);
        panel.add(tandaTanganImageLabel);

        // 17. Berlaku Hingga : Text
        panel.add(new JLabel("Berlaku Hingga (tanggal-bulan-tahun)"));
        JTextField berlakuHingga = createTextField(200, 30);
        panel.add(berlakuHingga);

        // 18. Kota Pembuatan KTP : Text
        panel.add(new JLabel("Kota Pembuatan KTP"));
        JTextField kotaPembuatan = createTextField(200, 30);
        panel.add(kotaPembuatan);

        // 19. Tanggal Pembuatan KTP : Date
        panel.add(new JLabel("Tanggal Pembuatan (tanggal-bulan-tahun)"));
        JTextField tanggalPembuatan = createTextField(200, 30);
        panel.add(tanggalPembuatan);

        // 20. Provinsi (Hardcode di output)        

        // 21. Insert Data (ga boleh kosong) (pesan sukses) (frame baru halaman ktp dan
        // tombol close) (error : pesan pakai JOPTION Pane)
        JButton insert = new JButton("Insert Data");
        insert.addActionListener(e -> {
            // Cek apakah semua field telah terisi
            if (nik.getText().isEmpty() || nama.getText().isEmpty() || tempatLahir.getText().isEmpty() ||
                    tanggalLahir.getText().isEmpty() || alamat.getText().isEmpty() || rtRw.getText().isEmpty() ||
                    kelDesa.getText().isEmpty() || kecamatan.getText().isEmpty() || berlakuHingga.getText().isEmpty() ||
                    kotaPembuatan.getText().isEmpty() || tanggalPembuatan.getText().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Semua field harus terisi!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (pria.isSelected() == false && wanita.isSelected() == false) {
                JOptionPane.showMessageDialog(this, "Pilih Jenis Kelamin!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (golA.isSelected() == false && golB.isSelected() == false && golO.isSelected() == false
                    && golAB.isSelected() == false) {
                JOptionPane.showMessageDialog(this, "Pilih Golongan Darah!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (agamaBox.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Pilih Agama!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (statusPerkawinanBox.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Pilih Status Perkawinan!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!(karyawanSwasta.isSelected() || pns.isSelected() || wiraswasta.isSelected()
                    || akademisi.isSelected() || pengangguran.isSelected())) {
                JOptionPane.showMessageDialog(this, "Pilih Pekerjaan!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (wna.isSelected() && wnaTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Masukkan Kewarganegaraan untuk WNA!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (fotoImageLabel.getIcon() == null) {
                JOptionPane.showMessageDialog(this, "Pilih Foto!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (tandaTanganImageLabel.getIcon() == null) {
                JOptionPane.showMessageDialog(this, "Pilih Foto Tanda Tangan!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Pesan Berhasil",
                        JOptionPane.INFORMATION_MESSAGE);
                setEnabled(false);
                OutputKtpFrame outputFrame = new OutputKtpFrame(
                        nik.getText(), nama.getText(), tempatLahir.getText(), tanggalLahir.getText(),
                        pria.isSelected() ? "Pria" : "Wanita",
                        golA.isSelected() ? "A" : golB.isSelected() ? "B" : golO.isSelected() ? "O" : "AB",
                        alamat.getText(), rtRw.getText(), kelDesa.getText(), kecamatan.getText(),
                        (String) agamaBox.getSelectedItem(),
                        (String) statusPerkawinanBox.getSelectedItem(),
                        karyawanSwasta.isSelected() ? "Karyawan Swasta"
                                : pns.isSelected() ? "PNS"
                                        : wiraswasta.isSelected() ? "Wiraswasta"
                                                : akademisi.isSelected() ? "Akademisi" : "Pengangguran",
                        wni.isSelected() ? "WNI" : wnaTextField.getText(),
                        berlakuHingga.getText(), kotaPembuatan.getText(), tanggalPembuatan.getText(),
                        (ImageIcon) fotoImageLabel.getIcon(), (ImageIcon) tandaTanganImageLabel.getIcon());

                outputFrame.setVisible(true);
            }
        });

        panel.add(insert);

        // JScroll
        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane);
    }
}
