package repository.impl;

import model.BenhAn;
import repository.BaseRepository;
import repository.IBenhAnRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BenhAnRepository implements IBenhAnRepository {
    private static final String DANH_SACH_BENH_AN = "select * from benh_an";
    @Override
    public List<BenhAn> showList() {
        List<BenhAn> benhAnList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DANH_SACH_BENH_AN);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String idBenhAn = resultSet.getString("id_benh_an");
                String tenBenhAn = resultSet.getString("ten_benh_an");
                int idBenhNhan = resultSet.getInt("id_benh_nhan");
                Date ngayNhapVien = resultSet.getDate("ngay_nhap_vien");
                Date ngayRaVien = resultSet.getDate("ngay_ra_vien");
                String lyDoNhapVien = resultSet.getString("ly_do_nhap_vien");
                benhAnList.add(new BenhAn(idBenhAn, tenBenhAn, idBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhAnList;
    }

    @Override
    public boolean update(BenhAn benhAn) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
