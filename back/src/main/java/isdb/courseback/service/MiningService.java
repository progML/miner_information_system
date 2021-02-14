package isdb.courseback.service;

import isdb.courseback.model.Mining;
import isdb.courseback.repository.MiningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiningService {

    private MiningRepository miningRepository;

    @Autowired
    public MiningService(MiningRepository miningRepository) {
        this.miningRepository = miningRepository;
    }

    public List<Mining> findAllMinings(int brigadeId) {
        return this.miningRepository.findAllByBrigadeId(brigadeId);
    }

    public void addMining(Mining mining) {
        miningRepository.save(mining);
    }

}
