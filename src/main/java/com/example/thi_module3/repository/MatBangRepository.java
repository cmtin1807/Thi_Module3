package com.example.thi_module3.repository;

import com.example.thi_module3.model.MatBang;
import com.example.thi_module3.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MatBangRepository implements IGenerateRepository<MatBang> {
    private static final String SELECT_ALL_MATBANG = "SELECT * FROM mat_bang";
    private static final String INSERT_MATBANG_SQL = "INSERT INTO mat_bang (ma_mb, dien_tich, trang_thai, tang, loai_vp, mo_ta, gia, ngay_bat_dau, ngay_ket_thuc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_MATBANG_BY_ID = "SELECT * FROM mat_bang WHERE id_mb = ?";
    private static final String UPDATE_MATBANG_SQL = "UPDATE mat_bang SET ma_mb = ?, dien_tich = ?, trang_thai = ?, tang = ?, loai_vp = ?, mo_ta = ?, gia = ?, ngay_bat_dau = ?, ngay_ket_thuc = ? WHERE id_mb = ?";
    private static final String DELETE_MATBANG_SQL = "DELETE FROM mat_bang WHERE id_mb = ?";
    private static final String SEARCH_MATBANG_BY_LOAI_VP = "SELECT * FROM mat_bang WHERE loai_vp = ?";
    private static final String SEARCH_MATBANG_BY_TANG = "SELECT * FROM mat_bang WHERE tang = ?";
    public List<MatBang> findByTang(int tang) {
        List<MatBang> list = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_MATBANG_BY_TANG)) {
            preparedStatement.setInt(1, tang);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MatBang matBang = new MatBang();
                matBang.setId(resultSet.getInt("id_mb"));
                matBang.setMaMb(resultSet.getString("ma_mb"));
                matBang.setDienTich(resultSet.getInt("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiVp(resultSet.getString("loai_vp"));
                matBang.setMoTa(resultSet.getString("mo_ta"));
                matBang.setGia(resultSet.getInt("gia"));
                matBang.setNgayBatDau(resultSet.getDate("ngay_bat_dau"));
                matBang.setNgayKetThuc(resultSet.getDate("ngay_ket_thuc"));
                matBang.setTrangThai(resultSet.getString("trang_thai"));
                list.add(matBang);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error searching MatBang by tang", e);
        }
        return list;
    }
    public List<MatBang> findByLoaiVp(String loaiVp) {
        List<MatBang> list = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_MATBANG_BY_LOAI_VP)) {
            preparedStatement.setString(1, loaiVp);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MatBang matBang = new MatBang();
                matBang.setId(resultSet.getInt("id_mb"));
                matBang.setMaMb(resultSet.getString("ma_mb"));
                matBang.setDienTich(resultSet.getInt("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiVp(resultSet.getString("loai_vp"));
                matBang.setMoTa(resultSet.getString("mo_ta"));
                matBang.setGia(resultSet.getInt("gia"));
                matBang.setNgayBatDau(resultSet.getDate("ngay_bat_dau"));
                matBang.setNgayKetThuc(resultSet.getDate("ngay_ket_thuc"));
                matBang.setTrangThai(resultSet.getString("trang_thai"));
                list.add(matBang);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error searching MatBang by loai_vp", e);
        }
        return list;
    }
    @Override
    public List<MatBang> findAll() {
        List<MatBang> list = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MATBANG)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MatBang matBang = new MatBang();
                matBang.setId(resultSet.getInt("id_mb"));
                matBang.setMaMb(resultSet.getString("ma_mb"));
                matBang.setDienTich(resultSet.getInt("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiVp(resultSet.getString("loai_vp"));
                matBang.setMoTa(resultSet.getString("mo_ta"));
                matBang.setGia(resultSet.getInt("gia"));
                matBang.setNgayBatDau(resultSet.getDate("ngay_bat_dau"));
                matBang.setNgayKetThuc(resultSet.getDate("ngay_ket_thuc"));
                matBang.setTrangThai(resultSet.getString("trang_thai"));
                list.add(matBang);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all MatBang", e);
        }
        return list;
    }

    @Override
    public MatBang findById(int id) {
        MatBang matBang = null;
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MATBANG_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                matBang = new MatBang();
                matBang.setId(resultSet.getInt("id_mb"));
                matBang.setMaMb(resultSet.getString("ma_mb"));
                matBang.setDienTich(resultSet.getInt("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiVp(resultSet.getString("loai_vp"));
                matBang.setMoTa(resultSet.getString("mo_ta"));
                matBang.setGia(resultSet.getInt("gia"));
                matBang.setNgayBatDau(resultSet.getDate("ngay_bat_dau"));
                matBang.setNgayKetThuc(resultSet.getDate("ngay_ket_thuc"));
                matBang.setTrangThai(resultSet.getString("trang_thai"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving MatBang by ID", e);
        }
        return matBang;
    }

    @Override
    public void save(MatBang matBang) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MATBANG_SQL)) {
            preparedStatement.setString(1, matBang.getMaMb());
            preparedStatement.setInt(2, matBang.getDienTich());
            preparedStatement.setString(3, matBang.getTrangThai());
            preparedStatement.setInt(4, matBang.getTang());
            preparedStatement.setString(5, matBang.getLoaiVp());
            preparedStatement.setString(6, matBang.getMoTa());
            preparedStatement.setInt(7, matBang.getGia());
            preparedStatement.setDate(8, new java.sql.Date(matBang.getNgayBatDau().getTime()));
            preparedStatement.setDate(9, new java.sql.Date(matBang.getNgayKetThuc().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving MatBang", e);
        }
    }

    @Override
    public void update(int id, MatBang matBang) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MATBANG_SQL)) {
            preparedStatement.setString(1, matBang.getMaMb());
            preparedStatement.setInt(2, matBang.getDienTich());
            preparedStatement.setString(3, matBang.getTrangThai());
            preparedStatement.setInt(4, matBang.getTang());
            preparedStatement.setString(5, matBang.getLoaiVp());
            preparedStatement.setString(6, matBang.getMoTa());
            preparedStatement.setInt(7, matBang.getGia());
            preparedStatement.setDate(8, new java.sql.Date(matBang.getNgayBatDau().getTime()));
            preparedStatement.setDate(9, new java.sql.Date(matBang.getNgayKetThuc().getTime()));
            preparedStatement.setInt(10, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating MatBang", e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MATBANG_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting MatBang", e);
        }
    }
}
