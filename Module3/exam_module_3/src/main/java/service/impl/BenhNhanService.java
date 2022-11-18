package service.impl;

import model.BenhNhan;
import repository.IBenhNhanRepository;
import repository.impl.BenhNhanRepository;
import service.IBenhAnService;
import service.IBenhNhanService;

import java.util.List;

public class BenhNhanService implements IBenhNhanService {
    private IBenhNhanRepository benhNhanRepository = new BenhNhanRepository();
    @Override
    public List<BenhNhan> showList() {
        return benhNhanRepository.showList();
    }
}
