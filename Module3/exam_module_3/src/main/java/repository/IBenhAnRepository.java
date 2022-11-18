package repository;

import model.BenhAn;

import java.util.List;

public interface IBenhAnRepository {
    List<BenhAn> showList();

    boolean update(BenhAn benhAn);

    boolean delete(String id);
}
