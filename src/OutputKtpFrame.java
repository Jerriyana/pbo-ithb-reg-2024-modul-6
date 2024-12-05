import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class OutputKtpFrame extends JFrame {
    private User user; // Menyimpan data pengguna

    public OutputKtpFrame(String nik, String nama, String tempatLahir, String tanggalLahir, String jenisKelamin,
                          String golDarah, String alamat, String rtRw, String kelDesa, String kecamatan,
                          String agama, String statusPerkawinan, String pekerjaan, String kewarganegaraan,
                          String berlakuHingga, String kotaPembuatan, String tanggalPembuatan,
                          ImageIcon foto, ImageIcon tandaTangan) {
        // Controller 
        Controller controller = new Controller();

        // Menyimpan data pengguna dalam objek User
        user = new User();
        user.setNik(nik);
        user.setNama(nama);
        user.setTempatLahir(tempatLahir);
        user.setTanggalLahir(tanggalLahir);
        user.setJenisKelamin(jenisKelamin);
        user.setGolonganDarah(golDarah);
        user.setAlamat(alamat);
        user.setRtRw(rtRw);
        user.setKelDesa(kelDesa);
        user.setKecamatan(kecamatan);
        user.setAgama(agama);
        user.setStatusPerkawinan(statusPerkawinan);
        user.setPekerjaan(pekerjaan);
        user.setKewarganegaraan(kewarganegaraan);
        user.setBerlakuHingga(berlakuHingga);
        user.setKotaPembuatan(kotaPembuatan);
        user.setTanggalPembuatan(tanggalPembuatan);
        user.setFoto(foto.toString()); // Simpan path atau string representasi foto
        user.setTandaTangan(tandaTangan.toString()); // Simpan path atau string representasi tanda tangan

        // Setting JFrame
        setTitle("E-KTP Output");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        // Panel kiri: Informasi teks KTP
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Label Header: Provinsi dan Kota
        JLabel provinsiLabel = new JLabel("PROVINSI REPUBLIK HARAPAN BANGSA");
        provinsiLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel kotaLabel = new JLabel("KABUPATEN / KOTA " + kotaPembuatan.toUpperCase());
        kotaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        leftPanel.add(provinsiLabel);
        leftPanel.add(kotaLabel);
        leftPanel.add(Box.createVerticalStrut(10)); // Spacer

        // Informasi lainnya
        leftPanel.add(createRowLabel("NIK", nik));
        leftPanel.add(createRowLabel("Nama", nama));
        leftPanel.add(createRowLabel("Tempat/Tgl Lahir", tempatLahir + ", " + tanggalLahir));
        leftPanel.add(createRowLabel("Jenis Kelamin", jenisKelamin + "   Gol. Darah: " + golDarah));
        leftPanel.add(createRowLabel("Alamat", alamat));
        leftPanel.add(createRowLabel("RT/RW", rtRw));
        leftPanel.add(createRowLabel("Kel/Desa", kelDesa));
        leftPanel.add(createRowLabel("Kecamatan", kecamatan));
        leftPanel.add(createRowLabel("Agama", agama));
        leftPanel.add(createRowLabel("Status Perkawinan", statusPerkawinan));
        leftPanel.add(createRowLabel("Pekerjaan", pekerjaan));
        leftPanel.add(createRowLabel("Kewarganegaraan", kewarganegaraan));
        leftPanel.add(createRowLabel("Berlaku Hingga", berlakuHingga));

        // Panel kanan: Foto, Tanda T angan
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel fotoLabel = new JLabel(foto);
        JLabel tandaTanganLabel = new JLabel(tandaTangan);
        
        rightPanel.add(new JLabel("Foto:"));
        rightPanel.add(fotoLabel);
        rightPanel.add(Box.createVerticalStrut(10)); // Spacer
        rightPanel.add(new JLabel("Tanda Tangan:"));
        rightPanel.add(tandaTanganLabel);

        // Menambahkan panel ke frame
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(leftPanel);
        add(rightPanel);

        // Panel untuk tombol Update dan Delete
        JPanel buttonPanel = new JPanel();
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        updateButton.addActionListener(e -> {
            // Logika untuk update data
            boolean success = controller.updateUser (user);
            if (success) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengupdate data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            // Kembali ke Main Menu
            new MainMenu().setVisible(true);
            dispose();
        });

        deleteButton.addActionListener(e -> {
            // Logika untuk delete data
            boolean success = controller.deleteUser (user.getNik());
            if (success) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            // Kembali ke Main Menu
            new MainMenu().setVisible(true);
            dispose();
        });

        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel);
    }

    private JLabel createRowLabel(String label, String value) {
        return new JLabel(label + ": " + value);
    }
}