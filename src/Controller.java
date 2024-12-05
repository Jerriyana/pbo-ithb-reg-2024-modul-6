import java.sql.*;
import java.util.ArrayList;

public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();

    // SELECT WHERE
    public User getUserByNik(String nik) {
        User user = null;
        conn.connect();
        String query = "SELECT * FROM users WHERE nik = ?";
        try (PreparedStatement stmt = conn.con.prepareStatement(query)) {
            stmt.setString(1, nik);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setNik(rs.getString("nik"));
                user.setNama(rs.getString("nama"));
                user.setTempatLahir(rs.getString("tempat_lahir"));
                user.setTanggalLahir(rs.getString("tanggal_lahir"));
                user.setJenisKelamin(rs.getString("jenis_kelamin"));
                user.setGolonganDarah(rs.getString("golongan_darah"));
                user.setAlamat(rs.getString("alamat"));
                user.setRtRw(rs.getString("rt_rw"));
                user.setKelDesa(rs.getString("kel_desa"));
                user.setKecamatan(rs.getString("kecamatan"));
                user.setAgama(rs.getString("agama"));
                user.setStatusPerkawinan(rs.getString("status_perkawinan"));
                user.setPekerjaan(rs.getString("pekerjaan"));
                user.setKewarganegaraan(rs.getString("kewarganegaraan"));
                user.setBerlakuHingga(rs.getString("berlaku_hingga"));
                user.setKotaPembuatan(rs.getString("kota_pembuatan"));
                user.setTanggalPembuatan(rs.getString("tanggal_pembuatan"));
                user.setFoto(rs.getString("foto"));
                user.setTandaTangan(rs.getString("tanda_tangan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return user;
    }

    // INSERT
    public boolean insertUser (User user) {
        conn.connect();
        String query = "INSERT INTO users (nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, golongan_darah, alamat, rt_rw, kel_desa, kecamatan, agama, status_perkawinan, pekerjaan, kewarganegaraan, berlaku_hingga, kota_pembuatan, tanggal_pembuatan, foto, tanda_tangan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.con.prepareStatement(query)) {
            stmt.setString(1, user.getNik());
            stmt.setString(2, user.getNama());
            stmt.setString(3, user.getTempatLahir());
            stmt.setString(4, user.getTanggalLahir());
            stmt.setString(5, user.getJenisKelamin());
            stmt.setString(6, user.getGolonganDarah());
            stmt.setString(7, user.getAlamat());
            stmt.setString(8, user.getRtRw());
            stmt.setString(9, user.getKelDesa());
            stmt.setString(10, user.getKecamatan());
            stmt.setString(11, user.getAgama());
            stmt.setString(12, user.getStatusPerkawinan());
            stmt.setString(13, user.getPekerjaan());
            stmt.setString(14, user.getKewarganegaraan());
            stmt.setString(15, user.getBerlakuHingga());
            stmt.setString(16, user.getKotaPembuatan());
            stmt.setString(17, user.getTanggalPembuatan());
            stmt.setString(18, user.getFoto());
            stmt.setString(19, user.getTandaTangan());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
    }

    // UPDATE
    public boolean updateUser (User user) {
        conn.connect();
        String query = "UPDATE users SET nama=?, tempat_lahir=?, tanggal_lahir=?, jenis_kelamin=?, golongan_darah=?, alamat=?, rt_rw=?, kel_desa=?, kecamatan=?, agama=?, status_perkawinan=?, pekerjaan=?, kewarganegaraan=?, berlaku_hingga=?, kota_pembuatan=?, tanggal_pembuatan=?, foto=?, tanda_tangan=? WHERE nik=?";
        try (PreparedStatement stmt = conn.con.prepareStatement(query)) {
            stmt.setString(1, user.getNama());
            stmt.setString(2, user.getTempatLahir());
            stmt.setString(3, user.getTanggalLahir());
            stmt.setString(4, user.getJenisKelamin());
            stmt.setString(5, user.getGolonganDarah());
            stmt.setString(6, user.getAlamat());
            stmt.setString(7, user.getRtRw());
            stmt.setString(8, user.getKelDesa());
            stmt.setString(9, user.getKecamatan());
            stmt.setString(10, user.getAgama());
            stmt.setString(11, user.getStatusPerkawinan());
            stmt.setString(12, user.getPekerjaan());
            stmt.setString(13, user.getKewarganegaraan());
            stmt.setString(14, user.getBerlakuHingga());
            stmt.setString(15, user.getKotaPembuatan());
            stmt.setString(16, user.getTanggalPembuatan());
            stmt.setString(17, user.getFoto());
            stmt.setString(18, user.getTandaTangan());
            stmt.setString(19, user.getNik());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
    }

    // DELETE
    public boolean deleteUser (String nik) {
        conn.connect();
        String query = "DELETE FROM users WHERE nik=?";
        try (PreparedStatement stmt = conn.con.prepareStatement(query)) {
            stmt.setString(1, nik);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
    }
}