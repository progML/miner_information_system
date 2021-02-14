package isdb.courseback.service;

import isdb.courseback.dto.MinerPartResponse;
import isdb.courseback.model.BrigadeRecord;
import isdb.courseback.model.Miner;
import isdb.courseback.repository.BrigadeRecordRepository;
import isdb.courseback.repository.DeliveryAutoRepository;
import isdb.courseback.repository.DeliveryEquipmentRepository;
import isdb.courseback.repository.MinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MinerService {

    private MinerRepository minerRepository;
    private BrigadeRecordRepository brigadeRecordRepository;
    private DeliveryEquipmentRepository deliveryEquipmentRepository;
    private DeliveryAutoRepository deliveryAutoRepository;

    @Autowired
    public MinerService(MinerRepository minerRepository, BrigadeRecordRepository brigadeRecordRepository,
                        DeliveryEquipmentRepository deliveryEquipmentRepository,
                        DeliveryAutoRepository deliveryAutoRepository) {
        this.minerRepository = minerRepository;
        this.brigadeRecordRepository = brigadeRecordRepository;
        this.deliveryEquipmentRepository = deliveryEquipmentRepository;
        this.deliveryAutoRepository = deliveryAutoRepository;
    }

    public Optional<Miner> showMiner(int id) {
        return minerRepository.findByMinerId(id);
    }

    public List<MinerPartResponse> showMinerDeliveryByBrigadeId(int brigadeId) {
        List<Integer> deliveryMinerId = deliveryEquipmentRepository.findAllMinerId();
        deliveryMinerId.addAll(deliveryAutoRepository.findAllMinerId());
        List<BrigadeRecord> brigadeRecords = deliveryMinerId.isEmpty() ? brigadeRecordRepository.findAllByBrigadeId(brigadeId) :
                brigadeRecordRepository.findAllByBrigadeIdAndMinerIdNotIn(brigadeId, deliveryMinerId);
        System.out.println(brigadeRecords);

        List<MinerPartResponse> minerPartResponseList = new ArrayList<MinerPartResponse>();
        for (BrigadeRecord brigadeRec:
             brigadeRecords)
        {
            minerPartResponseList.add(MinerPartResponse.builder().
                    minerId(brigadeRec.getMinerId())
                    .name(minerRepository.findByMinerId(brigadeRec.getMinerId()).map(Miner::getMinerName).orElse(""))
                    .part(brigadeRec.getPart())
                    .build());
        }
        return minerPartResponseList;
    }


}
