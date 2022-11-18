package repository.impl;

import model.BenhNhan;
import repository.BaseRepository;
import repository.IBenhNhanRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepository implements IBenhNhanRepository {
    private static final String DANH_SACH_BENH_NHAN = "select * from benh_nhan";
    @Override
    public List<BenhNhan> showList() {
        List<BenhNhan> benhNhanList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DANH_SACH_BENH_NHAN);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String idBenhNhan = resultSet.getString("id_benh_nhan");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                benhNhanList.add(new BenhNhan(id,idBenhNhan, tenBenhNhan));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhNhanList;
    }
}
