package service;

import model.BenhAn;

import java.util.List;

public interface IBenhAnService {
    List<BenhAn> showList();

    boolean update(BenhAn benhAn);

    boolean delete(String id);
}
