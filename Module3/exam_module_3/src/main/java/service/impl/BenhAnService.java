package service.impl;

import model.BenhAn;
import repository.IBenhAnRepository;
import repository.impl.BenhAnRepository;
import service.IBenhAnService;

import java.util.List;

public class BenhAnService implements IBenhAnService {
    private IBenhAnRepository benhAnRepository = new BenhAnRepository();
    @Override
    public List<BenhAn> showList() {
        return benhAnRepository.showList();
    }

    @Override
    public boolean update(BenhAn benhAn) {
        return benhAnRepository.update(benhAn);
    }

    @Override
    public boolean delete(String id) {
        return benhAnRepository.delete(id);
    }
}
